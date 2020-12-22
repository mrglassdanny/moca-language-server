package com.github.mrglassdanny.mocalanguageserver.services.highlight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutline;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutliningResult;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceStackFrame;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.SemanticHighlightingParams;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens.Token;

public class MocaTraceOutlineServiceSemanticHighlightingManager {

    // Integers represent indicies in list sent to MocaLanguageServer.
    private static final int OUTLINE_ID_SCOPES_IDX = 7;
    private static final int SERVER_GOT_SCOPES_IDX = 8;
    private static final int COMMAND_INITIATED_SCOPES_IDX = 9;
    private static final int COMMAND_SCOPES_IDX = 10;
    private static final int FIRING_TRIGGERS_SCOPES_IDX = 11;
    private static final int TRIGGER_SCOPES_IDX = 12;
    private static final int ERROR_SCOPES_IDX = 13;
    private static final int ERROR_CAUGHT_SCOPES = 14;
    private static final int CONDITIONAL_TEST_PASS_SCOPES_IDX = 15;
    private static final int CONDITIONAL_TEST_FAIL_SCOPES_IDX = 16;
    private static final int PREPARED_STATEMENT_SCOPES_IDX = 17;
    private static final int EXCEEDS_EXECUTION_TIME_SCOPES_IDX = 18;
    private static final int C_FUNCTION_SCOPES_IDX = 19;
    private static final int JAVA_METHOD_SCOPES_IDX = 20;
    private static final int INSTRUCTION_PREFIX_SCOPES_IDX = 21;
    private static final int INSTRUCTION_SUFFIX_SCOPES_IDX = 22;
    private static final int UNIMPORTANT_INSTRUCTION_SCOPES_IDX = 23;

    public static List<List<String>> textmateScopes = new ArrayList<>();

    public static void setTextmateScopes() {

        List<String> mocaTraceOutlineOutlineIdScopes = new ArrayList<>();
        mocaTraceOutlineOutlineIdScopes.add("moca.traceoutline.outlineid");

        List<String> mocaTraceOutlineServerGotScopes = new ArrayList<>();
        mocaTraceOutlineServerGotScopes.add("moca.traceoutline.servergot");

        List<String> mocaTraceOutlineCommandInitiatedScopes = new ArrayList<>();
        mocaTraceOutlineCommandInitiatedScopes.add("moca.traceoutline.commandinitiated");

        List<String> mocaTraceOutlineMocaCommandScopes = new ArrayList<>();
        mocaTraceOutlineMocaCommandScopes.add("entity.name.function");

        List<String> mocaTraceOutlineFiringTriggersScopes = new ArrayList<>();
        mocaTraceOutlineFiringTriggersScopes.add("moca.traceoutline.firingtriggers");

        List<String> mocaTraceOutlineTriggerScopes = new ArrayList<>();
        mocaTraceOutlineTriggerScopes.add("moca.traceoutline.trigger");

        List<String> mocaTraceOutlineErrorScopes = new ArrayList<>();
        mocaTraceOutlineErrorScopes.add("moca.traceoutline.error");

        List<String> mocaTraceOutlineErrorCaughtScopes = new ArrayList<>();
        mocaTraceOutlineErrorCaughtScopes.add("moca.traceoutline.error.caught");

        List<String> mocaTraceOutlineConditionalTestPassScopes = new ArrayList<>();
        mocaTraceOutlineConditionalTestPassScopes.add("moca.traceoutline.conditionaltest.pass");

        List<String> mocaTraceOutlineConditionalTestFailScopes = new ArrayList<>();
        mocaTraceOutlineConditionalTestFailScopes.add("moca.traceoutline.conditionaltest.fail");

        List<String> mocaTraceOutlinePreparedStatementScopes = new ArrayList<>();
        mocaTraceOutlinePreparedStatementScopes.add("moca.traceoutline.preparedstatement");

        List<String> mocaTraceOutlineExceedsExecutionTimeScopes = new ArrayList<>();
        mocaTraceOutlineExceedsExecutionTimeScopes.add("moca.traceoutline.exceedsexecutiontime");

        List<String> mocaTraceOutlineCFunctionScopes = new ArrayList<>();
        mocaTraceOutlineCFunctionScopes.add("moca.traceoutline.cfunction");

        List<String> mocaTraceOutlineJavaMethodScopes = new ArrayList<>();
        mocaTraceOutlineJavaMethodScopes.add("moca.traceoutline.javamethod");

        List<String> mocaTraceOutlineInstructionPrefixScopes = new ArrayList<>();
        mocaTraceOutlineInstructionPrefixScopes.add("moca.traceoutline.instructionprefix");

        List<String> mocaTraceOutlineInstructionSuffixScopes = new ArrayList<>();
        mocaTraceOutlineInstructionSuffixScopes.add("moca.traceoutline.instructionsuffix");

        List<String> mocaTraceOutlineUnimportantInstructionScopes = new ArrayList<>();
        mocaTraceOutlineUnimportantInstructionScopes.add("moca.traceoutline.unimportantinstruction");

        textmateScopes.add(mocaTraceOutlineOutlineIdScopes);
        textmateScopes.add(mocaTraceOutlineServerGotScopes);
        textmateScopes.add(mocaTraceOutlineCommandInitiatedScopes);
        textmateScopes.add(mocaTraceOutlineMocaCommandScopes);
        textmateScopes.add(mocaTraceOutlineFiringTriggersScopes);
        textmateScopes.add(mocaTraceOutlineTriggerScopes);
        textmateScopes.add(mocaTraceOutlineErrorScopes);
        textmateScopes.add(mocaTraceOutlineErrorCaughtScopes);
        textmateScopes.add(mocaTraceOutlineConditionalTestPassScopes);
        textmateScopes.add(mocaTraceOutlineConditionalTestFailScopes);
        textmateScopes.add(mocaTraceOutlinePreparedStatementScopes);
        textmateScopes.add(mocaTraceOutlineExceedsExecutionTimeScopes);
        textmateScopes.add(mocaTraceOutlineCFunctionScopes);
        textmateScopes.add(mocaTraceOutlineJavaMethodScopes);
        textmateScopes.add(mocaTraceOutlineInstructionPrefixScopes);
        textmateScopes.add(mocaTraceOutlineInstructionSuffixScopes);
        textmateScopes.add(mocaTraceOutlineUnimportantInstructionScopes);

    }

