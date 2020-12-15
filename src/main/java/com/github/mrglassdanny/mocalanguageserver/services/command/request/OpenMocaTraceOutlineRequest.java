package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.google.gson.JsonElement;

public class OpenMocaTraceOutlineRequest {

    public String requestedTraceFileName;
    public String createdTraceOutlineUriStr;
    public boolean isRemote;
    public boolean useLogicalIndentStrategy;
    public double minimumExecutionTime;

    public OpenMocaTraceOutlineRequest(List<Object> args) throws Exception {
        if (args == null || args.isEmpty()) {
            this.requestedTraceFileName = null;
            this.createdTraceOutlineUriStr = null;
            this.isRemote = false;
            this.useLogicalIndentStrategy = false;
            this.minimumExecutionTime = 0.0;
        } else {
            JsonElement requestedTraceFileNameJsonElem = (JsonElement) args.get(0);
            this.requestedTraceFileName = requestedTraceFileNameJsonElem.getAsString();
            JsonElement createdTraceOutlineUriStrJsonElem = (JsonElement) args.get(1);
            this.createdTraceOutlineUriStr = createdTraceOutlineUriStrJsonElem.getAsString();
            JsonElement isRemoteJsonElem = (JsonElement) args.get(2);
            this.isRemote = isRemoteJsonElem.getAsBoolean();
            JsonElement useLogicalIndentStrategyJsonElem = (JsonElement) args.get(3);
            this.useLogicalIndentStrategy = useLogicalIndentStrategyJsonElem.getAsBoolean();
            JsonElement minimumExecutionTimeJsonElem = (JsonElement) args.get(4);
            this.minimumExecutionTime = minimumExecutionTimeJsonElem.getAsDouble();
        }
    }
}
