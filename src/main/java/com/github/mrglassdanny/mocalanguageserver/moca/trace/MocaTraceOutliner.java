package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;

public class MocaTraceOutliner {

    private static final Pattern TRACE_LINE_REGEX_PATTERN = Pattern.compile(
            "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) (TRACE|DEBUG|INFO |WARN |ERROR|FATAL) \\[(\\d+)[ ]+(.*?)\\] (.+?) \\[(\\d{1,3})\\] ([\\s\\S]*) \\[[\\s\\S]*\\](.*)");

    private static final int TRACE_LINE_REGEX_THREAD_GROUP_IDX = 3;
    private static final int TRACE_LINE_REGEX_SESSION_GROUP_IDX = 4;
    private static final int TRACE_LINE_REGEX_LOGGER_GROUP_IDX = 5;
    private static final int TRACE_LINE_REGEX_STACK_LEVEL_GROUP_IDX = 6;
    private static final int TRACE_LINE_REGEX_MESSAGE_GROUP_IDX = 7;

    // There are a select few loggers that we actually care to analyze.
    private static final String[] LOGGERS = { "Argument", "CommandStatement", "DefaultServerContext", "JDBCAdapter",
            "Performance", "CommandDispatcher", "MocaTransactionManager", "GroovyScriptAdapter", "ComponentAdapter",
            "ServerActivity" };

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
            .compile("(Firing triggers\\.\\.\\.)    (\\()((?s).*)(\\))");
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
    private static final Pattern MESSAGE_EXECUTING_SQL_REGEX_PATTERN = Pattern.compile("(UNBIND:) ((?s).*)");
    private static final Pattern MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile("SQL execution completed");
    private static final Pattern MESSAGE_CONNECTION_PREPARESTATEMENT_REGEX_PATTERN = Pattern
            .compile("(Connection.prepareStatement(.*?\\())((?s).*)(\\))");
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

    private static int lineNum;
    private static StringBuilder lineTextBuffer;
    private static ArrayList<String> absoluteTraceLines;
    private static HashMap<String, ArrayList<String>> relativeTraceLinesMap;
    private static HashMap<String, ArrayList<MocaTraceStackFrame>> outlineMap;
    private static ArrayList<String> orderedOutlineIds; // Outline IDs stored in the order in which we come across them.
                                                        // HashMaps do not order outlines this way.
    private static HashMap<String, Stack<MocaTraceStackFrame>> indentStackMap;
    private static HashMap<String, Integer> previousStackLevelMap;
    private static HashMap<String, HashMap<String, String>> publishedMap;
    private static HashMap<String, HashMap<String, String>> argumentsMap;

    private static void processUnindent(Stack<MocaTraceStackFrame> indentStack, int stackLevel,
            ArrayList<MocaTraceStackFrame> outline, String outlineId) {

        if (indentStack.size() == 0) {
            return;
        }

        if (indentStack.peek().isCommandStatementOrNestedBraces) {
            int beginIndentStackSize = indentStack.size();
            while (indentStack.peek().stackLevel >= stackLevel && indentStack.size() > 1
                    && indentStack.peek().isCommandStatementOrNestedBraces) {
                MocaTraceStackFrame poppedFrame = indentStack.pop();

                outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                        poppedFrame.relativeLineNum, "}", "0", true, getIndentString(indentStack), indentStack));
            }

