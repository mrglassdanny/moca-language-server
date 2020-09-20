package com.github.mrglassdanny.mocalanguageserver.hover;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaFunction;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.Table;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.ast.GroovyASTNodeVisitor;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyNodeToStringUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

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

                String mocaWord = PositionUtils.getWordAtPosition(textDocumentContents, position, "([a-zA-Z_0-9.])");

                if (mocaWord != null) {

                    mocaWord = mocaWord.toLowerCase();

                    // First check if this is a moca function.
                    MocaFunction mocaFunction = MocaLanguageServer.currentMocaConnection.cache.mocaCache.functions
                            .get(mocaWord);
                    if (mocaFunction != null) {

                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, mocaFunction.getMarkdownStr()));

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
                                    String content = MocaCommand.getMarkdownStr(verbNounClause.toString(), mcmds);

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
                String mocaSqlWord = PositionUtils.getWordAtPosition(textDocumentContents, position, "([a-zA-Z_0-9])");

                if (mocaSqlWord != null) {
                    // Convert to lowercase since repo is in lowercase.
                    mocaSqlWord = mocaSqlWord.toLowerCase();

                    // Check first to see if mocasql word is table/view in database.
                    Table table = MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.tables.get(mocaSqlWord);
                    if (table != null) {
                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, table.getMarkdownStr()));
                        return CompletableFuture.completedFuture(hover);
                    }

                    Table view = MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.views.get(mocaSqlWord);
                    if (view != null) {
                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, view.getMarkdownStr()));
                        return CompletableFuture.completedFuture(hover);
                    }

                    // If not, check aliased tables/views/subqueries.
                    if (mocaSqlCompilationResult != null && mocaSqlCompilationResult.mocaSqlParseTreeListener != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.aliasedTableNames != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.aliasedTableNames
                                    .containsKey(mocaSqlWord)) {
                        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, Table.getMarkdownStrForAlias(
                                mocaSqlCompilationResult.mocaSqlParseTreeListener.aliasedTableNames.get(mocaSqlWord))));
                        return CompletableFuture.completedFuture(hover);
                    }
                    if (mocaSqlCompilationResult != null && mocaSqlCompilationResult.mocaSqlParseTreeListener != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries != null
                            && mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries.containsKey(mocaSqlWord)) {
                        hover.setContents(
                                new MarkupContent(MarkupKind.MARKDOWN, Table.getMarkdownStrForSubquery(mocaSqlWord)));
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

                String content = getGroovyMarkdown(groovyCompilationResult.astVisitor, definitionNode);
                if (content == null) {
                    return CompletableFuture.completedFuture(hover);
                }

                hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, content));
                return CompletableFuture.completedFuture(hover);
        }

        return CompletableFuture.completedFuture(hover);
    }

    private static String getGroovyMarkdown(GroovyASTNodeVisitor ast, ASTNode hoverNode) {
        if (hoverNode instanceof ClassNode) {
            ClassNode classNode = (ClassNode) hoverNode;
            return String.format("```groovy\n%s\n```", GroovyNodeToStringUtils.classToString(classNode, ast));
        } else if (hoverNode instanceof MethodNode) {
            MethodNode methodNode = (MethodNode) hoverNode;
            return String.format("```groovy\n%s\n```", GroovyNodeToStringUtils.methodToString(methodNode, ast));
        } else if (hoverNode instanceof Variable) {
            Variable varNode = (Variable) hoverNode;
            return String.format("```groovy\n%s\n```", GroovyNodeToStringUtils.variableToString(varNode, ast));
        }
        return null;
    }
}