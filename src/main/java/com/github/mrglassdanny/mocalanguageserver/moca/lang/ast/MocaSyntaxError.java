package com.github.mrglassdanny.mocalanguageserver.moca.lang.ast;

public class MocaSyntaxError {
    public int line;
    public int charPositionInLine;
    public String msg;

    public MocaSyntaxError(int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
    }
}