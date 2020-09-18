package com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql;

public class Table {
    public String table_name;
    public String description;

    public Table(String table_name, String description) {
        this.table_name = table_name.toLowerCase(); // We want all database entities lower case.
        this.description = description;
    }

    public String getMarkdown() {
        return String.format("table **%s**\n\n%s", this.table_name,
                (this.description == null || this.description.isEmpty() ? ""
                        : String.format("*%s*", this.description)));
    }

}