package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCache;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.TableColumn;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlBaseListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Derived_tableContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Dml_clauseContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Expression_elemContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.IdContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Insert_statementContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Join_partContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Query_specificationContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Select_list_elemContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Select_statementContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.SubqueryContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_sourceContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_source_item_joinedContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_sourcesContext;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;

public class MocaSqlParseTreeListener extends MocaSqlBaseListener {

    public static final String ANONYMOUS_SUBQUERY = "__ANONYMOUS_SUBQUERY__";

    public ArrayList<Token> tableTokens;
    public HashMap<String, String> tableAliasNames; // Key is table alias name and Value is table name.
    public HashMap<String, ArrayList<Token>> columnTokens; // Key is table name.
    public ArrayList<String> columnAliasNames;
    public HashMap<String, SubqueryContext> subqueries; // Key is subquery name.
    public HashMap<SubqueryContext, ArrayList<Token>> subqueryColumns;

    public MocaSqlParseTreeListener() {
        this.tableTokens = new ArrayList<>();
        this.tableAliasNames = new HashMap<>();
        this.columnTokens = new HashMap<>();
        this.columnAliasNames = new ArrayList<>();
        this.subqueries = new HashMap<>();
        this.subqueryColumns = new HashMap<>();
    }

    private static RuleContext getParentRuleContext(RuleContext ctx, Class<?> parentRuleContextClass) {

        RuleContext p = ctx;
        while (p.parent != null) {
            if (p.parent.getClass() == parentRuleContextClass) {
                return p.parent;
            } else {
                p = p.parent;
            }
        }

        return null;
    }

    // SELECT statements.
    @Override
    public void enterTable_source_item(MocaSqlParser.Table_source_itemContext ctx) {

        if (ctx == null) {
            return;
        }

        String tableName = "";
        String tableAliasName = "";

        // Want to make sure we are not dealing with subquery here.
        if (ctx.table_name_with_hint() != null) {
            // If table is fully qualified, we want to make sure we just get the name --
            // stop token will work.
            tableName = ctx.table_name_with_hint().table_name().getStop().getText();

            // No need to add table token to list -- our enterTable_name listener will do
            // so!

            // Check if alias.
            if (ctx.as_table_alias() != null) {
                tableAliasName = ctx.as_table_alias().table_alias().id().getText();

                // Can go ahead and put in map from here.
                // Can assume that tableName was populated above if we have an alias.
                this.tableAliasNames.put(tableAliasName, tableName);
            }
        }

        // Subquery analysis.
        if (ctx.derived_table() != null) {
            Derived_tableContext derivedTableCtx = ctx.derived_table();
            // We want to store the alias.
            if (ctx.as_table_alias() != null) {
                // Can add to list from here.
                this.subqueries.put(ctx.as_table_alias().table_alias().id().getText().toLowerCase(),
                        derivedTableCtx.subquery());
            } else {
                // Mark subquery as anon.
                this.subqueries.put(ANONYMOUS_SUBQUERY, derivedTableCtx.subquery());
            }

            // Subquery columns will be retrieved in a different function!

        }

    }

    // INSERT, UPDATE, DELETE statements.
    @Override
    public void enterFull_table_name(MocaSqlParser.Full_table_nameContext ctx) {

        if (ctx == null) {
            return;
        }

        // Table token we care about will be the last token, since it could be fully
        // qualified table name.
        this.tableTokens.add(ctx.getStop());
    }

    // SELECT statements.
    @Override
    public void enterTable_name(MocaSqlParser.Table_nameContext ctx) {

        if (ctx == null) {
            return;
        }

        // Table token we care about will be the last token, since it could be fully
        // qualified table name.
        this.tableTokens.add(ctx.getStop());
    }

