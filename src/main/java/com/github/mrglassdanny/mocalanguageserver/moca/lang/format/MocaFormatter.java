package com.github.mrglassdanny.mocalanguageserver.moca.lang.format;

import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.Position;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.format.MocaSqlFormatter;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util.MocaSqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.RangeUtils;

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

    private static boolean tokenWillAddNewline(Token token) {
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

    public static String format(MocaCompilationResult mocaCompilationResult) {

        // Need to copy existing list into new list for processing. Reason is that we do
        // not want to modify moca compilation result's token list since other processes
        // could be using it.
        List<Token> tokens = new ArrayList<>(mocaCompilationResult.mocaTokens.size());
        // Do not copy in whitespace tokens.
        for (int i = 0; i < mocaCompilationResult.mocaTokens.size(); i++) {
            if (mocaCompilationResult.mocaTokens.get(i).getType() != MocaLexer.WHITESPACE
                    && mocaCompilationResult.mocaTokens.get(i).getType() != MocaLexer.NEWLINE) {
                tokens.add(mocaCompilationResult.mocaTokens.get(i));
            }
        }

        StringBuilder buf = new StringBuilder(2048);
        StringBuilder indentBuf = new StringBuilder();
        int parenCounter = 0;
        Token token, prevToken = null, nextToken = null;

        int mocasqlCompilationResultsVisited = 0;
        // Commenting out for now -- int groovyCompilationResultsVisited = 0;

        // Code is pretty self-explanatory -- just look at each condition for specifics.
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

                    // Make sure moca language server options allow us to format.
                    if (MocaLanguageServer.mocaLanguageServerOptions.groovyFormattingEnabled) {
                        // Groovy formatting not yet supported!
                        buf.append(tokenText);
                    } else {
                        buf.append(tokenText);
                    }

                    // Increment groovy compilation result visit count.
                    // Commenting out for now -- groovyCompilationResultsVisited++;

                    break;
                case MocaLexer.SINGLE_BRACKET_STRING:

                    // Could just be an ordinary bracket string -- make sure to check!
                    if (MocaSqlLanguageUtils.isMocaSqlScript(tokenText)) {

                        // Make sure moca language server options allow us to format.
                        if (MocaLanguageServer.mocaLanguageServerOptions.mocasqlFormattingEnabled) {
                            MocaSqlCompilationResult mocaSqlCompilationResult = mocaCompilationResult.mocaSqlCompilationResults
                                    .get(mocasqlCompilationResultsVisited);

                            // Go ahead and just make sure mocasql compilation result is not null. Should
                            // not be null, but we just want to be safe!
                            if (mocaSqlCompilationResult != null) {
                                try {
                                    String formattedMocaSqlScript = formatMocaSql(
                                            mocaSqlCompilationResult.mocaSqlTokens, indentBuf);
                                    if (formattedMocaSqlScript != null) {
                                        buf.append(formattedMocaSqlScript);
                                    } else {
                                        buf.append(tokenText);
                                    }
                                } catch (EmptyStackException emptyStackException) {
                                    buf.append(tokenText);
                                }
                            } else {
                                buf.append(tokenText);
                            }
                        } else {
                            buf.append(tokenText);
                        }

                        // Increment mocasql compilation result visit count.
                        mocasqlCompilationResultsVisited++;

                    } else {
                        buf.append(tokenText);
                    }

                    break;

                case MocaLexer.LEFT_PAREN:
                    buf.append(tokenText);
                    parenCounter++;
                    break;
                case MocaLexer.RIGHT_PAREN:
                    parenCounter--;
                    buf.append(tokenText);

                    // This handles IF without LEFT_BRACE behind it.
                    if (nextToken != null && isWord(nextToken)) {
                        if (nextToken.getType() == MocaLexer.AND || nextToken.getType() == MocaLexer.OR) {
                            buf.append(' ');
                        } else {
                            addNewline(buf, indentBuf);
                        }
                    }

                    break;

                case MocaLexer.LEFT_BRACE:

                    if (prevToken == null || (prevToken != null && !tokenWillAddNewline(prevToken))) {
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

                    if (nextToken != null && (isWord(nextToken))) {
                        if (prevToken != null && (isOperator(prevToken) || prevToken.getType() == MocaLexer.LEFT_PAREN
                                || prevToken.getType() == MocaLexer.COMMA)) {
                            buf.append(tokenText);
                        } else {
                            buf.append(' ');
                            buf.append(tokenText);
                            buf.append(' ');
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

                    addNewline(buf, indentBuf);
                    buf.append(tokenText);

                    // This handles ELSE without LEFT_BRACE behind it.
                    if (nextToken != null && nextToken.getType() != MocaLexer.LEFT_BRACE
                            && nextToken.getType() != MocaLexer.IF) {
                        addNewline(buf, indentBuf);
                    }

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

                    if (prevToken == null || (prevToken != null && tokenWillAddNewline(prevToken))) {
                        buf.append(tokenText);
                    } else {
                        addNewline(buf, indentBuf);
                        buf.append(tokenText);
                    }

                    if (nextToken != null && !tokenWillAddNewline(nextToken)) {
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

    public static String format(String script) {
        return format(MocaCompiler.compileScript(script));
    }

    // This function will have the same formatting logic as ^. The only difference
    // is we are passing in the changed position in hopes of being able to
    // format moca(we always need to do moca regardless of change position) and just
    // the embedded language range that it is contained in, if any.
    public static String formatChange(MocaCompilationResult mocaCompilationResult, Position changePosition) {

        // Make sure we actually need to format right now -- we only want to go through
        // with on type formatting if we come across a token. This includes mocasql and
        // groovy.
        // If we decide that we do not need to format right now, we can just return the
        // current script.
        Token _token = MocaLanguageUtils.getMocaTokenAtPosition(changePosition, mocaCompilationResult);
        switch (_token.getType()) {
            case MocaLexer.DOUBLE_BRACKET_STRING:
                return mocaCompilationResult.script;
            case MocaLexer.SINGLE_BRACKET_STRING:
                if (MocaSqlFormatter.tokenPromptsFormat(
                        MocaSqlLanguageUtils.getMocaSqlTokenAtPosition(changePosition, mocaCompilationResult))) {
                    break;
                } else {
                    return mocaCompilationResult.script;
                }
            case MocaLexer.LEFT_PAREN:
            case MocaLexer.RIGHT_PAREN:
            case MocaLexer.LEFT_BRACE:
            case MocaLexer.RIGHT_BRACE:
            case MocaLexer.EQUAL:
            case MocaLexer.NOT_EQUAL:
            case MocaLexer.LESS:
            case MocaLexer.GREATER:
            case MocaLexer.LESS_EQUAL:
            case MocaLexer.GREATER_EQUAL:
            case MocaLexer.DIV:
            case MocaLexer.STAR:
            case MocaLexer.MOD:
            case MocaLexer.PLUS:
            case MocaLexer.MINUS:
            case MocaLexer.COMMA:
            case MocaLexer.DOUBLE_PIPE:
            case MocaLexer.SEMI_COLON:
            case MocaLexer.PIPE:
            case MocaLexer.AMPERSAND:
            case MocaLexer.DOUBLE_GREATER:
            case MocaLexer.WHERE:
            case MocaLexer.AND:
            case MocaLexer.IF:
            case MocaLexer.ELSE:
            case MocaLexer.OR:
            case MocaLexer.TRY:
            case MocaLexer.CATCH:
            case MocaLexer.FINALLY:
            case MocaLexer.REMOTE:
            case MocaLexer.PARALLEL:
            case MocaLexer.INPARALLEL:
            case MocaLexer.BLOCK_COMMENT:
                break;
            default:
                return mocaCompilationResult.script;
        }

        // Need to copy existing list into new list for processing. Reason is that we do
        // not want to modify moca compilation result's token list since other processes
        // could be using it.
        List<Token> tokens = new ArrayList<>(mocaCompilationResult.mocaTokens.size());
        // Do not copy in whitespace tokens.
        for (int i = 0; i < mocaCompilationResult.mocaTokens.size(); i++) {
            if (mocaCompilationResult.mocaTokens.get(i).getType() != MocaLexer.WHITESPACE
                    && mocaCompilationResult.mocaTokens.get(i).getType() != MocaLexer.NEWLINE) {
                tokens.add(mocaCompilationResult.mocaTokens.get(i));
            }
        }

        StringBuilder buf = new StringBuilder(2048);
        StringBuilder indentBuf = new StringBuilder();
        int parenCounter = 0;
        Token token, prevToken = null, nextToken = null;

        int mocasqlCompilationResultsVisited = 0;
        // Commenting out for now -- int groovyCompilationResultsVisited = 0;

        // Code is pretty self-explanatory -- just look at each condition for specifics.
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

                    // Make sure moca language server options allow us to format.
                    if (MocaLanguageServer.mocaLanguageServerOptions.groovyFormattingEnabled) {
                        // Groovy formatting not yet supported!
                        buf.append(tokenText);
                    } else {
                        buf.append(tokenText);
                    }

                    // Increment groovy compilation result visit count.
                    // Commenting out for now -- groovyCompilationResultsVisited++;

                    break;
                case MocaLexer.SINGLE_BRACKET_STRING:

                    // Could just be an ordinary bracket string -- make sure to check!
                    if (MocaSqlLanguageUtils.isMocaSqlScript(tokenText)) {

                        // Make sure moca language server options allow us to format.
                        if (MocaLanguageServer.mocaLanguageServerOptions.mocasqlFormattingEnabled) {
                            MocaSqlCompilationResult mocaSqlCompilationResult = mocaCompilationResult.mocaSqlCompilationResults
                                    .get(mocasqlCompilationResultsVisited);

                            // Go ahead and just make sure mocasql compilation result is not null. Should
                            // not be null, but we just want to be safe!
                            if (mocaSqlCompilationResult != null) {
                                // Now let's see if changed position is contained in mocasql range. If so,
                                // format it. Otherwise, we will assume formatting is not necessary.
                                if (RangeUtils.contains(mocaSqlCompilationResult.range, changePosition)) {
                                    try {
                                        String formattedMocaSqlScript = formatMocaSql(
                                                mocaSqlCompilationResult.mocaSqlTokens, indentBuf);
                                        if (formattedMocaSqlScript != null) {
                                            buf.append(formattedMocaSqlScript);
                                        } else {
                                            buf.append(tokenText);
                                        }
                                    } catch (EmptyStackException emptyStackException) {
                                        buf.append(tokenText);
                                    }
                                } else {
                                    buf.append(tokenText);
                                }
                            } else {
                                buf.append(tokenText);
                            }
                        } else {
                            buf.append(tokenText);
                        }

                        // Increment mocasql compilation result visit count.
                        mocasqlCompilationResultsVisited++;

                    } else {
                        buf.append(tokenText);
                    }

                    break;

                case MocaLexer.LEFT_PAREN:
                    buf.append(tokenText);
                    parenCounter++;
                    break;
                case MocaLexer.RIGHT_PAREN:
                    parenCounter--;
                    buf.append(tokenText);

                    // This handles IF without LEFT_BRACE behind it.
                    if (nextToken != null && isWord(nextToken)) {
                        if (nextToken.getType() == MocaLexer.AND || nextToken.getType() == MocaLexer.OR) {
                            buf.append(' ');
                        } else {
                            addNewline(buf, indentBuf);
                        }
                    }

                    break;

                case MocaLexer.LEFT_BRACE:

                    if (prevToken == null || (prevToken != null && !tokenWillAddNewline(prevToken))) {
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

                    if (nextToken != null && (isWord(nextToken))) {
                        if (prevToken != null && (isOperator(prevToken) || prevToken.getType() == MocaLexer.LEFT_PAREN
                                || prevToken.getType() == MocaLexer.COMMA)) {
                            buf.append(tokenText);
                        } else {
                            buf.append(' ');
                            buf.append(tokenText);
                            buf.append(' ');
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

                    addNewline(buf, indentBuf);
                    buf.append(tokenText);

                    // This handles ELSE without LEFT_BRACE behind it.
                    if (nextToken != null && nextToken.getType() != MocaLexer.LEFT_BRACE
                            && nextToken.getType() != MocaLexer.IF) {
                        addNewline(buf, indentBuf);
                    }

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

                    if (prevToken == null || (prevToken != null && tokenWillAddNewline(prevToken))) {
                        buf.append(tokenText);
                    } else {
                        addNewline(buf, indentBuf);
                        buf.append(tokenText);
                    }

                    if (nextToken != null && !tokenWillAddNewline(nextToken)) {
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

    private static String formatMocaSql(List<? extends Token> tokens, final StringBuilder mocaIndentBufState)
            throws EmptyStackException {

        String formattedMocaSqlScript = MocaSqlFormatter.format(tokens);

        if (formattedMocaSqlScript != null) {
            // Make copy so we can add to it.
            StringBuilder mocaIndentBufStateClone = new StringBuilder(mocaIndentBufState);
            mocaIndentBufStateClone.append(' ');
            formattedMocaSqlScript = formattedMocaSqlScript.replace("\n", "\n" + mocaIndentBufStateClone.toString());

        }

        return String.format("[%s]", formattedMocaSqlScript);

    }
}