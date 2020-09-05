package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.ast;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlBaseListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Ddl_objectContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Derived_tableContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Query_specificationContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Select_listContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Select_list_elemContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_name_with_hintContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_sourcesContext;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;

public class MocaSqlParseTreeListener extends MocaSqlBaseListener {

    public ArrayList<Token> tableTokens;
    public HashMap<String, String> aliasedTableNames;
    public HashMap<String, Token> subqueries;
    public HashMap<String, ArrayList<Token>> columnTokens; // Key is table name.

    public MocaSqlParseTreeListener() {
        this.tableTokens = new ArrayList<>();
        this.aliasedTableNames = new HashMap<>();
        this.subqueries = new HashMap<>();
        this.columnTokens = new HashMap<>();

    }

    @Override
    public void enterTable_source_item(MocaSqlParser.Table_source_itemContext ctx) {

        String tableName = null;
        String tableAliasName = null;

        // Want to make sure we are not dealing with subquery here.
        if (ctx.children != null && ctx.children.get(0) instanceof Table_name_with_hintContext) {
            Token token = ctx.getStart();
            tableName = token.getText();

            // No need to add table token to list -- our enterTable_name listener will do
            // so!
        }

        // Want to make sure we are not dealing with subquery here.
        if (ctx.children != null && ctx.children.size() > 1
                && ctx.children.get(0) instanceof Table_name_with_hintContext) {
            Token token = ctx.getStop();
            tableAliasName = token.getText();

            // Can go ahead and put in map from here.
            // Can assume that tableName was populated above if we have an alias.
            this.aliasedTableNames.put(tableAliasName, tableName);
        }

        // Subquery token will be stop field.
        if (ctx.children != null && ctx.children.get(0) instanceof Derived_tableContext) {
            Token token = ctx.getStop();
            // Can add to list from here.
            this.subqueries.put(token.getText(), token);
        }

    }

    @Override
    public void enterFull_table_name(MocaSqlParser.Full_table_nameContext ctx) {

        // Table token we care about will be the last token, since it could be fully
        // qualified table name.
        this.tableTokens.add(ctx.getStop());
    }

    @Override
    public void enterTable_name(MocaSqlParser.Table_nameContext ctx) {

        // Table token we care about will be the last token, since it could be fully
        // qualified table name.
        this.tableTokens.add(ctx.getStop());
    }

    @Override
    public void enterColumn_elem(MocaSqlParser.Column_elemContext ctx) {

        // Stop token will be column we care about.
        Token columnToken = ctx.getStop();
        String tableName = null;

        if (ctx.table_name() != null) {
            /// Table token we care about will be the last token, since it could be fully
            // qualified table name.
            tableName = ctx.table_name().getStop().getText();

        } else {
            // If table name is null, we can get the tables via going up through parents.
            // Parent should be select_list_elem, then select_list, then
            // query_specification.
            if (ctx.parent instanceof Select_list_elemContext && ctx.parent.parent instanceof Select_listContext
                    && ctx.parent.parent.parent instanceof Query_specificationContext) {
                // We should be able to access table_sources and downward to get what we need.
                Query_specificationContext querySpecCtx = (Query_specificationContext) ctx.parent.parent.parent;
                if (querySpecCtx.table_sources() != null) {
                    Table_sourcesContext tblSrcCtx = querySpecCtx.table_sources();
                    if (tblSrcCtx.table_source().size() > 1) {
                        // If greater than 1, we know there are multiple tables. Let's indicate this via
                        // the table name.
                        tableName = "__MULTIPLE_TABLES";
                    } else {
                        tableName = tblSrcCtx.table_source().get(0).getStop().getText();
                    }
                }
            }
        }

        // Now add current table token and column to map.
        if (this.columnTokens.containsKey(tableName)) {
            ArrayList<Token> columnTokenList = this.columnTokens.get(tableName);
            columnTokenList.add(columnToken);
        } else {
            ArrayList<Token> columnTokenList = new ArrayList<>();
            columnTokenList.add(columnToken);
            this.columnTokens.put(tableName, columnTokenList);

        }
    }

    @Override
    public void enterFull_column_name(MocaSqlParser.Full_column_nameContext ctx) {

        // Stop token will be column we care about.
        Token columnToken = ctx.getStop();
        String tableName = null;

        if (ctx.table_name() != null) {
            /// Table token we care about will be the last token, since it could be fully
            // qualified table name.
            tableName = ctx.table_name().getStop().getText();

        } else {

        }

        // Now add current table token and column to map.
        if (this.columnTokens.containsKey(tableName)) {
            ArrayList<Token> columnTokenList = this.columnTokens.get(tableName);
            columnTokenList.add(columnToken);
        } else {
            ArrayList<Token> columnTokenList = new ArrayList<>();
            columnTokenList.add(columnToken);
            this.columnTokens.put(tableName, columnTokenList);

        }
    }

    @Override
    public void enterColumn_name_list(MocaSqlParser.Column_name_listContext ctx) {

        // Column tokens will be delimited by commas -- let's go ahead and put them in a
        // list.
        ArrayList<Token> columnTokenList = new ArrayList<>();
        for (int i = 0; i < ctx.children.size(); i++) {
            Object child = ctx.children.get(i).getPayload();
            if (child instanceof CommonToken) {
                CommonToken commonToken = (CommonToken) child;

                if (commonToken.getType() == MocaSqlLexer.ID) {
                    columnTokenList.add((Token) commonToken);
                }
            }
        }

        String tableName = null;
        // We can get table name by getting parent and accessing it's ddl_object.
        if (ctx.parent instanceof Ddl_objectContext) {
            Ddl_objectContext ddlCtx = (Ddl_objectContext) ctx.parent;
            if (ddlCtx.full_table_name() != null) {
                // Table token we care about will be the last token, since it could be fully
                // qualified table name.
                tableName = ddlCtx.full_table_name().getStop().getText();
            }
        }

        // Add to map.
        if (this.columnTokens.containsKey(tableName)) {
            this.columnTokens.get(tableName).addAll(columnTokenList);
        } else {
            this.columnTokens.put(tableName, columnTokenList);

        }
    }

}