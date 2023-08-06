package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaResultsResponse {

    public MocaResults results;
    public Exception exception;
    public boolean needsApprovalToExecute;
    public boolean superUser;

    public MocaResultsResponse() {
        this.results = null;
        this.exception = null;
        this.needsApprovalToExecute = false;
        this.superUser = false;
    }

    public MocaResultsResponse(MocaResults results, Exception exception, boolean needsApprovalToExecute,
            boolean superUser) {
        this.results = results;
        this.exception = exception;
        this.needsApprovalToExecute = needsApprovalToExecute;
        this.superUser = superUser;
    }
}