
package com.github.mrglassdanny.mocalanguageserver.moca.connection;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.repository.MocaRepository;
import com.github.mrglassdanny.mocalanguageserver.client.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.client.response.MocaResultsResponse;
import com.redprairie.moca.MocaException;
import com.redprairie.moca.client.ConnectionFailedException;
import com.redprairie.moca.client.ConnectionUtils;
import com.redprairie.moca.client.LoginFailedException;
import com.redprairie.moca.client.LogoutFailedException;
import com.redprairie.moca.client.MocaConnection;

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

        try {
            this.mocaConnection = ConnectionUtils.createConnection(this.url, null);
            ConnectionUtils.login(this.mocaConnection, this.userId, this.password);
            response.eOk = true;
            response.exception = null;
        } catch (LoginFailedException loginException) {
            this.mocaConnection.close();
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = loginException;
        } catch (ConnectionFailedException connectionFailException) {
            this.mocaConnection = null;
            response.eOk = false;
            response.exception = connectionFailException;
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

    public MocaConnectionResponse disconnect() {

        MocaConnectionResponse response = new MocaConnectionResponse();

        try {
            ConnectionUtils.logout(this.mocaConnection);
            this.mocaConnection.close();
            response.eOk = true;
            response.exception = null;
        } catch (LogoutFailedException logoutException) {
            this.mocaConnection.close();
            response.eOk = false;
            response.exception = logoutException;
        } finally {
            this.mocaConnection = null;
        }

        return response;
    }

    public MocaResultsResponse executeCommand(String script) {
        try {
            return new MocaResultsResponse(this.mocaConnection.executeCommand(script), null);
        } catch (MocaException e) {
            return new MocaResultsResponse(null, e);
        }
    }

    public void loadRepository() {
        this.repository.loadAsync(this);
    }

}