package com.github.mrglassdanny.mocalanguageserver.moca.lang.format;

import java.io.File;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;

public class MocaFormatter {

    public static final org.antlr.codebuff.misc.LangDescriptor mocaLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor(
            "Moca", "formatting/moca", ".*\\.msql", MocaLexer.class, MocaParser.class, "moca_script", 4,
            MocaLexer.BLOCK_COMMENT);

    public static org.antlr.codebuff.Corpus mocaCorpus = null;

    static {
        try {
            mocaCorpus = org.antlr.codebuff.Tool.trainCorpusForMocaLanguageServer(mocaLangDescriptor);

            File f = new File("formatting/moca");
            MocaLanguageServer.languageClient.logMessage(new MessageParams(MessageType.Log, f.getAbsolutePath()));
        } catch (Exception e) {
            // Do nothing..
        }
    }
}