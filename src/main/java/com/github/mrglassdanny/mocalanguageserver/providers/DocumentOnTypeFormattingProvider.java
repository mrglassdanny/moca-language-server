package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;

import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.TextEdit;

public class DocumentOnTypeFormattingProvider {

        public static CompletableFuture<List<? extends TextEdit>> provideDocumentOnTypeFormatting(
                        DocumentOnTypeFormattingParams params, String textDocumentContents, MocaCompiler mocaCompiler) {

                // Check to see if file extension is marked as read only. If so, do not attempt
                // to format.
                // This will be the case for any files created by command lookup functionality
                // in the client.
                String uriStr = params.getTextDocument().getUri();
                String uriExtStr = uriStr.substring(uriStr.lastIndexOf("."));
                if (uriExtStr.compareToIgnoreCase(".readonly") == 0) {
                        return CompletableFuture.completedFuture(new ArrayList<>());
                }

                // If we are typing new line whitespace, do not attempt to format.
                if (params.getCh().contains("\n")) {
                        return CompletableFuture.completedFuture(new ArrayList<>());
                } else {
                        return CompletableFuture.completedFuture(DocumentFormattingProvider
                                        .processDocumentFormatting(textDocumentContents, mocaCompiler));
                }
        }

}