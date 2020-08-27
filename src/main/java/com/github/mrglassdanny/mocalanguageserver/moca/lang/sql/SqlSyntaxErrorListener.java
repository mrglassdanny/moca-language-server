package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SqlSyntaxErrorListener extends BaseErrorListener {

    public ArrayList<SqlSyntaxError> sqlSyntaxErrors;

    public SqlSyntaxErrorListener() {
        this.sqlSyntaxErrors = new ArrayList<>();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        this.sqlSyntaxErrors.add(new SqlSyntaxError(line, charPositionInLine, msg));
    }
}