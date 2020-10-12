package com.github.mrglassdanny.mocalanguageserver.services.diagnostic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCache;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.TableColumn;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxError;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlSyntaxError;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util.MocaSqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaTokenUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

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

public class DiagnosticManager {

    private static final String MOCA_SYNTAX_ERROR = "MOCA: line %d:%d %s";
    private static final String MOCA_COMMAND_DOES_NOT_EXIST_WARNING = "MOCA: Command '%s' does not exist";
    private static final String MOCASQL_SYNTAX_ERROR = "SQL: %s";
    private static final String MOCASQL_TABLE_DOES_NOT_EXIST_WARNING = "SQL: Table/View/Subquery '%s' does not exist";
    private static final String MOCASQL_COLUMN_DOES_NOT_EXIST_ON_TABLE_OR_VIEW_WARNING = "SQL: Column '%s' does not exist on Table/View/Subquery '%s'";
    private static final String MOCASQL_COLUMN_DOES_NOT_EXIST_ON_SUBQUERY_WARNING = "SQL: Column '%s' does not exist on Subquery '%s'";
    private static final String MOCASQL_COLUMN_DOES_NOT_EXIST_ON_ANON_SUBQUERY_WARNING = "SQL: Column '%s' does not exist on anonymous Subquery";
    private static final String MOCASQL_COLUMN_EXISTS_FOR_MULTIPLE_TABLES_WARNING = "SQL: Column '%s' exists for multiple tables(%s) in context; please specify table for column";
    private static final String GROOVY_MESSAGE = "GROOVY: %s";
    private static final String GROOVY_ERROR = "GROOVY: %s";

    private static final String[] MOCASQL_RESERVED_COLUMN_NAMES = { "rownum", "sysdate" };

    public static void streamAll() {

        // Check to see if file extension is marked as read only. If so, do not publish
        // any diagnostics.
        // This will be the case for any files created by command lookup functionality
        // in the client.
        String uriExtStr = MocaServices.mocaCompilationResult.uriStr
                .substring(MocaServices.mocaCompilationResult.uriStr.lastIndexOf("."));
        if (uriExtStr.compareToIgnoreCase(".readonly") == 0) {
            return;
        }

        clearDiagnostics(MocaServices.mocaCompilationResult.uriStr);

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        diagnostics.addAll(streamErrors());
        diagnostics.addAll(streamWarnings());
        diagnostics.addAll(streamInformation());
        diagnostics.addAll(streamHints());

        MocaServices.languageClient.publishDiagnostics(
                new PublishDiagnosticsParams(MocaServices.mocaCompilationResult.uriStr, diagnostics));

    }

    // Could be clearing diagnostics for uriStr different than one in moca
    // compilation result.
    public static void clearDiagnostics(String uriStr) {
        MocaServices.languageClient.publishDiagnostics(new PublishDiagnosticsParams(uriStr, new ArrayList<>()));
    }

    public static ArrayList<Diagnostic> streamErrors() {

        // Clear out all existing dianostics by sending empty list.
        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        // MOCA.
        // Check moca diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocaDiagnosticsEnabled) {
            diagnostics.addAll(handleMocaSyntaxErrors());
        }

