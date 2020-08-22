package com.github.mrglassdanny.mocalanguageserver.client.response;

public class MocaExecutionHistoryResponse {

    // Using a moca results response due to fact that the client side data grid
    // control is already spec'd to handle moca results.
    public MocaResultsResponse mocaResultsResponse;

    public MocaExecutionHistoryResponse(MocaResultsResponse mocaResultsResponse) {
        this.mocaResultsResponse = mocaResultsResponse;
    }
}