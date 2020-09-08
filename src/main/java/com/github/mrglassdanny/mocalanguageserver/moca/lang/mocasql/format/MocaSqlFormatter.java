package com.github.mrglassdanny.mocalanguageserver.moca.lang.mocasql.format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaSqlParser;

public class MocaSqlFormatter {

    private static String FORMATTING_TRAINING_DIR_FRAGMENT = "\\formatting\\training\\mocasql\\";

    private static org.antlr.codebuff.misc.LangDescriptor mocaSqlLangDescriptor = null;
    private static org.antlr.codebuff.Corpus mocaSqlCorpus = null;

    public static void configureAndTrain(String corpusDirName) throws Exception {
        mocaSqlLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor("MocaSql",
                MocaLanguageServer.globalStoragePath + FORMATTING_TRAINING_DIR_FRAGMENT + corpusDirName, ".*\\.mocasql",
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

            String exampleFormattedMocaSqlScript = "SELECT a, \n" + "       b, \n" + "       c, \n" + "       d, \n"
                    + "       e \n" + "FROM   l \n" + "WHERE  l.a = '' \n" + "       AND l.b = 'asdf' \n"
                    + "       AND c = 'asdf' \n" + "       AND d = 10\n" + "\t   \n" + "SELECT DISTINCT a, \n"
                    + "                b, \n" + "                c, \n" + "                d, \n"
                    + "                e \n" + "FROM   l \n" + "       JOIN z \n" + "         ON l.a = z.a \n"
                    + "            AND l.b = z.b \n" + "       LEFT JOIN oo \n" + "              ON z.a = o.a \n"
                    + "       RIGHT JOIN zz \n" + "               ON z.z = zz.z \n" + "WHERE  l.a = '' \n"
                    + "       AND l.b = 'asdf' \n" + "       AND c = 'asdf' \n" + "       AND d = 10 \n"
                    + "GROUP  BY a, \n" + "          b, \n" + "          c \n" + "ORDER  BY a, \n" + "          b, \n"
                    + "          c \n" + "\n" + "INSERT INTO l \n" + "            (a, \n" + "             b, \n"
                    + "             c, \n" + "             d) \n" + "VALUES      ('asdf', \n" + "             asdf, \n"
                    + "             'asdf', \n" + "             654) \n" + "\t\t\t \n" + "UPDATE abc \n"
                    + "SET    a = '', \n" + "       b = 10, \n" + "       c = asdf \n" + "WHERE  a = '' \n"
                    + "       AND abc.b = 10 \n" + "       AND abc.c = asdf \n" + "\t   \n" + "DELETE FROM abc \n"
                    + "WHERE  a = 10 \n" + "       AND b = 'asdf' \n" + "       AND abc.d = foo \n"
                    + "       AND abc.e = bar \n" + "\t   \n" + "SELECT a, \n" + "       b, \n" + "       c, \n"
                    + "       d, \n" + "       e \n" + "FROM   l \n" + "WHERE  l.a = '' \n"
                    + "       AND l.b = 'asdf' \n" + "       AND c = 'asdf' \n" + "       AND d = 10\n" + "\t   \n"
                    + "SELECT DISTINCT a, \n" + "                b, \n" + "                c, \n"
                    + "                d, \n" + "                e \n" + "FROM   l \n" + "       JOIN z \n"
                    + "         ON l.a = z.a \n" + "            AND l.b = z.b \n" + "       LEFT JOIN oo \n"
                    + "              ON z.a = o.a \n" + "       RIGHT JOIN zz \n" + "               ON z.z = zz.z \n"
                    + "WHERE  l.a = '' \n" + "       AND l.b = @asdlkfj:raw\n" + "       AND @+asdf\n"
                    + "       AND @* \n" + "GROUP  BY a, \n" + "          b, \n" + "          c \n" + "ORDER  BY a, \n"
                    + "          b, \n" + "          c \n" + "\n" + "INSERT INTO l \n" + "            (a, \n"
                    + "             b, \n" + "             c, \n" + "             d) \n" + "VALUES      ('asdf', \n"
                    + "             asdf, \n" + "             'asdf', \n" + "             654) \n" + "\t\t\t \n"
                    + "UPDATE abc \n" + "SET    a = '', \n" + "       b = 10, \n" + "       c = asdf \n"
                    + "WHERE  a = '' \n" + "       AND abc.b = 10 \n" + "       AND abc.c = nvl(asdf, @asdlfkj) \n"
                    + "\t   \n" + "DELETE FROM abc \n" + "WHERE  a = 10 \n" + "       AND b = 'asdf' \n"
                    + "       AND abc.d = @@foo \n" + "       AND abc.e = @bar ";

            Files.write(Paths.get(defaultPath + "\\file.mocasql"), exampleFormattedMocaSqlScript.getBytes());
        }

    }

}