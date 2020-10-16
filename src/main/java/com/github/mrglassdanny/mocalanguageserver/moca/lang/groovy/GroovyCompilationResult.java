package com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.ast.GroovyASTNodeVisitor;

import org.eclipse.lsp4j.Range;

public class GroovyCompilationResult {

    public GroovyCompilationUnit compilationUnit;
    public GroovyASTNodeVisitor astVisitor;
    public Range range;

    public GroovyCompilationResult() {
        this.compilationUnit = null;
        this.astVisitor = new GroovyASTNodeVisitor();
        this.range = null;
    }
}