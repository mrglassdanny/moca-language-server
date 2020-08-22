
package com.github.mrglassdanny.mocalanguageserver.moca.connection;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.LoginFailException;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.UnsupportedConnectionTypeException;
import com.github.mrglassdanny.mocalanguageserver.moca.repository.MocaRepository;

import java.io.IOException;

import com.github.mrglassdanny.mocalanguageserver.client.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.client.response.MocaResultsResponse;

public class MocaConnectionWrapper {

    private MocaConnection mocaConnection;
    public String url;
    public String userId;
    private String password;
    public MocaRepository repository;

    public MocaConnectionWrapper(String url, String userId, String password) {

        this.mocaConnection = null;
        this.url = url;
        this.userId = userId;
        this.password = password;

        this.repository = new MocaRepository();
    }

    public MocaConnectionWrapper(String url, String userId, String password, MocaRepository existingMocaRepo) {

        this.mocaConnection = null;
        this.url = url;
        this.userId = userId;
        this.password = password;

        this.repository = existingMocaRepo;
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
        } catch (LoginFailException loginFailException) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = loginFailException;
        } catch (IOException ioException) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = ioException;
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

    public void loadRepository() {
        this.repository.loadAsync(this);
    }

}