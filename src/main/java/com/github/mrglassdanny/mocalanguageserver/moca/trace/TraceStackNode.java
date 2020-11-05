package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceStackNode {

    private static final String SERVER_GOT_REGEX_STR = "(Server got:) ((?s).*)";
    private static final String COMMAND_INITIATED_REGEX_STR = "(Command initiated:) (\\[)((?s).*)(\\])";
    private static final String EXECUTING_COMMAND_REGEX_STR = "(Executing Command:) (.*)";
    private static final String EXECUTED_COMMAND_REGEX_STR = "(Executed Command:) (.*)";
    private static final String PUBLISHED_REGEX_STR = "(Published) (.*)(=)(.*) (\\(.*\\))";
    private static final String ARGUMENT_REGEX_STR = "(Argument) (.*)(=)(.*) (\\(.*\\))";
    private static final String EVALUATING_CONDITIONAL_TEST_REGEX_STR = "(Evaluating conditional test:) ((?s).*)";
    private static final String IF_TEST_FAILED_REGEX_STR = "If-test failed";
    private static final String IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_STR = "If-test failed - executing else block";
    private static final String FIRING_TRIGGERS_REGEX_STR = "(Firing triggers...) ((?s).*)";
    private static final String EXECUTING_SQL_REGEX_STR = "(UNBIND:) ((?s).*)";
    private static final String EXECUTING_COMPILED_SCRIPT_REGEX_STR = "Executing Compiled Script";

    private static final Pattern SERVER_GOT_REGEX_PATTERN = Pattern.compile(TraceStackNode.SERVER_GOT_REGEX_STR);
    private static final Pattern COMMAND_INITIATED_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.COMMAND_INITIATED_REGEX_STR);
    private static final Pattern EXECUTING_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.EXECUTING_COMMAND_REGEX_STR);
    private static final Pattern EXECUTED_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.EXECUTED_COMMAND_REGEX_STR);
    private static final Pattern PUBLISHED_REGEX_PATTERN = Pattern.compile(TraceStackNode.PUBLISHED_REGEX_STR);
    private static final Pattern ARGUMENT_REGEX_PATTERN = Pattern.compile(TraceStackNode.ARGUMENT_REGEX_STR);
    private static final Pattern EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.EVALUATING_CONDITIONAL_TEST_REGEX_STR);
    private static final Pattern IF_TEST_FAILED_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.IF_TEST_FAILED_REGEX_STR);
    private static final Pattern IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_STR);
    private static final Pattern FIRING_TRIGGERS_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.FIRING_TRIGGERS_REGEX_STR);
    private static final Pattern EXECUTING_SQL_REGEX_PATTERN = Pattern.compile(TraceStackNode.EXECUTING_SQL_REGEX_STR);
    private static final Pattern EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN = Pattern
            .compile(TraceStackNode.EXECUTING_COMPILED_SCRIPT_REGEX_STR);

    public int stackLevel;
    public int stackLevelStartLineNum; // For joining up with raw trace file contents.
    public String instruction;
    public String instructionStatus; // Indicates MOCA return status for instruction.
    public boolean instructionChanged; // Indicates if instruction has changed at stack level. This happens when stack
                                       // level is reused for the same instruction but has new stack variables.
    public String conditionalTest;
    public HashMap<String, String> published; // What is on the stack at time of instruction invocation.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.
    public ArrayList<String> flowMessages;
    public boolean isWritten; // Indicates if node has been written to outline buffer.

    public TraceStackNode(int stackLevel, int lineNum, String logLevel, String component, String text,
            StringBuilder htmlBuf) {
        this.stackLevel = stackLevel;
        this.stackLevelStartLineNum = lineNum;
        this.instruction = "";
        this.instructionStatus = "";
        this.instructionChanged = false;
        this.conditionalTest = "";
        this.published = new HashMap<>();
        this.arguments = new HashMap<>();
        this.flowMessages = new ArrayList<>();
        this.isWritten = false;

        this.processText(lineNum, logLevel, component, text, htmlBuf);
    }

    public void processText(int lineNum, String logLevel, String component, String text, StringBuilder htmlBuf) {

        Matcher matcher;

        matcher = TraceStackNode.EXECUTING_COMMAND_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            if (!this.instruction.isEmpty()) {
                this.instructionChanged = true;
                this.stackLevelStartLineNum = lineNum;
            }
            this.instruction = matcher.group(2);
        }

        matcher = TraceStackNode.SERVER_GOT_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            if (!this.instruction.isEmpty()) {
                this.instructionChanged = true;
                this.stackLevelStartLineNum = lineNum;
            }
            this.instruction = matcher.group(2);
        }

        matcher = TraceStackNode.COMMAND_INITIATED_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            if (!this.instruction.isEmpty()) {
                this.instructionChanged = true;
                this.stackLevelStartLineNum = lineNum;
            }
            this.instruction = matcher.group(3);
            // Need to change stack level start line number if we have a match here.
            this.stackLevelStartLineNum = lineNum;
        }

        matcher = TraceStackNode.EXECUTING_SQL_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            if (!this.instruction.isEmpty()) {
                this.instructionChanged = true;
                this.stackLevelStartLineNum = lineNum;
            }
            this.instruction = matcher.group(2);
        }

        matcher = TraceStackNode.EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            if (!this.instruction.isEmpty()) {
                this.instructionChanged = true;
                this.stackLevelStartLineNum = lineNum;
            }
            this.instruction = "[[Compiled Script]]";
        }

        matcher = TraceStackNode.FIRING_TRIGGERS_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            if (!this.instruction.isEmpty()) {
                this.instructionChanged = true;
                this.stackLevelStartLineNum = lineNum;
            }
            this.instruction = "FIRING TRIGGERS: " + matcher.group(2);
        }

        matcher = TraceStackNode.EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.conditionalTest = "IF: " + matcher.group(2);
        }

        matcher = TraceStackNode.IF_TEST_FAILED_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.conditionalTest += " : FAILED";
        }

        matcher = TraceStackNode.IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.conditionalTest += " -> ELSE";
        }

        if (component.compareToIgnoreCase("FLOW") == 0) {
            this.flowMessages.add(text);
        }

        matcher = TraceStackNode.PUBLISHED_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.published.put(matcher.group(2), matcher.group(4));
        }

        matcher = TraceStackNode.ARGUMENT_REGEX_PATTERN.matcher(text);
        if (matcher.find()) {
            this.arguments.put(matcher.group(2), matcher.group(4));
        }

        matcher = TraceStackNode.EXECUTED_COMMAND_REGEX_PATTERN.matcher(text);
        if (matcher.find() && this.instructionChanged && !this.isWritten) {
            htmlBuf.append("<li>");
            htmlBuf.append(this.toString());
            htmlBuf.append("</li>");
            // Do not set isWritten = true here.
        }

    }

    @Override
    public String toString() {

        String str = "";
        for (int i = 0; i < this.stackLevel; i++) {
            str += "---";
        }

        if (!this.instruction.isEmpty()) {
            if (!this.conditionalTest.isEmpty()) {
                return String.format("<span>%s %d : %d %s -> %s</span>", str, this.stackLevelStartLineNum,
                        this.stackLevel, this.conditionalTest,
                        this.instruction.length() > 50 ? this.instruction.substring(0, 50) + "..." : this.instruction);
            } else {
                return String.format("<span>%s %d : %d %s</span>", str, this.stackLevelStartLineNum, this.stackLevel,
                        this.instruction.length() > 50 ? this.instruction.substring(0, 50) + "..." : this.instruction);
            }
        } else {
            if (!this.conditionalTest.isEmpty()) {
                return String.format("<span>%s %d : %d %s</span>", str, this.stackLevelStartLineNum, this.stackLevel,
                        this.conditionalTest);
            } else {
                return null;
            }
        }

    }

}