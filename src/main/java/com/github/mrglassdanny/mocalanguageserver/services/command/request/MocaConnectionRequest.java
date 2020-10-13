package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MocaConnectionRequest {

    public String url;
    public String userId;
    public String password;
    public ArrayList<String> groovyClasspathList;

    public MocaConnectionRequest(List<Object> args) throws Exception {

        JsonObject connJsonObj = (JsonObject) args.get(0);
        this.url = connJsonObj.get("url").getAsString();
        this.userId = connJsonObj.get("user").getAsString();
        this.password = connJsonObj.get("password").getAsString();

        this.groovyClasspathList = new ArrayList<>();
        JsonArray classpathJsonArr = connJsonObj.get("groovyclasspath").getAsJsonArray();
        for (JsonElement jsonElem : classpathJsonArr) {
            this.groovyClasspathList.add(jsonElem.getAsString());
        }

    }

}