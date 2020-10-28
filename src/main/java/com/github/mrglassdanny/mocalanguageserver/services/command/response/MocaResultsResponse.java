package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaResultsResponse {

    public MocaResults results;
    public Exception exception;
    public boolean isProductionEnvionmentAndScriptIsUnsafe;

    public MocaResultsResponse() {
        this.results = null;
        this.exception = null;
        this.isProductionEnvionmentAndScriptIsUnsafe = false;
    }

    public MocaResultsResponse(MocaResults results, Exception exception,
            boolean isProductionEnvionmentAndScriptIsUnsafe) {
        this.results = results;
        this.exception = exception;
        this.isProductionEnvionmentAndScriptIsUnsafe = isProductionEnvionmentAndScriptIsUnsafe;
    }
}