package com.github.mrglassdanny.mocalanguageserver.languageclient.request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class MocaConnectionRequest {

    public String url;
    public String userId;
    public String password;
    public ArrayList<String> classpathList;

    public boolean useExistingRepository;

    public MocaConnectionRequest(List<Object> args) throws Exception {
        JsonArray jsonArr = (JsonArray) args.get(0);
        this.url = jsonArr.get(1).getAsString();
        this.userId = jsonArr.get(2).getAsString();
        this.password = jsonArr.get(3).getAsString();

        this.classpathList = new ArrayList<>();
        JsonArray classpathJsonArr = jsonArr.get(4).getAsJsonArray();
        for (JsonElement jsonElem : classpathJsonArr) {
            this.classpathList.add(jsonElem.getAsString());
        }

        this.useExistingRepository = ((JsonElement) args.get(1)).getAsBoolean();
    }

}