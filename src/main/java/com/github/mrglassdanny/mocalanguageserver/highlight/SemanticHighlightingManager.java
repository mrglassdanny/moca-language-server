package com.github.mrglassdanny.mocalanguageserver.highlight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.mrglassdanny.mocalanguageserver.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCache;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.MocaSqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.util.MocaSqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.SemanticHighlightingParams;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens.Token;

public class SemanticHighlightingManager {

    private static final int MOCASQL_RANGE_SCOPES_IDX = 0;
    private static final int MOCASQL_RANGE_LAST_LINE_SCOPES_IDX = 1;
    private static final int GROOVY_RANGE_SCOPES_IDX = 2;
    private static final int GROOVY_RANGE_LAST_LINE_SCOPES_IDX = 3;
    private static final int MOCA_COMMAND_SCOPES_IDX = 4;
    private static final int MOCA_COMMAND_STREAM_END_SCOPES_IDX = 5;
    private static final int MOCASQL_TABLE_SCOPES_IDX = 6;

    public static List<List<String>> textmateScopes = new ArrayList<>();

    public static void setTextmateScopes() {

        List<String> mocaSqlRangeScopes = new ArrayList<>();
        mocaSqlRangeScopes.add("moca.sql");

        List<String> mocaSqlRangeLastLineScopes = new ArrayList<>();
        mocaSqlRangeLastLineScopes.add("moca.sql.lastline");

        List<String> groovyRangeScopes = new ArrayList<>();
        groovyRangeScopes.add("moca.groovy");

        List<String> groovyRangeLastLineScopes = new ArrayList<>();
        groovyRangeLastLineScopes.add("moca.groovy.lastline");

        List<String> mocaCommandScopes = new ArrayList<>();
        mocaCommandScopes.add("entity.name.function");

        List<String> mocaCommandStreamEndScopes = new ArrayList<>();
        mocaCommandStreamEndScopes.add("moca.commandstream.end");

        List<String> mocaSqlTableScopes = new ArrayList<>();
        mocaSqlTableScopes.add("entity.name.type.class");

        textmateScopes.add(mocaSqlRangeScopes);
        textmateScopes.add(mocaSqlRangeLastLineScopes);
        textmateScopes.add(groovyRangeScopes);
        textmateScopes.add(groovyRangeLastLineScopes);
        textmateScopes.add(mocaCommandScopes);
        textmateScopes.add(mocaCommandStreamEndScopes);
        textmateScopes.add(mocaSqlTableScopes);
    }

