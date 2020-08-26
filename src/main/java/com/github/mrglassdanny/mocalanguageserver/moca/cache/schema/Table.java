package com.github.mrglassdanny.mocalanguageserver.moca.cache.schema;

public class Table {
    public String table_name;
    public String description;

    public Table(String table_name, String description) {
        this.table_name = table_name.toLowerCase(); // We want all database entities lower case.
        this.description = description;
    }

}