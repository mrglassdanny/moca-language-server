package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import java.util.ArrayList;

public class OpenMocaTraceResponse {

    public ArrayList<String> traceFileNames;
    public String traceFileContents;
    public Exception exception;

    public OpenMocaTraceResponse(ArrayList<String> traceFileNames, String traceFileContents, Exception exception) {
        this.traceFileNames = traceFileNames;
        this.traceFileContents = traceFileContents;
        this.exception = exception;
    }
}