            if (beginIndentStackSize > indentStack.size() && indentStack.peek().isCommandStatementOrNestedBraces) {
                MocaTraceStackFrame poppedFrame = indentStack.pop();

                outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                        poppedFrame.relativeLineNum, "}", "0", true, getIndentString(indentStack), indentStack));

                processUnindent(indentStack, stackLevel, outline, outlineId);
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

                        MocaTraceStackFrame poppedFrame = indentStack.pop();

                        outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel,
                                poppedFrame.absoluteLineNum, poppedFrame.relativeLineNum, "}", "0", true,
                                getIndentString(indentStack), indentStack));

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                    } else if (prevLvl > stackLevel && indentStack.peek().stackLevel >= stackLevel - 1) {

                        MocaTraceStackFrame poppedFrame = indentStack.pop();

                        outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel,
                                poppedFrame.absoluteLineNum, poppedFrame.relativeLineNum, "}", "0", true,
                                getIndentString(indentStack), indentStack));

                        processUnindent(indentStack, stackLevel, outline, outlineId);
                    }
                }
            }
        } else {
            if (indentStack.peek().isCommandInitiated && outline.get(outline.size() - 1).stackLevel > stackLevel
                    && indentStack.peek().stackLevel >= stackLevel) {
                indentStack.pop();

                processUnindent(indentStack, stackLevel, outline, outlineId);
            }
        }
    }

    private static String getIndentString(Stack<MocaTraceStackFrame> indentStack) {
        StringBuilder buf = new StringBuilder(indentStack.size());
        for (int i = 0; i < indentStack.size(); i++) {
            buf.append('\t');
        }
        return buf.toString();
    }

    private static void readLine(int lineNum, String lineText) {

        // We are passing the trace file contents line by line into MocaTraceOutliner
        // function. For
        // the most part, a line represents a perfect match via our trace line regex
        // pattern. MocaTraceOutliner is not the case though if the 'message' capture
        // group extends
        // multiple lines.
        // Therefore, we are keeping a line buffer member and are using it to resolve
        // MocaTraceOutliner issue. If we have a perfect match, we need to process the
        // line and clear
        // out the line buffer. If we do not, we need to hold off on processing line
        // until the line is 'complete' and we have a perfect regex match.

        // The lineNum member will be in line with how we are processing lines ^.
        if (MocaTraceOutliner.lineTextBuffer.length() == 0) {
            MocaTraceOutliner.lineNum = lineNum;
        }

        // Add newline if needed.
        if (MocaTraceOutliner.lineTextBuffer.length() > 0) {
            MocaTraceOutliner.lineTextBuffer.append('\n');
            // Need to increment line number since we are adding a newline.
            lineNum++;
        }
        MocaTraceOutliner.lineTextBuffer.append(lineText);

        Matcher traceLineMatcher = MocaTraceOutliner.TRACE_LINE_REGEX_PATTERN
                .matcher(MocaTraceOutliner.lineTextBuffer.toString());

        if (traceLineMatcher.find()) {

            // Add to absolute trace line list now.
            MocaTraceOutliner.absoluteTraceLines.add(MocaTraceOutliner.lineTextBuffer.toString());

            String thread = traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_THREAD_GROUP_IDX);
            String session = traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_SESSION_GROUP_IDX);
            String logger = traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_LOGGER_GROUP_IDX);

            // We need to make sure we are adding to the correct buffer/stack/lines for
            // thread & session combo. This will be the outline's ID.
            String outlineId = String.format("%s-%s", thread, session);

            // When we come across a new outline, add it to ordered list.
            if (!MocaTraceOutliner.orderedOutlineIds.contains(outlineId)) {
                MocaTraceOutliner.orderedOutlineIds.add(outlineId);
            }

            // Relative line number refers to line num relative to outline ID.
            int relativeLineNum;
            if (MocaTraceOutliner.relativeTraceLinesMap.containsKey(outlineId)) {
                ArrayList<String> relativeLines = MocaTraceOutliner.relativeTraceLinesMap.get(outlineId);
                relativeLines.add(MocaTraceOutliner.lineTextBuffer.toString());
                relativeLineNum = relativeLines.size();
            } else {
                ArrayList<String> relativeLines = new ArrayList<>();
                relativeLines.add(MocaTraceOutliner.lineTextBuffer.toString());
                MocaTraceOutliner.relativeTraceLinesMap.put(outlineId, relativeLines);
                relativeLineNum = relativeLines.size();
            }

            // Check if ignored logger.
            boolean ignoreLogger = true;
            for (String _logger : MocaTraceOutliner.LOGGERS) {
                if (logger.compareTo(_logger) == 0) {
                    ignoreLogger = false;
                    break;
                }
            }

            if (!ignoreLogger) {

                int stackLevel = Integer
                        .parseInt(traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
                String message = traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_MESSAGE_GROUP_IDX);

                Stack<MocaTraceStackFrame> indentStack;
                if (MocaTraceOutliner.indentStackMap.containsKey(outlineId)) {
                    indentStack = MocaTraceOutliner.indentStackMap.get(outlineId);
                } else {
                    indentStack = new Stack<>();
                    MocaTraceOutliner.indentStackMap.put(outlineId, indentStack);
                }
                ArrayList<MocaTraceStackFrame> outline;
                if (MocaTraceOutliner.outlineMap.containsKey(outlineId)) {
                    outline = MocaTraceOutliner.outlineMap.get(outlineId);
                } else {
                    outline = new ArrayList<>();
                    MocaTraceOutliner.outlineMap.put(outlineId, outline);
                }
                HashMap<String, String> published;
                if (MocaTraceOutliner.publishedMap.containsKey(outlineId)) {
                    published = MocaTraceOutliner.publishedMap.get(outlineId);
                } else {
                    published = new HashMap<>();
                    MocaTraceOutliner.publishedMap.put(outlineId, published);
                }
                HashMap<String, String> arguments;
                if (MocaTraceOutliner.argumentsMap.containsKey(outlineId)) {
                    arguments = MocaTraceOutliner.argumentsMap.get(outlineId);
                } else {
                    arguments = new HashMap<>();
                    MocaTraceOutliner.argumentsMap.put(outlineId, arguments);
                }

                // If we come across trace stack start/end cues, we need to clear the stack and
                // get ready for a new one.
                if (message.compareToIgnoreCase(MocaTraceOutliner.MESSAGE_TRACE_STACK_START_TEXT) == 0) {
                    indentStack.clear();
                } else if (message.compareToIgnoreCase(MocaTraceOutliner.MESSAGE_TRACE_STACK_END_TEXT) == 0) {
                    indentStack.clear();
                } else {

                    // Handle scenario where stack level goes down/comes up multiple levels.
                    // MocaTraceOutliner
                    // happens due to extra "{}" either because of "try" block or nesting "{}".
                    // Ex: 1 -> 3 OR 3 -> 1
                    // Indenting via "{}" below for organization purposes and to illustrate exactly
                    // what we are looking for in the trace -- lol.
                    {
                        MocaTraceOutliner.previousStackLevelMap.get(outlineId);
                        if (MocaTraceOutliner.previousStackLevelMap.containsKey(outlineId)) {
                            int previousStackLevel = MocaTraceOutliner.previousStackLevelMap.get(outlineId);
                            if (previousStackLevel < stackLevel) { // Going down (1 -> 3).
                                int p = previousStackLevel;
                                while (p < stackLevel - 1) {
                                    outline.add(new MocaTraceStackFrame(outlineId, p + 1, lineNum, relativeLineNum, "{",
                                            "0", true, getIndentString(indentStack), indentStack));
                                    indentStack.push(outline.get(outline.size() - 1));
                                    p++;
                                }
                            } else if (previousStackLevel > stackLevel) { // Coming up (3 -> 1).
                                if (previousStackLevel > stackLevel + 1 && indentStack.size() > 0
                                        && indentStack.peek().isCommandStatementOrNestedBraces
                                        && indentStack.peek().instruction == "{") {
                                    processUnindent(indentStack, stackLevel, outline, outlineId);
                                }
                            }

                            // We also need to process published/argument argument stack level change.
                            if (previousStackLevel != stackLevel) {
                                published.clear();
                                arguments.clear();
                            }

                        }

                        MocaTraceOutliner.previousStackLevelMap.put(outlineId, stackLevel);
                    }

                    Matcher matcher;

                    // SERVER GOT:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_SERVER_GOT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        indentStack.clear();

                        String instruction = matcher.group(2).trim().replace('\n', ' ');

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, "", indentStack));
                        outline.get(outline.size() - 1).isServerGot = true;

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    // COMMAND INITIATED:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_COMMAND_INITIATED_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        String instruction = matcher.group(3).trim().replace('\n', ' ');

                        if (stackLevel == 0) {

                            indentStack.clear();

                            outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                    instruction, "0", false, "", indentStack));
                            outline.get(outline.size() - 1).isCommandInitiated = true;

                            indentStack.push(outline.get(outline.size() - 1));
                        } else {

                            processUnindent(indentStack, stackLevel, outline, outlineId);

                            outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                    instruction, "0", false, getIndentString(indentStack), indentStack));
                            outline.get(outline.size() - 1).isCommandInitiated = true;

                            indentStack.push(outline.get(outline.size() - 1));
                        }
                    }

                    // MOCA:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String[] instructionArr = matcher.group(2).trim().split("/");
                        String cmplvl = instructionArr[0];
                        String instruction = instructionArr[1];

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).componentLevel = cmplvl;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        if (indentStack.size() > 0) {
                            indentStack.pop();
                        }

                    }

                    matcher = MocaTraceOutliner.MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()
                            && !MocaTraceOutliner.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message).find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = matcher.group(3);

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isFiringTriggers = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        indentStack.pop();
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_COMMAND_ON_REMOTE_HOST_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = "remote" + matcher.group(2) + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_REMOTE_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        if (indentStack.size() > 0) {
                            indentStack.pop();
                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_PARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = "parallel" + matcher.group(2) + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_INPARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = "inparallel" + matcher.group(2)
                                + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_PARALLEL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        if (indentStack.size() > 0) {
                            indentStack.pop();
                        }
                    }

                    // SQL:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_SQL_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = "[" + matcher.group(2).trim().replace('\n', ' ') + "]";

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                    }

                    matcher = MocaTraceOutliner.MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                    }

                    matcher = MocaTraceOutliner.MESSAGE_CONNECTION_PREPARESTATEMENT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = "[" + matcher.group(3).trim().replace('\n', ' ').replace("?", "'<var>'")
                                + "]";

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).isPreparedStatement = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                    }

                    matcher = MocaTraceOutliner.MESSAGE_PREPAREDSTATEMENT_EXECUTE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).actualPreparedStatementQuery = "["
                                + matcher.group(3).trim().replace('\n', ' ') + "]";
                    }

                    matcher = MocaTraceOutliner.MESSAGE_PREPAREDSTATEMENT_CLOSE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                    }

                    // GROOVY:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = "[[ /* Groovy */ ]]";

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        indentStack.pop();
                    }

                    // COMMAND STATEMENTS:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN.matcher(message);
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

                            Matcher extractConditionalTestValuesMatcher = MocaTraceOutliner.EXTRACT_CONDITIONAL_TEST_VALUES
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

                            processUnindent(indentStack, stackLevel, outline, outlineId);

                            String instruction;

                            String conditionalTest = matcher.group(2);

                            Matcher extractConditionalTestValuesMatcher = MocaTraceOutliner.EXTRACT_CONDITIONAL_TEST_VALUES
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

                            outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                    instruction, "0", true, getIndentString(indentStack), indentStack));
                            outline.get(outline.size() - 1).published.putAll(published);
                            outline.get(outline.size() - 1).arguments.putAll(arguments);
                            published.clear();
                            arguments.clear();

                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_IF_TEST_PASSED_EXECUTING_IF_BLOCK_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).instructionStatus = "Passed";

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, "{", "0",
                                true, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_IF_TEST_FAILED_NO_ELSE_BLOCK_TO_EXECUTE_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).instructionStatus = "Failed";

                    }

                    matcher = MocaTraceOutliner.MESSAGE_IF_TEST_FAILED_EXECUTING_ELSE_BLOCK_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).instructionStatus = "Failed";

                        String instruction = "else";

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", true, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, "{", "0",
                                true, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_EVALUATING_TRY_CATCH_EXPRESSION_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        String conditionalTest = matcher.group(2);

                        Matcher extractConditionalTestValuesMatcher = MocaTraceOutliner.EXTRACT_CONDITIONAL_TEST_VALUES
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

                    matcher = MocaTraceOutliner.MESSAGE_CATCH_CONDITION_MET_EXECUTING_CATCH_BLOCK_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_FINALLY_BLOCK_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processUnindent(indentStack, stackLevel, outline, outlineId);

                        String instruction = "finally";

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", true, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, "{", "0",
                                true, getIndentString(indentStack), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    // ERRORS:
                    // -----------------------------------------------------------------------------------------------------------------

                    // For errors(for the most part), we need to look back through outline entries
                    // and find the right outline instruction status to assign error to.
                    matcher = MocaTraceOutliner.MESSAGE_EXCEPTION_RAISED_FROM_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (stackLevel == outline.get(i).stackLevel && !outline.get(i).isCommandInitiated) {
                                outline.get(i).instructionStatus = matcher.group(2);
                                break;
                            }
                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXCEPTION_THROWN_FROM_COMPONENT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).instructionStatus = matcher.group(2);
                    }

                    // MocaTraceOutliner error should only come up after a MOCA command fails.
                    matcher = MocaTraceOutliner.MESSAGE_RAISING_ERROR_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (stackLevel == outline.get(i).stackLevel && outline.get(i).componentLevel != null) {
                                outline.get(i).instructionStatus = "-1403";
                                break;
                            }
                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_THROWING_NOT_FOUND_EXCEPTION_REGEX_PATTERN.matcher(message);
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

                    matcher = MocaTraceOutliner.MESSAGE_PUBLISHED_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        published.put(matcher.group(2), matcher.group(4));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_ARGUMENT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        arguments.put(matcher.group(2), matcher.group(4));
                    }

                    // OTHER:
                    // -----------------------------------------------------------------------------------------------------------------

                    // ServerActivity logger has some good messages we can use.
                    if (logger.compareTo("ServerActivity") == 0) {

                        matcher = MocaTraceOutliner.MESSAGE_SERVER_ACTIVITY_SUMMARY_REGEX_PATTERN.matcher(message);
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

                    // Seems like we only see MocaTraceOutliner in regards to the "Server got:"
                    // match.
                    matcher = MocaTraceOutliner.MESSAGE_RETURNING_X_ROWS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        // Go back to last server got instruction.
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (outline.get(i).isServerGot) {
                                outline.get(i).returnedRows = Integer.parseInt(matcher.group(2));
                                break;
                            }
                        }
                    }

                    // MocaTraceOutliner one should just be in regards to JDBCApapter queries.
                    matcher = MocaTraceOutliner.MESSAGE_QUERY_RETURNED_X_ROWS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).returnedRows = Integer.parseInt(matcher.group(2));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTION_TIME_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).executionTime = Double.parseDouble(matcher.group(2));
                    }
                }
            }

            // Need to clear line text buf for next read line call.
            MocaTraceOutliner.lineTextBuffer.setLength(0);
        }

    }

    public MocaTraceOutlineResult outlineTrace(String traceFileName, MocaResults res) {

        // Reset all fields.
        MocaTraceOutliner.lineNum = -1;
        MocaTraceOutliner.lineTextBuffer = new StringBuilder(2048);
        MocaTraceOutliner.absoluteTraceLines = new ArrayList<>();
        MocaTraceOutliner.relativeTraceLinesMap = new HashMap<>();
        MocaTraceOutliner.outlineMap = new HashMap<>();
        MocaTraceOutliner.orderedOutlineIds = new ArrayList<>();
        MocaTraceOutliner.indentStackMap = new HashMap<>();
        MocaTraceOutliner.previousStackLevelMap = new HashMap<>();
        MocaTraceOutliner.publishedMap = new HashMap<>();
        MocaTraceOutliner.argumentsMap = new HashMap<>();

        // Process trace outlining.
        for (int i = 1; i < res.getRowCount(); i++) {
            MocaTraceOutliner.readLine(i, res.getString(i, "text"));
        }

        // Initialize result structure and return it.
        MocaTraceOutlineResult outlineResult = new MocaTraceOutlineResult(traceFileName, MocaTraceOutliner.outlineMap,
                MocaTraceOutliner.orderedOutlineIds, MocaTraceOutliner.absoluteTraceLines,
                MocaTraceOutliner.relativeTraceLinesMap);

        return outlineResult;
    }

}
