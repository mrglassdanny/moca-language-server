package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceAnalyzer {

    private static final String FULL_LINE_REGEX = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) (TRACE|DEBUG|INFO |WARN |ERROR|FATAL) \\[(\\d+)[ ]+([a-f0-9]+)\\] (.+?) \\[(\\d{1,3})\\] ([\\s\\S]*?) \\[[\\s\\S]*?\\](.*)";
    private static final Pattern FULL_LINE_REGEX_PATTERN = Pattern.compile(TraceAnalyzer.FULL_LINE_REGEX);

    private static final int FULL_LINE_REGEX_LOG_LEVEL_GROUP_IDX = 2;
    private static final int FULL_LINE_REGEX_COMPONENT_GROUP_IDX = 5;
    private static final int FULL_LINE_REGEX_STACK_LEVEL_GROUP_IDX = 6;
    private static final int FULL_LINE_REGEX_TEXT_GROUP_IDX = 7;

    private Stack<TraceStackNode> stack;
    private StringBuilder lineBuf;

    public TraceAnalyzer() {
        this.stack = new Stack<>();
        this.lineBuf = new StringBuilder(2048);
    }

    public void readLine(String line, StringBuilder buf) {

        // This function is a bit tricky:
        // Basically we are passing the trace file contents line by line(lines are
        // determined in 'read file' MOCA command call) into this function. For the most
        // part, a MOCA read file line represents a perfect match via our full line
        // regex pattern. This is not the case though if the 'text' capture group
        // extends multiple lines.
        // Therefore, we are keeping a line buffer member and are using it to resolve
        // this issue:
        // If we have a perfect match, we need to process the line and clear out the
        // line buffer. If we do not, we need to hold off on processing line until the
        // line is 'complete' and we have a perfect regex match.

        this.lineBuf.append(line);
        Matcher matcher = TraceAnalyzer.FULL_LINE_REGEX_PATTERN.matcher(this.lineBuf.toString());

        if (matcher.find()) {
            int stackLevel = Integer.parseInt(matcher.group(TraceAnalyzer.FULL_LINE_REGEX_STACK_LEVEL_GROUP_IDX));
            String logLevel = matcher.group(TraceAnalyzer.FULL_LINE_REGEX_LOG_LEVEL_GROUP_IDX);
            String component = matcher.group(TraceAnalyzer.FULL_LINE_REGEX_COMPONENT_GROUP_IDX);
            String text = matcher.group(TraceAnalyzer.FULL_LINE_REGEX_TEXT_GROUP_IDX);

            if (this.stack.empty()) {
                // We do not want to read anything if stack is empty and level is not 0.
                if (stackLevel == 0) {
                    this.stack.push(new TraceStackNode(0, logLevel, component, text));
                }
            } else {
                TraceStackNode curStackLevel = this.stack.peek();
                if (stackLevel == curStackLevel.stackLevel) {
                    curStackLevel.processText(logLevel, component, text);
                } else if (stackLevel > curStackLevel.stackLevel) {

                    buf.append(curStackLevel.toString2());
                    buf.append('\n');

                    this.stack.push(new TraceStackNode(stackLevel, logLevel, component, text));
                } else {
                    buf.append(stack.pop().toString2());
                    buf.append('\n');
                }
            }

            // Need to clear out the line buffer since we had a match!
            this.lineBuf.setLength(0);
        } else {
            // We can assume that we need to add a newline character.
            // this.lineBuf.append('\n');
        }
    }
}
