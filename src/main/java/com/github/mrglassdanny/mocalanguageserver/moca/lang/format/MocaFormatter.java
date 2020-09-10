package com.github.mrglassdanny.mocalanguageserver.moca.lang.format;

import org.antlr.v4.runtime.Token;

import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;

public class MocaFormatter {

    private static boolean isWord(Token token) {

        switch (token.getType()) {
            case MocaLexer.WORD:
            case MocaLexer.OVERSTACKED_ARGS:
            case MocaLexer.SPECIAL_COMMAND_ARG_NO_ROWS:
            case MocaLexer.SPECIAL_COMMAND_ARG_DUMMY_ARG:
            case MocaLexer.ONSTACK:
            case MocaLexer.KEEP:
            case MocaLexer.NUMERIC_LITERAL:
            case MocaLexer.STRING_LITERAL:
            case MocaLexer.LIKE:
            case MocaLexer.IS:
            case MocaLexer.NOT:
            case MocaLexer.NULL:
                return true;
            default:
                return false;
        }
    }

    private static boolean isOperator(Token token) {
        switch (token.getType()) {
            case MocaLexer.EQUAL:
            case MocaLexer.NOT_EQUAL:
            case MocaLexer.LESS:
            case MocaLexer.GREATER:
            case MocaLexer.LESS_EQUAL:
            case MocaLexer.GREATER_EQUAL:
            case MocaLexer.PLUS:
            case MocaLexer.MINUS:
            case MocaLexer.STAR:
            case MocaLexer.DIV:
            case MocaLexer.MOD:
                return true;
            default:
                return false;
        }
    }

    private static boolean addedNewline(Token token) {
        switch (token.getType()) {
            case MocaLexer.SEMI_COLON:
            case MocaLexer.PIPE:
            case MocaLexer.AMPERSAND:
            case MocaLexer.LEFT_BRACE:
            case MocaLexer.RIGHT_BRACE:
            case MocaLexer.WHERE:
            case MocaLexer.AND:
                return true;
            default:
                return false;
        }
    }

    private static void addNewline(StringBuilder buf, StringBuilder a) {
        buf.append('\n');
        buf.append(a.toString());
    }

