package com.github.mrglassdanny.mocalanguageserver.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaResultsRequest {

    public String script;
    public String fileName;

    public MocaResultsRequest(List<Object> args) throws Exception {
        JsonElement scriptJsonElem = (JsonElement) args.get(0);
        JsonElement fileNameJsonElem = (JsonElement) args.get(1);
        this.script = scriptJsonElem.getAsString();
        this.fileName = fileNameJsonElem.getAsString();
    }

}