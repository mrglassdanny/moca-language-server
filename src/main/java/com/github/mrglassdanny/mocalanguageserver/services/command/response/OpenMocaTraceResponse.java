package com.github.mrglassdanny.mocalanguageserver.services.command.response;

import java.util.ArrayList;

public class OpenMocaTraceResponse {

    public ArrayList<String> traceFileNames;
    public String traceOutlineHtml;
    public Exception exception;

    public OpenMocaTraceResponse(ArrayList<String> traceFileNames, String traceOutlineHtml, Exception exception) {
        this.traceFileNames = traceFileNames;
        this.traceOutlineHtml = traceOutlineHtml;
        this.exception = exception;
    }
}
