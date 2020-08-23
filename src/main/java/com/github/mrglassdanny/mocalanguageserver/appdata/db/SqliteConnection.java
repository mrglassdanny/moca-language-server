package com.github.mrglassdanny.mocalanguageserver.appdata.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.MocaResults;

public class SqliteConnection {

    private Connection connection;

    public SqliteConnection() {
        this.connection = null;
    }

    private void open() throws SQLException {
        String url = "jdbc:sqlite:" + MocaLanguageServer.globalStoragePath + "\\" + DatabaseMetadata.DATABASE_NAME;
        this.connection = DriverManager.getConnection(url);
    }

    public void close() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
            this.connection = null;
        }
    }

    // Returns whether or not table now exists.
    private boolean checkTableExists(String tableName) {
        // Can assume connection is open.
        try {
            // Query table.
            Statement stmt = this.connection.createStatement();
            stmt.execute("select 1 from " + tableName + " limit 1");
            stmt.close();
            return true;
        } catch (SQLException ex) {
            // This means that the table does not exist, so we need to create it.
            try {
                Statement stmt = this.connection.createStatement();
                stmt.execute(DatabaseMetadata.createTableQueries.get(tableName));
                stmt.close();
                return true;
            } catch (Exception innerEx) {
                // Not good if this happens...
                return false;
            }
        }
    }

    public void openExecuteClose(String tableName, String query) throws SQLException {

        try {
            // Make database connection(will create db if not exists).
            this.open();

            // Make sure table exists.
            // If not, create it.
            if (this.checkTableExists(tableName)) {
                Statement stmt = this.connection.createStatement();
                stmt.execute(query);
                stmt.close();
            }
        } catch (SQLException ex) {
            // Do nothing here.
        } finally {
            this.close();
        }

    }

    public MocaResults openGetResultsAsMocaResultsClose(String query) throws SQLException {

        MocaResults mocaRes = null;

        // TODO: Fix this at some point!

        // try {

        // this.open();
        // Statement stmt = this.connection.createStatement();
        // ResultSet res = stmt.executeQuery(query);

        // ResultSetMetaData resMetadata = res.getMetaData();

        // // Now build moca results.
        // mocaRes = new MocaResults();

        // int colCount = resMetadata.getColumnCount();

        // for (int i = 0; i < colCount; i++) {
        // mocaRes.addColumn(resMetadata.getColumnName(i + 1), MocaType.STRING);
        // }

        // while (res.next()) {
        // mocaRes.addRow();
        // for (int i = 0; i < colCount; i++) {
        // mocaRes.setStringValue(i, new String(res.getBytes(i + 1)));
        // }
        // }

        // res.close();
        // stmt.close();

        // } catch (Exception ex) {

        // } finally {
        // this.close();
        // }

        return mocaRes;
    }

}