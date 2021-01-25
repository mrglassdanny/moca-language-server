package com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;

public class MocaSqlCache {

        private static final String TABLES_SCRIPT = "list user tables description\n" + "|\n" + "list table comment\n"
                        + " where table_name = @table_name catch(@?)\n" + "|\n" + "if (@? = 0)\n" + "{\n"
                        + "    publish data\n" + "     where table_name = @table_name\n"
                        + "       and description = nvl(@description, @table_name)\n"
                        + "       and table_comment = @table_comment\n" + "}\n" + "else\n" + "{\n"
                        + "    publish data\n" + "     where table_name = @table_name\n"
                        + "       and description = nvl(@description, @table_name)\n"
                        + "       and table_comment = ''\n" + "}";
        private static final String VIEWS_SCRIPT = "list user views";
        private static final String INDEXES_SCRIPT = "list user tables | list table indexes where table_name = @table_name catch(-1403)";
        private static final String COLUMNS_SCRIPT = "if (dbtype = 'ORACLE')\n" + "{\n"
                        + "    [select col.table_name,\n" + "            col.column_id,\n"
                        + "            col.column_name,\n" + "            col.data_type,\n"
                        + "            col.data_length max_length\n" + "       from sys.all_tab_columns col\n"
                        + "      inner\n" + "       join sys.all_tables t\n" + "         on col.owner = t.owner\n"
                        + "        and col.table_name = t.table_name\n"
                        + "      where col.owner not in ('ANONYMOUS', 'CTXSYS', 'DBSNMP', 'EXFSYS', 'LBACSYS', 'MDSYS', 'MGMT_VIEW', 'OLAPSYS', 'OWBSYS', 'ORDPLUGINS', 'ORDSYS', 'OUTLN', 'SI_INFORMTN_SCHEMA', 'SYS', 'SYSMAN', 'SYSTEM', 'TSMSYS', 'WK_TEST', 'WKSYS', 'WKPROXY', 'WMSYS', 'XDB', 'APEX_040000', 'APEX_PUBLIC_USER', 'DIP', 'FLOWS_30000', 'FLOWS_FILES', 'MDDATA', 'ORACLE_OCM', 'XS$NULL', 'SPATIAL_CSW_ADMIN_USR', 'SPATIAL_WFS_ADMIN_USR', 'PUBLIC')\n"
                        + "     union\n" + "     select col.table_name,\n" + "            col.column_id,\n"
                        + "            col.column_name,\n" + "            col.data_type,\n"
                        + "            col.data_length max_length\n" + "       from sys.all_tab_columns col\n"
                        + "      inner\n" + "       join sys.all_views v\n" + "         on col.owner = v.owner\n"
                        + "        and col.table_name = v.view_name\n"
                        + "      where col.owner not in ('ANONYMOUS', 'CTXSYS', 'DBSNMP', 'EXFSYS', 'LBACSYS', 'MDSYS', 'MGMT_VIEW', 'OLAPSYS', 'OWBSYS', 'ORDPLUGINS', 'ORDSYS', 'OUTLN', 'SI_INFORMTN_SCHEMA', 'SYS', 'SYSMAN', 'SYSTEM', 'TSMSYS', 'WK_TEST', 'WKSYS', 'WKPROXY', 'WMSYS', 'XDB', 'APEX_040000', 'APEX_PUBLIC_USER', 'DIP', 'FLOWS_30000', 'FLOWS_FILES', 'MDDATA', 'ORACLE_OCM', 'XS$NULL', 'SPATIAL_CSW_ADMIN_USR', 'SPATIAL_WFS_ADMIN_USR', 'PUBLIC')\n"
                        + "      order by 1,\n" + "            2,\n" + "            3]\n" + "}\n"
                        + "else if (dbtype = 'MSSQL')\n" + "{\n" + "    [select tab.name as table_name,\n"
                        + "            col.column_id,\n" + "            col.name as column_name,\n"
                        + "            t.name as data_type,\n" + "            col.max_length\n"
                        + "       from sys.tables as tab\n" + "      inner\n" + "       join sys.columns as col\n"
                        + "         on tab.object_id = col.object_id\n" + "       left\n"
                        + "       join sys.types as t\n" + "         on col.user_type_id = t.user_type_id\n"
                        + "     union\n" + "     select object_name(c.object_id) as table_name,\n"
                        + "            c.column_id,\n" + "            c.name as column_name,\n"
                        + "            type_name(user_type_id) as data_type,\n" + "            c.max_length\n"
                        + "       from sys.columns c\n" + "       join sys.views v\n"
                        + "         on v.object_id = c.object_id\n" + "      order by 1,\n" + "            2,\n"
                        + "            3]\n" + "}";

        public HashMap<String, Table> tables;
        public HashMap<String, Table> views;
        public HashMap<String, ArrayList<TableIndex>> indexes;
        public HashMap<String, ArrayList<TableColumn>> columns;
        public HashMap<String, MocaSqlFunction> functions;

