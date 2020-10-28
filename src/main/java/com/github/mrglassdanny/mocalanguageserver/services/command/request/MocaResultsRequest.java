package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaResultsRequest {

    public String script;
    public String fileName;
    public boolean isApprovedForRun;

    public MocaResultsRequest(List<Object> args) throws Exception {
        JsonElement scriptJsonElem = (JsonElement) args.get(0);
        JsonElement fileNameJsonElem = (JsonElement) args.get(1);
        JsonElement isApprovedForRunJsonElem = (JsonElement) args.get(2);
        this.script = scriptJsonElem.getAsString();
        this.fileName = fileNameJsonElem.getAsString();
        this.isApprovedForRun = isApprovedForRunJsonElem.getAsBoolean();
    }

}