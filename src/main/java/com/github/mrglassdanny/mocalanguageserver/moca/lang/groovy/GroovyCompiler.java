package com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy;

import java.io.File;
import java.util.ArrayList;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;

import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.Phases;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer;
import org.eclipse.lsp4j.Range;

import groovy.lang.GroovyClassLoader;
import groovy.transform.TypeChecked;

public class GroovyCompiler {

    public static ArrayList<String> classpathList = new ArrayList<>();

    public static GroovyCompilationResult compileScript(final int compilationResultIdx, String groovyScript,
            Range range) {

        GroovyCompilationResult groovyCompilationResult = new GroovyCompilationResult();
        groovyCompilationResult.compilationUnit = createCompilationUnit();

        // Add a source unit to compilation unit and then compile.
        groovyCompilationResult.compilationUnit.addSource(new SourceUnit("script" + compilationResultIdx, groovyScript,
                groovyCompilationResult.compilationUnit.getConfiguration(),
                groovyCompilationResult.compilationUnit.getClassLoader(),
                groovyCompilationResult.compilationUnit.getErrorCollector()));

        try {
            // AST is completely built after the canonicalization phase;
            // for code intelligence, we shouldn't need to go further.
            // However, for static type checking, we need to go through instruction
            // selection.
            // http://groovy-lang.org/metaprogramming.html#_compilation_phases_guide

            // Check if static type checking is enabled via moca lang server options.
            if (MocaLanguageServer.mocaLanguageServerOptions.groovyStaticTypeCheckingEnabled) {
                groovyCompilationResult.compilationUnit.compile(Phases.INSTRUCTION_SELECTION);
            } else {
                groovyCompilationResult.compilationUnit.compile(Phases.CANONICALIZATION);
            }

        } catch (CompilationFailedException e) {
            // ignore
        } catch (Exception e) {
            System.err.println("Unexpected exception in language server when compiling Groovy.");
            e.printStackTrace(System.err);
        }

        // Now visit AST and we should be all good.
        groovyCompilationResult.astVisitor.visitCompilationUnit(groovyCompilationResult.compilationUnit);
        groovyCompilationResult.range = range;
        return groovyCompilationResult;

    }

    private static GroovyCompilationUnit createCompilationUnit() {
        CompilerConfiguration config = getConfiguration();
        GroovyClassLoader classLoader = new GroovyClassLoader(ClassLoader.getSystemClassLoader().getParent(), config,
                true);

        GroovyCompilationUnit compilationUnit = new GroovyCompilationUnit(config, null, classLoader);

        return compilationUnit;

    }

    private static CompilerConfiguration getConfiguration() {

        CompilerConfiguration config = new CompilerConfiguration();

        // Check if static type checking is enabled via moca lang server options.
        if (MocaLanguageServer.mocaLanguageServerOptions.groovyStaticTypeCheckingEnabled) {
            // Adding type checking - see:
            // http://groovy-lang.org/semantics.html#static-type-checking
            config.addCompilationCustomizers(new ASTTransformationCustomizer(TypeChecked.class));
        }

        // Make sure not null before trying to set class path list.
        ArrayList<String> classpathConfig = getClasspathListForConfiguration();
        if (classpathConfig != null) {
            config.setClasspathList(classpathConfig);
        }

        return config;
    }

    private static ArrayList<String> getClasspathListForConfiguration() {
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

}
