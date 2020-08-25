package com.github.mrglassdanny.mocalanguageserver.moca.lang.util;

import org.antlr.v4.runtime.RecognitionException;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaLanguageUtils {

    public static Range syntaxExceptionToRange(RecognitionException exception) {

        Position pos = new Position((int) exception.getOffendingToken().getLine(),
                (int) exception.getOffendingToken().getCharPositionInLine());

        return new Range(pos, pos);
    }
}