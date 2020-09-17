package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml.ast;

public class MocaXmlSyntaxError {
    public int line;
    public int charPositionInLine;
    public String msg;

    public MocaXmlSyntaxError(int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
    }
}