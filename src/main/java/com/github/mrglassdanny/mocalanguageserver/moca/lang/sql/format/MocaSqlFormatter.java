package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.format;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;

public class MocaSqlFormatter {

    public static final org.antlr.codebuff.misc.LangDescriptor mocaSqlLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor(
            "MocaSql", "C:\\Users\\dglass\\OneDrive - Longbow Advantage\\Desktop\\formatting-training\\mocasql",
            ".*\\.sql", MocaSqlLexer.class, MocaSqlParser.class, "moca_sql_script", 4, MocaSqlLexer.LINE_COMMENT);

    public static org.antlr.codebuff.Corpus mocaSqlCorpus = null;

    static {
        try {
            mocaSqlCorpus = org.antlr.codebuff.Tool.trainCorpusForMocaLanguageServer(mocaSqlLangDescriptor);
        } catch (Exception e) {
            // Do nothing..
        }
    }

}