    public static String formatStandard(List<? extends Token> tokens) {

        StringBuilder buf = new StringBuilder(2048);

        StringBuilder indentBuf = new StringBuilder();
        int parenCounter = 0;
        Token token, prevToken = null, nextToken = null;

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getType() == MocaLexer.WHITESPACE || tokens.get(i).getType() == MocaLexer.NEWLINE) {
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

            String tokenText = token.getText();

            switch (token.getType()) {

                case MocaLexer.DOUBLE_BRACKET_STRING:
                    buf.append(tokenText);
                    break;
                case MocaLexer.SINGLE_BRACKET_STRING:
                    buf.append(tokenText);
                    break;

                case MocaLexer.LEFT_PAREN:
                    buf.append(tokenText);
                    parenCounter++;
                    break;
                case MocaLexer.RIGHT_PAREN:
                    parenCounter--;
                    buf.append(tokenText);
                    break;

                case MocaLexer.LEFT_BRACE:

                    if (prevToken == null || (prevToken != null && !addedNewline(prevToken))) {
                        addNewline(buf, indentBuf);
                    }
                    indentBuf.append('\t');

                    buf.append(tokenText);

                    addNewline(buf, indentBuf);
                    break;
                case MocaLexer.RIGHT_BRACE:
                    indentBuf.deleteCharAt(indentBuf.length() - 1);

                    addNewline(buf, indentBuf);

                    buf.append(tokenText);
                    break;

                case MocaLexer.EQUAL:
                case MocaLexer.NOT_EQUAL:
                case MocaLexer.LESS:
                case MocaLexer.GREATER:
                case MocaLexer.LESS_EQUAL:
                case MocaLexer.GREATER_EQUAL:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.DIV:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.STAR:
                case MocaLexer.MOD:
                case MocaLexer.PLUS:
                    if (prevToken != null && prevToken.getType() == MocaLexer.AT) {
                        buf.append(tokenText);
                    } else {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }

                    break;

                case MocaLexer.MINUS:

                    if (nextToken != null && isWord(nextToken)) {
                        if (prevToken != null
                                && (isOperator(prevToken) || prevToken.getType() == MocaLexer.LEFT_PAREN)) {
                            buf.append(tokenText);
                        } else {
                            buf.append(' ');
                            buf.append(tokenText);
                        }
                    } else if (prevToken != null && prevToken.getType() == MocaLexer.AT) {
                        buf.append(tokenText);
                    } else {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }

                    break;

                case MocaLexer.COMMA:
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.DOUBLE_PIPE:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.SEMI_COLON:
                    buf.append(tokenText);
                    addNewline(buf, indentBuf);
                    break;
                case MocaLexer.PIPE:
                    addNewline(buf, indentBuf);
                    buf.append(tokenText);
                    addNewline(buf, indentBuf);
                    break;

                case MocaLexer.AMPERSAND:
                    buf.append(' ');
                    buf.append(tokenText);
                    addNewline(buf, indentBuf);
                    break;

                case MocaLexer.DOUBLE_GREATER:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.WHERE:
                    addNewline(buf, indentBuf);
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');

                    break;
                case MocaLexer.AND:

                    if (parenCounter > 0) {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    } else {
                        addNewline(buf, indentBuf);
                        buf.append(' ');
                        buf.append(' ');
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }

                    break;

                case MocaLexer.IF:

                    if (prevToken != null && prevToken.getType() == MocaLexer.ELSE) {
                        buf.append(' ');
                    }

                    buf.append(tokenText);
                    buf.append(' ');
                    break;
                case MocaLexer.ELSE:

                    if (prevToken != null && prevToken.getType() == MocaLexer.RIGHT_BRACE) {
                        addNewline(buf, indentBuf);
                    }

                    buf.append(tokenText);
                    break;

                case MocaLexer.OR:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.TRY:
                    buf.append(tokenText);
                    buf.append(' ');
                    break;
                case MocaLexer.CATCH:
                    buf.append(' ');
                    buf.append(tokenText);
                    break;
                case MocaLexer.FINALLY:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.REMOTE:
                case MocaLexer.PARALLEL:
                case MocaLexer.INPARALLEL:
                    buf.append(tokenText);
                    break;

                case MocaLexer.BLOCK_COMMENT:

                    if (prevToken == null || (prevToken != null && addedNewline(prevToken))) {
                        buf.append(tokenText);
                    } else {
                        addNewline(buf, indentBuf);
                        buf.append(tokenText);
                    }

                    if (nextToken != null && !addedNewline(nextToken)) {
                        addNewline(buf, indentBuf);
                    }

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

    public static String formatJavaStyleBraces(List<? extends Token> tokens) {

        StringBuilder buf = new StringBuilder(2048);

        StringBuilder indentBuf = new StringBuilder();
        int parenCounter = 0;
        Token token, prevToken = null, nextToken = null;

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getType() == MocaLexer.WHITESPACE || tokens.get(i).getType() == MocaLexer.NEWLINE) {
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

            String tokenText = token.getText();

            switch (token.getType()) {

                case MocaLexer.DOUBLE_BRACKET_STRING:
                    buf.append(tokenText);
                    break;
                case MocaLexer.SINGLE_BRACKET_STRING:
                    buf.append(tokenText);
                    break;

                case MocaLexer.LEFT_PAREN:
                    buf.append(tokenText);
                    parenCounter++;
                    break;
                case MocaLexer.RIGHT_PAREN:
                    parenCounter--;
                    buf.append(tokenText);
                    break;

                case MocaLexer.LEFT_BRACE:
                    indentBuf.append('\t');

                    if (prevToken != null && prevToken.getType() == MocaLexer.RIGHT_PAREN) {
                        buf.append(' ');
                    }

                    buf.append(tokenText);

                    addNewline(buf, indentBuf);
                    break;
                case MocaLexer.RIGHT_BRACE:
                    indentBuf.deleteCharAt(indentBuf.length() - 1);

                    addNewline(buf, indentBuf);

                    buf.append(tokenText);
                    break;

                case MocaLexer.EQUAL:
                case MocaLexer.NOT_EQUAL:
                case MocaLexer.LESS:
                case MocaLexer.GREATER:
                case MocaLexer.LESS_EQUAL:
                case MocaLexer.GREATER_EQUAL:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.DIV:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.STAR:
                case MocaLexer.MOD:
                case MocaLexer.PLUS:
                    if (prevToken != null && prevToken.getType() == MocaLexer.AT) {
                        buf.append(tokenText);
                    } else {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }

                    break;

                case MocaLexer.MINUS:

                    if (nextToken != null && isWord(nextToken)) {
                        if (prevToken != null
                                && (isOperator(prevToken) || prevToken.getType() == MocaLexer.LEFT_PAREN)) {
                            buf.append(tokenText);
                        } else {
                            buf.append(' ');
                            buf.append(tokenText);
                        }
                    } else if (prevToken != null && prevToken.getType() == MocaLexer.AT) {
                        buf.append(tokenText);
                    } else {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }

                    break;

                case MocaLexer.COMMA:
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.DOUBLE_PIPE:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.SEMI_COLON:
                    buf.append(tokenText);
                    addNewline(buf, indentBuf);
                    break;
                case MocaLexer.PIPE:
                    addNewline(buf, indentBuf);
                    buf.append(tokenText);
                    addNewline(buf, indentBuf);
                    break;

                case MocaLexer.AMPERSAND:
                    buf.append(' ');
                    buf.append(tokenText);
                    addNewline(buf, indentBuf);
                    break;

                case MocaLexer.DOUBLE_GREATER:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.WHERE:
                    addNewline(buf, indentBuf);
                    buf.append('\t');
                    buf.append(tokenText);
                    buf.append(' ');

                    break;
                case MocaLexer.AND:

                    if (parenCounter > 0) {
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    } else {
                        addNewline(buf, indentBuf);
                        buf.append('\t');
                        buf.append(' ');
                        buf.append(' ');
                        buf.append(tokenText);
                        buf.append(' ');
                    }

                    break;

                case MocaLexer.IF:
                    buf.append(tokenText);
                    buf.append(' ');
                    break;
                case MocaLexer.ELSE:

                    if (prevToken != null && prevToken.getType() == MocaLexer.RIGHT_BRACE) {
                        buf.append(' ');
                    }

                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.OR:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.TRY:
                    buf.append(tokenText);
                    buf.append(' ');
                    break;
                case MocaLexer.CATCH:
                    buf.append(' ');
                    buf.append(tokenText);
                    break;
                case MocaLexer.FINALLY:
                    buf.append(' ');
                    buf.append(tokenText);
                    buf.append(' ');
                    break;

                case MocaLexer.REMOTE:
                case MocaLexer.PARALLEL:
                case MocaLexer.INPARALLEL:
                    buf.append(tokenText);
                    break;

                case MocaLexer.BLOCK_COMMENT:

                    if (prevToken == null || (prevToken != null && addedNewline(prevToken))) {
                        buf.append(tokenText);
                    } else {
                        addNewline(buf, indentBuf);
                        buf.append(tokenText);
                    }

                    if (nextToken != null && !addedNewline(nextToken)) {
                        addNewline(buf, indentBuf);
                    }

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