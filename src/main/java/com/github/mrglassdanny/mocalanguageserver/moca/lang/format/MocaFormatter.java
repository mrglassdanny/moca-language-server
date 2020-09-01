package com.github.mrglassdanny.mocalanguageserver.moca.lang.format;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

public class MocaFormatter {

    private static org.antlr.codebuff.misc.LangDescriptor mocaLangDescriptor = null;
    private static org.antlr.codebuff.Corpus mocaCorpus = null;

    public static void configureAndTrain() throws Exception {
        mocaLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor("Moca",
                "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\formatting-training\\moca", ".*\\.msql",
                MocaLexer.class, MocaParser.class, "moca_script", 2, MocaLexer.BLOCK_COMMENT);

        mocaCorpus = org.antlr.codebuff.Tool.trainCorpusForMocaLanguageServer(mocaLangDescriptor);
    }

    public static String format(String src) {

        String dst = null;
        try {
            dst = org.antlr.codebuff.Tool.formatForMocaLanguageServer(MocaFormatter.mocaLangDescriptor, src,
                    MocaFormatter.mocaCorpus);
        } catch (Exception e) {
        }

        return dst;
    }
}