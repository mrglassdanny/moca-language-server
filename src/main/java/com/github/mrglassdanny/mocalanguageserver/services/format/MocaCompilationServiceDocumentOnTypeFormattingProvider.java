package com.github.mrglassdanny.mocalanguageserver.services.format;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.format.MocaFormatter;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;

public class MocaCompilationServiceDocumentOnTypeFormattingProvider {

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

                return CompletableFuture.completedFuture(MocaCompilationServiceDocumentOnTypeFormattingProvider
                                .processDocumentOnTypeFormatting(params.getPosition()));
        }

        public static ArrayList<TextEdit> processDocumentOnTypeFormatting(Position changePosition) {
                ArrayList<TextEdit> edits = new ArrayList<>();

                String formattedMocaScript = MocaFormatter.formatChange(MocaServices.mocaCompilationResult,
                                changePosition);

                // If old script equals new script, then nothing got formatted and we can just
                // return an empty list.
                if (MocaServices.mocaCompilationResult.script.equals(formattedMocaScript)) {
                        return edits;
                }

                // Add to text doc edits and return!
                edits.add(new TextEdit(
                                new Range(new Position(0, 0),
                                                PositionUtils.getPosition(MocaServices.mocaCompilationResult.script,
                                                                MocaServices.mocaCompilationResult.script.length())),
                                formattedMocaScript));
                return edits;
        }

}