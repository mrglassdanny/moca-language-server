package com.github.mrglassdanny.mocalanguageserver.moca.lang;

public class MocaLanguageContext {

    public enum ContextId {
        Moca, MocaSql, Groovy
    };

    public MocaLanguageContext.ContextId id;
    // Represents key in compilation result maps.
    public int compilationResultIdx;

    public MocaLanguageContext() {
        this.id = MocaLanguageContext.ContextId.Moca;
        this.compilationResultIdx = 0;
    }

    public MocaLanguageContext(MocaLanguageContext.ContextId id, int compilationResultIdx) {
        this.id = id;
        this.compilationResultIdx = compilationResultIdx;
    }

}