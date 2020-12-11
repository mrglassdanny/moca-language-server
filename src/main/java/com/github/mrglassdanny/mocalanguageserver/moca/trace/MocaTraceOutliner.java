package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.io.BufferedReader;
import java.io.IOException;
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
            "ServerActivity", "CFunctionCommand" };

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
    private static final Pattern MESSAGE_RESUMING_EXECUTION_OF_REGEX_PATTERN = Pattern
            .compile("(Resuming execution of) (.*)");

    private static final Pattern MESSAGE_CALLING_C_FUNCTION_REGEX_PATTERN = Pattern
            .compile("(Calling C function) (.*)");
    private static final Pattern MESSAGE_INVOKING_METHOD_REGEX_PATTERN = Pattern.compile("(Invoking method:) (.*)");

    // SQL:
    private static final Pattern MESSAGE_EXECUTING_SQL_REGEX_PATTERN = Pattern.compile("(Executing SQL:) ((?s).*)");
    private static final Pattern MESSAGE_UNBIND_SQL_REGEX_PATTERN = Pattern.compile("(UNBIND:) ((?s).*)");
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
    private static final Pattern MESSAGE_SQL_EXCEPTION_REGEX_PATTERN = Pattern.compile("SQL Exception");

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

    private String traceFileName;
    private boolean useLogicalIndentStrategy;
    private boolean showCurlyBraces;
    private double minimumExecutionTime; // Used only for semantic highlighting.
    private int lineNum;
    private StringBuilder lineTextBuffer;
    private ArrayList<String> absoluteTraceLines;
    private HashMap<String, ArrayList<String>> relativeTraceLinesMap;
    private HashMap<String, ArrayList<MocaTraceStackFrame>> outlineMap;
    private ArrayList<String> orderedOutlineIds; // Outline IDs stored in the order in which we come across them.
                                                 // HashMaps do not order outlines this way.
    private HashMap<String, Stack<MocaTraceStackFrame>> indentStackMap;
    private HashMap<String, Integer> previousStackLevelMap;
    private HashMap<String, HashMap<String, String>> publishedMap;
    private HashMap<String, HashMap<String, String>> argumentsMap;
    private HashMap<String, Stack<ReturnedRows>> returnedRowsStackMap;

    private MocaTraceOutliner(String traceFileName, boolean useLogicalIndentStrategy, boolean showCurlyBraces,
            double minimumExecutionTime) {
        this.traceFileName = traceFileName;
        this.useLogicalIndentStrategy = useLogicalIndentStrategy;
        this.showCurlyBraces = showCurlyBraces;
        this.minimumExecutionTime = minimumExecutionTime;
        this.lineNum = 0;
        this.lineTextBuffer = new StringBuilder(2048);
        this.absoluteTraceLines = new ArrayList<>();
        this.relativeTraceLinesMap = new HashMap<>();
        this.outlineMap = new HashMap<>();
        this.orderedOutlineIds = new ArrayList<>();
        this.indentStackMap = new HashMap<>();
        this.previousStackLevelMap = new HashMap<>();
        this.publishedMap = new HashMap<>();
        this.argumentsMap = new HashMap<>();
        this.returnedRowsStackMap = new HashMap<>();
    }

    private String buildIndentString(Stack<MocaTraceStackFrame> indentStack, int stackLevel) {

        if (this.useLogicalIndentStrategy) {
            StringBuilder buf = new StringBuilder(indentStack.size());
            for (int i = 0; i < indentStack.size(); i++) {
                buf.append('\t');
            }
            return buf.toString();
        } else {
            StringBuilder buf = new StringBuilder(stackLevel);
            for (int i = 0; i < stackLevel; i++) {
                buf.append('\t');
            }
            return buf.toString();
        }
    }

    // For logical indent strategy:
    // This gets called when we have a scenario where we know we need to pop an
    // indent stack frame. "Explicit" is used here because the tell for popping
    // indent stack frames here is clear.
    private MocaTraceStackFrame processExplicitUnindentForLogicalIndentStrategy(Stack<MocaTraceStackFrame> indentStack,
            boolean checkSize) {
        if (checkSize) {
            if (indentStack.size() > 0) {
                return indentStack.pop();
            } else {
                return null;
            }
        } else {
            return indentStack.pop();
        }
    }

    // For logical indent strategy:
    // This gets called when we are not sure whether or not we need to pop an indent
    // stack frame. "Implicit" is used here because the tell for popping indent
    // stack frames here is not explicit.
    private void processImplicitUnindentForLogicalIndentStrategy(Stack<MocaTraceStackFrame> indentStack, int stackLevel,
            ArrayList<MocaTraceStackFrame> outline, String outlineId) {

        // Need to quit if no indents.
        if (indentStack.size() == 0) {
            return;
        }

        // For implicit unindentation, current indent stack frame was due to either:
        // command statement | nested braces | command initiated

        // NOTE: this function is recursive in nature.

        if (indentStack.peek().isCommandStatement) {
            // Obvious pop scenario: if last indent stack frame level is greater than
            // current stack level.
            if (indentStack.peek().stackLevel > stackLevel) {
                MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(indentStack, false);
                outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                        poppedFrame.relativeLineNum, "}", "0", true, false,
                        buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
            } else if (indentStack.peek().stackLevel == stackLevel) {
                // ^^^ it is also possible we need to pop if current indent stack frame level
                // equals current level.

                // If outline suggests that we went down and are now coming back up, we need to
                // pop.
                if (outline.get(outline.size() - 1).stackLevel > stackLevel) {
                    MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(indentStack,
                            false);
                    outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                            poppedFrame.relativeLineNum, "}", "0", true, false,
                            buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                    processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
                }
            } else {
                // ^^^ could have odd edge cases for when current indent stack frame level is
                // less than stack level.

                // Odd edge case coverage: if we are clearly coming up and our stack level is 1
                // less than current indent stack frame level, we need to pop.
                if (outline.get(outline.size() - 1).stackLevel >= stackLevel
                        && indentStack.peek().stackLevel >= stackLevel - 1) {
                    MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(indentStack,
                            false);
                    outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                            poppedFrame.relativeLineNum, "}", "0", true, false,
                            buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                    processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
                }
            }

        } else if (indentStack.peek().isNestedBraces) {
            // Obvious pop scenario: if last indent stack frame level is greater than
            // current stack level.
            if (indentStack.peek().stackLevel > stackLevel) {
                MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(indentStack, false);
                outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                        poppedFrame.relativeLineNum, "}", "0", false, true,
                        buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
            } else if (indentStack.peek().stackLevel == stackLevel) {
                // ^^^ it is also possible we need to pop if current indent stack frame level
                // equals current level.

                // If outline suggests that we went down and are now coming back up, we need to
                // pop.
                if (outline.get(outline.size() - 1).stackLevel > stackLevel) {
                    MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(indentStack,
                            false);
                    outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                            poppedFrame.relativeLineNum, "}", "0", false, true,
                            buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                    processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
                } else if (outline.get(outline.size() - 1).stackLevel == stackLevel) {
                    // Need to check if we are just seeing same stack level again due to
                    // multiple rows returned from previous stack frame instruction.
                    for (int i = outline.size() - 1, rowsSeenSoFar = 1; i >= 0; i--, rowsSeenSoFar++) {
                        if (outline.get(i).stackLevel < stackLevel) {
                            if (outline.get(i).returnedRows >= rowsSeenSoFar) {
                                return;
                            } else {
                                break;
                            }
                        }
                    }

                    // If we get here, we probably need to pop.
                    MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(indentStack,
                            false);
                    outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                            poppedFrame.relativeLineNum, "}", "0", false, true,
                            buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                    processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
                }
            } else {
                // ^^^ could have odd edge cases for when current indent stack frame level is
                // less than stack level.

                // Odd edge case coverage: if we are likely coming up and our stack level is 1
                // less than current indent stack frame level, we need to pop.
                if (outline.get(outline.size() - 1).stackLevel >= stackLevel
                        && indentStack.peek().stackLevel >= stackLevel - 1) {
                    MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(indentStack,
                            false);
                    outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel, poppedFrame.absoluteLineNum,
                            poppedFrame.relativeLineNum, "}", "0", false, true,
                            buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                    processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
                }
            }
        } else if (indentStack.peek().isCommandInitiated) {
            // Pop if we are clearly coming up from an outline and indent stack frame
            // perspective.
            if (outline.get(outline.size() - 1).stackLevel > stackLevel
                    && indentStack.peek().stackLevel >= stackLevel - 1) {
                processExplicitUnindentForLogicalIndentStrategy(indentStack, false);
                processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
            }
        } else {
            // Edge case coverage: if groovy instruction and something fails during, we will
            // get a groovy script exec complete match. Therefore, we need to look for these
            // and handle them.
            if (indentStack.peek().isGroovy && indentStack.peek().stackLevel > stackLevel) {
                processExplicitUnindentForLogicalIndentStrategy(indentStack, false);
                processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
            }
        }

    }

    private void processReturnedRowsForChild(Stack<ReturnedRows> returnedRowsStack, int stackLevel,
            MocaTraceStackFrame stackFrame) {
        if (returnedRowsStack.size() > 0) {
            if (returnedRowsStack.peek().stackLevel == stackLevel - 1) {

                returnedRowsStack.peek().visitedRows++;

                stackFrame.parentReturnedRows = returnedRowsStack.peek().totalRows;
                stackFrame.rowNumberToParent = returnedRowsStack.peek().visitedRows;

            }
        }
    }

    private void readLine(int lineNum, String lineText) {

        // We are passing the trace file contents line by line into this
        // function. For the most part, a line represents a perfect match via our trace
        // line regex pattern. This is not the case though if the 'message'
        // capture group extends multiple lines.
        // Therefore, we are keeping a line buffer member and are using it to resolve
        // this issue. If we have a perfect match, we need to process the
        // line and clear out the line buffer. If we do not, we need to hold off on
        // processing line until the line is 'complete' and we have a perfect regex
        // match.

        // The lineNum member will be in line with how we are processing lines ^.
        if (this.lineTextBuffer.length() == 0) {
            this.lineNum = lineNum;
        }

        this.lineTextBuffer.append(lineText);

        Matcher traceLineMatcher = MocaTraceOutliner.TRACE_LINE_REGEX_PATTERN.matcher(this.lineTextBuffer.toString());

        if (traceLineMatcher.find()) {

            // Add to absolute trace line list now.
            this.absoluteTraceLines.add(this.lineTextBuffer.toString());

            String thread = traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_THREAD_GROUP_IDX);
            String session = traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_SESSION_GROUP_IDX);
            String logger = traceLineMatcher.group(MocaTraceOutliner.TRACE_LINE_REGEX_LOGGER_GROUP_IDX);

            // We need to make sure we are adding to the correct buffer/stack/lines for
            // thread & session combo. This will be the outline's ID.
            String outlineId = String.format("%s-%s", thread, session);

            // When we come across a new outline, add it to ordered list.
            if (!this.orderedOutlineIds.contains(outlineId)) {
                this.orderedOutlineIds.add(outlineId);
            }

            // Relative line number refers to line num relative to outline ID.
            int relativeLineNum;
            if (this.relativeTraceLinesMap.containsKey(outlineId)) {
                ArrayList<String> relativeLines = this.relativeTraceLinesMap.get(outlineId);
                relativeLines.add(this.lineTextBuffer.toString());
                relativeLineNum = relativeLines.size();
            } else {
                ArrayList<String> relativeLines = new ArrayList<>();
                relativeLines.add(this.lineTextBuffer.toString());
                this.relativeTraceLinesMap.put(outlineId, relativeLines);
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

                ArrayList<MocaTraceStackFrame> outline;
                if (this.outlineMap.containsKey(outlineId)) {
                    outline = this.outlineMap.get(outlineId);
                } else {
                    outline = new ArrayList<>();
                    this.outlineMap.put(outlineId, outline);
                }
                Stack<MocaTraceStackFrame> indentStack;
                if (this.indentStackMap.containsKey(outlineId)) {
                    indentStack = this.indentStackMap.get(outlineId);
                } else {
                    indentStack = new Stack<>();
                    this.indentStackMap.put(outlineId, indentStack);
                }
                HashMap<String, String> published;
                if (this.publishedMap.containsKey(outlineId)) {
                    published = this.publishedMap.get(outlineId);
                } else {
                    published = new HashMap<>();
                    this.publishedMap.put(outlineId, published);
                }
                HashMap<String, String> arguments;
                if (this.argumentsMap.containsKey(outlineId)) {
                    arguments = this.argumentsMap.get(outlineId);
                } else {
                    arguments = new HashMap<>();
                    this.argumentsMap.put(outlineId, arguments);
                }
                Stack<ReturnedRows> returnedRowsStack;
                if (this.returnedRowsStackMap.containsKey(outlineId)) {
                    returnedRowsStack = this.returnedRowsStackMap.get(outlineId);
                } else {
                    returnedRowsStack = new Stack<>();
                    this.returnedRowsStackMap.put(outlineId, returnedRowsStack);
                }

                // If we come across trace stack start/end cues, we need to clear the stack and
                // get ready for a new one.
                if (message.compareToIgnoreCase(MocaTraceOutliner.MESSAGE_TRACE_STACK_START_TEXT) == 0) {
                    indentStack.clear();
                } else if (message.compareToIgnoreCase(MocaTraceOutliner.MESSAGE_TRACE_STACK_END_TEXT) == 0) {
                    processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);
                    indentStack.clear();
                } else {

                    // Handle scenario where stack level goes down/comes up multiple levels.
                    // This happens due to extra "{}" either because of try block or nesting "{}".
                    // Ex: 1 -> 3 OR 3 -> 1
                    // Indenting via "{}" below for organization purposes and to illustrate exactly
                    // what we are looking for in the trace -- lol.
                    {
                        this.previousStackLevelMap.get(outlineId);
                        if (this.previousStackLevelMap.containsKey(outlineId)) {
                            int previousStackLevel = this.previousStackLevelMap.get(outlineId);
                            if (previousStackLevel < stackLevel) { // Going down (1 -> 3).
                                int p = previousStackLevel;
                                while (p < stackLevel - 1) {
                                    outline.add(new MocaTraceStackFrame(outlineId, p + 1, lineNum, relativeLineNum, "{",
                                            "0", false, true, buildIndentString(indentStack, p + 1), indentStack));
                                    indentStack.push(outline.get(outline.size() - 1));
                                    p++;
                                }
                            } else if (previousStackLevel > stackLevel) { // Coming up (3 -> 1).
                                if (previousStackLevel > stackLevel + 1 && indentStack.size() > 0
                                        && indentStack.peek().isNestedBraces) {
                                    processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline,
                                            outlineId);
                                }
                            }

                            // We also need to process published/argument argument stack level change.
                            if (previousStackLevel != stackLevel) {
                                published.clear();
                                arguments.clear();
                            }

                        }

                        this.previousStackLevelMap.put(outlineId, stackLevel);
                    }

                    // Returned rows analysis: we need to determine if stack elements need to be
                    // popped due to stack level changes.
                    // NOTE: For JDBC, we need to make sure current stack is less than returned rows
                    // stack level due to where in the stack frame the JDBC returned rows regex
                    // match occurs. Non JDBC matches at different timing, so less than or equal to
                    // works.
                    while (returnedRowsStack.size() > 0 && ((returnedRowsStack.peek().stackLevel >= stackLevel
                            && !returnedRowsStack.peek().fromJDBC)
                            || (returnedRowsStack.peek().stackLevel > stackLevel
                                    && returnedRowsStack.peek().fromJDBC))) {

                        ReturnedRows poppedReturnedRows = returnedRowsStack.pop();
                        // Let's make sure that we actually visited rows. We can tell by
                        // comparing the visited rows to the total rows. If they dont equal eachother,
                        // then we may not have actually visited any(maybe due to redirect or
                        // semicolon). This is not perfect, but it should be
                        // accurate enough.
                        if (poppedReturnedRows.totalRows != poppedReturnedRows.visitedRows) {
                            // Now we need to go back to all the stack frames that think they were visited
                            // and clear them out.
                            for (int i = outline.size() - 1; i >= 0; i--) {
                                if (outline.get(i).stackLevel == poppedReturnedRows.stackLevel + 1
                                        && outline.get(i).parentReturnedRows == poppedReturnedRows.totalRows) {
                                    outline.get(i).parentReturnedRows = 0;
                                    outline.get(i).rowNumberToParent = 0;
                                } else if (outline.get(i).stackLevel <= poppedReturnedRows.stackLevel) {
                                    break;
                                }
                            }
                        }
                    }

                    // Process matches:

                    Matcher matcher;

                    // SERVER GOT:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_SERVER_GOT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        indentStack.clear();

                        String instruction = matcher.group(2).trim().replace('\n', ' ');

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                instruction, "0", false, false, "", indentStack));
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
                                    instruction, "0", false, false, "", indentStack));
                            outline.get(outline.size() - 1).isCommandInitiated = true;

                            indentStack.push(outline.get(outline.size() - 1));
                        } else {

                            processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline,
                                    outlineId);

                            outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                    instruction, "0", false, false, buildIndentString(indentStack, stackLevel),
                                    indentStack));
                            outline.get(outline.size() - 1).isCommandInitiated = true;

                            indentStack.push(outline.get(outline.size() - 1));
                        }
                    }

                    // MOCA:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_COMMAND_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String[] instructionArr = matcher.group(2).trim().split("/");
                        String cmplvl = instructionArr[0];
                        String instruction = instructionArr[1];

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).componentLevel = cmplvl;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTED_COMMAND_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        processExplicitUnindentForLogicalIndentStrategy(indentStack, true);

                    }

                    matcher = MocaTraceOutliner.MESSAGE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()
                            && !MocaTraceOutliner.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message).find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "/* Firing triggers for " + matcher.group(3) + " */";

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).isFiringTriggers = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_DONE_FIRING_TRIGGERS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        processExplicitUnindentForLogicalIndentStrategy(indentStack, false);
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_COMMAND_ON_REMOTE_HOST_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "remote" + matcher.group(2) + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_REMOTE_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        processExplicitUnindentForLogicalIndentStrategy(indentStack, true);
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_PARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "parallel" + matcher.group(2) + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_INPARALLEL_COMMAND_ON_REMOTE_HOSTS_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "inparallel" + matcher.group(2)
                                + matcher.group(4).trim().replace('\n', ' ');

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).isRemote = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_PARALLEL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        processExplicitUnindentForLogicalIndentStrategy(indentStack, true);
                    }

                    matcher = MocaTraceOutliner.MESSAGE_RESUMING_EXECUTION_OF_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        // This is like a combo of explicit and implicit unindent.

                        String[] instructionArr = matcher.group(2).trim().split("/");
                        String cmplvl = instructionArr[0];
                        String instruction = instructionArr[1];

                        // Can assume we need to pop if current indent stack frame was command statement
                        // or nested brace AND if current indent stack frame level is GE to our
                        // current level, but we need to make sure that we do not pop the
                        // command/cmplvl being resumed. Only pop 1 frame.
                        if ((indentStack.peek().isCommandStatement || indentStack.peek().isNestedBraces)
                                && indentStack.peek().stackLevel >= stackLevel
                                && indentStack.peek().instruction.compareToIgnoreCase(instruction) != 0
                                && (indentStack.peek().componentLevel == null
                                        || indentStack.peek().componentLevel.compareToIgnoreCase(cmplvl) != 0)) {
                            MocaTraceStackFrame poppedFrame = processExplicitUnindentForLogicalIndentStrategy(
                                    indentStack, false);

                            if (poppedFrame.isCommandStatement) {
                                outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel,
                                        poppedFrame.absoluteLineNum, poppedFrame.relativeLineNum, "}", "0", true, false,
                                        buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                            } else if (poppedFrame.isNestedBraces) {
                                outline.add(new MocaTraceStackFrame(outlineId, poppedFrame.stackLevel,
                                        poppedFrame.absoluteLineNum, poppedFrame.relativeLineNum, "}", "0", false, true,
                                        buildIndentString(indentStack, poppedFrame.stackLevel), indentStack));
                            }
                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_CALLING_C_FUNCTION_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).isCFunction = true;
                    }

                    matcher = MocaTraceOutliner.MESSAGE_INVOKING_METHOD_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).isJavaMethod = true;
                    }

                    // SQL:
                    // -----------------------------------------------------------------------------------------------------------------
                    // Need both exec sql and unbind sql since sometimes unbind will not occur.
                    // If unbind comes through, we will just overwrite.
                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_SQL_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "["
                                + matcher.group(2).trim().replace('\n', ' ').replace(" N'", "'").replace("(N'", "('")
                                + "]";

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                    }
                    // Overwrite last outline frame if we get unbind.
                    matcher = MocaTraceOutliner.MESSAGE_UNBIND_SQL_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        String instruction = "["
                                + matcher.group(2).trim().replace('\n', ' ').replace(" N'", "'").replace("(N'", "('")
                                + "]";

                        outline.get(outline.size() - 1).instruction = instruction;

                    }

                    matcher = MocaTraceOutliner.MESSAGE_SQL_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                    }

                    matcher = MocaTraceOutliner.MESSAGE_CONNECTION_PREPARESTATEMENT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "[" + matcher.group(3).trim().replace('\n', ' ').replace("?", "'<var>'")
                                + "]";

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).isPreparedStatement = true;
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_PREPAREDSTATEMENT_EXECUTE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).preparedStatementQuery = "["
                                + matcher.group(3).trim().replace('\n', ' ') + "]";
                    }

                    matcher = MocaTraceOutliner.MESSAGE_PREPAREDSTATEMENT_CLOSE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                    }

                    // GROOVY:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTING_COMPILED_SCRIPT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "[[ /* Groovy */ ]]";

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", false, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        outline.get(outline.size() - 1).isGroovy = true;

                        processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                        indentStack.push(outline.get(outline.size() - 1));
                    }

                    matcher = MocaTraceOutliner.MESSAGE_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        processExplicitUnindentForLogicalIndentStrategy(indentStack, false);
                    }

                    // COMMAND STATEMENTS:
                    // -----------------------------------------------------------------------------------------------------------------

                    matcher = MocaTraceOutliner.MESSAGE_EVALUATING_CONDITIONAL_TEST_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        if (indentStack.size() > 0 && indentStack.peek().isCommandStatement
                                && outline.get(outline.size() - 2).instruction.compareTo("else") == 0
                                && outline.get(outline.size() - 2).stackLevel == stackLevel) {
                            // ^^^ -2 since we added an outline entry for "{".

                            // Get rid of preemptive indent.
                            processExplicitUnindentForLogicalIndentStrategy(indentStack, false);
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
                                        if (value.contains("'") || value.contains("=")) {
                                            value = (" \"" + value.replace("\"", "\"\"") + "\"");
                                        } else {
                                            if (value.compareToIgnoreCase("null") != 0) {
                                                value = (" '" + value + "'");
                                            }
                                        }
                                        break;
                                    case "RESULTS":
                                        value = (" \"" + value.replace("\"", "\"\"") + "\"");
                                        break;
                                    default:
                                        break;
                                }

                                conditionalTest = conditionalTest.replace(entireGroup, value);
                            }

                            appendInstruction = " if (" + conditionalTest + ")";

                            outline.get(outline.size() - 1).instruction += appendInstruction;

                        } else {

                            processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline,
                                    outlineId);

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
                                        if (value.contains("'") || value.contains("=")) {
                                            value = (" \"" + value.replace("\"", "\"\"") + "\"");
                                        } else {
                                            if (value.compareToIgnoreCase("null") != 0) {
                                                value = (" '" + value + "'");
                                            }
                                        }
                                        break;
                                    case "RESULTS":
                                        value = (" \"" + value.replace("\"", "\"\"") + "\"");
                                        break;
                                    default:
                                        break;
                                }

                                conditionalTest = conditionalTest.replace(entireGroup, value);
                            }

                            instruction = "if (" + conditionalTest + ")";

                            outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum,
                                    instruction, "0", true, false, buildIndentString(indentStack, stackLevel),
                                    indentStack));
                            outline.get(outline.size() - 1).published.putAll(published);
                            outline.get(outline.size() - 1).arguments.putAll(arguments);
                            published.clear();
                            arguments.clear();

                            processReturnedRowsForChild(returnedRowsStack, stackLevel, outline.get(outline.size() - 1));

                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_IF_TEST_PASSED_EXECUTING_IF_BLOCK_REGEX_PATTERN
                            .matcher(message);
                    if (matcher.find()) {

                        outline.get(outline.size() - 1).instructionStatus = "Passed";

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, "{", "0",
                                true, false, buildIndentString(indentStack, stackLevel), indentStack));
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

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", true, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, "{", "0",
                                true, false, buildIndentString(indentStack, stackLevel), indentStack));

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    matcher = MocaTraceOutliner.MESSAGE_EVALUATING_TRY_CATCH_EXPRESSION_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {

                        // Only process implicit undindent if current indent stack frame is nested brace
                        // (likely try block!).
                        if (indentStack.peek().isNestedBraces) {
                            processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline,
                                    outlineId);
                        }

                        String conditionalTest = matcher.group(2);

                        Matcher extractConditionalTestValuesMatcher = MocaTraceOutliner.EXTRACT_CONDITIONAL_TEST_VALUES
                                .matcher(conditionalTest);

                        while (extractConditionalTestValuesMatcher.find()) {
                            String entireGroup = extractConditionalTestValuesMatcher.group(0);
                            String type = extractConditionalTestValuesMatcher.group(3);
                            String value = extractConditionalTestValuesMatcher.group(6);

                            switch (type) {
                                case "STRING":
                                    if (value.contains("'") || value.contains("=")) {
                                        value = (" \"" + value.replace("\"", "\"\"") + "\"");
                                    } else {
                                        if (value.compareToIgnoreCase("null") != 0) {
                                            value = (" '" + value + "'");
                                        }
                                    }
                                    break;
                                case "RESULTS":
                                    value = (" \"" + value.replace("\"", "\"\"") + "\"");
                                    break;
                                default:
                                    break;
                            }

                            conditionalTest = conditionalTest.replace(entireGroup, value);
                        }

                        // May have to go back a few frames to find the correct stack frame.
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            // Should not be prepared statement.
                            if (outline.get(i).stackLevel == stackLevel && !outline.get(i).isPreparedStatement
                                    && !outline.get(i).isCommandInitiated) {

                                // If outline at i is nested braces(which should indicate try block), use the
                                // outline before that instead, since it is likely the instruction that failed.
                                if (outline.get(i).isNestedBraces && outline.get(i).instruction == "}") {
                                    // Should be i - 1 since i is "}".
                                    outline.get(i - 1).instructionStatus = "Caught (" + conditionalTest + ")";
                                } else {
                                    outline.get(i).instructionStatus = "Caught (" + conditionalTest + ")";
                                }

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

                        processImplicitUnindentForLogicalIndentStrategy(indentStack, stackLevel, outline, outlineId);

                        String instruction = "finally";

                        outline.add(
                                new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, instruction,
                                        "0", true, false, buildIndentString(indentStack, stackLevel), indentStack));
                        outline.get(outline.size() - 1).published.putAll(published);
                        outline.get(outline.size() - 1).arguments.putAll(arguments);
                        published.clear();
                        arguments.clear();

                        outline.add(new MocaTraceStackFrame(outlineId, stackLevel, lineNum, relativeLineNum, "{", "0",
                                true, false, buildIndentString(indentStack, stackLevel), indentStack));

                        indentStack.push(outline.get(outline.size() - 1));

                    }

                    // ERRORS:
                    // -----------------------------------------------------------------------------------------------------------------

                    // For errors(for the most part), we need to look back through outline entries
                    // and find the right outline instruction status to assign error to.
                    matcher = MocaTraceOutliner.MESSAGE_EXCEPTION_RAISED_FROM_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (stackLevel == outline.get(i).stackLevel && !outline.get(i).isCommandInitiated
                                    && !outline.get(i).isNestedBraces && !outline.get(i).isCommandStatement) {
                                outline.get(i).instructionStatus = matcher.group(2);
                                break;
                            }
                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXCEPTION_THROWN_FROM_COMPONENT_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        for (int i = outline.size() - 1; i >= 0; i--) {
                            if (stackLevel == outline.get(i).stackLevel && !outline.get(i).isCommandInitiated
                                    && !outline.get(i).isNestedBraces && !outline.get(i).isCommandStatement) {
                                outline.get(i).instructionStatus = matcher.group(2);
                                break;
                            }
                        }
                    }

                    // This error should only come up after a MOCA command fails.
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
                            if (stackLevel == outline.get(i).stackLevel && !outline.get(i).isCommandInitiated
                                    && !outline.get(i).isNestedBraces && !outline.get(i).isCommandStatement) {
                                outline.get(i).instructionStatus = "-1403";
                                break;
                            }
                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_SQL_EXCEPTION_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).instructionStatus = matcher.group();
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

                                    if (outline.get(i).returnedRows > 1) {
                                        returnedRowsStack
                                                .push(new ReturnedRows(stackLevel, outline.get(i).returnedRows, false));
                                    }

                                    break;
                                }
                            }
                        }
                    }

                    // Seems like we only see this in regards to the "Server got:"
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

                    // This one should just be in regards to JDBCApapter queries.
                    matcher = MocaTraceOutliner.MESSAGE_QUERY_RETURNED_X_ROWS_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).returnedRows = Integer.parseInt(matcher.group(2));

                        if (outline.get(outline.size() - 1).returnedRows > 1) {
                            returnedRowsStack.push(
                                    new ReturnedRows(stackLevel, outline.get(outline.size() - 1).returnedRows, true));
                        }
                    }

                    matcher = MocaTraceOutliner.MESSAGE_EXECUTION_TIME_REGEX_PATTERN.matcher(message);
                    if (matcher.find()) {
                        outline.get(outline.size() - 1).executionTime = Double.parseDouble(matcher.group(2));
                    }
                }
            }

            // Need to clear line text buf for next read line call.
            this.lineTextBuffer.setLength(0);
        }

    }

    private MocaTraceOutlineResult toResult() {
        return new MocaTraceOutlineResult(this.traceFileName, this.outlineMap, this.orderedOutlineIds,
                this.absoluteTraceLines, this.relativeTraceLinesMap, this.minimumExecutionTime);
    }

    public static MocaTraceOutlineResult outlineTrace(String traceFileName, boolean useLogicalIndentStrategy,
            boolean showCurlyBraces, double minimumExecutionTime, MocaResults res) {

        MocaTraceOutliner outliner = new MocaTraceOutliner(traceFileName, useLogicalIndentStrategy, showCurlyBraces,
                minimumExecutionTime);

        for (int i = 1; i < res.getRowCount(); i++) {
            outliner.readLine(i, res.getString(i, "text"));
        }

        return outliner.toResult();
    }

    public static MocaTraceOutlineResult outlineTrace(String traceFileName, boolean useLogicalIndentStrategy,
            boolean showCurlyBraces, double minimumExecutionTime, BufferedReader bufferedReader) throws IOException {

        MocaTraceOutliner outliner = new MocaTraceOutliner(traceFileName, useLogicalIndentStrategy, showCurlyBraces,
                minimumExecutionTime);

        int lineNum = 1;
        String line = bufferedReader.readLine();
        while (line != null) {
            outliner.readLine(lineNum++, line);
            line = bufferedReader.readLine();
        }

        return outliner.toResult();
    }

}

// Basic data structure to aid with parent instruction returned row processing.
class ReturnedRows {
    int stackLevel;
    int totalRows;
    int visitedRows;
    boolean fromJDBC; // Slightly different logic in some places if from JDBC logger.

    ReturnedRows(int stackLevel, int totalRows, boolean fromJDBC) {
        this.stackLevel = stackLevel;
        this.totalRows = totalRows;
        this.visitedRows = 0;
        this.fromJDBC = fromJDBC;
    }
}
