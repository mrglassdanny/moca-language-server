package com.github.mrglassdanny.mocalanguageserver.moca.lang.ast;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaBaseListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser.Function_exprContext;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class MocaParseTreeListener extends MocaBaseListener {

    public HashMap<Token, String> redirects;
    // verbNounClauses HashMap needs to have StringBuilder as key instead of String,
    // that way duplicate verb noun clauses will not get put on top of each other.
    public HashMap<StringBuilder, ArrayList<Token>> verbNounClauses;

    public ArrayList<Function_exprContext> functions;

    public MocaParseTreeListener() {
        this.redirects = new HashMap<>();
        this.verbNounClauses = new HashMap<>();
        this.functions = new ArrayList<>();
    }

    @Override
    public void enterVerb_noun_clause(MocaParser.Verb_noun_clauseContext ctx) {

        if (ctx == null) {
            return;
        }

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
                    verbNounClauseBuf.append(commonToken.getText());
                    // Need to put a space since we skip whitespace in parser!
                    verbNounClauseBuf.append(" ");
                    tokens.add(commonToken);
                }
            } else {
                break;
            }
        }

        // If verb noun clause is empty, do nothing for now.
        if (verbNounClauseBuf.length() == 0) {
            return;
        }

        // Remove the last space we added to verb noun clause.
        verbNounClauseBuf.deleteCharAt(verbNounClauseBuf.length() - 1);

        this.verbNounClauses.put(verbNounClauseBuf, tokens);

    }

    @Override
    public void enterRedirect_expr(MocaParser.Redirect_exprContext ctx) {

        if (ctx == null) {
            return;
        }

        // Redirects are setup as DOUBLE_GREATER then WORD.
        // Therefore, we can just get the stop token and use it's
        // data to fill hashmap.
        Token redirectWord = ctx.getStop();
        this.redirects.put(redirectWord, redirectWord.getText());

    }

    @Override
    public void enterFunction_expr(MocaParser.Function_exprContext ctx) {

        if (ctx == null) {
            return;
        }

        this.functions.add(ctx);

    }
}