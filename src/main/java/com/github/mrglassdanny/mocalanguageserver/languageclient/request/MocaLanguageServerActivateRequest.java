package com.github.mrglassdanny.mocalanguageserver.languageclient.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaLanguageServerActivateRequest {

    public String globalStoragePath;

    public MocaLanguageServerActivateRequest(List<Object> args) throws Exception {
        this.globalStoragePath = ((JsonElement) args.get(0)).getAsString();
    }

}