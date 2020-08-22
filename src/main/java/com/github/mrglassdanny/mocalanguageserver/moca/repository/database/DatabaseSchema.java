package com.github.mrglassdanny.mocalanguageserver.moca.repository.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.MocaResults;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnectionWrapper;

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
            for (int rowIdx = 0; rowIdx < res.values.length; rowIdx++) {
                String tableName = res.getString(rowIdx, "table_name").toLowerCase();
                this.tables.put(tableName, new Table(tableName, res.getString(rowIdx, "description")));
            }

        }
    }

    public void loadViews(MocaConnectionWrapper conn) {

        this.views.clear();

        MocaResults res = conn.executeCommand(DatabaseSchema.VIEWS_SCRIPT).results;

        if (res != null) {

            for (int rowIdx = 0; rowIdx < res.values.length; rowIdx++) {
                String viewName = res.getString(rowIdx, "view_name").toLowerCase();
                this.views.put(viewName, new Table(viewName, ""));
            }
        }

        // Add 'dual' - lol.
        this.views.put("dual", new Table("dual", ""));

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

            for (int rowIdx = 0; rowIdx < tableColRes.values.length; rowIdx++) {
                String tableName = tableColRes.getString(rowIdx, "table_name");
                String curRowTableName = tableName; // Gets updated each row.
                ArrayList<TableColumn> tableCols = new ArrayList<>();

                // Check if we have a first column set from below.
                if (firstColumn != null) {
                    // If so, add it to the new array then null it out for the next go round.
                    tableCols.add(firstColumn);
                    firstColumn = null;
                }

                while (tableName.compareToIgnoreCase(curRowTableName) == 0) {

                    tableCols.add(new TableColumn(tableName, tableColRes.getString(rowIdx, "column_name"),
                            tableColRes.getString(rowIdx, "lngdsc"), tableColRes.getString(rowIdx, "comtyp"),
                            tableColRes.getInt(rowIdx, "length"), tableColRes.getBoolean(rowIdx, "null_flg"),
                            tableColRes.getBoolean(rowIdx, "pk_flg"), tableColRes.getBoolean(rowIdx, "ident_flg"),
                            tableColRes.getString(rowIdx, "column_comment")));

                    if (rowIdx >= tableColRes.values.length) {
                        break;
                    } else {
                        rowIdx++;
                    }

                    curRowTableName = tableColRes.getString(rowIdx, "table_name");
                    if (tableName.compareToIgnoreCase(curRowTableName) != 0) {
                        // New table. Need to save off some info so we dont lose the first column!
                        firstColumn = new TableColumn(tableName, tableColRes.getString(rowIdx, "column_name"),
                                tableColRes.getString(rowIdx, "lngdsc"), tableColRes.getString(rowIdx, "comtyp"),
                                tableColRes.getInt(rowIdx, "length"), tableColRes.getBoolean(rowIdx, "null_flg"),
                                tableColRes.getBoolean(rowIdx, "pk_flg"), tableColRes.getBoolean(rowIdx, "ident_flg"),
                                tableColRes.getString(rowIdx, "column_comment"));
                    }
                }

                // Now add to map.
                this.columns.put(tableName, tableCols);
            }
        }

        // Null out first column for start of views.
        firstColumn = null;

        if (viewColRes != null) {

            for (int rowIdx = 0; rowIdx < viewColRes.values.length; rowIdx++) {
                String viewName = viewColRes.getString(rowIdx, "table_name");
                String curRowViewName = viewName; // Gets updated each row.
                ArrayList<TableColumn> viewCols = new ArrayList<>();

                // Check if we have a first column set from below.
                if (firstColumn != null) {
                    // If so, add it to the new array then null it out for the next go round.
                    viewCols.add(firstColumn);
                    firstColumn = null;
                }

                while (viewName.compareToIgnoreCase(curRowViewName) == 0) {

                    viewCols.add(new TableColumn(viewName, viewColRes.getString(rowIdx, "column_name"),
                            viewColRes.getString(rowIdx, "lngdsc"), viewColRes.getString(rowIdx, "comtyp"),
                            viewColRes.getInt(rowIdx, "length"), viewColRes.getBoolean(rowIdx, "null_flg"),
                            viewColRes.getBoolean(rowIdx, "pk_flg"), viewColRes.getBoolean(rowIdx, "ident_flg"),
                            viewColRes.getString(rowIdx, "column_comment")));

                    if (rowIdx >= viewColRes.values.length) {
                        break;
                    } else {
                        rowIdx++;
                    }

                    curRowViewName = viewColRes.getString(rowIdx, "table_name");
                    if (viewName.compareToIgnoreCase(curRowViewName) != 0) {
                        // New view. Need to save off some info so we dont lose the first column!
                        firstColumn = new TableColumn(viewName, viewColRes.getString(rowIdx, "column_name"),
                                viewColRes.getString(rowIdx, "lngdsc"), viewColRes.getString(rowIdx, "comtyp"),
                                viewColRes.getInt(rowIdx, "length"), viewColRes.getBoolean(rowIdx, "null_flg"),
                                viewColRes.getBoolean(rowIdx, "pk_flg"), viewColRes.getBoolean(rowIdx, "ident_flg"),
                                viewColRes.getString(rowIdx, "column_comment"));
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