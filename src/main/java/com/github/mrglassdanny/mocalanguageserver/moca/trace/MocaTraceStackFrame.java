package com.github.mrglassdanny.mocalanguageserver.moca.trace;

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
    public String indentStr; // String that stores tabs/spaces for indenting instruction.
    public String instruction; // Stack frames have 1 instruction. Instruction is meant to be close to actual
                               // MOCA instruction.
    public String instructionStatus; // Stack frames have 1 instruction status. Status will be a specific format that
                                     // we can analyze.
    public String instructionPrefix; // Since instruction is not meant to be anything but actual MOCA instruction, we
                                     // will have a prefix string for display purposes.
    public String instructionSuffix; // Since instruction is not meant to be anything but actual MOCA instruction, we
                                     // will have a suffix string for display purposes.
    public int returnedRows; // How many rows returned from instruction.
    public int parentReturnedRows; // How many rows did parent instruction return.
    public int rowNumber; // Which row am I in regards to parent instruction returned rows.
    public double executionTime; // Execution time for instruction.
    public HashMap<String, String> published; // What is on the stack at time of instruction invocation.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.
    public boolean isServerGot; // Indicates if match was from "Server got:" regex in message.
    public boolean isCommandInitiated; // Indicates if match was from "Command initiated:" regex in message.
    public boolean isCommandStatement; // Indicates if logger was CommandStatement(includes "{" & "}" for command
                                       // statement, but not nested braces).
    public boolean isNestedBraces; // Indicates if instruction is nested "{" or "}".
    public String componentLevel; // MOCA command component level.
    public boolean isCFunction; // Tells if C function.
    public boolean isJavaMethod; // Tells if Java method.
    public boolean isFiringTriggers; // Indicates if "Firing triggers" instruction.
    public boolean isTrigger; // Indicates if instruction is the first instruction for a trigger (under
                              // "Firing triggers" instruction!).
    public boolean isRemote; // Tells if MOCA command executed on remote host.
    public boolean isPreparedStatement; // Tells if instruction was JDBC prepared statement.
    public String actualPreparedStatementQuery; // Actual query ran -- we will use this for hover instruction instead of
                                                // actual instruction(actual contains '?'s!).

    public MocaTraceStackFrame(String outlineId, int stackLevel, int lineNum, int relativeLineNum, String instruction,
            String instructionStatus, boolean isCommandStatement, boolean isNestedBraces, String indentStr,
            Stack<MocaTraceStackFrame> indentStack) {
        this.outlineId = outlineId;
        this.stackLevel = stackLevel;
        this.absoluteLineNum = lineNum;
        this.relativeLineNum = relativeLineNum;
        this.indentStr = indentStr;
        this.instruction = instruction;
        this.instructionStatus = instructionStatus;
        this.instructionPrefix = "";
        this.instructionSuffix = "";
        this.returnedRows = 0;
        this.parentReturnedRows = 0;
        this.rowNumber = 0;
        this.executionTime = 0.0;
        this.published = new HashMap<>();
        this.arguments = new HashMap<>();
        this.isServerGot = false;
        this.isCommandInitiated = false;
        this.isCommandStatement = isCommandStatement;
        this.isNestedBraces = isNestedBraces;
        this.componentLevel = null;
        this.isCFunction = false;
        this.isJavaMethod = false;
        this.isFiringTriggers = false;
        this.isTrigger = false;
        this.isRemote = false;
        this.isPreparedStatement = false;
        this.actualPreparedStatementQuery = null;

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

        buf.append(String.format("Stack Level: **%d**\n\n", this.stackLevel));

        if (this.instructionStatus != "0") {
            buf.append(String.format("Status: **%s**\n\n", this.instructionStatus));
        }

        buf.append(String.format("Rows Returned: **%d**\n\n", this.returnedRows));
        buf.append(String.format("Execution Time: **%s** seconds\n\n", this.executionTime));

        if (this.componentLevel != null) {
            buf.append(String.format("Component Level: **%s**\n\n", this.componentLevel));

            if (this.isCFunction) {
                buf.append(String.format("Type: **C Function**\n\n"));
            } else if (this.isJavaMethod) {
                buf.append(String.format("Type: **Java Method**\n\n"));
            } else {
                buf.append(String.format("Type: **Local Syntax**\n\n"));
            }
        }

        if (this.isTrigger) {
            buf.append("Is Trigger: **true**\n\n");
        }

        // Published args:
        StringBuilder stackArgsBuf = new StringBuilder(1024);
        if (this.published.size() > 0) {
            stackArgsBuf.append("/* On stack */ ");
            stackArgsBuf.append("publish data where ");
        }
        for (Entry<String, String> entry : this.published.entrySet()) {
            if (!entry.getKey().isBlank()) {
                String value = entry.getValue().trim();
                if (value.contains("'") || value.contains("=") || value.contains("<") || value.contains(">")) {
                    value = ("\"" + value + "\"");
                } else {
                    if (value.compareToIgnoreCase("null") != 0) {
                        value = ("'" + value + "'");
                    }
                }
                stackArgsBuf.append(String.format("%s = %s and ", entry.getKey(), value));
            }
        }

        if (stackArgsBuf.length() == 0 && this.arguments.size() > 0) {
            stackArgsBuf.append("/* On stack */ ");
            stackArgsBuf.append("publish data where ");
        }
        for (Entry<String, String> entry : this.arguments.entrySet()) {
            if (!entry.getKey().isEmpty()) {
                String value = entry.getValue().trim();
                if (value.contains("'") || value.contains("=") || value.contains("<") || value.contains(">")) {
                    value = ("\"" + value + "\"");
                } else {
                    if (value.compareToIgnoreCase("null") != 0) {
                        value = ("'" + value + "'");
                    }
                }
                stackArgsBuf.append(String.format("%s = %s and ", entry.getKey(), value));
            }
        }
        // Remove last ' and '.
        if (stackArgsBuf.length() > 1) {
            stackArgsBuf.delete(stackArgsBuf.length() - 5, stackArgsBuf.length() - 1);
        }

        // Instruction:
        if (this.instruction != "{" && this.instruction != "}") {

            if (stackArgsBuf.length() > 0) {
                // Pipe down to instruction.
                stackArgsBuf.append(" | ");
            }

            String adjInstruction = this.instruction;
            if (this.isPreparedStatement && this.actualPreparedStatementQuery != null) {
                adjInstruction = this.actualPreparedStatementQuery;
            }

            String formattedScript;
            // Formatter could throw exception.
            try {
                formattedScript = MocaFormatter.format(stackArgsBuf.toString() + adjInstruction);
            } catch (Exception e) {
                formattedScript = null;
            }
            if (formattedScript != null) {
                buf.append(String.format("```moca\n\n%s\n\n```", formattedScript));
            } else {
                buf.append(String.format("```moca\n\n%s\n\n```", stackArgsBuf.toString() + adjInstruction));
            }
        } else {
            // If here, we dont have an instruction... this probably wont happen.
            String formattedScript;
            // Formatter could throw exception.
            try {
                formattedScript = MocaFormatter.format(stackArgsBuf.toString());
            } catch (Exception e) {
                formattedScript = null;
            }

            if (formattedScript != null) {
                buf.append(String.format("```moca\n\n%s\n\n```", formattedScript));
            } else {
                buf.append(String.format("```moca\n\n%s\n\n```", stackArgsBuf.toString()));
            }
        }

        return buf.toString();
    }

}
