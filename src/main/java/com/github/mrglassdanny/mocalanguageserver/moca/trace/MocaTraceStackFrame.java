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
    public String instructionStatus; // Stack frames have 1 instruction status. Status will be a specific format(set
                                     // by us) that we can analyze.
    public String evaluatingTryCatchCondition; // Placeholder field for storing try-catch evaluation before we set
                                               // instruction status.
    private String instructionPrefix; // Since instruction is not meant to be anything but actual MOCA instruction, we
                                      // will have a prefix string for display purposes. NOTE: we also have text
                                      // decorations that could be before/after instruction, but it should not affect
                                      // this! NOTE: is private since we do not want any outsiders writing to this --
                                      // our public fields will influence what we write to this during our toString
                                      // method. However, there are some circumstances where outsiders do need to
                                      // write to this -- we have a public interface(setInstructionPrefix) for this.
    private String instructionSuffix; // Since instruction is not meant to be anything but actual MOCA instruction, we
                                      // will have a suffix string for display purposes. NOTE: we also have text
                                      // decorations that could be before/after instruction, but it should not affect
                                      // this! NOTE: is private since we do not want any outsiders writing to this --
                                      // our public fields will influence what we write to this during our toString
                                      // method. However, there are some circumstances where outsiders do need to
                                      // write to this -- we have a public interface(setInstructionSuffix) for this.
    public int returnedRows; // How many rows returned from instruction.
    public int previousStackLevelReturnedRows; // How many rows did previous stack level return.
    public int rowNumberToPreviousStackLevel; // Which row am I in regards to previous stack level returned rows.
    public double executionTime; // Execution time for instruction.
    public HashMap<String, String> published; // What is on the stack at time of instruction execution.
    public HashMap<String, String> arguments; // What is being explicitly passed to instruction.
    public boolean isServerGot; // Indicates if match was from "Server got:" regex in message.
    public boolean isCommandInitiated; // Indicates if match was from "Command initiated:" regex in message.
    public boolean isCommandStatement; // Indicates if logger was CommandStatement(includes "{" & "}" for command
                                       // statement, but not nested braces).
    public boolean isNestedBraces; // Indicates if instruction is nested "{" or "}".
    public String componentLevel; // MOCA command component level.
    public boolean isCFunction; // Tells if C function.
    public boolean isJavaMethod; // Tells if Java method.
    public boolean isGroovy; // Tells if Groovy script.
    public boolean isFiringTriggers; // Indicates if "Firing triggers" instruction.
    public boolean isTrigger; // Indicates if instruction is the first instruction for a trigger ("Firing
                              // triggers" stack level - 1).
    public boolean isRemote; // Tells if MOCA command executed on remote host.
    public boolean isPreparedStatement; // Tells if instruction was JDBC prepared statement.
    public String preparedStatementQuery; // Actual query ran -- we will use this for hover instruction instead of
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
        this.evaluatingTryCatchCondition = "";
        this.instructionPrefix = "";
        this.instructionSuffix = "";
        this.returnedRows = 0;
        this.previousStackLevelReturnedRows = 0;
        this.rowNumberToPreviousStackLevel = 0;
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
        this.isGroovy = false;
        this.isFiringTriggers = false;
        this.isTrigger = false;
        this.isRemote = false;
        this.isPreparedStatement = false;
        this.preparedStatementQuery = null;

        // Passing in the indent stack so we can use it for setting certain fields.
        if (indentStack.size() > 0) {
            MocaTraceStackFrame curIndentStackFrame = indentStack.peek();
            if (curIndentStackFrame.isFiringTriggers && curIndentStackFrame.stackLevel == this.stackLevel - 1
                    && this.instruction != "}" && this.instruction != "{") {
                this.isTrigger = true;
            }
        }
    }

    @Override
    public String toString() {

        if (this.rowNumberToPreviousStackLevel > 0 && this.previousStackLevelReturnedRows > 0) {
            this.instructionPrefix = String.format("(%d/%d) ", this.rowNumberToPreviousStackLevel,
                    this.previousStackLevelReturnedRows);
        }

        if (this.returnedRows > 1) {
            this.instructionSuffix = String.format("\t\tReturned %s rows in %.3f seconds", this.returnedRows,
                    this.executionTime);
        } else if (this.returnedRows == 1) {
            this.instructionSuffix = String.format("\t\tReturned %s row in %.3f seconds", this.returnedRows,
                    this.executionTime);
        }

        if (this.instructionStatus != "0" && this.instructionStatus != "Passed" && this.instructionStatus != "Failed") {
            if (this.instructionStatus.contains("Caught")) {
                this.instructionSuffix = String.format("\t\t%s in %.3f seconds", this.instructionStatus,
                        this.executionTime);
            } else {
                this.instructionSuffix = String.format("\t\tReturned (%s) in %.3f seconds", this.instructionStatus,
                        this.executionTime);
            }
        }

        // Make sure to clean up whitespace in instruction.
        return this.indentStr + this.instructionPrefix + this.instruction.replaceAll("\\s+", " ")
                + this.instructionSuffix;
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

        if (this.isFiringTriggers) {
            buf.append(String.format("**%s**\n\n", this.instructionPrefix));
        }

        // Stack args:
        StringBuilder stackArgsBuf = new StringBuilder(1024);
        if (this.published.size() > 0) {
            stackArgsBuf.append("/* On stack */ ");
            stackArgsBuf.append("publish data where ");
        }

        for (Entry<String, String> entry : this.published.entrySet()) {
            if (!entry.getKey().isEmpty()) {
                String value = adjustValue(entry.getValue().trim());
                stackArgsBuf.append(String.format("%s = %s and ", entry.getKey(), value));
            }
        }

        if (stackArgsBuf.length() == 0 && this.arguments.size() > 0) {
            stackArgsBuf.append("/* On stack */ ");
            stackArgsBuf.append("publish data where ");
        }

        for (Entry<String, String> entry : this.arguments.entrySet()) {
            if (!entry.getKey().isEmpty()) {
                String value = adjustValue(entry.getValue().trim());
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

            stackArgsBuf.append("/* Instruction */ ");

            String adjInstruction = this.instruction;
            if (this.isPreparedStatement && this.preparedStatementQuery != null) {
                adjInstruction = this.preparedStatementQuery;
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

    public int getInstructionPrefixLen() {
        return this.instructionPrefix.length();
    }

    public int getInstructionSuffixLen() {
        return this.instructionSuffix.length();
    }

    public void setInstructionPrefix(String instructionPrefix) {
        this.instructionPrefix = instructionPrefix;
    }

    public void setInstructionSuffix(String instructionSuffix) {
        this.instructionSuffix = instructionSuffix;
    }

    private static String adjustValue(String value) {
        String adjValue = value;
        if (adjValue.contains("'") || adjValue.contains("=") || adjValue.contains("<") || adjValue.contains(">")
                || adjValue.contains("{")) {
            adjValue = ("\"" + adjValue.replace("\"", "\"\"") + "\"");
        } else {
            if (adjValue.compareToIgnoreCase("null") != 0) {
                adjValue = ("'" + adjValue + "'");
            }
        }

        return adjValue;
    }
}
