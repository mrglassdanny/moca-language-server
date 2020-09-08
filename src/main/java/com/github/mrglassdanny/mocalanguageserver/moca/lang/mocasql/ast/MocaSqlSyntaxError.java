package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast;

public class MocaSqlSyntaxError {
    public int line;
    public int charPositionInLine;
    public String msg;

    public MocaSqlSyntaxError(int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
    }
}