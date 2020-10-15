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
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.RangeUtils;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.lsp4j.Position;

public class MocaCompiler {

    // Since mocasql/groovy ranges can be compiled independently of eachother, we
    // will utilize a simple thread pool.
    // However, we will keep resource usage in check a bit by only allowing a
    // maximum of 10 threads.
    private static ExecutorService embeddedLanguageCompilationThreadPool = Executors.newFixedThreadPool(10);

    public static MocaCompilationResult compileScript(final String mocaScript, final String uriStr) {

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
            int changeIdx, int changeLen, MocaCompilationResult previousMocaCompilationResult) {

        // Need to compile moca regardless of where the change is, since technically
        // moca is changed regardless of where the change is lang context-wise.
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

        // NOTE: we will not worry about using thread pool here since we are only going
        // to compile 1 range at most -- it would not make a difference to do so on a
        // different thread.

        // NOTE: we do not need to worry about other mocasql/groovy ranges being
        // invalidated due to this. Since we take into account where ranges are in
        // regards to the moca compilation result(createMocaPosition function in
        // MocaSqlLanguageUtils/GroovyLanguageUtils), all we need to do is make sure
        // that the moca compilation result embedded ranges are updated. This occurs
        // when we compile moca and call updateEmbeddedLangaugeRanges function.

        // Need to get start and end positions for processing below.
        // NOTE: changeLen could be negative number.
        Position startPos, endPos;

        startPos = PositionUtils.getPosition(mocaScript, changeIdx);
        endPos = PositionUtils.getPosition(mocaScript, changeIdx + Math.abs(changeLen));
        if (endPos == null) {
            endPos = PositionUtils.getPosition(mocaScript, mocaScript.length() - 1);
        }

        // We are going to go through each range in order of position in
        // file(sortedRanges list) and compile all ranges that are contained in changed
        // range.

        boolean foundStart = false;
        for (MocaEmbeddedLanguageRange mocaEmbeddedLanguageRange : mocaCompilationResult.sortedRanges) {

            if (!foundStart) {
                if (RangeUtils.contains(mocaEmbeddedLanguageRange.range, startPos)) {
                    if (mocaEmbeddedLanguageRange.mocaLanguageContext.id == MocaLanguageContext.ContextId.MocaSql) {
                        compileMocaSql(mocaScript, mocaCompilationResult,
                                mocaEmbeddedLanguageRange.mocaLanguageContext.rangeIdx);
                    } else if (mocaEmbeddedLanguageRange.mocaLanguageContext.id == MocaLanguageContext.ContextId.Groovy) {
                        compileGroovy(mocaScript, mocaCompilationResult,
                                mocaEmbeddedLanguageRange.mocaLanguageContext.rangeIdx);
                    }

                    foundStart = true;

                    // If range contains end position as well, we can just quit here!
                    if (RangeUtils.contains(mocaEmbeddedLanguageRange.range, endPos)) {
                        return mocaCompilationResult;
                    }
                }

            } else {
                // Need to compile range regardless of whether or not we contain end position
                // since we have already found start postion -- we can assume we are inside of
                // the changed range right now.
                if (mocaEmbeddedLanguageRange.mocaLanguageContext.id == MocaLanguageContext.ContextId.MocaSql) {
                    compileMocaSql(mocaScript, mocaCompilationResult,
                            mocaEmbeddedLanguageRange.mocaLanguageContext.rangeIdx);
                } else if (mocaEmbeddedLanguageRange.mocaLanguageContext.id == MocaLanguageContext.ContextId.Groovy) {
                    compileGroovy(mocaScript, mocaCompilationResult,
                            mocaEmbeddedLanguageRange.mocaLanguageContext.rangeIdx);
                }

                // Now we check if this range contains the end postion. If so, we quit!
                if (RangeUtils.contains(mocaEmbeddedLanguageRange.range, endPos)) {
                    return mocaCompilationResult;
                }
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