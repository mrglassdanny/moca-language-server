package com.github.mrglassdanny.mocalanguageserver.services.command.response;

public class MocaCSVResultsResponse {

    public Exception exception;
    public boolean needsApprovalToExecute;

    public MocaCSVResultsResponse() {
        this.exception = null;
        this.needsApprovalToExecute = false;
    }

    public MocaCSVResultsResponse(Exception exception, boolean needsApprovalToExecute) {
        this.exception = exception;
        this.needsApprovalToExecute = needsApprovalToExecute;
    }
}