package com.github.mrglassdanny.mocalanguageserver.services.completion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCommandArgument;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaFunction;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.MocaSqlFunction;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.Table;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.TableColumn;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.TableIndex;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Common_table_expressionContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.SubqueryContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaTokenUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

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
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.MarkupKind;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassGraphException;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.PackageInfo;
import io.github.classgraph.ScanResult;

public class MocaCompilationServiceCompletionProvider {

    public static CompletableFuture<Either<List<CompletionItem>, CompletionList>> provideCompletion(Position position,
            MocaLanguageContext mocaLanguageContext) {

        List<CompletionItem> items = new ArrayList<>();

        switch (mocaLanguageContext.id) {
            case Moca:

                // Validate compilation result.
                if (MocaServices.mocaCompilationResult == null) {
                    // Can assume user wants commands.
                    populateMocaCommands(items);
                    return CompletableFuture.completedFuture(Either.forLeft(items));
                }

                // Now, we need to see where we are in token list based on the position that was
                // passed in.
                int curMocaTokenIdx = MocaLanguageUtils.getMocaTokenIndexAtPosition(position,
                        MocaServices.mocaCompilationResult);

                // Validate we have a valid index.
                if (curMocaTokenIdx == -1) {
                    // Can assume user wants commands.
                    populateMocaCommands(items);
                    return CompletableFuture.completedFuture(Either.forLeft(items));
                }

                // Check if bracket string before we do anything else. If so, return nothing for
                // now.
                org.antlr.v4.runtime.Token potentialBracketStringMocaToken = MocaServices.mocaCompilationResult.mocaTokens
                        .get(curMocaTokenIdx);
                if (potentialBracketStringMocaToken != null
                        && (potentialBracketStringMocaToken.getType() == MocaLexer.SINGLE_BRACKET_STRING
                                || potentialBracketStringMocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING)) {
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                // Check if the word we are typing resembles "where".
                // If so, we want nothing for now.
                String curWord = PositionUtils.getWordAtPosition(MocaServices.mocaCompilationResult.script, position,
                        "([a-zA-Z_0-9.])");
                boolean matchesWhere = curWord.matches("(?i)\\b(where|wher|whe|wh|w)\\b");
                if (matchesWhere) {
                    // Return nothing for now.
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                // Now we are just going to look backward until we find something that we know
                // what to do with.
                for (int i = curMocaTokenIdx; i >= 0; i--) {
                    org.antlr.v4.runtime.Token curMocaToken = MocaServices.mocaCompilationResult.mocaTokens.get(i);
                    switch (curMocaToken.getType()) {
                        case MocaLexer.WHERE:
                            // Do not look for AND -- we know that we want args here.

                            // Get verb noun clause current moca token is in.
                            StringBuilder verbNounClause = null;
                            boolean foundTokenMatch = false;
                            for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry : MocaServices.mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                                    .entrySet()) {

                                // We have a WHERE token match, therefore we know that the token prior to our
                                // current token is part of a verb noun clause. All we need to do is get that
                                // token and figure out what the verb noun clause is. Unfortunatley, we do not
                                // have an easy way of just doing a token lookup in our verb noun clause map.
                                // So, that means we need to go through each entry in the map and find the token
                                // that we think corresponds to the token right before where we currently
                                // are(WHERE).

                                for (org.antlr.v4.runtime.Token verbNounClauseToken : entry.getValue()) {

                                    // Idea here is that it is extremely unlikely that the stop index of the verb
                                    // noun clause token we are checking will not be within 5 characters of our
                                    // current token's start. Also, the verb noun clause token's start index needs
                                    // to be less than our current token index.
                                    if (((MocaTokenUtils.getAdjustedMocaTokenStopIndex(
                                            verbNounClauseToken.getStopIndex()) >= curMocaToken.getStartIndex() - 5
                                            && verbNounClauseToken.getStartIndex() <= curMocaToken.getStartIndex()))) {
                                        verbNounClause = entry.getKey();
                                        foundTokenMatch = true;
                                        break;
                                    }
                                }
                                if (foundTokenMatch) {
                                    break;
                                }
                            }
                            // Now we can get the verb noun clause's data from our distinct commands list!
                            if (verbNounClause != null) {
                                if (MocaServices.mocaCache.distinctCommands.contains(verbNounClause.toString())) {

                                    // HACK - getting the first letter typed for command arg population; see
                                    // function for more info.
                                    char firstTypedLetter = PositionUtils.getCharacterAtPosition(
                                            MocaServices.mocaCompilationResult.script,
                                            new Position(position.getLine(), position.getCharacter() - 1));
                                    populateMocaCommandArguments(verbNounClause.toString(), items, firstTypedLetter);
                                    // Also populate functions.
                                    populateMocaFunctions(items);
                                    return CompletableFuture.completedFuture(Either.forLeft(items));
                                }
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
                // Just return moca commands/functions if we get here.
                populateMocaCommands(items);
                populateMocaFunctions(items);
                return CompletableFuture.completedFuture(Either.forLeft(items));
            case MocaSql:

                MocaSqlCompilationResult mocaSqlCompilationResult = MocaServices.mocaCompilationResult.mocaSqlCompilationResults
                        .get(mocaLanguageContext.compilationResultIdx);

                // If we do not have compilation result, we need to quit now.
                if (mocaSqlCompilationResult != null) {

                    // Checking to see if we pressed '.' - which in an mocasql context would mean
                    // that we are looking for table columns.
                    if (PositionUtils.getCharacterAtPosition(MocaServices.mocaCompilationResult.script,
                            new Position(position.getLine(), position.getCharacter() - 1)) == '.'
                            || PositionUtils.getCharacterAtPosition(MocaServices.mocaCompilationResult.script,
                                    new Position(position.getLine(), position.getCharacter() - 2)) == '.') {

                        // Get word on left of '.'.
                        String word = PositionUtils.getWordAtPosition(MocaServices.mocaCompilationResult.script,
                                new Position(position.getLine(), position.getCharacter() - 2), "([a-zA-Z_0-9])");
                        if (word != null) {
                            // Make sure case sensitivity will not get in the way.
                            String lowerCaseWord = word.toLowerCase();

                            // Now we need to determine if we are dealing with an alias, a table, a
                            // subquery, or a CTE.
                            populateMocaSqlColumnsFromTableName(lowerCaseWord, null, true, items);

                            // Try table indexes as well.
                            populateMocaSqlIndexesFromTableName(lowerCaseWord, null,
                                    mocaSqlCompilationResult.mocaSqlParseTreeListener, items);

                            if (items.isEmpty()) { // Empty - must be alias, subquery, or CTE.

                                // Checking if table is aliased, is subquery, or is CTE.
                                if (mocaSqlCompilationResult.mocaSqlParseTreeListener.tableAliasNames
                                        .containsKey(lowerCaseWord)) {

                                    String aliasedTableName = mocaSqlCompilationResult.mocaSqlParseTreeListener.tableAliasNames
                                            .get(lowerCaseWord);

                                    populateMocaSqlColumnsFromTableName(aliasedTableName, lowerCaseWord, true, items);

                                    // Try table indexes for alias as well.
                                    populateMocaSqlIndexesFromTableName(aliasedTableName, lowerCaseWord,
                                            mocaSqlCompilationResult.mocaSqlParseTreeListener, items);
                                } else if (mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries
                                        .containsKey(lowerCaseWord)) {
                                    populateMocaSqlColumnsFromSubquery(
                                            mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueryColumns.get(
                                                    mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries
                                                            .get(lowerCaseWord)),
                                            items);
                                } else if (mocaSqlCompilationResult.mocaSqlParseTreeListener.ctes
                                        .containsKey(lowerCaseWord)) {
                                    populateMocaSqlColumnsFromCTE(
                                            mocaSqlCompilationResult.mocaSqlParseTreeListener.cteColumns.get(
                                                    mocaSqlCompilationResult.mocaSqlParseTreeListener.ctes
                                                            .get(lowerCaseWord)),
                                            items);
                                }
                            }
                        }

                    } else {

                        // Let's check how many tables there are in script. If there is just 1, we will
                        // get the columns for it.
                        if (mocaSqlCompilationResult.mocaSqlParseTreeListener.tableTokens.size() == 1) {
                            String tableName = mocaSqlCompilationResult.mocaSqlParseTreeListener.tableTokens.get(0)
                                    .getText();
                            // Check if it has been aliased.
                            if (mocaSqlCompilationResult.mocaSqlParseTreeListener.tableAliasNames
                                    .containsValue(tableName)) {
                                for (Map.Entry<String, String> entry : mocaSqlCompilationResult.mocaSqlParseTreeListener.tableAliasNames
                                        .entrySet()) {
                                    if (entry.getValue().compareTo(tableName) == 0) {
                                        populateMocaSqlColumnsFromTableName(tableName, entry.getKey(), false, items);
                                        break;
                                    }
                                }
                            } else {
                                populateMocaSqlColumnsFromTableName(tableName, null, false, items);
                            }

                            // If there is a single anonymous subquery.
                            populateMocaSqlColumnsFromSubquery(
                                    mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueryColumns
                                            .get(mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries
                                                    .get(MocaSqlParseTreeListener.ANONYMOUS_SUBQUERY)),
                                    items);
                        }

                        // Get tables/views from database.
                        populateMocaSqlTables(items);
                        // Also get any other aliased entities in script.
                        populateMocaSqlTableAliasNames(
                                mocaSqlCompilationResult.mocaSqlParseTreeListener.tableAliasNames, items);
                        populateMocaSqlSubqueryNames(mocaSqlCompilationResult.mocaSqlParseTreeListener.subqueries,
                                items);
                        populateMocaSqlCTENames(mocaSqlCompilationResult.mocaSqlParseTreeListener.ctes,
                                items);

                        // Get mocasql functions as well.
                        populateMocaSqlFunctions(items);

                    }

                }

                return CompletableFuture.completedFuture(Either.forLeft(items));
            case Groovy:

                GroovyCompilationResult groovyCompilationResult = MocaServices.mocaCompilationResult.groovyCompilationResults
                        .get(mocaLanguageContext.compilationResultIdx);

                if (groovyCompilationResult.astVisitor == null) {
                    // this shouldn't happen, but let's avoid an exception if something
                    // goes terribly wrong.
                    return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                }

                // Catching NoClassDefFoundError -- this isn't really best practice, but it
                // doesn't hurt anything and I would rather give the user a more concise error
                // message than what is thrown without this try/catch.
                try {
                    ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                            position.getCharacter(), groovyCompilationResult.range);
                    if (offsetNode == null) {
                        return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
                    }

                    ASTNode parentNode = groovyCompilationResult.astVisitor.getParent(offsetNode);

                    if (offsetNode instanceof PropertyExpression) {
                        populateGroovyItemsFromPropertyExpression((PropertyExpression) offsetNode, position, items,
                                groovyCompilationResult.range, groovyCompilationResult);
                    } else if (parentNode instanceof PropertyExpression) {
                        populateGroovyItemsFromPropertyExpression((PropertyExpression) parentNode, position, items,
                                groovyCompilationResult.range, groovyCompilationResult);
                    } else if (offsetNode instanceof MethodCallExpression) {
                        populateGroovyItemsFromMethodCallExpression((MethodCallExpression) offsetNode, position, items,
                                groovyCompilationResult.range, groovyCompilationResult);
                    } else if (offsetNode instanceof ConstructorCallExpression) {
                        populateGroovyItemsFromConstructorCallExpression((ConstructorCallExpression) offsetNode,
                                position, items, groovyCompilationResult.range, groovyCompilationResult);
                    } else if (parentNode instanceof MethodCallExpression) {
                        populateGroovyItemsFromMethodCallExpression((MethodCallExpression) parentNode, position, items,
                                groovyCompilationResult.range, groovyCompilationResult);
                    } else if (offsetNode instanceof VariableExpression) {
                        populateGroovyItemsFromVariableExpression((VariableExpression) offsetNode, position, items,
                                groovyCompilationResult.range, groovyCompilationResult);
                    } else if (offsetNode instanceof ImportNode) {
                        populateGroovyItemsFromImportNode((ImportNode) offsetNode, position, items,
                                groovyCompilationResult.range, groovyCompilationResult);
                    } else if (offsetNode instanceof MethodNode) {
                        populateGroovyItemsFromScope(offsetNode, "", items, groovyCompilationResult.range,
                                groovyCompilationResult);
                    } else if (offsetNode instanceof Statement) {
                        populateGroovyItemsFromScope(offsetNode, "", items, groovyCompilationResult.range,
                                groovyCompilationResult);
                    }
                } catch (NoClassDefFoundError noClassDefFoundError) {
                    MocaServices.logErrorToLanguageClient(String.format("Class '%s' not linked in groovyclasspath",
                            noClassDefFoundError.getMessage()));
                }
                return CompletableFuture.completedFuture(Either.forLeft(items));
        }
        return CompletableFuture.completedFuture(Either.forLeft(items));
    }

    // MOCA.
    private static void populateMocaCommands(List<CompletionItem> items) {

        for (Map.Entry<String, ArrayList<MocaCommand>> entry : MocaServices.mocaCache.commands.entrySet()) {
            CompletionItem item = new CompletionItem(entry.getKey());
            item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN,
                    MocaCommand.getMarkdownStr(entry.getKey(), entry.getValue())));
            item.setKind(CompletionItemKind.Function);
            items.add(item);
        }

    }

    private static void populateMocaCommandArguments(String mocaCommandName, List<CompletionItem> items,
            char firstTypedLetter) {

        ArrayList<MocaCommandArgument> cmdArgs = MocaServices.mocaCache.commandArguments.get(mocaCommandName);
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
                item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, arg.getMarkdownStr()));
                // HACK - we want the user typing the args to see all possiblities. Other
                // clients
                // do this by using the space character as a trigger character.
                // Instead of doing that, we will pre-pend the first letter the user types in
                // the filter text of the completion item. This will populate all
                // args regardless of what the user types.
                item.setFilterText(firstTypedLetter + arg.argnam);
                item.setKind(CompletionItemKind.Field);
                items.add(item);

