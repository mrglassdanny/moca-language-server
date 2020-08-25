package com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy;

import java.io.File;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.antlr.v4.runtime.Token;
import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
import org.codehaus.groovy.control.Phases;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer;

import groovy.lang.GroovyClassLoader;
import groovy.transform.TypeChecked;

public class GroovyCompiler {

    public static ArrayList<String> classpathList = new ArrayList<>();

    // public ArrayList<String> classpathList;
    public HashMap<Integer, GroovyCompilationResult> compilationResults;

    public GroovyCompiler() {
        this.compilationResults = new HashMap<>();
    }

    // Passing in MocaCompiler and moca script so that we can get redirects( >> res)
    // from moca so we can add groovy script prefix. We will initialize these as
    // SimpleResults objects, that way we dont get the static
    // type check warning and we get intellisense!
    public GroovyCompilationResult compileScript(int rangeIdx, String groovyScript, MocaCompiler mocaCompiler,
            String mocaScript) {

        GroovyCompilationResult compilationResult = new GroovyCompilationResult();
        compilationResult.compilationUnit = this.createCompilationUnit();

        // Add prefixes to script.
        // Also add moca redirects, as long as they were 'declared' above current groovy
        // script range.
        String mocaRedirects = "";
        // Need to keep track of what we have added, that way we dont add 2 redirects
        // with the same name(will cause static type checking issue).
        ArrayList<String> addedMocaRedirectNames = new ArrayList<>();
        int groovyScriptOffset = Positions.getOffset(mocaScript, mocaCompiler.groovyRanges.get(rangeIdx).getStart());
        if (mocaCompiler.lastSuccessfulCompilationResult != null) {
            for (Map.Entry<Token, String> entry : mocaCompiler.lastSuccessfulCompilationResult.mocaParserReImpl.redirects
                    .entrySet()) {
                if (entry.getKey().getStartIndex() <= groovyScriptOffset) {
                    String curMocaRedirectName = entry.getValue();
                    if (!addedMocaRedirectNames.contains(curMocaRedirectName)) {
                        mocaRedirects += ("SimpleResults " + curMocaRedirectName + "; ");
                        addedMocaRedirectNames.add(curMocaRedirectName);
                    }
                }
            }
        }

        groovyScript = GroovyLanguageUtils.GROOVY_DEFAULT_IMPORTS + GroovyLanguageUtils.MOCA_GROOVY_SCRIPT_PREFIX
                + mocaRedirects + groovyScript;

        // Add a source unit to compilation unit and then compile.
        compilationResult.compilationUnit.addSource(
                new SourceUnit("script" + rangeIdx, groovyScript, compilationResult.compilationUnit.getConfiguration(),
                        compilationResult.compilationUnit.getClassLoader(),
                        compilationResult.compilationUnit.getErrorCollector()));

        try {
            // AST is completely built after the canonicalization phase;
            // for code intelligence, we shouldn't need to go further.
            // However, for static type checking, we need to go through instruction
            // selection.
            // http://groovy-lang.org/metaprogramming.html#_compilation_phases_guide
            compilationResult.compilationUnit.compile(Phases.INSTRUCTION_SELECTION);
        } catch (MultipleCompilationErrorsException e) {
            // ignore
        } catch (GroovyBugError e) {
            System.err.println("Unexpected exception in language server when compiling Groovy.");
            e.printStackTrace(System.err);
        } catch (Exception e) {
            System.err.println("Unexpected exception in language server when compiling Groovy.");
            e.printStackTrace(System.err);
        }

        // Now visit AST and we should be all good.
        compilationResult.astVisitor.visitCompilationUnit(compilationResult.compilationUnit);
        // Do not forget to add to hash map.
        this.compilationResults.put(rangeIdx, compilationResult);
        return compilationResult;

    }

    public GroovyCompilationUnit createCompilationUnit() {
        CompilerConfiguration config = this.getConfiguration();
        GroovyClassLoader classLoader = new GroovyClassLoader(ClassLoader.getSystemClassLoader().getParent(), config,
                true);

        GroovyCompilationUnit compilationUnit = new GroovyCompilationUnit(config, null, classLoader);

        return compilationUnit;

    }

    public CompilerConfiguration getConfiguration() {

        CompilerConfiguration config = new CompilerConfiguration();
        // Adding type checking - see:
        // http://groovy-lang.org/semantics.html#static-type-checking
        config.addCompilationCustomizers(new ASTTransformationCustomizer(TypeChecked.class));

        // Make sure not null before trying to set class path list.
        ArrayList<String> classpathConfig = this.getClasspathListForConfiguration();
        if (classpathConfig != null) {
            config.setClasspathList(classpathConfig);
        }

        return config;
    }

    protected ArrayList<String> getClasspathListForConfiguration() {
        if (GroovyCompiler.classpathList == null || GroovyCompiler.classpathList.isEmpty()) {
            return null;
        }

        ArrayList<String> classpathListForConfig = new ArrayList<>();

        for (String entry : GroovyCompiler.classpathList) {
            boolean mustBeDirectory = false;
            if (entry.endsWith("*")) {
                entry = entry.substring(0, entry.length() - 1);
                mustBeDirectory = true;
            }

            File file = new File(entry);
            if (!file.exists()) {
                continue;
            }
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    if (!child.getName().endsWith(".jar") || !child.isFile()) {
                        continue;
                    }
                    classpathListForConfig.add(child.getPath());
                }
            } else if (!mustBeDirectory && file.isFile()) {
                if (file.getName().endsWith(".jar")) {
                    classpathListForConfig.add(entry);
                }
            }
        }

        return classpathListForConfig;
    }

    public class GroovyCompilationUnit extends CompilationUnit {
        public GroovyCompilationUnit(CompilerConfiguration config) {
            this(config, null, null);
        }

        public GroovyCompilationUnit(CompilerConfiguration config, CodeSource security, GroovyClassLoader loader) {
            super(config, security, loader);
            this.errorCollector = new GroovyErrorCollector(config);
        }

    }

}