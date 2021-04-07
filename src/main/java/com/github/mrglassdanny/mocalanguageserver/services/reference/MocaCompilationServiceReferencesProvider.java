package com.github.mrglassdanny.mocalanguageserver.services.reference;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaTrigger;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;
import com.github.mrglassdanny.mocalanguageserver.util.os.OSUtils;

import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaCompilationServiceReferencesProvider {

    public static CompletableFuture<List<? extends Location>> provideReferences(Position position) {

        // Analyze context id for position.
        MocaLanguageContext mocaLanguageContext = MocaLanguageUtils.getMocaLanguageContextFromPosition(position,
                MocaServices.mocaCompilationResult);

        switch (mocaLanguageContext.id) {
            case Moca:

                if (MocaServices.mocaCompilationResult == null) {
                    return CompletableFuture.completedFuture(Collections.emptyList());
                }

                String mocaWord = PositionUtils.getWordAtPosition(MocaServices.mocaCompilationResult.script, position,
                        "([a-zA-Z_0-9.])");

                if (mocaWord != null) {

                    mocaWord = mocaWord.toLowerCase();

                    // Get current moca token at position.
                    org.antlr.v4.runtime.Token curMocaToken = MocaLanguageUtils.getMocaTokenAtPosition(position,
                            MocaServices.mocaCompilationResult);

                    // Get verb noun clause current moca token is in.
                    StringBuilder verbNounClause = null;
                    for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry : MocaServices.mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                            .entrySet()) {

                        // Checking for begin/end match since token objects parsed and lexed will not be
                        // the same objects.
                        for (org.antlr.v4.runtime.Token verbNounClauseToken : entry.getValue()) {
                            if (verbNounClauseToken.getStartIndex() == curMocaToken.getStartIndex()
                                    // No need to adjust stop index here!
                                    && verbNounClauseToken.getStopIndex() == curMocaToken.getStopIndex()
                                    && verbNounClauseToken.getType() == curMocaToken.getType()) {

                                verbNounClause = entry.getKey();

                                ArrayList<Location> locations = new ArrayList<>();

                                // Loop through all moca commands in cache and check syntax for reference to
                                // verb noun clause.
                                for (ArrayList<MocaCommand> mcmds : MocaServices.mocaCache.commands.values()) {
                                    for (MocaCommand mcmd : mcmds) {
                                        if (mcmd.type.compareToIgnoreCase(MocaCommand.TYPE_LOCAL_SYNTAX) == 0) {

                                            if (mcmd.syntax.contains(verbNounClause.toString())) {

                                                // If mcmd syntax contains verb noun clause, we need to validate actual
                                                // verb noun clause reference via moca parse tree listener.

                                                MocaParseTreeListener mocaParseTreeListener = MocaCompiler
                                                        .generateMocaParseTreeListener(mcmd.syntax);

                                                for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry2 : mocaParseTreeListener.verbNounClauses
                                                        .entrySet()) {

                                                    if (entry2.getKey().toString()
                                                            .compareToIgnoreCase(verbNounClause.toString()) == 0) {

                                                        // Actual reference found -- create file and add location to
                                                        // list.

                                                        try {
                                                            
                                                            String mcmdFileName = null;
                                                            if(OSUtils.isWindows()) {
                                                                mcmdFileName = MocaLanguageServer.globalStoragePath
                                                                    + "\\references\\"
                                                                    + (mcmd.cmplvl + "-" + mcmd.command).replace(" ",
                                                                            "_")
                                                                    + ".moca.readonly";
                                                            } else {
                                                                mcmdFileName = MocaLanguageServer.globalStoragePath
                                                                    + "/references/"
                                                                    + (mcmd.cmplvl + "-" + mcmd.command).replace(" ",
                                                                            "_")
                                                                    + ".moca.readonly";
                                                            }


                                                            File mcmdFile = new File(mcmdFileName);
                                                            URI mcmdFileUri = mcmdFile.toURI();
                                                            BufferedWriter mcmdBufferedWriter = new BufferedWriter(
                                                                    new FileWriter(mcmdFile));
                                                            mcmdBufferedWriter.write(mcmd.syntax);
                                                            mcmdBufferedWriter.close();

                                                            Token startToken = entry2.getValue().get(0);
                                                            Token endToken = entry2.getValue()
                                                                    .get(entry2.getValue().size() - 1);

                                                            Position startPos = new Position(startToken.getLine() - 1,
                                                                    startToken.getCharPositionInLine());

                                                            Position endPos = new Position(endToken.getLine() - 1,
                                                                    endToken.getCharPositionInLine()
                                                                            + endToken.getText().length());

                                                            Location location = new Location(mcmdFileUri.toString(),
                                                                    new Range(startPos, endPos));

                                                            locations.add(location);

                                                        } catch (IOException ioException) {
                                                            return CompletableFuture
                                                                    .completedFuture(Collections.emptyList());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                // Loop through all moca triggers in cache and check syntax for reference to
                                // verb noun clause.
                                for (ArrayList<MocaTrigger> mtrgs : MocaServices.mocaCache.triggers.values()) {
                                    for (MocaTrigger mtrg : mtrgs) {
                                        if (mtrg.syntax.contains(verbNounClause.toString())) {

                                            // If mtrg syntax contains verb noun clause, we need to validate actual
                                            // verb noun clause reference via moca parse tree listener.

                                            MocaParseTreeListener mocaParseTreeListener = MocaCompiler
                                                    .generateMocaParseTreeListener(mtrg.syntax);

                                            for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry2 : mocaParseTreeListener.verbNounClauses
                                                    .entrySet()) {

                                                if (entry2.getKey().toString()
                                                        .compareToIgnoreCase(verbNounClause.toString()) == 0) {

                                                    // Actual reference found -- create file and add location to
                                                    // list.

                                                    try {
                                                        String mtrgFileName = null;
                                                        if(OSUtils.isWindows()) {
                                                            mtrgFileName = MocaLanguageServer.globalStoragePath
                                                                + "\\references\\"
                                                                + (mtrg.command + "-" + mtrg.name).replace(" ", "_")
                                                                + ".moca.readonly";
                                                        } else {
                                                            mtrgFileName = MocaLanguageServer.globalStoragePath
                                                                + "/references/"
                                                                + (mtrg.command + "-" + mtrg.name).replace(" ", "_")
                                                                + ".moca.readonly";
                                                        }

                                                        File mtrgFile = new File(mtrgFileName);
                                                        URI mtrgFileUri = mtrgFile.toURI();
                                                        BufferedWriter mtrgBufferedWriter = new BufferedWriter(
                                                                new FileWriter(mtrgFile));
                                                        mtrgBufferedWriter.write(mtrg.syntax);
                                                        mtrgBufferedWriter.close();

                                                        Token startToken = entry2.getValue().get(0);
                                                        Token endToken = entry2.getValue()
                                                                .get(entry2.getValue().size() - 1);

                                                        Position startPos = new Position(startToken.getLine() - 1,
                                                                startToken.getCharPositionInLine());

                                                        Position endPos = new Position(endToken.getLine() - 1,
                                                                endToken.getCharPositionInLine()
                                                                        + endToken.getText().length());

                                                        Location location = new Location(mtrgFileUri.toString(),
                                                                new Range(startPos, endPos));

                                                        locations.add(location);

                                                    } catch (IOException ioException) {
                                                        return CompletableFuture
                                                                .completedFuture(Collections.emptyList());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                return CompletableFuture.completedFuture(locations);
                            }
                        }
                    }
                }
                return CompletableFuture.completedFuture(Collections.emptyList());
            case MocaSql:
                return CompletableFuture.completedFuture(Collections.emptyList());
            case Groovy:

                return CompletableFuture.completedFuture(Collections.emptyList());
        }

        return CompletableFuture.completedFuture(Collections.emptyList());

    }
}
