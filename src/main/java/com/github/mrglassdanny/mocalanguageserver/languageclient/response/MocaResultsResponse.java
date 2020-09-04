package com.github.mrglassdanny.mocalanguageserver.languageclient.response;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaResultsResponse {

    public MocaResults results;
    public Exception exception;

    public MocaResultsResponse(MocaResults results, Exception exception) {
        this.results = results;
        this.exception = exception;
    }
}