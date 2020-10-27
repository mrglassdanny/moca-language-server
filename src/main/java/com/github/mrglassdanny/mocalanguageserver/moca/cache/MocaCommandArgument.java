package com.github.mrglassdanny.mocalanguageserver.moca.cache;

public class MocaCommandArgument {
    public String cmplvl;
    public String command;
    public String argnam;
    public String altnam;
    public String argtyp;
    public String fixval;
    public int argidx;
    public boolean argreq;

    public MocaCommandArgument(String cmplvl, String command, String argnam, String altnam, String argtyp,
            String fixval, int argidx, boolean argreq) {
        this.cmplvl = cmplvl;
        this.command = command.toLowerCase(); // We want all moca entities lower case.
        this.argnam = argnam.toLowerCase(); // We want all moca entities lower case.
        this.altnam = altnam.toLowerCase(); // We want all moca entities lower case.
        this.argtyp = argtyp;
        this.fixval = fixval;
        this.argidx = argidx;
        this.argreq = argreq;
    }

    public String getMarkdownStr() {
        return String.format("argument **%s**\n\nType: %s\n\n%s\n\n%s", this.argnam, this.argtyp,
                (this.altnam == null || this.altnam.isEmpty() ? "" : String.format("Alias: %s", this.altnam)),
                (this.argreq ? "**REQUIRED**" : ""));
    }

    public String getAlternateNameMarkdownStr() {
        if (this.altnam == null || this.altnam.isEmpty()) {
            return this.getMarkdownStr();
        } else {
            return String.format("alias **%s** for argument **%s**\n\nType: %s\n\n%s", this.altnam, this.argnam,
                    this.argtyp, (this.argreq ? "**REQUIRED**" : ""));
        }

    }
}