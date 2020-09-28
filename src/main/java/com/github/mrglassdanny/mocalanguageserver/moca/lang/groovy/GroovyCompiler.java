package com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

import org.antlr.v4.runtime.Token;
import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
import org.codehaus.groovy.control.Phases;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer;

import groovy.lang.GroovyClassLoader;
import groovy.transform.TypeChecked;

public class GroovyCompiler {

    public static ArrayList<String> classpathList = new ArrayList<>();

    // Passing in moca script so that we can get redirects( >> res)
    // from moca so we can add groovy script prefix. We will initialize these as
    // SimpleResults objects, that way we dont get the static
    // type check warning and we get intellisense!
    public static GroovyCompilationResult compileScript(final int rangeIdx, String groovyScript, String mocaScript) {

        GroovyCompilationResult compilationResult = new GroovyCompilationResult();
        compilationResult.compilationUnit = createCompilationUnit();

        // Add prefixes to script.
        // Also add moca redirects, as long as they were 'declared' above current groovy
        // script range.
        String mocaRedirects = "";
        // Need to keep track of what we have added, that way we dont add 2 redirects
        // with the same name(will cause static type checking issue).
        ArrayList<String> addedMocaRedirectNames = new ArrayList<>();
        int groovyScriptOffset = PositionUtils.getOffset(mocaScript,
                MocaServices.mocaCompilationResult.groovyRanges.get(rangeIdx).getStart());
        if (MocaServices.mocaCompilationResult != null) {
            for (Map.Entry<Token, String> entry : MocaServices.mocaCompilationResult.mocaParseTreeListener.redirects
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

            // Check if static type checking is enabled via moca lang server options.
            if (MocaLanguageServer.mocaLanguageServerOptions.groovyStaticTypeCheckingEnabled) {
                compilationResult.compilationUnit.compile(Phases.INSTRUCTION_SELECTION);
            } else {
                compilationResult.compilationUnit.compile(Phases.CANONICALIZATION);
            }

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
        return compilationResult;

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
        // Adding type checking - see:
        // http://groovy-lang.org/semantics.html#static-type-checking
        config.addCompilationCustomizers(new ASTTransformationCustomizer(TypeChecked.class));

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
