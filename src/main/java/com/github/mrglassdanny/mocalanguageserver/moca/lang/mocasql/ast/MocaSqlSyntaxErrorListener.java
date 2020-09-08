package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast;

import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class MocaSqlSyntaxErrorListener extends BaseErrorListener {

    public ArrayList<MocaSqlSyntaxError> mocaSqlSyntaxErrors;

    public MocaSqlSyntaxErrorListener() {
        this.mocaSqlSyntaxErrors = new ArrayList<>();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        this.mocaSqlSyntaxErrors.add(new MocaSqlSyntaxError(line, charPositionInLine, msg));
    }
}