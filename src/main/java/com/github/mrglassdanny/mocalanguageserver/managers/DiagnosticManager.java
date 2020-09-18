package com.github.mrglassdanny.mocalanguageserver.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.TableColumn;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxError;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlSyntaxError;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util.MocaSqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaTokenUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Ranges;

import org.antlr.v4.runtime.Token;
import org.codehaus.groovy.control.messages.ExceptionMessage;
import org.codehaus.groovy.control.messages.Message;
import org.codehaus.groovy.control.messages.SyntaxErrorMessage;
import org.codehaus.groovy.syntax.SyntaxException;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.services.LanguageClient;

public class DiagnosticManager {

    private static final String MOCA_SYNTAX_ERROR = "MOCA: line %d:%d %s";
    private static final String MOCA_COMMAND_DOES_NOT_EXIST_WARNING = "MOCA: Command '%s' does not exist";
    private static final String MOCASQL_SYNTAX_ERROR = "SQL: %s";
    private static final String MOCASQL_TABLE_DOES_NOT_EXIST_WARNING = "SQL: Table/View/Subquery '%s' does not exist";
    private static final String MOCASQL_COLUMN_DOES_NOT_EXIST_ON_TABLE_OR_VIEW_WARNING = "SQL: Column '%s' does not exist on Table/View '%s'";
    private static final String MOCASQL_COLUMN_DOES_NOT_EXIST_ON_SUBQUERY_WARNING = "SQL: Column '%s' does not exist on Subquery '%s'";
    private static final String MOCASQL_COLUMN_DOES_NOT_EXIST_ON_ANON_SUBQUERY_WARNING = "SQL: Column '%s' does not exist on anonymous Subquery";
    private static final String MOCASQL_MULTIPLE_TABLES_FOR_COLUMN_WARNING = "SQL: Multiple tables detected; please specify table for column '%s'";
    private static final String GROOVY_MESSAGE = "GROOVY: %s";
    private static final String GROOVY_ERROR = "GROOVY: %s";

    private static final String[] MOCASQL_RESERVED_COLUMN_NAMES = { "rownum", "sysdate" };

    public static void streamAll(LanguageClient languageClient, String uriStr, String script,
            MocaCompiler mocaCompiler) {

        // Check to see if file extension is marked as read only. If so, do not publish
        // any diagnostics.
        // This will be the case for any files created by command lookup functionality
        // in the client.
        String uriExtStr = uriStr.substring(uriStr.lastIndexOf("."));
        if (uriExtStr.compareToIgnoreCase(".readonly") == 0) {
            return;
        }

        clearDiagnostics(languageClient, uriStr);

        // Make sure nothing we need is null, as exceptions could be thrown.
        if (MocaLanguageServer.currentMocaConnection == null
                || MocaLanguageServer.currentMocaConnection.cache == null) {
            return;
        }

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        diagnostics.addAll(streamErrors(languageClient, uriStr, script, mocaCompiler));
        diagnostics.addAll(streamWarnings(languageClient, uriStr, script, mocaCompiler));
        diagnostics.addAll(streamInformation(languageClient, uriStr, script, mocaCompiler));
        diagnostics.addAll(streamHints(languageClient, uriStr, script, mocaCompiler));

        languageClient.publishDiagnostics(new PublishDiagnosticsParams(uriStr, diagnostics));

    }

    public static void clearDiagnostics(LanguageClient languageClient, String uriStr) {
        languageClient.publishDiagnostics(new PublishDiagnosticsParams(uriStr, new ArrayList<>()));
    }

    public static ArrayList<Diagnostic> streamErrors(LanguageClient languageClient, String uriStr, String script,
            MocaCompiler mocaCompiler) {

        // Clear out all existing dianostics by sending empty list.
        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        // MOCA.
        // Check moca diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocaDiagnosticsEnabled) {
            diagnostics.addAll(handleMocaSyntaxErrors(uriStr, mocaCompiler.currentCompilationResult));
        }

