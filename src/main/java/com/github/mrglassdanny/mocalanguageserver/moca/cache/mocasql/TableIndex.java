package com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql;

public class TableIndex {
    public String table_name;
    public String index_name;
    public String[] columnNames;

    public TableIndex(String table_name, String index_name, String index_keys) {
        // We want all database entities lower case.
        this.table_name = table_name.toLowerCase();
        this.index_name = index_name.toLowerCase();
        // index_keys string is comma delimited list of index keys.
        this.columnNames = index_keys.toLowerCase().split(",");
        for (int i = 0; i < this.columnNames.length; i++) {
            this.columnNames[i] = this.columnNames[i].trim();
        }
    }

}