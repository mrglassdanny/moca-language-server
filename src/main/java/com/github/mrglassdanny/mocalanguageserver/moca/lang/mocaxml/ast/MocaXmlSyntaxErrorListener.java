package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml.ast;

import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class MocaXmlSyntaxErrorListener extends BaseErrorListener {

    public ArrayList<MocaXmlSyntaxError> mocaXmlSyntaxErrors;

    public MocaXmlSyntaxErrorListener() {
        this.mocaXmlSyntaxErrors = new ArrayList<>();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        this.mocaXmlSyntaxErrors.add(new MocaXmlSyntaxError(line, charPositionInLine, msg));
    }

}