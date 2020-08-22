package com.github.mrglassdanny.mocalanguageserver.moca.lang.util;

import com.redprairie.moca.server.parse.MocaParseException;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaLanguageUtils {

    public static Range syntaxExceptionToRange(MocaParseException exception) {

        Position pos = new Position((int) exception.getArgValue("line"), (int) exception.getArgValue("byte"));

        return new Range(pos, pos);
    }
}