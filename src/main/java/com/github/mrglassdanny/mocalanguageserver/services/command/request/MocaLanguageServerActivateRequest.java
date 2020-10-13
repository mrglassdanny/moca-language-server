package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MocaLanguageServerActivateRequest {

    public String globalStoragePath;
    public MocaLanguageServerOptionsRequest mocaLanguageServerOptionsRequest;
    public ArrayList<String> defaultGroovyClasspathList;

    public MocaLanguageServerActivateRequest(List<Object> args) throws Exception {
        this.globalStoragePath = ((JsonElement) args.get(0)).getAsString();

        JsonObject mocaLanguageServerOptsJsonObj = (JsonObject) args.get(1);
        this.mocaLanguageServerOptionsRequest = new MocaLanguageServerOptionsRequest(mocaLanguageServerOptsJsonObj);

        this.defaultGroovyClasspathList = new ArrayList<>();
        JsonArray defaultClasspathJsonArr = ((JsonArray) args.get(2)).getAsJsonArray();
        for (JsonElement jsonElem : defaultClasspathJsonArr) {
            this.defaultGroovyClasspathList.add(jsonElem.getAsString());
        }
    }

}