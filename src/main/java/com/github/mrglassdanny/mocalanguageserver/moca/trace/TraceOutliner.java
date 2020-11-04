package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceOutliner {

    private static final String FULL_LINE_REGEX_STR = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) (TRACE|DEBUG|INFO |WARN |ERROR|FATAL) \\[(\\d+)[ ]+([a-f0-9]+)\\] (.+?) \\[(\\d{1,3})\\] ([\\s\\S]*) \\[[\\s\\S]*\\](.*)";
    private static final Pattern FULL_LINE_REGEX_PATTERN = Pattern.compile(TraceOutliner.FULL_LINE_REGEX_STR);

    private static final String TRACE_STACK_START_TEXT = "Dispatching command...";
    private static final String TRACE_STACK_END_TEXT = "Dispatched command";

    private static final int FULL_LINE_REGEX_LOG_LEVEL_GROUP_IDX = 2;
    private static final int FULL_LINE_REGEX_COMPONENT_GROUP_IDX = 5;
    private static final int FULL_LINE_REGEX_STACK_LEVEL_GROUP_IDX = 6;
    private static final int FULL_LINE_REGEX_TEXT_GROUP_IDX = 7;

    private Stack<TraceStackNode> stack;
    private int lineNum;
    private StringBuilder lineBuf;

    public TraceOutliner() {
        this.stack = new Stack<>();
        this.lineNum = -1;
        this.lineBuf = new StringBuilder(2048);
    }

    public void readLine(int lineNum, String line, StringBuilder buf) {

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
        if (this.lineBuf.length() == 0) {
            this.lineNum = lineNum;
        }

        this.lineBuf.append(line);

        Matcher matcher = TraceOutliner.FULL_LINE_REGEX_PATTERN.matcher(this.lineBuf.toString());

        if (matcher.find()) {
            int stackLevel = Integer.parseInt(matcher.group(TraceOutliner.FULL_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
            String logLevel = matcher.group(TraceOutliner.FULL_LINE_REGEX_LOG_LEVEL_GROUP_IDX);
            String component = matcher.group(TraceOutliner.FULL_LINE_REGEX_COMPONENT_GROUP_IDX);
            String text = matcher.group(TraceOutliner.FULL_LINE_REGEX_TEXT_GROUP_IDX);

            if (text.compareToIgnoreCase(TraceOutliner.TRACE_STACK_START_TEXT) == 0) {
                this.stack.clear();
            } else if (text.compareToIgnoreCase(TraceOutliner.TRACE_STACK_END_TEXT) == 0) {
                this.stack.clear();
            } else {
                if (this.stack.empty()) {
                    if (stackLevel == 0) {
                        this.stack.push(new TraceStackNode(0, this.lineNum, logLevel, component, text, buf));
                    }
                } else {
                    TraceStackNode curTraceStackNode = this.stack.peek();
                    if (stackLevel == curTraceStackNode.stackLevel) {
                        curTraceStackNode.processText(this.lineNum, logLevel, component, text, buf);
                    } else if (stackLevel > curTraceStackNode.stackLevel) {
                        String str = curTraceStackNode.toString();

                        if (str != null && !curTraceStackNode.isWritten) {
                            buf.append("<li>");
                            buf.append(str);
                            buf.append("</li>");
                            curTraceStackNode.isWritten = true;
                        }

                        this.stack.push(new TraceStackNode(stackLevel, this.lineNum, logLevel, component, text, buf));
                    } else {

                        String str = curTraceStackNode.toString();
                        if (str != null && !curTraceStackNode.isWritten) {
                            buf.append("<li>");
                            buf.append(str);
                            buf.append("</li>");
                            curTraceStackNode.isWritten = true;
                        }

                        while (stackLevel < curTraceStackNode.stackLevel) {
                            stack.pop();
                            curTraceStackNode = this.stack.peek();
                        }

                        curTraceStackNode.processText(lineNum, logLevel, component, text, buf);
                    }

                }

            }

            // Need to clear out the line buffer since we had a match!
            this.lineBuf.setLength(0);
        }
    }
}
