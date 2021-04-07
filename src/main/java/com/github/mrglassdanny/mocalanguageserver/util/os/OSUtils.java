package com.github.mrglassdanny.mocalanguageserver.util.os;

public class OSUtils {

    public static boolean isWindows() {
        String osName = System.getProperty("os.name");
        if(osName == null) {
            return false;
        } else {
            if(osName.toLowerCase().contains("win")) {
                return true;
            } else {
                return false;
            }
        }
        
    }

}