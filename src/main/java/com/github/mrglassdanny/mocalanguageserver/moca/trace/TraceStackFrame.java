package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceStackFrame {

    private static final Pattern MESSAGE_SERVER_GOT_REGEX_PATTERN = Pattern.compile("(Server got:) ((?s).*)");

    private static final Pattern MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN = Pattern.compile("(Executing Command:) (.*)");
    private static final Pattern MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN = Pattern.compile("(Executed Command:) (.*)");
    private static final Pattern MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN = Pattern
            .compile("(Firing triggers...) ((?s).*)");
    private static final Pattern MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN = Pattern
            .compile("(Done Firing triggers...) ((?s).*)");
    private static final Pattern MESSAGE_EXECUTING_COMMAND_ON_REMOTE_HOST_REGEX_PATTERN = Pattern
            .compile("(Executing command on remote host) (.*)(\\:)((?s).*)");
    private static final Pattern MESSAGE_REMOTE_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("Remote execution complete");

    private static final Pattern MESSAGE_EXECUTING_SQL_REGEX_PATTERN = Pattern.compile("(UNBIND:) ((?s).*)");
    private static final Pattern MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("SQL execution completed");
    private static final Pattern MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN = Pattern
            .compile("Executing Compiled Script");
    private static final Pattern MESSAGE_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("Script Execution Complete");

    private static final Pattern MESSAGE_EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN = Pattern
            .compile("(Evaluating conditional test:) ((?s).*)");
    private static final Pattern MESSAGE_IF_TEST_PASSED_EXECUTING_IF_BLOCK_REGEX_PATTERN = Pattern
            .compile("If-test passed - executing if block");
    private static final Pattern MESSAGE_IF_TEST_FAILED_NO_ELSE_BLOCK_TO_EXECUTE_REGEX_PATTERN = Pattern
            .compile("If-test failed - no else block to execute");
    private static final Pattern MESSAGE_IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN = Pattern
            .compile("If-test failed - executing else block");
    private static final Pattern MESSAGE_EVALUATING_TRY_CATCH_EXPRESSION_REGEX_PATTERN = Pattern
            .compile("(Evaluating try-catch expression...) ((?s).*)");
    private static final Pattern MESSAGE_CATCH_CONDITION_MET_EXECUTING_CATCH_BLOCK_REGEX_PATTERN = Pattern
            .compile("Catch condition met - executing catch block...");
    private static final Pattern MESSAGE_EXECUTING_FINALLY_BLOCK_REGEX_PATTERN = Pattern
            .compile("Executing finally block...");

    private static final Pattern MESSAGE_PUBLISHED_REGEX_PATTERN = Pattern
            .compile("(Published) (.*)(=)(.*) (\\(.*\\))");
    private static final Pattern MESSAGE_ARGUMENT_REGEX_PATTERN = Pattern.compile("(Argument) (.*)(=)(.*) (\\(.*\\))");

    public int stackLevel; // Will have 1 stack level per frame.
    public int absoluteLineNum; // For joining up with raw trace file contents relative to entire file.
    public int relativeLineNum; // For joining up with raw trace file contents relative to thread:session combo.

    // Could be multple instructions executed in stack frame.
    public String instruction;

    // Should just be 1, if any, conditional tests per stack frame.
    public String conditionalTest;

    // Can assume that we will only have 1 set of each of the below per stack frame.
    public HashMap<String, String> published; // What is on the stack at time of instruction invocation.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.

    public ArrayList<String> flowMessages; // Simple list of flow messages.

    public boolean isHtmlAppended; // Indicates if html payload has been appended to buffer yet.

    public TraceStackFrame(int stackLevel, int lineNum, int relativeLineNum) {
        this.stackLevel = stackLevel;
        this.absoluteLineNum = lineNum;
        this.relativeLineNum = relativeLineNum;

        this.instruction = "";

        this.conditionalTest = "";

        this.published = new HashMap<>();
        this.arguments = new HashMap<>();

        this.flowMessages = new ArrayList<>();

        this.isHtmlAppended = false;
    }

    private void reset(int lineNum, int relativeLineNum) {

        this.absoluteLineNum = lineNum;
        this.relativeLineNum = relativeLineNum;

        this.instruction = "";

        this.conditionalTest = "";

        this.published.clear();
        this.arguments.clear();

        this.flowMessages.clear();

        this.isHtmlAppended = false;
    }

    public void appendHtml(StringBuilder htmlBuf) {
        if (!this.isHtmlAppended) {
            String htmlStr = this.toHtmlString();
            if (htmlStr != null) {
                htmlBuf.append(htmlStr);
            }
        }
    }

    public String toHtmlString() {

        this.isHtmlAppended = true;

        String stackLevelBuf = "";
        for (int i = 0; i < this.stackLevel; i++) {
            stackLevelBuf += "---";
        }

        String retStr = "";
        if (!this.instruction.isEmpty()) {
            retStr += String.format("<li><span>%s %d(%d) : %d %s</span></li>", stackLevelBuf, this.absoluteLineNum,
                    this.relativeLineNum, this.stackLevel,
                    this.instruction.length() > 150 ? this.instruction.substring(0, 150) + "..." : this.instruction);
        }

        if (retStr.isEmpty()) {
            return null;
        } else {
            return retStr;
        }
    }

    public void processCommandDispatcherMessage(int lineNum, int relativeLineNum, String message,
            StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_SERVER_GOT_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.instruction = matcher.group(2);
        }
    }

    public void processDefaultServerContextMessage(int lineNum, int relativeLineNum, String message,
            StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
            this.instruction = matcher.group(2);
        }

        matcher = TraceStackFrame.MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }

        matcher = TraceStackFrame.MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
            this.instruction = message;
        }

        matcher = TraceStackFrame.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
        }

        matcher = TraceStackFrame.MESSAGE_EXECUTING_COMMAND_ON_REMOTE_HOST_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
            this.instruction = String.format("REMOTE %s -> %s", matcher.group(2), matcher.group(4));
        }

        matcher = TraceStackFrame.MESSAGE_REMOTE_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }

    }

    public void processJdbcAdapterMessage(int lineNum, int relativeLineNum, String message, StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EXECUTING_SQL_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
            this.instruction = matcher.group(2);
        }

        matcher = TraceStackFrame.MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }
    }

    public void processGroovyScriptAdapterMessage(int lineNum, int relativeLineNum, String message,
            StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
            this.instruction = "[[Compiled Script]]";
        }

        matcher = TraceStackFrame.MESSAGE_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }
    }

    public void processCommandStatementMessage(int lineNum, int relativeLineNum, String message,
            StringBuilder htmlBuf) {

        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
            this.conditionalTest = "IF: " + matcher.group(2);
        }

        matcher = TraceStackFrame.MESSAGE_IF_TEST_PASSED_EXECUTING_IF_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : PASSED";

            this.instruction = this.conditionalTest;
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }

        matcher = TraceStackFrame.MESSAGE_IF_TEST_FAILED_NO_ELSE_BLOCK_TO_EXECUTE_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : FAILED";

            this.instruction = this.conditionalTest;
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }

        matcher = TraceStackFrame.MESSAGE_IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : FAILED -> ELSE";

            this.instruction = this.conditionalTest;
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }

        matcher = TraceStackFrame.MESSAGE_EVALUATING_TRY_CATCH_EXPRESSION_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {

            if (!this.conditionalTest.isEmpty()) {
                this.conditionalTest += " : FAILED";
                this.instruction = this.conditionalTest;
                this.appendHtml(htmlBuf);
                this.reset(lineNum, relativeLineNum);
            }

            this.reset(lineNum, relativeLineNum);
            this.conditionalTest = "CATCH: " + matcher.group(2);
        }

        matcher = TraceStackFrame.MESSAGE_CATCH_CONDITION_MET_EXECUTING_CATCH_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : PASSED";

            this.instruction = this.conditionalTest;
            this.appendHtml(htmlBuf);
            this.reset(lineNum, relativeLineNum);
        }

        matcher = TraceStackFrame.MESSAGE_EXECUTING_FINALLY_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.reset(lineNum, relativeLineNum);
            this.conditionalTest = "FINALLY";
            this.instruction = this.conditionalTest;
        }

    }

    public void processArgumentMessage(int lineNum, int relativeLineNum, String message, StringBuilder htmlBuf) {

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

    public void processFlowMessage(int lineNum, int relativeLineNum, String message, StringBuilder htmlBuf) {
        this.flowMessages.add(message);
    }

}
