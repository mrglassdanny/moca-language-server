package com.github.mrglassdanny.mocalanguageserver.moca.cache;

import java.util.ArrayList;

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

    public static String getMarkdownStr(String commandName, ArrayList<MocaCommand> mcmds) {
        String headerStr = String.format("command **%s**", commandName);
        String descriptionStr = "";
        if (mcmds.get(0).desc != null) {
            descriptionStr = String.format("%s", mcmds.get(0).desc);
        }

        String levelsStr = "";
        for (MocaCommand mcmd : mcmds) {
            levelsStr += String.format("* %s - %s\n", mcmd.cmplvl, mcmd.type);
        }

        // Add required args to documentation if there are any.
        String requiredArgumentsStr = "";
        ArrayList<MocaCommandArgument> args = MocaCache.getGlobalMocaCache().commandArguments.get(mcmds.get(0).command);
        if (args != null) {
            for (MocaCommandArgument arg : args) {
                if (arg.argreq) {
                    // Have to make sure we are not adding an argnam that has already been added!
                    if (!requiredArgumentsStr.contains(arg.argtyp + " " + arg.argnam)) {
                        requiredArgumentsStr += String.format("* %s %s%s\n", arg.argtyp, arg.argnam,
                                (arg.altnam != null && !arg.altnam.isEmpty() ? " (" + arg.altnam + ")" : ""));
                    }
                }
            }
        }
        // Go ahead and add triggers to documentation if there are any.
        String triggersStr = "";
        ArrayList<MocaTrigger> triggers = MocaCache.getGlobalMocaCache().triggers.get(mcmds.get(0).command);
        if (triggers != null) {
            for (MocaTrigger trg : triggers) {
                triggersStr += String.format("* %d: %s\n", trg.trgseq, trg.name);
            }
        }

        return String.format("%s\n\n%s\n\nLevels\n%s\n\n%s\n%s\n\n%s\n%s", headerStr, descriptionStr, levelsStr,
                (requiredArgumentsStr.isEmpty() ? "" : "Required Arguments"), requiredArgumentsStr,
                (triggersStr.isEmpty() ? "" : "Triggers"), triggersStr);
    }

}