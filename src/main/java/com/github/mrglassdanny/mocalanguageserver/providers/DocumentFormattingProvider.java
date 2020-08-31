package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.antlr.codebuff.misc.LangDescriptor;
import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;

public class DocumentFormattingProvider {

        public static CompletableFuture<List<? extends TextEdit>> provideDocumentFormatting(
                        DocumentFormattingParams params, String textDocumentContents, MocaCompiler mocaCompiler) {

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

        // Range formatting will be exact same as doc formatting.
        public static CompletableFuture<List<? extends TextEdit>> provideDocumentRangeFormatting(
                        DocumentRangeFormattingParams params, String textDocumentContents, MocaCompiler mocaCompiler) {

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

                                        sqlText = org.antlr.codebuff.Tool.format2(new LangDescriptor("MocaSql",
                                                        "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\corpus\\mocasql",
                                                        ".*\\.sql", MocaSqlLexer.class, MocaSqlParser.class,
                                                        "moca_sql_script", 2, MocaSqlLexer.LINE_COMMENT),
                                                        origSqlScript);

                                } catch (Exception e) {
                                        MocaLanguageServer.languageClient
                                                        .logMessage(new MessageParams(MessageType.Error, e.toString()));
                                }

                                if (sqlText != null) {
                                        nxtSrc = nxtSrc.replace(mocaToken.getText(), "[" + sqlText + "]");
                                }

                        } else if (mocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING) {

                        }
                }

                String finalText = null;

                try {

                        finalText = org.antlr.codebuff.Tool.format2(new LangDescriptor("Moca",
                                        "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\corpus\\moca",
                                        ".*\\.msql", MocaLexer.class, MocaParser.class, "moca_script", 2,
                                        MocaLexer.BLOCK_COMMENT), nxtSrc);

                } catch (Exception e) {
                        MocaLanguageServer.languageClient
                                        .logMessage(new MessageParams(MessageType.Error, e.toString()));
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