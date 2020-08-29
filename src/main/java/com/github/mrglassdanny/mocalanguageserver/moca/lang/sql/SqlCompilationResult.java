package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;

import org.antlr.v4.runtime.Token;

public class SqlCompilationResult {

    public List<? extends Token> sqlTokens; // From lexer.
    public MocaSqlParser sqlParser;
    public SqlParseTreeListener sqlParseTreeListener;
    public SqlSyntaxErrorListener sqlSyntaxErrorListener;

    public SqlCompilationResult() {

        this.sqlTokens = null;
        this.sqlParser = null;
        this.sqlParseTreeListener = null;
        this.sqlSyntaxErrorListener = null;
    }

    public boolean hasSqlErrors() {
        return this.sqlSyntaxErrorListener != null && this.sqlSyntaxErrorListener.sqlSyntaxErrors.size() > 0;
    }
}