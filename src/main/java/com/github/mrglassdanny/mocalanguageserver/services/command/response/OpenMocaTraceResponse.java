package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import java.util.ArrayList;

public class OpenMocaTraceResponse {

    public ArrayList<String> traceFileNames;
    public String traceOutline;
    public Exception exception;

    public OpenMocaTraceResponse(ArrayList<String> traceFileNames, String traceOutline, Exception exception) {
        this.traceFileNames = traceFileNames;
        this.traceOutline = traceOutline;
        this.exception = exception;
    }
}
