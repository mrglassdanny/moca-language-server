package com.github.mrglassdanny.mocalanguageserver.moca.cache.moca;

public class MocaCommand {

    public static final String TYPE_LOCAL_SYNTAX = "Local Syntax";

    public String cmplvl;
    public int cmplvlseq;
    public String command;
    public String type;
    public String syntax;
    public String desc;

    public MocaCommand(String command) {
        this.command = command;
    }

    public MocaCommand(String cmplvl, int cmplvlseq, String command, String type, String syntax, String desc) {
        this.cmplvl = cmplvl;
        this.cmplvlseq = cmplvlseq;
        this.command = command.toLowerCase(); // We want all moca entities lower case.
        this.type = type;
        this.syntax = syntax;
        this.desc = desc;
    }

    // Cannot generate moca command markdown here due to list of commands
    // requirement.
}