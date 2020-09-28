package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlrutil.CaseChangingCharStream;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.ast.MocaSqlSyntaxErrorListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class MocaSqlCompiler {

    public static MocaSqlCompilationResult compileScript(String script) {
        MocaSqlCompilationResult mocaSqlCompilationResult = new MocaSqlCompilationResult();

        mocaSqlCompilationResult.mocaSqlTokens = new MocaSqlLexer(
                new CaseChangingCharStream(CharStreams.fromString(script), true)).getAllTokens();
        mocaSqlCompilationResult.mocaSqlParser = new MocaSqlParser(new CommonTokenStream(
                new MocaSqlLexer(new CaseChangingCharStream(CharStreams.fromString(script), true))));
        mocaSqlCompilationResult.mocaSqlSyntaxErrorListener = new MocaSqlSyntaxErrorListener();
        mocaSqlCompilationResult.mocaSqlParser.addErrorListener(mocaSqlCompilationResult.mocaSqlSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        mocaSqlCompilationResult.mocaSqlParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = mocaSqlCompilationResult.mocaSqlParser.moca_sql_script();
        mocaSqlCompilationResult.mocaSqlParseTreeListener = new MocaSqlParseTreeListener();
        new ParseTreeWalker().walk(mocaSqlCompilationResult.mocaSqlParseTreeListener, parseTree);

        return mocaSqlCompilationResult;
    }
}