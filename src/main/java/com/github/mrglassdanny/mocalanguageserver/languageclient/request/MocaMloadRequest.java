package com.github.mrglassdanny.mocalanguageserver.languageclient.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaMloadRequest {

    public String csvFilePath;
    public String ctlFilePath;

    public MocaMloadRequest(List<Object> args) throws Exception {
        JsonElement csvJsonElem = (JsonElement) args.get(0);
        this.csvFilePath = csvJsonElem.getAsString();

        JsonElement ctlJsonElem = (JsonElement) args.get(1);
        this.ctlFilePath = ctlJsonElem.getAsString();
    }
}