    public static void streamAll(String uriStr, String mocaScript) {

        // Prepare to add new highlights.
        List<SemanticHighlightingInformation> lines = new ArrayList<>();
        VersionedTextDocumentIdentifier versionTextDoc = new VersionedTextDocumentIdentifier(uriStr, 1);
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        // Get semantic highlights.
        HashMap<Integer, ArrayList<Token>> mocaSqlRangePreInfos = getMocaSqlRangeSemanticHighlightings(lines,
                mocaScript);
        for (Map.Entry<Integer, ArrayList<Token>> entry : mocaSqlRangePreInfos.entrySet()) {

            int lineNum = entry.getKey();
            if (preInfos.containsKey(lineNum)) {
                preInfos.get(lineNum).addAll(entry.getValue());
            } else {
                ArrayList<Token> arr = new ArrayList<>();
                arr.addAll(entry.getValue());
                preInfos.put(lineNum, arr);
            }
        }
        HashMap<Integer, ArrayList<Token>> groovyRangePreInfos = getGroovyRangeSemanticHighlightings(lines, mocaScript);
        for (Map.Entry<Integer, ArrayList<Token>> entry : groovyRangePreInfos.entrySet()) {

            int lineNum = entry.getKey();
            if (preInfos.containsKey(lineNum)) {
                preInfos.get(lineNum).addAll(entry.getValue());
            } else {
                ArrayList<Token> arr = new ArrayList<>();
                arr.addAll(entry.getValue());
                preInfos.put(lineNum, arr);
            }
        }
        HashMap<Integer, ArrayList<Token>> mocaCommandPreInfos = getMocaCommandSemanticHighlightings(lines, mocaScript);
        for (Map.Entry<Integer, ArrayList<Token>> entry : mocaCommandPreInfos.entrySet()) {

            int lineNum = entry.getKey();
            if (preInfos.containsKey(lineNum)) {
                preInfos.get(lineNum).addAll(entry.getValue());
            } else {
                ArrayList<Token> arr = new ArrayList<>();
                arr.addAll(entry.getValue());
                preInfos.put(lineNum, arr);
            }
        }
        HashMap<Integer, ArrayList<Token>> mocaCommandStreamEndPreInfos = getMocaCommandStreamEndSemanticHighlightings(
                lines, mocaScript);
        for (Map.Entry<Integer, ArrayList<Token>> entry : mocaCommandStreamEndPreInfos.entrySet()) {

            int lineNum = entry.getKey();
            if (preInfos.containsKey(lineNum)) {
                preInfos.get(lineNum).addAll(entry.getValue());
            } else {
                ArrayList<Token> arr = new ArrayList<>();
                arr.addAll(entry.getValue());
                preInfos.put(lineNum, arr);
            }
        }
        HashMap<Integer, ArrayList<Token>> mocaSqlTablePreInfos = getMocaSqlTableSemanticHighlightings(lines,
                mocaScript);
        for (Map.Entry<Integer, ArrayList<Token>> entry : mocaSqlTablePreInfos.entrySet()) {

            int lineNum = entry.getKey();
            if (preInfos.containsKey(lineNum)) {
                preInfos.get(lineNum).addAll(entry.getValue());
            } else {
                ArrayList<Token> arr = new ArrayList<>();
                arr.addAll(entry.getValue());
                preInfos.put(lineNum, arr);
            }
        }

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

    public static HashMap<Integer, ArrayList<Token>> getMocaSqlRangeSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        for (Range mocaSqlRange : MocaServices.mocaCompilationResult.mocaSqlRanges) {
            int firstLine = mocaSqlRange.getStart().getLine();
            int lastLine = mocaSqlRange.getEnd().getLine();

            for (int i = firstLine; i < lastLine; i++) {
                if (preInfos.containsKey(i)) {
                    preInfos.get(i).add(new Token(0, 5, MOCASQL_RANGE_SCOPES_IDX));
                } else {
                    ArrayList<Token> tokensArr = new ArrayList<>();
                    tokensArr.add(new Token(0, 5, MOCASQL_RANGE_SCOPES_IDX));
                    preInfos.put(i, tokensArr);
                }
            }

            // Add last line now.
            if (preInfos.containsKey(lastLine)) {
                preInfos.get(lastLine)
                        .add(new Token(0, mocaSqlRange.getEnd().getCharacter(), MOCASQL_RANGE_LAST_LINE_SCOPES_IDX));
            } else {
                ArrayList<Token> tokensArr = new ArrayList<>();
                tokensArr.add(new Token(0, mocaSqlRange.getEnd().getCharacter(), MOCASQL_RANGE_LAST_LINE_SCOPES_IDX));
                preInfos.put(lastLine, tokensArr);
            }

        }

        return preInfos;

    }

