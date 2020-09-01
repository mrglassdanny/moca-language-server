package com.github.mrglassdanny.mocalanguageserver.languageclient.request;

import java.util.List;

import com.google.gson.JsonElement;

public class TrainFormattersRequest {

    public String mocaDirName;
    public String mocaSqlDirName;

    public TrainFormattersRequest(List<Object> args) throws Exception {
        this.mocaDirName = ((JsonElement) args.get(0)).getAsString();
        this.mocaSqlDirName = ((JsonElement) args.get(1)).getAsString();
    }
}
