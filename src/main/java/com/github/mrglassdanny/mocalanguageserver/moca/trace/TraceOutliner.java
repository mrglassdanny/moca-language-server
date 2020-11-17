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
            "Performance", "CommandDispatcher", "MocaTransactionManager", "GroovyScriptAdapter", "Flow", "FLOW" };

    // These messages indicate the beginning and ending of a trace 'stack'.
    private static final String MESSAGE_TRACE_STACK_START_TEXT = "Dispatching command...";
    private static final String MESSAGE_TRACE_STACK_END_TEXT = "Dispatched command";

    private int lineNum;
    private StringBuilder lineTextBuffer;

    // We could have multiple threads/sessions in trace. We need to keep them
    // seperate if this is the case.
    public HashMap<String, StringBuilder> htmlBuffers;
    private HashMap<String, Stack<TraceStackFrame>> stacks;
    public HashMap<String, ArrayList<String>> relativeTraceLines;
    public ArrayList<String> absoluteTraceLines;

    public TraceOutliner() {
        this.lineNum = -1;
        this.lineTextBuffer = new StringBuilder(2048);
        this.htmlBuffers = new HashMap<>();
        this.stacks = new HashMap<>();
        this.relativeTraceLines = new HashMap<>();
        this.absoluteTraceLines = new ArrayList<>();
    }

    public void readLine(int lineNum, String lineText) {

        // We are passing the trace file contents line by line(lines are
        // determined in 'read file' MOCA command call) into this function. For the most
        // part, a MOCA read file line represents a perfect match via our full line
        // regex pattern. This is not the case though if the 'message' capture group
        // extends multiple lines.
        // Therefore, we are keeping a line buffer member and are using it to resolve
        // this issue. If we have a perfect match, we need to process the line and clear
        // out the line buffer. If we do not, we need to hold off on processing line
        // until the line is 'complete' and we have a perfect regex match.

        // The lineNum member will be in line with how we are processing lines ^.
        if (this.lineTextBuffer.length() == 0) {
            this.lineNum = lineNum;
        }
        this.lineTextBuffer.append(lineText);

        Matcher matcher = TraceOutliner.TRACE_LINE_REGEX_PATTERN.matcher(this.lineTextBuffer.toString());

        if (matcher.find()) {

            // Add to absolute trace line list now.
            this.absoluteTraceLines.add(this.lineTextBuffer.toString());

            String thread = matcher.group(TraceOutliner.TRACE_LINE_REGEX_THREAD_GROUP_IDX);
            String session = matcher.group(TraceOutliner.TRACE_LINE_REGEX_SESSION_GROUP_IDX);
            String logger = matcher.group(TraceOutliner.TRACE_LINE_REGEX_LOGGER_GROUP_IDX);

            // We need to make sure we are adding to the correct buffer/stack/lines for
            // thread:session combo.
            String key = thread + ":" + session;

            // Relative line number refers to line num relative to thread:session combo.
            int relativeLineNum;
            if (this.relativeTraceLines.containsKey(key)) {
                ArrayList<String> lines = this.relativeTraceLines.get(key);
                lines.add(this.lineTextBuffer.toString());
                relativeLineNum = lines.size();
            } else {
                ArrayList<String> lines = new ArrayList<>();
                lines.add(this.lineTextBuffer.toString());
                this.relativeTraceLines.put(key, lines);
                relativeLineNum = lines.size();
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
                int stackLevel = Integer.parseInt(matcher.group(TraceOutliner.TRACE_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
                String message = matcher.group(TraceOutliner.TRACE_LINE_REGEX_MESSAGE_GROUP_IDX);

                StringBuilder htmlBuf;
                Stack<TraceStackFrame> stack;

                if (this.htmlBuffers.containsKey(key)) {
                    htmlBuf = this.htmlBuffers.get(key);
                } else {
                    htmlBuf = new StringBuilder();
                    this.htmlBuffers.put(key, htmlBuf);
                }
                if (this.stacks.containsKey(key)) {
                    stack = this.stacks.get(key);
                } else {
                    stack = new Stack<>();
                    this.stacks.put(key, stack);
                }

                // If we come across trace stack start/end cues, we need to clear the stack and
                // get ready for a new one.
                if (message.compareToIgnoreCase(TraceOutliner.MESSAGE_TRACE_STACK_START_TEXT) == 0) {
                    stack.clear();
                } else if (message.compareToIgnoreCase(TraceOutliner.MESSAGE_TRACE_STACK_END_TEXT) == 0) {
                    stack.clear();
                } else {
                    TraceStackFrame curStackFrame;
                    if (stack.empty()) {
                        if (stackLevel == 0) {
                            curStackFrame = stack.push(new TraceStackFrame(0, this.lineNum, relativeLineNum));
                            processLogger(curStackFrame, this.lineNum, relativeLineNum, logger, message, htmlBuf);
                        }
                    } else {
                        curStackFrame = stack.peek();
                        if (stackLevel == curStackFrame.stackLevel) {
                            processLogger(curStackFrame, this.lineNum, relativeLineNum, logger, message, htmlBuf);
                        } else if (stackLevel > curStackFrame.stackLevel) {

                            curStackFrame.appendHtml(htmlBuf);
                            curStackFrame.reset(this.lineNum, relativeLineNum);

                            // Check if stack level jumps up more than 1 level.
                            for (int i = curStackFrame.stackLevel + 1; i < stackLevel; i++) {
                                stack.push(new TraceStackFrame(i, this.lineNum, relativeLineNum));
                            }

                            curStackFrame = stack.push(new TraceStackFrame(stackLevel, this.lineNum, relativeLineNum));
                            processLogger(curStackFrame, this.lineNum, relativeLineNum, logger, message, htmlBuf);
                        } else {
                            while (curStackFrame.stackLevel > stackLevel) {
                                stack.pop();
                                curStackFrame = stack.peek();
                            }
                            processLogger(curStackFrame, this.lineNum, relativeLineNum, logger, message, htmlBuf);
                        }
                    }
                }
            }

            // Need to clear line text buf for next read line call.
            this.lineTextBuffer.setLength(0);
        }

    }

    private static void processLogger(TraceStackFrame stackFrame, int lineNum, int relativeLineNum, String logger,
            String message, StringBuilder htmlBuf) {

        switch (logger) {
            case "CommandDispatcher":
                stackFrame.processCommandDispatcherMessage(lineNum, relativeLineNum, message, htmlBuf);
                break;
            case "DefaultServerContext":
                stackFrame.processDefaultServerContextMessage(lineNum, relativeLineNum, message, htmlBuf);
                break;
            case "JDBCAdapter":
                stackFrame.processJdbcAdapterMessage(lineNum, relativeLineNum, message, htmlBuf);
                break;
            case "GroovyScriptAdapter":
                stackFrame.processGroovyScriptAdapterMessage(lineNum, relativeLineNum, message, htmlBuf);
                break;
            case "CommandStatement":
                stackFrame.processCommandStatementMessage(lineNum, relativeLineNum, message, htmlBuf);
                break;
            case "Argument":
                stackFrame.processArgumentMessage(lineNum, relativeLineNum, message, htmlBuf);
                break;
            case "Flow":
            case "FLOW":
                stackFrame.processFlowMessage(lineNum, relativeLineNum, message, htmlBuf);
                break;
            default:
                break;
        }
    }

}
