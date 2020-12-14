package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;

public class MocaTraceOutline {

    public String id;
    public ArrayList<MocaTraceStackFrame> frames;
    public ArrayList<String> relativeTraceLines;

    MocaTraceOutline(String id, ArrayList<MocaTraceStackFrame> frames, ArrayList<String> relativeTraceLines) {
        this.id = id;
        this.frames = frames;
        this.relativeTraceLines = relativeTraceLines;
    }

}
