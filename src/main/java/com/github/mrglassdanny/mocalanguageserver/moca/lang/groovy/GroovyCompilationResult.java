package com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler.GroovyCompilationUnit;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.ast.GroovyASTNodeVisitor;

public class GroovyCompilationResult {

    public GroovyCompilationUnit compilationUnit;
    public GroovyASTNodeVisitor astVisitor;

    public GroovyCompilationResult() {
        this.compilationUnit = null;
        this.astVisitor = new GroovyASTNodeVisitor();
    }
}