        public MocaSqlCache() {
                this.tables = new HashMap<>();
                this.views = new HashMap<>();
                this.indexes = new HashMap<>();
                this.columns = new HashMap<>();
                this.functions = new HashMap<>();

                // Functions can be hardcoded.
                {
                        // SQL aggregation functions:
                        MocaSqlFunction maxFunc = new MocaSqlFunction("max", new String[] { "expression" },
                                        "Returns the maximum value in the expression.");
                        MocaSqlFunction minFunc = new MocaSqlFunction("min", new String[] { "expression" },
                                        "Returns the minimum value in the expression.");
                        MocaSqlFunction countFunc = new MocaSqlFunction("count", new String[] { "expression" },
                                        "This function returns the number of items found in a group.");
                        MocaSqlFunction sumFunc = new MocaSqlFunction("sum", new String[] { "expression" },
                                        "Returns the sum of all the values in the expression -- null values are ignored.");
                        MocaSqlFunction avgFunc = new MocaSqlFunction("avg", new String[] { "expression" },
                                        "This function returns the average of the values in a group -- it ignores null values.");

                        this.functions.put("max", maxFunc);
                        this.functions.put("min", minFunc);
                        this.functions.put("count", countFunc);
                        this.functions.put("sum", sumFunc);
                        this.functions.put("avg", avgFunc);

                        // MOCA functions:
                        MocaSqlFunction instrFunc = new MocaSqlFunction("instr",
                                        new String[] { "search", "lookfor", "n" },
                                        "Index of the first character in search that contains the string lookfor. The string search is searched beginning at character n (if n is omitted, the first character).");
                        MocaSqlFunction lenFunc = new MocaSqlFunction("len", new String[] { "expr" },
                                        "Length of expr as returned by strlen().");
                        MocaSqlFunction lengthFunc = new MocaSqlFunction("length", new String[] { "expr" },
                                        "Length of expr as returned by strlen().");
                        MocaSqlFunction lowerFunc = new MocaSqlFunction("lower", new String[] { "expr" },
                                        "expr as a MocaType.STRING converted to lowercase.");
                        MocaSqlFunction lpadFunc = new MocaSqlFunction("lpad",
                                        new String[] { "expr", "length", "padstr" },
                                        "expr as a MocaType.STRING left padded to the length as a MocaType.INTEGER using the padstr as a MocaType.STRING. If padstr is not passed, the default is a space. If length is smaller than the length of the expr, then it will truncate to that length.");
                        MocaSqlFunction rpadFunc = new MocaSqlFunction("rpad",
                                        new String[] { "expr", "length", "padstr" },
                                        "expr as a MocaType.STRING right padded to the length as a MocaType.INTEGER using the padstr as a MocaType.STRING. If padstr is not passed, the default is a space. If length is smaller than the length of the expr, then it will truncate to that length.");
                        MocaSqlFunction rtrimFunc = new MocaSqlFunction("rtrim", new String[] { "expr" },
                                        "expr as a MocaType.STRING with trailing whitespace removed.");
                        MocaSqlFunction substrFunc = new MocaSqlFunction("substr", new String[] { "expr", "m", "n" },
                                        "expr as a MocaType.STRING beginning at character m, n characters long (if n is omitted, to end of expr).");
                        MocaSqlFunction upperFunc = new MocaSqlFunction("upper", new String[] { "expr" },
                                        "expr as a MocaType.STRING converted to uppercase.");
                        MocaSqlFunction sysdateFunc = new MocaSqlFunction("sysdate", new String[] {},
                                        "Current date and time as a MocaType.DATETIME.");
                        MocaSqlFunction to_charFunc = new MocaSqlFunction("to_char", new String[] { "expr", "format" },
                                        "expr as a MocaType.STRING using format if provided.");
                        MocaSqlFunction to_dateFunc = new MocaSqlFunction("to_date", new String[] { "expr", "format" },
                                        "expr as a MocaType.DATETIME using format if provided.");
                        MocaSqlFunction to_numberFunc = new MocaSqlFunction("to_number", new String[] { "expr" },
                                        "expr as a MocaType.DOUBLE.");
                        MocaSqlFunction decodeFunc = new MocaSqlFunction("decode",
                                        new String[] { "expr", "search1", "return1", "search2", "return2",
                                                        MocaSqlFunction.VARIABLE_LENGTH_ARGUMENT, "default" },
                                        "If expr equals any search, it returns the corresponding return; if not, it returns default.");
                        MocaSqlFunction iifFunc = new MocaSqlFunction("iif",
                                        new String[] { "expr", "trueExpr", "falseExpr" },
                                        "If expr is true, it returns trueExpr; if not, it returns falseExpr.");
                        MocaSqlFunction nvlFunc = new MocaSqlFunction("nvl", new String[] { "expr1", "expr2" },
                                        "If expr1 is not null, it returns expr1; otherwise, it returns expr2.");

                        this.functions.put("instr", instrFunc);
                        this.functions.put("len", lenFunc);
                        this.functions.put("length", lengthFunc);
                        this.functions.put("lower", lowerFunc);
                        this.functions.put("lpad", lpadFunc);
                        this.functions.put("rpad", rpadFunc);
                        this.functions.put("rtrim", rtrimFunc);
                        this.functions.put("substr", substrFunc);
                        this.functions.put("upper", upperFunc);
                        this.functions.put("sysdate", sysdateFunc);
                        this.functions.put("to_char", to_charFunc);
                        this.functions.put("to_date", to_dateFunc);
                        this.functions.put("to_number", to_numberFunc);
                        this.functions.put("decode", decodeFunc);
                        this.functions.put("iif", iifFunc);
                        this.functions.put("nvl", nvlFunc);

                }
        }

