package com.github.mrglassdanny.mocalanguageserver.languageclient.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaTraceRequest {

    public boolean startTrace;
    public String fileName;
    public String mode;

    public MocaTraceRequest(List<Object> args) throws Exception {
        JsonElement startTraceJsonElem = (JsonElement) args.get(0);
        this.startTrace = startTraceJsonElem.getAsBoolean();
        JsonElement fileNameJsonElem = (JsonElement) args.get(1);
        this.fileName = fileNameJsonElem.getAsString();
        JsonElement modeJsonElem = (JsonElement) args.get(2);
        this.mode = modeJsonElem.getAsString();
    }

}