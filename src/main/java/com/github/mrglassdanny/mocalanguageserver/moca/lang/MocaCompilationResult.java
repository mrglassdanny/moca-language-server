package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.SqlCompilationResult;

public class MocaCompilationResult {

    public MocaParser mocaParser;
    public MocaParseTreeListener mocaParseTreeListener;
    public MocaSyntaxErrorListener mocaSyntaxErrorListener;

    public HashMap<Integer, SqlCompilationResult> sqlCompilationResults;
    // Based on how sql/groovy parsers work(no ast data when exception in parse), we
    // need to
    // store last successful compilation results.
    public HashMap<Integer, SqlCompilationResult> sqlLastSuccessfulCompilationResults;
    public HashMap<Integer, GroovyCompilationResult> groovyCompilationResults;

    public MocaCompilationResult() {

        this.mocaParser = null;
        this.mocaParseTreeListener = null;
        this.mocaSyntaxErrorListener = null;

        this.sqlCompilationResults = null;
        this.sqlLastSuccessfulCompilationResults = null;
        this.groovyCompilationResults = null;

    }

    public boolean hasMocaErrors() {
        return this.mocaSyntaxErrorListener != null && this.mocaSyntaxErrorListener.mocaSyntaxErrors.size() > 0;
    }

    // // TODO
    // public String getParseErrorText() {
    // // return this.parseException.getMessage();
    // return "";
    // }

}