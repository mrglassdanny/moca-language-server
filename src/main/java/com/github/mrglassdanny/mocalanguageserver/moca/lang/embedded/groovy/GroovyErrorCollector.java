package com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy;

import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.ErrorCollector;

public class GroovyErrorCollector extends ErrorCollector {
    private static final long serialVersionUID = 1L;

    public GroovyErrorCollector(CompilerConfiguration configuration) {
        super(configuration);
    }

    public void clear() {
        if (errors != null) {
            errors.clear();
        }
        if (warnings != null) {
            warnings.clear();
        }
    }

    @Override
    protected void failIfErrors() throws CompilationFailedException {
        // don't fail
    }
}