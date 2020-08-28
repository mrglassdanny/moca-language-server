package com.github.mrglassdanny.mocalanguageserver.appdata.db;

import java.util.HashMap;

public class DatabaseMetadata {

    protected static final String DATABASE_NAME = "moca_language_server.db";

    public static final String TABLE_NAME_EXECUTION_HISTORY = "execution_history";

    protected static HashMap<String, String> createTableQueries = new HashMap<>();
    static {
        createTableQueries.put(TABLE_NAME_EXECUTION_HISTORY, "create table " + TABLE_NAME_EXECUTION_HISTORY
                + "(status INTEGER, message TEXT, rows INTEGER, elapsed NUMERIC, text TEXT, start_time DATETIME, result TEXT, moca_url TEXT)");
    }

}