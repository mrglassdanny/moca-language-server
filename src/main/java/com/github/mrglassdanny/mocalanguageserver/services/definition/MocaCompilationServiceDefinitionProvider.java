package com.github.mrglassdanny.mocalanguageserver.services.definition;

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
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCache;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

import org.codehaus.groovy.ast.ASTNode;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

public class MocaCompilationServiceDefinitionProvider {

    public static CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> provideDefinition(
            URI uri, Position position) {

        // Analyze context id for position.
        MocaLanguageContext mocaLanguageContext = MocaLanguageUtils.getMocaLanguageContextFromPosition(position,
                MocaServices.mocaCompilationResult);

        switch (mocaLanguageContext.id) {
            case Moca:

                if (MocaServices.mocaCompilationResult == null) {
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
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

                                ArrayList<MocaCommand> mcmds = MocaCache.getGlobalMocaCache().commands
                                        .get(verbNounClause.toString());
                                if (mcmds != null) {

                                    ArrayList<Location> locations = new ArrayList<>();

                                    // For override mcmd support, let's go ahead and load all local syntax levels.
                                    for (MocaCommand mcmd : mcmds) {
                                        // Before we go any further, make sure command is local syntax.
                                        if (mcmd.type.compareToIgnoreCase(MocaCommand.TYPE_LOCAL_SYNTAX) == 0) {
                                            try {

                                                String mcmdFileName = MocaLanguageServer.globalStoragePath
                                                        + "\\command-lookup\\"
                                                        + (mcmd.cmplvl + "-" + mcmd.command).replace(" ", "_")
                                                        + ".moca.readonly";
                                                File mcmdFile = new File(mcmdFileName);
                                                URI mcmdFileUri = mcmdFile.toURI();
                                                BufferedWriter mcmdBufferedWriter = new BufferedWriter(
                                                        new FileWriter(mcmdFile));
                                                mcmdBufferedWriter.write(mcmd.syntax);
                                                mcmdBufferedWriter.close();

                                                Position startPos = new Position(0, 0);
                                                Location location = new Location(mcmdFileUri.toString(),
                                                        new Range(startPos, startPos));

                                                locations.add(location);

                                            } catch (IOException ioException) {
                                                return CompletableFuture
                                                        .completedFuture(Either.forLeft(Collections.emptyList()));
                                            }
                                        }
                                    }

                                    return CompletableFuture.completedFuture(Either.forLeft(locations));
                                }
                            }
                        }
                    }
                }
                return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
            case MocaSql:
                return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
            case Groovy:

                GroovyCompilationResult groovyCompilationResult = MocaServices.mocaCompilationResult.groovyCompilationResults
                        .get(mocaLanguageContext.compilationResultIdx);

                if (groovyCompilationResult.astVisitor == null) {
                    // This shouldn't happen, but let's avoid an exception if something
                    // goes terribly wrong.
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                // Catching NoClassDefFoundError -- this isn't really best practice, but it
                // doesn't hurt anything and I would rather give the user a more concise error
                // message than what is thrown without this try/catch.
                try {
                    ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                            position.getCharacter(), groovyCompilationResult.range);

                    ASTNode definitionNode = GroovyASTUtils.getDefinition(offsetNode, false,
                            groovyCompilationResult.astVisitor);

                    if (definitionNode == null || definitionNode.getLineNumber() == -1
                            || definitionNode.getColumnNumber() == -1) {
                        return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                    }

                    Location location = new Location(uri.toString(),
                            GroovyLanguageUtils.astNodeToRange(definitionNode, groovyCompilationResult.range));

                    return CompletableFuture.completedFuture(Either.forLeft(Collections.singletonList(location)));
                } catch (NoClassDefFoundError noClassDefFoundError) {
                    MocaServices.logErrorToLanguageClient(String.format("Class '%s' not linked in groovyclasspath",
                            noClassDefFoundError.getMessage()));

                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }
        }

        return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));

    }
}
