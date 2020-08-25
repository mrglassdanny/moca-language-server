package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.SqlCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.util.SqlLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.parse.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.parse.MocaParser;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Ranges;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class MocaCompiler {

    private static final Pattern XML_HEADER_PATTERN = Pattern
            .compile("<!\\[CDATA\\[(?=(?:[^(\"|')]*(\"|')[^(\"|')]*(\"|'))*[^(\"|')]*$)");

    public List<Token> mocaTokens; // From lexer.
    public MocaCompilationResult currentCompilationResult;
    // Based on how parser works(no ast data when exception in parse), we need to
    // store last successful compilation results.
    public MocaCompilationResult lastSuccessfulCompilationResult;

    public ArrayList<Range> sqlRanges;
    public ArrayList<Range> groovyRanges;

    private SqlCompiler sqlCompiler;
    private GroovyCompiler groovyCompiler;

    public MocaCompiler() {
        this.mocaTokens = null;
        this.currentCompilationResult = null;
        this.lastSuccessfulCompilationResult = null;

        this.sqlRanges = new ArrayList<>();
        this.groovyRanges = new ArrayList<>();

        this.sqlCompiler = new SqlCompiler();
        this.groovyCompiler = new GroovyCompiler();
    }

    public MocaCompilationResult compileScript(String mocaScript) {

        MocaCompilationResult compilationResult = new MocaCompilationResult();
        this.currentCompilationResult = compilationResult;

        // Alter mocaScript to handle mcmd/mtrg xml header and footer text.
        // We should be able to just wrap these in comment blocks(will have to replace a
        // few characters in order to not mess up lexer token positions). That way the
        // lexer tokens' positions are correct and the moca compiler will not think
        // these sections are part of the script.
        // NOTE: there could be multiple XML_HEADER_PATTERN matches. That being said,
        // the first match should be the only one we care about.
        Matcher xmlHeaderMatcher = XML_HEADER_PATTERN.matcher(mocaScript);
        if (xmlHeaderMatcher.find()) {

            int headerStartIdx = 0;
            int headerEndIdx = xmlHeaderMatcher.end();
            int footerStartIdx = mocaScript.indexOf("]]>", headerEndIdx);
            int footerEndIdx = mocaScript.length() - 1;

            char[] mocaScriptCharArr = mocaScript.toCharArray();
            mocaScriptCharArr[headerStartIdx] = '/';
            mocaScriptCharArr[headerStartIdx + 1] = '*';
            mocaScriptCharArr[headerEndIdx - 1] = '*';
            mocaScriptCharArr[headerEndIdx] = '/';
            mocaScriptCharArr[footerStartIdx] = '/';
            mocaScriptCharArr[footerStartIdx + 1] = '*';
            mocaScriptCharArr[footerEndIdx - 1] = '*';
            mocaScriptCharArr[footerEndIdx] = '/';

            mocaScript = new String(mocaScriptCharArr);
        }

        // Alter mocaScript to handle integration alg syntax(:i_c_wh_id).
        mocaScript = mocaScript.replace(":i_", "_i_");
        // TODO - handle <<OVERSTACKED_ARGS>>.

        try {
            MocaLexer mocaLexer = new MocaLexer(CharStreams.fromString(mocaScript));
            compilationResult.mocaParser = new MocaParser(new CommonTokenStream(mocaLexer));
            ParseTree parseTree = compilationResult.mocaParser.moca_script();
            // If exception, we stop here.
            this.lastSuccessfulCompilationResult = compilationResult;
        } catch (RecognitionException parseException) {
            compilationResult.parseException = parseException;
            // Do not change lastSuccessfulCompilationResult.
        }

        MocaLexer mocaLexer = new MocaLexer(CharStreams.fromString(mocaScript));
        List tokens = mocaLexer.getAllTokens();
        // If we get here, the lexer must not have had any issues.
        // Go ahead and set mocaTokens.
        if (tokens != null) {
            this.mocaTokens = tokens;
        }

        // Update embedded lang ranges, then compile them.
        this.updateEmbeddedLanguageRanges(mocaScript);

        // Start with SQL.
        for (int i = 0; i < this.sqlRanges.size(); i++) {
            // Remove first and last characters('[', ']'). We cannot blindly remove all
            // instances of these chars like we do in groovy, since it is possible to have
            // '[]' in sql script.
            String sqlScript = Ranges.getText(mocaScript, this.sqlRanges.get(i));
            sqlScript = sqlScript.substring(1, sqlScript.length() - 1);
            this.sqlCompiler.compileScript(i, sqlScript);
        }

        compilationResult.sqlCompilationResults = this.sqlCompiler.compilationResults;
        compilationResult.sqlLastSuccessfulCompilationResults = this.sqlCompiler.lastSuccessfulCompilationResults;

        // Now Groovy.
        for (int i = 0; i < this.groovyRanges.size(); i++) {
            // Remove '[[]]'.
            String groovyScript = Ranges.getText(mocaScript, this.groovyRanges.get(i)).replaceAll("(\\[\\[)|(\\]\\])",
                    "");
            this.groovyCompiler.compileScript(i, groovyScript, this, mocaScript);
        }

        compilationResult.groovyCompilationResults = this.groovyCompiler.compilationResults;

        return compilationResult;
    }

    public void updateEmbeddedLanguageRanges(String mocaScript) {
        this.sqlRanges.clear();
        this.groovyRanges.clear();

        // Can assume we do not have any ranges if no moca tokens exist.
        if (this.mocaTokens == null) {
            return;
        }

        // Now just loop through tokens and find scripts.
        for (Token curMocaToken : this.mocaTokens) {
            if (curMocaToken.getType() == MocaLexer.SINGLE_BRACKET_STRING) {
                if (SqlLanguageUtils.isMocaTokenValueSqlScript(curMocaToken.getText())) {
                    this.sqlRanges.add(new Range(Positions.getPosition(mocaScript, curMocaToken.getStartIndex()),
                            Positions.getPosition(mocaScript, curMocaToken.getStopIndex())));
                }
            } else if (curMocaToken.getType() == MocaLexer.DOUBLE_BRACKET_STRING) {
                this.groovyRanges.add(new Range(Positions.getPosition(mocaScript, curMocaToken.getStartIndex()),
                        Positions.getPosition(mocaScript, curMocaToken.getStopIndex())));
            }
        }

    }

    public MocaLanguageContext getMocaLanguageContextFromPosition(Position position) {

        // Check sql.
        int sqlCount = 0;
        for (Range range : this.sqlRanges) {
            if (Ranges.contains(range, position)) {
                return new MocaLanguageContext(MocaLanguageContext.ContextId.Sql, sqlCount);
            }
            sqlCount++;
        }

        // Check groovy.
        int groovyCount = 0;
        for (Range range : this.groovyRanges) {
            if (Ranges.contains(range, position)) {
                return new MocaLanguageContext(MocaLanguageContext.ContextId.Groovy, groovyCount);
            }
            groovyCount++;
        }

        // Must be moca.
        return new MocaLanguageContext(MocaLanguageContext.ContextId.Moca, 0);
    }

    public Token getMocaTokenAtPosition(String mocaScript, Position pos) {
        int idx = this.getMocaTokenIndexAtPosition(mocaScript, pos);
        return idx == -1 ? null : this.mocaTokens.get(idx);
    }

    public int getMocaTokenIndexAtPosition(String mocaScript, Position pos) {
        int posOffset = Positions.getOffset(mocaScript, pos);
        for (int i = 0; i < this.mocaTokens.size(); i++) {
            Token mocaToken = this.mocaTokens.get(i);

            // Have to manually calculate begin whitespace.
            int beginWhitespace = 0;
            if (i > 0) {
                beginWhitespace = this.mocaTokens.get(i - 1).getStopIndex() + 1;
            }

            if (beginWhitespace <= posOffset && mocaToken.getStopIndex() >= posOffset) {
                return i;
            }
        }

        return -1;
    }

}