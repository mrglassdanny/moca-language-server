package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MocaTraceOutlineResult {

    public String traceFileName;
    public ArrayList<MocaTraceOutline> outlines;
    public ArrayList<String> absoluteTraceLines;
    // This will associate actual editor line number with trace stack frame so that
    // we do not have to spend time analyzing outlines to find correct stack frame
    // for actual line.
    public HashMap<Integer, MocaTraceStackFrame> actualLinesMap; // Line numbers start at 1.

    public MocaTraceOutlineResult(String traceFileName, HashMap<String, ArrayList<MocaTraceStackFrame>> outlineMap,
            ArrayList<String> absoluteTraceLines, HashMap<String, ArrayList<String>> relativeTraceLinesMap) {

        // Remove .log from file name.
        this.traceFileName = traceFileName.substring(0, traceFileName.lastIndexOf("."));
        this.outlines = new ArrayList<>();
        this.absoluteTraceLines = new ArrayList<>();
        this.actualLinesMap = new HashMap<>();

        for (Entry<String, ArrayList<MocaTraceStackFrame>> entry : outlineMap.entrySet()) {
            String key = entry.getKey();
            this.outlines.add(new MocaTraceOutline(key, entry.getValue(), relativeTraceLinesMap.get(key)));
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
                outlineBuf.append(t.instruction);
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

class MocaTraceOutline {

    String id;
    ArrayList<MocaTraceStackFrame> frames;
    ArrayList<String> relativeTraceLines;

    MocaTraceOutline(String id, ArrayList<MocaTraceStackFrame> frames, ArrayList<String> relativeTraceLines) {
        this.id = id;
        this.frames = frames;
        this.relativeTraceLines = relativeTraceLines;
    }
}