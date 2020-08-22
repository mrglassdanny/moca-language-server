package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaExecutableComponentVisitor;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.SqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.reimpl.MocaParserReImpl;
import com.redprairie.moca.server.parse.MocaParseException;

public class MocaCompilationResult {

    public MocaParserReImpl mocaParserReImpl;
    public MocaExecutableComponentVisitor astVisitor;
    public MocaParseException parseException;

    public HashMap<Integer, SqlCompilationResult> sqlCompilationResults;
    // Based on how parser works(no ast data when exception in parse), we need to
    // store last successful compilation results.
    public HashMap<Integer, SqlCompilationResult> sqlLastSuccessfulCompilationResults;
    public HashMap<Integer, GroovyCompilationResult> groovyCompilationResults;

    public MocaCompilationResult() {
        this.mocaParserReImpl = null;
        this.astVisitor = null;
        this.parseException = null;

        this.sqlCompilationResults = null;
        this.sqlLastSuccessfulCompilationResults = null;
        this.groovyCompilationResults = null;

    }

    public boolean hasMocaErrors() {
        return this.parseException != null;
    }

    public String getParseErrorText() {
        return this.parseException.getArgValue("text").toString();
    }

}