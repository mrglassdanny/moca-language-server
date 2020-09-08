package com.github.mrglassdanny.mocalanguageserver.moca.lang.format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaLexer;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser;

public class MocaFormatter {

    private static String FORMATTING_TRAINING_DIR_FRAGMENT = "\\formatting\\training\\moca\\";

    private static org.antlr.codebuff.misc.LangDescriptor mocaLangDescriptor = null;
    private static org.antlr.codebuff.Corpus mocaCorpus = null;

    public static void configureAndTrain(String corpusDirName) throws Exception {
        mocaLangDescriptor = new org.antlr.codebuff.misc.LangDescriptor("Moca",
                MocaLanguageServer.globalStoragePath + FORMATTING_TRAINING_DIR_FRAGMENT + corpusDirName, ".*\\.moca",
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

            String exampleFormattedMocaScript = "example moca command\n" + " where var_a = 'string'\n"
                    + "   and var_b = @var\n" + "   and var_c = @@env_var\n" + "   and var_d = @var:date\n"
                    + "   and var_e = @var#onstack\n" + "   and @+var\n" + "   and @%var\n" + "   and @*\n" + "|\n"
                    + "another example command\n" + " where var_a = nvl(@func, @@func)\n"
                    + "   and var_b = 'string again';\n" + "another example command\n" + " where var_a = 'adfadsf'\n"
                    + "   and var_b = @@abc &\n" + "so many commands >> res;\n" + "test abc catch(510, -1403, @?)\n"
                    + "|\n" + "say hello to my little friend\n" + " where friend = 'machine gun' catch(@?)\n" + "|\n"
                    + "if (@? = 0)\n" + "{\n" + "    publish data\n" + "     where status = @?\n"
                    + "       and msg = @! >> res\n" + "    |\n"
                    + "    if (@a = @b and @c = @b or @something = 'something')\n" + "    {\n" + "        do stuff\n"
                    + "         where a = @abc\n" + "           and b = @def\n"
                    + "           and foo = nvl('', '') >> res\n" + "    }\n" + "    else\n" + "    {\n"
                    + "        more stuff here\n" + "         where a = rowcount(@abc)\n"
                    + "           and b = 'asldkfjasldkjfsalkd' &\n" + "        hello world >> res;\n" + "        {\n"
                    + "            {\n" + "                {\n" + "                    here are some nested brackets\n"
                    + "                     where foo = 'foo'\n" + "                       and bar = @bar\n"
                    + "                       and @+database.qualifier\n" + "                       and @*\n"
                    + "                }\n" + "            }\n" + "        }\n" + "    }\n" + "}\n" + "|\n" + "try\n"
                    + "{\n" + "    publish data\n" + "     where a = 'here is a try'\n" + "} catch(1)\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is a catch'\n" + "} catch(-2)\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is another catch'\n" + "}\n" + "finally\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is a finally'\n" + "};\n" + "hello;\n" + "world;\n"
                    + "hello &\n" + "world;\n" + "hello\n" + "|\n" + "world\n" + "|\n" + "hello\n" + "|\n" + "{\n"
                    + "    {\n" + "        {\n" + "            {\n" + "                {\n"
                    + "                    world\n" + "                    |\n" + "                    world\n"
                    + "                    |\n" + "                    world\n" + "                     where w = ''\n"
                    + "                       and w = @asdflkj\n"
                    + "                       and w = nvl(@sadflkj, @@sdzaflkj)\n" + "                       and @*\n"
                    + "                }\n" + "            }\n" + "        }\n" + "    }\n" + "};\n"
                    + "example moca command\n" + " where var_a = 'string'\n" + "   and var_b = @var\n"
                    + "   and var_c = @@env_var\n" + "   and var_d = @var:date\n" + "   and var_e = @var#onstack\n"
                    + "   and @+var\n" + "   and @%var\n" + "   and @*\n" + "|\n" + "another example command\n"
                    + " where var_a = nvl(@func, @@func)\n" + "   and var_b = 'string again';\n"
                    + "another example command\n" + " where var_a = 'adfadsf'\n" + "   and var_b = @@abc &\n"
                    + "so many commands >> res;\n" + "test abc catch(510, -1403, @?)\n" + "|\n"
                    + "say hello to my little friend\n" + " where friend = 'machine gun' catch(@?)\n" + "|\n"
                    + "if (@? = 0)\n" + "{\n" + "    publish data\n" + "     where status = @?\n"
                    + "       and msg = @! >> res\n" + "    |\n"
                    + "    if (@a = @b and @c = @b or @something = 'something')\n" + "    {\n" + "        do stuff\n"
                    + "         where a = @abc\n" + "           and b = @def\n"
                    + "           and foo = nvl('', '') >> res\n" + "    }\n" + "    else\n" + "    {\n"
                    + "        more stuff here\n" + "         where a = rowcount(@abc)\n"
                    + "           and b = 'asldkfjasldkjfsalkd' &\n" + "        hello world >> res;\n" + "        {\n"
                    + "            {\n" + "                {\n" + "                    here are some nested brackets\n"
                    + "                     where foo = 'foo'\n" + "                       and bar = @bar\n"
                    + "                       and @+database.qualifier\n" + "                       and @*\n"
                    + "                }\n" + "            }\n" + "        }\n" + "    }\n" + "}\n" + "|\n" + "try\n"
                    + "{\n" + "    publish data\n" + "     where a = 'here is a try'\n" + "} catch(1)\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is a catch'\n" + "} catch(-2)\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is another catch'\n" + "}\n" + "finally\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is a finally'\n" + "};\n" + "hello;\n" + "world;\n"
                    + "hello &\n" + "world;\n" + "hello\n" + "|\n" + "world\n" + "|\n" + "hello\n" + "|\n" + "{\n"
                    + "    {\n" + "        {\n" + "            {\n" + "                {\n"
                    + "                    world\n" + "                    |\n" + "                    world\n"
                    + "                    |\n" + "                    world\n" + "                     where w = ''\n"
                    + "                       and w = @asdflkj\n"
                    + "                       and w = nvl(@sadflkj, @@sdzaflkj)\n" + "                       and @*\n"
                    + "                }\n" + "            }\n" + "        }\n" + "    }\n" + "};\n"
                    + "example moca command\n" + " where var_a = 'string'\n" + "   and var_b = @var\n"
                    + "   and var_c = @@env_var\n" + "   and var_d = @var:date\n" + "   and var_e = @var#onstack\n"
                    + "   and @+var\n" + "   and @%var\n" + "   and @*\n" + "|\n" + "another example command\n"
                    + " where var_a = nvl(@func, @@func)\n" + "   and var_b = 'string again';\n"
                    + "another example command\n" + " where var_a = 'adfadsf'\n" + "   and var_b = @@abc &\n"
                    + "so many commands >> res;\n" + "test abc catch(510, -1403, @?)\n" + "|\n"
                    + "say hello to my little friend\n" + " where friend = 'machine gun' catch(@?)\n" + "|\n"
                    + "if (@? = 0)\n" + "{\n" + "    publish data\n" + "     where status = @?\n"
                    + "       and msg = @! >> res\n" + "    |\n"
                    + "    if (@a = @b and @c = @b or @something = 'something')\n" + "    {\n" + "        do stuff\n"
                    + "         where a = @abc\n" + "           and b = @def\n"
                    + "           and foo = nvl('', '') >> res\n" + "    }\n" + "    else\n" + "    {\n"
                    + "        more stuff here\n" + "         where a = rowcount(@abc)\n"
                    + "           and b = 'asldkfjasldkjfsalkd' &\n" + "        hello world >> res;\n" + "        {\n"
                    + "            {\n" + "                {\n" + "                    here are some nested brackets\n"
                    + "                     where foo = 'foo'\n" + "                       and bar = @bar\n"
                    + "                       and @+database.qualifier\n" + "                       and @*\n"
                    + "                }\n" + "            }\n" + "        }\n" + "    }\n" + "}\n" + "|\n" + "try\n"
                    + "{\n" + "    publish data\n" + "     where a = 'here is a try'\n" + "} catch(1)\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is a catch'\n" + "} catch(-2)\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is another catch'\n" + "}\n" + "finally\n" + "{\n"
                    + "    publish data\n" + "     where a = 'here is a finally'\n" + "};\n" + "hello;\n" + "world;\n"
                    + "hello &\n" + "world;\n" + "hello\n" + "|\n" + "world\n" + "|\n" + "hello\n" + "|\n" + "{\n"
                    + "    {\n" + "        {\n" + "            {\n" + "                {\n"
                    + "                    world\n" + "                    |\n" + "                    world\n"
                    + "                    |\n" + "                    world\n" + "                     where w = ''\n"
                    + "                       and w = @asdflkj\n"
                    + "                       and w = nvl(@sadflkj, @@sdzaflkj)\n" + "                       and @*\n"
                    + "                }\n" + "            }\n" + "        }\n" + "    }\n" + "};";
            ;

            Files.write(Paths.get(defaultPath + "\\file.moca"), exampleFormattedMocaScript.getBytes());
        }

    }
}