package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml;

import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaXmlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml.ast.MocaXmlParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml.ast.MocaXmlSyntaxErrorListener;

import org.antlr.v4.runtime.Token;

public class MocaXmlCompilationResult {

    public List<? extends Token> mocaXmlTokens; // From lexer.
    public MocaXmlParser mocaXmlParser;
    public MocaXmlParseTreeListener mocaXmlParseTreeListener;
    public MocaXmlSyntaxErrorListener mocaXmlSyntaxErrorListener;

    public MocaXmlCompilationResult() {

        this.mocaXmlTokens = null;
        this.mocaXmlParser = null;
        this.mocaXmlParseTreeListener = null;
        this.mocaXmlSyntaxErrorListener = null;
    }

    public boolean hasXmlErrors() {
        return this.mocaXmlSyntaxErrorListener != null
                && this.mocaXmlSyntaxErrorListener.mocaXmlSyntaxErrors.size() > 0;
    }

}
