package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxErrorListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompiler;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.RangeUtils;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class MocaCompiler {

    // Since mocasql/groovy ranges can be compiled independently of eachother, we
    // will utilize a simple thread pool.
    private static ExecutorService embeddedLanguageCompilationThreadPool = Executors.newCachedThreadPool();

    public static MocaCompilationResult compileScript(String finalMocaScript) {

        MocaCompilationResult compilationResult = new MocaCompilationResult();

        compilationResult.mocaParser = new MocaParser(
                new CommonTokenStream(new MocaLexer(CharStreams.fromString(finalMocaScript))));

        compilationResult.mocaSyntaxErrorListener = new MocaSyntaxErrorListener();
        compilationResult.mocaParser.addErrorListener(compilationResult.mocaSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        compilationResult.mocaParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = compilationResult.mocaParser.moca_script();
        compilationResult.mocaParseTreeListener = new MocaParseTreeListener();
        new ParseTreeWalker().walk(compilationResult.mocaParseTreeListener, parseTree);

        compilationResult.mocaTokens = new MocaLexer(CharStreams.fromString(finalMocaScript)).getAllTokens();

        // Update embedded lang ranges, then compile them.
        compilationResult.updateEmbeddedLanguageRanges(finalMocaScript);

        Collection<Callable<Boolean>> compileTasks = new ArrayList<Callable<Boolean>>();

        for (int i = 0; i < compilationResult.mocaSqlRanges.size(); i++) {
            final int rangeIdx = i;
            compileTasks.add(() -> {
                // Remove first and last characters('[', ']').
                String mocaSqlScript = RangeUtils.getText(finalMocaScript,
                        compilationResult.mocaSqlRanges.get(rangeIdx));
                mocaSqlScript = mocaSqlScript.substring(1, mocaSqlScript.length() - 1);
                compilationResult.mocaSqlCompilationResults.put(rangeIdx, MocaSqlCompiler.compileScript(mocaSqlScript));
                return true;
            });
        }

        for (int i = 0; i < compilationResult.groovyRanges.size(); i++) {
            final int rangeIdx = i;
            compileTasks.add(() -> {
                // Remove first and last instances of("[[", "]]").
                String groovyScript = RangeUtils.getText(finalMocaScript, compilationResult.groovyRanges.get(rangeIdx));
                groovyScript = groovyScript.substring(2, groovyScript.length() - 2);
                compilationResult.groovyCompilationResults.put(rangeIdx,
                        GroovyCompiler.compileScript(rangeIdx, groovyScript, finalMocaScript));
                return true;
            });
        }

        try {
            embeddedLanguageCompilationThreadPool.invokeAll(compileTasks);
        } catch (InterruptedException ex) {
            // Do nothing..
        }

        return compilationResult;
    }
}