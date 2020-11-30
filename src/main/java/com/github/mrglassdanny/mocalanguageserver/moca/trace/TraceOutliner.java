package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceOutliner {

    private static final Pattern TRACE_LINE_REGEX_PATTERN = Pattern.compile(
            "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) (TRACE|DEBUG|INFO |WARN |ERROR|FATAL) \\[(\\d+)[ ]+(.*?)\\] (.+?) \\[(\\d{1,3})\\] ([\\s\\S]*) \\[[\\s\\S]*\\](.*)");

    private static final int TRACE_LINE_REGEX_THREAD_GROUP_IDX = 3;
    private static final int TRACE_LINE_REGEX_SESSION_GROUP_IDX = 4;
    private static final int TRACE_LINE_REGEX_LOGGER_GROUP_IDX = 5;
    private static final int TRACE_LINE_REGEX_STACK_LEVEL_GROUP_IDX = 6;
    private static final int TRACE_LINE_REGEX_MESSAGE_GROUP_IDX = 7;

    // There are a select few loggers that we actually care to analyze.
    private static final String[] LOGGERS = { "Argument", "CommandStatement", "DefaultServerContext", "JDBCAdapter",
            "Performance", "CommandDispatcher", "MocaTransactionManager", "GroovyScriptAdapter", "Flow", "FLOW",
            "ComponentAdapter", "ServerActivity" };

    // These messages indicate the beginning and ending of a trace 'stack'.
    private static final String MESSAGE_TRACE_STACK_START_TEXT = "Dispatching command...";
    private static final String MESSAGE_TRACE_STACK_END_TEXT = "Dispatched command";

    // SERVER GOT:
    private static final Pattern MESSAGE_SERVER_GOT_REGEX_PATTERN = Pattern.compile("(Server got:) ((?s).*)");

    // COMMAND INITIATED:
    private static final Pattern MESSAGE_COMMAND_INITIATED_REGEX_PATTERN = Pattern
            .compile("(Command initiated:) (\\[)((?s).*)(\\])");

    // MOCA:
    private static final Pattern MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN = Pattern.compile("(Executing Command:) (.*)");
    private static final Pattern MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN = Pattern.compile("(Executed Command:) (.*)");
    private static final Pattern MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN = Pattern
            .compile("(Firing triggers\\.\\.\\.) ((?s).*)");
    private static final Pattern MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN = Pattern
            .compile("(Done Firing triggers\\.\\.\\.) ((?s).*)");
    private static final Pattern MESSAGE_EXECUTING_COMMAND_ON_REMOTE_HOST_REGEX_PATTERN = Pattern
            .compile("(Executing command on remote host) (.*)(:)((?s).*)");
    private static final Pattern MESSAGE_REMOTE_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("Remote execution complete");
    private static final Pattern MESSAGE_EXECUTING_PARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN = Pattern
            .compile("(Executing parallel command on hosts) (.*)(:)((?s).*)");
    private static final Pattern MESSAGE_EXECUTING_INPARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN = Pattern
            .compile("(Executing inparallel command on hosts) (.*)(:)((?s).*)");
    private static final Pattern MESSAGE_PARALLEL_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("Parallel execution complete");

    // SQL:
    private static final Pattern MESSAGE_EXECUTING_SQL_REGEX_PATTERN = Pattern.compile("(Executing SQL:) ((?s).*)");
    private static final Pattern MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("SQL execution completed");
    private static final Pattern MESSAGE_PREPAREDSTATEMENT_EXECUTE_REGEX_PATTERN = Pattern
            .compile("( \\.\\.\\.PreparedStatement\\.execute(.*?\\())((?s).*)(\\))");
    private static final Pattern MESSAGE_PREPAREDSTATEMENT_CLOSE_REGEX_PATTERN = Pattern
            .compile(" \\.\\.\\.PreparedStatement\\.close\\(\\)");

    // GROOVY:
    private static final Pattern MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN = Pattern
            .compile("Executing Compiled Script");
    private static final Pattern MESSAGE_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("Script Execution Complete");

    // COMMAND STATEMENTS:
    private static final Pattern MESSAGE_EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN = Pattern
            .compile("(Evaluating conditional test:) ((?s).*)");
    private static final Pattern MESSAGE_IF_TEST_PASSED_EXECUTING_IF_BLOCK_REGEX_PATTERN = Pattern
            .compile("If-test passed - executing if block");
    private static final Pattern MESSAGE_IF_TEST_FAILED_NO_ELSE_BLOCK_TO_EXECUTE_REGEX_PATTERN = Pattern
            .compile("If-test failed - no else block to execute");
    private static final Pattern MESSAGE_IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN = Pattern
            .compile("If-test failed - executing else block");
    private static final Pattern MESSAGE_EVALUATING_TRY_CATCH_EXPRESSION_REGEX_PATTERN = Pattern
            .compile("(Evaluating try-catch expression\\.\\.\\.) ((?s).*)");
    private static final Pattern MESSAGE_CATCH_CONDITION_MET_EXECUTING_CATCH_BLOCK_REGEX_PATTERN = Pattern
            .compile("Catch condition met - executing catch block\\.\\.\\.");
    private static final Pattern MESSAGE_EXECUTING_FINALLY_BLOCK_REGEX_PATTERN = Pattern
            .compile("Executing finally block\\.\\.\\.");
    private static final Pattern EXTRACT_CONDITIONAL_TEST_VALUES = Pattern
            .compile("(\\()(TYPE: )(.*?)(, )(VALUE: )(.*?)(\\))");

    // ERRORS:
    private static final Pattern MESSAGE_EXCEPTION_RAISED_FROM_REGEX_PATTERN = Pattern
            .compile("(Exception raised from .*?:) ((?s).*)");
    private static final Pattern MESSAGE_EXCEPTION_THROWN_FROM_COMPONENT_REGEX_PATTERN = Pattern
            .compile("(Exception thrown from component: .*?:) ((?s).*)");
    private static final Pattern MESSAGE_RAISING_ERROR_REGEX_PATTERN = Pattern
            .compile("(\\*\\*\\* RAISING ERROR) (.*)");
    private static final Pattern MESSAGE_THROWING_NOT_FOUND_EXCEPTION_REGEX_PATTERN = Pattern
            .compile("Throwing NotFoundException");

    // ARGUMENTS:
    private static final Pattern MESSAGE_PUBLISHED_REGEX_PATTERN = Pattern
            .compile("(Published) (.*)(=)(.*) (\\(.*\\))");
    private static final Pattern MESSAGE_ARGUMENT_REGEX_PATTERN = Pattern.compile("(Argument) (.*)(=)(.*) (\\(.*\\))");

    // OTHER:
    private static final Pattern MESSAGE_SERVER_ACTIVITY_SUMMARY_REGEX_PATTERN = Pattern
            .compile("\\[(.*?)\\] \\[(.*?)\\] \\[(.*?)\\] \\[(.*?)\\] \\[(.*?)\\]");
    private static final Pattern MESSAGE_RETURNING_X_ROWS_REGEX_PATTERN = Pattern
            .compile("(Returning) ([0-9]+) (row\\(s\\))");
    private static final Pattern MESSAGE_QUERY_RETURNED_X_ROWS_REGEX_PATTERN = Pattern
            .compile("(Query returned) ([0-9]+) (rows)");
    private static final Pattern MESSAGE_EXECUTION_TIME_REGEX_PATTERN = Pattern
            .compile("(Execute Time:) ([0-9.]+) (s)");

    private int lineNum;
    private StringBuilder lineTextBuffer;
    public ArrayList<String> absoluteTraceLines;
    public HashMap<String, ArrayList<String>> relativeTraceLinesMap;
    public HashMap<String, Stack<TraceStackFrame>> indentStackMap;
    public HashMap<String, ArrayList<TraceStackFrame>> outlineMap;
    public HashMap<String, Integer> previousStackLevelMap;
    public HashMap<String, HashMap<String, String>> publishedMap;
    public HashMap<String, HashMap<String, String>> argumentsMap;
    public HashMap<String, ArrayList<String>> flowsMap;

    public TraceOutliner() {
        this.lineNum = -1;
        this.lineTextBuffer = new StringBuilder(2048);
        this.absoluteTraceLines = new ArrayList<>();
        this.relativeTraceLinesMap = new HashMap<>();
        this.indentStackMap = new HashMap<>();
        this.outlineMap = new HashMap<>();
        this.previousStackLevelMap = new HashMap<>();
        this.publishedMap = new HashMap<>();
        this.argumentsMap = new HashMap<>();
        this.flowsMap = new HashMap<>();

    }

    private static void processUnindent(Stack<TraceStackFrame> indentStack, int stackLevel,
            ArrayList<TraceStackFrame> outline) {

        if (indentStack.size() == 0) {
            return;
        }

        if (indentStack.peek().isCommandStatementOrNestedBraces) {
            int beginIndentStackSize = indentStack.size();
            while (indentStack.peek().stackLevel >= stackLevel && indentStack.size() > 1
                    && indentStack.peek().isCommandStatementOrNestedBraces) {
                TraceStackFrame poppedFrame = indentStack.pop();

                outline.add(new TraceStackFrame(poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                        poppedFrame.relativeLineNum, "}", "0", true, getIndentString(indentStack), indentStack));
            }

            if (beginIndentStackSize > indentStack.size() && indentStack.peek().isCommandStatementOrNestedBraces) {
                TraceStackFrame poppedFrame = indentStack.pop();

                outline.add(new TraceStackFrame(poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                        poppedFrame.relativeLineNum, "}", "0", true, getIndentString(indentStack), indentStack));

                processUnindent(indentStack, stackLevel, outline);
            } else {
                if (indentStack.peek().isCommandStatementOrNestedBraces) {

                    int prevLvl = outline.get(outline.size() - 1).stackLevel;
                    if (prevLvl == stackLevel) {
                        // Need to check if we are just seeing same stack level again due to
                        // multiple rows returned from previous stack frame instruction.
                        for (int i = outline.size() - 1, rowCount = 1; i >= 0; i--, rowCount++) {
                            if (outline.get(i).stackLevel < stackLevel) {
                                if (outline.get(i).returnedRows >= rowCount) {
                                    return;
                                } else {
                                    break;
                                }
                            }
                        }

                        TraceStackFrame poppedFrame = indentStack.pop();

                        outline.add(new TraceStackFrame(poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                                poppedFrame.relativeLineNum, "}", "0", true, getIndentString(indentStack),
                                indentStack));

                        processUnindent(indentStack, stackLevel, outline);

                    } else if (prevLvl > stackLevel && indentStack.peek().stackLevel >= stackLevel - 1) {

                        TraceStackFrame poppedFrame = indentStack.pop();

                        outline.add(new TraceStackFrame(poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                                poppedFrame.relativeLineNum, "}", "0", true, getIndentString(indentStack),
                                indentStack));

                        processUnindent(indentStack, stackLevel, outline);
                    }
                }
            }
        } else {
            if (indentStack.peek().isCommandInitiated && outline.get(outline.size() - 1).stackLevel > stackLevel
                    && indentStack.peek().stackLevel >= stackLevel) {
                indentStack.pop();

                processUnindent(indentStack, stackLevel, outline);
            }
        }
    }

    private static String getIndentString(Stack<TraceStackFrame> indentStack) {
        StringBuilder buf = new StringBuilder(indentStack.size());
        for (int i = 0; i < indentStack.size(); i++) {
            buf.append('\t');
        }
        return buf.toString();
    }

    public void readLine(int lineNum, String lineText) {

        // We are passing the trace file contents line by line into this function. For
        // the most part, a line represents a perfect match via our trace line regex
        // pattern. This is not the case though if the 'message' capture group extends
        // multiple lines.
        // Therefore, we are keeping a line buffer member and are using it to resolve
        // this issue. If we have a perfect match, we need to process the line and clear
        // out the line buffer. If we do not, we need to hold off on processing line
        // until the line is 'complete' and we have a perfect regex match.

        // The lineNum member will be in line with how we are processing lines ^.
        if (this.lineTextBuffer.length() == 0) {
            this.lineNum = lineNum;
        }
        this.lineTextBuffer.append(lineText);

        Matcher traceLineMatcher = TraceOutliner.TRACE_LINE_REGEX_PATTERN.matcher(this.lineTextBuffer.toString());

        if (traceLineMatcher.find()) {

            // Add to absolute trace line list now.
            this.absoluteTraceLines.add(this.lineTextBuffer.toString());

            String thread = traceLineMatcher.group(TraceOutliner.TRACE_LINE_REGEX_THREAD_GROUP_IDX);
            String session = traceLineMatcher.group(TraceOutliner.TRACE_LINE_REGEX_SESSION_GROUP_IDX);
            String logger = traceLineMatcher.group(TraceOutliner.TRACE_LINE_REGEX_LOGGER_GROUP_IDX);

            // We need to make sure we are adding to the correct buffer/stack/lines for
            // thread:session combo.
            String key = String.format("Thread: %s  Session: %s", thread, session);

            // Relative line number refers to line num relative to thread:session combo.
            int relativeLineNum;
            if (this.relativeTraceLinesMap.containsKey(key)) {
                ArrayList<String> relativeLines = this.relativeTraceLinesMap.get(key);
                relativeLines.add(this.lineTextBuffer.toString());
                relativeLineNum = relativeLines.size();
            } else {
                ArrayList<String> relativeLines = new ArrayList<>();
                relativeLines.add(this.lineTextBuffer.toString());
                this.relativeTraceLinesMap.put(key, relativeLines);
                relativeLineNum = relativeLines.size();
            }

            // Check if ignored logger.
            boolean ignoreLogger = true;
            for (String _logger : TraceOutliner.LOGGERS) {
                if (logger.compareTo(_logger) == 0) {
                    ignoreLogger = false;
                    break;
                }
            }

            if (!ignoreLogger) {

                int stackLevel = Integer
                        .parseInt(traceLineMatcher.group(TraceOutliner.TRACE_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
                String message = traceLineMatcher.group(TraceOutliner.TRACE_LINE_REGEX_MESSAGE_GROUP_IDX);

                Stack<TraceStackFrame> indentStack;
                if (this.indentStackMap.containsKey(key)) {
                    indentStack = this.indentStackMap.get(key);
                } else {
                    indentStack = new Stack<>();
                    this.indentStackMap.put(key, indentStack);
                }
                ArrayList<TraceStackFrame> outline;
                if (this.outlineMap.containsKey(key)) {
                    outline = this.outlineMap.get(key);
                } else {
                    outline = new ArrayList<>();
                    this.outlineMap.put(key, outline);
                }
                HashMap<String, String> published;
                if (this.publishedMap.containsKey(key)) {
                    published = this.publishedMap.get(key);
                } else {
                    published = new HashMap<>();
                    this.publishedMap.put(key, published);
                }
                HashMap<String, String> arguments;
                if (this.argumentsMap.containsKey(key)) {
                    arguments = this.argumentsMap.get(key);
                } else {
                    arguments = new HashMap<>();
                    this.argumentsMap.put(key, arguments);
                }
                ArrayList<String> flows;
                if (this.flowsMap.containsKey(key)) {
                    flows = this.flowsMap.get(key);
                } else {
                    flows = new ArrayList<>();
                    this.flowsMap.put(key, flows);
                }

                // If we come across trace stack start/end cues, we need to clear the stack and
                // get ready for a new one.
                if (message.compareToIgnoreCase(TraceOutliner.MESSAGE_TRACE_STACK_START_TEXT) == 0) {
                    indentStack.clear();
                } else if (message.compareToIgnoreCase(TraceOutliner.MESSAGE_TRACE_STACK_END_TEXT) == 0) {
                    indentStack.clear();
                } else {

                    // Handle scenario where stack level goes down/comes up multiple levels. This
                    // happens due to extra "{}" either because of "try" block or nesting "{}".
                    // Ex: 1 -> 3 OR 3 -> 1
                    // Indenting via "{}" below for organization purposes and to illustrate exactly
                    // what we are looking for in the trace -- lol.
                    {
                        this.previousStackLevelMap.get(key);
                        if (this.previousStackLevelMap.containsKey(key)) {
                            int previousStackLevel = this.previousStackLevelMap.get(key);
                            if (previousStackLevel < stackLevel) { // Going down (1 -> 3).
                                int p = previousStackLevel;
                                while (p < stackLevel - 1) {
                                    outline.add(new TraceStackFrame(p + 1, lineNum, relativeLineNum, "{", "0", true,
                                            getIndentString(indentStack), indentStack));
                                    indentStack.push(outline.get(outline.size() - 1));
                                    p++;
                                }
                            } else if (previousStackLevel > stackLevel) { // Coming up (3 -> 1).
                                if (previousStackLevel > stackLevel + 1
                                        && indentStack.peek().isCommandStatementOrNestedBraces
                                        && indentStack.peek().instruction == "{") {
                                    processUnindent(indentStack, stackLevel, outline);
                                }
                            }

                            // We also need to process published/argument argument stack level change.
                            if (previousStackLevel != stackLevel) {
                                published.clear();
                                arguments.clear();
                                flows.clear();
                            }

                        }

                        this.previousStackLevelMap.put(key, stackLevel);
                    }

                    Matcher matcher;

                    // SERVER GOT:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = TraceOutliner.MESSAGE_SERVER_GOT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        indentStack.clear();

                        String instruction = matcher.group(2).trim().replace('\n', ' ');

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                "", indentStack));
                        outline.get(outline.size() - 1).isServerGot = true;

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    // COMMAND INITIATED:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = TraceOutliner.MESSAGE_COMMAND_INITIATED_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        String instruction = matcher.group(3).trim().replace('\n', ' ');

                        if (stackLevel == 0) {

                            indentStack.clear();

                            outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0",
                                    false, "", indentStack));
                            outline.get(outline.size() - 1).isCommandInitiated = true;

                            indentStack.push(outline.get(outline.size() - 1));
                        } else {

                            processUnindent(indentStack, stackLevel, outline);

                            outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0",
                                    false, getIndentString(indentStack), indentStack));
                            outline.get(outline.size() - 1).isCommandInitiated = true;

                            indentStack.push(outline.get(outline.size() - 1));
                        }
                    }

                    // MOCA:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = TraceOutliner.MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String[] instructionArr = matcher.group(2).trim().split("/");
                        String cmplvl = instructionArr[0];
                        String instruction = instructionArr[1];

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).componentLevel = cmplvl;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = TraceOutliner.MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        if (indentStack.size() > 0) {
                            indentStack.pop();
                        }

                    }

                    matcher = TraceOutliner.MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()
                            && !TraceOutliner.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message).find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "Firing Triggers:" + matcher.group(2);

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isFiringTriggers = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = TraceOutliner.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        indentStack.pop();
                    }

                    matcher = TraceOutliner.MESSAGE_EXECUTING_COMMAND_ON_REMOTE_HOST_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "remote" + matcher.group(2) + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = TraceOutliner.MESSAGE_REMOTE_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        if (indentStack.size() > 0) {
                            indentStack.pop();
                        }
                    }

                    matcher = TraceOutliner.MESSAGE_EXECUTING_PARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "parallel" + matcher.group(2) + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = TraceOutliner.MESSAGE_EXECUTING_INPARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "inparallel" + matcher.group(2)
                                + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = TraceOutliner.MESSAGE_PARALLEL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        if (indentStack.size() > 0) {
                            indentStack.pop();
                        }
                    }

                    // SQL:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = TraceOutliner.MESSAGE_EXECUTING_SQL_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "[" + matcher.group(2).trim().replace('\n', ' ') + "]";

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);
                    }

                    matcher = TraceOutliner.MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                    }

                    matcher = TraceOutliner.MESSAGE_PREPAREDSTATEMENT_EXECUTE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "[" + matcher.group(3).trim().replace('\n', ' ') + "]";

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isPreparedStatement = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);
                    }

                    matcher = TraceOutliner.MESSAGE_PREPAREDSTATEMENT_CLOSE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                    }

                    // GROOVY:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = TraceOutliner.MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "[[ Groovy ]]";

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", false,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = TraceOutliner.MESSAGE_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        indentStack.pop();
                    }

                    // COMMAND STATEMENTS:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = TraceOutliner.MESSAGE_EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        if (indentStack.size() > 0 && indentStack.peek().isCommandStatementOrNestedBraces
                                && outline.get(outline.size() - 2).instruction.compareTo("else") == 0) {
                            // ^^^ -2 since we added an outline entry for "{".

                            // Get rid of preemptive indent.
                            indentStack.pop();
                            // Get rid of outline entry "{".
                            outline.remove(outline.size() - 1);

                            String appendInstruction;

                            String conditionalTest = matcher.group(2);

                            Matcher extractConditionalTestValuesMatcher = TraceOutliner.EXTRACT_CONDITIONAL_TEST_VALUES
                                    .matcher(conditionalTest);

                            while (extractConditionalTestValuesMatcher.find()) {
                                String entireGroup = extractConditionalTestValuesMatcher.group(0);
                                String type = extractConditionalTestValuesMatcher.group(3);
                                String value = extractConditionalTestValuesMatcher.group(6);

                                switch (type) {
                                    case "STRING":
                                        value = "'" + value + "'";
                                        break;
                                    default:
                                        break;
                                }

                                conditionalTest = conditionalTest.replace(entireGroup, value);
                            }

                            appendInstruction = " if (" + conditionalTest + ")";

                            outline.get(outline.size() - 1).instruction += appendInstruction;

                        } else {

                            processUnindent(indentStack, stackLevel, outline);

                            String instruction;

                            String conditionalTest = matcher.group(2);

                            Matcher extractConditionalTestValuesMatcher = TraceOutliner.EXTRACT_CONDITIONAL_TEST_VALUES
                                    .matcher(conditionalTest);

                            while (extractConditionalTestValuesMatcher.find()) {
                                String entireGroup = extractConditionalTestValuesMatcher.group(0);
                                String type = extractConditionalTestValuesMatcher.group(3);
                                String value = extractConditionalTestValuesMatcher.group(6);

                                switch (type) {
                                    case "STRING":
                                        value = "'" + value + "'";
                                        break;
                                    default:
                                        break;
                                }

                                conditionalTest = conditionalTest.replace(entireGroup, value);
                            }

                            instruction = "if (" + conditionalTest + ")";

                            outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0",
                                    true, getIndentString(indentStack), indentStack));
                            outline.get(outline.size() - 1).published = published;
                            outline.get(outline.size() - 1).arguments = arguments;

                        }
                    }

                    matcher = TraceOutliner.MESSAGE_IF_TEST_PASSED_EXECUTING_IF_BLOCK_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).instructionStatus = "Passed";

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, "{", "0", true,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = TraceOutliner.MESSAGE_IF_TEST_FAILED_NO_ELSE_BLOCK_TO_EXECUTE_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).instructionStatus = "Failed";

                    }

                    matcher = TraceOutliner.MESSAGE_IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).instructionStatus = "Failed";

                        String instruction = "else";

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", true,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, "{", "0", true,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = TraceOutliner.MESSAGE_EVALUATING_TRY_CATCH_EXPRESSION_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        String conditionalTest = matcher.group(2);

                        Matcher extractConditionalTestValuesMatcher = TraceOutliner.EXTRACT_CONDITIONAL_TEST_VALUES
                                .matcher(conditionalTest);

                        while (extractConditionalTestValuesMatcher.find()) {
                            String entireGroup = extractConditionalTestValuesMatcher.group(0);
                            String type = extractConditionalTestValuesMatcher.group(3);
                            String value = extractConditionalTestValuesMatcher.group(6);

                            switch (type) {
                                case "STRING":
                                    value = "'" + value + "'";
                                    break;
                                default:
                                    break;
                            }

                            conditionalTest = conditionalTest.replace(entireGroup, value);
                        }

                        // May have to go back a few frames to find the correct stack frame.
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            // Should not be prepared statement.
                            if (!outline.get(i).isPreparedStatement) {
                                outline.get(i).instructionStatus = "Caught (" + conditionalTest + ")";
                                break;
                            }
                        }
                    }

                    matcher = TraceOutliner.MESSAGE_CATCH_CONDITION_MET_EXECUTING_CATCH_BLOCK_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                    }

                    matcher = TraceOutliner.MESSAGE_EXECUTING_FINALLY_BLOCK_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline);

                        String instruction = "finally";

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, instruction, "0", true,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        outline.add(new TraceStackFrame(stackLevel, lineNum, relativeLineNum, "{", "0", true,
                                getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        outline.get(outline.size() - 1).flows.addAll(flows);

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    // ERRORS:
                    // -----------------------------------------------------------------------------------------------------------------

                    // For errors(for the most part), we need to look back through outline entries
                    // and find the right outline instruction status to assign error to.
                    matcher = TraceOutliner.MESSAGE_EXCEPTION_RAISED_FROM_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (stackLevel == outline.get(i).stackLevel && !outline.get(i).isCommandInitiated) {
                                outline.get(i).instructionStatus = matcher.group(2);
                                break;
                            }
                        }
                    }

                    matcher = TraceOutliner.MESSAGE_EXCEPTION_THROWN_FROM_COMPONENT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).instructionStatus = matcher.group(2);
                    }

                    // This error should only come up after a MOCA command fails.
                    matcher = TraceOutliner.MESSAGE_RAISING_ERROR_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (stackLevel == outline.get(i).stackLevel && outline.get(i).componentLevel != null) {
                                outline.get(i).instructionStatus = "-1403";
                                break;
                            }
                        }
                    }

                    matcher = TraceOutliner.MESSAGE_THROWING_NOT_FOUND_EXCEPTION_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (stackLevel == outline.get(i).stackLevel && !outline.get(i).isCommandInitiated) {
                                outline.get(i).instructionStatus = "-1403";
                                break;
                            }
                        }
                    }

                    // ARGUMENTS:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = TraceOutliner.MESSAGE_PUBLISHED_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        published.put(matcher.group(2), matcher.group(4));
                    }

                    matcher = TraceOutliner.MESSAGE_ARGUMENT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        arguments.put(matcher.group(2), matcher.group(4));
                    }

                    // OTHER:
                    // -----------------------------------------------------------------------------------------------------------------

                    // ServerActivity logger has some good messages we can use.
                    if (logger.compareTo("ServerActivity") == 0) {

                        matcher = TraceOutliner.MESSAGE_SERVER_ACTIVITY_SUMMARY_REGEX_PATTERN.matcher(message);
                        if (matcher.find()) {
                            /*
                             * Example message: [MCSbase/list warehouses] [{}] [0.002] [0] [6]
                             * 
                             * Group 1: command, Group 2: args, Group 3: performance, Group 4: status, Group
                             * 5: rows
                             */

                            // Segregate cmplvl and command, then find matching outline entry.
                            String[] instructionArr = matcher.group(1).trim().split("/");
                            String cmplvl = instructionArr[0];
                            String instruction = instructionArr[1];

                            for (int i = outline.size() - 1; i >= 0; i--) {
                                if (outline.get(i).stackLevel == stackLevel
                                        && outline.get(i).instruction.compareTo(instruction) == 0
                                        && outline.get(i).componentLevel.compareTo(cmplvl) == 0) {
                                    outline.get(i).executionTime = Double.parseDouble(matcher.group(3));
                                    if (outline.get(i).instructionStatus.isEmpty()) {
                                        outline.get(i).instructionStatus = matcher.group(4);
                                    }
                                    outline.get(i).returnedRows = Integer.parseInt(matcher.group(5));

                                    break;
                                }
                            }

                        }
                    }

                    // Seems like we only see this in regards to the "Server got:" match.
                    matcher = TraceOutliner.MESSAGE_RETURNING_X_ROWS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        // Go back to last server got instruction.
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (outline.get(i).isServerGot) {
                                outline.get(i).returnedRows = Integer.parseInt(matcher.group(2));
                                break;
                            }
                        }
                    }

                    // This one should just be in regards to JDBCApapter queries.
                    matcher = TraceOutliner.MESSAGE_QUERY_RETURNED_X_ROWS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).returnedRows = Integer.parseInt(matcher.group(2));
                    }

                    matcher = TraceOutliner.MESSAGE_EXECUTION_TIME_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).executionTime = Double.parseDouble(matcher.group(2));
                    }

                    // Add FLOW messages.
                    if (logger.compareToIgnoreCase("FLOW") == 0) {
                        flows.add(message);
                    }
                }
            }

            // Need to clear line text buf for next read line call.
            this.lineTextBuffer.setLength(0);
        }

    }

}
