package com.github.mrglassdanny.mocalanguageserver.languageclient.response;

import java.util.ArrayList;

import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.MocaTrigger;

public class MocaCommandLookupResponse {

    public ArrayList<String> distinctMocaCommands;
    public ArrayList<MocaCommand> commandsAtLevels;
    public ArrayList<MocaTrigger> triggers;
    public Exception exception;

    public MocaCommandLookupResponse(ArrayList<String> distinctMocaCommands, ArrayList<MocaCommand> commandsAtLevels,
            ArrayList<MocaTrigger> triggers, Exception exception) {
        this.distinctMocaCommands = distinctMocaCommands;
        this.commandsAtLevels = commandsAtLevels;
        this.triggers = triggers;
        this.exception = exception;
    }
}