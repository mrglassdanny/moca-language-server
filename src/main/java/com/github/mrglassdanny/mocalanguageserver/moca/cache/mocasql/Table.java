package com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql;

public class Table {
    public String table_name;
    public String description;

    public Table(String table_name, String description) {
        this.table_name = table_name.toLowerCase(); // We want all database entities lower case.
        this.description = description;
    }

    public String getMarkdownStr(boolean isView) {
        if (isView) {
            return String.format("view **%s**\n\n%s", this.table_name,
                    (this.description == null || this.description.isEmpty() ? ""
                            : String.format("%s", this.description)));
        } else {
            return String.format("table **%s**\n\n%s", this.table_name,
                    (this.description == null || this.description.isEmpty() ? ""
                            : String.format("%s", this.description)));
        }
    }

    public static String getMarkdownStrForAlias(String aliasedTableName) {
        return String.format("alias for **%s**", aliasedTableName);
    }

    public static String getMarkdownStrForSubquery(String subqueryName) {
        return String.format("subquery **%s**", subqueryName);
    }

    public static String getMarkdownStrForCTE(String cteName) {
        return String.format("CTE **%s**", cteName);
    }

}