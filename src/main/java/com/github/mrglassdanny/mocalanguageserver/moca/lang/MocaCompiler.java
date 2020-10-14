package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxErrorListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompiler;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.RangeUtils;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaCompiler {

    // Since mocasql/groovy ranges can be compiled independently of eachother, we
    // will utilize a simple thread pool.
    // However, we will keep resource usage in check a bit by only allowing a
    // maximum of 10 threads.
    private static ExecutorService embeddedLanguageCompilationThreadPool = Executors.newFixedThreadPool(10);

    public static MocaCompilationResult compileScript(final String mocaScript, final String uriStr) {

        MocaServices.logInfoToLanguageClient("COMPILING");

        MocaCompilationResult mocaCompilationResult = new MocaCompilationResult(mocaScript, uriStr);

        mocaCompilationResult.mocaParser = new MocaParser(
                new CommonTokenStream(new MocaLexer(CharStreams.fromString(mocaScript))));

        mocaCompilationResult.mocaSyntaxErrorListener = new MocaSyntaxErrorListener();
        mocaCompilationResult.mocaParser.addErrorListener(mocaCompilationResult.mocaSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        mocaCompilationResult.mocaParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = mocaCompilationResult.mocaParser.moca_script();
        mocaCompilationResult.mocaParseTreeListener = new MocaParseTreeListener();
        new ParseTreeWalker().walk(mocaCompilationResult.mocaParseTreeListener, parseTree);

        mocaCompilationResult.mocaTokens = new MocaLexer(CharStreams.fromString(mocaScript)).getAllTokens();

        // Update embedded lang ranges, then compile them.
        mocaCompilationResult.updateEmbeddedLanguageRanges(mocaScript);

        Collection<Callable<Boolean>> compileTasks = new ArrayList<Callable<Boolean>>();

        for (int i = 0; i < mocaCompilationResult.mocaSqlRanges.size(); i++) {
            final int rangeIdx = i;
            compileTasks.add(() -> {
                compileMocaSql(mocaScript, mocaCompilationResult, rangeIdx);
                return true;
            });
        }

        for (int i = 0; i < mocaCompilationResult.groovyRanges.size(); i++) {
            final int rangeIdx = i;
            compileTasks.add(() -> {
                compileGroovy(mocaScript, mocaCompilationResult, rangeIdx);
                return true;
            });
        }

        try {
            embeddedLanguageCompilationThreadPool.invokeAll(compileTasks);
        } catch (InterruptedException ex) {
            // Do nothing..
        }

        return mocaCompilationResult;
    }

    public static MocaCompilationResult compileScriptChanges(final String mocaScript, final String uriStr,
            Position changedPos, MocaCompilationResult previousMocaCompilationResult) {

        MocaServices.logInfoToLanguageClient("COMPILING CHANGES");

        // Need to compile moca regardless of where the change is, since technically
        // moca is changes regardless of where the change is.
        MocaCompilationResult mocaCompilationResult = new MocaCompilationResult(mocaScript, uriStr);

        mocaCompilationResult.mocaParser = new MocaParser(
                new CommonTokenStream(new MocaLexer(CharStreams.fromString(mocaScript))));

        mocaCompilationResult.mocaSyntaxErrorListener = new MocaSyntaxErrorListener();
        mocaCompilationResult.mocaParser.addErrorListener(mocaCompilationResult.mocaSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        mocaCompilationResult.mocaParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = mocaCompilationResult.mocaParser.moca_script();
        mocaCompilationResult.mocaParseTreeListener = new MocaParseTreeListener();
        new ParseTreeWalker().walk(mocaCompilationResult.mocaParseTreeListener, parseTree);

        mocaCompilationResult.mocaTokens = new MocaLexer(CharStreams.fromString(mocaScript)).getAllTokens();

        // Update embedded lang ranges.
        mocaCompilationResult.updateEmbeddedLanguageRanges(mocaScript);

        // Now we need to check if changed position is inside mocasql or groovy. If so,
        // we only need to compile that range and leave the rest alone. So let's go
        // ahead and set the new moca compilation results mocasql/groovy compilation
        // units to the previous ones'.
        mocaCompilationResult.mocaSqlCompilationResults = previousMocaCompilationResult.mocaSqlCompilationResults;
        mocaCompilationResult.groovyCompilationResults = previousMocaCompilationResult.groovyCompilationResults;

        // Now find changed position in either mocasql or groovy ranges. Once we find
        // it, we just need to compile that range and return our moca compilation
        // result.
        // If it is not in mocasql or groovy, then it must have been in moca.

        // NOTE: we will not worry about thread pool here since we are only going to
        // compile 1 range at most -- it would not make a difference to do so on a
        // different thread.

        // NOTE: we do not need to worry about other mocasql/groovy ranges being
        // invalidated due to this. Since we take into account where ranges are in
        // regards to the moca compilation result(createMocaPosition function in
        // MocaSqlLanguageUtils/GroovyLanguageUtils), all we need to do is make sure
        // that the moca compilation result embedded ranges are updated. This occurs
        // when we compile moca and call updateEmbeddedLangaugeRanges function.

        int mocaSqlRangeIdx = 0;
        for (Range mocaSqlRange : mocaCompilationResult.mocaSqlRanges) {
            if (RangeUtils.contains(mocaSqlRange, changedPos)) {
                MocaServices.logInfoToLanguageClient("FOUND IN SQL");
                compileMocaSql(mocaScript, mocaCompilationResult, mocaSqlRangeIdx);
                return mocaCompilationResult;
            } else {
                mocaSqlRangeIdx++;
            }
        }

        int groovyRangeIdx = 0;
        for (Range groovyRange : mocaCompilationResult.groovyRanges) {
            if (RangeUtils.contains(groovyRange, changedPos)) {
                MocaServices.logInfoToLanguageClient("FOUND IN GROOVY");
                compileGroovy(mocaScript, mocaCompilationResult, groovyRangeIdx);
                return mocaCompilationResult;
            } else {
                groovyRangeIdx++;
            }
        }

        return mocaCompilationResult;
    }

    private static void compileMocaSql(String mocaScript, MocaCompilationResult mocaCompilationResult,
            final int rangeIdx) {
        // Remove first and last characters('[', ']').
        String mocaSqlScript = RangeUtils.getText(mocaScript, mocaCompilationResult.mocaSqlRanges.get(rangeIdx));
        mocaSqlScript = mocaSqlScript.substring(1, mocaSqlScript.length() - 1);
        mocaCompilationResult.mocaSqlCompilationResults.put(rangeIdx, MocaSqlCompiler.compileScript(mocaSqlScript));
    }

    private static void compileGroovy(String mocaScript, MocaCompilationResult mocaCompilationResult,
            final int rangeIdx) {
        // Remove first and last instances of("[[", "]]").
        String groovyScript = RangeUtils.getText(mocaScript, mocaCompilationResult.groovyRanges.get(rangeIdx));
        groovyScript = groovyScript.substring(2, groovyScript.length() - 2);

        // Add prefixes to script.
        // Also add moca redirects, as long as they were 'declared' above current groovy
        // script range. We will initialize these as
        // SimpleResults objects, that way we dont get the static
        // type check warning and we get intellisense!

        // NOTE: obvious potential problem if redirect is in a different scope.. worst
        // case scenario is just the intellisense, so no need to make things more
        // complicated.
        String mocaRedirects = "";
        // Need to keep track of what we have added, that way we dont add 2 redirects
        // with the same name(will cause static type checking issue).
        ArrayList<String> addedMocaRedirectNames = new ArrayList<>();
        int groovyScriptOffset = PositionUtils.getOffset(mocaScript,
                mocaCompilationResult.groovyRanges.get(rangeIdx).getStart());

        for (Map.Entry<Token, String> entry : mocaCompilationResult.mocaParseTreeListener.redirects.entrySet()) {
            if (entry.getKey().getStartIndex() <= groovyScriptOffset) {
                String curMocaRedirectName = entry.getValue();
                if (!addedMocaRedirectNames.contains(curMocaRedirectName)) {
                    mocaRedirects += ("SimpleResults " + curMocaRedirectName + "; ");
                    addedMocaRedirectNames.add(curMocaRedirectName);
                }
            }
        }

        groovyScript = GroovyLanguageUtils.GROOVY_DEFAULT_IMPORTS + GroovyLanguageUtils.MOCA_GROOVY_SCRIPT_PREFIX
                + mocaRedirects + groovyScript;

        mocaCompilationResult.groovyCompilationResults.put(rangeIdx,
                GroovyCompiler.compileScript(rangeIdx, groovyScript));
    }
}