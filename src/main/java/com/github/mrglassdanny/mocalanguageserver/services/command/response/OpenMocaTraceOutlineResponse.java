package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import java.util.ArrayList;

public class OpenMocaTraceOutlineResponse {

    public ArrayList<String> traceFileNames;
    public String traceOutlineStr;
    public Exception exception;

    public OpenMocaTraceOutlineResponse(ArrayList<String> traceFileNames, String traceOutlineStr, Exception exception) {
        this.traceFileNames = traceFileNames;
        this.traceOutlineStr = traceOutlineStr;
        this.exception = exception;
    }
}
