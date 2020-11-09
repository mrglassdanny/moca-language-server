package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;

public class TraceAnalyzer {

    private static final Pattern TRACE_LINE_REGEX_PATTERN = Pattern.compile(
            "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) (TRACE|DEBUG|INFO |WARN |ERROR|FATAL) \\[(\\d+)[ ]+(.*?)\\] (.+?) \\[(\\d{1,3})\\] ([\\s\\S]*) \\[[\\s\\S]*\\](.*)");

    private static final int TRACE_LINE_REGEX_LOG_LEVEL_GROUP_IDX = 2;
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

    public TraceAnalyzer() {
        this.lineNum = -1;
        this.lineTextBuffer = new StringBuilder(2048);
        this.htmlBuffers = new HashMap<>();
        this.stacks = new HashMap<>();
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

        this.lineNum = lineNum;
        this.lineTextBuffer.append(lineText);

        Matcher matcher = TraceAnalyzer.TRACE_LINE_REGEX_PATTERN.matcher(this.lineTextBuffer.toString());

        if (matcher.find()) {

            String logger = matcher.group(TraceAnalyzer.TRACE_LINE_REGEX_LOGGER_GROUP_IDX);

            // Check if ignored logger.
            boolean ignoreLogger = true;
            for (String _logger : TraceAnalyzer.LOGGERS) {
                if (logger.compareTo(_logger) == 0) {
                    ignoreLogger = false;
                    break;
                }
            }

            if (!ignoreLogger) {
                String logLevel = matcher.group(TraceAnalyzer.TRACE_LINE_REGEX_LOG_LEVEL_GROUP_IDX);
                String thread = matcher.group(TraceAnalyzer.TRACE_LINE_REGEX_THREAD_GROUP_IDX);
                String session = matcher.group(TraceAnalyzer.TRACE_LINE_REGEX_SESSION_GROUP_IDX);
                int stackLevel = Integer.parseInt(matcher.group(TraceAnalyzer.TRACE_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
                String message = matcher.group(TraceAnalyzer.TRACE_LINE_REGEX_MESSAGE_GROUP_IDX);

                // We need to make sure we are adding to the correct buffer/stack for
                // thread/session combo.
                String key = thread + ":" + session;
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
                if (message.compareToIgnoreCase(TraceAnalyzer.MESSAGE_TRACE_STACK_START_TEXT) == 0) {
                    stack.clear();
                } else if (message.compareToIgnoreCase(TraceAnalyzer.MESSAGE_TRACE_STACK_END_TEXT) == 0) {
                    stack.clear();
                } else {
                    TraceStackFrame curStackFrame;
                    if (stack.empty()) {
                        if (stackLevel == 0) {
                            curStackFrame = stack.push(new TraceStackFrame(0, this.lineNum));
                            processLogger(curStackFrame, this.lineNum, logger, message, htmlBuf);
                        }
                    } else {
                        curStackFrame = stack.peek();
                        if (stackLevel == curStackFrame.stackLevel) {
                            processLogger(curStackFrame, this.lineNum, logger, message, htmlBuf);
                        } else if (stackLevel > curStackFrame.stackLevel) {

                            String htmlStr = curStackFrame.toHtmlString();
                            if (htmlStr != null) {
                                htmlBuf.append(htmlStr);
                            }

                            // Check if stack level jumps more than 1 up.
                            for (int i = curStackFrame.stackLevel + 1; i < stackLevel; i++) {
                                stack.push(new TraceStackFrame(i, this.lineNum));
                            }

                            curStackFrame = stack.push(new TraceStackFrame(stackLevel, this.lineNum));
                            processLogger(curStackFrame, this.lineNum, logger, message, htmlBuf);
                        } else {
                            while (curStackFrame.stackLevel > stackLevel) {
                                stack.pop();
                                curStackFrame = stack.peek();
                            }
                            processLogger(curStackFrame, this.lineNum, logger, message, htmlBuf);
                        }
                    }
                }
            }

            // Need to clear line text buf for next read line call.
            this.lineTextBuffer.setLength(0);
        }

    }

    private static void processLogger(TraceStackFrame stackFrame, int lineNum, String logger, String message,
            StringBuilder htmlBuf) {

        MocaServices.logInfoToLanguageClient(lineNum + "---" + stackFrame.stackLevel + "::" + logger + "::" + message);

        switch (logger) {
            case "CommandDispatcher":
                stackFrame.processCommandDispatcherMessage(lineNum, message, htmlBuf);
                break;
            case "DefaultServerContext":
                stackFrame.processDefaultServerContextMessage(lineNum, message, htmlBuf);
                break;
            case "JDBCAdapter":
                stackFrame.processJdbcAdapterMessage(lineNum, message, htmlBuf);
                break;
            case "GroovyScriptAdapter":
                stackFrame.processGroovyScriptAdapterMessage(lineNum, message, htmlBuf);
                break;
            case "CommandStatement":
                stackFrame.processCommandStatementMessage(lineNum, message, htmlBuf);
                break;
            case "Argument":
                stackFrame.processArgumentMessage(lineNum, message, htmlBuf);
                break;
            case "Flow":
            case "FLOW":
                stackFrame.processFlowMessage(lineNum, message, htmlBuf);
                break;
            default:
                break;
        }
    }

}
