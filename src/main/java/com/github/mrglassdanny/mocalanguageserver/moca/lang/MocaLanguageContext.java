package com.github.mrglassdanny.mocalanguageserver.moca.lang;

public class MocaLanguageContext {

    public enum ContextId {
        Moca, MocaSql, Groovy
    };

    public MocaLanguageContext.ContextId id;
    public int rangeIdx;

    public MocaLanguageContext() {
        this.id = MocaLanguageContext.ContextId.Moca;
        this.rangeIdx = 0;
    }

    public MocaLanguageContext(MocaLanguageContext.ContextId id, int rangeIdx) {
        this.id = id;
        this.rangeIdx = rangeIdx;
    }

}