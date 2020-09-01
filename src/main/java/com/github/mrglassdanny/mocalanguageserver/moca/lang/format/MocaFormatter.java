package com.github.mrglassdanny.mocalanguageserver.moca.lang.format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

public class MocaFormatter {

    private static String FORMATTING_TRAINING_DIR_FRAGMENT = "\\formatting\\training\\moca\\";

    private static org.antlr.codebuff.misc.LangDescriptor mocaLangDescriptor = null;
    private static org.antlr.codebuff.Corpus mocaCorpus = null;

    public static void configureAndTrain(String corpusDirName) throws Exception {
        mocaLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor("Moca",
                MocaLanguageServer.globalStoragePath + FORMATTING_TRAINING_DIR_FRAGMENT + corpusDirName, ".*\\.msql",
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

    public static void createDefaults() throws IOException {

        // Main default:
        {
            final String defaultPath = MocaLanguageServer.globalStoragePath + FORMATTING_TRAINING_DIR_FRAGMENT
                    + "\\default";

            Files.createDirectories(Paths.get(defaultPath));

            Files.write(Paths.get(defaultPath + "\\file.msql"), "hello world where a = @abc".getBytes(),
                    StandardOpenOption.CREATE);
        }

    }
}