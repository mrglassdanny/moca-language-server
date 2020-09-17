package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml.ast;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaXmlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaXmlParserBaseListener;

import org.antlr.v4.runtime.Token;

public class MocaXmlParseTreeListener extends MocaXmlParserBaseListener {

    private static final String TYPE_LOCAL_SYNTAX = "local-syntax";

    public Token localSyntaxCdataToken;

    public MocaXmlParseTreeListener() {
        this.localSyntaxCdataToken = null;
    }

    @Override
    public void enterElement(MocaXmlParser.ElementContext ctx) {

        // Make sure context is not null.
        if (ctx == null) {
            return;
        }

        // Should be 2 name elements; we want the 1st one.
        if (!ctx.Name().isEmpty() && ctx.Name().get(0).getText().compareToIgnoreCase(TYPE_LOCAL_SYNTAX) == 0) {

            // Now just set our local-syntax token.
            if (ctx.content() != null && !ctx.content().CDATA().isEmpty()) {
                this.localSyntaxCdataToken = ctx.content().CDATA().get(0).getSymbol();
            }

        }
    }
}
