package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

import org.antlr.codebuff.misc.LangDescriptor;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;

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

                try {
                        org.antlr.codebuff.Tool.format(new LangDescriptor("Moca",
                                        "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\corpus\\moca",
                                        ".*\\.msql", MocaLexer.class, MocaParser.class, "moca_script", 4,
                                        MocaLexer.BLOCK_COMMENT),
                                        "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\format-a.msql",
                                        "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\format-b.msql");

                } catch (Exception e) {
                        MocaLanguageServer.languageClient
                                        .logMessage(new MessageParams(MessageType.Error, e.toString()));
                }

                return CompletableFuture.completedFuture(new ArrayList<>());

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

                return CompletableFuture.completedFuture(new ArrayList<>());
        }

}