        // SQL.
        // Check mocasql diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocasqlDiagnosticsEnabled) {
            for (int i = 0; i < mocaCompiler.mocaSqlRanges.size(); i++) {
                diagnostics.addAll(handleMocaSqlSyntaxErrors(uriStr,
                        mocaCompiler.currentCompilationResult.mocaSqlCompilationResults.get(i),
                        mocaCompiler.mocaSqlRanges.get(i)));
            }
        }

        // GROOVY.
        // Check groovy diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.groovyDiagnosticsEnabled) {
            for (int i = 0; i < mocaCompiler.groovyRanges.size(); i++) {
                diagnostics.addAll(
                        handleGroovyAll(uriStr, mocaCompiler.currentCompilationResult.groovyCompilationResults.get(i),
                                mocaCompiler.groovyRanges.get(i), languageClient));
            }
        }

        return diagnostics;

    }

    public static ArrayList<Diagnostic> streamWarnings(LanguageClient languageClient, String uriStr, String script,
            MocaCompiler mocaCompiler) {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        // MOCA.
        // Check moca diagnostics and warning diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocaDiagnosticsEnabled
                && MocaLanguageServer.mocaLanguageServerOptions.mocaWarningDiagnosticsEnabled) {
            diagnostics.addAll(handleMocaCommandMayNotExistWarnings(uriStr, script, mocaCompiler));
        }

        // SQL.
        // Check mocasql diagnostics and warning diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocasqlDiagnosticsEnabled
                && MocaLanguageServer.mocaLanguageServerOptions.mocasqlWarningDiagnosticsEnabled) {
            for (int i = 0; i < mocaCompiler.mocaSqlRanges.size(); i++) {
                MocaSqlCompilationResult sqlCompilationResult = mocaCompiler.currentCompilationResult.mocaSqlCompilationResults
                        .get(i);
                Range sqlRange = mocaCompiler.mocaSqlRanges.get(i);
                diagnostics.addAll(handleMocaSqlTableMayNotExistWarnings(uriStr, script,
                        sqlCompilationResult.mocaSqlParseTreeListener, sqlRange));
                diagnostics.addAll(handleMocaSqlColumnsMayNotExistInTableWarnings(uriStr, script,
                        sqlCompilationResult.mocaSqlParseTreeListener, sqlRange));
            }
        }

        return diagnostics;

    }

    public static ArrayList<Diagnostic> streamInformation(LanguageClient languageClient, String uriStr, String script,
            MocaCompiler mocaCompiler) {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();
        diagnostics.addAll(handleTodos(uriStr, script, mocaCompiler));
        return diagnostics;

    }

    public static ArrayList<Diagnostic> streamHints(LanguageClient languageClient, String uriStr, String script,
            MocaCompiler mocaCompiler) {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        return diagnostics;

    }

    // MOCA.
    private static ArrayList<Diagnostic> handleMocaSyntaxErrors(String uriStr,
            MocaCompilationResult compilationResult) {

        if (!compilationResult.hasMocaErrors()) {
            return new ArrayList<>();
        } else {
            ArrayList<Diagnostic> diagnostics = new ArrayList<>();

            for (MocaSyntaxError mocaSyntaxError : compilationResult.mocaSyntaxErrorListener.mocaSyntaxErrors) {
                Position pos = new Position(mocaSyntaxError.line, mocaSyntaxError.charPositionInLine);
                Range range = new Range(pos, pos);
                Diagnostic diagnostic = new Diagnostic();
                diagnostic.setRange(range);
                diagnostic.setSeverity(DiagnosticSeverity.Error);
                diagnostic.setMessage(String.format(MOCA_SYNTAX_ERROR, mocaSyntaxError.line,
                        mocaSyntaxError.charPositionInLine, mocaSyntaxError.msg));
                diagnostics.add(diagnostic);
            }

            return diagnostics;

        }
    }

    private static ArrayList<Diagnostic> handleMocaCommandMayNotExistWarnings(String uriStr, String script,
            MocaCompiler mocaCompiler) {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        // Need to make sure we have a moca ast.
        MocaCompilationResult mocaCompilationResult = mocaCompiler.currentCompilationResult;

        if (mocaCompilationResult == null) {
            // Return empty list.
            return diagnostics;
        }

        // Loop through all verb noun clauses and see if we have any verbNounClauses
        // that do not exist in cache. If so, we will get the range, build the
        // diagnosic, and add it to the list.
        for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry : mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                .entrySet()) {

            StringBuilder verbNounClause = entry.getKey();

            if (!MocaLanguageServer.currentMocaConnection.cache.mocaCache.distinctCommands
                    .contains(verbNounClause.toString())) {

                ArrayList<org.antlr.v4.runtime.Token> mocaTokens = entry.getValue();
                // No need to validate size -- we can assume that we have
                // at least 1 moca token in list.
                org.antlr.v4.runtime.Token beginToken = mocaTokens.get(0);
                org.antlr.v4.runtime.Token endToken = mocaTokens.get(mocaTokens.size() - 1);

                Position beginPos = Positions.getPosition(script, beginToken.getStartIndex());
                Position endPos = Positions.getPosition(script,
                        MocaTokenUtils.getAdjustedMocaTokenStopIndex(endToken.getStopIndex()));

                if (beginPos != null && endPos != null) {
                    Range range = new Range(beginPos, endPos);
                    Diagnostic diagnostic = new Diagnostic();
                    diagnostic.setRange(range);
                    diagnostic.setSeverity(DiagnosticSeverity.Warning);
                    diagnostic.setMessage(String.format(MOCA_COMMAND_DOES_NOT_EXIST_WARNING, verbNounClause));
                    diagnostics.add(diagnostic);
                }
            }
        }

        return diagnostics;
    }

    // MOCASQL.
    private static ArrayList<Diagnostic> handleMocaSqlSyntaxErrors(String uriStr,
            MocaSqlCompilationResult compilationResult, Range sqlScriptRange) {
        if (!compilationResult.hasSqlErrors()) {
            return new ArrayList<Diagnostic>();
        } else {
            // Set diagnostics.
            ArrayList<Diagnostic> diagnostics = new ArrayList<>();

            for (MocaSqlSyntaxError sqlSyntaxError : compilationResult.mocaSqlSyntaxErrorListener.mocaSqlSyntaxErrors) {
                Range range = MocaSqlLanguageUtils.syntaxExceptionToRange(sqlSyntaxError, sqlScriptRange);
                Diagnostic diagnostic = new Diagnostic();
                diagnostic.setRange(range);
                diagnostic.setSeverity(DiagnosticSeverity.Error);
                diagnostic.setMessage(String.format(MOCASQL_SYNTAX_ERROR, sqlSyntaxError.msg));
                diagnostics.add(diagnostic);
            }

            return diagnostics;
        }
    }

    private static ArrayList<Diagnostic> handleMocaSqlTableMayNotExistWarnings(String uriStr, String script,
            MocaSqlParseTreeListener sqlParseTreeListener, Range sqlScriptRange) {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        // Basically we are going to check all tables in the ast against our cache
        // and see if there are an discrepancies.

        for (Token tableToken : sqlParseTreeListener.tableTokens) {

            boolean foundTable = false;

            String tableTokenText = tableToken.getText().toLowerCase();

            // Check tables and views.
            if (MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.tables.containsKey(tableTokenText)
                    || MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.views.containsKey(tableTokenText)) {
                foundTable = true;
            }

            // Check to see if is alias for table name.
            // NOTE: could see goofy stuff if alias is declared elsewhere in parse tree -- a
            // risk I am willing to take!
            if (!foundTable) {
                if (sqlParseTreeListener.aliasedTableNames.containsKey(tableTokenText)) {
                    foundTable = true;
                }
            }

            // Try subqueries.
            if (!foundTable) {
                if (sqlParseTreeListener.subqueries.containsKey(tableTokenText)) {
                    foundTable = true;
                }
            }

            if (!foundTable) {

                Position beginPos = MocaSqlLanguageUtils.createMocaPosition(tableToken.getLine(),
                        tableToken.getCharPositionInLine(), sqlScriptRange);
                Position endPos = MocaSqlLanguageUtils.createMocaPosition(tableToken.getLine(),
                        tableToken.getCharPositionInLine(), sqlScriptRange);

                if (beginPos != null && endPos != null) {
                    Range range = new Range(beginPos, endPos);
                    Diagnostic diagnostic = new Diagnostic();
                    diagnostic.setRange(range);
                    diagnostic.setSeverity(DiagnosticSeverity.Warning);
                    diagnostic.setMessage(String.format(MOCASQL_TABLE_DOES_NOT_EXIST_WARNING, tableTokenText));
                    diagnostics.add(diagnostic);
                }

            }
        }

        return diagnostics;
    }

    private static ArrayList<Diagnostic> handleMocaSqlColumnsMayNotExistInTableWarnings(String uriStr, String script,
            MocaSqlParseTreeListener sqlParseTreeListener, Range sqlScriptRange) {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        for (Map.Entry<String, ArrayList<org.antlr.v4.runtime.Token>> entry : sqlParseTreeListener.columnTokens
                .entrySet()) {

            String tableName = entry.getKey();

            // Before we continue, we need to check if this is an alias for another table.
            if (sqlParseTreeListener.aliasedTableNames.containsKey(tableName)) {
                // Switch to actual table name.
                // NOTE: could see goofy stuff if alias is declared elsewhere in parse tree -- a
                // risk I am willing to take!
                tableName = sqlParseTreeListener.aliasedTableNames.get(tableName);
            }

            if (tableName == null) {
                // Should not be null..
            } else {
                // Analyze table name and see if column(s) exist for it.

                if (tableName.compareTo(MocaSqlParseTreeListener.MULTIPLE_TABLES_DETECTED_FOR_COLUMN) == 0) {

                    // This is bad practice -- return warning to user.

                    for (org.antlr.v4.runtime.Token columnToken : entry.getValue()) {

                        String columnTokenText = columnToken.getText();

                        // Make sure column does not exist in reserved column names array.
                        boolean isReservedColumn = false;
                        for (String reservedColumnName : MOCASQL_RESERVED_COLUMN_NAMES) {
                            if (reservedColumnName.compareToIgnoreCase(columnTokenText) == 0) {
                                isReservedColumn = true;
                                break;
                            }
                        }

                        if (!isReservedColumn) {
                            Position beginPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                    columnToken.getCharPositionInLine(), sqlScriptRange);
                            Position endPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                    columnToken.getCharPositionInLine(), sqlScriptRange);

                            if (beginPos != null && endPos != null) {
                                Range range = new Range(beginPos, endPos);
                                Diagnostic diagnostic = new Diagnostic();
                                diagnostic.setRange(range);
                                diagnostic.setSeverity(DiagnosticSeverity.Warning);
                                diagnostic.setMessage(
                                        String.format(MOCASQL_MULTIPLE_TABLES_FOR_COLUMN_WARNING, columnTokenText));
                                diagnostics.add(diagnostic);
                            }
                        }
                    }

                } else if (tableName.compareTo(MocaSqlParseTreeListener.ANONYMOUS_SUBQUERY) == 0) {

                    // Dealing with anon subquery -- check columns in map for anon subquery key.
                    // NOTE: could see goofy stuff if multiple anonymous subqueries, but that is a
                    // risk I am willing to take!
                    ArrayList<org.antlr.v4.runtime.Token> subqueryColumnTokens = sqlParseTreeListener.subqueryColumns
                            .get(sqlParseTreeListener.subqueries.get(MocaSqlParseTreeListener.ANONYMOUS_SUBQUERY));

                    if (subqueryColumnTokens != null) {
                        for (org.antlr.v4.runtime.Token columnToken : entry.getValue()) {

                            String columnTokenText = columnToken.getText();

                            // Check if column token exists in subquery column token list.
                            // Need to compare token text since objects are likely different instances.
                            boolean foundColumn = false;
                            for (org.antlr.v4.runtime.Token subqueryColumnToken : subqueryColumnTokens) {
                                if (columnTokenText.compareToIgnoreCase(subqueryColumnToken.getText()) == 0) {
                                    foundColumn = true;
                                    break;
                                }
                            }

                            // Make sure column does not exist in reserved column names array.
                            boolean isReservedColumn = false;
                            // Do not check if already found!
                            if (!foundColumn) {
                                for (String reservedColumnName : MOCASQL_RESERVED_COLUMN_NAMES) {
                                    if (reservedColumnName.compareToIgnoreCase(columnTokenText) == 0) {
                                        isReservedColumn = true;
                                        break;
                                    }
                                }
                            }

                            if (!foundColumn && !isReservedColumn) {
                                Position beginPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                        columnToken.getCharPositionInLine(), sqlScriptRange);
                                Position endPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                        columnToken.getCharPositionInLine(), sqlScriptRange);

                                if (beginPos != null && endPos != null) {
                                    Range range = new Range(beginPos, endPos);
                                    Diagnostic diagnostic = new Diagnostic();
                                    diagnostic.setRange(range);
                                    diagnostic.setSeverity(DiagnosticSeverity.Warning);
                                    diagnostic.setMessage(String.format(
                                            MOCASQL_COLUMN_DOES_NOT_EXIST_ON_ANON_SUBQUERY_WARNING, columnTokenText));
                                    diagnostics.add(diagnostic);
                                }
                            }
                        }
                    }
                } else {

                    // Let's see if this table is a subquery.
                    if (sqlParseTreeListener.subqueries.containsKey(tableName)) {

                        // Check columns in here.
                        // NOTE: could see goofy stuff if multiple subqueries of the same name, but that
                        // is a risk I am willing to take!
                        ArrayList<org.antlr.v4.runtime.Token> subqueryColumnTokens = sqlParseTreeListener.subqueryColumns
                                .get(sqlParseTreeListener.subqueries.get(tableName));

                        if (subqueryColumnTokens != null) {
                            for (org.antlr.v4.runtime.Token columnToken : entry.getValue()) {

                                String columnTokenText = columnToken.getText();

                                // Check if column token exists in subquery column token list.
                                // Need to compare token text since objects are likely different instances.
                                boolean foundColumn = false;

                                for (org.antlr.v4.runtime.Token subqueryColumnToken : subqueryColumnTokens) {
                                    if (columnTokenText.compareToIgnoreCase(subqueryColumnToken.getText()) == 0) {
                                        foundColumn = true;
                                        break;
                                    }
                                }

                                // Make sure column does not exist in reserved column names array.
                                boolean isReservedColumn = false;
                                // Do not check if already found!
                                if (!foundColumn) {
                                    for (String reservedColumnName : MOCASQL_RESERVED_COLUMN_NAMES) {
                                        if (reservedColumnName.compareToIgnoreCase(columnTokenText) == 0) {
                                            isReservedColumn = true;
                                            break;
                                        }
                                    }
                                }

                                if (!foundColumn && !isReservedColumn) {
                                    Position beginPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                            columnToken.getCharPositionInLine(), sqlScriptRange);
                                    Position endPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                            columnToken.getCharPositionInLine(), sqlScriptRange);

                                    if (beginPos != null && endPos != null) {
                                        Range range = new Range(beginPos, endPos);
                                        Diagnostic diagnostic = new Diagnostic();
                                        diagnostic.setRange(range);
                                        diagnostic.setSeverity(DiagnosticSeverity.Warning);
                                        diagnostic.setMessage(
                                                String.format(MOCASQL_COLUMN_DOES_NOT_EXIST_ON_SUBQUERY_WARNING,
                                                        columnTokenText, tableName));
                                        diagnostics.add(diagnostic);
                                    }
                                }
                            }
                        }

                    } else {

                        // Do not worry about checking aliases -- we did so above and table name has
                        // been adjusted accordingly.

                        tableName = tableName.toLowerCase();

                        for (org.antlr.v4.runtime.Token columnToken : entry.getValue()) {

                            String columnTokenText = columnToken.getText();

                            ArrayList<TableColumn> columnsInTable = MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache
                                    .getColumnsForTable(tableName);

                            boolean foundColumn = false;
                            if (columnsInTable != null) {
                                for (TableColumn tableColumn : columnsInTable) {
                                    if (tableColumn.column_name.compareToIgnoreCase(columnTokenText) == 0) {
                                        foundColumn = true;
                                        break;
                                    }
                                }
                            }

                            // Make sure column does not exist in reserved column names array.
                            boolean isReservedColumn = false;
                            // Do not check if already found!
                            if (!foundColumn) {
                                for (String reservedColumnName : MOCASQL_RESERVED_COLUMN_NAMES) {
                                    if (reservedColumnName.compareToIgnoreCase(columnTokenText) == 0) {
                                        isReservedColumn = true;
                                        break;
                                    }
                                }
                            }

                            if (!foundColumn && !isReservedColumn) {

                                Position beginPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                        columnToken.getCharPositionInLine(), sqlScriptRange);
                                Position endPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                        columnToken.getCharPositionInLine(), sqlScriptRange);

                                if (beginPos != null && endPos != null) {
                                    Range range = new Range(beginPos, endPos);
                                    Diagnostic diagnostic = new Diagnostic();
                                    diagnostic.setRange(range);
                                    diagnostic.setSeverity(DiagnosticSeverity.Warning);
                                    diagnostic.setMessage(
                                            String.format(MOCASQL_COLUMN_DOES_NOT_EXIST_ON_TABLE_OR_VIEW_WARNING,
                                                    columnTokenText, tableName));
                                    diagnostics.add(diagnostic);
                                }

                            }
                        }
                    }

                }

            }
        }
        return diagnostics;
    }

    // GROOVY.
    private static ArrayList<Diagnostic> handleGroovyAll(String uriStr, GroovyCompilationResult compilationResult,
            Range groovyScriptRange, LanguageClient client) {
        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<Message> errors = compilationResult.compilationUnit.getErrorCollector().getErrors();
        // For whatever reason, we are getting duplicate messages. Lets log the already
        // added messages to make sure we are not duplicating.
        ArrayList<String> alreadyAddedMessages = new ArrayList<>();
        if (errors != null) {
            errors.stream().forEach((Object message) -> {

                if (message instanceof SyntaxErrorMessage) {
                    SyntaxErrorMessage syntaxErrorMessage = (SyntaxErrorMessage) message;
                    SyntaxException cause = syntaxErrorMessage.getCause();
                    Range range = GroovyLanguageUtils.syntaxExceptionToRange(cause, groovyScriptRange);
                    Diagnostic diagnostic = new Diagnostic();
                    diagnostic.setRange(range);
                    // We know diagnostics are on, but let's also check for warning
                    // diagnostics if cause is not fatal.
                    if (cause.isFatal() || (!cause.isFatal()
                            && MocaLanguageServer.mocaLanguageServerOptions.groovyWarningDiagnosticsEnabled)) {
                        diagnostic.setSeverity(cause.isFatal() ? DiagnosticSeverity.Error : DiagnosticSeverity.Warning);
                        String msg = cause.getMessage();
                        diagnostic.setMessage(String.format(GROOVY_MESSAGE, msg));
                        // Check to see if we have already add message.
                        if (!alreadyAddedMessages.contains(msg)) {
                            diagnostics.add(diagnostic);
                            // Add to existing messages list.
                            alreadyAddedMessages.add(msg);
                        }
                    }

                } else if (message instanceof ExceptionMessage) {
                    // Only time I have seen this is if we imported a library that is missing one of
                    // it's dependencies. If this happens, we want the user to be aware. We will not
                    // really have a range, so lets just point to the top of the current groovy
                    // context.

                    // Do not worry about checking moca lang server options -- let's return message
                    // regardless.
                    ExceptionMessage exceptionMessage = (ExceptionMessage) message;
                    Exception cause = exceptionMessage.getCause();
                    Position pos = GroovyLanguageUtils.createMocaPosition(0, 0, groovyScriptRange);
                    Range range = new Range(pos, pos);
                    Diagnostic diagnostic = new Diagnostic();
                    diagnostic.setRange(range);
                    diagnostic.setSeverity(DiagnosticSeverity.Error);
                    String errMsg = cause.getMessage();
                    diagnostic.setMessage(String.format(GROOVY_ERROR, errMsg));
                }

            });
        }

        return diagnostics;
    }

    // MISC.
    private static ArrayList<Diagnostic> handleTodos(String uriStr, String script, MocaCompiler mocaCompiler) {

        // Basically just finding in TODOs and adding them to the list.

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        Pattern todoPattern = Pattern.compile("\\b(?i)(TODO.*)\\b");
        Matcher todoMatcher = todoPattern.matcher(script);
        while (todoMatcher.find()) {
            Range range = new Range(Positions.getPosition(script, todoMatcher.start()),
                    Positions.getPosition(script, todoMatcher.end()));
            Diagnostic diagnostic = new Diagnostic();

            // Now let's check if todo is in sql or groovy range.
            boolean inSqlRange = false;
            boolean inGroovyRange = false;
            for (Range sqlRange : mocaCompiler.mocaSqlRanges) {
                if (Ranges.contains(sqlRange, range)) {
                    inSqlRange = true;
                    break;
                }
            }

            if (!inSqlRange) {
                for (Range groovyRange : mocaCompiler.groovyRanges) {
                    if (Ranges.contains(groovyRange, range)) {
                        inGroovyRange = true;
                        break;
                    }
                }
            }

            String prefix = null;
            if (inSqlRange) {
                prefix = "SQL: ";
            } else if (inGroovyRange) {
                prefix = "GROOVY: ";
            } else {
                prefix = "MOCA: ";
            }

            diagnostic.setRange(range);
            diagnostic.setSeverity(DiagnosticSeverity.Information);
            diagnostic.setMessage(prefix + todoMatcher.group());
            diagnostics.add(diagnostic);
        }

        return diagnostics;
    }

}