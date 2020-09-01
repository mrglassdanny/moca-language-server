package com.github.mrglassdanny.mocalanguageserver.languageclient.request;

import java.util.List;

import com.google.gson.JsonElement;

public class MocaLanguageServerActivateRequest {

    public String globalStoragePath;

    // Including formatting training data so we can train model on activation.
    public String formatTrainingMocaDirName;
    public String formatTrainingMocaSqlDirName;

    public MocaLanguageServerActivateRequest(List<Object> args) throws Exception {
        this.globalStoragePath = ((JsonElement) args.get(0)).getAsString();
        this.formatTrainingMocaDirName = ((JsonElement) args.get(1)).getAsString();
        this.formatTrainingMocaSqlDirName = ((JsonElement) args.get(2)).getAsString();
    }

}