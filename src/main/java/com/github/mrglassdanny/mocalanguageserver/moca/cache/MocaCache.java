package com.github.mrglassdanny.mocalanguageserver.moca.cache;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.MocaSqlCache;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnection;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaCache {

        // Using singleton pattern to manage single global cache instance.
        private static MocaCache globalMocaCache = null;

        public static MocaCache getGlobalMocaCache() {
                if (MocaCache.globalMocaCache == null) {
                        MocaCache.globalMocaCache = new MocaCache();
                        return MocaCache.globalMocaCache;
                } else {
                        return MocaCache.globalMocaCache;
                }
        }

        private static final String COMMANDS_SCRIPT = "list active commands";
        private static final String COMMAND_ARGUMENTS_SCRIPT = "list active command arguments";
        private static final String TRIGGERS_SCRIPT = "list active triggers";

        public ArrayList<String> distinctCommands;
        public HashMap<String, ArrayList<MocaCommand>> commands;
        public HashMap<String, ArrayList<MocaCommandArgument>> commandArguments;
        public HashMap<String, ArrayList<MocaTrigger>> triggers;
        public HashMap<String, MocaFunction> functions;

        public MocaSqlCache mocaSqlCache;

        public MocaCache() {
                this.distinctCommands = new ArrayList<>();
                this.commands = new HashMap<>();
                this.commandArguments = new HashMap<>();
                this.triggers = new HashMap<>();

                this.mocaSqlCache = new MocaSqlCache();

                // Moca functions can be hardcoded.
                {
                        MocaFunction maxFunc = new MocaFunction("max",
                                        new String[] { MocaFunction.VARIABLE_LENGTH_ARGUMENT },
                                        "Maximum expr as a MocaType.INTEGER");
                        MocaFunction minFunc = new MocaFunction("min",
                                        new String[] { MocaFunction.VARIABLE_LENGTH_ARGUMENT },
                                        "Minimum expr as a MocaType.INTEGER");

                        MocaFunction instrFunc = new MocaFunction("instr", new String[] { "search", "lookfor", "n" },
                                        "Index of the first character in search that contains the string lookfor. The string search is searched beginning at character n (if n is omitted, the first character)");
                        MocaFunction lenFunc = new MocaFunction("len", new String[] { "expr" },
                                        "Length of expr as returned by strlen()");
                        MocaFunction lengthFunc = new MocaFunction("length", new String[] { "expr" },
                                        "Length of expr as returned by strlen()");
                        MocaFunction lowerFunc = new MocaFunction("lower", new String[] { "expr" },
                                        "expr as a MocaType.STRING converted to lowercase");
                        MocaFunction lpadFunc = new MocaFunction("lpad", new String[] { "expr", "length", "padstr" },
                                        "expr as a MocaType.STRING left padded to the length as a MocaType.INTEGER using the padstr as a MocaType.STRING. If padstr is not passed, the default is a space. If length is smaller than the length of the expr, then it will truncate to that length");
                        MocaFunction rpadFunc = new MocaFunction("rpad", new String[] { "expr", "length", "padstr" },
                                        "expr as a MocaType.STRING right padded to the length as a MocaType.INTEGER using the padstr as a MocaType.STRING. If padstr is not passed, the default is a space. If length is smaller than the length of the expr, then it will truncate to that length");
                        MocaFunction rtrimFunc = new MocaFunction("rtrim", new String[] { "expr" },
                                        "expr as a MocaType.STRING with trailing whitespace removed");
                        MocaFunction sprintfFunc = new MocaFunction("sprintf", new String[] { "fmt", "arg" },
                                        "Result of applying the format expressed by fmt to arg using sprintf() as a MocaType.STRING. The fmt argument can only contain one format specifier");
                        MocaFunction substrFunc = new MocaFunction("substr", new String[] { "expr", "m", "n" },
                                        "expr as a MocaType.STRING beginning at character m, n characters long (if n is omitted, to end of expr)");
                        MocaFunction trimFunc = new MocaFunction("trim", new String[] { "expr" },
                                        "expr as a MocaType.STRING with trailing whitespace removed");
                        MocaFunction upperFunc = new MocaFunction("upper", new String[] { "expr" },
                                        "expr as a MocaType.STRING converted to uppercase");

                        MocaFunction sysdateFunc = new MocaFunction("sysdate", new String[] {},
                                        "Current date and time as a MocaType.DATETIME");

                        MocaFunction dateFunc = new MocaFunction("date", new String[] { "expr" },
                                        "expr as a MocaType.DATETIME");
                        MocaFunction dbdateFunc = new MocaFunction("dbdate", new String[] { "expr" },
                                        "expr as a MocaType.STRING converted to the correct format, based on current database. expr must be either a MocaType.STRING or a MocaType.STRING in the 'YYYYMMDDHH24MISS' format");
                        MocaFunction floatFunc = new MocaFunction("float", new String[] { "expr" },
                                        "expr as a MocaType.DOUBLE");
                        MocaFunction intFunc = new MocaFunction("int", new String[] { "expr" },
                                        "expr as a MocaType.INTEGER");
                        MocaFunction stringFunc = new MocaFunction("string", new String[] { "expr" },
                                        "expr as a MocaType.STRING");
                        MocaFunction to_charFunc = new MocaFunction("to_char", new String[] { "expr", "format" },
                                        "expr as a MocaType.STRING using format if provided");
                        MocaFunction to_dateFunc = new MocaFunction("to_date", new String[] { "expr", "format" },
                                        "expr as a MocaType.DATETIME using format if provided");
                        MocaFunction to_numberFunc = new MocaFunction("to_number", new String[] { "expr" },
                                        "expr as a MocaType.DOUBLE");

                        MocaFunction dbtypeFunc = new MocaFunction("dbtype", new String[] {},
                                        "Database type as a MocaType.STRING. 'ERROR', 'NONE', 'DB2', 'MSSQL', or 'ORACLE'");
                        MocaFunction nextvalFunc = new MocaFunction("nextval", new String[] { "expr" },
                                        "Next value in the sequence expr as a MocaType.STRING");

                        MocaFunction decodeFunc = new MocaFunction("decode",
                                        new String[] { "expr", "search1", "return1", "search2", "return2",
                                                        MocaFunction.VARIABLE_LENGTH_ARGUMENT, "default" },
                                        "If expr equals any search, it returns the corresponding return; if not, it returns default");
                        MocaFunction iifFunc = new MocaFunction("iif", new String[] { "expr", "trueExpr", "falseExpr" },
                                        "If expr is true, it returns trueExpr; if not, it returns falseExpr");
                        MocaFunction nvlFunc = new MocaFunction("nvl", new String[] { "expr1", "expr2" },
                                        "If expr1 is not null, it returns expr1; otherwise, it returns expr2");
                        MocaFunction rowcountFunc = new MocaFunction("rowcount", new String[] { "resultset" },
                                        "Number of rows in resultset");
                        MocaFunction commandFunc = new MocaFunction("command", new String[] {},
                                        "Full text of the currently executing command");

                        this.functions = new HashMap<>();
                        this.functions.put("max", maxFunc);
                        this.functions.put("min", minFunc);
                        this.functions.put("instr", instrFunc);
                        this.functions.put("len", lenFunc);
                        this.functions.put("length", lengthFunc);
                        this.functions.put("lower", lowerFunc);
                        this.functions.put("lpad", lpadFunc);
                        this.functions.put("rpad", rpadFunc);
                        this.functions.put("rtrim", rtrimFunc);
                        this.functions.put("sprintf", sprintfFunc);
                        this.functions.put("substr", substrFunc);
                        this.functions.put("trim", trimFunc);
                        this.functions.put("upper", upperFunc);
                        this.functions.put("sysdate", sysdateFunc);
                        this.functions.put("date", dateFunc);
                        this.functions.put("dbdate", dbdateFunc);
                        this.functions.put("float", floatFunc);
                        this.functions.put("int", intFunc);
                        this.functions.put("string", stringFunc);
                        this.functions.put("to_char", to_charFunc);
                        this.functions.put("to_date", to_dateFunc);
                        this.functions.put("to_number", to_numberFunc);
                        this.functions.put("dbtype", dbtypeFunc);
                        this.functions.put("nextval", nextvalFunc);
                        this.functions.put("decode", decodeFunc);
                        this.functions.put("iif", iifFunc);
                        this.functions.put("nvl", nvlFunc);
                        this.functions.put("rowcount", rowcountFunc);
                        this.functions.put("command", commandFunc);
                }

        }

        public void loadCommands() {

                this.distinctCommands.clear();
                this.commands.clear();

                try {
                        MocaResults res = MocaConnection.getGlobalMocaConnection()
                                        .executeCommand(MocaCache.COMMANDS_SCRIPT);
                        if (res != null) {

                                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                                        String command = res.getString(rowIdx, "command");
                                        if (this.commands.containsKey(command)) {

                                                // Do not add to distinct mcmd list.

                                                ArrayList<MocaCommand> cmds = this.commands.get(command);

                                                cmds.add(new MocaCommand(res.getString(rowIdx, "cmplvl"),
                                                                res.getInt(rowIdx, "cmplvlseq"), command,
                                                                res.getString(rowIdx, "type"),
                                                                res.getString(rowIdx, "syntax"),
                                                                res.getString(rowIdx, "desc")));
                                        } else {

                                                ArrayList<MocaCommand> cmds = new ArrayList<>();
                                                cmds.add(new MocaCommand(res.getString(rowIdx, "cmplvl"),
                                                                res.getInt(rowIdx, "cmplvlseq"), command,
                                                                res.getString(rowIdx, "type"),
                                                                res.getString(rowIdx, "syntax"),
                                                                res.getString(rowIdx, "desc")));

                                                this.commands.put(command, cmds);

                                                // Add to distinct mcmd list.
                                                this.distinctCommands.add(command);
                                        }
                                }
                        }
                } catch (Exception e) {
                        // ignore
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

        public void loadCommandArguments() {

                this.commandArguments.clear();

                try {
                        MocaResults res = MocaConnection.getGlobalMocaConnection()
                                        .executeCommand(MocaCache.COMMAND_ARGUMENTS_SCRIPT);

                        if (res != null) {

                                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                                        String command = res.getString(rowIdx, "command");
                                        if (this.commandArguments.containsKey(command)) {

                                                ArrayList<MocaCommandArgument> cmdArgs = this.commandArguments
                                                                .get(command);
                                                cmdArgs.add(new MocaCommandArgument(res.getString(rowIdx, "cmplvl"),
                                                                res.getString(rowIdx, "command"),
                                                                res.getString(rowIdx, "argnam"),
                                                                res.getString(rowIdx, "altnam"),
                                                                res.getString(rowIdx, "argtyp"),
                                                                res.getString(rowIdx, "fixval"),
                                                                res.getInt(rowIdx, "argidx"),
                                                                res.getBoolean(rowIdx, "argreq")));
                                        } else {

                                                ArrayList<MocaCommandArgument> cmdArgs = new ArrayList<>();
                                                cmdArgs.add(new MocaCommandArgument(res.getString(rowIdx, "cmplvl"),
                                                                res.getString(rowIdx, "command"),
                                                                res.getString(rowIdx, "argnam"),
                                                                res.getString(rowIdx, "altnam"),
                                                                res.getString(rowIdx, "argtyp"),
                                                                res.getString(rowIdx, "fixval"),
                                                                res.getInt(rowIdx, "argidx"),
                                                                res.getBoolean(rowIdx, "argreq")));
                                                this.commandArguments.put(command, cmdArgs);
                                        }
                                }
                        }
                } catch (Exception e) {
                        // ignore
                }

        }

        public void loadTriggers() {

                this.triggers.clear();

                try {
                        MocaResults res = MocaConnection.getGlobalMocaConnection()
                                        .executeCommand(MocaCache.TRIGGERS_SCRIPT);

                        if (res != null) {

                                for (int rowIdx = 0; rowIdx < res.getRowCount(); rowIdx++) {
                                        String command = res.getString(rowIdx, "command");
                                        if (this.triggers.containsKey(command)) {
                                                // No need to worry about sorting, as the result set is sorted by
                                                // command,
                                                // trigger seq!
                                                ArrayList<MocaTrigger> triggers = this.triggers.get(command);
                                                triggers.add(new MocaTrigger(res.getString(rowIdx, "name"), command,
                                                                res.getInt(rowIdx, "trgseq"),
                                                                res.getString(rowIdx, "syntax")));
                                        } else {

                                                ArrayList<MocaTrigger> triggers = new ArrayList<>();
                                                triggers.add(new MocaTrigger(res.getString(rowIdx, "name"), command,
                                                                res.getInt(rowIdx, "trgseq"),
                                                                res.getString(rowIdx, "syntax")));
                                                this.triggers.put(command, triggers);
                                        }
                                }
                        }
                } catch (Exception e) {
                        // ignore
                }

        }

}