    // SELECT statements.
    @Override
    public void enterColumn_elem(MocaSqlParser.Column_elemContext ctx) {

        if (ctx == null || ctx.id() == null) {
            return;
        }

        Token columnToken = ctx.id().getStop();

        String tableName = "";

        if (ctx.table_name() != null) {
            /// Table token we care about will be the last token, since it could be fully
            // qualified table name.
            tableName = ctx.table_name().getStop().getText();

        } else {
            // If table name is null, we can get the tables via going up through parents.
            // Parent we want is query_specification. Right now, we are likely in the column
            // list of a SELECT clause.
            Query_specificationContext querySpecCtx = (Query_specificationContext) getParentRuleContext(ctx,
                    Query_specificationContext.class);

            if (querySpecCtx != null) {
                // We should be able to access table_sources and downward to get what we need.
                Table_sourcesContext tblSrcsCtx = querySpecCtx.table_sources();
                if (tblSrcsCtx != null) {

                    if (tblSrcsCtx.table_source().size() > 1) {
                        // If greater than 1, we know there are multiple tables -- we will build a
                        // string of table names delimited by commas.
                        for (Table_sourceContext tblSrcCtx : tblSrcsCtx.table_source()) {
                            tableName += (tblSrcCtx.getStop().getText() + ",");
                        }
                    } else {
                        // Now check if we are joining in here -- if so, note multiple tables.
                        // We will build a string of table names delimited by commas.
                        Table_source_item_joinedContext tblSrcJoinCtx = tblSrcsCtx.table_source().get(0)
                                .table_source_item_joined();
                        if (tblSrcJoinCtx != null && tblSrcJoinCtx.join_part() != null
                                && tblSrcJoinCtx.join_part().size() >= 1) {
                            // For joins here, we also need to get the table from the FROM clause, since the
                            // join part contexts do not include it.
                            tableName += (tblSrcJoinCtx.table_source_item().getStop().getText() + ",");
                            for (Join_partContext joinPartCtx : tblSrcJoinCtx.join_part()) {
                                tableName += (joinPartCtx.table_source().getStop().getText() + ",");
                            }
                        } else {
                            // Should just have 1 table/subquery.
                            String possibleTableName = tblSrcsCtx.table_source().get(0).getStop().getText();
                            // Could be a nameless subquery.
                            if (possibleTableName.compareTo(")") == 0) {
                                tableName = ANONYMOUS_SUBQUERY;
                            } else {
                                tableName = possibleTableName;
                            }

                        }
                    }
                }
            }
        }

        // Now the goal is to see if this column elem is inside of a subquery.
        // Let's try to find a subquery context parent and go from there.
        SubqueryContext subqueryCtx = (SubqueryContext) getParentRuleContext(ctx, SubqueryContext.class);
        if (subqueryCtx != null) {

            // With subquery, we want to add the column alias if it exists.
            Token subqueryColumnToken = columnToken;
            if (ctx.as_column_alias() != null) {
                subqueryColumnToken = ctx.as_column_alias().getStop();
            }

            // Check subquery columns map first.
            if (this.subqueryColumns.containsKey(subqueryCtx)) {
                this.subqueryColumns.get(subqueryCtx).add(subqueryColumnToken);
            } else {
                // Let's see if we have an value in the subquery map that matches.
                if (this.subqueries.values().contains(subqueryCtx)) {
                    // We need to put in a new sub query column map entry.
                    ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                    subqueryColumnTokens.add(subqueryColumnToken);
                    this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                } else {
                    // Looks like subquery context does not exist in subqueries map yet. Let's go
                    // ahead and still add to subquery columns map.
                    // We need to put in a new sub query column map entry.
                    ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                    subqueryColumnTokens.add(subqueryColumnToken);
                    this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
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

    // WHERE & SET clauses.
    // Could also be in expression in SELECT clause (WHERE/GROUP BY/ORDER BY
    // clauses).
    @Override
    public void enterFull_column_name(MocaSqlParser.Full_column_nameContext ctx) {

        if (ctx == null || ctx.id() == null) {
            return;
        }

        Token columnToken = ctx.id().getStop();

        String tableName = "";

        if (ctx.table_name() != null) {
            // Table token we care about will be the last token, since it could be fully
            // qualified table name.
            tableName = ctx.table_name().getStop().getText();

        } else {
            // If table name is null, we can get the tables via going up through parents.
            // Parent we want is select_statement. Select statement context will exist if we
            // are in the WHERE/GROUP BY/ORDER BY clause of a SELECT statement.
            Select_statementContext selectStatementCtx = (Select_statementContext) getParentRuleContext(ctx,
                    Select_statementContext.class);

            if (selectStatementCtx != null && selectStatementCtx.query_expression() != null) {
                // First try to get query spec from select statement context. This could fail in
                // certain circumstances.
                Query_specificationContext querySpecCtx = selectStatementCtx.query_expression().query_specification();

                // If null, get query spec from ctx.
                if (querySpecCtx == null) {
                    querySpecCtx = (Query_specificationContext) getParentRuleContext(ctx,
                            Query_specificationContext.class);
                }

                // With query spec context, We should be able to access table_sources and
                // downward to get what we need.
                Table_sourcesContext tblSrcsCtx = querySpecCtx.table_sources();
                if (tblSrcsCtx != null) {
                    if (tblSrcsCtx.table_source().size() > 1) {
                        // If greater than 1, we know there are multiple tables -- we will build a
                        // string of table names delimited by commas.
                        for (Table_sourceContext tblSrcCtx : tblSrcsCtx.table_source()) {
                            tableName += (tblSrcCtx.getStop().getText() + ",");
                        }
                    } else {
                        // Now check if we are joining in here -- if so, note multiple tables.
                        // We will build a string of table names delimited by commas.
                        Table_source_item_joinedContext tblSrcJoinCtx = tblSrcsCtx.table_source().get(0)
                                .table_source_item_joined();
                        if (tblSrcJoinCtx != null && tblSrcJoinCtx.join_part() != null
                                && tblSrcJoinCtx.join_part().size() >= 1) {
                            // For joins here, we also need to get the table from the FROM clause, since the
                            // join part contexts do not include it.
                            tableName += (tblSrcJoinCtx.table_source_item().getStop().getText() + ",");
                            for (Join_partContext joinPartCtx : tblSrcJoinCtx.join_part()) {
                                tableName += (joinPartCtx.table_source().getStop().getText() + ",");
                            }
                        } else {
                            // Should just have 1 table/subquery.
                            String possibleTableName = tblSrcsCtx.table_source().get(0).getStop().getText();
                            // Could be a nameless subquery.
                            if (possibleTableName.compareTo(")") == 0) {
                                tableName = ANONYMOUS_SUBQUERY;
                            } else {
                                tableName = possibleTableName;
                            }

                        }
                    }
                }
            } else {
                // If query spec ctx is null, that means we need to look for a different parent.
                // Let's try DML clause. It is likely that we are now in a UPDATE statement
                // SET/WHERE or DELETE statement WHERE clause.
                Dml_clauseContext dmlClauseCtx = (Dml_clauseContext) getParentRuleContext(ctx, Dml_clauseContext.class);

                if (dmlClauseCtx != null) {
                    // Process update and delete -- we already of select covered above and have
                    // insert covered in another function.
                    if (dmlClauseCtx.update_statement() != null) {
                        tableName = dmlClauseCtx.update_statement().ddl_object().full_table_name().getStop().getText();
                    } else if (dmlClauseCtx.delete_statement() != null) {
                        // Assume we have a table here.
                        tableName = dmlClauseCtx.delete_statement().delete_statement_from().ddl_object()
                                .full_table_name().getStop().getText();
                    }
                }
            }
        }

        // Now the goal is to see if this full column name is inside an expression_elem
        // inside of a subquery.
        // Let's try to find a subquery context parent and go from there.
        SubqueryContext subqueryCtx = (SubqueryContext) getParentRuleContext(ctx, SubqueryContext.class);
        if (subqueryCtx != null) {

            // Looks like we are in a subquery. Now let's try to get the expression_elem
            // parent.
            Expression_elemContext expression_elemContext = (Expression_elemContext) getParentRuleContext(ctx,
                    Expression_elemContext.class);
            if (expression_elemContext != null) {
                // Nice -- we have an expression elem parent. Now let's see if it has a column
                // alias indicated. If so, we will add it to subquery columns.

                if (expression_elemContext.as_column_alias() != null) {
                    Token subqueryColumnToken = expression_elemContext.as_column_alias().getStop();

                    // Check subquery columns map first.
                    if (this.subqueryColumns.containsKey(subqueryCtx)) {
                        this.subqueryColumns.get(subqueryCtx).add(subqueryColumnToken);
                    } else {
                        // Let's see if we have an value in the subquery map that matches.
                        if (this.subqueries.values().contains(subqueryCtx)) {
                            // We need to put in a new sub query column map entry.
                            ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                            subqueryColumnTokens.add(subqueryColumnToken);
                            this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                        } else {
                            // Looks like subquery context does not exist in subqueries map yet. Let's go
                            // ahead and still add to subquery columns map.
                            // We need to put in a new sub query column map entry.
                            ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                            subqueryColumnTokens.add(subqueryColumnToken);
                            this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                        }
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

    // INSERT statements.
    @Override
    public void enterColumn_name_list(MocaSqlParser.Column_name_listContext ctx) {

        if (ctx == null || ctx.children == null) {
            return;
        }

        // Column tokens will be delimited by commas -- let's go ahead and put them in a
        // list.
        ArrayList<Token> columnTokenList = new ArrayList<>();

        for (int i = 0; i < ctx.children.size(); i++) {
            Object child = ctx.children.get(i).getPayload();
            if (child instanceof IdContext) {
                IdContext idCtx = (IdContext) child;
                columnTokenList.add(idCtx.getStop());
            }
        }

        String tableName = null;
        // We can get table name by getting parent insert statement and accessing it's
        // ddl_object.
        Insert_statementContext insertStatementCtx = (Insert_statementContext) getParentRuleContext(ctx,
                Insert_statementContext.class);
        if (insertStatementCtx != null && insertStatementCtx.ddl_object().full_table_name() != null) {
            // Table token we care about will be the last token, since it could be fully
            // qualified table name.
            tableName = insertStatementCtx.ddl_object().full_table_name().getStop().getText();
        }

        // Add to map.
        if (this.columnTokens.containsKey(tableName)) {
            this.columnTokens.get(tableName).addAll(columnTokenList);
        } else {
            this.columnTokens.put(tableName, columnTokenList);
        }
    }

    // SELECT statements.
    @Override
    public void exitAsterisk(MocaSqlParser.AsteriskContext ctx) {
        // MocaSqlParser does not consider '*' a column element, though we want to treat
        // it like one. Instead of just adding it like a regular column elem, we
        // will get all of the columns in the mocasql cache/subquery for the
        // table/subquery that it refers to and add them to the column list. If there
        // are no columns, we will not worry about adding anything -- including the
        // asterisk.

        if (ctx == null) {
            return;
        }

        Token asteriskToken = ctx.getStop();
        ArrayList<Token> columnTokensForAsterisk = new ArrayList<>();

        String tableName = "";

        if (ctx.table_name() != null) {
            /// Table token we care about will be the last token, since it could be fully
            // qualified table name.
            tableName = ctx.table_name().getStop().getText();

        } else {
            // If table name is null, we can get the tables via going up through parents.
            // Parent we want is query_specification. Right now, we are likely in the column
            // list of a SELECT clause.
            Query_specificationContext querySpecCtx = (Query_specificationContext) getParentRuleContext(ctx,
                    Query_specificationContext.class);

            if (querySpecCtx != null) {
                // We should be able to access table_sources and downward to get what we need.
                Table_sourcesContext tblSrcsCtx = querySpecCtx.table_sources();
                if (tblSrcsCtx != null) {

                    if (tblSrcsCtx.table_source().size() > 1) {
                        // If greater than 1, we know there are multiple tables -- we will build a
                        // string of table names delimited by commas.
                        for (Table_sourceContext tblSrcCtx : tblSrcsCtx.table_source()) {
                            tableName += (tblSrcCtx.getStop().getText() + ",");
                        }
                    } else {
                        // Now check if we are joining in here -- if so, note multiple tables.
                        // We will build a string of table names delimited by commas.
                        Table_source_item_joinedContext tblSrcJoinCtx = tblSrcsCtx.table_source().get(0)
                                .table_source_item_joined();
                        if (tblSrcJoinCtx != null && tblSrcJoinCtx.join_part() != null
                                && tblSrcJoinCtx.join_part().size() >= 1) {
                            // For joins here, we also need to get the table from the FROM clause, since the
                            // join part contexts do not include it.
                            tableName += (tblSrcJoinCtx.table_source_item().getStop().getText() + ",");
                            for (Join_partContext joinPartCtx : tblSrcJoinCtx.join_part()) {
                                if (joinPartCtx.table_source() != null) {
                                    tableName += (joinPartCtx.table_source().getStop().getText() + ",");
                                }
                            }
                        } else {
                            // Should just have 1 table/subquery.
                            String possibleTableName = tblSrcsCtx.table_source().get(0).getStop().getText();
                            // Could be a nameless subquery.
                            if (possibleTableName.compareTo(")") == 0) {
                                tableName = ANONYMOUS_SUBQUERY;
                            } else {
                                tableName = possibleTableName;
                            }

                        }
                    }
                }
            }
        }

        // Before we try to get all columns that asterisk is referring to, we need to
        // see what the table is.
        boolean processedAsteriskColumns = false;

        // Check table/view cache first.
        if (!processedAsteriskColumns) {

            ArrayList<TableColumn> tableColumnsForAsterisk = MocaCache.getGlobalMocaCache().mocaSqlCache
                    .getColumnsForTable(tableName);

            if (tableColumnsForAsterisk != null) {

                processedAsteriskColumns = true;

                for (TableColumn tableColumn : tableColumnsForAsterisk) {
                    // Should be able to just use all the details for the asterisk token and just
                    // change the text.
                    CommonToken commonToken = new CommonToken(asteriskToken);
                    commonToken.setText(tableColumn.column_name);
                    columnTokensForAsterisk.add((Token) commonToken);
                }
            }
        }

        // Check aliases next.
        if (this.tableAliasNames.containsKey(tableName)) {
            processedAsteriskColumns = true;

            // Get all columns from cache for aliased table.
            ArrayList<TableColumn> tableColumnsForAsterisk = MocaCache.getGlobalMocaCache().mocaSqlCache
                    .getColumnsForTable(this.tableAliasNames.get(tableName));

            if (tableColumnsForAsterisk != null) {
                for (TableColumn tableColumn : tableColumnsForAsterisk) {
                    // Should be able to just use all the details for the asterisk token and just
                    // change the text.
                    CommonToken commonToken = new CommonToken(asteriskToken);
                    commonToken.setText(tableColumn.column_name);
                    columnTokensForAsterisk.add((Token) commonToken);
                }
            }
        }

        // Finally, check subqueries.
        if (!processedAsteriskColumns && this.subqueries.containsKey(tableName)) {
            processedAsteriskColumns = true;

            ArrayList<Token> subqueryColumnTokens = this.subqueryColumns.get(this.subqueries.get(tableName));
            if (subqueryColumnTokens != null) {
                for (Token subqueryColumnToken : subqueryColumnTokens) {
                    // Should be able to just use all the details for the asterisk token and just
                    // change the text.
                    CommonToken commonToken = new CommonToken(asteriskToken);
                    commonToken.setText(subqueryColumnToken.getText());
                    columnTokensForAsterisk.add((Token) commonToken);
                }
            }
        }

        // Now the goal is to see if this column elem is inside of a subquery.
        // Let's try to find a subquery context parent and go from there.
        SubqueryContext subqueryCtx = (SubqueryContext) getParentRuleContext(ctx, SubqueryContext.class);
        if (subqueryCtx != null) {

            // Check subquery columns map first.
            if (this.subqueryColumns.containsKey(subqueryCtx)) {
                this.subqueryColumns.get(subqueryCtx).addAll(columnTokensForAsterisk);
            } else {
                // Let's see if we have an value in the subquery map that matches.
                if (this.subqueries.values().contains(subqueryCtx)) {
                    // We need to put in a new sub query column map entry.
                    ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                    subqueryColumnTokens.addAll(columnTokensForAsterisk);
                    this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                } else {
                    // Looks like subquery context does not exist in subqueries map yet. Let's go
                    // ahead and still add to subquery columns map.
                    // We need to put in a new sub query column map entry.
                    ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                    subqueryColumnTokens.addAll(columnTokensForAsterisk);
                    this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                }
            }
        }

        // Now add current table token and column to map.
        if (this.columnTokens.containsKey(tableName)) {
            ArrayList<Token> columnTokenList = this.columnTokens.get(tableName);
            columnTokenList.addAll(columnTokensForAsterisk);
        } else {
            ArrayList<Token> columnTokenList = new ArrayList<>();
            columnTokenList.addAll(columnTokensForAsterisk);
            this.columnTokens.put(tableName, columnTokenList);
        }
    }

    // SELECT statements.
    @Override
    public void enterColumn_alias(MocaSqlParser.Column_aliasContext ctx) {
        if (ctx == null) {
            return;
        }

        Token columnToken = ctx.id().getStop();

        // Let's go ahead add to column alias list.
        this.columnAliasNames.add(columnToken.getText());

        // Since we are handling column aliases elsewhere, we will only worry about
        // scenarios where column alias is in a subquery and is accompanied by
        // expression instead of a column type element. This happens in situations like
        // this:
        // "select subq.test_alias from (select 'expr' test_alias from dual) subq"
        // -------------------------------------^^^^^^

        // First make sure this is ^ scenario. We can do this by confirming that we have
        // expression elem parent.
        Expression_elemContext exprElemCtx = (Expression_elemContext) getParentRuleContext(ctx,
                Expression_elemContext.class);
        if (exprElemCtx != null) {
            // Basically we want to make sure we are in a SELECT clause before we try to get
            // subquery context. To do this, we will make sure we have a select list
            // element parent. If we do, then we will get subquery parent and go from
            // there.
            Select_list_elemContext selectListElemCtx = (Select_list_elemContext) getParentRuleContext(exprElemCtx,
                    Select_list_elemContext.class);
            if (selectListElemCtx != null) {

                // Now the goal is to see if we are inside a subquery.
                SubqueryContext subqueryCtx = (SubqueryContext) getParentRuleContext(selectListElemCtx,
                        SubqueryContext.class);
                if (subqueryCtx != null) {

                    // Check subquery columns map first.
                    if (this.subqueryColumns.containsKey(subqueryCtx)) {
                        this.subqueryColumns.get(subqueryCtx).add(columnToken);
                    } else {
                        // Let's see if we have an value in the subquery map that matches.
                        if (this.subqueries.values().contains(subqueryCtx)) {
                            // We need to put in a new sub query column map entry.
                            ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                            subqueryColumnTokens.add(columnToken);
                            this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                        } else {
                            // Looks like subquery context does not exist in subqueries map yet. Let's go
                            // ahead and still add to subquery columns map.
                            // We need to put in a new sub query column map entry.
                            ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                            subqueryColumnTokens.add(columnToken);
                            this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                        }
                    }
                }
            }
        }
    }
}