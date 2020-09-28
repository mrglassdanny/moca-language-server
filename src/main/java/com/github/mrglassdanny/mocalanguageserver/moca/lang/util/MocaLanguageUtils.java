package com.github.mrglassdanny.mocalanguageserver.moca.lang.util;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.RangeUtils;

import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaLanguageUtils {

    public static MocaLanguageContext getMocaLanguageContextFromPosition(Position position,
            MocaCompilationResult mocaCompilationResult) {

        // Check moca sql.
        int mocaSqlCount = 0;
        for (Range range : mocaCompilationResult.mocaSqlRanges) {
            if (RangeUtils.contains(range, position)) {
                return new MocaLanguageContext(MocaLanguageContext.ContextId.MocaSql, mocaSqlCount);
            }
            mocaSqlCount++;
        }

        // Check groovy.
        int groovyCount = 0;
        for (Range range : mocaCompilationResult.groovyRanges) {
            if (RangeUtils.contains(range, position)) {
                return new MocaLanguageContext(MocaLanguageContext.ContextId.Groovy, groovyCount);
            }
            groovyCount++;
        }

        // Must be moca.
        return new MocaLanguageContext(MocaLanguageContext.ContextId.Moca, 0);
    }

    public static Token getMocaTokenAtPosition(Position pos, MocaCompilationResult mocaCompilationResult) {
        int idx = getMocaTokenIndexAtPosition(pos, mocaCompilationResult);
        return idx == -1 ? null : mocaCompilationResult.mocaTokens.get(idx);
    }

    public static int getMocaTokenIndexAtPosition(Position pos, MocaCompilationResult mocaCompilationResult) {
        int posOffset = PositionUtils.getOffset(mocaCompilationResult.script, pos);
        for (int i = 0; i < mocaCompilationResult.mocaTokens.size(); i++) {
            Token mocaToken = mocaCompilationResult.mocaTokens.get(i);

            // Have to manually calculate begin whitespace.
            int beginWhitespace = 0;
            if (i > 0) {
                beginWhitespace = MocaTokenUtils
                        .getAdjustedMocaTokenStopIndex(mocaCompilationResult.mocaTokens.get(i - 1).getStopIndex());
            }

            if (beginWhitespace <= posOffset
                    && MocaTokenUtils.getAdjustedMocaTokenStopIndex(mocaToken.getStopIndex()) >= posOffset) {
                return i;
            }
        }

        return -1;
    }

}
