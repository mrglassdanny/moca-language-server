package com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy;

import java.security.CodeSource;

import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilerConfiguration;

import groovy.lang.GroovyClassLoader;

public class GroovyCompilationUnit extends CompilationUnit {
    public GroovyCompilationUnit(CompilerConfiguration config) {
        this(config, null, null);
    }

    public GroovyCompilationUnit(CompilerConfiguration config, CodeSource security, GroovyClassLoader loader) {
        super(config, security, loader);
        this.errorCollector = new GroovyErrorCollector(config);
    }

}
