package com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql;

public class MocaSqlFunction {

    public static final String VARIABLE_LENGTH_ARGUMENT = "__variable_length_argument";

    public String name;
    public String[] argumentNames;
    public String description;

    public MocaSqlFunction(String name, String[] argumentNames, String description) {
        this.name = name;
        this.argumentNames = argumentNames;
        this.description = description;
    }

    public String getMarkdownStr() {
        // Build out function signature.
        StringBuilder argBuf = new StringBuilder();
        for (String argName : this.argumentNames) {
            if (argName.compareTo(MocaSqlFunction.VARIABLE_LENGTH_ARGUMENT) == 0) {
                argBuf.append("...");
                argBuf.append(",");
            } else {
                argBuf.append(argName);
                argBuf.append(",");
            }
        }

        // Remove last comma from argument buffer.
        if (argBuf.length() > 0) {
            argBuf.deleteCharAt(argBuf.length() - 1);
        }
        return String.format("function **%s**\n\n%s\n\n```sql\n%s(%s)\n```", this.name, this.description, this.name,
                argBuf.toString());
    }

}