    public static void streamAll(String uriStr) {

        // Prepare to add new highlights.
        List<SemanticHighlightingInformation> lines = new ArrayList<>();
        VersionedTextDocumentIdentifier versionTextDoc = new VersionedTextDocumentIdentifier(uriStr, 1);

        // Get semantic highlights.
        HashMap<Integer, ArrayList<Token>> preInfos = getMocaTraceOutlineHighlights(uriStr);

        // Now steam all semantic highlights.
        for (Map.Entry<Integer, ArrayList<Token>> entry : preInfos.entrySet()) {

            String tokensStr = SemanticHighlightingTokens.encode(entry.getValue());
            SemanticHighlightingInformation info = new SemanticHighlightingInformation(entry.getKey(), tokensStr);
            info.setTokens(tokensStr);
            lines.add(info);
        }

        SemanticHighlightingParams params = new SemanticHighlightingParams(versionTextDoc, lines);
        MocaServices.languageClient.semanticHighlighting(params);
    }

    // Can do all work in one function, contrary to
    // MocaCompilationServiceSemanticHighlightingManager.
    public static HashMap<Integer, ArrayList<Token>> getMocaTraceOutlineHighlights(String uriStr) {
        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        MocaTraceOutliningResult mocaTraceOutliningResult = MocaServices.mocaTraceOutliningResultMap.get(uriStr);

        // Make sure we have a working trace outline result.
        if (mocaTraceOutliningResult != null) {

            for (int outlineIdLineNum : mocaTraceOutliningResult.outlineIdLineNumbers) {
                Position pos = new Position(outlineIdLineNum, 0);
                if (preInfos.containsKey(pos.getLine())) {
                    preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), 1,
                            MocaTraceOutlineServiceSemanticHighlightingManager.OUTLINE_ID_SCOPES_IDX));
                } else {
                    ArrayList<Token> tokensArr = new ArrayList<>();
                    tokensArr.add(new Token(pos.getCharacter(), 1,
                            MocaTraceOutlineServiceSemanticHighlightingManager.OUTLINE_ID_SCOPES_IDX));
                    preInfos.put(pos.getLine(), tokensArr);
                }
            }

            int lineNum = 1;
            for (MocaTraceOutline outline : mocaTraceOutliningResult.outlines) {

                for (MocaTraceStackFrame frame : outline.frames) {

                    if (frame.isServerGot) {
                        Position pos = new Position(lineNum, 0);
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine())
                                    .add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length()
                                                    + frame.getInstructionPrefixLen() + frame.getInstructionSuffixLen(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.SERVER_GOT_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(),
                                    frame.instruction.length() + frame.indentStr.length()
                                            + frame.getInstructionPrefixLen() + frame.getInstructionSuffixLen(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.SERVER_GOT_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.isCommandInitiated) {
                        Position pos = new Position(lineNum, frame.instruction.length() + frame.indentStr.length()
                                + frame.getInstructionPrefixLen() + frame.getInstructionSuffixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_INITIATED_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_INITIATED_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.componentLevel != null) {
                        Position pos = new Position(lineNum,
                                frame.indentStr.length() + frame.getInstructionPrefixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.isTrigger) {
                        Position pos = new Position(lineNum,
                                frame.indentStr.length() + frame.getInstructionPrefixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.TRIGGER_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.TRIGGER_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.instructionStatus != "0") {
                        if (frame.instructionStatus == "Passed") {
                            Position pos = new Position(lineNum, frame.instruction.length() + frame.indentStr.length()
                                    + frame.getInstructionPrefixLen() + frame.getInstructionSuffixLen());
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), 0,
                                        MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_PASS_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), 0,
                                        MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_PASS_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        } else if (frame.instructionStatus == "Failed") {
                            Position pos = new Position(lineNum, frame.instruction.length() + frame.indentStr.length()
                                    + frame.getInstructionPrefixLen() + frame.getInstructionSuffixLen());
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), 0,
                                        MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_FAIL_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), 0,
                                        MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_FAIL_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        } else if (frame.instructionStatus.contains("Caught")) {
                            Position pos = new Position(lineNum,
                                    frame.indentStr.length() + frame.getInstructionPrefixLen());
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_CAUGHT_SCOPES));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), frame.instruction.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_CAUGHT_SCOPES));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        } else {
                            Position pos = new Position(lineNum,
                                    frame.indentStr.length() + frame.getInstructionPrefixLen());
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine())
                                        .add(new Token(pos.getCharacter(), frame.instruction.length(),
                                                MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), frame.instruction.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.isPreparedStatement) {
                        Position pos = new Position(lineNum,
                                frame.indentStr.length() + frame.getInstructionPrefixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.PREPARED_STATEMENT_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.PREPARED_STATEMENT_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.executionTime >= mocaTraceOutliningResult.minimumExecutionTime) {
                        Position pos = new Position(lineNum,
                                frame.indentStr.length() + frame.getInstructionPrefixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.EXCEEDS_EXECUTION_TIME_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.EXCEEDS_EXECUTION_TIME_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.isCFunction) {
                        Position pos = new Position(lineNum, frame.instruction.length() + frame.indentStr.length()
                                + frame.getInstructionPrefixLen() + frame.getInstructionSuffixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.C_FUNCTION_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.C_FUNCTION_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.isJavaMethod) {
                        Position pos = new Position(lineNum, frame.instruction.length() + frame.indentStr.length()
                                + frame.getInstructionPrefixLen() + frame.getInstructionSuffixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.JAVA_METHOD_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), 0,
                                    MocaTraceOutlineServiceSemanticHighlightingManager.JAVA_METHOD_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.getInstructionPrefixLen() > 0) {
                        // Firing triggers indication will be in instruction prefix, but we want to
                        // color it differently.
                        if (frame.isFiringTriggers) {
                            Position pos = new Position(lineNum, frame.indentStr.length());
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.getInstructionPrefixLen(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.FIRING_TRIGGERS_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), frame.getInstructionPrefixLen(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.FIRING_TRIGGERS_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        } else {
                            // Regular instruction prefix decoration.
                            Position pos = new Position(lineNum, frame.indentStr.length());
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.getInstructionPrefixLen(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.INSTRUCTION_PREFIX_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), frame.getInstructionPrefixLen(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.INSTRUCTION_PREFIX_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }

                    }

                    if (frame.getInstructionSuffixLen() > 0) {
                        Position pos = new Position(lineNum, frame.indentStr.length() + frame.getInstructionPrefixLen()
                                + frame.instruction.length());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                    frame.getInstructionSuffixLen(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.INSTRUCTION_SUFFIX_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), frame.getInstructionSuffixLen(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.INSTRUCTION_SUFFIX_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    if (frame.isUnimportantInstruction) {
                        Position pos = new Position(lineNum,
                                frame.indentStr.length() + frame.getInstructionPrefixLen());
                        if (preInfos.containsKey(pos.getLine())) {
                            preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.UNIMPORTANT_INSTRUCTION_SCOPES_IDX));
                        } else {
                            ArrayList<Token> tokensArr = new ArrayList<>();
                            tokensArr.add(new Token(pos.getCharacter(), frame.instruction.length(),
                                    MocaTraceOutlineServiceSemanticHighlightingManager.UNIMPORTANT_INSTRUCTION_SCOPES_IDX));
                            preInfos.put(pos.getLine(), tokensArr);
                        }
                    }

                    lineNum++;
                }
                // Need to increment here since we are still writing outline ID comment.
                lineNum++;
            }

        }

        return preInfos;
    }

}
