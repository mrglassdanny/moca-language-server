package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxErrorListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.MocaSqlCompilationResult;

public class MocaCompilationResult {

    public MocaParser mocaParser;
    public MocaParseTreeListener mocaParseTreeListener;
    public MocaSyntaxErrorListener mocaSyntaxErrorListener;

    public HashMap<Integer, MocaSqlCompilationResult> sqlCompilationResults;
    public HashMap<Integer, GroovyCompilationResult> groovyCompilationResults;

    public MocaCompilationResult() {

        this.mocaParser = null;
        this.mocaParseTreeListener = null;
        this.mocaSyntaxErrorListener = null;

        this.sqlCompilationResults = null;
        this.groovyCompilationResults = null;

    }

    public boolean hasMocaErrors() {
        return this.mocaSyntaxErrorListener != null && this.mocaSyntaxErrorListener.mocaSyntaxErrors.size() > 0;
    }

}