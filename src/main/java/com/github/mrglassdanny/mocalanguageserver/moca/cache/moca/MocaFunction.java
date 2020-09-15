package com.github.mrglassdanny.mocalanguageserver.moca.cache.moca;

public class MocaFunction {

    public static final String VARIABLE_LENGTH_ARGUMENT = "__variable_length_argument";

    public String name;
    public String[] argumentNames;
    public String description;

    public MocaFunction(String name, String[] argumentNames, String description) {
        this.name = name;
        this.argumentNames = argumentNames;
        this.description = description;
    }
}
