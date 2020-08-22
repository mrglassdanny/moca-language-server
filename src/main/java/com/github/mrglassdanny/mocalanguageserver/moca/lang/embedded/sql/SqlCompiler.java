package com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql;

import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.ast.SqlStatementVisitor;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.sql.util.SqlLanguageUtils;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.SimpleNode;

public class SqlCompiler {

    public HashMap<Integer, SqlCompilationResult> compilationResults;
    // Based on how parser works(no ast data when exception in parse), we need to
    // store last successful compilation results.
    public HashMap<Integer, SqlCompilationResult> lastSuccessfulCompilationResults;

    public SqlCompiler() {
        this.compilationResults = new HashMap<>();
        this.lastSuccessfulCompilationResults = new HashMap<>();
    }

    public SqlCompilationResult compileScript(int rangeIdx, String script) {
        SqlCompilationResult compilationResult = new SqlCompilationResult();

        try {
            script = SqlLanguageUtils.adjustSqlScriptForMoca(script);
            compilationResult.astVisitor = new SqlStatementVisitor();
            compilationResult.astVisitor.rootNode = (SimpleNode) CCJSqlParserUtil.parseAST(script);
            compilationResult.astVisitor.visit(CCJSqlParserUtil.parse(script));

            // Add to last succesful if we get here.
            this.lastSuccessfulCompilationResults.put(rangeIdx, compilationResult);
        } catch (JSQLParserException jpe) {
            compilationResult.sqlSyntaxError = new SqlSyntaxError(jpe);
            // Dont touch last successful.
        }

        this.compilationResults.put(rangeIdx, compilationResult);
        return compilationResult;
    }
}