package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.format;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;

public class MocaSqlFormatter {

    private static org.antlr.codebuff.misc.LangDescriptor mocaSqlLangDescriptor = null;
    private static org.antlr.codebuff.Corpus mocaSqlCorpus = null;

    public static void configureAndTrain(String corpusDirName) throws Exception {
        mocaSqlLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor("MocaSql",
                MocaLanguageServer.globalStoragePath + "\\formatting\\training\\mocasql\\" + corpusDirName, ".*\\.sql",
                MocaSqlLexer.class, MocaSqlParser.class, "moca_sql_script", 4, MocaSqlLexer.LINE_COMMENT);

        mocaSqlCorpus = org.antlr.codebuff.Tool.trainCorpusForMocaLanguageServer(mocaSqlLangDescriptor);
    }

    public static String format(String src) {

        String dst = null;
        try {
            dst = org.antlr.codebuff.Tool.formatForMocaLanguageServer(MocaSqlFormatter.mocaSqlLangDescriptor, src,
                    MocaSqlFormatter.mocaSqlCorpus);
        } catch (Exception e) {
        }

        return dst;
    }

    private static void createDefaultA() {
        // Make sure lang descriptor is not null.
        if (mocaSqlLangDescriptor != null) {

        }
    }

}