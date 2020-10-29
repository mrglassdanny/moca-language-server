package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaResultsResponse {

    public MocaResults results;
    public Exception exception;
    public boolean needsApprovalToExecute;

    public MocaResultsResponse() {
        this.results = null;
        this.exception = null;
        this.needsApprovalToExecute = false;
    }

    public MocaResultsResponse(MocaResults results, Exception exception, boolean needsApprovalToExecute) {
        this.results = results;
        this.exception = exception;
        this.needsApprovalToExecute = needsApprovalToExecute;
    }
}