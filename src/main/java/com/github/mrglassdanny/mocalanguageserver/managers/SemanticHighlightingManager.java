package com.github.mrglassdanny.mocalanguageserver.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.SqlCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.util.SqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.SemanticHighlightingParams;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens.Token;

import net.sf.jsqlparser.parser.SimpleNode;

public class SemanticHighlightingManager {

    private static final int SQL_RANGE_SCOPES_IDX = 0;
    private static final int SQL_RANGE_LAST_LINE_SCOPES_IDX = 1;
    private static final int GROOVY_RANGE_SCOPES_IDX = 2;
    private static final int GROOVY_RANGE_LAST_LINE_SCOPES_IDX = 3;
    private static final int MOCA_COMMAND_SCOPES_IDX = 4;
    private static final int MOCA_COMMAND_STREAM_END_SCOPES_IDX = 5;
    private static final int SQL_TABLE_SCOPES_IDX = 6;

    public static List<List<String>> textmateScopes = new ArrayList<>();

    public static void setTextmateScopes() {

        List<String> sqlRangeScopes = new ArrayList<>();
        sqlRangeScopes.add("moca.sql");

        List<String> sqlRangeLastLineScopes = new ArrayList<>();
        sqlRangeLastLineScopes.add("moca.sql.lastline");

        List<String> groovyRangeScopes = new ArrayList<>();
        groovyRangeScopes.add("moca.groovy");

        List<String> groovyRangeLastLineScopes = new ArrayList<>();
        groovyRangeLastLineScopes.add("moca.groovy.lastline");

        List<String> mocaCommandScopes = new ArrayList<>();
        mocaCommandScopes.add("entity.name.function");

        List<String> mocaCommandStreamEndScopes = new ArrayList<>();
        mocaCommandStreamEndScopes.add("moca.commandstream.end");

        List<String> sqlTableScopes = new ArrayList<>();
        sqlTableScopes.add("entity.name.type.class");

        textmateScopes.add(sqlRangeScopes);
        textmateScopes.add(sqlRangeLastLineScopes);
        textmateScopes.add(groovyRangeScopes);
        textmateScopes.add(groovyRangeLastLineScopes);
        textmateScopes.add(mocaCommandScopes);
        textmateScopes.add(mocaCommandStreamEndScopes);
        textmateScopes.add(sqlTableScopes);
    }

    public static void streamAll(LanguageClient client, String uriStr, String mocaScript, MocaCompiler mocaCompiler) {

        // Make sure we are good to stream.
        if (MocaLanguageServer.currentMocaConnection == null) {
            return;
        }

        // Prepare to add new highlights.
        List<SemanticHighlightingInformation> lines = new ArrayList<>();
        VersionedTextDocumentIdentifier versionTextDoc = new VersionedTextDocumentIdentifier(uriStr, 1);
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        // Get semantic highlights.
        HashMap<Integer, ArrayList<Token>> sqlRangePreInfos = getSqlRangeSemanticHighlightings(lines, mocaScript,
                mocaCompiler, client);
        for (Map.Entry<Integer, ArrayList<Token>> entry : sqlRangePreInfos.entrySet()) {

            int lineNum = entry.getKey();
            if (preInfos.containsKey(lineNum)) {
                preInfos.get(lineNum).addAll(entry.getValue());
            } else {
                ArrayList<Token> arr = new ArrayList<>();
                arr.addAll(entry.getValue());
                preInfos.put(lineNum, arr);
            }
        }
        HashMap<Integer, ArrayList<Token>> groovyRangePreInfos = getGroovyRangeSemanticHighlightings(lines, mocaScript,
                mocaCompiler, client);
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
        HashMap<Integer, ArrayList<Token>> mocaCommandPreInfos = getMocaCommandSemanticHighlightings(lines, mocaScript,
                mocaCompiler, client);
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
                lines, mocaScript, mocaCompiler, client);
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
        HashMap<Integer, ArrayList<Token>> sqlTablePreInfos = getSqlTableSemanticHighlightings(lines, mocaScript,
                mocaCompiler, client);
        for (Map.Entry<Integer, ArrayList<Token>> entry : sqlTablePreInfos.entrySet()) {

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
        client.semanticHighlighting(params);
    }

