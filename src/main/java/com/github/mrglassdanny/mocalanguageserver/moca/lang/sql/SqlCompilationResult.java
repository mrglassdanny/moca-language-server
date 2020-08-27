package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.ast.SqlStatementVisitor;

public class SqlCompilationResult {

    public SqlStatementVisitor astVisitor;
    public SqlSyntaxError sqlSyntaxError;

    public SqlCompilationResult() {
        this.astVisitor = null;
        this.sqlSyntaxError = null;
    }

    public boolean hasErrors() {
        return this.sqlSyntaxError != null;
    }
}