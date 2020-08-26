package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaBaseListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class MocaParseTreeListener extends MocaBaseListener {

    public HashMap<Token, String> mocaRedirects;
    public HashMap<String, ArrayList<Token>> verbNounClauses;

    public MocaParseTreeListener() {
        this.mocaRedirects = new HashMap<>();
        this.verbNounClauses = new HashMap<>();
    }

    @Override
    public void enterVerb_noun_clause(MocaParser.Verb_noun_clauseContext ctx) {

        StringBuilder verbNounClauseBuf = new StringBuilder();
        ArrayList<Token> tokens = new ArrayList<>();
        for (int i = 0; i < ctx.children.size(); i++) {
            Object child = ctx.children.get(i).getPayload();
            // If child is not CommonToken, then we know that we are at the verb noun clause
            // args. We do not want to include args here.
            if (child instanceof CommonToken) {
                CommonToken commonToken = (CommonToken) child;

                // Token could be a CARET if override; let's ignore it.
                // Let's also ignore WHERE token.
                if (commonToken.getType() != MocaLexer.CARET && commonToken.getType() != MocaLexer.WHERE) {
                    verbNounClauseBuf.append(commonToken.getText() + " "); // Need to put a space since we skip
                                                                           // whitespace in parser!
                    tokens.add(commonToken);
                }
            } else {
                break;
            }
        }

        String verbNounClause = verbNounClauseBuf.toString().trim(); // Need to make sure string is trimmed, especially
                                                                     // since we added spaces above.

        this.verbNounClauses.put(verbNounClause, tokens);

    }

    @Override
    public void enterMoca_redirect_expr(MocaParser.Moca_redirect_exprContext ctx) {
        // Redirects are setup as DOUBLE_GREATER then WORD.
        // Therefore, we can just get the stop token and use it's
        // data to fill hashmap.
        Token mocaRedirectWord = ctx.getStop();
        this.mocaRedirects.put(mocaRedirectWord, mocaRedirectWord.getText());

    }
}