package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.repository.database.Table;
import com.github.mrglassdanny.mocalanguageserver.moca.repository.database.TableColumn;
import com.github.mrglassdanny.mocalanguageserver.moca.repository.moca.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.repository.moca.MocaCommandArgument;
import com.github.mrglassdanny.mocalanguageserver.moca.repository.moca.MocaTrigger;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.SqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.ast.SqlStatementVisitor;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.ImportNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.codehaus.groovy.ast.PropertyNode;
import org.codehaus.groovy.ast.VariableScope;
import org.codehaus.groovy.ast.expr.ConstructorCallExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.expr.PropertyExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.eclipse.lsp4j.CompletionContext;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassGraphException;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.PackageInfo;
import io.github.classgraph.ScanResult;
import net.sf.jsqlparser.statement.select.SubSelect;

public class CompletionProvider {

    public static CompletableFuture<Either<List<CompletionItem>, CompletionList>> provideCompletion(
            TextDocumentIdentifier textDocument, Position position, String textDocumentContents,
            CompletionContext context, MocaCompiler mocaCompiler) {

        List<CompletionItem> items = new ArrayList<>();

        // Analyze context id for position.
        MocaLanguageContext ctx = mocaCompiler.getMocaLanguageContextFromPosition(position);

        switch (ctx.id) {
            case Moca:

                // For completion, we need to make sure the moca compiliation result we are
                // looking at has no errors.
                MocaCompilationResult mocaCompilationResult = mocaCompiler.currentCompilationResult;
                if (mocaCompilationResult.hasMocaErrors()) {
                    mocaCompilationResult = mocaCompiler.lastSuccessfulCompilationResult;
                }

                if (mocaCompilationResult == null) {
                    // Can assume user wants commands.
                    populateMocaCommands(items);
                    return CompletableFuture.completedFuture(Either.forLeft(items));
                }

                // Now, we need to see where we are in token list based on the position that was
                // passed in.
                int curMocaTokenIdx = mocaCompiler.getMocaTokenIndexAtPosition(textDocumentContents, position);

                // Check if bracket string before we do anything else. If so, return nothing for
                // now.
                org.antlr.v4.runtime.Token potentialBracketStringMocaToken = mocaCompiler.mocaTokens
                        .get(curMocaTokenIdx);
                if (potentialBracketStringMocaToken != null
                        && (potentialBracketStringMocaToken.getType() == MocaLexer.SINGLE_BRACKET_STRING
                                || potentialBracketStringMocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING)) {
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                if (curMocaTokenIdx == -1) {
                    // Can assume user wants commands.
                    populateMocaCommands(items);
                    return CompletableFuture.completedFuture(Either.forLeft(items));
                }

                // Check if the word we are typing resembles "where".
                // If so, we want nothing for now.
                String curWord = Positions.getWordAtPosition(textDocumentContents, position);
                boolean matchesWhere = curWord.matches("(?i)\\b(where|wher|whe|wh|w)\\b");
                if (matchesWhere) {
                    // Return nothing for now.
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                for (int i = curMocaTokenIdx; i >= 0; i--) {
                    org.antlr.v4.runtime.Token curMocaToken = mocaCompiler.mocaTokens.get(i);
                    switch (curMocaToken.getType()) {
                        case MocaLexer.WHERE:
                            // case AND:
                            // Do not look for AND!
                            // We want args!

                            // Get command unit current moca token is in.
                            String verbNounClause = null;
                            boolean foundTokenMatch = false;
                            for (Map.Entry<String, ArrayList<org.antlr.v4.runtime.Token>> entry : mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                                    .entrySet()) {

                                // We are checking for 2 things:
                                // 1. a WHERE token match - this will be the case if more than 1 arg has been
                                // typed. This will be a match of begin, end, and type.
                                // 2. a token match between the curMocaToken(WHERE) and the soon-to-be WHERE
                                // token that is part of the last successful parse result(where|wher|whe|wh|w).
                                // This will be a match of begin and regex match of parsed token value.
                                for (org.antlr.v4.runtime.Token parsedMocaToken : entry.getValue()) {

                                    if (((parsedMocaToken.getStartIndex() >= curMocaToken.getStartIndex() - 10
                                            && parsedMocaToken.getStartIndex() <= curMocaToken.getStartIndex())
                                            // This is a little goofy, but if
                                            // formatting on type is turned on,
                                            // the begin for the parsed token and
                                            // the begin for the curtoken will be
                                            // different.
                                            && parsedMocaToken.getText().matches("(?i)\\b(where|wher|whe|wh|w)\\b"))
                                            || (parsedMocaToken.getStartIndex() == curMocaToken.getStartIndex()
                                                    && parsedMocaToken.getStopIndex() == curMocaToken.getStopIndex()
                                                    && parsedMocaToken.getType() == curMocaToken.getType())) {

                                        verbNounClause = entry.getKey();
                                        foundTokenMatch = true;
                                        break;
                                    }
                                }
                                if (foundTokenMatch) {
                                    break;
                                }
                            }
                            // Now we can get the command unit's data.
                            if (verbNounClause != null) {
                                // Now, need to potentially remove the last token from the verbNounClause
                                // IF we matched the 2nd condition above.
                                // Let's check all the distinct commands for both conditions: as it is, and
                                // removing the last token.

                                // First checking verbNounClause as is.
                                if (!MocaLanguageServer.currentMocaConnection.repository.commandRepository.distinctCommands
                                        .contains(verbNounClause)) {
                                    // Remove last token and try again.
                                    try {
                                        verbNounClause = verbNounClause.substring(0, verbNounClause.lastIndexOf(" "));
                                    } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                                        // Do nothing...
                                    }

                                    if (!MocaLanguageServer.currentMocaConnection.repository.commandRepository.distinctCommands
                                            .contains(verbNounClause)) {
                                        // This will stop us from trying to get completion items below.
                                        verbNounClause = null;
                                    }
                                }
                            }

                            if (verbNounClause != null) {
                                // HACK - getting the first letter typed for command arg population; see
                                // function for more info.
                                char firstTypedLetter = Positions.getCharacterAtPosition(textDocumentContents,
                                        new Position(position.getLine(), position.getCharacter() - 1));
                                populateMocaCommandArguments(verbNounClause, items, firstTypedLetter);
                                return CompletableFuture.completedFuture(Either.forLeft(items));
                            }

                            // If nothing for some reason, return empty list.
                            return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                        case MocaLexer.DOUBLE_GREATER:
                        case MocaLexer.CATCH:
                            // Nothing for now.
                            return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                        case MocaLexer.SINGLE_BRACKET_STRING:
                        case MocaLexer.DOUBLE_BRACKET_STRING:
                        case MocaLexer.RIGHT_BRACE:
                        case MocaLexer.SEMI_COLON:
                        case MocaLexer.AMPERSAND:
                        case MocaLexer.PIPE:
                        case MocaLexer.CARET:
                            // Commands.
                            populateMocaCommands(items);
                            return CompletableFuture.completedFuture(Either.forLeft(items));
                        default:
                            break;
                    }
                }
                // Just return moca commands if we get here.
                populateMocaCommands(items);
                return CompletableFuture.completedFuture(Either.forLeft(items));
            case Sql:

                // For completion, we need to make sure the sql compiliation result we are
                // looking at has no errors.
                SqlCompilationResult sqlCompilationResult = mocaCompiler.currentCompilationResult.sqlCompilationResults
                        .get(ctx.rangeIdx);
                if (sqlCompilationResult.hasErrors()) {
                    sqlCompilationResult = mocaCompiler.currentCompilationResult.sqlLastSuccessfulCompilationResults
                            .get(ctx.rangeIdx);
                }

                // If we do not have one, we need to quit now.
                if (sqlCompilationResult != null) {

                    // Checking to see if we pressed '.' - which in an sql context would mean that
                    // we are looking for table columns.
                    if (Positions.getCharacterAtPosition(textDocumentContents,
                            new Position(position.getLine(), position.getCharacter() - 1)) == '.') {

                        // Get word on left of '.'.
                        String word = Positions.getWordAtPosition(textDocumentContents,
                                new Position(position.getLine(), position.getCharacter() - 2));
                        if (word != null) {
                            // Make sure case sensitivity will not get in the way.
                            String lowerCaseWord = word.toLowerCase();

                            // Now we need to determine if we are dealing with an alias, a table, or a
                            // subquery.
                            populateSqlColumnsFromTableName(lowerCaseWord, null, true, items);

                            if (items.isEmpty()) { // Empty - must be alias or subquery.

                                // Checking if table is aliased.
                                if (sqlCompilationResult.astVisitor.aliasedTableNames.containsKey(lowerCaseWord)) {
                                    populateSqlColumnsFromTableName(
                                            sqlCompilationResult.astVisitor.aliasedTableNames.get(lowerCaseWord),
                                            lowerCaseWord, true, items);
                                } else {
                                    // Must be a subquery.
                                    // See if match in map.
                                    if (sqlCompilationResult.astVisitor.subqueries.containsKey(lowerCaseWord)) {

                                        ArrayList<String> subqueryColumnNames = new ArrayList<>();
                                        SubSelect subquery = sqlCompilationResult.astVisitor.subqueries
                                                .get(lowerCaseWord);

                                        // Easiest way to get columns from subquery is just analyze the subquery
                                        // statement like this.
                                        SqlStatementVisitor subqueryVisitor = new SqlStatementVisitor() {

                                            @Override
                                            public void visit(net.sf.jsqlparser.schema.Column column) {

                                                String columnName = column.getColumnName();
                                                // Make sure column name has not already been added!
                                                if (!subqueryColumnNames.contains(columnName)) {
                                                    subqueryColumnNames.add(columnName);
                                                }

                                                super.visit(column);
                                            }
                                        };
                                        subqueryVisitor.visit(subquery);
                                        populateSqlColumnsFromSubquery(subqueryColumnNames, items);

                                    }
                                }
                            }
                        }

                    } else {

                        // Let's check how many tables there are in script. If there is just 1, we will
                        // get the columns for it.
                        if (sqlCompilationResult.astVisitor.tableNames.size() == 1) {
                            String tableName = sqlCompilationResult.astVisitor.tableNames.get(0);
                            // Check if it has been aliased.
                            if (sqlCompilationResult.astVisitor.aliasedTableNames.containsValue(tableName)) {
                                for (Map.Entry<String, String> entry : sqlCompilationResult.astVisitor.aliasedTableNames
                                        .entrySet()) {
                                    if (entry.getValue().compareTo(tableName) == 0) {
                                        populateSqlColumnsFromTableName(tableName, entry.getKey(), false, items);
                                        break;
                                    }
                                }
                            } else {
                                populateSqlColumnsFromTableName(tableName, null, false, items);
                            }
                        }

                        // Get tables/views from database.
                        populateSqlTables(items);
                        // Also get any other aliased entities in script.
                        populateAliasedTableNames(sqlCompilationResult.astVisitor.aliasedTableNames, items);
                        populateSubqueryNames(sqlCompilationResult.astVisitor.subqueries, items);

                    }

                }

                return CompletableFuture.completedFuture(Either.forLeft(items));
            case Groovy:

                GroovyCompilationResult groovyCompilationResult = mocaCompiler.currentCompilationResult.groovyCompilationResults
                        .get(ctx.rangeIdx);

                Range groovyScriptRange = mocaCompiler.groovyRanges.get(ctx.rangeIdx);

                if (groovyCompilationResult.astVisitor == null) {
                    // this shouldn't happen, but let's avoid an exception if something
                    // goes terribly wrong.
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                        position.getCharacter(), groovyScriptRange);
                if (offsetNode == null) {
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                ASTNode parentNode = groovyCompilationResult.astVisitor.getParent(offsetNode);

                if (offsetNode instanceof PropertyExpression) {
                    populateGroovyItemsFromPropertyExpression((PropertyExpression) offsetNode, position, items,
                            groovyScriptRange, groovyCompilationResult);
                } else if (parentNode instanceof PropertyExpression) {
                    populateGroovyItemsFromPropertyExpression((PropertyExpression) parentNode, position, items,
                            groovyScriptRange, groovyCompilationResult);
                } else if (offsetNode instanceof MethodCallExpression) {
                    populateGroovyItemsFromMethodCallExpression((MethodCallExpression) offsetNode, position, items,
                            groovyScriptRange, groovyCompilationResult);
                } else if (offsetNode instanceof ConstructorCallExpression) {
                    populateGroovyItemsFromConstructorCallExpression((ConstructorCallExpression) offsetNode, position,
                            items, groovyScriptRange, groovyCompilationResult);
                } else if (parentNode instanceof MethodCallExpression) {
                    populateGroovyItemsFromMethodCallExpression((MethodCallExpression) parentNode, position, items,
                            groovyScriptRange, groovyCompilationResult);
                } else if (offsetNode instanceof VariableExpression) {
                    populateGroovyItemsFromVariableExpression((VariableExpression) offsetNode, position, items,
                            groovyScriptRange, groovyCompilationResult);
                } else if (offsetNode instanceof ImportNode) {
                    populateGroovyItemsFromImportNode((ImportNode) offsetNode, position, items, groovyScriptRange,
                            groovyCompilationResult);
                } else if (offsetNode instanceof MethodNode) {
                    populateGroovyItemsFromScope(offsetNode, "", items, groovyScriptRange, groovyCompilationResult);
                } else if (offsetNode instanceof Statement) {
                    populateGroovyItemsFromScope(offsetNode, "", items, groovyScriptRange, groovyCompilationResult);
                }

                return CompletableFuture.completedFuture(Either.forLeft(items));
        }

        return CompletableFuture.completedFuture(Either.forLeft(items));
    }

    // MOCA.
    private static void populateMocaCommands(List<CompletionItem> items) {

        for (Map.Entry<String, ArrayList<MocaCommand>> entry : MocaLanguageServer.currentMocaConnection.repository.commandRepository.commands
                .entrySet()) {
            CompletionItem item = new CompletionItem(entry.getKey());
            ArrayList<MocaCommand> mcmds = entry.getValue();
            String docStr = "";
            for (MocaCommand mcmd : mcmds) {
                docStr += mcmd.cmplvl + " - " + mcmd.type + "\n";
            }
            if (mcmds.size() > 0 && mcmds.get(0).desc != null) {
                docStr += mcmds.get(0).desc;
            }

            // Add required args to documentation if there are any.
            docStr += "\n\nRequired Arguments:\n";
            ArrayList<MocaCommandArgument> args = MocaLanguageServer.currentMocaConnection.repository.commandRepository.commandArguments
                    .get(mcmds.get(0).command);
            if (args != null) {
                for (MocaCommandArgument arg : args) {
                    if (arg.argreq) {
                        // Have to make sure we are not adding an argnam that has already been added!
                        if (!docStr.contains(arg.argtyp + " " + arg.argnam)) {
                            docStr += (arg.argtyp + " " + arg.argnam
                                    + (arg.altnam != null && !arg.altnam.isEmpty() ? " (" + arg.altnam + ")" : ""))
                                    + "\n";
                        }
                    }
                }
            }

            // Go ahead and add triggers to documentation if there are any.
            docStr += "\nTriggers:\n";
            ArrayList<MocaTrigger> triggers = MocaLanguageServer.currentMocaConnection.repository.commandRepository.triggers
                    .get(mcmds.get(0).command);
            if (triggers != null) {
                for (MocaTrigger trg : triggers) {
                    docStr += (trg.trgseq + " - " + trg.name) + "\n";
                }
            }

            item.setDocumentation(docStr);
            item.setKind(CompletionItemKind.Function);
            items.add(item);
        }

    }

    private static void populateMocaCommandArguments(String mocaCommandName, List<CompletionItem> items,
            char firstTypedLetter) {

        ArrayList<MocaCommandArgument> cmdArgs = MocaLanguageServer.currentMocaConnection.repository.commandRepository.commandArguments
                .get(mocaCommandName);
        if (cmdArgs == null) {
            return;
        }

        for (MocaCommandArgument arg : cmdArgs) {
            // Need to make sure the arg is not already in the list.
            boolean argAlreadyInList = false;
            for (CompletionItem testItem : items) {
                if (testItem.getLabel().compareTo(arg.argnam) == 0) {
                    argAlreadyInList = true;
                    break;
                }
            }

            if (!argAlreadyInList) {
                CompletionItem item = new CompletionItem(arg.argnam);
                item.setDocumentation(arg.argtyp + " " + arg.argnam + (arg.argreq ? "\t(Required)" : "") + "\n"
                        + (arg.altnam != null && !arg.altnam.isEmpty() ? "alias - " + arg.altnam : ""));
                // HACK - we want the user typing the args to see all possiblities. LextEdit
                // does this by using the space character as a trigger character.
                // Instead of doing that, we will pre-pend the first letter the user types in
                // the filter text of the completion item. This will populate all
                // args regardless of what the user types.
                item.setFilterText(firstTypedLetter + arg.argnam);
                item.setKind(CompletionItemKind.Field);
                items.add(item);
            }
        }

    }

    // SQL.
    // Includes views.
    private static void populateSqlTables(List<CompletionItem> items) {

        for (Map.Entry<String, Table> tableEntry : MocaLanguageServer.currentMocaConnection.repository.databaseSchema.tables
                .entrySet()) {
            Table tbl = tableEntry.getValue();
            CompletionItem item = new CompletionItem(tbl.table_name);
            item.setDocumentation(tbl.description);
            item.setKind(CompletionItemKind.Struct);
            items.add(item);
        }

        for (Map.Entry<String, Table> viewEntry : MocaLanguageServer.currentMocaConnection.repository.databaseSchema.views
                .entrySet()) {
            Table view = viewEntry.getValue();
            CompletionItem item = new CompletionItem(view.table_name);
            item.setDocumentation(view.description);
            item.setKind(CompletionItemKind.Enum);
            items.add(item);
        }
    }

    private static void populateAliasedTableNames(HashMap<String, String> aliasedTableNames,
            List<CompletionItem> items) {

        for (Map.Entry<String, String> entry : aliasedTableNames.entrySet()) {
            CompletionItem item = new CompletionItem(entry.getKey());
            item.setDocumentation("(alias) " + entry.getValue());
            item.setKind(CompletionItemKind.Struct);
            items.add(item);
        }
    }

    private static void populateSubqueryNames(HashMap<String, SubSelect> subqueries, List<CompletionItem> items) {

        for (String subqueryName : subqueries.keySet()) {
            CompletionItem item = new CompletionItem(subqueryName);
            item.setDocumentation("subquery");
            item.setKind(CompletionItemKind.Class);
            items.add(item);
        }
    }

    private static void populateSqlColumnsFromTableName(String tableName, String aliasName,
            boolean excludeColPrefixForFirstForAllCols, List<CompletionItem> items) {
        ArrayList<TableColumn> cols = MocaLanguageServer.currentMocaConnection.repository.databaseSchema
                .getColumnsForTable(tableName);

        // Could be null.
        if (cols == null) {
            return;
        }

        // Add an 'all columns' completion item, which will insert all the columns in
        // the table.
        CompletionItem allColItem = new CompletionItem("_all_columns");
        allColItem.setDocumentation("Fill in all column names comma delimited.");
        allColItem.setKind(CompletionItemKind.Unit);
        String insertText = "";
        String colPrefix = (aliasName != null && !aliasName.isEmpty() ? aliasName : tableName) + ".";
        for (TableColumn col : cols) {
            insertText += colPrefix + col.column_name + ", ";
        }
        // Remove last 2 characters(", "):
        insertText = insertText.substring(0, insertText.length() - 2);
        // If we need to exclude col prefix via boolean passed in, do so now.
        if (excludeColPrefixForFirstForAllCols) {
            insertText = insertText.substring(colPrefix.length(), insertText.length());
        }
        allColItem.setInsertText(insertText);
        items.add(allColItem);

        // Now add table columns.
        for (TableColumn col : cols) {
            CompletionItem item = new CompletionItem(col.column_name);
            item.setDocumentation(col.documentationStr);
            item.setKind(CompletionItemKind.Field);
            items.add(item);
        }
    }

    private static void populateSqlColumnsFromSubquery(ArrayList<String> columnNames, List<CompletionItem> items) {
        for (String columnName : columnNames) {
            CompletionItem item = new CompletionItem(columnName);
            item.setDocumentation("from subquery");
            item.setKind(CompletionItemKind.Field);
            items.add(item);
        }
    }

    // GROOVY.
    private static void populateGroovyItemsFromPropertyExpression(PropertyExpression propExpr, Position position,
            List<CompletionItem> items, Range groovyScriptRange, GroovyCompilationResult groovyCompilationResult) {
        Range propertyRange = GroovyLanguageUtils.astNodeToRange(propExpr.getProperty(), groovyScriptRange);
        String memberName = getGroovyMemberName(propExpr.getPropertyAsString(), propertyRange, position);
        populateGroovyItemsFromExpression(propExpr.getObjectExpression(), memberName, items, groovyCompilationResult);
    }

    private static void populateGroovyItemsFromMethodCallExpression(MethodCallExpression methodCallExpr,
            Position position, List<CompletionItem> items, Range groovyScriptRange,
            GroovyCompilationResult groovyCompilationResult) {
        Range methodRange = GroovyLanguageUtils.astNodeToRange(methodCallExpr.getMethod(), groovyScriptRange);
        String memberName = getGroovyMemberName(methodCallExpr.getMethodAsString(), methodRange, position);
        populateGroovyItemsFromExpression(methodCallExpr.getObjectExpression(), memberName, items,
                groovyCompilationResult);
    }

    private static void populateGroovyItemsFromImportNode(ImportNode importNode, Position position,
            List<CompletionItem> items, Range groovyScriptRange, GroovyCompilationResult groovyCompilationResult) {
        Range importRange = GroovyLanguageUtils.astNodeToRange(importNode, groovyScriptRange);
        // skip the "import " at the beginning
        importRange.setStart(new Position(importRange.getEnd().getLine(),
                importRange.getEnd().getCharacter() - importNode.getType().getName().length()));
        String importText = getGroovyMemberName(importNode.getType().getName(), importRange, position);

        ModuleNode enclosingModule = groovyCompilationResult.astVisitor.module;
        String enclosingPackageName = enclosingModule.getPackageName();
        List<String> importNames = enclosingModule.getImports().stream()
                .map(otherImportNode -> otherImportNode.getClassName()).collect(Collectors.toList());

        List<CompletionItem> localClassItems = groovyCompilationResult.astVisitor.getClassNodes().stream()
                .filter(classNode -> {
                    String packageName = classNode.getPackageName();
                    if (packageName == null || packageName.length() == 0 || packageName.equals(enclosingPackageName)) {
                        return false;
                    }
                    String className = classNode.getName();
                    String classNameWithoutPackage = classNode.getNameWithoutPackage();
                    if (!className.startsWith(importText) && !classNameWithoutPackage.startsWith(importText)) {
                        return false;
                    }
                    if (importNames.contains(className)) {
                        return false;
                    }
                    return true;
                }).map(classNode -> {
                    CompletionItem item = new CompletionItem();
                    item.setLabel(classNode.getName());
                    item.setTextEdit(new TextEdit(importRange, classNode.getName()));
                    item.setKind(GroovyLanguageUtils.astNodeToCompletionItemKind(classNode));
                    if (classNode.getNameWithoutPackage().startsWith(importText)) {
                        item.setSortText(classNode.getNameWithoutPackage());
                    }
                    return item;
                }).collect(Collectors.toList());
        items.addAll(localClassItems);

        ScanResult scanResult = scanClassesForGroovy(groovyCompilationResult);
        if (scanResult == null) {
            return;
        }
        List<ClassInfo> classes = scanResult.getAllClasses();
        List<PackageInfo> packages = scanResult.getPackageInfo();

        List<CompletionItem> packageItems = packages.stream().filter(packageInfo -> {
            String packageName = packageInfo.getName();
            if (packageName.startsWith(importText)) {
                return true;
            }
            return false;
        }).map(packageInfo -> {
            CompletionItem item = new CompletionItem();
            item.setLabel(packageInfo.getName());
            item.setTextEdit(new TextEdit(importRange, packageInfo.getName()));
            item.setKind(CompletionItemKind.Module);
            return item;
        }).collect(Collectors.toList());
        items.addAll(packageItems);

        List<CompletionItem> classItems = classes.stream().filter(classInfo -> {
            String packageName = classInfo.getPackageName();
            if (packageName == null || packageName.length() == 0 || packageName.equals(enclosingPackageName)) {
                return false;
            }
            String className = classInfo.getName();
            String classNameWithoutPackage = classInfo.getSimpleName();
            if (!className.startsWith(importText) && !classNameWithoutPackage.startsWith(importText)) {
                return false;
            }
            if (importNames.contains(className)) {
                return false;
            }
            return true;
        }).map(classInfo -> {
            CompletionItem item = new CompletionItem();
            item.setLabel(classInfo.getName());
            item.setTextEdit(new TextEdit(importRange, classInfo.getName()));
            item.setKind(groovyClassInfoToCompletionItemKind(classInfo));
            if (classInfo.getSimpleName().startsWith(importText)) {
                item.setSortText(classInfo.getSimpleName());
            }
            return item;
        }).collect(Collectors.toList());
        items.addAll(classItems);
    }

    private static void populateGroovyItemsFromConstructorCallExpression(ConstructorCallExpression constructorCallExpr,
            Position position, List<CompletionItem> items, Range groovyScriptRange,
            GroovyCompilationResult groovyCompilationResult) {
        Range typeRange = GroovyLanguageUtils.astNodeToRange(constructorCallExpr.getType(), groovyScriptRange);
        String typeName = getGroovyMemberName(constructorCallExpr.getType().getNameWithoutPackage(), typeRange,
                position);
        populateGroovyClasses(constructorCallExpr, typeName, new HashSet<>(), items, groovyScriptRange,
                groovyCompilationResult);
    }

    private static void populateGroovyItemsFromVariableExpression(VariableExpression varExpr, Position position,
            List<CompletionItem> items, Range groovyScriptRange, GroovyCompilationResult groovyCompilationResult) {
        Range varRange = GroovyLanguageUtils.astNodeToRange(varExpr, groovyScriptRange);
        String memberName = getGroovyMemberName(varExpr.getName(), varRange, position);
        populateGroovyItemsFromScope(varExpr, memberName, items, groovyScriptRange, groovyCompilationResult);
    }

    private static void populateGroovyItemsFromPropertiesAndFields(List<PropertyNode> properties,
            List<FieldNode> fields, String memberNamePrefix, Set<String> existingNames, List<CompletionItem> items) {
        List<CompletionItem> propItems = properties.stream().filter(property -> {
            String name = property.getName();
            // sometimes, a property and a field will have the same name
            if (name.startsWith(memberNamePrefix) && !existingNames.contains(name)) {
                existingNames.add(name);
                return true;
            }
            return false;
        }).map(property -> {
            CompletionItem item = new CompletionItem();
            item.setLabel(property.getName());
            item.setKind(GroovyLanguageUtils.astNodeToCompletionItemKind(property));
            return item;
        }).collect(Collectors.toList());
        items.addAll(propItems);
        List<CompletionItem> fieldItems = fields.stream().filter(field -> {
            String name = field.getName();
            // sometimes, a property and a field will have the same name
            if (name.startsWith(memberNamePrefix) && !existingNames.contains(name)) {
                existingNames.add(name);
                return true;
            }
            return false;
        }).map(field -> {
            CompletionItem item = new CompletionItem();
            item.setLabel(field.getName());
            item.setKind(GroovyLanguageUtils.astNodeToCompletionItemKind(field));
            return item;
        }).collect(Collectors.toList());
        items.addAll(fieldItems);
    }

    private static void populateGroovyItemsFromMethods(List<MethodNode> methods, String memberNamePrefix,
            Set<String> existingNames, List<CompletionItem> items) {
        List<CompletionItem> methodItems = methods.stream().filter(method -> {
            String methodName = method.getName();
            // overloads can cause duplicates
            if (methodName.startsWith(memberNamePrefix) && !existingNames.contains(methodName)) {
                existingNames.add(methodName);
                return true;
            }
            return false;
        }).map(method -> {
            CompletionItem item = new CompletionItem();
            item.setLabel(method.getName());
            item.setKind(GroovyLanguageUtils.astNodeToCompletionItemKind(method));
            return item;
        }).collect(Collectors.toList());
        items.addAll(methodItems);
    }

    private static void populateGroovyItemsFromExpression(Expression leftSide, String memberNamePrefix,
            List<CompletionItem> items, GroovyCompilationResult groovyCompilationResult) {
        Set<String> existingNames = new HashSet<>();

        List<PropertyNode> properties = GroovyASTUtils.getPropertiesForLeftSideOfPropertyExpression(leftSide,
                groovyCompilationResult.astVisitor);
        List<FieldNode> fields = GroovyASTUtils.getFieldsForLeftSideOfPropertyExpression(leftSide,
                groovyCompilationResult.astVisitor);
        populateGroovyItemsFromPropertiesAndFields(properties, fields, memberNamePrefix, existingNames, items);

        List<MethodNode> methods = GroovyASTUtils.getMethodsForLeftSideOfPropertyExpression(leftSide,
                groovyCompilationResult.astVisitor);
        populateGroovyItemsFromMethods(methods, memberNamePrefix, existingNames, items);
    }

    private static void populateGroovyItemsFromVariableScope(VariableScope variableScope, String memberNamePrefix,
            Set<String> existingNames, List<CompletionItem> items) {
        List<CompletionItem> variableItems = variableScope.getDeclaredVariables().values().stream().filter(variable -> {

            String variableName = variable.getName();
            // overloads can cause duplicates
            if (variableName.startsWith(memberNamePrefix) && !existingNames.contains(variableName)) {
                existingNames.add(variableName);
                return true;
            }
            return false;
        }).map(variable -> {
            CompletionItem item = new CompletionItem();
            item.setLabel(variable.getName());
            item.setKind(GroovyLanguageUtils.astNodeToCompletionItemKind((ASTNode) variable));
            return item;
        }).collect(Collectors.toList());
        items.addAll(variableItems);
    }

    private static void populateGroovyItemsFromScope(ASTNode node, String namePrefix, List<CompletionItem> items,
            Range groovyScriptRange, GroovyCompilationResult groovyCompilationResult) {
        Set<String> existingNames = new HashSet<>();
        ASTNode current = node;
        while (current != null) {
            if (current instanceof ClassNode) {
                ClassNode classNode = (ClassNode) current;
                populateGroovyItemsFromPropertiesAndFields(classNode.getProperties(), classNode.getFields(), namePrefix,
                        existingNames, items);
                populateGroovyItemsFromMethods(classNode.getMethods(), namePrefix, existingNames, items);
            } else if (current instanceof MethodNode) {
                MethodNode methodNode = (MethodNode) current;
                populateGroovyItemsFromVariableScope(methodNode.getVariableScope(), namePrefix, existingNames, items);
            } else if (current instanceof BlockStatement) {
                BlockStatement block = (BlockStatement) current;
                populateGroovyItemsFromVariableScope(block.getVariableScope(), namePrefix, existingNames, items);
            }
            current = groovyCompilationResult.astVisitor.getParent(current);
        }
        populateGroovyClasses(node, namePrefix, existingNames, items, groovyScriptRange, groovyCompilationResult);
    }

    private static void populateGroovyClasses(ASTNode offsetNode, String namePrefix, Set<String> existingNames,
            List<CompletionItem> items, Range groovyScriptRange, GroovyCompilationResult groovyCompilationResult) {
        Range addImportRange = GroovyASTUtils.findAddImportRange(offsetNode, groovyCompilationResult.astVisitor,
                groovyScriptRange);

        ModuleNode enclosingModule = groovyCompilationResult.astVisitor.module;
        String enclosingPackageName = enclosingModule.getPackageName();
        List<String> importNames = enclosingModule.getImports().stream().map(importNode -> importNode.getClassName())
                .collect(Collectors.toList());

        List<CompletionItem> localClassItems = groovyCompilationResult.astVisitor.getClassNodes().stream()
                .filter(classNode -> {
                    String classNameWithoutPackage = classNode.getNameWithoutPackage();
                    String className = classNode.getName();
                    if (classNameWithoutPackage.startsWith(namePrefix) && !existingNames.contains(className)) {
                        existingNames.add(className);
                        return true;
                    }
                    return false;
                }).map(classNode -> {
                    String className = classNode.getName();
                    String packageName = classNode.getPackageName();
                    CompletionItem item = new CompletionItem();
                    item.setLabel(classNode.getNameWithoutPackage());
                    item.setKind(GroovyLanguageUtils.astNodeToCompletionItemKind(classNode));
                    item.setDetail(packageName);
                    if (packageName != null && !packageName.equals(enclosingPackageName)
                            && !importNames.contains(className)) {
                        List<TextEdit> additionalTextEdits = new ArrayList<>();
                        TextEdit addImportEdit = createGroovyAddImportTextEdit(className, addImportRange);
                        additionalTextEdits.add(addImportEdit);
                        item.setAdditionalTextEdits(additionalTextEdits);
                    }
                    return item;
                }).collect(Collectors.toList());
        items.addAll(localClassItems);

        ScanResult scanResult = scanClassesForGroovy(groovyCompilationResult);
        if (scanResult == null) {
            return;
        }
        List<ClassInfo> classes = scanResult.getAllClasses();

        List<CompletionItem> classItems = classes.stream().filter(classInfo -> {
            String className = classInfo.getName();
            String classNameWithoutPackage = classInfo.getSimpleName();
            if (classNameWithoutPackage.startsWith(namePrefix) && !existingNames.contains(className)) {
                existingNames.add(className);
                return true;
            }
            return false;
        }).map(classInfo -> {
            String className = classInfo.getName();
            String packageName = classInfo.getPackageName();
            CompletionItem item = new CompletionItem();
            item.setLabel(classInfo.getSimpleName());
            item.setDetail(packageName);
            item.setKind(groovyClassInfoToCompletionItemKind(classInfo));
            // Also make sure proposed import will not conflict with already imported
            // groovy/moca classes.
            if (packageName != null && !packageName.equals(enclosingPackageName) && !importNames.contains(className)
                    && !GroovyLanguageUtils.importIsContainedInDefaultGroovyImports(className)) {
                List<TextEdit> additionalTextEdits = new ArrayList<>();
                TextEdit addImportEdit = createGroovyAddImportTextEdit(className, addImportRange);
                additionalTextEdits.add(addImportEdit);
                item.setAdditionalTextEdits(additionalTextEdits);
            }
            return item;
        }).collect(Collectors.toList());
        items.addAll(classItems);
    }

    private static String getGroovyMemberName(String memberName, Range range, Position position) {
        if (position.getLine() == range.getStart().getLine()
                && position.getCharacter() > range.getStart().getCharacter()) {
            int length = position.getCharacter() - range.getStart().getCharacter();
            if (length > 0 && length <= memberName.length()) {
                return memberName.substring(0, length).trim();
            }
        }
        return "";
    }

    private static CompletionItemKind groovyClassInfoToCompletionItemKind(ClassInfo classInfo) {
        if (classInfo.isInterface()) {
            return CompletionItemKind.Interface;
        }
        if (classInfo.isEnum()) {
            return CompletionItemKind.Enum;
        }
        return CompletionItemKind.Class;
    }

    private static TextEdit createGroovyAddImportTextEdit(String className, Range range) {
        TextEdit edit = new TextEdit();
        StringBuilder builder = new StringBuilder();
        builder.append("import ");
        builder.append(className);
        builder.append("\n");
        edit.setNewText(builder.toString());
        edit.setRange(range);
        return edit;
    }

    private static ScanResult scanClassesForGroovy(GroovyCompilationResult groovyCompilationResult) {
        try {
            return new ClassGraph().overrideClassLoaders(groovyCompilationResult.compilationUnit.getClassLoader())
                    .enableClassInfo().enableSystemJarsAndModules().scan();
        } catch (ClassGraphException e) {
        }
        return null;
    }

}