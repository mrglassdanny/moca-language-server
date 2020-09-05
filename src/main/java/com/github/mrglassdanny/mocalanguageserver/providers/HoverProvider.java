package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaCommandArgument;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaTrigger;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.Table;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.ast.GroovyASTNodeVisitor;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyNodeToStringUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.Variable;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkedString;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

public class HoverProvider {

    public static CompletableFuture<Hover> provideHover(TextDocumentIdentifier textDocument, Position position,
            String textDocumentContents, MocaCompiler mocaCompiler) {

        Hover hover = new Hover();
        List<Either<String, MarkedString>> contents = new ArrayList<>();
        hover.setContents(contents);

        // Analyze context id for position.
        MocaLanguageContext ctx = mocaCompiler.getMocaLanguageContextFromPosition(position);

        switch (ctx.id) {
            case Moca:

                // For hover, we need to make sure the moca compiliation result we are
                // looking at has no errors.
                MocaCompilationResult mocaCompilationResult = mocaCompiler.currentCompilationResult;

                if (mocaCompilationResult == null) {
                    return CompletableFuture.completedFuture(hover);
                }

                String mocaWord = Positions.getWordAtPosition(textDocumentContents, position).toLowerCase();

                if (mocaWord != null) {
                    mocaWord = mocaWord.toLowerCase();

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
                                    String content = getMocaContent(verbNounClause.toString(), mcmds);

                                    contents.add(Either.forRight(new MarkedString("plaintext", content)));
                                    return CompletableFuture.completedFuture(hover);
                                }
                            }
                        }
                    }

                }

                break;
            case Sql:

                // For hover, we need to make sure the sql compiliation result we are
                // looking at has no errors.
                MocaSqlCompilationResult sqlCompilationResult = mocaCompiler.currentCompilationResult.sqlCompilationResults
                        .get(ctx.rangeIdx);

                // Tables, views, aliases, and subqueries - oh my!
                String sqlWord = Positions.getWordAtPosition(textDocumentContents, position);

                if (sqlWord != null) {
                    // Convert to lowercase since repo is in lowercase.
                    sqlWord = sqlWord.toLowerCase();

                    // Check first to see if sql word is table/view in database.
                    Table table = MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.tables.get(sqlWord);
                    if (table != null) {
                        contents.add(Either.forRight(new MarkedString("plaintext", getSqlContent(table, false))));
                        return CompletableFuture.completedFuture(hover);
                    }

                    Table view = MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.views.get(sqlWord);
                    if (view != null) {
                        contents.add(Either.forRight(new MarkedString("plaintext", getSqlContent(view, true))));
                        return CompletableFuture.completedFuture(hover);
                    }

                    // If not, check aliased tables/views/subqueries.
                    if (sqlCompilationResult != null && sqlCompilationResult.sqlParseTreeListener != null
                            && sqlCompilationResult.sqlParseTreeListener.aliasedTableNames != null
                            && sqlCompilationResult.sqlParseTreeListener.aliasedTableNames.containsKey(sqlWord)) {
                        contents.add(Either.forRight(new MarkedString("plaintext", "(alias) "
                                + sqlCompilationResult.sqlParseTreeListener.aliasedTableNames.get(sqlWord))));
                        return CompletableFuture.completedFuture(hover);
                    }
                    if (sqlCompilationResult != null && sqlCompilationResult.sqlParseTreeListener != null
                            && sqlCompilationResult.sqlParseTreeListener.subqueries != null
                            && sqlCompilationResult.sqlParseTreeListener.subqueries.containsKey(sqlWord)) {
                        contents.add(Either.forRight(new MarkedString("plaintext", "subquery " + sqlWord)));
                        return CompletableFuture.completedFuture(hover);
                    }

                }

                break;
            case Groovy:

                GroovyCompilationResult groovyCompilationResult = mocaCompiler.currentCompilationResult.groovyCompilationResults
                        .get(ctx.rangeIdx);

                if (groovyCompilationResult.astVisitor == null) {
                    // This shouldn't happen, but let's avoid an exception if something
                    // goes terribly wrong.
                    return CompletableFuture.completedFuture(hover);
                }

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                        position.getCharacter(), mocaCompiler.groovyRanges.get(ctx.rangeIdx));

                ASTNode definitionNode = GroovyASTUtils.getDefinition(offsetNode, false,
                        groovyCompilationResult.astVisitor);
                if (definitionNode == null) {
                    return CompletableFuture.completedFuture(hover);
                }

                String content = getGroovyContent(groovyCompilationResult.astVisitor, definitionNode);
                if (content == null) {
                    return CompletableFuture.completedFuture(hover);
                }

                contents.add(Either.forRight(new MarkedString("groovy", content)));
                return CompletableFuture.completedFuture(hover);
        }

        return CompletableFuture.completedFuture(hover);
    }

    // MOCA.
    private static String getMocaContent(String commandName, ArrayList<MocaCommand> mcmds) {

        String contents = "command " + commandName + "\n";
        for (MocaCommand mcmd : mcmds) {
            contents += mcmd.cmplvl + " - " + mcmd.type + "\n";
        }
        if (mcmds.get(0).desc != null) {
            contents += mcmds.get(0).desc;
        }

        // Add required args to documentation if there are any.
        contents += "\n\nRequired Arguments:\n";
        ArrayList<MocaCommandArgument> args = MocaLanguageServer.currentMocaConnection.cache.mocaCache.commandArguments
                .get(mcmds.get(0).command);
        if (args != null) {
            for (MocaCommandArgument arg : args) {
                if (arg.argreq) {
                    // Have to make sure we are not adding an argnam that has already been added!
                    if (!contents.contains(arg.argtyp + " " + arg.argnam)) {
                        contents += (arg.argtyp + " " + arg.argnam
                                + (arg.altnam != null && !arg.altnam.isEmpty() ? " (" + arg.altnam + ")" : "")) + "\n";
                    }
                }
            }
        }
        // Go ahead and add triggers to documentation if there are any.
        contents += "\nTriggers:\n";
        ArrayList<MocaTrigger> triggers = MocaLanguageServer.currentMocaConnection.cache.mocaCache.triggers
                .get(mcmds.get(0).command);
        if (triggers != null) {
            for (MocaTrigger trg : triggers) {
                contents += (trg.trgseq + " - " + trg.name) + "\n";
            }
        }

        return contents;

    }

    // SQL.
    private static String getSqlContent(Table table, boolean isView) {

        if (isView) {
            return "view " + table.table_name + "\n" + (table.description == null ? "" : table.description);
        } else {
            return "table " + table.table_name + "\n" + (table.description == null ? "" : table.description);
        }
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
        } else {
            System.err.println("*** hover not available for node: " + hoverNode);
        }
        return null;
    }
}