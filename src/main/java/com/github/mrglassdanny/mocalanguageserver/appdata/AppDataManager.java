package com.github.mrglassdanny.mocalanguageserver.appdata;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.github.mrglassdanny.mocalanguageserver.appdata.db.DatabaseMetadata;
import com.github.mrglassdanny.mocalanguageserver.appdata.db.SqliteConnection;
import com.redprairie.moca.MocaResults;
import com.redprairie.moca.MocaType;
import com.redprairie.moca.SimpleResults;

public class AppDataManager {

    public static void runMaintenance() {
        try {
            purgeExecutionHistory();
        } catch (Exception ex) {

        }
    }

    public static void createExecutionHistory(int status, String message, int rows, double elapsed, String text,
            MocaResults result, String mocaUrl) throws Exception {
        new SqliteConnection().openExecuteClose(DatabaseMetadata.TABLE_NAME_EXECUTION_HISTORY,
                "insert into " + DatabaseMetadata.TABLE_NAME_EXECUTION_HISTORY + " values(" + status + ",'" + message
                        + "'," + rows + "," + elapsed + ",\"" + text + "\",datetime('now', 'localtime'),'','" + mocaUrl
                        + "')");
    }

    public static void purgeExecutionHistory() throws Exception {
        new SqliteConnection().openExecuteClose(DatabaseMetadata.TABLE_NAME_EXECUTION_HISTORY,
                "delete from " + DatabaseMetadata.TABLE_NAME_EXECUTION_HISTORY
                        + " where start_time < datetime('now', 'localtime', '-14 days')");
    }

    public static MocaResults getExecutionHistory() {

        SimpleResults mocaRes = null;

        SqliteConnection conn = new SqliteConnection();
        try {

            mocaRes = (SimpleResults) conn.openGetResultsAsMocaResultsClose(
                    "select * from " + DatabaseMetadata.TABLE_NAME_EXECUTION_HISTORY + " order by start_time desc");

        } catch (Exception ex) {
            // Do nothing - finally block takes care of everything.
        }
        return mocaRes;
    }
}