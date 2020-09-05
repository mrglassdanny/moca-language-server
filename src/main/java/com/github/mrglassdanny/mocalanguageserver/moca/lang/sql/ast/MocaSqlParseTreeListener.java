package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.ast;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlBaseListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Derived_tableContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_name_with_hintContext;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class MocaSqlParseTreeListener extends MocaSqlBaseListener {
    public ArrayList<Token> tableTokens;
    public HashMap<String, String> aliasedTableNames;
    public HashMap<String, Token> subqueries;

    public MocaSqlParseTreeListener() {
        this.tableTokens = new ArrayList<>();
        this.aliasedTableNames = new HashMap<>();
        this.subqueries = new HashMap<>();

    }

    @Override
    public void enterTable_source_item(MocaSqlParser.Table_source_itemContext ctx) {

        String tableName = null;
        String tableAliasName = null;

        // Want to make sure we are not dealing with subquery here.
        if (ctx.start instanceof CommonToken && ctx.children.get(0) instanceof Table_name_with_hintContext) {
            CommonToken token = (CommonToken) ctx.start;
            tableName = token.getText();

            // Can add to list from here.
            this.tableTokens.add(token);
        }

        // Want to make sure we are not dealing with subquery here.
        if (ctx.stop instanceof CommonToken && ctx.children.size() > 1
                && ctx.children.get(0) instanceof Table_name_with_hintContext) {
            CommonToken token = (CommonToken) ctx.stop;
            tableAliasName = token.getText();

            // Can go ahead and put in map from here.
            // Can assume that tableName was populated above if we have an alias.
            this.aliasedTableNames.put(tableAliasName, tableName);
        }

        // Subquery token will be stop field.
        if (ctx.start instanceof CommonToken && ctx.children.get(0) instanceof Derived_tableContext) {
            CommonToken token = (CommonToken) ctx.stop;
            // Can add to list from here.
            this.subqueries.put(token.getText(), token);
        }

    }

    @Override
    public void enterFull_table_name(MocaSqlParser.Full_table_nameContext ctx) {

        // Table name we care about will be the last token, since it could be fully
        // qualified table name.
        if (ctx.stop instanceof CommonToken) {
            CommonToken token = (CommonToken) ctx.stop;
            // Can add to list from here.
            this.tableTokens.add(token);
        }
    }

    @Override
    public void enterTable_name(MocaSqlParser.Table_nameContext ctx) {

        // Table name we care about will be the last token, since it could be fully
        // qualified table name.
        if (ctx.stop instanceof CommonToken) {
            CommonToken token = (CommonToken) ctx.stop;
            // Can add to list from here.
            this.tableTokens.add(token);
        }
    }

}