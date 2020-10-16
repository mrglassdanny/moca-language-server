package com.github.mrglassdanny.mocalanguageserver.moca.lang.util;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaEmbeddedLanguageRange;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.RangeUtils;

import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.Position;

public class MocaLanguageUtils {

    public static MocaLanguageContext getMocaLanguageContextFromPosition(Position position,
            MocaCompilationResult mocaCompilationResult) {

        // Check inside mocasql and groovy ranges.
        for (MocaEmbeddedLanguageRange mocaEmbeddedLanguageRange : mocaCompilationResult.mocaEmbeddedLanguageRanges) {
            if (RangeUtils.contains(mocaEmbeddedLanguageRange.range, position)) {
                return mocaEmbeddedLanguageRange.mocaLanguageContext;
            }
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
