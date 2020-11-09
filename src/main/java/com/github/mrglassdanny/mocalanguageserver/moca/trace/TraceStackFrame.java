package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceStackFrame {

    private static final Pattern MESSAGE_SERVER_GOT_REGEX_PATTERN = Pattern.compile("(Server got:) ((?s).*)");

    private static final Pattern MESSAGE_COMMAND_INITIATED_REGEX_PATTERN = Pattern
            .compile("(Command initiated:) (\\[)((?s).*)(\\])");
    private static final Pattern MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN = Pattern.compile("(Executing Command:) (.*)");
    private static final Pattern MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN = Pattern.compile("(Executed Command:) (.*)");

    private static final Pattern MESSAGE_EXECUTING_SQL_REGEX_PATTERN = Pattern.compile("(UNBIND:) ((?s).*)");
    private static final Pattern MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN = Pattern
            .compile("Executing Compiled Script");

    private static final Pattern MESSAGE_PUBLISHED_REGEX_PATTERN = Pattern
            .compile("(Published) (.*)(=)(.*) (\\(.*\\))");
    private static final Pattern MESSAGE_ARGUMENT_REGEX_PATTERN = Pattern.compile("(Argument) (.*)(=)(.*) (\\(.*\\))");

    // Will have 1 stack level and 1 start line number per frame.
    public int stackLevel;
    public int startLineNum; // For joining up with raw trace file contents.

    // Could be multple instructions executed in stack frame.
    public ArrayList<String> instructions;

    // Can assume that we will only have 1 set of each of the below per stack frame.
    public HashMap<String, String> published; // What is on the stack at time of instruction invocation.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.

    public TraceStackFrame(int stackLevel, int lineNum) {
        this.stackLevel = stackLevel;
        this.startLineNum = lineNum;

        this.instructions = new ArrayList<>();

        this.published = new HashMap<>();
        this.arguments = new HashMap<>();
    }

    public void processCommandDispatcherMessage(String message) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_SERVER_GOT_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.instructions.add(matcher.group(2));
        }
    }

    public void processDefaultServerContextMessage(String message) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_COMMAND_INITIATED_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.instructions.add(matcher.group(2));
        }

        // matcher =
        // TraceStackFrame.MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN.matcher(message);
        // if (matcher.find()) {

        // }

        matcher = TraceStackFrame.MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.instructions.add(matcher.group(2));
        }
    }

    public void processJdbcAdapterMessage(String message) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EXECUTING_SQL_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.instructions.add(matcher.group(2));
        }
    }

    public void processGroovyScriptAdapterMessage(String message) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.instructions.add("[[Compiled Script]]");
        }
    }

    public void processCommandStatementMessage(String message) {
    }

    public void processArgumentMessage(String message) {

        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_PUBLISHED_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.published.put(matcher.group(2), matcher.group(4));
        }

        matcher = TraceStackFrame.MESSAGE_ARGUMENT_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.arguments.put(matcher.group(2), matcher.group(4));
        }
    }

}
