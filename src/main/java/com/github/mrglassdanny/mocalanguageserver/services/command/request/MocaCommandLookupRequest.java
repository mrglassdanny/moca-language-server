package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaCommandLookupRequest {

    public String requestedMocaCommand;

    public MocaCommandLookupRequest(List<Object> args) throws Exception {

        if (args == null || args.isEmpty()) {
            this.requestedMocaCommand = null;
        } else {
            JsonElement jsonElem = (JsonElement) args.get(0);
            this.requestedMocaCommand = jsonElem.getAsString();
        }
    }

}