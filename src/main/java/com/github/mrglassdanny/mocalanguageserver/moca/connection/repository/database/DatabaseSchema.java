package com.github.mrglassdanny.mocalanguageserver.moca.connection.repository.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnectionWrapper;
import com.redprairie.moca.MocaResults;

public class DatabaseSchema {

    private static final String TABLES_SCRIPT = "list user tables description";
    private static final String VIEWS_SCRIPT = "list user views";
    private static final String TABLE_COLUMNS_SCRIPT = "list user tables | list table columns where table_name = @table_name";
    private static final String VIEW_COLUMNS_SCRIPT = "list user views | list table columns where table_name = @view_name";

    public HashMap<String, Table> tables;
    public HashMap<String, Table> views;
    public HashMap<String, ArrayList<TableColumn>> columns;

    public DatabaseSchema() {
        this.tables = new HashMap<>();
        this.views = new HashMap<>();
        this.columns = new HashMap<>();
    }

    public void loadAsync(MocaConnectionWrapper conn) {

        CompletableFuture.runAsync(() -> {
            this.loadTables(conn);
        });

        CompletableFuture.runAsync(() -> {
            this.loadViews(conn);
        });

        CompletableFuture.runAsync(() -> {
            this.loadColumns(conn);
        });

    }

    public void loadTables(MocaConnectionWrapper conn) {

        this.tables.clear();

        MocaResults res = conn.executeCommand(DatabaseSchema.TABLES_SCRIPT).results;

        if (res != null) {
            while (res.next()) {
                String tableName = res.getString("table_name").toLowerCase();
                this.tables.put(tableName, new Table(tableName, res.getString("description")));
            }
        }
    }

    public void loadViews(MocaConnectionWrapper conn) {

        this.views.clear();

        MocaResults res = conn.executeCommand(DatabaseSchema.VIEWS_SCRIPT).results;

        if (res != null) {
            while (res.next()) {
                String viewName = res.getString("view_name").toLowerCase();
                this.views.put(viewName, new Table(viewName, ""));
            }
        }

        // Add 'dual' - lol.
        this.views.put("dual", new Table("dual", res.getString("")));

    }

    public void loadColumns(MocaConnectionWrapper conn) {

        this.columns.clear();

        MocaResults tableColRes = conn.executeCommand(DatabaseSchema.TABLE_COLUMNS_SCRIPT).results;
        MocaResults viewColRes = conn.executeCommand(DatabaseSchema.VIEW_COLUMNS_SCRIPT).results;

        // Due to how our loop works, we need to save off data here so that we do not
        // leave out the first column of every table(after the first table).
        TableColumn firstColumn = null;

        // For table columns and view columns, we can assume that the data is sorted by
        // table_name, column_name.
        if (tableColRes != null) {
            while (tableColRes.next()) {
                String tableName = tableColRes.getString("table_name");
                String curRowTableName = tableName; // Gets updated each row.
                ArrayList<TableColumn> tableCols = new ArrayList<>();

                // Check if we have a first column set from below.
                if (firstColumn != null) {
                    // If so, add it to the new array then null it out for the next go round.
                    tableCols.add(firstColumn);
                    firstColumn = null;
                }

                while (tableName.compareToIgnoreCase(curRowTableName) == 0) {

                    tableCols.add(new TableColumn(tableName, tableColRes.getString("column_name"),
                            tableColRes.getString("lngdsc"), tableColRes.getString("comtyp"),
                            tableColRes.getInt("length"), tableColRes.getBoolean("null_flg"),
                            tableColRes.getBoolean("pk_flg"), tableColRes.getBoolean("ident_flg"),
                            tableColRes.getString("column_comment")));

                    if (!tableColRes.next()) {
                        break;
                    }
                    curRowTableName = tableColRes.getString("table_name");
                    if (tableName.compareToIgnoreCase(curRowTableName) != 0) {
                        // New table. Need to save off some info so we dont lose the first column!
                        firstColumn = new TableColumn(tableName, tableColRes.getString("column_name"),
                                tableColRes.getString("lngdsc"), tableColRes.getString("comtyp"),
                                tableColRes.getInt("length"), tableColRes.getBoolean("null_flg"),
                                tableColRes.getBoolean("pk_flg"), tableColRes.getBoolean("ident_flg"),
                                tableColRes.getString("column_comment"));
                    }
                }

                // Now add to map.
                this.columns.put(tableName, tableCols);
            }
        }

        // Null out first column for start of views.
        firstColumn = null;

        if (viewColRes != null) {

            while (viewColRes.next()) {
                String viewName = viewColRes.getString("table_name");
                String curRowViewName = viewName; // Gets updated each row.
                ArrayList<TableColumn> viewCols = new ArrayList<>();

                // Check if we have a first column set from below.
                if (firstColumn != null) {
                    // If so, add it to the new array then null it out for the next go round.
                    viewCols.add(firstColumn);
                    firstColumn = null;
                }

                while (viewName.compareToIgnoreCase(curRowViewName) == 0) {

                    viewCols.add(new TableColumn(viewName, viewColRes.getString("column_name"),
                            viewColRes.getString("lngdsc"), viewColRes.getString("comtyp"), viewColRes.getInt("length"),
                            viewColRes.getBoolean("null_flg"), viewColRes.getBoolean("pk_flg"),
                            viewColRes.getBoolean("ident_flg"), viewColRes.getString("column_comment")));

                    if (!viewColRes.next()) {
                        break;
                    }
                    curRowViewName = viewColRes.getString("table_name");
                    if (viewName.compareToIgnoreCase(curRowViewName) != 0) {
                        // New view. Need to save off some info so we dont lose the first column!
                        firstColumn = new TableColumn(viewName, viewColRes.getString("column_name"),
                                viewColRes.getString("lngdsc"), viewColRes.getString("comtyp"),
                                viewColRes.getInt("length"), viewColRes.getBoolean("null_flg"),
                                viewColRes.getBoolean("pk_flg"), viewColRes.getBoolean("ident_flg"),
                                viewColRes.getString("column_comment"));
                    }
                }

                // Now add to map.
                this.columns.put(viewName, viewCols);
            }
        }
    }

    public ArrayList<TableColumn> getColumnsForTable(String tableName) {
        return this.columns.get(tableName);
    }

}