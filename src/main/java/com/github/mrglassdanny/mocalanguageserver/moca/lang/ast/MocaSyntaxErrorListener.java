package com.github.mrglassdanny.mocalanguageserver.moca.lang.ast;

import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class MocaSyntaxErrorListener extends BaseErrorListener {

    public ArrayList<MocaSyntaxError> mocaSyntaxErrors;

    public MocaSyntaxErrorListener() {
        this.mocaSyntaxErrors = new ArrayList<>();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        this.mocaSyntaxErrors.add(new MocaSyntaxError(line, charPositionInLine, msg));
    }

}