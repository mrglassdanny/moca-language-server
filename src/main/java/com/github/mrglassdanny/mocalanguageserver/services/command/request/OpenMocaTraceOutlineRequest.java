package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class OpenMocaTraceOutlineRequest {

    public String requestedTraceFileName;
    public boolean isRemote;

    public OpenMocaTraceOutlineRequest(List<Object> args) throws Exception {
        if (args == null || args.isEmpty()) {
            this.requestedTraceFileName = null;
            this.isRemote = false;
        } else {
            JsonElement requestedTraceFileNameJsonElem = (JsonElement) args.get(0);
            this.requestedTraceFileName = requestedTraceFileNameJsonElem.getAsString();
            JsonElement isRemoteJsonElem = (JsonElement) args.get(1);
            this.isRemote = isRemoteJsonElem.getAsBoolean();
        }
    }
}
