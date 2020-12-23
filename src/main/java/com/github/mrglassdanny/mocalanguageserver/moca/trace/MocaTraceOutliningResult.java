package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;

public class MocaTraceOutliningResult {

    public String traceFileName;
    public MocaTraceOutlineOptions options;
    public ArrayList<MocaTraceOutline> outlines;
    public ArrayList<String> absoluteTraceLines;
    public boolean hasWrittenAbsolute; // Field for definition provider to indicate if we have already written file
                                       // for absolute trace file lines.
    // actualLinesMap will associate actual editor line number with trace stack
    // frame so that we do not have to spend time analyzing outlines to find correct
    // stack frame for actual line.
    public HashMap<Integer, MocaTraceStackFrame> actualLinesMap; // Line numbers start at 1.
    public ArrayList<Integer> outlineIdLineNumbers; // Easy way for decorations to be applied to outline ID lines.

    public MocaTraceOutliningResult(String traceFileName, HashMap<String, ArrayList<MocaTraceStackFrame>> outlineMap,
            ArrayList<String> orderedOutlineIds, ArrayList<String> absoluteTraceLines,
            HashMap<String, ArrayList<String>> relativeTraceLinesMap, MocaTraceOutlineOptions options) {

        // Remove .log from file name.
        this.traceFileName = traceFileName.replace(".log", "");
        this.options = options;
        this.outlines = new ArrayList<>();
        this.absoluteTraceLines = new ArrayList<>();
        this.actualLinesMap = new HashMap<>();
        this.outlineIdLineNumbers = new ArrayList<>();

        // Add according to ordered outline ID list.
        for (String outlineId : orderedOutlineIds) {
            this.outlines.add(
                    new MocaTraceOutline(outlineId, outlineMap.get(outlineId), relativeTraceLinesMap.get(outlineId)));
        }

        this.absoluteTraceLines.addAll(absoluteTraceLines);
        this.hasWrittenAbsolute = false;

    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder(65536);

        int actualLineNum = 1;

        for (MocaTraceOutline outline : this.outlines) {

            buf.append("/* ----------- Thread-Session: " + outline.id
                    + " ------------------------------------------------------------------------------------------------------------------ */\n");
            this.outlineIdLineNumbers.add(actualLineNum - 1);
            actualLineNum++;

            StringBuilder outlineBuf = new StringBuilder(8192);
            for (MocaTraceStackFrame frame : outline.frames) {
                this.actualLinesMap.put(actualLineNum, frame);
                outlineBuf.append(frame.toString());
                outlineBuf.append('\n');
                actualLineNum++;
            }

            buf.append(outlineBuf.toString());

        }

        return buf.toString();
    }

    public MocaTraceOutline getOutline(String outlineId) {
        for (MocaTraceOutline outline : this.outlines) {
            if (outline.id.compareToIgnoreCase(outlineId) == 0) {
                return outline;
            }
        }
        return null;
    }
}