    public static HashMap<Integer, ArrayList<Token>> getGroovyRangeSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();
        for (Range groovyRange : MocaServices.mocaCompilationResult.groovyRanges) {
            int firstLine = groovyRange.getStart().getLine();
            int lastLine = groovyRange.getEnd().getLine();

            for (int i = firstLine; i < lastLine; i++) {
                if (preInfos.containsKey(i)) {
                    preInfos.get(i).add(new Token(0, 1, GROOVY_RANGE_SCOPES_IDX));
                } else {
                    ArrayList<Token> tokensArr = new ArrayList<>();
                    tokensArr.add(new Token(0, 1, GROOVY_RANGE_SCOPES_IDX));
                    preInfos.put(i, tokensArr);
                }
            }

            // Add last line now.
            if (preInfos.containsKey(lastLine)) {
                preInfos.get(lastLine)
                        .add(new Token(0, groovyRange.getEnd().getCharacter(), GROOVY_RANGE_LAST_LINE_SCOPES_IDX));
            } else {
                ArrayList<Token> tokensArr = new ArrayList<>();
                tokensArr.add(new Token(0, groovyRange.getEnd().getCharacter(), GROOVY_RANGE_LAST_LINE_SCOPES_IDX));
                preInfos.put(lastLine, tokensArr);
            }
        }
        return preInfos;

    }

    public static HashMap<Integer, ArrayList<Token>> getMocaCommandSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        MocaCompilationResult mocaCompilationResult = MocaServices.mocaCompilationResult;

        // Go ahead and stop now if null compilation result.
        if (mocaCompilationResult != null) {
            for (Map.Entry<StringBuilder, ArrayList<org.antlr.v4.runtime.Token>> entry : mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                    .entrySet()) {

                StringBuilder verbNounClause = entry.getKey();
                ArrayList<org.antlr.v4.runtime.Token> mocaTokens = entry.getValue();
                if (verbNounClause != null) {

                    // Make sure command exists before we color it.
                    if (MocaCache.getGlobalMocaCache().commands.containsKey(verbNounClause.toString())) {
                        Position pos = PositionUtils.getPosition(mocaScript, mocaTokens.get(0).getStartIndex());

                        if (pos != null) {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine()).add(new Token(pos.getCharacter(), verbNounClause.length(),
                                        MOCA_COMMAND_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), verbNounClause.length(),
                                        MOCA_COMMAND_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }
                }
            }
        }

        return preInfos;
    }

    public static HashMap<Integer, ArrayList<Token>> getMocaCommandStreamEndSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        for (org.antlr.v4.runtime.Token mocaToken : MocaServices.mocaCompilationResult.mocaTokens) {
            if (mocaToken.getType() == MocaLexer.SEMI_COLON) {
                Position pos = PositionUtils.getPosition(mocaScript, mocaToken.getStartIndex());
                int lineNum = pos.getLine();
                if (preInfos.containsKey(lineNum)) {
                    preInfos.get(lineNum).add(new Token(0, pos.getCharacter(), MOCA_COMMAND_STREAM_END_SCOPES_IDX));
                } else {
                    ArrayList<Token> tokensArr = new ArrayList<>();
                    tokensArr.add(new Token(0, pos.getCharacter(), MOCA_COMMAND_STREAM_END_SCOPES_IDX));
                    preInfos.put(lineNum, tokensArr);
                }
            }
        }

        return preInfos;
    }

    public static HashMap<Integer, ArrayList<Token>> getMocaSqlTableSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        for (int i = 0; i < MocaServices.mocaCompilationResult.mocaSqlRanges.size(); i++) {

            MocaSqlCompilationResult mocaSqlCompilationResult = MocaServices.mocaCompilationResult.mocaSqlCompilationResults
                    .get(i);

            // Quit now if no compilation result.
            if (mocaSqlCompilationResult != null) {

                for (org.antlr.v4.runtime.Token tableToken : mocaSqlCompilationResult.mocaSqlParseTreeListener.tableTokens) {

                    Position pos = MocaSqlLanguageUtils.createMocaPosition(tableToken.getLine(),
                            tableToken.getCharPositionInLine(),
                            MocaServices.mocaCompilationResult.mocaSqlRanges.get(i));

                    String word = tableToken.getText().toLowerCase();

                    // Check if exists in tables/views before we add to map.
                    if (MocaCache.getGlobalMocaCache().mocaSqlCache.tables.containsKey(word)
                            || MocaCache.getGlobalMocaCache().mocaSqlCache.views.containsKey(word)) {

                        // Let's make sure real quick that this is not a '@' var.
                        int offset = PositionUtils.getOffset(mocaScript, pos);
                        if (offset > 0 && (offset - 1) < mocaScript.length() && mocaScript.charAt(offset - 1) != '@') {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine())
                                        .add(new Token(pos.getCharacter(), word.length(), MOCASQL_TABLE_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), word.length(), MOCASQL_TABLE_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }
                }
            }
        }

        return preInfos;
    }

}