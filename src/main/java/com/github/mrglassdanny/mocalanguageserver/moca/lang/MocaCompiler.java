package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxErrorListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util.MocaSqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaTokenUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Ranges;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaCompiler {

    private static final Pattern XML_HEADER_PATTERN = Pattern
            .compile("<!\\[CDATA\\[(?=(?:[^(\"|')]*(\"|')[^(\"|')]*(\"|'))*[^(\"|')]*$)");

    public List<? extends Token> mocaTokens; // From lexer.
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

    // New thread per script.
    public MocaCompilationResult compileScript(String mocaScript) {

        MocaCompilationResult compilationResult = new MocaCompilationResult();
        this.currentCompilationResult = compilationResult;

        // Alter mocaScript to handle mcmd/mtrg xml header and footer text.
        // We should be able to just wrap these in comment blocks(will have to replace a
        // few characters in order to not mess up lexer token positions). That way the
        // lexer tokens' positions are correct and the moca compiler will not think
        // these sections are part of the script.
        // NOTE: there could be multiple XML_HEADER_PATTERN matches. That being said,
        // the first match should be the only one we care about.
        Matcher xmlHeaderMatcher = XML_HEADER_PATTERN.matcher(mocaScript);
        if (xmlHeaderMatcher.find()) {

            int headerStartIdx = 0;
            int headerEndIdx = xmlHeaderMatcher.end();
            int footerStartIdx = mocaScript.indexOf("]]>", headerEndIdx);
            int footerEndIdx = mocaScript.length() - 1;

            char[] mocaScriptCharArr = mocaScript.toCharArray();
            mocaScriptCharArr[headerStartIdx] = '/';
            mocaScriptCharArr[headerStartIdx + 1] = '*';
            mocaScriptCharArr[headerEndIdx - 1] = '*';
            mocaScriptCharArr[headerEndIdx] = '/';
            mocaScriptCharArr[footerStartIdx] = '/';
            mocaScriptCharArr[footerStartIdx + 1] = '*';
            mocaScriptCharArr[footerEndIdx - 1] = '*';
            mocaScriptCharArr[footerEndIdx] = '/';

            mocaScript = new String(mocaScriptCharArr);
        }

        // Making final so that we can introduce more threads.
        final String finalMocaScript = mocaScript;

        // If error, no exception will be thrown -- we will use the
        // MocaSyntaxErrorListener.

        compilationResult.mocaParser = new MocaParser(
                new CommonTokenStream(new MocaLexer(new ANTLRInputStream(finalMocaScript))));

        compilationResult.mocaSyntaxErrorListener = new MocaSyntaxErrorListener();
        compilationResult.mocaParser.addErrorListener(compilationResult.mocaSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        compilationResult.mocaParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = compilationResult.mocaParser.moca_script();
        compilationResult.mocaParseTreeListener = new MocaParseTreeListener();
        new ParseTreeWalker().walk(compilationResult.mocaParseTreeListener, parseTree);

        this.mocaTokens = new MocaLexer(new ANTLRInputStream(finalMocaScript)).getAllTokens();

        // Update embedded lang ranges, then compile them.
        this.updateEmbeddedLanguageRanges(finalMocaScript);

        // Before setting up infrastructure to compile sql and groovy, make sure there
        // is something to compile!

        // We are utilizing a very naive threading strategy below. The only way it could
        // bite us would be if there is a combined ~20000 sql/groovy contexts that need
        // to be compiled -- I am okay with risking our naive strategy for now!

        // Start with MOCA SQL.
        Thread mainMocaSqlThread = null;
        if (!this.mocaSqlRanges.isEmpty()) {

            mainMocaSqlThread = new Thread(() -> {
                ArrayList<Thread> mocaSqlThreads = new ArrayList<>();
                for (int i = 0; i < this.mocaSqlRanges.size(); i++) {

                    final int rangeIdx = i;

                    // Compiling moca sql ranges via another thread.
                    Thread mocaSqlThread = new Thread(() -> {
                        // Remove first and last characters('[', ']').
                        String mocaSqlScript = Ranges.getText(finalMocaScript, this.mocaSqlRanges.get(rangeIdx));
                        mocaSqlScript = mocaSqlScript.substring(1, mocaSqlScript.length() - 1);
                        this.mocaSqlCompiler.compileScript(rangeIdx, mocaSqlScript);
                    });

                    mocaSqlThread.start();
                    mocaSqlThreads.add(mocaSqlThread);

                }

                // Mark sure all sql threads are done before we leave.
                try {
                    for (Thread thread : mocaSqlThreads) {
                        thread.join();
                    }

                } catch (InterruptedException InterruptedException) {
                    // Do nothing...
                }
            });

            mainMocaSqlThread.start();

        }

        // Now Groovy.
        Thread mainGroovyThread = null;
        if (!this.groovyRanges.isEmpty()) {

            mainGroovyThread = new Thread(() -> {

                ArrayList<Thread> groovyThreads = new ArrayList<>();
                for (int i = 0; i < this.groovyRanges.size(); i++) {

                    final int rangeIdx = i;

                    // Compiling groovy ranges via another thread.
                    Thread groovyThread = new Thread(() -> {
                        // Remove '[[]]'.
                        String groovyScript = Ranges.getText(finalMocaScript, this.groovyRanges.get(rangeIdx));
                        groovyScript = groovyScript.substring(2, groovyScript.length() - 2);

                        this.groovyCompiler.compileScript(rangeIdx, groovyScript, this, finalMocaScript);
                    });

                    groovyThread.start();
                    groovyThreads.add(groovyThread);

                }

                // Mark sure all groovy threads are done before we leave.
                try {
                    for (Thread thread : groovyThreads) {
                        thread.join();
                    }
                } catch (InterruptedException InterruptedException) {
                    // Do nothing...
                }
            });

            mainGroovyThread.start();

        }

        // Wait for moca sql and groovy threads to finish.
        try {
            if (mainMocaSqlThread != null) {
                mainMocaSqlThread.join();
                compilationResult.mocaSqlCompilationResults = this.mocaSqlCompiler.compilationResults;
            }
            if (mainGroovyThread != null) {
                mainGroovyThread.join();
                compilationResult.groovyCompilationResults = this.groovyCompiler.compilationResults;
            }

        } catch (InterruptedException InterruptedException) {
            // Do nothing...
        }

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
                    this.mocaSqlRanges.add(new Range(Positions.getPosition(mocaScript, curMocaToken.getStartIndex()),
                            Positions.getPosition(mocaScript,
                                    MocaTokenUtils.getAdjustedMocaTokenStopIndex(curMocaToken.getStopIndex()))));
                }
            } else if (curMocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING) {
                this.groovyRanges.add(new Range(Positions.getPosition(mocaScript, curMocaToken.getStartIndex()),
                        Positions.getPosition(mocaScript,
                                MocaTokenUtils.getAdjustedMocaTokenStopIndex(curMocaToken.getStopIndex()))));
            }
        }

    }

    public MocaLanguageContext getMocaLanguageContextFromPosition(Position position) {

        // Check moca sql.
        int mocaSqlCount = 0;
        for (Range range : this.mocaSqlRanges) {
            if (Ranges.contains(range, position)) {
                return new MocaLanguageContext(MocaLanguageContext.ContextId.MocaSql, mocaSqlCount);
            }
            mocaSqlCount++;
        }

        // Check groovy.
        int groovyCount = 0;
        for (Range range : this.groovyRanges) {
            if (Ranges.contains(range, position)) {
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
        int posOffset = Positions.getOffset(mocaScript, pos);
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