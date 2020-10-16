package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import org.eclipse.lsp4j.Range;

public class MocaEmbeddedLanguageRange {
    public Range range;
    public MocaLanguageContext mocaLanguageContext;

    public MocaEmbeddedLanguageRange(Range range, MocaLanguageContext mocaLanguageContext) {
        this.range = range;
        this.mocaLanguageContext = mocaLanguageContext;
    }
}
