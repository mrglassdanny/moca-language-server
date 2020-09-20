
package com.github.mrglassdanny.mocalanguageserver.moca.connection;

import com.github.mrglassdanny.mocalanguageserver.command.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.command.response.MocaResultsResponse;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.Cache;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.UnsupportedConnectionTypeException;

import java.io.IOException;

public class MocaConnectionWrapper {

    private MocaConnection mocaConnection;
    public String urlStr;
    public String userId;
    private String password;
    public Cache cache;

    public MocaConnectionWrapper() {
        this.mocaConnection = null;
        this.urlStr = null;
        this.userId = null;
        this.password = null;
        this.cache = new Cache();
    }

    public MocaConnectionWrapper(String url, String userId, String password) {

        this.mocaConnection = null;
        this.urlStr = url;
        this.userId = userId;
        this.password = password;

        this.cache = new Cache();
    }

    public MocaConnectionWrapper(String url, String userId, String password, Cache existingMocaCache) {

        this.mocaConnection = null;
        this.urlStr = url;
        this.userId = userId;
        this.password = password;

        this.cache = existingMocaCache;
    }

    public MocaConnectionResponse connect() {

        MocaConnectionResponse response = new MocaConnectionResponse();

        // Test to see if url is correct type -- we will only support http and https.
        String lowerCaseUrlStr = this.urlStr.toLowerCase();
        if (!lowerCaseUrlStr.startsWith("http") && !lowerCaseUrlStr.startsWith("https")) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = new UnsupportedConnectionTypeException(
                    "MOCA Language Server only supports 'http' and 'https' connections!");
            return response;
        }

        // Now attempt to connect.
        try {
            this.mocaConnection = new MocaConnection(this.urlStr);
            this.mocaConnection.login(this.userId, this.password);
            response.eOk = true;
            response.exception = null;
        } catch (IOException ioException) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = ioException;
        } catch (MocaException mocaException) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = mocaException;
        } catch (Exception exception) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = exception;
        }

        return response;
    }

    public MocaResultsResponse executeCommand(String command) {
        try {
            return new MocaResultsResponse(this.mocaConnection.executeCommand(command), null);
        } catch (Exception e) {
            return new MocaResultsResponse(null, e);
        }
    }

}