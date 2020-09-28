package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaResultsResponse {

    public MocaResults results;
    public Exception exception;

    public MocaResultsResponse() {
        this.results = null;
        this.exception = null;
    }

    public MocaResultsResponse(MocaResults results, Exception exception) {
        this.results = results;
        this.exception = exception;
    }
}