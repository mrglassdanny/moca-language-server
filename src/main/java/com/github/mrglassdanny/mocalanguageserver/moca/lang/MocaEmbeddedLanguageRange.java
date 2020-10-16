package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import org.eclipse.lsp4j.Range;

public class MocaEmbeddedLanguageRange {
    public Range range;
    public MocaLanguageContext mocaLanguageContext;
    // This field represents whether or not range did change from last compilation.
    // MocaCompiler.compileScript sets all ranges didChange to 'true', while
    // MocaCompiler.compileScriptChanges will only set 'true' if change occured and
    // we are compiling. Otherwise, didChange will stay 'false'.
    public boolean didChange;

    public MocaEmbeddedLanguageRange(Range range, MocaLanguageContext mocaLanguageContext) {
        this.range = range;
        this.mocaLanguageContext = mocaLanguageContext;
        this.didChange = false;
    }
}
