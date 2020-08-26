package com.github.mrglassdanny.mocalanguageserver.providers;

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
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.codehaus.groovy.ast.ASTNode;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

public class DefinitionProvider {

    public static CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> provideDefinition(
            TextDocumentIdentifier textDocument, Position position, String textDocumentContents,
            MocaCompiler mocaCompiler) {

        // Analyze context id for position.
        MocaLanguageContext ctx = mocaCompiler.getMocaLanguageContextFromPosition(position);

        switch (ctx.id) {
            case Moca:

                // For hover, we need to make sure the moca compiliation result we are
                // looking at has no errors.
                MocaCompilationResult mocaCompilationResult = mocaCompiler.currentCompilationResult;
                if (mocaCompilationResult.hasMocaErrors()) {
                    mocaCompilationResult = mocaCompiler.lastSuccessfulCompilationResult;
                }

                if (mocaCompilationResult == null) {
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                String mocaWord = Positions.getWordAtPosition(textDocumentContents, position).toLowerCase();

                if (mocaWord != null) {
                    mocaWord = mocaWord.toLowerCase();

                    // Get current moca token at position.
                    org.antlr.v4.runtime.Token curMocaToken = mocaCompiler.getMocaTokenAtPosition(textDocumentContents,
                            position);

                    // Get command unit current moca token is in.
                    String verbNounClause = null;
                    for (Map.Entry<String, ArrayList<org.antlr.v4.runtime.Token>> entry : mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                            .entrySet()) {

                        // Checking for begin/end match since token objects parsed and lexed will not be
                        // the same objects.
                        for (org.antlr.v4.runtime.Token verbNounClauseToken : entry.getValue()) {
                            if (verbNounClauseToken.getStartIndex() == curMocaToken.getStartIndex()
                                    // No need to adjust stop index here!
                                    && verbNounClauseToken.getStopIndex() == curMocaToken.getStopIndex()
                                    && verbNounClauseToken.getType() == curMocaToken.getType()) {

                                verbNounClause = entry.getKey();

                                ArrayList<MocaCommand> mcmds = MocaLanguageServer.currentMocaConnection.cache.commandRepository.commands
                                        .get(verbNounClause);
                                if (mcmds != null) {

                                    ArrayList<Location> locations = new ArrayList<>();

                                    // For override mcmd support, let's go ahead and load all local syntax levels.
                                    for (MocaCommand mcmd : mcmds) {
                                        // Before we go any further, make sure command is local syntax.
                                        if (mcmd.type.compareToIgnoreCase(MocaCommand.TYPE_LOCAL_SYNTAX) == 0) {
                                            try {

                                                String mcmdFileName = MocaLanguageServer.globalStoragePath
                                                        + "\\command_lookup\\"
                                                        + (mcmd.cmplvl + "-" + mcmd.command).replace(" ", "_")
                                                        + ".msql.readonly";
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
            case Sql:
                return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
            case Groovy:

                GroovyCompilationResult groovyCompilationResult = mocaCompiler.currentCompilationResult.groovyCompilationResults
                        .get(ctx.rangeIdx);

                Range groovyScriptRange = mocaCompiler.groovyRanges.get(ctx.rangeIdx);

                if (groovyCompilationResult.astVisitor == null) {
                    // This shouldn't happen, but let's avoid an exception if something
                    // goes terribly wrong.
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                URI uri = URI.create(textDocument.getUri());

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                        position.getCharacter(), groovyScriptRange);

                ASTNode definitionNode = GroovyASTUtils.getDefinition(offsetNode, false,
                        groovyCompilationResult.astVisitor);

                if (definitionNode == null || definitionNode.getLineNumber() == -1
                        || definitionNode.getColumnNumber() == -1) {
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                Location location = new Location(uri.toString(),
                        GroovyLanguageUtils.astNodeToRange(definitionNode, groovyScriptRange));

                return CompletableFuture.completedFuture(Either.forLeft(Collections.singletonList(location)));
        }

        return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));

    }
}