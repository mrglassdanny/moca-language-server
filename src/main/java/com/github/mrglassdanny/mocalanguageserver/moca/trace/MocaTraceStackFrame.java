package com.github.mrglassdanny.mocalanguageserver.moca.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map.Entry;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.format.MocaFormatter;

public class MocaTraceStackFrame {

    public String outlineId; // ID for outline.
    public int stackLevel; // Will have 1 stack level per frame.
    public int absoluteLineNum; // For joining up with raw trace file contents relative to entire file. Line
                                // numbers start at 1.
    public int relativeLineNum; // For joining up with raw trace file contents relative to outline ID. Line
                                // numbers start at 1.
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

    public MocaTraceStackFrame(String outlineId, int stackLevel, int lineNum, int relativeLineNum, String instruction,
            String instructionStatus, boolean isCommandStatementOrNestedBraces, String indentStr,
            Stack<MocaTraceStackFrame> indentStack) {
        this.outlineId = outlineId;
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

    public String getMarkdownStr() {

        StringBuilder buf = new StringBuilder(2048);

        if (this.instructionStatus != "0") {
            buf.append(String.format("Status: **%s**\n\n", this.instructionStatus));
        }

        buf.append(String.format("Rows Returned: **%d**\n\n", this.returnedRows));
        buf.append(String.format("Execution Time: **%s** seconds\n\n", this.executionTime));

        if (this.componentLevel != null) {
            buf.append(String.format("Component Level: **%s**\n\n", this.componentLevel));
        }

        if (this.isFiringTriggers) {

        }

        if (this.isTrigger) {

        }

        // Published args:
        StringBuilder argsBuf = new StringBuilder(1024);
        if (this.published.size() > 0) {
            argsBuf.append("/* Published */ ");
            argsBuf.append("publish data where ");
        }
        for (Entry<String, String> entry : this.published.entrySet()) {
            if (!entry.getKey().isEmpty()) {
                String value = entry.getValue().trim();
                if (value.contains("'")) {
                    value = ("\"" + value + "\"");
                } else {
                    if (value.compareToIgnoreCase("null") != 0) {
                        value = ("'" + value + "'");
                    }
                }
                argsBuf.append(String.format("%s = %s and ", entry.getKey(), value));
            }
        }
        // Remove last ' and '.
        if (argsBuf.length() > 1) {
            argsBuf.delete(argsBuf.length() - 5, argsBuf.length() - 1);
            argsBuf.append(" | ");
        }

        // Argument args:
        if (this.arguments.size() > 0) {
            argsBuf.append("/* Arguments */ ");
            argsBuf.append("publish data where ");
        }
        for (Entry<String, String> entry : this.arguments.entrySet()) {
            if (!entry.getKey().isEmpty()) {
                String value = entry.getValue().trim();
                if (value.contains("'")) {
                    value = ("\"" + value + "\"");
                } else {
                    if (value.compareToIgnoreCase("null") != 0) {
                        value = ("'" + value + "'");
                    }
                }
                argsBuf.append(String.format("%s = %s and ", entry.getKey(), value));
            }
        }
        // Remove last ' and '.
        if (argsBuf.length() > 1) {
            argsBuf.delete(argsBuf.length() - 5, argsBuf.length() - 1);
            argsBuf.append(" | ");
        }

        // Instruction:
        if (this.instruction != "{" && this.instruction != "}") {
            String formattedScript = MocaFormatter.format(argsBuf.toString() + this.instruction);
            if (formattedScript != null) {
                buf.append(String.format("```moca\n\n%s\n\n```", formattedScript));
            } else {
                buf.append(String.format("```moca\n\n%s\n\n```", argsBuf.toString() + this.instruction));
            }
        } else {
            // Remove " | ".
            if (argsBuf.length() > 1) {
                argsBuf.delete(argsBuf.length() - 3, argsBuf.length() - 1);
                argsBuf.append(" & ");
            }

            String formattedScript = MocaFormatter.format(argsBuf.toString());
            if (formattedScript != null) {
                buf.append(String.format("```moca\n\n%s\n\n```", formattedScript));
            } else {
                buf.append(String.format("```moca\n\n%s\n\n```", argsBuf.toString()));
            }
        }

        return buf.toString();
    }

}
