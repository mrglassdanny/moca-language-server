package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

import java.util.HashMap;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlrutil.CaseChangingCharStream;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.util.MocaSqlLanguageUtils;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class MocaSqlCompiler {

    public HashMap<Integer, MocaSqlCompilationResult> compilationResults;

    public MocaSqlCompiler() {
        this.compilationResults = new HashMap<>();
    }

    public MocaSqlCompilationResult compileScript(int rangeIdx, String script) {
        MocaSqlCompilationResult compilationResult = new MocaSqlCompilationResult();

        script = MocaSqlLanguageUtils.adjustSqlScriptForMoca(script);
        compilationResult.sqlTokens = new MocaSqlLexer(new CaseChangingCharStream(new ANTLRInputStream(script), true))
                .getAllTokens();
        compilationResult.sqlParser = new MocaSqlParser(new CommonTokenStream(
                new MocaSqlLexer(new CaseChangingCharStream(new ANTLRInputStream(script), true))));
        compilationResult.sqlSyntaxErrorListener = new MocaSqlSyntaxErrorListener();
        compilationResult.sqlParser.addErrorListener(compilationResult.sqlSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        compilationResult.sqlParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = compilationResult.sqlParser.moca_sql_script();
        compilationResult.sqlParseTreeListener = new MocaSqlParseTreeListener();
        new ParseTreeWalker().walk(compilationResult.sqlParseTreeListener, parseTree);

        this.compilationResults.put(rangeIdx, compilationResult);
        return compilationResult;
    }
}