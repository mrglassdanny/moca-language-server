package com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnection;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaSqlCache {

    private static final String TABLES_SCRIPT = "list user tables description\n" + "|\n" + "list table comment\n"
            + " where table_name = @table_name catch(@?)\n" + "|\n" + "if (@? = 0)\n" + "{\n" + "    publish data\n"
            + "     where table_name = @table_name\n" + "       and description = nvl(@description, @table_name)\n"
            + "       and table_comment = @table_comment\n" + "}\n" + "else\n" + "{\n" + "    publish data\n"
            + "     where table_name = @table_name\n" + "       and description = nvl(@description, @table_name)\n"
            + "       and table_comment = ''\n" + "}";
    private static final String VIEWS_SCRIPT = "list user views";
    private static final String COLUMNS_SCRIPT = "if (dbtype = 'ORACLE')\n" + "{\n" + "    [select col.table_name,\n"
            + "            col.column_id,\n" + "            col.column_name,\n" + "            col.data_type,\n"
            + "            col.data_length max_length\n" + "       from sys.all_tab_columns col\n" + "      inner\n"
            + "       join sys.all_tables t\n" + "         on col.owner = t.owner\n"
            + "        and col.table_name = t.table_name\n"
            + "      where col.owner not in ('ANONYMOUS', 'CTXSYS', 'DBSNMP', 'EXFSYS', 'LBACSYS', 'MDSYS', 'MGMT_VIEW', 'OLAPSYS', 'OWBSYS', 'ORDPLUGINS', 'ORDSYS', 'OUTLN', 'SI_INFORMTN_SCHEMA', 'SYS', 'SYSMAN', 'SYSTEM', 'TSMSYS', 'WK_TEST', 'WKSYS', 'WKPROXY', 'WMSYS', 'XDB', 'APEX_040000', 'APEX_PUBLIC_USER', 'DIP', 'FLOWS_30000', 'FLOWS_FILES', 'MDDATA', 'ORACLE_OCM', 'XS$NULL', 'SPATIAL_CSW_ADMIN_USR', 'SPATIAL_WFS_ADMIN_USR', 'PUBLIC')\n"
            + "     union\n" + "     select col.table_name,\n" + "            col.column_id,\n"
            + "            col.column_name,\n" + "            col.data_type,\n"
            + "            col.data_length max_length\n" + "       from sys.all_tab_columns col\n" + "      inner\n"
            + "       join sys.all_views v\n" + "         on col.owner = v.owner\n"
            + "        and col.table_name = v.view_name\n"
            + "      where col.owner not in ('ANONYMOUS', 'CTXSYS', 'DBSNMP', 'EXFSYS', 'LBACSYS', 'MDSYS', 'MGMT_VIEW', 'OLAPSYS', 'OWBSYS', 'ORDPLUGINS', 'ORDSYS', 'OUTLN', 'SI_INFORMTN_SCHEMA', 'SYS', 'SYSMAN', 'SYSTEM', 'TSMSYS', 'WK_TEST', 'WKSYS', 'WKPROXY', 'WMSYS', 'XDB', 'APEX_040000', 'APEX_PUBLIC_USER', 'DIP', 'FLOWS_30000', 'FLOWS_FILES', 'MDDATA', 'ORACLE_OCM', 'XS$NULL', 'SPATIAL_CSW_ADMIN_USR', 'SPATIAL_WFS_ADMIN_USR', 'PUBLIC')\n"
            + "      order by 1,\n" + "            2,\n" + "            3]\n" + "}\n" + "else if (dbtype = 'MSSQL')\n"
            + "{\n" + "    [select tab.name as table_name,\n" + "            col.column_id,\n"
            + "            col.name as column_name,\n" + "            t.name as data_type,\n"
            + "            col.max_length\n" + "       from sys.tables as tab\n" + "      inner\n"
            + "       join sys.columns as col\n" + "         on tab.object_id = col.object_id\n" + "       left\n"
            + "       join sys.types as t\n" + "         on col.user_type_id = t.user_type_id\n" + "     union\n"
            + "     select object_name(c.object_id) as table_name,\n" + "            c.column_id,\n"
            + "            c.name as column_name,\n" + "            type_name(user_type_id) as data_type,\n"
            + "            c.max_length\n" + "       from sys.columns c\n" + "       join sys.views v\n"
            + "         on v.object_id = c.object_id\n" + "      order by 1,\n" + "            2,\n"
            + "            3]\n" + "}";

    public HashMap<String, Table> tables;
    public HashMap<String, Table> views;
    public HashMap<String, ArrayList<TableColumn>> columns;

    public MocaSqlCache() {
        this.tables = new HashMap<>();
        this.views = new HashMap<>();
        this.columns = new HashMap<>();
    }

    public void loadTables() {

        this.tables.clear();

        try {
            MocaResults res = MocaConnection.getGlobalMocaConnection().executeCommand(MocaSqlCache.TABLES_SCRIPT);

            if (res != null) {
                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                    String tableName = res.getString(rowIdx, "table_name").toLowerCase();
                    String tableDescription = res.getString(rowIdx, "description");
                    String tableComment = res.getString(rowIdx, "table_comment");
                    if (!tableComment.isEmpty()) {
                        tableDescription += ": " + tableComment;
                    }
                    this.tables.put(tableName, new Table(tableName, tableDescription));
                }

            }
        } catch (Exception e) {
            // ignore
        }

    }

    public void loadViews() {

        this.views.clear();

        try {
            MocaResults res = MocaConnection.getGlobalMocaConnection().executeCommand(MocaSqlCache.VIEWS_SCRIPT);

            if (res != null) {

                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                    String viewName = res.getString(rowIdx, "view_name").toLowerCase();
                    this.views.put(viewName, new Table(viewName, ""));
                }
            }

            // Add 'dual' - lol.
            this.views.put("dual", new Table("dual", ""));
        } catch (Exception e) {
            // ignore
        }

    }

    public void loadColumns() {

        this.columns.clear();

        try {
            MocaResults colRes = MocaConnection.getGlobalMocaConnection().executeCommand(MocaSqlCache.COLUMNS_SCRIPT);

            // Due to how our loop works, we need to save off data here so that we do not
            // leave out the first column of every table(after the first table).
            TableColumn firstColumn = null;

            // For table columns and view columns, we can assume that the data is sorted by
            // table_name, column_id, column_name.
            if (colRes != null) {

                for (int rowIdx = 0; rowIdx < colRes.getRowCount(); rowIdx++) {
                    String tableName = colRes.getString(rowIdx, "table_name");
                    String curRowTableName = tableName; // Gets updated each row.
                    ArrayList<TableColumn> tableCols = new ArrayList<>();

                    // Check if we have a first column set from below.
                    if (firstColumn != null) {
                        // If so, add it to the new array then null it out for the next go round.
                        tableCols.add(firstColumn);
                        firstColumn = null;
                    }

                    while (tableName.compareToIgnoreCase(curRowTableName) == 0) {

                        tableCols.add(new TableColumn(tableName, colRes.getString(rowIdx, "column_name"),
                                colRes.getString(rowIdx, "data_type"), colRes.getInt(rowIdx, "max_length")));

                        if (rowIdx >= colRes.getRowCount()) {
                            break;
                        } else {
                            rowIdx++;
                        }

                        curRowTableName = colRes.getString(rowIdx, "table_name");
                        if (tableName.compareToIgnoreCase(curRowTableName) != 0) {
                            // New table. Need to save off some info so we dont lose the first column!
                            firstColumn = new TableColumn(tableName, colRes.getString(rowIdx, "column_name"),
                                    colRes.getString(rowIdx, "data_type"), colRes.getInt(rowIdx, "max_length"));
                        }
                    }

                    // Now add to map.
                    this.columns.put(tableName, tableCols);
                }
            }
        } catch (Exception e) {
            // ignore
        }

    }

    public ArrayList<TableColumn> getColumnsForTable(String tableName) {
        return this.columns.get(tableName);
    }

}