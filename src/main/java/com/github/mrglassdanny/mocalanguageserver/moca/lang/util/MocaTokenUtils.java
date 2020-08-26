package com.github.mrglassdanny.mocalanguageserver.moca.lang.util;

public class MocaTokenUtils {

    public static int getAdjustedMocaTokenStopIndex(int stopIndex) {
        // Little janky, but for some reason the antlr lexing is cutting off the last
        // character. We need to add 1 to the stop index to correct it.
        return stopIndex + 1;
    }

}