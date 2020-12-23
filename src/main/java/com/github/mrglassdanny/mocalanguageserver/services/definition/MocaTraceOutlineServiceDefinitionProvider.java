package com.github.mrglassdanny.mocalanguageserver.services.definition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutline;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutliningResult;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceStackFrame;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

public class MocaTraceOutlineServiceDefinitionProvider {

    public static CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> provideDefinition(
            String uriStr, URI uri, Position position) {

        MocaTraceOutliningResult mocaTraceOutliningResult = MocaServices.mocaTraceOutliningResultMap.get(uriStr);

        // Make sure we have a working trace outline result.
        if (mocaTraceOutliningResult == null) {
            return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
        }

        // +1 since lsp position lines start at 0!
        MocaTraceStackFrame frame = mocaTraceOutliningResult.actualLinesMap.get(position.getLine() + 1);

        if (frame == null) {
            return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
        }

        ArrayList<Location> locations = new ArrayList<>();

        try {

            if (mocaTraceOutliningResult.options.viewRelativeLog) {

                MocaTraceOutline outline = mocaTraceOutliningResult.getOutline(frame.outlineId);
                if (outline == null) {
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                String logFileName = MocaLanguageServer.globalStoragePath + "\\trace\\"
                        + (mocaTraceOutliningResult.traceFileName + "_" + frame.outlineId) + ".log";
                File logFile = new File(logFileName);
                URI logFileUri = logFile.toURI();

                if (!outline.hasWrittenRelative) {

                    BufferedWriter logFileBufferedWriter = new BufferedWriter(new FileWriter(logFile));

                    for (String line : outline.relativeTraceLines) {
                        logFileBufferedWriter.append(line + "\n");
                    }

                    logFileBufferedWriter.close();

                    outline.hasWrittenRelative = true;
                }

                // -1 since lsp position line nums start at 0 and stack frame relative line nums
                // start at 1!
                Position startPos = new Position(frame.relativeLineNum - 1, 0);
                Position endPos = new Position(frame.relativeLineNum, 0);
                Location location = new Location(logFileUri.toString(), new Range(startPos, endPos));
                locations.add(location);
            } else {

                String logFileName = MocaLanguageServer.globalStoragePath + "\\trace\\"
                        + (mocaTraceOutliningResult.traceFileName) + ".log";
                File logFile = new File(logFileName);
                URI logFileUri = logFile.toURI();

                if (!mocaTraceOutliningResult.hasWrittenAbsolute) {

                    BufferedWriter logFileBufferedWriter = new BufferedWriter(new FileWriter(logFile));

                    for (String line : mocaTraceOutliningResult.absoluteTraceLines) {
                        logFileBufferedWriter.append(line + "\n");
                    }

                    logFileBufferedWriter.close();

                    mocaTraceOutliningResult.hasWrittenAbsolute = true;
                }

                // -1 since lsp position line nums start at 0 and stack frame relative line nums
                // start at 1!
                Position startPos = new Position(frame.absoluteLineNum - 1, 0);
                Position endPos = new Position(frame.absoluteLineNum, 0);
                Location location = new Location(logFileUri.toString(), new Range(startPos, endPos));
                locations.add(location);
            }

        } catch (IOException ioException) {
            return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
        }

        return CompletableFuture.completedFuture(Either.forLeft(locations));

    }
}
