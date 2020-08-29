package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlrutil.CaseChangingCharStream;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.util.SqlLanguageUtils;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class SqlCompiler {

    public HashMap<Integer, SqlCompilationResult> compilationResults;

    public SqlCompiler() {
        this.compilationResults = new HashMap<>();
    }

    public SqlCompilationResult compileScript(int rangeIdx, String script) {
        SqlCompilationResult compilationResult = new SqlCompilationResult();

        script = SqlLanguageUtils.adjustSqlScriptForMoca(script);
        compilationResult.sqlTokens = new MocaSqlLexer(new CaseChangingCharStream(new ANTLRInputStream(script), true))
                .getAllTokens();
        compilationResult.sqlParser = new MocaSqlParser(new CommonTokenStream(
                new MocaSqlLexer(new CaseChangingCharStream(new ANTLRInputStream(script), true))));
        compilationResult.sqlSyntaxErrorListener = new SqlSyntaxErrorListener();
        compilationResult.sqlParser.addErrorListener(compilationResult.sqlSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        compilationResult.sqlParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = compilationResult.sqlParser.moca_sql_file();
        compilationResult.sqlParseTreeListener = new SqlParseTreeListener();
        new ParseTreeWalker().walk(compilationResult.sqlParseTreeListener, parseTree);

        this.compilationResults.put(rangeIdx, compilationResult);
        return compilationResult;
    }
}