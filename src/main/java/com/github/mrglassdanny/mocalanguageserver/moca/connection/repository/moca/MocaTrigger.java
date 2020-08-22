package com.github.mrglassdanny.mocalanguageserver.moca.connection.repository.moca;

public class MocaTrigger {

    public String name;
    public String command;
    public int trgseq;
    public String syntax;

    public MocaTrigger(String name, String command, int trgseq, String syntax) {
        this.name = name;
        this.command = command;
        this.trgseq = trgseq;
        this.syntax = syntax;
    }
}