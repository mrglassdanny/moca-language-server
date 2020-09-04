package com.github.mrglassdanny.mocalanguageserver.moca.cache.moca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnectionWrapper;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class CommandRepository {

    private static final String COMMANDS_SCRIPT = "list active commands";
    private static final String COMMAND_ARGUMENTS_SCRIPT = "list active command arguments";
    private static final String TRIGGERS_SCRIPT = "list active triggers";

    public ArrayList<String> distinctCommands;
    public HashMap<String, ArrayList<MocaCommand>> commands;
    public HashMap<String, ArrayList<MocaCommandArgument>> commandArguments;
    public HashMap<String, ArrayList<MocaTrigger>> triggers;

    public CommandRepository() {
        this.distinctCommands = new ArrayList<>();
        this.commands = new HashMap<>();
        this.commandArguments = new HashMap<>();
        this.triggers = new HashMap<>();

    }

    public void loadAsync(MocaConnectionWrapper conn) {

        CompletableFuture.runAsync(() -> {
            this.loadCommands(conn);
        });

        CompletableFuture.runAsync(() -> {
            this.loadCommandArguments(conn);
        });

        CompletableFuture.runAsync(() -> {
            this.loadTriggers(conn);
        });
    }

    public void loadCommands(MocaConnectionWrapper conn) {

        this.distinctCommands.clear();
        this.commands.clear();

        MocaResults res = conn.executeCommand(CommandRepository.COMMANDS_SCRIPT).results;
        if (res != null) {

            for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                String command = res.getString(rowIdx, "command");
                if (this.commands.containsKey(command)) {

                    // Do not add to distinct mcmd list.

                    ArrayList<MocaCommand> cmds = this.commands.get(command);

                    cmds.add(new MocaCommand(res.getString(rowIdx, "cmplvl"), res.getInt(rowIdx, "cmplvlseq"), command,
                            res.getString(rowIdx, "type"), res.getString(rowIdx, "syntax"),
                            res.getString(rowIdx, "desc")));
                } else {

                    ArrayList<MocaCommand> cmds = new ArrayList<>();
                    cmds.add(new MocaCommand(res.getString(rowIdx, "cmplvl"), res.getInt(rowIdx, "cmplvlseq"), command,
                            res.getString(rowIdx, "type"), res.getString(rowIdx, "syntax"),
                            res.getString(rowIdx, "desc")));

                    this.commands.put(command, cmds);

                    // Add to distinct mcmd list.
                    this.distinctCommands.add(command);
                }
            }
        }

        // Add built in commands..
        ArrayList<MocaCommand> noopCmds = new ArrayList<>();
        noopCmds.add(new MocaCommand("N/A", 0, "noop", "N/A", "", "Built in command"));
        this.commands.put("noop", noopCmds);
        this.distinctCommands.add("noop");
        ArrayList<MocaCommand> commitCmds = new ArrayList<>();
        commitCmds.add(new MocaCommand("N/A", 0, "commit", "N/A", "", "Built in command"));
        this.commands.put("commit", commitCmds);
        this.distinctCommands.add("commit");
        ArrayList<MocaCommand> rollbackCmds = new ArrayList<>();
        rollbackCmds.add(new MocaCommand("N/A", 0, "rollback", "N/A", "", "Built in command"));
        this.commands.put("rollback", rollbackCmds);
        this.distinctCommands.add("rollback");
        ArrayList<MocaCommand> nodbcommitCmds = new ArrayList<>();
        nodbcommitCmds.add(new MocaCommand("N/A", 0, "nodbcommit", "N/A", "", "Built in command"));
        this.commands.put("nodbcommit", nodbcommitCmds);
        this.distinctCommands.add("nodbcommit");
        ArrayList<MocaCommand> nodbrollbackCmds = new ArrayList<>();
        nodbrollbackCmds.add(new MocaCommand("N/A", 0, "nodbrollback", "N/A", "", "Built in command"));
        this.commands.put("nodbrollback", nodbrollbackCmds);
        this.distinctCommands.add("nodbrollback");
        ArrayList<MocaCommand> prepareCmds = new ArrayList<>();
        prepareCmds.add(new MocaCommand("N/A", 0, "prepare", "N/A", "", "Built in command"));
        this.commands.put("prepare", prepareCmds);
        this.distinctCommands.add("prepare");
        ArrayList<MocaCommand> pingCmds = new ArrayList<>();
        pingCmds.add(new MocaCommand("N/A", 0, "ping", "N/A", "", "Built in command"));
        this.commands.put("ping", pingCmds);
        this.distinctCommands.add("ping");

    }

    public void loadCommandArguments(MocaConnectionWrapper conn) {

        this.commandArguments.clear();

        MocaResults res = conn.executeCommand(CommandRepository.COMMAND_ARGUMENTS_SCRIPT).results;

        if (res != null) {

            for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                String command = res.getString(rowIdx, "command");
                if (this.commandArguments.containsKey(command)) {

                    ArrayList<MocaCommandArgument> cmdArgs = this.commandArguments.get(command);
                    cmdArgs.add(
                            new MocaCommandArgument(res.getString(rowIdx, "cmplvl"), res.getString(rowIdx, "command"),
                                    res.getString(rowIdx, "argnam"), res.getString(rowIdx, "altnam"),
                                    res.getString(rowIdx, "argtyp"), res.getString(rowIdx, "fixval"),
                                    res.getInt(rowIdx, "argidx"), res.getBoolean(rowIdx, "argreq")));
                } else {

                    ArrayList<MocaCommandArgument> cmdArgs = new ArrayList<>();
                    cmdArgs.add(
                            new MocaCommandArgument(res.getString(rowIdx, "cmplvl"), res.getString(rowIdx, "command"),
                                    res.getString(rowIdx, "argnam"), res.getString(rowIdx, "altnam"),
                                    res.getString(rowIdx, "argtyp"), res.getString(rowIdx, "fixval"),
                                    res.getInt(rowIdx, "argidx"), res.getBoolean(rowIdx, "argreq")));
                    this.commandArguments.put(command, cmdArgs);
                }
            }
        }
    }

    public void loadTriggers(MocaConnectionWrapper conn) {
        this.triggers.clear();

        MocaResults res = conn.executeCommand(CommandRepository.TRIGGERS_SCRIPT).results;

        if (res != null) {

            for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                String command = res.getString(rowIdx, "command");
                if (this.triggers.containsKey(command)) {
                    // No need to worry about sorting, as the result set is sorted by command,
                    // trigger seq!
                    ArrayList<MocaTrigger> triggers = this.triggers.get(command);
                    triggers.add(new MocaTrigger(res.getString(rowIdx, "name"), command, res.getInt(rowIdx, "trgseq"),
                            res.getString(rowIdx, "syntax")));
                } else {

                    ArrayList<MocaTrigger> triggers = new ArrayList<>();
                    triggers.add(new MocaTrigger(res.getString(rowIdx, "name"), command, res.getInt(rowIdx, "trgseq"),
                            res.getString(rowIdx, "syntax")));
                    this.triggers.put(command, triggers);
                }
            }
        }
    }

}