        // SQL.
        // Check mocasql diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocasqlDiagnosticsEnabled) {
            for (int i = 0; i < MocaServices.mocaCompilationResult.mocaSqlRanges.size(); i++) {
                diagnostics.addAll(
                        handleMocaSqlSyntaxErrors(MocaServices.mocaCompilationResult.mocaSqlCompilationResults.get(i),
                                MocaServices.mocaCompilationResult.mocaSqlRanges.get(i)));
            }
        }

        // GROOVY.
        // Check groovy diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.groovyDiagnosticsEnabled) {
            for (int i = 0; i < MocaServices.mocaCompilationResult.groovyRanges.size(); i++) {
                diagnostics.addAll(handleGroovyAll(MocaServices.mocaCompilationResult.groovyCompilationResults.get(i),
                        MocaServices.mocaCompilationResult.groovyRanges.get(i)));
            }
        }

        return diagnostics;

    }

    public static ArrayList<Diagnostic> streamWarnings() {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        // MOCA.
        // Check moca diagnostics and warning diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocaDiagnosticsEnabled
                && MocaLanguageServer.mocaLanguageServerOptions.mocaWarningDiagnosticsEnabled) {
            diagnostics.addAll(handleMocaCommandDoesNotExistWarnings());
        }

        // SQL.
        // Check mocasql diagnostics and warning diagnostics enabled.
        if (MocaLanguageServer.mocaLanguageServerOptions.mocasqlDiagnosticsEnabled
                && MocaLanguageServer.mocaLanguageServerOptions.mocasqlWarningDiagnosticsEnabled) {
            for (int i = 0; i < MocaServices.mocaCompilationResult.mocaSqlRanges.size(); i++) {
                MocaSqlCompilationResult sqlCompilationResult = MocaServices.mocaCompilationResult.mocaSqlCompilationResults
                        .get(i);
                Range sqlRange = MocaServices.mocaCompilationResult.mocaSqlRanges.get(i);
                diagnostics.addAll(handleMocaSqlTableDoesNotExistWarnings(sqlCompilationResult.mocaSqlParseTreeListener,
                        sqlRange));
                diagnostics.addAll(handleMocaSqlColumnsDoesNotExistInTableWarnings(
                        sqlCompilationResult.mocaSqlParseTreeListener, sqlRange));
            }
        }

        return diagnostics;

    }

    public static ArrayList<Diagnostic> streamInformation() {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        return diagnostics;

    }

    public static ArrayList<Diagnostic> streamHints() {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        return diagnostics;

    }

    // MOCA.
    private static ArrayList<Diagnostic> handleMocaSyntaxErrors() {

        if (!MocaServices.mocaCompilationResult.hasMocaErrors()) {
            return new ArrayList<>();
        } else {
            ArrayList<Diagnostic> diagnostics = new ArrayList<>();

            for (MocaSyntaxError mocaSyntaxError : MocaServices.mocaCompilationResult.mocaSyntaxErrorListener.mocaSyntaxErrors) {
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

    private static ArrayList<Diagnostic> handleMocaCommandDoesNotExistWarnings() {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        if (MocaServices.mocaCompilationResult == null) {
            // Return empty list.
            return diagnostics;
        }

        // Loop through all verb noun clauses and see if we have any verbNounClauses
        // that do not exist in cache. If so, we will get the range, build the
        // diagnosic, and add it to the list.
        for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry : MocaServices.mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                .entrySet()) {

            StringBuilder verbNounClause = entry.getKey();

            if (!MocaCache.getGlobalMocaCache().distinctCommands.contains(verbNounClause.toString())) {

                ArrayList<org.antlr.v4.runtime.Token> mocaTokens = entry.getValue();
                // No need to validate size -- we can assume that we have
                // at least 1 moca token in list.
                org.antlr.v4.runtime.Token beginToken = mocaTokens.get(0);
                org.antlr.v4.runtime.Token endToken = mocaTokens.get(mocaTokens.size() - 1);

                Position beginPos = PositionUtils.getPosition(MocaServices.mocaCompilationResult.script,
                        beginToken.getStartIndex());
                Position endPos = PositionUtils.getPosition(MocaServices.mocaCompilationResult.script,
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
    private static ArrayList<Diagnostic> handleMocaSqlSyntaxErrors(MocaSqlCompilationResult mocaSqlCompilationResult,
            Range sqlScriptRange) {
        if (mocaSqlCompilationResult == null || !mocaSqlCompilationResult.hasSqlErrors()) {
            return new ArrayList<Diagnostic>();
        } else {
            // Set diagnostics.
            ArrayList<Diagnostic> diagnostics = new ArrayList<>();

            for (MocaSqlSyntaxError sqlSyntaxError : mocaSqlCompilationResult.mocaSqlSyntaxErrorListener.mocaSqlSyntaxErrors) {
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

    private static ArrayList<Diagnostic> handleMocaSqlTableDoesNotExistWarnings(
            MocaSqlParseTreeListener sqlParseTreeListener, Range sqlScriptRange) {

        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        // Basically we are going to check all tables in the ast against our cache
        // and see if there are an discrepancies.

        for (Token tableToken : sqlParseTreeListener.tableTokens) {

            boolean foundTable = false;

            String tableTokenText = tableToken.getText().toLowerCase();

            // Check tables and views.
            if (MocaCache.getGlobalMocaCache().mocaSqlCache.tables.containsKey(tableTokenText)
                    || MocaCache.getGlobalMocaCache().mocaSqlCache.views.containsKey(tableTokenText)) {
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

    private static ArrayList<Diagnostic> handleMocaSqlColumnsDoesNotExistInTableWarnings(
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

            // Analyze table name and see if column(s) exist for it.

            // Convert tableName to lowercase.
            tableName = tableName.toLowerCase();

            if (tableName.compareTo(MocaSqlParseTreeListener.ANONYMOUS_SUBQUERY) == 0) {

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
                                    diagnostic
                                            .setMessage(String.format(MOCASQL_COLUMN_DOES_NOT_EXIST_ON_SUBQUERY_WARNING,
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

                        // If table name not specified on column, tableName could be multiple table
                        // names delimited by comma. Let's assume this is the case and loop over the
                        // split result. If this is not the case, we will simply iterate 1 time over
                        // the single table name.
                        String[] tableNamesForColumn = entry.getKey().split(",");
                        // Need to keep track of tables found for column. This is only
                        // necessary if no table specified for column and there are multiple tables in
                        // context.
                        int tablesFoundForColumn = 0;
                        // We will add tables found to string for diagnostic message.
                        StringBuilder tableNamesForWarnDiagnosticBuf = new StringBuilder(256);

                        boolean foundColumn = false;
                        for (String tableNameForColumn : tableNamesForColumn) {

                            // We check for alias above, but if we have multiple tables in context it would
                            // have failed. We need to check here in our analysis.
                            if (sqlParseTreeListener.aliasedTableNames.containsKey(tableNameForColumn)) {
                                // Switch to actual table name.
                                // NOTE: could see goofy stuff if alias is declared elsewhere in parse tree -- a
                                // risk I am willing to take!
                                tableNameForColumn = sqlParseTreeListener.aliasedTableNames.get(tableNameForColumn);
                            }

                            ArrayList<TableColumn> columnsInTable = MocaCache.getGlobalMocaCache().mocaSqlCache
                                    .getColumnsForTable(tableNameForColumn);
                            if (columnsInTable != null) {
                                for (TableColumn tableColumn : columnsInTable) {
                                    if (tableColumn.column_name.compareToIgnoreCase(columnTokenText) == 0) {
                                        foundColumn = true;
                                        tablesFoundForColumn++;
                                        tableNamesForWarnDiagnosticBuf.append(tableNameForColumn);
                                        tableNamesForWarnDiagnosticBuf.append(",");
                                        // Need to remember to get rid of trailing comma later ^.
                                        break;
                                    }
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

                        if (tablesFoundForColumn > 1) {

                            Position beginPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                    columnToken.getCharPositionInLine(), sqlScriptRange);
                            Position endPos = MocaSqlLanguageUtils.createMocaPosition(columnToken.getLine(),
                                    columnToken.getCharPositionInLine(), sqlScriptRange);

                            if (beginPos != null && endPos != null) {
                                Range range = new Range(beginPos, endPos);
                                Diagnostic diagnostic = new Diagnostic();
                                diagnostic.setRange(range);
                                diagnostic.setSeverity(DiagnosticSeverity.Warning);
                                // Remove trailing comma from tableNamesForWarnDiagnosticBuf.
                                tableNamesForWarnDiagnosticBuf
                                        .deleteCharAt(tableNamesForWarnDiagnosticBuf.length() - 1);
                                diagnostic.setMessage(String.format(MOCASQL_COLUMN_EXISTS_FOR_MULTIPLE_TABLES_WARNING,
                                        columnTokenText, tableNamesForWarnDiagnosticBuf.toString()));
                                diagnostics.add(diagnostic);
                            }
                        }

                        if (!foundColumn && !isReservedColumn && tablesFoundForColumn == 0) {

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
        return diagnostics;

    }

    // GROOVY.
    private static ArrayList<Diagnostic> handleGroovyAll(GroovyCompilationResult groovyCompilationResult,
            Range groovyScriptRange) {
        ArrayList<Diagnostic> diagnostics = new ArrayList<>();

        if (groovyCompilationResult == null) {
            return diagnostics;
        }

        @SuppressWarnings("unchecked")
        List<Message> errors = groovyCompilationResult.compilationUnit.getErrorCollector().getErrors();
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

}