package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MocaTraceOutlineResult {

    public HashMap<String, ArrayList<MocaTraceStackFrame>> outlines;
    public ArrayList<String> absoluteTraceLines;
    public HashMap<String, ArrayList<String>> relativeTraceLines;

    public MocaTraceOutlineResult() {
        this.outlines = new HashMap<>();
        this.absoluteTraceLines = new ArrayList<>();
        this.relativeTraceLines = new HashMap<>();
    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder(8196);

        for (Entry<String, ArrayList<MocaTraceStackFrame>> entry : this.outlines.entrySet()) {
            buf.append("=== START: " + entry.getKey()
                    + " =======================================================================\n");
            StringBuilder entryBuf = new StringBuilder(2048);
            for (MocaTraceStackFrame t : entry.getValue()) {
                entryBuf.append(String.format("%d - ", t.stackLevel));

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
            buf.append("===== END: " + entry.getKey()
                    + " =======================================================================\n");
        }

        return buf.toString();
    }
}