                // NOTE: argument alias/alternate names will be included as distinct completion
                // items.
                if (arg.altnam != null && !arg.altnam.isEmpty()) {
                    CompletionItem altItem = new CompletionItem(arg.altnam);
                    altItem.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, arg.getAlternateNameMarkdownStr()));
                    // HACK - same as ^.
                    altItem.setFilterText(firstTypedLetter + arg.altnam);
                    altItem.setKind(CompletionItemKind.EnumMember);
                    items.add(altItem);
                }
            }
        }

    }

    private static void populateMocaFunctions(List<CompletionItem> items) {
        for (Map.Entry<String, MocaFunction> entry : MocaServices.mocaCache.functions.entrySet()) {
            MocaFunction mocaFunction = entry.getValue();
            CompletionItem item = new CompletionItem(mocaFunction.name);
            item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, mocaFunction.getMarkdownStr()));
            item.setKind(CompletionItemKind.Function);
            items.add(item);
        }
    }

    // MOCA SQL.
    // Includes views.
    private static void populateMocaSqlTables(List<CompletionItem> items) {

        for (Map.Entry<String, Table> tableEntry : MocaServices.mocaCache.mocaSqlCache.tables.entrySet()) {
            Table tbl = tableEntry.getValue();
            CompletionItem item = new CompletionItem(tbl.table_name);
            item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, tbl.getMarkdownStr(false)));
            item.setKind(CompletionItemKind.Struct);
            items.add(item);
        }

        for (Map.Entry<String, Table> viewEntry : MocaServices.mocaCache.mocaSqlCache.views.entrySet()) {
            Table view = viewEntry.getValue();
            CompletionItem item = new CompletionItem(view.table_name);
            item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, view.getMarkdownStr(true)));
            item.setKind(CompletionItemKind.Struct);
            items.add(item);
        }
    }

    private static void populateMocaSqlTableAliasNames(HashMap<String, String> tableAliasNames,
            List<CompletionItem> items) {

        if (tableAliasNames == null) {
            return;
        }

        for (Map.Entry<String, String> entry : tableAliasNames.entrySet()) {
            CompletionItem item = new CompletionItem(entry.getKey());
            item.setDocumentation(
                    new MarkupContent(MarkupKind.MARKDOWN, Table.getMarkdownStrForAlias(entry.getValue())));
            item.setKind(CompletionItemKind.Struct);
            items.add(item);
        }
    }

    private static void populateMocaSqlSubqueryNames(HashMap<String, SubqueryContext> subqueries,
            List<CompletionItem> items) {

        if (subqueries == null) {
            return;
        }

        for (String subqueryName : subqueries.keySet()) {
            CompletionItem item = new CompletionItem(subqueryName);
            item.setDocumentation(
                    new MarkupContent(MarkupKind.MARKDOWN, Table.getMarkdownStrForSubquery(subqueryName)));
            item.setKind(CompletionItemKind.Class);
            items.add(item);
        }
    }

    private static void populateMocaSqlCTENames(HashMap<String, Common_table_expressionContext> ctes,
            List<CompletionItem> items) {

        if (ctes == null) {
            return;
        }

        for (String cteName : ctes.keySet()) {
            CompletionItem item = new CompletionItem(cteName);
            item.setDocumentation(
                    new MarkupContent(MarkupKind.MARKDOWN, Table.getMarkdownStrForCTE(cteName)));
            item.setKind(CompletionItemKind.Class);
            items.add(item);
        }
    }

    private static void populateMocaSqlIndexesFromTableName(String tableName, String tableAliasName,
            MocaSqlParseTreeListener mocaSqlParseTreeListener, List<CompletionItem> items) {

        ArrayList<TableIndex> indexes = MocaServices.mocaCache.mocaSqlCache.getIndexesForTable(tableName);

        // Could be null.
        if (indexes == null) {
            return;
        }

        String completionItemTableName = (tableAliasName == null ? tableName : tableAliasName);

        // First we will create WHERE completion items.
        for (TableIndex index : indexes) {

            CompletionItem item = new CompletionItem(String.format("%s", index.index_name));
            String documentationStr = String.format("index **%s**\n\n", index.index_name);
            for (String columnName : index.columnNames) {
                documentationStr += String.format("* %s\n", columnName);
            }
            item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, documentationStr));
            item.setKind(CompletionItemKind.Constant);
            String insertText = "";
            for (String columnName : index.columnNames) {
                insertText += String.format("%s.%s = '' and ", completionItemTableName, columnName);
            }

            // Remove first "table." since user already typed it.
            insertText = insertText.substring((completionItemTableName.length() + 1), insertText.length());

            // Remove last " and ".
            insertText = insertText.substring(0, insertText.length() - " and ".length());

            item.setInsertText(insertText);
            items.add(item);
        }

        // Now let's create JOIN completion items.

        // Since table aliases and table tokens are stored separately, it
        // is possible that a table's index info gets added twice.
        // Therefore, we will use this list, `visitedTableNames`, to keep track of the
        // table names that we come across so that we do not accidentally add
        // duplicates.
        ArrayList<String> visitedTableNames = new ArrayList<>();

        // Go through aliases first.
        for (Map.Entry<String, String> entry : mocaSqlParseTreeListener.tableAliasNames.entrySet()) {

            String otherTableAliasName = entry.getKey();
            String otherTableName = entry.getValue();
            visitedTableNames.add(otherTableName);

            // Make sure we are not looking at ourself.
            if (otherTableAliasName.compareToIgnoreCase(completionItemTableName) != 0) {

                ArrayList<TableIndex> indexesForTableAlias = MocaServices.mocaCache.mocaSqlCache
                        .getIndexesForTable(otherTableName);

                if (indexesForTableAlias != null) {

                    for (TableIndex index : indexes) {
                        for (TableIndex indexForTableAlias : indexesForTableAlias) {

                            ArrayList<String> matchedColumnNames = new ArrayList<>();

                            for (String columnName : index.columnNames) {
                                for (String columnNameForTableTokenIndex : indexForTableAlias.columnNames) {

                                    if (columnName.compareTo(columnNameForTableTokenIndex) == 0) {
                                        matchedColumnNames.add(columnName);
                                        break;
                                    }
                                }
                            }

                            // Now add completion item.
                            // NOTE: only want to add completion item for indexes if at least one of the
                            // indexes is fully represented -- meaning that all the columns for at least one
                            // of the indexes must have matched the other index's columns. Otherwise, it is
                            // not worth adding a completion item since neither of the indexes would be
                            // complete.
                            if (matchedColumnNames.size() == index.columnNames.length
                                    || matchedColumnNames.size() == indexForTableAlias.columnNames.length) {
                                CompletionItem item = new CompletionItem(String.format("%s = %s.%s", index.index_name,
                                        otherTableAliasName, indexForTableAlias.index_name));
                                String documentationStr = String.format("join **%s** to **%s**\n\n",
                                        completionItemTableName, otherTableAliasName);
                                for (String columnName : matchedColumnNames) {
                                    documentationStr += String.format("* %s\n", columnName);
                                }
                                item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, documentationStr));
                                item.setKind(CompletionItemKind.Enum);
                                String insertText = "";
                                for (String columnName : matchedColumnNames) {
                                    insertText += String.format("%s.%s = %s.%s and ", completionItemTableName,
                                            columnName, otherTableAliasName, columnName);
                                }

                                // Remove first "table." since user already typed it.
                                insertText = insertText.substring((completionItemTableName.length() + 1),
                                        insertText.length());

                                // Remove last " and ".
                                insertText = insertText.substring(0, insertText.length() - " and ".length());

                                item.setInsertText(insertText);
                                items.add(item);
                            }
                        }
                    }
                }
            }
        }

        // Now table tokens.
        for (org.antlr.v4.runtime.Token tableToken : mocaSqlParseTreeListener.tableTokens) {

            String tableTokenText = tableToken.getText();

            // Check if table name has been visited. If so, we need to delete the element
            // and move onto the next table token. Deleting the element will ensure that we
            // do not accidentally fail to visit a non-aliased table.
            if (visitedTableNames.contains(tableTokenText)) {
                visitedTableNames.remove(tableTokenText);
            } else {

                // Now add to visited.
                visitedTableNames.add(tableTokenText);

                // Make sure we are not looking at ourself.
                if (tableTokenText.compareToIgnoreCase(tableName) != 0) {

                    ArrayList<TableIndex> indexesForTableToken = MocaServices.mocaCache.mocaSqlCache
                            .getIndexesForTable(tableTokenText);

                    if (indexesForTableToken != null) {

                        for (TableIndex index : indexes) {
                            for (TableIndex indexForTableToken : indexesForTableToken) {

                                ArrayList<String> matchedColumnNames = new ArrayList<>();

                                for (String columnName : index.columnNames) {
                                    for (String columnNameForTableTokenIndex : indexForTableToken.columnNames) {
                                        if (columnName.compareTo(columnNameForTableTokenIndex) == 0) {
                                            matchedColumnNames.add(columnName);
                                            break;
                                        }
                                    }
                                }

                                // Now add completion item.
                                // NOTE: only want to add completion item for indexes if at least one of the
                                // indexes is fully represented -- meaning that all the columns for at least one
                                // of the indexes must have matched the other index's columns. Otherwise, it is
                                // not worth adding a completion item since neither of the indexes would be
                                // complete.
                                if (matchedColumnNames.size() == index.columnNames.length
                                        || matchedColumnNames.size() == indexForTableToken.columnNames.length) {
                                    CompletionItem item = new CompletionItem(String.format("%s = %s.%s",
                                            index.index_name, tableTokenText, indexForTableToken.index_name));
                                    String documentationStr = String.format("join **%s** to **%s**\n\n",
                                            completionItemTableName, tableTokenText);
                                    for (String columnName : matchedColumnNames) {
                                        documentationStr += String.format("* %s\n", columnName);
                                    }
                                    item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, documentationStr));
                                    item.setKind(CompletionItemKind.Enum);
                                    String insertText = "";
                                    for (String columnName : matchedColumnNames) {
                                        insertText += String.format("%s.%s = %s.%s and ", completionItemTableName,
                                                columnName, tableTokenText, columnName);
                                    }

                                    // Remove first "table." since user already typed it.
                                    insertText = insertText.substring((completionItemTableName.length() + 1),
                                            insertText.length());

                                    // Remove last " and ".
                                    insertText = insertText.substring(0, insertText.length() - " and ".length());

                                    item.setInsertText(insertText);
                                    items.add(item);
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    private static void populateMocaSqlColumnsFromTableName(String tableName, String aliasName,
            boolean excludeColPrefixForFirstForAllCols, List<CompletionItem> items) {
        ArrayList<TableColumn> cols = MocaServices.mocaCache.mocaSqlCache.getColumnsForTable(tableName);

        // Could be null.
        if (cols == null) {
            return;
        }

        // Add an 'all columns' completion item, which will insert all the columns in
        // the table.
        CompletionItem allColItem = new CompletionItem("_all_columns");
        allColItem.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN,
                String.format("insert all **%s** columns", (aliasName == null ? tableName : aliasName))));
        allColItem.setKind(CompletionItemKind.Constant);
        String insertText = "";
        String colPrefix = (aliasName != null && !aliasName.isEmpty() ? aliasName : tableName) + ".";
        for (TableColumn col : cols) {
            insertText += colPrefix + col.column_name + ", ";
        }
        // Remove last ", ":
        insertText = insertText.substring(0, insertText.length() - ", ".length());
        // If we need to exclude col prefix via boolean passed in, do so now.
        if (excludeColPrefixForFirstForAllCols) {
            insertText = insertText.substring(colPrefix.length(), insertText.length());
        }
        allColItem.setInsertText(insertText);
        items.add(allColItem);

        // Now add table columns.
        for (TableColumn col : cols) {
            CompletionItem item = new CompletionItem(col.column_name);
            item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, col.getMarkdownStr()));
            item.setKind(CompletionItemKind.Field);
            items.add(item);
        }
    }

    private static void populateMocaSqlColumnsFromSubquery(ArrayList<org.antlr.v4.runtime.Token> columnTokens,
            List<CompletionItem> items) {

        if (columnTokens == null) {
            return;
        }

        // Could potentially be duplicates if UNION is used.
        ArrayList<String> columnsAlreadyAdded = new ArrayList<>();

        for (org.antlr.v4.runtime.Token columnToken : columnTokens) {
            String columnName = columnToken.getText();
            if (!columnsAlreadyAdded.contains(columnName)) {
                columnsAlreadyAdded.add(columnName);
                CompletionItem item = new CompletionItem(columnName);
                item.setDocumentation("from subquery");
                item.setKind(CompletionItemKind.Field);
                items.add(item);
            }

        }
    }

    private static void populateMocaSqlColumnsFromCTE(ArrayList<org.antlr.v4.runtime.Token> columnTokens,
            List<CompletionItem> items) {

        if (columnTokens == null) {
            return;
        }

        // Could potentially be duplicates if UNION is used.
        ArrayList<String> columnsAlreadyAdded = new ArrayList<>();

        for (org.antlr.v4.runtime.Token columnToken : columnTokens) {
            String columnName = columnToken.getText();
            if (!columnsAlreadyAdded.contains(columnName)) {
                columnsAlreadyAdded.add(columnName);
                CompletionItem item = new CompletionItem(columnName);
                item.setDocumentation("from CTE");
                item.setKind(CompletionItemKind.Field);
                items.add(item);
            }

        }
    }

    private static void populateMocaSqlFunctions(List<CompletionItem> items) {
        for (Map.Entry<String, MocaSqlFunction> entry : MocaServices.mocaCache.mocaSqlCache.functions.entrySet()) {
            MocaSqlFunction function = entry.getValue();
            CompletionItem item = new CompletionItem(function.name);
            item.setDocumentation(new MarkupContent(MarkupKind.MARKDOWN, function.getMarkdownStr()));
            item.setKind(CompletionItemKind.Function);
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
