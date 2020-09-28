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
        MocaSqlCompilationResult compilationResult = new MocaSqlCompilationResult();

        compilationResult.mocaSqlTokens = new MocaSqlLexer(
                new CaseChangingCharStream(CharStreams.fromString(script), true)).getAllTokens();
        compilationResult.mocaSqlParser = new MocaSqlParser(new CommonTokenStream(
                new MocaSqlLexer(new CaseChangingCharStream(CharStreams.fromString(script), true))));
        compilationResult.mocaSqlSyntaxErrorListener = new MocaSqlSyntaxErrorListener();
        compilationResult.mocaSqlParser.addErrorListener(compilationResult.mocaSqlSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        compilationResult.mocaSqlParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = compilationResult.mocaSqlParser.moca_sql_script();
        compilationResult.mocaSqlParseTreeListener = new MocaSqlParseTreeListener();
        new ParseTreeWalker().walk(compilationResult.mocaSqlParseTreeListener, parseTree);

        return compilationResult;
    }
}