package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutlineOptions;
import com.google.gson.JsonElement;

public class OpenMocaTraceOutlineRequest {

    public String requestedTraceFileName;
    public String createdTraceOutlineUriStr;
    public boolean isRemote;
    public MocaTraceOutlineOptions options;

    public OpenMocaTraceOutlineRequest(List<Object> args) throws Exception {
        if (args == null || args.isEmpty()) {
            this.requestedTraceFileName = null;
            this.createdTraceOutlineUriStr = null;
            this.isRemote = false;
            this.options = null;
        } else {
            JsonElement requestedTraceFileNameJsonElem = (JsonElement) args.get(0);
            this.requestedTraceFileName = requestedTraceFileNameJsonElem.getAsString();
            JsonElement createdTraceOutlineUriStrJsonElem = (JsonElement) args.get(1);
            this.createdTraceOutlineUriStr = createdTraceOutlineUriStrJsonElem.getAsString();
            JsonElement isRemoteJsonElem = (JsonElement) args.get(2);
            this.isRemote = isRemoteJsonElem.getAsBoolean();
            JsonElement useLogicalIndentStrategyJsonElem = (JsonElement) args.get(3);
            JsonElement minimumExecutionTimeJsonElem = (JsonElement) args.get(4);
            JsonElement viewRelativeLogJsonElem = (JsonElement) args.get(5);
            this.options = new MocaTraceOutlineOptions(useLogicalIndentStrategyJsonElem.getAsBoolean(),
                    minimumExecutionTimeJsonElem.getAsDouble(), viewRelativeLogJsonElem.getAsBoolean());
        }
    }
}
