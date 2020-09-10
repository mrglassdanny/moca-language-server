package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.format;

import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;

public class MocaSqlFormatter {

    private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z_0-9]+");

    private static boolean isWord(Token token) {

        Matcher wordMatcher = WORD_PATTERN.matcher(token.getText());
        if (!wordMatcher.find()) {
            switch (token.getType()) {
                case MocaSqlLexer.STRING:
                case MocaSqlLexer.MOCA_AT_STAR:
                    return true;
                default:
                    return false;
            }
        } else {
            return true;
        }
    }

    private static boolean isOperator(Token token) {
        switch (token.getType()) {
            case MocaSqlLexer.EQUAL:
            case MocaSqlLexer.NOT_EQUAL:
            case MocaSqlLexer.LESS:
            case MocaSqlLexer.GREATER:
            case MocaSqlLexer.LESS_EQUAL:
            case MocaSqlLexer.GREATER_EQUAL:
            case MocaSqlLexer.STAR:
            case MocaSqlLexer.DIVIDE:
            case MocaSqlLexer.MODULE:
            case MocaSqlLexer.PLUS:
            case MocaSqlLexer.MINUS:
            case MocaSqlLexer.PLUS_ASSIGN:
            case MocaSqlLexer.MINUS_ASSIGN:
            case MocaSqlLexer.MULT_ASSIGN:
            case MocaSqlLexer.DIV_ASSIGN:
            case MocaSqlLexer.MOD_ASSIGN:
            case MocaSqlLexer.AND_ASSIGN:
            case MocaSqlLexer.XOR_ASSIGN:
            case MocaSqlLexer.OR_ASSIGN:
                return true;
            default:
                return false;
        }
    }

    private static void addNewline(StringBuilder buf, Stack<Query> queryStack) {
        buf.append('\n');

        for (Query query : queryStack) {
            buf.append(query.clauseIndentBuf.toString());
            buf.append(query.subqueryIndentBuf.toString());
        }
    }

    public static String format(List<? extends Token> tokens) {

        StringBuilder buf = new StringBuilder(2048);

        Stack<Query> queryStack = new Stack<>();
        int parenCounter = 0;
        boolean inCaseWhen = false;
        boolean isDDL = false;
        Token token, prevToken = null, nextToken = null;
        Query curQuery;

        queryStack.push(new Query(parenCounter));

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getType() == MocaSqlLexer.SPACE) {
                tokens.remove(i--);
            }
        }

        for (int i = 0; i < tokens.size(); i++) {

            token = tokens.get(i);

            if (i > 0) {
                prevToken = tokens.get(i - 1);
            }

            if (i < tokens.size() - 1) {
                nextToken = tokens.get(i + 1);
            }

            curQuery = queryStack.peek();

            String tokenText = token.getText();

            switch (token.getType()) {

                case MocaSqlLexer.LR_BRACKET:

                    buf.append(tokenText);
                    parenCounter++;

                    if (nextToken != null && nextToken.getType() == MocaSqlLexer.SELECT) {

                        Query query = new Query(parenCounter);

                        int prevIndentSpaceCount = 0;
                        for (Query _query : queryStack) {
                            prevIndentSpaceCount += (_query.subqueryIndentBuf.length()
                                    + _query.clauseIndentBuf.length());
                        }
                        for (int j = buf.length() - 1 - prevIndentSpaceCount; j >= 0; j--) {
                            if (buf.charAt(j) == '\n') {
                                break;
                            } else {
                                query.subqueryIndentBuf.append(' ');
                            }
                        }

                        queryStack.push(query);
                    }

                    break;
                case MocaSqlLexer.RR_BRACKET:

                    if (parenCounter == curQuery.parenCounterState) {
                        queryStack.pop();
                    }

                    parenCounter--;

                    buf.append(tokenText);

                    if (nextToken != null && isWord(nextToken)) {
                        buf.append(' ');
                    }

                    break;

                case MocaSqlLexer.COMMA:

                    if (parenCounter > curQuery.parenCounterState) {

                        if (isDDL) {
                            buf.append(tokenText);
                            addNewline(buf, queryStack);
                        } else {
                            buf.append(tokenText);
                            buf.append(' ');
                        }
                    } else {
                        buf.append(tokenText);

                        addNewline(buf, queryStack);
                    }

                    break;

                case MocaSqlLexer.EQUAL:
                case MocaSqlLexer.NOT_EQUAL:
                case MocaSqlLexer.LESS:
                case MocaSqlLexer.GREATER:
                case MocaSqlLexer.LESS_EQUAL:
                case MocaSqlLexer.GREATER_EQUAL:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaSqlLexer.MINUS:
                    if (nextToken != null && isWord(nextToken)) {
                        if (prevToken != null
                                && (isOperator(prevToken) || prevToken.getType() == MocaSqlLexer.LR_BRACKET)) {
                            buf.append(tokenText);
                        } else {
                            buf.append(' ');
                            buf.append(tokenText);
                        }
                    } else {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }
                    break;

                case MocaSqlLexer.STAR:
                    if (prevToken != null && prevToken.getType() == MocaSqlLexer.DOT) {
                        buf.append(tokenText);
                    } else {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }
                    break;

                case MocaSqlLexer.DIVIDE:
                case MocaSqlLexer.MODULE:
                case MocaSqlLexer.PLUS:
                case MocaSqlLexer.PLUS_ASSIGN:
                case MocaSqlLexer.MINUS_ASSIGN:
                case MocaSqlLexer.MULT_ASSIGN:
                case MocaSqlLexer.DIV_ASSIGN:
                case MocaSqlLexer.MOD_ASSIGN:
                case MocaSqlLexer.AND_ASSIGN:
                case MocaSqlLexer.XOR_ASSIGN:
                case MocaSqlLexer.OR_ASSIGN:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaSqlLexer.DOUBLE_BAR:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaSqlLexer.SELECT:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.FROM:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.WHERE:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.AND:

                    if (!inCaseWhen) {
                        curQuery.clauseIndentBuf.setLength(0);
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');

                        addNewline(buf, queryStack);

                        buf.append(tokenText);
                    } else {
                        if (prevToken != null && isWord(prevToken)) {
                            buf.append(' ');
                        }
                        buf.append(tokenText);
                    }

                    break;
                case MocaSqlLexer.OR:

                    if (!inCaseWhen) {
                        curQuery.clauseIndentBuf.setLength(0);
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');

                        addNewline(buf, queryStack);

                        buf.append(tokenText);
                    } else {
                        if (prevToken != null && isWord(prevToken)) {
                            buf.append(' ');
                        }
                        buf.append(tokenText);
                    }

                    break;

                case MocaSqlLexer.INNER:
                case MocaSqlLexer.RIGHT:
                case MocaSqlLexer.OUTER:
                case MocaSqlLexer.CROSS:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.JOIN:
                case MocaSqlLexer.LEFT:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.ON:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.GROUP:
                case MocaSqlLexer.ORDER:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.BY:
                    buf.append(' ');
                    buf.append(tokenText);
                    break;

                case MocaSqlLexer.HAVING:

                    curQuery.clauseIndentBuf.setLength(0);

                    addNewline(buf, queryStack);

                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    buf.append(tokenText);

                    break;

                case MocaSqlLexer.UNION:

                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    buf.append(tokenText);

                    if (nextToken != null && nextToken.getType() == MocaSqlLexer.ALL) {
                        buf.append(' ');
                    } else {
                        addNewline(buf, queryStack);
                    }

                    break;

                case MocaSqlLexer.ALL:

                    buf.append(tokenText);
                    addNewline(buf, queryStack);

                    break;

                case MocaSqlLexer.SET:
                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    buf.append(tokenText);
                    break;

                case MocaSqlLexer.INTO:
                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    buf.append(tokenText);
                    break;
                case MocaSqlLexer.VALUES:
                    curQuery.clauseIndentBuf.setLength(0);

                    addNewline(buf, queryStack);

                    buf.append(tokenText);
                    break;

                case MocaSqlLexer.TABLE:
                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    buf.append(tokenText);
                    break;

                case MocaSqlLexer.ADD:
                    curQuery.clauseIndentBuf.setLength(0);
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    addNewline(buf, queryStack);

                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    buf.append(tokenText);
                    break;

                case MocaSqlLexer.DROP:
                    isDDL = true;

                    if (nextToken != null && nextToken.getType() == MocaSqlLexer.COLUMN) {
                        curQuery.clauseIndentBuf.setLength(0);
                        curQuery.clauseIndentBuf.append(' ');

                        addNewline(buf, queryStack);

                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');

                        buf.append(tokenText);
                    } else {
                        if (prevToken != null && isWord(prevToken)) {
                            buf.append(' ');
                        }

                        buf.append(tokenText);
                    }

                    break;

                case MocaSqlLexer.ALTER:
                    isDDL = true;

                    if (nextToken != null && nextToken.getType() == MocaSqlLexer.COLUMN) {
                        curQuery.clauseIndentBuf.setLength(0);

                        addNewline(buf, queryStack);

                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');
                        curQuery.clauseIndentBuf.append(' ');

                        buf.append(tokenText);
                    } else {
                        if (prevToken != null && isWord(prevToken)) {
                            buf.append(' ');
                        }

                        buf.append(tokenText);
                    }

                    break;

                case MocaSqlLexer.MODIFY:
                    isDDL = true;

                    curQuery.clauseIndentBuf.setLength(0);

                    addNewline(buf, queryStack);

                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    buf.append(tokenText);
                    break;

                case MocaSqlLexer.CREATE:
                    isDDL = true;

                    if (prevToken != null && isWord(prevToken)) {
                        buf.append(' ');
                    }

                    buf.append(tokenText);
                    break;

                case MocaSqlLexer.CASE:

                    inCaseWhen = true;

                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');
                    curQuery.clauseIndentBuf.append(' ');

                    if (prevToken != null && isWord(prevToken)) {
                        buf.append(' ');
                    }

                    buf.append(tokenText);
                    break;
                case MocaSqlLexer.WHEN:
                    addNewline(buf, queryStack);

                    if (prevToken != null && isWord(prevToken)) {
                        buf.append(' ');
                    }

                    buf.append(tokenText);
                    break;
                case MocaSqlLexer.END:

                    curQuery.clauseIndentBuf.deleteCharAt(curQuery.clauseIndentBuf.length() - 1);
                    curQuery.clauseIndentBuf.deleteCharAt(curQuery.clauseIndentBuf.length() - 1);
                    curQuery.clauseIndentBuf.deleteCharAt(curQuery.clauseIndentBuf.length() - 1);

                    addNewline(buf, queryStack);

                    if (prevToken != null && isWord(prevToken)) {
                        buf.append(' ');
                    }

                    buf.append(tokenText);

                    inCaseWhen = false;
                    break;

                default:
                    if (isWord(token)) {

                        if (prevToken != null && isWord(prevToken)) {
                            buf.append(' ');
                        }

                        buf.append(tokenText);

                    } else {
                        buf.append(tokenText);
                    }
                    break;
            }
        }

        return buf.toString();
    }

}

class Query {
    StringBuilder clauseIndentBuf;
    StringBuilder subqueryIndentBuf;
    final int parenCounterState;

    Query(final int parenCounter) {
        this.clauseIndentBuf = new StringBuilder();
        this.subqueryIndentBuf = new StringBuilder();
        this.parenCounterState = parenCounter;
    }

}
