package com.github.mrglassdanny.mocalanguageserver.moca.cache.schema;

public class TableColumn {
    public String table_name;
    public String column_name;
    public String data_type;
    public int max_length;
    public String documentationStr;

    public TableColumn(String table_name, String column_name, String data_type, int max_length) {
        this.table_name = table_name.toLowerCase(); // We want all database entities lower case.
        this.column_name = column_name.toLowerCase(); // We want all database entities lower case.
        this.data_type = data_type;
        this.max_length = max_length;

        this.setDocumentationString();
    }

    private void setDocumentationString() {
        this.documentationStr = String.format("Data Type: %s\tMax Length: %d", this.data_type.toUpperCase(), this.max_length);
    }
}