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

            // Relative:
            MocaTraceOutline outline = mocaTraceOutliningResult.getOutline(frame.outlineId);
            if (outline == null) {
                return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
            }

            String relLogFileName = MocaLanguageServer.globalStoragePath + "\\trace\\"
                    + (mocaTraceOutliningResult.traceFileName + "_" + frame.outlineId) + ".log";
            File relLogFile = new File(relLogFileName);
            URI relLogFileUri = relLogFile.toURI();

            // Only write file if we havent already.
            if (!outline.hasWrittenRelative) {

                BufferedWriter writer = new BufferedWriter(new FileWriter(relLogFile));

                for (String line : outline.relativeTraceLines) {
                    writer.append(line + "\n");
                }

                writer.close();

                outline.hasWrittenRelative = true;
            }

            // -1 since lsp position line nums start at 0 and stack frame relative line nums
            // start at 1!
            Position relStartPos = new Position(frame.relativeLineNum - 1, 0);
            Position relEndPos = new Position(frame.relativeLineNum, 0);
            Location relLocation = new Location(relLogFileUri.toString(), new Range(relStartPos, relEndPos));
            locations.add(relLocation);

            // Absolute:
            String absLogFileName = MocaLanguageServer.globalStoragePath + "\\trace\\"
                    + (mocaTraceOutliningResult.traceFileName) + ".log";
            File absLogFile = new File(absLogFileName);
            URI absLogFileUri = absLogFile.toURI();

            // Only write file if we havent already.
            if (!mocaTraceOutliningResult.hasWrittenAbsolute) {

                BufferedWriter writer = new BufferedWriter(new FileWriter(absLogFile));

                for (String line : mocaTraceOutliningResult.absoluteTraceLines) {
                    writer.append(line + "\n");
                }

                writer.close();

                mocaTraceOutliningResult.hasWrittenAbsolute = true;
            }

            // -1 since lsp position line nums start at 0 and stack frame absolute line nums
            // start at 1!
            Position absStartPos = new Position(frame.absoluteLineNum - 1, 0);
            Position absEndPos = new Position(frame.absoluteLineNum, 0);
            Location absLocation = new Location(absLogFileUri.toString(), new Range(absStartPos, absEndPos));
            locations.add(absLocation);

        } catch (IOException ioException) {
            return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
        }

        return CompletableFuture.completedFuture(Either.forLeft(locations));

    }
}
