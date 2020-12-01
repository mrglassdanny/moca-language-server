package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MocaTraceOutlineResult {

    public ArrayList<MocaTraceOutline> outlines;
    public ArrayList<String> absoluteTraceLines;

    public MocaTraceOutlineResult(HashMap<String, ArrayList<MocaTraceStackFrame>> outlineMap,
            ArrayList<String> absoluteTraceLines, HashMap<String, ArrayList<String>> relativeTraceLinesMap) {

        this.outlines = new ArrayList<>();
        this.absoluteTraceLines = new ArrayList<>();

        for (Entry<String, ArrayList<MocaTraceStackFrame>> entry : outlineMap.entrySet()) {
            String key = entry.getKey();
            this.outlines.add(new MocaTraceOutline(key, entry.getValue(), relativeTraceLinesMap.get(key)));
        }

        this.absoluteTraceLines.addAll(absoluteTraceLines);

    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder(8196);

        for (MocaTraceOutline outline : this.outlines) {
            buf.append("/*** " + outline.id
                    + " **********************************************************************/\n");
            StringBuilder entryBuf = new StringBuilder(2048);
            for (MocaTraceStackFrame t : outline.frames) {
                // entryBuf.append(String.format("%d - ", t.stackLevel));

                entryBuf.append(t.indentStr);
                if (t.isTrigger) {
                    entryBuf.append("(Trigger) ");
                }
                if (t.returnedRows > 0) {
                    entryBuf.append("ROWS: " + t.returnedRows + "   ");
                }
                if (t.executionTime > 0.0) {
                    entryBuf.append("TIME: " + t.executionTime + "   ");
                }
                if (t.instructionStatus != null && !t.instructionStatus.isEmpty() && t.instructionStatus != "0") {
                    entryBuf.append(t.instructionStatus + " -> " + t.instruction);
                } else {
                    entryBuf.append(t.instruction);
                }
                entryBuf.append('\n');

            }

            buf.append(entryBuf.toString());
        }

        return buf.toString();
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