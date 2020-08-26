package com.github.mrglassdanny.mocalanguageserver.languageclient.response;

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