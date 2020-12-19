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
import org.eclipse.lsp4j.util.Positions;
import org.eclipse.lsp4j.util.Ranges;

public class MocaCompiler {

    // Since mocasql/groovy ranges can be compiled independently of eachother, we
    // will utilize a simple thread pool.
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static MocaCompilationResult compileScript(final String mocaScript, final String uriStr) {

        MocaCompilationResult mocaCompilationResult = new MocaCompilationResult(mocaScript, uriStr);

        mocaCompilationResult.mocaTokens = new MocaLexer(CharStreams.fromString(mocaScript)).getAllTokens();
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

        // Set embedded lang ranges, then compile them.
        mocaCompilationResult.setMocaEmbeddedLanguageRanges(mocaScript);

        Collection<Callable<Boolean>> compileTasks = new ArrayList<Callable<Boolean>>();

        for (MocaEmbeddedLanguageRange mocaEmbeddedLanguageRange : mocaCompilationResult.mocaEmbeddedLanguageRanges) {

            switch (mocaEmbeddedLanguageRange.mocaLanguageContext.id) {
                case MocaSql:
                    compileTasks.add(() -> {
                        compileMocaSql(mocaScript, mocaCompilationResult, mocaEmbeddedLanguageRange.range,
                                mocaEmbeddedLanguageRange.mocaLanguageContext.compilationResultIdx);
                        return true;
                    });
                    break;
                case Groovy:
                    compileTasks.add(() -> {
                        compileGroovy(mocaScript, mocaCompilationResult, mocaEmbeddedLanguageRange.range,
                                mocaEmbeddedLanguageRange.mocaLanguageContext.compilationResultIdx);
                        return true;
                    });
                    break;
                default:
                    break;
            }
        }

        try {
            threadPool.invokeAll(compileTasks);
        } catch (InterruptedException ex) {
            // Do nothing..
        }

        return mocaCompilationResult;
    }

    public static MocaCompilationResult compileScriptChanges(final String mocaScript, final String uriStr,
            ArrayList<Integer> changedLineNums, MocaCompilationResult previousMocaCompilationResult) {

        // Need to compile moca regardless of where the change is, since technically
        // moca is changed regardless of where the change is lang context-wise.
        MocaCompilationResult mocaCompilationResult = new MocaCompilationResult(mocaScript, uriStr);

        mocaCompilationResult.mocaTokens = new MocaLexer(CharStreams.fromString(mocaScript)).getAllTokens();
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

        // Set embedded lang ranges.
        mocaCompilationResult.setMocaEmbeddedLanguageRanges(mocaScript);

        // Now that we have updated embedded lang ranges, the plan is to compare changed
        // line numbers to the ranges and only compile those ranges that contain/border
        // a changed line number.

        // Keep existing mocasql/groovy compilation results for now, since only a subset
        // may need to be re-compiled and replaced.
        mocaCompilationResult.mocaSqlCompilationResults = previousMocaCompilationResult.mocaSqlCompilationResults;
        mocaCompilationResult.groovyCompilationResults = previousMocaCompilationResult.groovyCompilationResults;

        // Will use thread pool to compile changes.
        Collection<Callable<Boolean>> compileTasks = new ArrayList<Callable<Boolean>>();

        // This variable is here to make sure we do not revisit already seen changed
        // line numbers.
        int visitedChangedLineCount = 0;
        for (MocaEmbeddedLanguageRange mocaEmbeddedLanguageRange : mocaCompilationResult.mocaEmbeddedLanguageRanges) {

            MocaServices.logInfoToLanguageClient(String.format("Checking Range: %s", mocaEmbeddedLanguageRange.range));

            for (int i = visitedChangedLineCount; i < changedLineNums.size(); i++) {
                int changedLineNum = changedLineNums.get(i);

                MocaServices.logInfoToLanguageClient(String.format("Changed Line Num: %d", changedLineNum));

                // Checking if changed line number is inside/part of range.
                if (mocaEmbeddedLanguageRange.range.getStart().getLine() <= changedLineNum
                        && mocaEmbeddedLanguageRange.range.getEnd().getLine() >= changedLineNum) {

                    // Add for compile.
                    if (mocaEmbeddedLanguageRange.mocaLanguageContext.id == MocaLanguageContext.ContextId.MocaSql) {
                        compileTasks.add(() -> {
                            compileMocaSql(mocaScript, mocaCompilationResult, mocaEmbeddedLanguageRange.range,
                                    mocaEmbeddedLanguageRange.mocaLanguageContext.compilationResultIdx);
                            return true;
                        });
                    } else if (mocaEmbeddedLanguageRange.mocaLanguageContext.id == MocaLanguageContext.ContextId.Groovy) {
                        compileTasks.add(() -> {
                            compileGroovy(mocaScript, mocaCompilationResult, mocaEmbeddedLanguageRange.range,
                                    mocaEmbeddedLanguageRange.mocaLanguageContext.compilationResultIdx);
                            return true;
                        });
                    }

                    // Now that we have added range for compilation, we can break from changed line
                    // nums loop to move
                    // onto the next range.
                    break;

                } else {
                    // Checking if changed line number is before and not contained/bordering range.
                    if (changedLineNum < mocaEmbeddedLanguageRange.range.getStart().getLine()) {
                        // If so, we need to move onto the next changed line number and not revisit this
                        // one.
                        visitedChangedLineCount++;
                    }
                }
            }

            // Can leave when we have visited all of the changed line numbers.
            if (visitedChangedLineCount == changedLineNums.size()) {
                break;
            }
        }

        // Now compile ranges.
        try {
            threadPool.invokeAll(compileTasks);
            MocaServices.logInfoToLanguageClient("COMPILED RANGES: " + compileTasks.size());
        } catch (InterruptedException ex) {
            // Do nothing..
        }

        return mocaCompilationResult;
    }

    private static void compileMocaSql(String mocaScript, MocaCompilationResult mocaCompilationResult, Range range,
            final int compilationResultIdx) {
        // Remove first and last characters('[', ']').
        String mocaSqlScript = RangeUtils.getText(mocaScript, range);
        mocaSqlScript = mocaSqlScript.substring(1, mocaSqlScript.length() - 1);
        mocaCompilationResult.mocaSqlCompilationResults.put(compilationResultIdx,
                MocaSqlCompiler.compileScript(mocaSqlScript, range));
    }

    private static void compileGroovy(String mocaScript, MocaCompilationResult mocaCompilationResult, Range range,
            final int compilationResultIdx) {
        // Remove first and last instances of("[[", "]]").
        String groovyScript = RangeUtils.getText(mocaScript, range);
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
        int groovyScriptOffset = PositionUtils.getOffset(mocaScript, range.getStart());

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

        mocaCompilationResult.groovyCompilationResults.put(compilationResultIdx,
                GroovyCompiler.compileScript(compilationResultIdx, groovyScript, range));
    }
}