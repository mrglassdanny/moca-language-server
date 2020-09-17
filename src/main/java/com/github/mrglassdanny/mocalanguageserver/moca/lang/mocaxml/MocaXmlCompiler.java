package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml;

import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaXmlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaXmlParser;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlrutil.CaseChangingCharStream;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml.ast.MocaXmlParseTreeListener;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.mocaxml.ast.MocaXmlSyntaxErrorListener;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class MocaXmlCompiler {

    public List<? extends Token> mocaXmlTokens;
    public MocaXmlCompilationResult currentCompilationResult;

    public MocaXmlCompilationResult compileScript(String script) {
        MocaXmlCompilationResult compilationResult = new MocaXmlCompilationResult();

        compilationResult.mocaXmlTokens = new MocaXmlLexer(
                new CaseChangingCharStream(CharStreams.fromString(script), true)).getAllTokens();
        compilationResult.mocaXmlParser = new MocaXmlParser(new CommonTokenStream(
                new MocaXmlLexer(new CaseChangingCharStream(CharStreams.fromString(script), true))));
        compilationResult.mocaXmlSyntaxErrorListener = new MocaXmlSyntaxErrorListener();
        compilationResult.mocaXmlParser.addErrorListener(compilationResult.mocaXmlSyntaxErrorListener);
        // Since we do not want errors printing to the console, remove this
        // ConsoleErrorListener.
        compilationResult.mocaXmlParser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree parseTree = compilationResult.mocaXmlParser.document();
        compilationResult.mocaXmlParseTreeListener = new MocaXmlParseTreeListener();
        new ParseTreeWalker().walk(compilationResult.mocaXmlParseTreeListener, parseTree);

        this.currentCompilationResult = compilationResult;
        return compilationResult;
    }
}
