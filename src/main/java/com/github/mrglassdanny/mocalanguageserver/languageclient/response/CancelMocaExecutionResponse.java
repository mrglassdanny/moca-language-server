package com.github.mrglassdanny.mocalanguageserver.languageclient.response;

public class CancelMocaExecutionResponse {

    public boolean cancelledSuccessfully;

    public CancelMocaExecutionResponse(boolean cancelledSuccessfully) {
        this.cancelledSuccessfully = cancelledSuccessfully;
    }

}