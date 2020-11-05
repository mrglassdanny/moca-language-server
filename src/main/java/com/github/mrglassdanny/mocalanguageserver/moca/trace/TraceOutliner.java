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

    private int lineNum;
    private StringBuilder lineBuffer;
    // We could have multiple transactions/threads in trace. We need to keep them
    // seperate if this is the case.
    public HashMap<String, StringBuilder> htmlBuffers; // Key is transaction + thread.
    private HashMap<String, Stack<TraceStackNode>> stacks; // Key is transaction + thread.

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

        // We want line number to be start line of text capture group. So if the text
        // capture group extends multiple lines, we want to make sure we are specifying
        // the start line. We can do this by making sure the current length of line
        // buffer is 0, since the only time we clear it out is when we are about to
        // start a new line.
        if (this.lineBuffer.length() == 0) {
            this.lineNum = lineNum;
        }

        this.lineBuffer.append(line);

        Matcher matcher = TraceOutliner.FULL_LINE_REGEX_PATTERN.matcher(this.lineBuffer.toString());

        if (matcher.find()) {
            String logLevel = matcher.group(TraceOutliner.FULL_LINE_REGEX_LOG_LEVEL_GROUP_IDX);
            String transaction = matcher.group(TraceOutliner.FULL_LINE_REGEX_TRANSACTION_GROUP_IDX);
            String thread = matcher.group(TraceOutliner.FULL_LINE_REGEX_THREAD_GROUP_IDX);
            String component = matcher.group(TraceOutliner.FULL_LINE_REGEX_COMPONENT_GROUP_IDX);
            int stackLevel = Integer.parseInt(matcher.group(TraceOutliner.FULL_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
            String text = matcher.group(TraceOutliner.FULL_LINE_REGEX_TEXT_GROUP_IDX);

            // Now that we have match, we need to make sure we are adding to the correct
            // buffer/stack.

            String key = transaction + thread;
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
                        curTraceStackNode.processText(this.lineNum, logLevel, component, text, htmlBuf);
                    } else if (stackLevel > curTraceStackNode.stackLevel) {
                        String str = curTraceStackNode.toString();

                        if (str != null) {
                            htmlBuf.append("<li>");
                            htmlBuf.append(str);
                            htmlBuf.append("</li>");
                            curTraceStackNode.isWritten = true;
                        }

                        stack.push(new TraceStackNode(stackLevel, this.lineNum, logLevel, component, text, htmlBuf));
                    } else {

                        String str = curTraceStackNode.toString();
                        if (str != null && !curTraceStackNode.isWritten) {
                            htmlBuf.append("<li>");
                            htmlBuf.append(str);
                            htmlBuf.append("</li>");
                            curTraceStackNode.isWritten = true;
                        }

                        while (stackLevel < curTraceStackNode.stackLevel) {
                            stack.pop();
                            curTraceStackNode = stack.peek();
                        }

                        curTraceStackNode.processText(lineNum, logLevel, component, text, htmlBuf);
                    }

                }

            }

            // Need to clear out the line buffer since we had a match!
            this.lineBuffer.setLength(0);
        }
    }
}
