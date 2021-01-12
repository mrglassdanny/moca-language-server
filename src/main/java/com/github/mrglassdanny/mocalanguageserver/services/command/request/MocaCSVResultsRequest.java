package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaCSVResultsRequest {

    public String script;
    public String fileName;
    public String fullFileName;
    public boolean isApprovedForExecution;

    public MocaCSVResultsRequest(List<Object> args) throws Exception {
        JsonElement scriptJsonElem = (JsonElement) args.get(0);
        JsonElement fileNameJsonElem = (JsonElement) args.get(1);
        JsonElement fullFileNameJsonElem = (JsonElement) args.get(2);
        JsonElement isApprovedForExecutionJsonElem = (JsonElement) args.get(3);
        this.script = scriptJsonElem.getAsString();
        this.fileName = fileNameJsonElem.getAsString();
        this.fullFileName = fullFileNameJsonElem.getAsString();
        this.isApprovedForExecution = isApprovedForExecutionJsonElem.getAsBoolean();
    }

}