package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

public class SqlSyntaxError {
    public int line;
    public int charPositionInLine;
    public String msg;

    public SqlSyntaxError(int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
    }
}