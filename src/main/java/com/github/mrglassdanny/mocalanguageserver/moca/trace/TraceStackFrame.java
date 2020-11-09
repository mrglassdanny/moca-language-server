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
    private static final Pattern MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN = Pattern
            .compile("(Firing triggers...) ((?s).*)");
    private static final Pattern MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN = Pattern
            .compile("(Done Firing triggers...) ((?s).*)");

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

    // Will have 1 stack level and 1 start line number per frame.
    public int stackLevel;
    public int startLineNum; // For joining up with raw trace file contents.

    // Could be multple instructions executed in stack frame.
    public ArrayList<String> instructions;

    // Should just be 1, if any, conditional tests per stack frame.
    public String conditionalTest;

    // Can assume that we will only have 1 set of each of the below per stack frame.
    public HashMap<String, String> published; // What is on the stack at time of instruction invocation.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.

    public ArrayList<String> flowMessages; // Simple list of flow messages.

    public boolean isHtmlAppended; // Indicates if html payload has been appended to buffer yet.

    public TraceStackFrame(int stackLevel, int lineNum) {
        this.stackLevel = stackLevel;
        this.startLineNum = lineNum;

        this.instructions = new ArrayList<>();

        this.conditionalTest = "";

        this.published = new HashMap<>();
        this.arguments = new HashMap<>();

        this.flowMessages = new ArrayList<>();

        this.isHtmlAppended = false;
    }

    private void clear(int lineNum) {

        this.startLineNum = lineNum;

        this.instructions = new ArrayList<>();

        this.conditionalTest = "";

        this.published = new HashMap<>();
        this.arguments = new HashMap<>();

        this.flowMessages = new ArrayList<>();

        this.isHtmlAppended = false;
    }

    public String toHtmlString() {

        this.isHtmlAppended = true;

        String stackLevelBuf = "";
        for (int i = 0; i < this.stackLevel; i++) {
            stackLevelBuf += "---";
        }

        String retStr = "";
        for (String ins : this.instructions) {
            retStr += String.format("<li><span>%s %d : %d %s</span></li>", stackLevelBuf, this.startLineNum,
                    this.stackLevel, ins.length() > 150 ? ins.substring(0, 150) + "..." : ins);
        }

        if (retStr.isEmpty()) {
            return null;
        } else {
            return retStr;
        }
    }

    public void processCommandDispatcherMessage(int lineNum, String message, StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_SERVER_GOT_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.instructions.add(matcher.group(2));
        }
    }

    public void processDefaultServerContextMessage(int lineNum, String message, StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_COMMAND_INITIATED_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.clear(lineNum);
            this.instructions.add(matcher.group(2));
        }

        matcher = TraceStackFrame.MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.clear(lineNum);
            this.instructions.add(matcher.group(2));
        }

        matcher = TraceStackFrame.MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }

        matcher = TraceStackFrame.MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.clear(lineNum);
            this.instructions.add(String.format("FIRING TRIGGERS: ", matcher.group(2)));
        }

        matcher = TraceStackFrame.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }

    }

    public void processJdbcAdapterMessage(int lineNum, String message, StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EXECUTING_SQL_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.clear(lineNum);
            this.instructions.add(matcher.group(2));
        }

        matcher = TraceStackFrame.MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }
    }

    public void processGroovyScriptAdapterMessage(int lineNum, String message, StringBuilder htmlBuf) {
        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.clear(lineNum);
            this.instructions.add("[[Compiled Script]]");
        }

        matcher = TraceStackFrame.MESSAGE_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }
    }

    public void processCommandStatementMessage(int lineNum, String message, StringBuilder htmlBuf) {

        Matcher matcher;

        matcher = TraceStackFrame.MESSAGE_EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.clear(lineNum);
            this.conditionalTest = "IF: " + matcher.group(2);
        }

        matcher = TraceStackFrame.MESSAGE_IF_TEST_PASSED_EXECUTING_IF_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : PASSED";

            this.instructions.add(this.conditionalTest);
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }

        matcher = TraceStackFrame.MESSAGE_IF_TEST_FAILED_NO_ELSE_BLOCK_TO_EXECUTE_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : FAILED";

            this.instructions.add(this.conditionalTest);
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }

        matcher = TraceStackFrame.MESSAGE_IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : FAILED -> ELSE";

            this.instructions.add(this.conditionalTest);
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }

        matcher = TraceStackFrame.MESSAGE_EVALUATING_TRY_CATCH_EXPRESSION_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {

            if (!this.conditionalTest.isEmpty()) {
                this.conditionalTest += " : FAILED";
                this.instructions.add(this.conditionalTest);
                if (!this.isHtmlAppended) {
                    String htmlStr = this.toHtmlString();
                    if (htmlStr != null) {
                        htmlBuf.append(htmlStr);
                    }
                }
                this.clear(lineNum);
            }

            this.clear(lineNum);
            this.conditionalTest = "CATCH: " + matcher.group(2);
        }

        matcher = TraceStackFrame.MESSAGE_CATCH_CONDITION_MET_EXECUTING_CATCH_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.conditionalTest += " : PASSED";

            this.instructions.add(this.conditionalTest);
            if (!this.isHtmlAppended) {
                String htmlStr = this.toHtmlString();
                if (htmlStr != null) {
                    htmlBuf.append(htmlStr);
                }
            }
            this.clear(lineNum);
        }

        matcher = TraceStackFrame.MESSAGE_EXECUTING_FINALLY_BLOCK_REGEX_PATTERN.matcher(message);
        if (matcher.find()) {
            this.clear(lineNum);
            this.conditionalTest = "FINALLY";
            this.instructions.add(this.conditionalTest);
        }

    }

    public void processArgumentMessage(int lineNum, String message, StringBuilder htmlBuf) {

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

    public void processFlowMessage(int lineNum, String message, StringBuilder htmlBuf) {
        this.flowMessages.add(message);
    }

}
