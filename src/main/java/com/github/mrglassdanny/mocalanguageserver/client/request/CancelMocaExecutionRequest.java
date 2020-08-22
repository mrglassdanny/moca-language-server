package com.github.mrglassdanny.mocalanguageserver.client.request;

import java.util.List;

import com.google.gson.JsonElement;

public class CancelMocaExecutionRequest {

    public String script;

    public CancelMocaExecutionRequest(List<Object> args) throws Exception {
        JsonElement scriptJsonElem = (JsonElement) args.get(0);
        this.script = scriptJsonElem.getAsString();
    }
}