package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.ast;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlBaseListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Derived_tableContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Dml_clauseContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.IdContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Insert_statementContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Query_specificationContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.SubqueryContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_source_item_joinedContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser.Table_sourcesContext;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;

public class MocaSqlParseTreeListener extends MocaSqlBaseListener {

    public static final String MULTIPLE_TABLES_DETECTED_FOR_COLUMN = "__MULTIPLE_TABLES_DETECTED_FOR_COLUMN__";
    public static final String ANONYMOUS_SUBQUERY = "__ANONYMOUS_SUBQUERY__";

    public ArrayList<Token> tableTokens;
    public HashMap<String, String> aliasedTableNames; // Key is alias and Value is table name.
    public HashMap<String, ArrayList<Token>> columnTokens; // Key is table name.
    public HashMap<String, SubqueryContext> subqueries; // Key is subquery name.
    public HashMap<SubqueryContext, ArrayList<Token>> subqueryColumns;

    public MocaSqlParseTreeListener() {
        this.tableTokens = new ArrayList<>();
        this.aliasedTableNames = new HashMap<>();
        this.subqueries = new HashMap<>();
        this.subqueryColumns = new HashMap<>();
        this.columnTokens = new HashMap<>();

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

        String tableName = null;
        String tableAliasName = null;

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
                this.aliasedTableNames.put(tableAliasName, tableName);
            }
        }

        // Subquery analysis.
        if (ctx.derived_table() != null) {
            Derived_tableContext derivedTableCtx = ctx.derived_table();
            // We want to store the alias.
            if (ctx.as_table_alias() != null) {
                // Can add to list from here.
                this.subqueries.put(ctx.as_table_alias().table_alias().id().getText(), derivedTableCtx.subquery());
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

        // Table token we care about will be the last token, since it could be fully
        // qualified table name.
        this.tableTokens.add(ctx.getStop());
    }

    // SELECT statements.
    @Override
    public void enterTable_name(MocaSqlParser.Table_nameContext ctx) {

        // Table token we care about will be the last token, since it could be fully
        // qualified table name.
        this.tableTokens.add(ctx.getStop());
    }

    // SELECT statements.
    @Override
    public void enterColumn_elem(MocaSqlParser.Column_elemContext ctx) {

        Token columnToken = ctx.id().getStop();

        String tableName = null;

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
                Table_sourcesContext tblSrcCtx = querySpecCtx.table_sources();
                if (tblSrcCtx != null) {

                    if (tblSrcCtx.table_source().size() > 1) {
                        // If greater than 1, we know there are multiple tables. Let's indicate this via
                        // the table name. this would be an old style join.
                        tableName = MULTIPLE_TABLES_DETECTED_FOR_COLUMN;
                    } else {
                        // Now check if we are joining in here -- if so, note multiple tables.
                        Table_source_item_joinedContext tblSrcJoinCtx = tblSrcCtx.table_source().get(0)
                                .table_source_item_joined();
                        if (tblSrcJoinCtx != null && tblSrcJoinCtx.join_part() != null
                                && tblSrcJoinCtx.join_part().size() >= 1) {
                            tableName = MULTIPLE_TABLES_DETECTED_FOR_COLUMN;
                        } else {
                            // Should just have 1 table/subquery.
                            String possibleTableName = tblSrcCtx.table_source().get(0).getStop().getText();
                            // Could be a nameless subquery.
                            if (possibleTableName.compareTo(")") == 0) {
                                tableName = ANONYMOUS_SUBQUERY;
                            } else {
                                tableName = possibleTableName;
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

    // WHERE & SET clauses.
    @Override
    public void enterFull_column_name(MocaSqlParser.Full_column_nameContext ctx) {

        Token columnToken = ctx.id().getStop();

        String tableName = null;

        if (ctx.table_name() != null) {
            // Table token we care about will be the last token, since it could be fully
            // qualified table name.
            tableName = ctx.table_name().getStop().getText();

        } else {
            // If table name is null, we can get the tables via going up through parents.
            // Parent we want is query_specification. Query spec will exist if we are in the
            // WHERE clause of a SELECT statement.
            Query_specificationContext querySpecCtx = (Query_specificationContext) getParentRuleContext(ctx,
                    Query_specificationContext.class);

            if (querySpecCtx != null) {
                // We should be able to access table_sources and downward to get what we need.
                Table_sourcesContext tblSrcCtx = querySpecCtx.table_sources();
                if (tblSrcCtx != null) {

                    if (tblSrcCtx.table_source().size() > 1) {
                        // If greater than 1, we know there are multiple tables. Let's indicate this via
                        // the table name. this would be an old style join.
                        tableName = MULTIPLE_TABLES_DETECTED_FOR_COLUMN;
                    } else {
                        // Now check if we are joining in here -- if so, note multiple tables.
                        Table_source_item_joinedContext tblSrcJoinCtx = tblSrcCtx.table_source().get(0)
                                .table_source_item_joined();
                        if (tblSrcJoinCtx != null && tblSrcJoinCtx.join_part() != null
                                && tblSrcJoinCtx.join_part().size() >= 1) {
                            tableName = MULTIPLE_TABLES_DETECTED_FOR_COLUMN;
                        } else {
                            // Should just have 1 table/subquery.
                            String possibleTableName = tblSrcCtx.table_source().get(0).getStop().getText();
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
    public void enterAsterisk(MocaSqlParser.AsteriskContext ctx) {
        // MocaSqlParser does not consider '*' a column element, though we want to treat
        // it the same way. Therefore, we are going to do the same thing here that we
        // are doing for column elems.

        Token asteriskToken = ctx.getStop();

        String tableName = null;

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
                Table_sourcesContext tblSrcCtx = querySpecCtx.table_sources();
                if (tblSrcCtx != null) {

                    if (tblSrcCtx.table_source().size() > 1) {
                        // If greater than 1, we know there are multiple tables. Let's indicate this via
                        // the table name. this would be an old style join.
                        tableName = MULTIPLE_TABLES_DETECTED_FOR_COLUMN;
                    } else {
                        // Now check if we are joining in here -- if so, note multiple tables.
                        Table_source_item_joinedContext tblSrcJoinCtx = tblSrcCtx.table_source().get(0)
                                .table_source_item_joined();
                        if (tblSrcJoinCtx != null && tblSrcJoinCtx.join_part() != null
                                && tblSrcJoinCtx.join_part().size() >= 1) {
                            tableName = MULTIPLE_TABLES_DETECTED_FOR_COLUMN;
                        } else {
                            // Should just have 1 table/subquery.
                            String possibleTableName = tblSrcCtx.table_source().get(0).getStop().getText();
                            // Could be a nameless subquery.
                            if (possibleTableName.compareTo(")") == 0) {
                                tableName = ANONYMOUS_SUBQUERY;
                            } else {
                                tableName = possibleTableName;
                            }

                        }
                    }
                }

                // Now the goal is to see if this column elem is inside of a subquery.
                // Let's try to find a subquery context parent and go from there.
                SubqueryContext subqueryCtx = (SubqueryContext) getParentRuleContext(ctx, SubqueryContext.class);
                if (subqueryCtx != null) {

                    // Check subquery columns map first.
                    if (this.subqueryColumns.containsKey(subqueryCtx)) {
                        this.subqueryColumns.get(subqueryCtx).add(asteriskToken);
                    } else {
                        // Let's see if we have an value in the subquery map that matches.
                        if (this.subqueries.values().contains(subqueryCtx)) {
                            // We need to put in a new sub query column map entry.
                            ArrayList<Token> subqueryColumnTokens = new ArrayList<>();
                            subqueryColumnTokens.add(asteriskToken);
                            this.subqueryColumns.put(subqueryCtx, subqueryColumnTokens);
                        }
                    }
                }
            }
        }

        // Now add current table token and column to map.
        if (this.columnTokens.containsKey(tableName)) {
            ArrayList<Token> columnTokenList = this.columnTokens.get(tableName);
            columnTokenList.add(asteriskToken);
        } else {
            ArrayList<Token> columnTokenList = new ArrayList<>();
            columnTokenList.add(asteriskToken);
            this.columnTokens.put(tableName, columnTokenList);
        }
    }

}