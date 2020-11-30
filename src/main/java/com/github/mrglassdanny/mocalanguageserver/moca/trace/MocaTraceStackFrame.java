package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MocaTraceStackFrame {

    public int stackLevel; // Will have 1 stack level per frame.
    public int absoluteLineNum; // For joining up with raw trace file contents relative to entire file.
    public int relativeLineNum; // For joining up with raw trace file contents relative to thread:session combo.
    public String instruction; // Stack frames have 1 instruction.
    public String instructionStatus; // Stack frames have 1 instruction status.
    public HashMap<String, String> published; // What is on the stack at time of instruction invocation.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.
    public ArrayList<String> flows; // Simple list of flow messages.
    public boolean isCommandStatementOrNestedBraces; // Indicates if logger was CommandStatement or if is nested
                                                     // brace instruction.
    public String indentStr; // String that stores tabs/spaces for indenting instruction.
    public boolean isServerGot; // Indicates if match was from "Server got:" regex in message.
    public boolean isCommandInitiated; // Indicates if match was from "Command initiated:" regex in message.
    public String componentLevel; // MOCA command component level.
    public boolean isFiringTriggers; // Indicates if "Firing triggers" instruction.
    public boolean isTrigger; // Indicates if instruction is the first instruction for a trigger (under
                              // "Firing triggers" instruction!).
    public boolean isRemote; // Tells if MOCA command executed on remote host.
    public boolean isPreparedStatement; // Tells if instruction was JDBC prepared statement.
    public int returnedRows; // How many rows returned from instruction.
    public double executionTime; // Execution time for instruction.

    public MocaTraceStackFrame(int stackLevel, int lineNum, int relativeLineNum, String instruction,
            boolean isCommandStatementOrNestedBraces, Stack<MocaTraceStackFrame> indentStack) {
        this.stackLevel = stackLevel;
        this.absoluteLineNum = lineNum;
        this.relativeLineNum = relativeLineNum;
        this.instruction = instruction;
        this.instructionStatus = "";
        this.published = new HashMap<>();
        this.arguments = new HashMap<>();
        this.flows = new ArrayList<>();
        this.isCommandStatementOrNestedBraces = isCommandStatementOrNestedBraces;
        this.indentStr = "";
        this.isServerGot = false;
        this.isCommandInitiated = false;
        this.componentLevel = null;
        this.isFiringTriggers = false;
        this.isTrigger = false;
        this.isRemote = false;
        this.isPreparedStatement = false;
        this.returnedRows = 0;
        this.executionTime = 0.0;

        // Passing in the indent stack so we can use it for setting certain fields.
        if (indentStack.size() > 0) {
            MocaTraceStackFrame curIndentStackFrame = indentStack.peek();
            if (curIndentStackFrame.isFiringTriggers && curIndentStackFrame.stackLevel == this.stackLevel - 1
                    && this.instruction != "}" && this.instruction != "{") {
                this.isTrigger = true;
            }
        }

    }

    public MocaTraceStackFrame(int stackLevel, int lineNum, int relativeLineNum, String instruction,
            String instructionStatus, boolean isCommandStatementOrNestedBraces, String indentStr,
            Stack<MocaTraceStackFrame> indentStack) {
        this.stackLevel = stackLevel;
        this.absoluteLineNum = lineNum;
        this.relativeLineNum = relativeLineNum;
        this.instruction = instruction;
        this.instructionStatus = instructionStatus;
        this.published = new HashMap<>();
        this.arguments = new HashMap<>();
        this.flows = new ArrayList<>();
        this.isCommandStatementOrNestedBraces = isCommandStatementOrNestedBraces;
        this.indentStr = indentStr;
        this.isServerGot = false;
        this.isCommandInitiated = false;
        this.componentLevel = null;
        this.isFiringTriggers = false;
        this.isTrigger = false;
        this.isRemote = false;
        this.isPreparedStatement = false;
        this.returnedRows = 0;
        this.executionTime = 0.0;

        // Passing in the indent stack so we can use it for setting certain fields.
        if (indentStack.size() > 0) {
            MocaTraceStackFrame curIndentStackFrame = indentStack.peek();
            if (curIndentStackFrame.isFiringTriggers && curIndentStackFrame.stackLevel == this.stackLevel - 1
                    && this.instruction != "}" && this.instruction != "{") {
                this.isTrigger = true;
            }
        }
    }

}
