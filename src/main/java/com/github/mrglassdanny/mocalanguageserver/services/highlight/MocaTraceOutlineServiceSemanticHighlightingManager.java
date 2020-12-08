package com.github.mrglassdanny.mocalanguageserver.services.highlight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutline;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutlineResult;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceStackFrame;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.SemanticHighlightingParams;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens.Token;

public class MocaTraceOutlineServiceSemanticHighlightingManager {

    // Integers represent indicies in list sent to MocaLanguageServer.
    private static final int SERVER_GOT_SCOPES_IDX = 7;
    private static final int COMMAND_INITIATED_SCOPES_IDX = 8;
    private static final int COMMAND_SCOPES_IDX = 9;
    private static final int FIRING_TRIGGERS_SCOPES_IDX = 10;
    private static final int TRIGGER_SCOPES_IDX = 11;
    private static final int ERROR_SCOPES_IDX = 12;
    private static final int ERROR_CAUGHT_SCOPES = 13;
    private static final int CONDITIONAL_TEST_PASS_SCOPES_IDX = 14;
    private static final int CONDITIONAL_TEST_FAIL_SCOPES_IDX = 15;
    private static final int PREPARED_STATEMENT_SCOPES_IDX = 16;
    private static final int EXECUTION_TIME_SCOPES_IDX = 17;
    private static final int C_FUNCTION_SCOPES_IDX = 18;
    private static final int JAVA_METHOD_SCOPES_IDX = 19;

    public static List<List<String>> textmateScopes = new ArrayList<>();

    public static void setTextmateScopes() {

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

        List<String> mocaTraceOutlineExecutionTimeScopes = new ArrayList<>();
        mocaTraceOutlineExecutionTimeScopes.add("moca.traceoutline.executiontime");

        List<String> mocaTraceOutlineCFunctionScopes = new ArrayList<>();
        mocaTraceOutlineCFunctionScopes.add("moca.traceoutline.cfunction");

        List<String> mocaTraceOutlineJavaMethodScopes = new ArrayList<>();
        mocaTraceOutlineJavaMethodScopes.add("moca.traceoutline.javamethod");

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
        textmateScopes.add(mocaTraceOutlineExecutionTimeScopes);
        textmateScopes.add(mocaTraceOutlineCFunctionScopes);
        textmateScopes.add(mocaTraceOutlineJavaMethodScopes);

    }

    public static void streamAll(String uriStr) {

        // Prepare to add new highlights.
        List<SemanticHighlightingInformation> lines = new ArrayList<>();
        VersionedTextDocumentIdentifier versionTextDoc = new VersionedTextDocumentIdentifier(uriStr, 1);

        // Get semantic highlights.
        HashMap<Integer, ArrayList<Token>> preInfos = getMocaTraceOutlineHighlights();

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
    public static HashMap<Integer, ArrayList<Token>> getMocaTraceOutlineHighlights() {
        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        MocaTraceOutlineResult mocaTraceOutlineResult = MocaServices.mocaTraceOutlineResult;

        // Go ahead and stop now if null compilation result.
        if (mocaTraceOutlineResult != null) {

            int lineNum = 1;
            for (MocaTraceOutline outline : mocaTraceOutlineResult.outlines) {

                for (MocaTraceStackFrame frame : outline.frames) {

                    if (frame.isServerGot) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.SERVER_GOT_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.SERVER_GOT_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.isCommandInitiated) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_INITIATED_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_INITIATED_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.componentLevel != null) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine())
                                        .add(new Token(pos.getCharacter(),
                                                frame.instruction.length() + frame.indentStr.length(),
                                                MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.COMMAND_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.isFiringTriggers) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.FIRING_TRIGGERS_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.FIRING_TRIGGERS_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.isTrigger) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine())
                                        .add(new Token(pos.getCharacter(),
                                                frame.instruction.length() + frame.indentStr.length(),
                                                MocaTraceOutlineServiceSemanticHighlightingManager.TRIGGER_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.TRIGGER_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.instructionStatus != "0") {
                        if (frame.instructionStatus == "Passed") {
                            Position pos = new Position(lineNum, 0);
                            if (pos != null) {
                                if (preInfos.containsKey(pos.getLine())) {
                                    preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_PASS_SCOPES_IDX));
                                } else {
                                    ArrayList<Token> tokensArr = new ArrayList<>();
                                    tokensArr.add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_PASS_SCOPES_IDX));
                                    preInfos.put(pos.getLine(), tokensArr);
                                }
                            }
                        } else if (frame.instructionStatus == "Failed") {
                            Position pos = new Position(lineNum, 0);
                            if (pos != null) {
                                if (preInfos.containsKey(pos.getLine())) {
                                    preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_FAIL_SCOPES_IDX));
                                } else {
                                    ArrayList<Token> tokensArr = new ArrayList<>();
                                    tokensArr.add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.CONDITIONAL_TEST_FAIL_SCOPES_IDX));
                                    preInfos.put(pos.getLine(), tokensArr);
                                }
                            }
                        } else if (frame.instructionStatus.contains("Caught")) {
                            Position pos = new Position(lineNum, 0);
                            if (pos != null) {
                                if (preInfos.containsKey(pos.getLine())) {
                                    preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_CAUGHT_SCOPES));
                                } else {
                                    ArrayList<Token> tokensArr = new ArrayList<>();
                                    tokensArr.add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_CAUGHT_SCOPES));
                                    preInfos.put(pos.getLine(), tokensArr);
                                }
                            }
                        } else {
                            Position pos = new Position(lineNum, 0);
                            if (pos != null) {
                                if (preInfos.containsKey(pos.getLine())) {
                                    preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_SCOPES_IDX));
                                } else {
                                    ArrayList<Token> tokensArr = new ArrayList<>();
                                    tokensArr.add(new Token(pos.getCharacter(),
                                            frame.instruction.length() + frame.indentStr.length(),
                                            MocaTraceOutlineServiceSemanticHighlightingManager.ERROR_SCOPES_IDX));
                                    preInfos.put(pos.getLine(), tokensArr);
                                }
                            }
                        }
                    }

                    if (frame.isPreparedStatement) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.PREPARED_STATEMENT_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.PREPARED_STATEMENT_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    // 1 second is significant enough!
                    if (frame.executionTime > 1.0) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.EXECUTION_TIME_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.EXECUTION_TIME_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.isCFunction) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.C_FUNCTION_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.C_FUNCTION_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    if (frame.isJavaMethod) {
                        Position pos = new Position(lineNum, 0);
                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.JAVA_METHOD_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(),
                                        frame.instruction.length() + frame.indentStr.length(),
                                        MocaTraceOutlineServiceSemanticHighlightingManager.JAVA_METHOD_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
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
