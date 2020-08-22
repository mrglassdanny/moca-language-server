package com.github.mrglassdanny.mocalanguageserver.client.response;

public class MocaConnectionResponse {

    public boolean eOk;
    public Exception exception;

    public MocaConnectionResponse() {

    }

    public MocaConnectionResponse(boolean eOk, Exception exception) {
        this.eOk = eOk;
        this.exception = exception;
    }
}