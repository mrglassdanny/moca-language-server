package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.TSqlParser;

public class SqlCompilationResult {

    public TSqlParser sqlParser;
    public SqlParseTreeListener sqlParseTreeListener;
    public SqlSyntaxErrorListener sqlSyntaxErrorListener;

    public SqlCompilationResult() {

        this.sqlParser = null;
        this.sqlParseTreeListener = null;
        this.sqlSyntaxErrorListener = null;
    }

    public boolean hasSqlErrors() {
        return this.sqlSyntaxErrorListener != null && this.sqlSyntaxErrorListener.sqlSyntaxErrors.size() > 0;
    }
}