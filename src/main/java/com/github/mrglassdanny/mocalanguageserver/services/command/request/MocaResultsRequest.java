package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaResultsRequest {

    public String script;
    public String fileName;
    public boolean isApprovedForExecution;

    public MocaResultsRequest(List<Object> args) throws Exception {
        JsonElement scriptJsonElem = (JsonElement) args.get(0);
        JsonElement fileNameJsonElem = (JsonElement) args.get(1);
        JsonElement isApprovedForExecutionJsonElem = (JsonElement) args.get(2);
        this.script = scriptJsonElem.getAsString();
        this.fileName = fileNameJsonElem.getAsString();
        this.isApprovedForExecution = isApprovedForExecutionJsonElem.getAsBoolean();
    }

}