        public void loadTables() {

                try {
                        MocaResults res = MocaServices.mocaConnection.executeCommand(MocaSqlCache.TABLES_SCRIPT);
                        this.tables.clear();

                        if (res != null) {
                                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                                        String tableName = res.getString(rowIdx, "table_name").toLowerCase();
                                        String tableDescription = res.getString(rowIdx, "description");
                                        String tableComment = res.getString(rowIdx, "table_comment");
                                        if (tableComment != null && !tableComment.isEmpty()) {
                                                tableDescription += ": " + tableComment;
                                        }
                                        this.tables.put(tableName, new Table(tableName, tableDescription));
                                }
                        }
                } catch (Exception e) {
                        MocaServices.logWarningToLanguageClient(
                                        String.format("MOCA Cache: Failed to load tables: %s", e.getMessage()));
                }

        }

        public void loadViews() {

                try {
                        MocaResults res = MocaServices.mocaConnection.executeCommand(MocaSqlCache.VIEWS_SCRIPT);
                        this.views.clear();

                        if (res != null) {

                                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                                        String viewName = res.getString(rowIdx, "view_name").toLowerCase();
                                        this.views.put(viewName, new Table(viewName, ""));
                                }
                        }

                        // Add 'dual' - lol.
                        this.views.put("dual", new Table("dual", ""));
                } catch (Exception e) {
                        MocaServices.logWarningToLanguageClient(
                                        String.format("MOCA Cache: Failed to load views: %s", e.getMessage()));
                }

        }

        public void loadIndexes() {

                try {
                        MocaResults res = MocaServices.mocaConnection.executeCommand(MocaSqlCache.INDEXES_SCRIPT);
                        this.indexes.clear();

                        if (res != null) {
                                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                                        String tableName = res.getString(rowIdx, "table_name").toLowerCase();
                                        String indexName = res.getString(rowIdx, "index_name");
                                        String indexKeys = res.getString(rowIdx, "index_keys");

                                        if (this.indexes.containsKey(tableName)) {
                                                this.indexes.get(tableName)
                                                                .add(new TableIndex(tableName, indexName, indexKeys));
                                        } else {
                                                ArrayList<TableIndex> indexesArrList = new ArrayList<>();
                                                indexesArrList.add(new TableIndex(tableName, indexName, indexKeys));
                                                this.indexes.put(tableName, indexesArrList);
                                        }
                                }
                        }
                } catch (Exception e) {
                        MocaServices.logWarningToLanguageClient(
                                        String.format("MOCA Cache: Failed to load indexes: %s", e.getMessage()));
                }
        }

        public void loadColumns() {

                try {
                        MocaResults colRes = MocaServices.mocaConnection.executeCommand(MocaSqlCache.COLUMNS_SCRIPT);
                        this.columns.clear();

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
                                                // If so, add it to the new array then null it out for the next go
                                                // round.
                                                tableCols.add(firstColumn);
                                                firstColumn = null;
                                        }

                                        while (tableName.compareToIgnoreCase(curRowTableName) == 0) {

                                                tableCols.add(new TableColumn(tableName,
                                                                colRes.getString(rowIdx, "column_name"),
                                                                colRes.getString(rowIdx, "data_type"),
                                                                colRes.getInt(rowIdx, "max_length")));

                                                if (rowIdx >= colRes.getRowCount() - 1) {
                                                        break;
                                                } else {
                                                        rowIdx++;
                                                }

                                                curRowTableName = colRes.getString(rowIdx, "table_name");
                                                if (tableName.compareToIgnoreCase(curRowTableName) != 0) {
                                                        // New table. Need to save off some info so we dont lose the
                                                        // first column!
                                                        firstColumn = new TableColumn(tableName,
                                                                        colRes.getString(rowIdx, "column_name"),
                                                                        colRes.getString(rowIdx, "data_type"),
                                                                        colRes.getInt(rowIdx, "max_length"));
                                                }
                                        }

                                        // Now add to map.
                                        // Make sure we convert to lowercase since table columns store table name as
                                        // lowercase.
                                        this.columns.put(tableName.toLowerCase(), tableCols);
                                }
                        }
                } catch (Exception e) {
                        MocaServices.logWarningToLanguageClient(
                                        String.format("MOCA Cache: Failed to load columns: %s", e.getMessage()));
                }

        }

        public ArrayList<TableIndex> getIndexesForTable(String tableName) {
                return this.indexes.get(tableName);
        }

        public ArrayList<TableColumn> getColumnsForTable(String tableName) {
                return this.columns.get(tableName);
        }

}