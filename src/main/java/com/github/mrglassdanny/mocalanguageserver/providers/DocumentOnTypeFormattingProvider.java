package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.SqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.util.SqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.reimpl.MocaLexerReImpl.MocaToken;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;
import com.redprairie.moca.server.parse.MocaTokenType;

import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;

import net.sf.jsqlparser.parser.SimpleNode;
import net.sf.jsqlparser.parser.Token;

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
                int mocaTokenCount = mocaCompiler.mocaTokens.length;
                MocaToken curMocaToken = null, prevMocaToken = null, nextMocaToken = null;
                StringBuilder indentBuilder = new StringBuilder();
                int parenStack = 0;
                int typedPosOffset = Positions.getOffset(mocaScript, typedPos), curMocaTokenOffset = 0;
                for (int i = 0; i < mocaTokenCount; i++) {

                        curMocaToken = mocaCompiler.mocaTokens[i];
                        curMocaTokenOffset = curMocaToken.beginToken + 1; // Not 100% sure we we have to add 1...

                        if (i > 0) {
                                prevMocaToken = mocaCompiler.mocaTokens[i - 1];
                        } else {
                                prevMocaToken = null;
                        }

                        if (i < mocaTokenCount - 1) {
                                nextMocaToken = mocaCompiler.mocaTokens[i + 1];
                        } else {
                                nextMocaToken = null;
                        }

                        switch (curMocaToken.type) {
                                case BRACKET_STRING:
                                        // Dig into contents of bracket string.
                                        // Gonna be either groovy or sql.
                                        String curMocaTokenValue = curMocaToken.getValue();
                                        int curMocaTokenValueLen = curMocaTokenValue.length();
                                        boolean isSql = false, isGroovy = false;
                                        if (curMocaTokenValueLen >= 4 && curMocaTokenValue.charAt(1) == '['
                                                        && curMocaTokenValue.charAt(curMocaTokenValueLen - 2) == ']') {
                                                isGroovy = true;
                                                groovyRangesVisited++;
                                        } else {
                                                // Making sure we are actually dealing with an sql statement before we
                                                // add this
                                                // range.
                                                if (SqlLanguageUtils.isMocaTokenValueSqlScript(curMocaTokenValue)) {
                                                        isSql = true;
                                                        sqlRangesVisited++;
                                                }
                                                // Else, just a bracket string.
                                        }

                                        if (isSql) {

                                                // Got our range.
                                                // Look up the ast and iterate over nodes.
                                                Range sqlScriptRange = mocaCompiler.sqlRanges.get(sqlRangesVisited);
                                                SqlCompilationResult sqlCompilationResult = mocaCompiler.currentCompilationResult.sqlCompilationResults
                                                                .get(sqlRangesVisited);
                                                if (sqlCompilationResult != null) {
                                                        formatSql(edits, sqlCompilationResult, sqlScriptRange,
                                                                        curMocaTokenValue, indentBuilder);
                                                }

                                        } else if (isGroovy) {

                                                Range groovyScriptRange = mocaCompiler.groovyRanges
                                                                .get(groovyRangesVisited);

                                                // Remove '[[]]'.
                                                String groovyScript = curMocaTokenValue.replaceAll("(\\[\\[)|(\\]\\])",
                                                                "");

                                                // Format.

                                        } else {
                                                // Just a bracket string; do nothing.
                                        }

                                        break;
                                case SEMICOLON:
                                        // Remove whitespace before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        EMPTY));

                                        // Add newline to end only if we are at typedPos.
                                        // Since we are formatting above typedPos, typedPos's offset will either be <=
                                        // current moca token offset. Make sure to quit right after!
                                        if (typedChar.compareToIgnoreCase(curMocaToken.getValue()) == 0
                                                        && typedPosOffset <= curMocaTokenOffset) {

                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript, curMocaToken.end),
                                                                Positions.getPosition(mocaScript, curMocaToken.end)),
                                                                NEWLINE + indentBuilder.toString()));
                                                return;
                                        }
                                        break;
                                case OPEN_BRACE:
                                        // Newline before(only if prev did not add new line
                                        // (pipe/amp/semicolon/open_brace)).
                                        if (prevMocaToken != null) {
                                                if (prevMocaToken.type != MocaTokenType.PIPE
                                                                && prevMocaToken.type != MocaTokenType.AMPERSAND
                                                                && prevMocaToken.type != MocaTokenType.SEMICOLON
                                                                && prevMocaToken.type != MocaTokenType.OPEN_BRACE) {
                                                        edits.add(new TextEdit(new Range(
                                                                        Positions.getPosition(mocaScript,
                                                                                        curMocaToken.beginWhitespace),
                                                                        Positions.getPosition(mocaScript,
                                                                                        curMocaToken.beginToken)),
                                                                        SPACE));
                                                }
                                        }

                                        indentBuilder.append(TAB);
                                        break;
                                case CLOSE_BRACE:

                                        if (indentBuilder.length() > 0) {
                                                indentBuilder.deleteCharAt(0);
                                        }
                                        break;
                                case PIPE:
                                        // Need to make sure we are not dealing with a double pipe.
                                        // We will do this by checking next token and previous token.
                                        if (nextMocaToken != null && nextMocaToken.type == MocaTokenType.PIPE) {
                                                // Space at beginning and remove whitespace after.
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginWhitespace),
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginToken)),
                                                                SPACE));
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript, curMocaToken.end),
                                                                Positions.getPosition(mocaScript, (nextMocaToken == null
                                                                                ? curMocaToken.end
                                                                                : nextMocaToken.beginToken))),
                                                                EMPTY));
                                        } else if (prevMocaToken != null && prevMocaToken.type == MocaTokenType.PIPE) {
                                                // Space in back - we are remove whitespace between pipes in cond above.
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript, curMocaToken.end),
                                                                Positions.getPosition(mocaScript, (nextMocaToken == null
                                                                                ? curMocaToken.end
                                                                                : nextMocaToken.beginToken))),
                                                                SPACE));
                                        } else {
                                                // Newline before.
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginWhitespace),
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginToken)),
                                                                NEWLINE + indentBuilder.toString()));

                                                // Add newline to end only if we are at typedPos.
                                                // Since we are formatting above typedPos, typedPos's offset will either
                                                // be <=
                                                // current moca token offset. Make sure to quit right after!
                                                if (typedChar.compareToIgnoreCase(curMocaToken.getValue()) == 0
                                                                && typedPosOffset <= curMocaTokenOffset) {

                                                        edits.add(new TextEdit(new Range(
                                                                        Positions.getPosition(mocaScript,
                                                                                        curMocaToken.end),
                                                                        Positions.getPosition(mocaScript,
                                                                                        curMocaToken.end)),
                                                                        NEWLINE + indentBuilder.toString()));
                                                        return;
                                                }
                                        }
                                        break;
                                case OPEN_PAREN:
                                        parenStack++;
                                        // Remove whitespace after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.end),
                                                        Positions.getPosition(mocaScript,
                                                                        (nextMocaToken == null ? curMocaToken.end
                                                                                        : nextMocaToken.beginToken))),
                                                        EMPTY));
                                        break;
                                case CLOSE_PAREN:
                                        parenStack--;
                                        // Remove whitespace before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        EMPTY));
                                        break;
                                case IF:
                                        // Remove whitespace after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.end),
                                                        Positions.getPosition(mocaScript,
                                                                        (nextMocaToken == null ? curMocaToken.end
                                                                                        : nextMocaToken.beginToken))),
                                                        EMPTY));
                                        break;
                                case ELSE:
                                        // Space before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        SPACE));
                                        break;
                                case REDIR_INTO:
                                case DOUBLEPIPE:
                                case EQ:
                                case NE:
                                case LT:
                                case GT:
                                case LE:
                                case GE:
                                case LIKE:
                                case OR:
                                case NOT:
                                case IS:
                                        // Space before and after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        SPACE));

                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.end),
                                                        Positions.getPosition(mocaScript,
                                                                        (nextMocaToken == null ? curMocaToken.end
                                                                                        : nextMocaToken.beginToken))),
                                                        SPACE));

                                        break;
                                case WHERE:
                                        // Newline + tab before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        NEWLINE + TAB + indentBuilder.toString()));
                                        break;
                                case AND:
                                        // Do not want to add newline if within parenthesis.
                                        if (parenStack > 0) {
                                                // Space before and after.
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginWhitespace),
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginToken)),
                                                                SPACE));
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript, curMocaToken.end),
                                                                Positions.getPosition(mocaScript, (nextMocaToken == null
                                                                                ? curMocaToken.end
                                                                                : nextMocaToken.beginToken))),
                                                                SPACE));
                                        } else {
                                                // Newline + tab + space before.
                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginWhitespace),
                                                                Positions.getPosition(mocaScript,
                                                                                curMocaToken.beginToken)),
                                                                NEWLINE + TAB + indentBuilder.toString() + SPACE
                                                                                + SPACE));
                                        }

                                        break;
                                case TRY:
                                        break;
                                case CATCH:
                                        // Space before and remove whitespace after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        SPACE));

                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.end),
                                                        Positions.getPosition(mocaScript,
                                                                        (nextMocaToken == null ? curMocaToken.end
                                                                                        : nextMocaToken.beginToken))),
                                                        EMPTY));
                                        break;
                                case FINALLY:
                                        break;
                                case AMPERSAND:
                                        // Space before.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        SPACE));

                                        // Add newline to end only if we are at typedPos.
                                        // Since we are formatting above typedPos, typedPos's offset will either be <=
                                        // current moca token offset. Make sure to quit right after!
                                        if (typedChar.compareToIgnoreCase(curMocaToken.getValue()) == 0
                                                        && typedPosOffset <= curMocaTokenOffset) {

                                                edits.add(new TextEdit(new Range(
                                                                Positions.getPosition(mocaScript, curMocaToken.end),
                                                                Positions.getPosition(mocaScript, curMocaToken.end)),
                                                                NEWLINE + indentBuilder.toString()));
                                                return;
                                        }
                                        break;
                                case COMMA:
                                        // Remove whitespace before and add space after.
                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.beginWhitespace),
                                                        Positions.getPosition(mocaScript, curMocaToken.beginToken)),
                                                        EMPTY));

                                        edits.add(new TextEdit(new Range(
                                                        Positions.getPosition(mocaScript, curMocaToken.end),
                                                        Positions.getPosition(mocaScript,
                                                                        (nextMocaToken == null ? curMocaToken.end
                                                                                        : nextMocaToken.beginToken))),
                                                        SPACE));
                                        break;
                                default:
                                        break;
                        }

                }
        }

        private static void formatSql(ArrayList<TextEdit> edits, SqlCompilationResult sqlCompilationResult,
                        Range sqlScriptRange, String sqlScript, StringBuilder mocaIndentBuilder) {
                SimpleNode root = sqlCompilationResult.astVisitor.rootNode;
                if (root != null) {

                        // Couple helper vars:
                        int parenStack = 0;
                        int subqueryMarker = 0;
                        StringBuilder subqueryIndentBuilder = new StringBuilder();

                        Token curSqlToken = root.jjtGetFirstToken();
                        Token prevSqlToken = null;
                        // Using these 4 vars because we want a similar setup to
                        // MOCA.
                        int beginWhitespace, begin, end, nextBegin;

                        while (curSqlToken != null) {
                                begin = curSqlToken.absoluteBegin;
                                end = curSqlToken.absoluteEnd;

                                if (prevSqlToken == null) {
                                        beginWhitespace = begin;
                                } else {
                                        beginWhitespace = prevSqlToken.absoluteEnd;
                                }

                                if (curSqlToken.next == null) {
                                        nextBegin = end;
                                } else {
                                        // Pretty sure this is a bug:
                                        // On delete statements, 'delete from' is valid syntax. The 'from' token for
                                        // some reason ends up having an empty string as it's next token. The empty
                                        // string's absolute begin is the same as the 'from' token's absolute begin.
                                        // This causes the 'from' token to get deleted during formatting.
                                        if (curSqlToken.next.image.isEmpty()) {
                                                nextBegin = end;
                                        } else {
                                                nextBegin = curSqlToken.next.absoluteBegin;
                                        }

                                }

                                // Check for comments: comments are represented as a special token attached the
                                // current token.
                                if (curSqlToken.specialToken != null) {
                                        Token specialSqlToken = curSqlToken.specialToken;

                                        // If multiple comment sections, need to traverse the last one.
                                        while (specialSqlToken.specialToken != null) {
                                                specialSqlToken = specialSqlToken.specialToken;
                                        }

                                        // NOTE: for whatever reason, absoluteBegin and absoluteEnd are not set for
                                        // special token.
                                        // However, beginLine/beginColumn & endLine/endColumn are.
                                        // Need to subtract 1 from lines and cols due to lsp.
                                        int specialSqlTokenAbsoluteBegin = Positions.getOffset(sqlScript,
                                                        new Position(specialSqlToken.beginLine - 1,
                                                                        specialSqlToken.beginColumn - 1));
                                        int specialSqlTokenAbsoluteEnd = Positions.getOffset(sqlScript, new Position(
                                                        specialSqlToken.endLine - 1, specialSqlToken.endColumn - 1));
                                        if (specialSqlTokenAbsoluteBegin < curSqlToken.absoluteBegin) {
                                                begin = specialSqlTokenAbsoluteBegin;
                                        } else {
                                                end = specialSqlTokenAbsoluteEnd;
                                        }
                                }

                                switch (curSqlToken.image.toLowerCase()) {
                                        case "select":
                                                if (prevSqlToken != null && prevSqlToken.image == "(") {
                                                        // Just in case the user put multiple "(".
                                                        subqueryMarker = parenStack;

                                                        // Add to subquery indent builder.
                                                        // Subtracting 2 makes things line up a little better!
                                                        for (int i = 0; i < curSqlToken.beginColumn - 2; i++) {
                                                                subqueryIndentBuilder.append(SPACE);
                                                        }
                                                }
                                                break;
                                        case "union":

                                                // Newline before + 2 spaces and newline after + space.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()
                                                                                + SPACE + SPACE));
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()
                                                                                + SPACE));
                                                break;
                                        case "all":
                                                // New line plus space after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()
                                                                                + SPACE));
                                                break;
                                        case "order":
                                        case "group":
                                        case "table":
                                        case "values":
                                        case "where":
                                                // Newline before + 2 spaces and space after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()
                                                                                + SPACE + SPACE));
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                SPACE));
                                                break;
                                        case "and":
                                                // If in function or complex cond analysis, we only want to remove
                                                // whitespace
                                                // before and add space after. Otherwise, add newline + tab to beginning
                                                // and add
                                                // space to end.
                                                if (subqueryMarker < parenStack) {
                                                        // Space before and after.
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        beginWhitespace,
                                                                                        sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        begin, sqlScriptRange)),
                                                                        SPACE));
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        end, sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        nextBegin, sqlScriptRange)),
                                                                        SPACE));
                                                } else {
                                                        // Newline + tab before and space after.
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        beginWhitespace,
                                                                                        sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        begin, sqlScriptRange)),
                                                                        NEWLINE + mocaIndentBuilder.toString()
                                                                                        + subqueryIndentBuilder
                                                                                                        .toString()
                                                                                        + TAB));
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        end, sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        nextBegin, sqlScriptRange)),
                                                                        SPACE));
                                                }

                                                break;
                                        case "case":
                                                // Just add to indent builder(add 3 tabs).
                                                mocaIndentBuilder.append(TAB + TAB + TAB);
                                                break;
                                        case "else":
                                        case "when":
                                                // Newline before.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()));
                                                break;
                                        case "end":

                                                // Remove from indent builder(remove 3 total, but just 2 right now).
                                                if (mocaIndentBuilder.length() > 0) {
                                                        mocaIndentBuilder.deleteCharAt(0);
                                                        // And again.
                                                        if (mocaIndentBuilder.length() > 0) {
                                                                mocaIndentBuilder.deleteCharAt(0);
                                                        }

                                                }

                                                // Newline + TAB before.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()
                                                                                + TAB));

                                                // Remove other 1 from indent builder.
                                                if (mocaIndentBuilder.length() > 0) {
                                                        mocaIndentBuilder.deleteCharAt(0);
                                                }
                                                break;
                                        case "into":
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString() + TAB
                                                                                + SPACE));
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                SPACE));
                                                break;
                                        case "left":
                                                // Make sure next token is either 'outer' or 'join'.
                                                if (curSqlToken.next != null) {
                                                        if (curSqlToken.next.image.compareToIgnoreCase("outer") == 0
                                                                        || curSqlToken.next.image.compareToIgnoreCase(
                                                                                        "join") == 0) {
                                                                // Newline + 3 spaces before.
                                                                edits.add(new TextEdit(new Range(
                                                                                SqlLanguageUtils.createMocaPosition(
                                                                                                sqlScript,
                                                                                                beginWhitespace,
                                                                                                sqlScriptRange),
                                                                                SqlLanguageUtils.createMocaPosition(
                                                                                                sqlScript, begin,
                                                                                                sqlScriptRange)),
                                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                                + subqueryIndentBuilder
                                                                                                                .toString()
                                                                                                + SPACE + SPACE
                                                                                                + SPACE));
                                                                break;
                                                        }
                                                }
                                                break;
                                        case "join":
                                        case "from":
                                                // Newline + 3 spaces before and space after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()
                                                                                + SPACE + SPACE + SPACE));
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                SPACE));
                                                break;
                                        case "set":
                                                // Newline + tab before and space after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString()
                                                                                + TAB));
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                SPACE));
                                                break;
                                        case "inner":
                                        case "cross":
                                        case "right":
                                                // Make sure next token is either 'outer' or 'join'.
                                                if (curSqlToken.next != null) {
                                                        if (curSqlToken.next.image.compareToIgnoreCase("outer") == 0
                                                                        || curSqlToken.next.image.compareToIgnoreCase(
                                                                                        "join") == 0) {
                                                                // Newline + space + space before.
                                                                edits.add(new TextEdit(new Range(
                                                                                SqlLanguageUtils.createMocaPosition(
                                                                                                sqlScript,
                                                                                                beginWhitespace,
                                                                                                sqlScriptRange),
                                                                                SqlLanguageUtils.createMocaPosition(
                                                                                                sqlScript, begin,
                                                                                                sqlScriptRange)),
                                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                                + subqueryIndentBuilder
                                                                                                                .toString()
                                                                                                + SPACE + SPACE));
                                                                break;
                                                        }
                                                }
                                                break;
                                        case "on":
                                                // Newline + tab + space before and space after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                NEWLINE + mocaIndentBuilder.toString()
                                                                                + subqueryIndentBuilder.toString() + TAB
                                                                                + SPACE));

                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                SPACE));
                                                break;
                                        case ",":
                                                // If in function or complex cond analysis, we only want to remove
                                                // whitespace
                                                // before and add space after. Otherwise, remove whitespace and add
                                                // newline + 2
                                                // tabs.

                                                if (subqueryMarker < parenStack) {
                                                        // Empty before and space after.
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        beginWhitespace,
                                                                                        sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        begin, sqlScriptRange)),
                                                                        EMPTY));
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        end, sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        nextBegin, sqlScriptRange)),
                                                                        SPACE));
                                                } else {
                                                        // Remove whitespace before and add newline + 2 tabs after.
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        beginWhitespace,
                                                                                        sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        begin, sqlScriptRange)),
                                                                        EMPTY));
                                                        edits.add(new TextEdit(new Range(
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        end, sqlScriptRange),
                                                                        SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                        nextBegin, sqlScriptRange)),
                                                                        NEWLINE + mocaIndentBuilder.toString()
                                                                                        + subqueryIndentBuilder
                                                                                                        .toString()
                                                                                        + TAB + TAB));
                                                }
                                                break;
                                        case "distinct":
                                                // Space after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                SPACE));
                                                break;
                                        case "in":
                                        case "not":
                                        case "is":
                                        case "like":
                                        case "or":
                                        case ">":
                                        case ">=":
                                        case "<":
                                        case "<=":
                                        case "<>":
                                        case "!=":
                                        case "=":
                                                // Space before and after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                SPACE));
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                SPACE));
                                                break;
                                        case "(":
                                                parenStack++;
                                                // Remove whitespace after.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, end,
                                                                                sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                nextBegin, sqlScriptRange)),
                                                                EMPTY));
                                                break;
                                        case ")":

                                                parenStack--;

                                                // If parenStack is less than subqueryMarker, then we are no longer in
                                                // subquery.
                                                if (parenStack < subqueryMarker) {
                                                        subqueryMarker = 0;

                                                        // Clear subquery indent builder.
                                                        subqueryIndentBuilder.setLength(0);
                                                }
                                                // Remove whitespace before.
                                                edits.add(new TextEdit(new Range(
                                                                SqlLanguageUtils.createMocaPosition(sqlScript,
                                                                                beginWhitespace, sqlScriptRange),
                                                                SqlLanguageUtils.createMocaPosition(sqlScript, begin,
                                                                                sqlScriptRange)),
                                                                EMPTY));
                                                break;
                                        default:
                                                break;
                                }

                                prevSqlToken = curSqlToken;
                                curSqlToken = curSqlToken.next;
                        }

                }
        }

}