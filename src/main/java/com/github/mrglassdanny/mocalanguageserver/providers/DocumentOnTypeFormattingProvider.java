package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.SqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.util.SqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaTokenUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;

public class DocumentOnTypeFormattingProvider {

        private static final String NEWLINE = "\n";
        private static final String TAB = "\t";
        private static final String SPACE = " ";
        private static final String EMPTY = "";

        public static CompletableFuture<List<? extends TextEdit>> provideDocumentOnTypeFormatting(
                        DocumentOnTypeFormattingParams params, String textDocumentContents, MocaCompiler mocaCompiler) {

                // Check to see if file extension is marked as read only. If so, do not publish
                // any diagnostics.
                // This will be the case for any files created by command lookup functionality
                // in the client.
                String uriStr = params.getTextDocument().getUri();
                String uriExtStr = uriStr.substring(uriStr.lastIndexOf("."));
                if (uriExtStr.compareToIgnoreCase(".readonly") == 0) {
                        return CompletableFuture.completedFuture(new ArrayList<>());
                }

                ArrayList<TextEdit> edits = new ArrayList<>();

                formatMoca(edits, mocaCompiler, textDocumentContents, params.getPosition(), params.getCh());

                return CompletableFuture.completedFuture(edits);

        }

        private static void formatMoca(ArrayList<TextEdit> edits, MocaCompiler mocaCompiler, String mocaScript,
                        Position typedPos, String typedChar) {
                // This is how we will know what range index we are in.
                // Starting at -1 because we will increment counter before we get any data from
                // counter.
                int sqlRangesVisited = -1, groovyRangesVisited = -1;
                int mocaTokenCount = mocaCompiler.mocaTokens.size();
                org.antlr.v4.runtime.Token curMocaToken = null, prevMocaToken = null, nextMocaToken = null;
                StringBuilder indentBuilder = new StringBuilder();
                int parenStack = 0;
                int typedPosOffset = Positions.getOffset(mocaScript, typedPos), curMocaTokenOffset = 0;
                for (int i = 0; i < mocaTokenCount; i++) {

                        curMocaToken = mocaCompiler.mocaTokens.get(i);

                        int curMocaTokenStartIdx = curMocaToken.getStartIndex();
                        int curMocaTokenStopIdx = MocaTokenUtils
                                        .getAdjustedMocaTokenStopIndex(curMocaToken.getStopIndex());

                        curMocaTokenOffset = curMocaTokenStartIdx + 1; // Not 100% sure we we have to add 1...

                        if (i > 0) {
                                prevMocaToken = mocaCompiler.mocaTokens.get(i - 1);
                        } else {
                                prevMocaToken = null;
                        }

                        int prevMocaTokenStartIdx = curMocaTokenStartIdx;
                        int prevMocaTokenStopIdx = curMocaTokenStartIdx;
                        if (prevMocaToken != null) {
                                prevMocaTokenStartIdx = prevMocaToken.getStartIndex();
                                prevMocaTokenStopIdx = MocaTokenUtils
                                                .getAdjustedMocaTokenStopIndex(prevMocaToken.getStopIndex());
                        }

                        if (i < mocaTokenCount - 1) {
                                nextMocaToken = mocaCompiler.mocaTokens.get(i + 1);
                        } else {
                                nextMocaToken = null;
                        }

                        int nextMocaTokenStartIdx = curMocaTokenStopIdx;
                        int nextMocaTokenStopIdx = curMocaTokenStopIdx;
                        if (nextMocaToken != null) {
                                nextMocaTokenStartIdx = nextMocaToken.getStartIndex();
                                nextMocaTokenStopIdx = MocaTokenUtils
                                                .getAdjustedMocaTokenStopIndex(nextMocaToken.getStopIndex());
                        }

                        // Have to manually calculate begin whitespace.
                        int curMocaTokenBeginWhitespaceIdx = 0;
                        if (prevMocaToken != null) {
                                curMocaTokenBeginWhitespaceIdx = prevMocaTokenStopIdx;
                        }

                        switch (curMocaToken.getType()) {
                                case MocaLexer.SINGLE_BRACKET_STRING:
                                        // Dig into contents of bracket string.
                                        // Gonna be either sql or just a bracket string.
                                        String curMocaTokenValue = curMocaToken.getText();
                                        boolean isSql = false;

                                        // Making sure we are actually dealing with an sql statement before we
                                        // add this
                                        // range.
                                        if (SqlLanguageUtils.isMocaTokenValueSqlScript(curMocaTokenValue)) {
                                                isSql = true;
                                                sqlRangesVisited++;
                                        }
                                        // Else, just a bracket string.

                                        if (isSql) {

                                                // TODO: Implement sql formatting.

                                        } else {
                                                // Just a bracket string; do nothing.
                                        }

                                        break;
                                case MocaLexer.DOUBLE_BRACKET_STRING:
                                        groovyRangesVisited++;
                                        Range groovyScriptRange = mocaCompiler.groovyRanges.get(groovyRangesVisited);

                                        // Remove '[[]]'.
                                        String groovyScript = curMocaToken.getText().replaceAll("(\\[\\[)|(\\]\\])",
                                                        "");

                                        // TODO: Implement groovy formatting.
                                        break;
                                case MocaLexer.SEMI_COLON:

                                        // Remove whitespace before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        EMPTY));

                                        // Add newline to end only if we are at typedPos.
                                        // Since we are formatting above typedPos, typedPos's offset will either
                                        // be <=
                                        // current moca token offset. Make sure to quit right after!
                                        if (typedChar.compareToIgnoreCase(curMocaToken.getText()) == 0
                                                        && typedPosOffset <= curMocaTokenOffset) {

                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript, curMocaTokenStopIdx),
                                                                // It is not a mistake that we are repeating
                                                                // curMocaTokenStopIdx -- it is needed for
                                                                // proper semicolon formatting!
                                                                Positions.getPosition(mocaScript, curMocaTokenStopIdx)),
                                                                NEWLINE + indentBuilder.toString()));
                                                return;
                                        }

                                        break;
                                case MocaLexer.LEFT_BRACE:
                                        // Newline before(only if prev did not add new line
                                        // (pipe/amp/semicolon/open_brace)).
                                        if (prevMocaToken != null) {
                                                if (prevMocaToken.getType() != MocaLexer.PIPE
                                                                && prevMocaToken.getType() != MocaLexer.AMPERSAND
                                                                && prevMocaToken.getType() != MocaLexer.SEMI_COLON
                                                                && prevMocaToken.getType() != MocaLexer.LEFT_BRACE) {
                                                        edits.add(new TextEdit(new Range(
                                                                        Positions.getPosition(mocaScript,
                                                                                        curMocaTokenBeginWhitespaceIdx),
                                                                        Positions.getPosition(mocaScript,
                                                                                        curMocaTokenStartIdx)),
                                                                        SPACE));
                                                }
                                        }

                                        indentBuilder.append(TAB);
                                        break;
                                case MocaLexer.RIGHT_BRACE:

                                        if (indentBuilder.length() > 0) {
                                                indentBuilder.deleteCharAt(0);
                                        }
                                        break;
                                case MocaLexer.PIPE:
                                        // Need to make sure we are not dealing with a double pipe.
                                        // We will do this by checking next token and previous token.
                                        if (nextMocaToken != null && nextMocaToken.getType() == MocaLexer.PIPE) {
                                                // Space at beginning and remove whitespace after.
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaTokenBeginWhitespaceIdx),
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaTokenStartIdx)),
                                                                SPACE));
                                                edits.add(new TextEdit(
                                                                new Range(Positions.getPosition(mocaScript,
                                                                                curMocaTokenStopIdx),
                                                                                Positions.getPosition(mocaScript,
                                                                                                nextMocaTokenStartIdx)),
                                                                EMPTY));
                                        } else if (prevMocaToken != null && prevMocaToken.getType() == MocaLexer.PIPE) {
                                                // Space in back - we are remove whitespace between pipes in
                                                // cond above.
                                                edits.add(new TextEdit(
                                                                new Range(Positions.getPosition(mocaScript,
                                                                                curMocaTokenStopIdx),
                                                                                Positions.getPosition(mocaScript,
                                                                                                nextMocaTokenStartIdx)),
                                                                SPACE));
                                        } else {

                                                // Newline before.
                                                edits.add(new TextEdit(
                                                                new Range(Positions.getPosition(mocaScript,
                                                                                curMocaTokenBeginWhitespaceIdx),
                                                                                Positions.getPosition(mocaScript,
                                                                                                curMocaTokenStartIdx)),
                                                                NEWLINE + indentBuilder.toString()));

                                                // Add newline to end only if we are at typedPos.
                                                // Since we are formatting above typedPos, typedPos's offset
                                                // will either
                                                // be <=
                                                // current moca token offset. Make sure to quit right after!
                                                if (typedChar.compareToIgnoreCase(curMocaToken.getText()) == 0
                                                                && typedPosOffset <= curMocaTokenOffset) {

                                                        edits.add(new TextEdit(new Range(
                                                                        Positions.getPosition(mocaScript,
                                                                                        curMocaTokenStopIdx),
                                                                        Positions.getPosition(mocaScript,
                                                                                        nextMocaTokenStartIdx)),
                                                                        NEWLINE + indentBuilder.toString()));
                                                        return;
                                                }

                                        }
                                        break;
                                case MocaLexer.LEFT_PAREN:
                                        parenStack++;
                                        // Remove whitespace after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaTokenStopIdx),
                                                        Positions.getPosition(mocaScript, nextMocaTokenStartIdx)),
                                                        EMPTY));
                                        break;
                                case MocaLexer.RIGHT_PAREN:
                                        parenStack--;
                                        // Remove whitespace before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        EMPTY));
                                        break;
                                case MocaLexer.IF:
                                        // Remove whitespace after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaTokenStopIdx),
                                                        Positions.getPosition(mocaScript, nextMocaTokenStartIdx)),
                                                        EMPTY));
                                        break;
                                case MocaLexer.ELSE:
                                        // Space before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        SPACE));
                                        break;
                                case MocaLexer.DOUBLE_GREATER:
                                case MocaLexer.DOUBLE_PIPE:
                                case MocaLexer.EQUAL:
                                case MocaLexer.NOT_EQUAL:
                                case MocaLexer.LESS:
                                case MocaLexer.GREATER:
                                case MocaLexer.LESS_EQUAL:
                                case MocaLexer.GREATER_EQUAL:
                                case MocaLexer.LIKE:
                                case MocaLexer.OR:
                                case MocaLexer.NOT:
                                case MocaLexer.IS:
                                        // Space before and after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        SPACE));

                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaTokenStopIdx),
                                                        Positions.getPosition(mocaScript, nextMocaTokenStartIdx)),
                                                        SPACE));

                                        break;
                                case MocaLexer.WHERE:
                                        // Newline + tab before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        NEWLINE + TAB + indentBuilder.toString()));
                                        break;
                                case MocaLexer.AND:
                                        // Do not want to add newline if within parenthesis.
                                        if (parenStack > 0) {
                                                // Space before and after.
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaTokenBeginWhitespaceIdx),
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaTokenStartIdx)),
                                                                SPACE));
                                                edits.add(new TextEdit(
                                                                new Range(Positions.getPosition(mocaScript,
                                                                                curMocaTokenStopIdx),
                                                                                Positions.getPosition(mocaScript,
                                                                                                nextMocaTokenStartIdx)),
                                                                SPACE));
                                        } else {
                                                // Newline + tab + space before.
                                                edits.add(new TextEdit(
                                                                new Range(Positions.getPosition(mocaScript,
                                                                                curMocaTokenBeginWhitespaceIdx),
                                                                                Positions.getPosition(mocaScript,
                                                                                                curMocaTokenStartIdx)),
                                                                NEWLINE + TAB + indentBuilder.toString() + SPACE
                                                                                + SPACE));
                                        }

                                        break;
                                case MocaLexer.TRY:
                                        break;
                                case MocaLexer.CATCH:
                                        // Space before and remove whitespace after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        SPACE));

                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaTokenStopIdx),
                                                        Positions.getPosition(mocaScript, nextMocaTokenStartIdx)),
                                                        EMPTY));
                                        break;
                                case MocaLexer.FINALLY:
                                        break;
                                case MocaLexer.AMPERSAND:
                                        // Space before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        SPACE));

                                        // Add newline to end only if we are at typedPos.
                                        // Since we are formatting above typedPos, typedPos's offset will either
                                        // be <=
                                        // current moca token offset. Make sure to quit right after!
                                        if (typedChar.compareToIgnoreCase(curMocaToken.getText()) == 0
                                                        && typedPosOffset <= curMocaTokenOffset) {

                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript, curMocaTokenStopIdx),
                                                                Positions.getPosition(mocaScript,
                                                                                nextMocaTokenStartIdx)),
                                                                NEWLINE + indentBuilder.toString()));
                                                return;
                                        }

                                        break;
                                case MocaLexer.COMMA:
                                        // Remove whitespace before and add space after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript,
                                                                        curMocaTokenBeginWhitespaceIdx),
                                                        Positions.getPosition(mocaScript, curMocaTokenStartIdx)),
                                                        EMPTY));

                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaTokenStopIdx),
                                                        Positions.getPosition(mocaScript, nextMocaTokenStartIdx)),
                                                        SPACE));
                                        break;
                                default:
                                        break;
                        }

                }
        }

}