package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaCommandArgument;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaFunction;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaTrigger;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.Table;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.ast.GroovyASTNodeVisitor;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyNodeToStringUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.Variable;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.MarkupKind;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;

public class HoverProvider {

    public static CompletableFuture<Hover> provideHover(TextDocumentIdentifier textDocument, Position position,
            String textDocumentContents, MocaCompiler mocaCompiler) {

        Hover hover = new Hover();
        // Placeholder contents until we set due to analysis.
        hover.setContents(new MarkupContent(MarkupKind.PLAINTEXT, ""));

        // Analyze context id for position.
        MocaLanguageContext mocaLanguageContext = mocaCompiler.getMocaLanguageContextFromPosition(position);

        switch (mocaLanguageContext.id) {
            case Moca:

                // For hover, we need to make sure the moca compiliation result we are
                // looking at has no errors.
                MocaCompilationResult mocaCompilationResult = mocaCompiler.currentCompilationResult;

                if (mocaCompilationResult == null) {
                    return CompletableFuture.completedFuture(hover);
                }

                String mocaWord = Positions.getWordAtPosition(textDocumentContents, position);

                if (mocaWord != null) {

                    mocaWord = mocaWord.toLowerCase();

                    // First check if this is a moca function.
                    MocaFunction mocaFunction = MocaLanguageServer.currentMocaConnection.cache.mocaCache.functions
                            .get(mocaWord);
                    if (mocaFunction != null) {

                        // Build out function signature.
                        StringBuilder argBuf = new StringBuilder();
                        for (String argName : mocaFunction.argumentNames) {
                            if (argName.compareTo(MocaFunction.VARIABLE_LENGTH_ARGUMENT) == 0) {
                                argBuf.append("...");
                                argBuf.append(",");
                            } else {
                                argBuf.append(argName);
                                argBuf.append(",");
                            }
                        }

                        // Remove last comma from argument buffer.
                        if (argBuf.length() > 0) {
                            argBuf.deleteCharAt(argBuf.length() - 1);
                        }
                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN,
                                String.format("function **%s**\n\n*%s*\n\n```moca\n%s(%s)\n```", mocaFunction.name,
                                        mocaFunction.description, mocaFunction.name, argBuf.toString())));

                        return CompletableFuture.completedFuture(hover);
                    }

                    // Get current moca token at position.
                    org.antlr.v4.runtime.Token curMocaToken = mocaCompiler.getMocaTokenAtPosition(textDocumentContents,
                            position);

                    // Validate curMocaToken.
                    if (curMocaToken == null) {
                        return CompletableFuture.completedFuture(hover);
                    }

                    // Get verb noun clause current moca token is in.
                    StringBuilder verbNounClause = null;
                    for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry : mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                            .entrySet()) {

                        // Checking for begin/end match since token objects parsed and lexed will not be
                        // the same objects.
                        for (org.antlr.v4.runtime.Token verbNounClauseToken : entry.getValue()) {
                            if (verbNounClauseToken.getStartIndex() == curMocaToken.getStartIndex()
                                    // No need to adjust stop index here!
                                    && verbNounClauseToken.getStopIndex() == curMocaToken.getStopIndex()
                                    && verbNounClauseToken.getType() == curMocaToken.getType()) {

                                verbNounClause = entry.getKey();

                                ArrayList<MocaCommand> mcmds = MocaLanguageServer.currentMocaConnection.cache.mocaCache.commands
                                        .get(verbNounClause.toString());
                                if (mcmds != null) {
                                    String content = getMocaCommandContent(verbNounClause.toString(), mcmds);

                                    hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, content));
                                    return CompletableFuture.completedFuture(hover);
                                }
                            }
                        }
                    }

                }

                break;
            case MocaSql:

                // For hover, we need to make sure the moca sql compiliation result we are
                // looking at has no errors.
                MocaSqlCompilationResult mocaSqlCompilationResult = mocaCompiler.currentCompilationResult.mocaSqlCompilationResults
                        .get(mocaLanguageContext.rangeIdx);

                // Tables, views, aliases, and subqueries - oh my!
                String mocaSqlWord = Positions.getWordAtPosition(textDocumentContents, position);

                if (mocaSqlWord != null) {
                    // Convert to lowercase since repo is in lowercase.
                    mocaSqlWord = mocaSqlWord.toLowerCase();

                    // Check first to see if mocasql word is table/view in database.
                    Table table = MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.tables.get(mocaSqlWord);
                    if (table != null) {
                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN,
                                String.format("table **%s**\n\n%s", table.table_name,
                                        (table.description == null || table.description.isEmpty() ? ""
                                                : String.format("*%s*", table.description)))));
                        return CompletableFuture.completedFuture(hover);
                    }

                    Table view = MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.views.get(mocaSqlWord);
                    if (view != null) {
                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN,
                                String.format("view **%s**\n\n%s", view.table_name,
                                        (view.description == null || view.description.isEmpty() ? ""
                                                : String.format("*%s*", view.description)))));
                        return CompletableFuture.completedFuture(hover);
                    }

                    // If not, check aliased tables/views/subqueries.
                    if (mocaSqlCompilationResult != null && mocaSqlCompilationResult.mocaSqlParseTreeListener != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.aliasedTableNames != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.aliasedTableNames
                                    .containsKey(mocaSqlWord)) {
                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, String.format("alias for **%s**",
                                mocaSqlCompilationResult.mocaSqlParseTreeListener.aliasedTableNames.get(mocaSqlWord))));
                        return CompletableFuture.completedFuture(hover);
                    }
                    if (mocaSqlCompilationResult != null && mocaSqlCompilationResult.mocaSqlParseTreeListener != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries.containsKey(mocaSqlWord)) {
                        hover.setContents(
                                new MarkupContent(MarkupKind.MARKDOWN, String.format("subquery **%s**", mocaSqlWord)));
                        return CompletableFuture.completedFuture(hover);
                    }

                }

                break;
            case Groovy:

                GroovyCompilationResult groovyCompilationResult = mocaCompiler.currentCompilationResult.groovyCompilationResults
                        .get(mocaLanguageContext.rangeIdx);

                if (groovyCompilationResult.astVisitor == null) {
                    // This shouldn't happen, but let's avoid an exception if something
                    // goes terribly wrong.
                    return CompletableFuture.completedFuture(hover);
                }

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                        position.getCharacter(), mocaCompiler.groovyRanges.get(mocaLanguageContext.rangeIdx));

                ASTNode definitionNode = GroovyASTUtils.getDefinition(offsetNode, false,
                        groovyCompilationResult.astVisitor);
                if (definitionNode == null) {
                    return CompletableFuture.completedFuture(hover);
                }

                String content = getGroovyContent(groovyCompilationResult.astVisitor, definitionNode);
                if (content == null) {
                    return CompletableFuture.completedFuture(hover);
                }

                hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, String.format("```groovy\n%s\n```", content)));
                return CompletableFuture.completedFuture(hover);
        }

        return CompletableFuture.completedFuture(hover);
    }

    // MOCA.
    private static String getMocaCommandContent(String commandName, ArrayList<MocaCommand> mcmds) {

        String headerStr = String.format("command **%s**", commandName);
        String descriptionStr = "";
        if (mcmds.get(0).desc != null) {
            descriptionStr = String.format("*%s*", mcmds.get(0).desc);
        }

        String levelsStr = "";
        for (MocaCommand mcmd : mcmds) {
            levelsStr += String.format("* %s - %s\n", mcmd.cmplvl, mcmd.type);
        }

        // Add required args to documentation if there are any.
        String requiredArgumentsStr = "";
        ArrayList<MocaCommandArgument> args = MocaLanguageServer.currentMocaConnection.cache.mocaCache.commandArguments
                .get(mcmds.get(0).command);
        if (args != null) {
            for (MocaCommandArgument arg : args) {
                if (arg.argreq) {
                    // Have to make sure we are not adding an argnam that has already been added!
                    if (!requiredArgumentsStr.contains(arg.argtyp + " " + arg.argnam)) {
                        requiredArgumentsStr += String.format("* %s %s%s\n", arg.argtyp, arg.argnam,
                                (arg.altnam != null && !arg.altnam.isEmpty() ? " (" + arg.altnam + ")" : ""));
                    }
                }
            }
        }
        // Go ahead and add triggers to documentation if there are any.
        String triggersStr = "";
        ArrayList<MocaTrigger> triggers = MocaLanguageServer.currentMocaConnection.cache.mocaCache.triggers
                .get(mcmds.get(0).command);
        if (triggers != null) {
            for (MocaTrigger trg : triggers) {
                triggersStr += String.format("* %d: %s\n", trg.trgseq, trg.name);
            }
        }

        return String.format("%s\n\n%s\n%s\n\n%s\n%s\n\n%s\n%s", headerStr, descriptionStr, levelsStr,
                (requiredArgumentsStr.isEmpty() ? "" : "Required Arguments"), requiredArgumentsStr,
                (triggersStr.isEmpty() ? "" : "Triggers"), triggersStr);

    }

    // GROOVY.
    private static String getGroovyContent(GroovyASTNodeVisitor ast, ASTNode hoverNode) {
        if (hoverNode instanceof ClassNode) {
            ClassNode classNode = (ClassNode) hoverNode;
            return GroovyNodeToStringUtils.classToString(classNode, ast);
        } else if (hoverNode instanceof MethodNode) {
            MethodNode methodNode = (MethodNode) hoverNode;
            return GroovyNodeToStringUtils.methodToString(methodNode, ast);
        } else if (hoverNode instanceof Variable) {
            Variable varNode = (Variable) hoverNode;
            return GroovyNodeToStringUtils.variableToString(varNode, ast);
        }
        return null;
    }
}