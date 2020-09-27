package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxErrorListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util.MocaSqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaTokenUtils;
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
    private static ExecutorService embeddedLanguageCompilationThreadPool = Executors.newCachedThreadPool();

    public List<? extends Token> mocaTokens;
    public MocaCompilationResult currentCompilationResult;

    public ArrayList<Range> mocaSqlRanges;
    public ArrayList<Range> groovyRanges;

    private MocaSqlCompiler mocaSqlCompiler;
    private GroovyCompiler groovyCompiler;

    public MocaCompiler() {
        this.mocaTokens = null;
        this.currentCompilationResult = null;

        this.mocaSqlRanges = new ArrayList<>();
        this.groovyRanges = new ArrayList<>();

        this.mocaSqlCompiler = new MocaSqlCompiler();
        this.groovyCompiler = new GroovyCompiler();
    }

    public MocaCompilationResult compileScript(String finalMocaScript) {

        MocaCompilationResult compilationResult = new MocaCompilationResult();
        this.currentCompilationResult = compilationResult;

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

        this.mocaTokens = new MocaLexer(CharStreams.fromString(finalMocaScript)).getAllTokens();

        // Update embedded lang ranges, then compile them.
        this.updateEmbeddedLanguageRanges(finalMocaScript);

        Collection<Callable<Boolean>> compileTasks = new ArrayList<Callable<Boolean>>();

        for (int i = 0; i < this.mocaSqlRanges.size(); i++) {
            final int rangeIdx = i;
            compileTasks.add(() -> {
                // Remove first and last characters('[', ']').
                String mocaSqlScript = RangeUtils.getText(finalMocaScript, this.mocaSqlRanges.get(rangeIdx));
                mocaSqlScript = mocaSqlScript.substring(1, mocaSqlScript.length() - 1);
                this.mocaSqlCompiler.compileScript(rangeIdx, mocaSqlScript);
                return true;
            });
        }

        for (int i = 0; i < this.groovyRanges.size(); i++) {
            final int rangeIdx = i;
            compileTasks.add(() -> {
                // Remove first and last instances of("[[", "]]").
                String groovyScript = RangeUtils.getText(finalMocaScript, this.groovyRanges.get(rangeIdx));
                groovyScript = groovyScript.substring(2, groovyScript.length() - 2);
                this.groovyCompiler.compileScript(rangeIdx, groovyScript, this, finalMocaScript);
                return true;
            });
        }

        try {
            embeddedLanguageCompilationThreadPool.invokeAll(compileTasks);
        } catch (InterruptedException ex) {
            // Do nothing..
        }

        compilationResult.mocaSqlCompilationResults = this.mocaSqlCompiler.compilationResults;
        compilationResult.groovyCompilationResults = this.groovyCompiler.compilationResults;

        return compilationResult;
    }

    public void updateEmbeddedLanguageRanges(String mocaScript) {
        this.mocaSqlRanges.clear();
        this.groovyRanges.clear();

        // Can assume we do not have any ranges if no moca tokens exist.
        if (this.mocaTokens == null) {
            return;
        }

        // Now just loop through tokens and find scripts.
        for (Token curMocaToken : this.mocaTokens) {
            if (curMocaToken.getType() == MocaLexer.SINGLE_BRACKET_STRING) {
                if (MocaSqlLanguageUtils.isMocaTokenValueMocaSqlScript(curMocaToken.getText())) {
                    this.mocaSqlRanges.add(new Range(
                            PositionUtils.getPosition(mocaScript, curMocaToken.getStartIndex()),
                            PositionUtils.getPosition(mocaScript,
                                    MocaTokenUtils.getAdjustedMocaTokenStopIndex(curMocaToken.getStopIndex()))));
                }
            } else if (curMocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING) {
                this.groovyRanges.add(new Range(PositionUtils.getPosition(mocaScript, curMocaToken.getStartIndex()),
                        PositionUtils.getPosition(mocaScript,
                                MocaTokenUtils.getAdjustedMocaTokenStopIndex(curMocaToken.getStopIndex()))));
            }
        }

    }

    public MocaLanguageContext getMocaLanguageContextFromPosition(Position position) {

        // Check moca sql.
        int mocaSqlCount = 0;
        for (Range range : this.mocaSqlRanges) {
            if (RangeUtils.contains(range, position)) {
                return new MocaLanguageContext(MocaLanguageContext.ContextId.MocaSql, mocaSqlCount);
            }
            mocaSqlCount++;
        }

        // Check groovy.
        int groovyCount = 0;
        for (Range range : this.groovyRanges) {
            if (RangeUtils.contains(range, position)) {
                return new MocaLanguageContext(MocaLanguageContext.ContextId.Groovy, groovyCount);
            }
            groovyCount++;
        }

        // Must be moca.
        return new MocaLanguageContext(MocaLanguageContext.ContextId.Moca, 0);
    }

    public Token getMocaTokenAtPosition(String mocaScript, Position pos) {
        int idx = this.getMocaTokenIndexAtPosition(mocaScript, pos);
        return idx == -1 ? null : this.mocaTokens.get(idx);
    }

    public int getMocaTokenIndexAtPosition(String mocaScript, Position pos) {
        int posOffset = PositionUtils.getOffset(mocaScript, pos);
        for (int i = 0; i < this.mocaTokens.size(); i++) {
            Token mocaToken = this.mocaTokens.get(i);

            // Have to manually calculate begin whitespace.
            int beginWhitespace = 0;
            if (i > 0) {
                beginWhitespace = MocaTokenUtils
                        .getAdjustedMocaTokenStopIndex(this.mocaTokens.get(i - 1).getStopIndex());
            }

            if (beginWhitespace <= posOffset
                    && MocaTokenUtils.getAdjustedMocaTokenStopIndex(mocaToken.getStopIndex()) >= posOffset) {
                return i;
            }
        }

        return -1;
    }

}