    public static HashMap<Integer, ArrayList<Token>> getSqlRangeSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript, MocaCompiler mocaCompiler,
            LanguageClient client) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        for (Range sqlRange : mocaCompiler.sqlRanges) {
            int firstLine = sqlRange.getStart().getLine();
            int lastLine = sqlRange.getEnd().getLine();

            for (int i = firstLine; i < lastLine; i++) {
                if (preInfos.containsKey(i)) {
                    preInfos.get(i).add(new Token(0, 5, SQL_RANGE_SCOPES_IDX));
                } else {
                    ArrayList<Token> tokensArr = new ArrayList<>();
                    tokensArr.add(new Token(0, 5, SQL_RANGE_SCOPES_IDX));
                    preInfos.put(i, tokensArr);
                }
            }

            // Add last line now.
            if (preInfos.containsKey(lastLine)) {
                preInfos.get(lastLine)
                        .add(new Token(0, sqlRange.getEnd().getCharacter(), SQL_RANGE_LAST_LINE_SCOPES_IDX));
            } else {
                ArrayList<Token> tokensArr = new ArrayList<>();
                tokensArr.add(new Token(0, sqlRange.getEnd().getCharacter(), SQL_RANGE_LAST_LINE_SCOPES_IDX));
                preInfos.put(lastLine, tokensArr);
            }

        }

        return preInfos;

    }

    public static HashMap<Integer, ArrayList<Token>> getGroovyRangeSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript, MocaCompiler mocaCompiler,
            LanguageClient client) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();
        for (Range groovyRange : mocaCompiler.groovyRanges) {
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
            List<SemanticHighlightingInformation> lines, String mocaScript, MocaCompiler mocaCompiler,
            LanguageClient client) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        // For semantic highlighting, we need to make sure the moca compiliation result
        // we are looking at has no errors.
        MocaCompilationResult mocaCompilationResult = mocaCompiler.currentCompilationResult;
        if (mocaCompilationResult.hasMocaErrors()) {
            mocaCompilationResult = mocaCompiler.lastSuccessfulCompilationResult;
        }

        // Go ahead and stop now if now compilation result.
        if (mocaCompilationResult != null) {
            for (Map.Entry<String, ArrayList<org.antlr.v4.runtime.Token>> entry : mocaCompilationResult.mocaParseTreeListener.verbNounClauses
                    .entrySet()) {

                String verbNounClause = entry.getKey();
                ArrayList<org.antlr.v4.runtime.Token> mocaTokens = entry.getValue();
                if (verbNounClause != null) {

                    // Make sure command exists before we color it.
                    if (MocaLanguageServer.currentMocaConnection.repository.commandRepository.commands
                            .containsKey(verbNounClause)) {
                        Position pos = Positions.getPosition(mocaScript, mocaTokens.get(0).getStartIndex());

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
            List<SemanticHighlightingInformation> lines, String mocaScript, MocaCompiler mocaCompiler,
            LanguageClient client) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        for (org.antlr.v4.runtime.Token mocaToken : mocaCompiler.mocaTokens) {
            if (mocaToken.getType() == MocaLexer.SEMI_COLON) {
                Position pos = Positions.getPosition(mocaScript, mocaToken.getStartIndex());
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

    public static HashMap<Integer, ArrayList<Token>> getSqlTableSemanticHighlightings(
            List<SemanticHighlightingInformation> lines, String mocaScript, MocaCompiler mocaCompiler,
            LanguageClient client) {

        // Have to pack all highlights for line into one SemanticHighlightingInformation
        // object.
        HashMap<Integer, ArrayList<Token>> preInfos = new HashMap<>();

        for (int i = 0; i < mocaCompiler.sqlRanges.size(); i++) {
            // For semantic highlighting, we need to make sure the sql compiliation result
            // we are looking at has no errors.
            SqlCompilationResult sqlCompilationResult = mocaCompiler.currentCompilationResult.sqlCompilationResults
                    .get(i);
            if (sqlCompilationResult.hasErrors()) {
                sqlCompilationResult = mocaCompiler.currentCompilationResult.sqlLastSuccessfulCompilationResults.get(i);
            }

            // Quit now if no compilation result.
            if (sqlCompilationResult != null) {

                SimpleNode curSqlNode = sqlCompilationResult.astVisitor.rootNode;
                net.sf.jsqlparser.parser.Token curSqlToken = curSqlNode.jjtGetFirstToken();
                while (curSqlToken != null) {

                    Position pos = SqlLanguageUtils.createMocaPosition(curSqlToken.beginLine, curSqlToken.beginColumn,
                            mocaCompiler.sqlRanges.get(i));

                    String sqlWord = curSqlToken.image.toLowerCase();

                    // Check if exists in tables/views before we add to map.
                    if (MocaLanguageServer.currentMocaConnection.repository.databaseSchema.tables.containsKey(sqlWord)
                            || MocaLanguageServer.currentMocaConnection.repository.databaseSchema.views
                                    .containsKey(sqlWord)) {

                        // Let's make sure real quick that this is not a '@' var.
                        int offset = Positions.getOffset(mocaScript, pos);
                        if (offset > 0 && (offset - 1) < mocaScript.length() && mocaScript.charAt(offset - 1) != '@') {
                            if (preInfos.containsKey(pos.getLine())) {
                                preInfos.get(pos.getLine())
                                        .add(new Token(pos.getCharacter(), sqlWord.length(), SQL_TABLE_SCOPES_IDX));
                            } else {
                                ArrayList<Token> tokensArr = new ArrayList<>();
                                tokensArr.add(new Token(pos.getCharacter(), sqlWord.length(), SQL_TABLE_SCOPES_IDX));
                                preInfos.put(pos.getLine(), tokensArr);
                            }
                        }
                    }

                    curSqlToken = curSqlToken.next;
                }
            }
        }

        return preInfos;
    }

}