package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;

public class MocaTraceOutline {

    public String id;
    public ArrayList<MocaTraceStackFrame> frames;
    public ArrayList<String> relativeTraceLines;
    public boolean hasWrittenRelative; // Field for definition provider to indicate if we have already written file
                                       // for relative trace file lines.

    MocaTraceOutline(String id, ArrayList<MocaTraceStackFrame> frames, ArrayList<String> relativeTraceLines) {
        this.id = id;
        this.frames = frames;
        this.relativeTraceLines = relativeTraceLines;
        this.hasWrittenRelative = false;
    }

}
