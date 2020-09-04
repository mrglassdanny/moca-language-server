
package com.github.mrglassdanny.mocalanguageserver.moca.connection;

import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaResultsResponse;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.Cache;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.UnsupportedConnectionTypeException;

import java.io.IOException;

public class MocaConnectionWrapper {

    private MocaConnection mocaConnection;
    public String url;
    public String userId;
    private String password;
    public Cache cache;

    public MocaConnectionWrapper() {
        this.mocaConnection = null;
        this.url = null;
        this.userId = null;
        this.password = null;
        this.cache = new Cache();
    }

    public MocaConnectionWrapper(String url, String userId, String password) {

        this.mocaConnection = null;
        this.url = url;
        this.userId = userId;
        this.password = password;

        this.cache = new Cache();
    }

    public MocaConnectionWrapper(String url, String userId, String password, Cache existingMocaCache) {

        this.mocaConnection = null;
        this.url = url;
        this.userId = userId;
        this.password = password;

        this.cache = existingMocaCache;
    }

    public MocaConnectionResponse connect() {

        MocaConnectionResponse response = new MocaConnectionResponse();

        // Test to see if url is correct type -- we will only support http and https.
        if (!this.url.startsWith("http") && !this.url.startsWith("https")) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = new UnsupportedConnectionTypeException("URL must be either HTTP or HTTPS!");
            return response;
        }

        // Now attempt to connect.
        try {
            this.mocaConnection = new MocaConnection(this.url);
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