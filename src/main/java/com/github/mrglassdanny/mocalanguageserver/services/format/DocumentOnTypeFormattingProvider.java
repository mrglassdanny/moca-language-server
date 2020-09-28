package com.github.mrglassdanny.mocalanguageserver.services.format;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;

import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.TextEdit;

public class DocumentOnTypeFormattingProvider {

        public static CompletableFuture<List<? extends TextEdit>> provideDocumentOnTypeFormatting(
                        DocumentOnTypeFormattingParams params) {

                // Check to see if file extension is marked as read only. If so, do not attempt
                // to format. This will be the case for any files created by command lookup
                // functionality in the client.
                String uriExtStr = MocaServices.mocaCompilationResult.uriStr
                                .substring(MocaServices.mocaCompilationResult.uriStr.lastIndexOf("."));
                if (uriExtStr.compareToIgnoreCase(".readonly") == 0) {
                        return CompletableFuture.completedFuture(new ArrayList<>());
                }

                return CompletableFuture.completedFuture(DocumentFormattingProvider.processDocumentFormatting());
        }

}