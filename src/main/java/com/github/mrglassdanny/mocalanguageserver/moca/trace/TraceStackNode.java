package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceStackNode {

    private static final String SERVER_GOT_REGEX_STR = "(Server got:) ((?s).*)";
    private static final String DISPATCHING_COMMAND_REGEX_STR = "Dispatching command...";
    private static final String DISPATCHED_COMMAND_REGEX_STR = "Dispatched command";
    private static final String PARSING_COMMAND_REGEX_STR = "Parsing command...";
    private static final String PARSED_COMMAND_REGEX_STR = "Parsed command";
    private static final String LOOKING_UP_COMMAND_REGEX_STR = "(Looking up command:) (.*)";
    private static final String EXECUTING_REGEX_STR = "Executing...";
    private static final String EXECUTING_COMMAND_REGEX_STR = "(Executing Command:) (.*)";
    private static final String EXECUTED_COMMAND_REGEX_STR = "(Executed Command:) (.*)";
    private static final String PUBLISHED_REGEX_STR = "(Published) (.*)(=)(.*) (\\(.*\\))";
    private static final String ARGUMENT_REGEX_STR = "(Argument) (.*)(=)(.*) (\\(.*\\))";
    private static final String EXECUTING_SQL_REGEX_STR = "(Executing SQL:) ((?s).*)";

    private static final Pattern SERVER_GOT_REGEX_PATTERN = Pattern.compile(TraceStackNode.SERVER_GOT_REGEX_STR);
    private static final Pattern DISPATCHING_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.DISPATCHING_COMMAND_REGEX_STR);
    private static final Pattern DISPATCHED_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.DISPATCHED_COMMAND_REGEX_STR);
    private static final Pattern PARSING_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.PARSING_COMMAND_REGEX_STR);
    private static final Pattern PARSED_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.PARSED_COMMAND_REGEX_STR);
    private static final Pattern LOOKING_UP_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.LOOKING_UP_COMMAND_REGEX_STR);
    private static final Pattern EXECUTING_REGEX_PATTERN = Pattern.compile(TraceStackNode.EXECUTING_REGEX_STR);
    private static final Pattern EXECUTING_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.EXECUTING_COMMAND_REGEX_STR);
    private static final Pattern EXECUTED_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.EXECUTED_COMMAND_REGEX_STR);
    private static final Pattern PUBLISHED_REGEX_PATTERN = Pattern.compile(TraceStackNode.PUBLISHED_REGEX_STR);
    private static final Pattern ARGUMENT_REGEX_PATTERN = Pattern.compile(TraceStackNode.ARGUMENT_REGEX_STR);
    private static final Pattern EXECUTING_SQL_REGEX_PATTERN = Pattern.compile(TraceStackNode.EXECUTING_SQL_REGEX_STR);

    public int stackLevel;

    public String instruction;
    public HashMap<String, String> published; // What is on the stack at time of instruction invocation.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.
    public ArrayList<String> flowMessages;

    public TraceStackNode(int stackLevel, String logLevel, String component, String text) {
        this.stackLevel = stackLevel;
        this.instruction = "";
        this.published = new HashMap<>();
        this.arguments = new HashMap<>();
        this.flowMessages = new ArrayList<>();

        this.processText(logLevel, component, text);
    }

    public void processText(String logLevel, String component, String text) {

        Matcher matcher = TraceStackNode.PUBLISHED_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.published.put(matcher.group(2), matcher.group(4));
        }

        matcher = TraceStackNode.ARGUMENT_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.arguments.put(matcher.group(2), matcher.group(4));
        }

        matcher = TraceStackNode.EXECUTING_COMMAND_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.instruction = matcher.group(2);
        }

        matcher = TraceStackNode.SERVER_GOT_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.instruction = matcher.group(2);
        }

        matcher = TraceStackNode.EXECUTING_SQL_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.instruction = matcher.group(2);
        }

        if (component.compareToIgnoreCase("FLOW") == 0) {
            this.flowMessages.add(text);
        }

    }

    @Override
    public String toString() {

        String indentStr = "";
        for (int i = 0; i < this.stackLevel; i++) {
            indentStr += "\t\t";
        }

        String publishedStr = "";
        String argumentsStr = "";

        for (Entry<String, String> e : this.published.entrySet()) {
            publishedStr += " - " + (e.getKey() + " = " + e.getValue()) + "\n" + indentStr;
        }

        for (Entry<String, String> e : this.arguments.entrySet()) {
            argumentsStr += " - " + (e.getKey() + " = " + e.getValue()) + "\n" + indentStr;
        }

        String flowMessageStr = "";

        for (String msg : this.flowMessages) {
            flowMessageStr += msg + "\n" + indentStr;
        }

        return String.format(
                "%sLevel: %d\n%sInstruction: %s\n%sPublished: \n%s%s\n%sArguments: \n%s%s\n%sFlow Messages: \n%s%s\n%s------------------------------",
                indentStr, this.stackLevel, indentStr, this.instruction, indentStr, indentStr, publishedStr, indentStr,
                indentStr, argumentsStr, indentStr, indentStr, flowMessageStr, indentStr);
    }

    public String toString2() {

        String indentStr = "";
        for (int i = 0; i < this.stackLevel; i++) {
            indentStr += "------";
        }

        if (this.instruction.isEmpty()) {
            return "";
        } else {
            return String.format("%s%s", indentStr, this.instruction);
        }

    }

}
