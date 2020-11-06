package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceOutliner {

    private static final String FULL_LINE_REGEX_STR = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) (TRACE|DEBUG|INFO |WARN |ERROR|FATAL) \\[(\\d+)[ ]+(.*?)\\] (.+?) \\[(\\d{1,3})\\] ([\\s\\S]*) \\[[\\s\\S]*\\](.*)";
    private static final Pattern FULL_LINE_REGEX_PATTERN = Pattern.compile(TraceOutliner.FULL_LINE_REGEX_STR);

    private static final String TRACE_STACK_START_TEXT = "Dispatching command...";
    private static final String TRACE_STACK_END_TEXT = "Dispatched command";

    private static final int FULL_LINE_REGEX_LOG_LEVEL_GROUP_IDX = 2;
    private static final int FULL_LINE_REGEX_TRANSACTION_GROUP_IDX = 3;
    private static final int FULL_LINE_REGEX_THREAD_GROUP_IDX = 4;
    private static final int FULL_LINE_REGEX_COMPONENT_GROUP_IDX = 5;
    private static final int FULL_LINE_REGEX_STACK_LEVEL_GROUP_IDX = 6;
    private static final int FULL_LINE_REGEX_TEXT_GROUP_IDX = 7;

    // There are a select few components that we actually care to analyze.
    private static final String[] APPROVED_COMPONENTS = { "Argument", "CommandStatement", "DefaultServerContext",
            "JDBCAdapter", "Performance", "CommandDispatcher", "MocaTransactionManager", "GroovyScriptAdapter",
            "ComponentAdapter" };

    // These indicate if instruction is complete in trace stack node but stack level
    // is not changed -- we will need to create a new one if this is the case!
    private static final String TEXT_EXECUTED_COMMAND_REGEX_STR = "(Executed Command:) (.*)";
    private static final String TEXT_SQL_EXECUTION_COMPLETED_REGEX_STR = "SQL execution completed";
    private static final String TEXT_SCRIPT_EXECUTION_COMPLETE_REGEX_STR = "Script Execution Complete";
    private static final Pattern TEXT_EXECUTED_COMMAND_REGEX_PATTERN = Pattern
            .compile(TraceOutliner.TEXT_EXECUTED_COMMAND_REGEX_STR);
    private static final Pattern TEXT_SQL_EXECUTION_COMPLETED_REGEX_PATTERN = Pattern
            .compile(TraceOutliner.TEXT_SQL_EXECUTION_COMPLETED_REGEX_STR);
    private static final Pattern TEXT_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN = Pattern
            .compile(TraceOutliner.TEXT_SCRIPT_EXECUTION_COMPLETE_REGEX_STR);

    private int lineNum;
    private StringBuilder lineBuffer;
    // We could have multiple transactions/threads in trace. We need to keep them
    // seperate if this is the case.
    public HashMap<String, StringBuilder> htmlBuffers;
    private HashMap<String, Stack<TraceStackNode>> stacks;

    public TraceOutliner() {

        this.lineNum = -1;
        this.lineBuffer = new StringBuilder(2048);
        this.htmlBuffers = new HashMap<>();
        this.stacks = new HashMap<>();
    }

    public void readLine(int lineNum, String line) {

        // We are passing the trace file contents line by line(lines are
        // determined in 'read file' MOCA command call) into this function. For the most
        // part, a MOCA read file line represents a perfect match via our full line
        // regex pattern. This is not the case though if the 'text' capture group
        // extends multiple lines.
        // Therefore, we are keeping a line buffer member and are using it to resolve
        // this issue. If we have a perfect match, we need to process the line and clear
        // out the line buffer. If we do not, we need to hold off on processing line
        // until the line is 'complete' and we have a perfect regex match.

        // TODO
        // We want line number to be start line of text capture group. So if the text
        // capture group extends multiple lines, we want to make sure we are specifying
        // the start line. We can do this by making sure the current length of line
        // buffer is 0, since the only time we clear it out is when we are about to
        // start a new line.
        // if (this.lineBuffer.length() == 0) {
        // this.lineNum = lineNum;
        // }
        this.lineNum = lineNum;
        this.lineBuffer.append(line);

        Matcher matcher = TraceOutliner.FULL_LINE_REGEX_PATTERN.matcher(this.lineBuffer.toString());

        if (matcher.find()) {
            String logLevel = matcher.group(TraceOutliner.FULL_LINE_REGEX_LOG_LEVEL_GROUP_IDX);
            String transaction = matcher.group(TraceOutliner.FULL_LINE_REGEX_TRANSACTION_GROUP_IDX);
            String thread = matcher.group(TraceOutliner.FULL_LINE_REGEX_THREAD_GROUP_IDX);
            String component = matcher.group(TraceOutliner.FULL_LINE_REGEX_COMPONENT_GROUP_IDX);
            int stackLevel = Integer.parseInt(matcher.group(TraceOutliner.FULL_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
            String text = matcher.group(TraceOutliner.FULL_LINE_REGEX_TEXT_GROUP_IDX);

            // Check if approved component.
            boolean componentIsApproved = false;
            for (String approvedComponent : TraceOutliner.APPROVED_COMPONENTS) {
                if (component.compareToIgnoreCase(approvedComponent) == 0) {
                    componentIsApproved = true;
                    break;
                }
            }

            if (componentIsApproved) {
                // Now that we have match, we need to make sure we are adding to the correct
                // buffer/stack.
                String key = thread;
                StringBuilder htmlBuf;
                Stack<TraceStackNode> stack;

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

                if (text.compareToIgnoreCase(TraceOutliner.TRACE_STACK_START_TEXT) == 0) {
                    stack.clear();
                } else if (text.compareToIgnoreCase(TraceOutliner.TRACE_STACK_END_TEXT) == 0) {
                    stack.clear();
                } else {
                    if (stack.empty()) {
                        if (stackLevel == 0) {
                            stack.push(new TraceStackNode(0, this.lineNum, logLevel, component, text, htmlBuf));
                        }
                    } else {
                        TraceStackNode curTraceStackNode = stack.peek();
                        if (stackLevel == curTraceStackNode.stackLevel) {

                            if (TraceOutliner.TEXT_EXECUTED_COMMAND_REGEX_PATTERN.matcher(text).find()
                                    || TraceOutliner.TEXT_SQL_EXECUTION_COMPLETED_REGEX_PATTERN.matcher(text).find()
                                    || TraceOutliner.TEXT_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(text)
                                            .find()) {

                                String str = curTraceStackNode.toString();
                                if (str != null) {
                                    htmlBuf.append("<li>");
                                    htmlBuf.append(str);
                                    htmlBuf.append("</li>");
                                }
                                curTraceStackNode = new TraceStackNode(stackLevel, this.lineNum, logLevel, component,
                                        text, htmlBuf);
                            } else {
                                curTraceStackNode.processText(this.lineNum, logLevel, component, text, htmlBuf);
                            }

                        } else if (stackLevel > curTraceStackNode.stackLevel) {
                            if (!curTraceStackNode.isWritten) {
                                String str = curTraceStackNode.toString();
                                if (str != null) {
                                    htmlBuf.append("<li>");
                                    htmlBuf.append(str);
                                    htmlBuf.append("</li>");
                                }
                            }
                            stack.push(
                                    new TraceStackNode(stackLevel, this.lineNum, logLevel, component, text, htmlBuf));
                        } else {

                            if (!curTraceStackNode.isWritten) {
                                String str = curTraceStackNode.toString();
                                if (str != null) {
                                    htmlBuf.append("<li>");
                                    htmlBuf.append(str);
                                    htmlBuf.append("</li>");
                                }
                            }

                            while (stackLevel < curTraceStackNode.stackLevel) {
                                stack.pop();
                                curTraceStackNode = stack.peek();
                            }

                            if (TraceOutliner.TEXT_EXECUTED_COMMAND_REGEX_PATTERN.matcher(text).find()
                                    || TraceOutliner.TEXT_SQL_EXECUTION_COMPLETED_REGEX_PATTERN.matcher(text).find()
                                    || TraceOutliner.TEXT_SCRIPT_EXECUTION_COMPLETE_REGEX_PATTERN.matcher(text)
                                            .find()) {

                                String str = curTraceStackNode.toString();
                                if (str != null) {
                                    htmlBuf.append("<li>");
                                    htmlBuf.append(str);
                                    htmlBuf.append("</li>");
                                }
                                curTraceStackNode = new TraceStackNode(stackLevel, this.lineNum, logLevel, component,
                                        text, htmlBuf);
                            } else {
                                curTraceStackNode.processText(this.lineNum, logLevel, component, text, htmlBuf);
                            }
                        }
                    }
                }
            }

            // Need to clear out the line buffer since we had a match!
            this.lineBuffer.setLength(0);
        }
    }
}
