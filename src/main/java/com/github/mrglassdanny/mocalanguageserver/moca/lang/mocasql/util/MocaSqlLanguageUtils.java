package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlSyntaxError;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.RangeUtils;

import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaSqlLanguageUtils {

    public static final Pattern MOCA_SQL_RANGE_START_WORD_PATTERN = Pattern
            .compile("(?i)\\b(select|update|delete|insert|create|alter|drop)\\b");

    public static Position createMocaPosition(int line, int column, Range scriptRange) {
        int lspLine = line;
        if (lspLine > 0) {
            lspLine--;
        }
        int lspColumn = column;
        if (lspColumn > 0) {
            lspColumn--;
        }

        // +1 to column due to antlr lexer starting the column an index too early.
        // We are doing something similar in MocaTokenUtils class.
        lspColumn++;

        // If the line is 0, we need to keep the char offset in mind.
        if (lspLine == 0) {
            return new Position(lspLine + scriptRange.getStart().getLine(),
                    lspColumn + scriptRange.getStart().getCharacter() + 1); // +1 for '['.
        } else {
            return new Position(lspLine + scriptRange.getStart().getLine(), lspColumn);
        }
    }

    public static Position createMocaPosition(String script, int offset, Range scriptRange) {

        Position sqlPos = PositionUtils.getPosition(script, offset + 1); // +1 for '['.

        // This probably wont happen..
        if (sqlPos == null) {
            return new Position(0, 0);
        }

        int lspLine = sqlPos.getLine(); // No need to subtract from line in this case.

        int lspColumn = sqlPos.getCharacter();
        if (lspColumn > 0) {
            lspColumn--;
        }

        // +1 to column due to antlr lexer starting the column an index too early.
        // We are doing something similar in MocaTokenUtils class.
        lspColumn++;

        if (lspLine == 0) {
            return new Position(lspLine + scriptRange.getStart().getLine(),
                    lspColumn + scriptRange.getStart().getCharacter());
        } else {
            return new Position(lspLine + scriptRange.getStart().getLine(), lspColumn);
        }

    }

    public static Range syntaxExceptionToRange(MocaSqlSyntaxError err, Range scriptRange) {
        return new Range(createMocaPosition(err.line, err.charPositionInLine, scriptRange),
                createMocaPosition(err.line, err.charPositionInLine, scriptRange));
    }

    public static boolean isMocaSqlScript(String str) {
        Matcher mocaSqlStartWordMatcher = MocaSqlLanguageUtils.MOCA_SQL_RANGE_START_WORD_PATTERN.matcher(str);
        if (mocaSqlStartWordMatcher.find()) {
            return true;
        } else {
            return false;
        }

    }

    public static Token getMocaSqlTokenAtPosition(Position pos, MocaCompilationResult mocaCompilationResult) {

        for (MocaSqlCompilationResult mocaSqlCompilationResult : mocaCompilationResult.mocaSqlCompilationResults
                .values()) {

            if (RangeUtils.contains(mocaSqlCompilationResult.range, pos)) {
                for (int i = 0; i < mocaSqlCompilationResult.mocaSqlTokens.size(); i++) {
                    Token mocaSqlToken = mocaSqlCompilationResult.mocaSqlTokens.get(i);

                    // Need to translate mocasqlToken positions into MOCA positions before we test
                    // whether or not this is our token.
                    Position adjMocasqlBeginTokenPos = createMocaPosition(mocaSqlToken.getLine(),
                            mocaSqlToken.getCharPositionInLine(), mocaSqlCompilationResult.range);
                    Position adjMocasqlEndTokenPos = new Position(adjMocasqlBeginTokenPos.getLine(),
                            adjMocasqlBeginTokenPos.getCharacter() + mocaSqlToken.getText().length());

                    if (RangeUtils.contains(new Range(adjMocasqlBeginTokenPos, adjMocasqlEndTokenPos), pos)) {
                        return mocaSqlToken;
                    }
                }
            }
        }

        return null;
    }
}