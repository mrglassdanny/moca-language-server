package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;

public class MocaSqlFormatter {

    private static String FORMATTING_TRAINING_DIR_FRAGMENT = "\\formatting\\training\\mocasql\\";

    private static org.antlr.codebuff.misc.LangDescriptor mocaSqlLangDescriptor = null;
    private static org.antlr.codebuff.Corpus mocaSqlCorpus = null;

    public static void configureAndTrain(String corpusDirName) throws Exception {
        mocaSqlLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor("MocaSql",
                MocaLanguageServer.globalStoragePath + FORMATTING_TRAINING_DIR_FRAGMENT + corpusDirName, ".*\\.sql",
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

    public static void createDefaults() throws IOException {

        // Main default:
        {
            final String defaultPath = MocaLanguageServer.globalStoragePath + FORMATTING_TRAINING_DIR_FRAGMENT
                    + "\\default";

            Files.createDirectories(Paths.get(defaultPath));

            Files.write(Paths.get(defaultPath + "\\file.sql"), "select * from locmst".getBytes(),
                    StandardOpenOption.CREATE);
        }

    }

}