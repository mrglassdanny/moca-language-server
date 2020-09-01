package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.format.MocaFormatter;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.format.MocaSqlFormatter;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;

public class DocumentOnTypeFormattingProvider {

        public static CompletableFuture<List<? extends TextEdit>> provideDocumentOnTypeFormatting(
                        DocumentOnTypeFormattingParams params, String textDocumentContents, MocaCompiler mocaCompiler) {

                // Check to see if file extension is marked as read only. If so, do not publish
                // any diagnostics.
                // This will be the case for any files created by command lookup functionality
                // in the client.
                String uriStr = params.getTextDocument().getUri();
                String uriExtStr = uriStr.substring(uriStr.lastIndexOf("."));
                if (uriExtStr.compareToIgnoreCase(".readonly") == 0) {
                        return CompletableFuture.completedFuture(new ArrayList<>());
                }

                return CompletableFuture.completedFuture(processFormatting(textDocumentContents, mocaCompiler));

        }

        public static ArrayList<TextEdit> processFormatting(String src, MocaCompiler mocaCompiler) {
                ArrayList<TextEdit> edits = new ArrayList<>();

                String nxtSrc = src;

                // Process sql & groovy:
                for (Token mocaToken : mocaCompiler.mocaTokens) {
                        if (mocaToken.getType() == MocaLexer.SINGLE_BRACKET_STRING) {

                                String origSqlScript = mocaToken.getText();
                                origSqlScript = origSqlScript.substring(1, origSqlScript.length() - 1);

                                String sqlText = null;
                                try {

                                        sqlText = org.antlr.codebuff.Tool.formatForMocaLanguageServer(
                                                        MocaSqlFormatter.mocaSqlLangDescriptor, origSqlScript,
                                                        MocaSqlFormatter.mocaSqlCorpus);

                                } catch (Exception e) {
                                        // Do nothing...
                                }

                                if (sqlText != null) {
                                        // In order for the entire sql script to be indented correctly after formatting,
                                        // we need to get the char num from the single bracket string token and add that
                                        // amount spaces/tabs to each newline in formatted sql script.
                                        String indention = "";
                                        for (int i = 0; i < mocaToken.getCharPositionInLine(); i++) {
                                                indention += " ";
                                        }

                                        sqlText = sqlText.replace("\n", "\n" + indention);

                                        nxtSrc = nxtSrc.replace(mocaToken.getText(), "[" + sqlText + "]");
                                }

                        } else if (mocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING) {

                        }
                }

                String finalText = null;

                try {

                        finalText = org.antlr.codebuff.Tool.formatForMocaLanguageServer(
                                        MocaFormatter.mocaLangDescriptor, nxtSrc, MocaFormatter.mocaCorpus);

                } catch (Exception e) {
                        // Do nothing...
                }

                if (finalText != null) {
                        edits.add(new TextEdit(new Range(new Position(0, 0), Positions.getPosition(src, src.length())),
                                        finalText));
                } else {
                        edits.add(new TextEdit(new Range(new Position(0, 0), Positions.getPosition(src, src.length())),
                                        nxtSrc));
                }
                return edits;
        }

}