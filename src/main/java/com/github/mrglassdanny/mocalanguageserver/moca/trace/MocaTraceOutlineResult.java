package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;

public class MocaTraceOutlineResult {

    public String traceFileName;
    public ArrayList<MocaTraceOutline> outlines;
    public ArrayList<String> absoluteTraceLines;
    // This will associate actual editor line number with trace stack frame so that
    // we do not have to spend time analyzing outlines to find correct stack frame
    // for actual line.
    public HashMap<Integer, MocaTraceStackFrame> actualLinesMap; // Line numbers start at 1.

    public MocaTraceOutlineResult(String traceFileName, HashMap<String, ArrayList<MocaTraceStackFrame>> outlineMap,
            ArrayList<String> orderedOutlineIds, ArrayList<String> absoluteTraceLines,
            HashMap<String, ArrayList<String>> relativeTraceLinesMap) {

        // Remove .log from file name.
        this.traceFileName = traceFileName.replace(".log", "");
        this.outlines = new ArrayList<>();
        this.absoluteTraceLines = new ArrayList<>();
        this.actualLinesMap = new HashMap<>();

        // Add according to ordered outline ID list.
        for (String outlineId : orderedOutlineIds) {
            this.outlines.add(
                    new MocaTraceOutline(outlineId, outlineMap.get(outlineId), relativeTraceLinesMap.get(outlineId)));
        }

        this.absoluteTraceLines.addAll(absoluteTraceLines);

    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder(8196);

        int actualLineNum = 1;

        for (MocaTraceOutline outline : this.outlines) {
            buf.append("/************************************************************ Thread-Session: " + outline.id
                    + " ************************************************************/\n");
            actualLineNum++;
            StringBuilder outlineBuf = new StringBuilder(2048);
            for (MocaTraceStackFrame t : outline.frames) {
                this.actualLinesMap.put(actualLineNum, t);
                outlineBuf.append(t.indentStr);
                outlineBuf.append(t.instructionPrefix);
                outlineBuf.append(t.instruction);
                outlineBuf.append(t.instructionSuffix);
                outlineBuf.append('\n');
                actualLineNum++;
            }

            buf.append(outlineBuf.toString());
        }

        return buf.toString();
    }

    public ArrayList<String> getRelativeTraceLinesForOutline(String outlineId) {
        for (MocaTraceOutline outline : this.outlines) {
            if (outline.id.compareToIgnoreCase(outlineId) == 0) {
                return outline.relativeTraceLines;
            }
        }
        return new ArrayList<>();
    }
}