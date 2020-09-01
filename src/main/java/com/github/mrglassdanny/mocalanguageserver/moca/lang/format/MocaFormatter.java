package com.github.mrglassdanny.mocalanguageserver.moca.lang.format;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

public class MocaFormatter {

    public static final org.antlr.codebuff.misc.LangDescriptor mocaLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor(
            "Moca", "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\formatting-training\\moca", ".*\\.msql",
            MocaLexer.class, MocaParser.class, "moca_script", 2, MocaLexer.BLOCK_COMMENT);

    public static org.antlr.codebuff.Corpus mocaCorpus = null;

    static {
        try {
            mocaCorpus = org.antlr.codebuff.Tool.trainCorpusForMocaLanguageServer(mocaLangDescriptor);
        } catch (Exception e) {
            // Do nothing..
        }
    }
}