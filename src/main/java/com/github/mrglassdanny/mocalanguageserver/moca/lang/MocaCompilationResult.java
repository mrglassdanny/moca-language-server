package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.SqlCompilationResult;

import org.antlr.v4.runtime.RecognitionException;

public class MocaCompilationResult {

    public MocaParser mocaParser;
    public MocaParseTreeListener mocaParseTreeListener;
    public RecognitionException parseException;

    public HashMap<Integer, SqlCompilationResult> sqlCompilationResults;
    // Based on how parser works(no ast data when exception in parse), we need to
    // store last successful compilation results.
    public HashMap<Integer, SqlCompilationResult> sqlLastSuccessfulCompilationResults;
    public HashMap<Integer, GroovyCompilationResult> groovyCompilationResults;

    public MocaCompilationResult() {

        this.mocaParser = null;
        this.mocaParseTreeListener = null;
        this.parseException = null;

        this.sqlCompilationResults = null;
        this.sqlLastSuccessfulCompilationResults = null;
        this.groovyCompilationResults = null;

    }

    public boolean hasMocaErrors() {
        return this.parseException != null;
    }

    public String getParseErrorText() {
        return this.parseException.getMessage();
    }

}