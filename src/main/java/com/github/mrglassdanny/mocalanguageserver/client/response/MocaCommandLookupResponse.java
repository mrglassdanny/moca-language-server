package com.github.mrglassdanny.mocalanguageserver.client.response;

import java.util.ArrayList;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.repository.moca.MocaCommand;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.repository.moca.MocaTrigger;

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