package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class OpenMocaTraceRequest {

    public String requestedTraceFileName;

    public OpenMocaTraceRequest(List<Object> args) throws Exception {
        if (args == null || args.isEmpty()) {
            this.requestedTraceFileName = null;
        } else {
            JsonElement jsonElem = (JsonElement) args.get(0);
            this.requestedTraceFileName = jsonElem.getAsString();
        }
    }
}
