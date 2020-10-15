package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.ast.MocaSyntaxErrorListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util.MocaSqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaTokenUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.Range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

public class MocaCompilationResult {

    public final String script;
    public final String uriStr;
    public List<? extends Token> mocaTokens;
    public MocaParser mocaParser;
    public MocaParseTreeListener mocaParseTreeListener;
    public MocaSyntaxErrorListener mocaSyntaxErrorListener;
    public ArrayList<Range> mocaSqlRanges;
    public ArrayList<Range> groovyRanges;
    // sortedRanges list is mainly for compiling changed ranges in MocaCompiler
    // class.
    public ArrayList<MocaEmbeddedLanguageRange> sortedRanges;
    public HashMap<Integer, MocaSqlCompilationResult> mocaSqlCompilationResults;
    public HashMap<Integer, GroovyCompilationResult> groovyCompilationResults;

    public MocaCompilationResult(final String script, final String uriStr) {

        this.script = script;
        this.uriStr = uriStr;
        this.mocaTokens = null;
        this.mocaParser = null;
        this.mocaParseTreeListener = null;
        this.mocaSyntaxErrorListener = null;
        this.mocaSqlRanges = new ArrayList<>();
        this.groovyRanges = new ArrayList<>();
        this.sortedRanges = new ArrayList<>();
        this.mocaSqlCompilationResults = new HashMap<>();
        this.groovyCompilationResults = new HashMap<>();
    }

    public boolean hasMocaErrors() {
        return this.mocaSyntaxErrorListener != null && this.mocaSyntaxErrorListener.mocaSyntaxErrors.size() > 0;
    }

    public void updateEmbeddedLanguageRanges(String mocaScript) {
        this.mocaSqlRanges.clear();
        this.groovyRanges.clear();
        this.sortedRanges.clear();

        // Can assume we do not have any ranges if no moca tokens exist.
        if (this.mocaTokens == null) {
            return;
        }

        // Now just loop through tokens and find scripts.
        int mocaSqlRangeIdx = 0;
        int groovyRangeIdx = 0;
        for (Token curMocaToken : this.mocaTokens) {
            if (curMocaToken.getType() == MocaLexer.SINGLE_BRACKET_STRING) {
                if (MocaSqlLanguageUtils.isMocaTokenValueMocaSqlScript(curMocaToken.getText())) {
                    Range range = new Range(PositionUtils.getPosition(mocaScript, curMocaToken.getStartIndex()),
                            PositionUtils.getPosition(mocaScript,
                                    MocaTokenUtils.getAdjustedMocaTokenStopIndex(curMocaToken.getStopIndex())));
                    this.mocaSqlRanges.add(range);

                    // Add range to 'sorted' range map.
                    this.sortedRanges.add(new MocaEmbeddedLanguageRange(range,
                            new MocaLanguageContext(MocaLanguageContext.ContextId.MocaSql, mocaSqlRangeIdx++)));
                }
            } else if (curMocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING) {
                Range range = new Range(PositionUtils.getPosition(mocaScript, curMocaToken.getStartIndex()),
                        PositionUtils.getPosition(mocaScript,
                                MocaTokenUtils.getAdjustedMocaTokenStopIndex(curMocaToken.getStopIndex())));
                this.groovyRanges.add(range);

                // Add range to 'sorted' range map.
                this.sortedRanges.add(new MocaEmbeddedLanguageRange(range,
                        new MocaLanguageContext(MocaLanguageContext.ContextId.Groovy, groovyRangeIdx++)));
            }
        }

    }

}