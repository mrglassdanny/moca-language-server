package com.github.mrglassdanny.mocalanguageserver;

public class MocaLanguageServerOptions {

    public boolean mocaDiagnosticsEnabled;
    public boolean mocasqlDiagnosticsEnabled;
    public boolean groovyDiagnosticsEnabled;

    public boolean mocasqlFormattingEnabled;
    public boolean groovyFormattingEnabled;

    public boolean groovyStaticTypeCheckingEnabled;

    public MocaLanguageServerOptions() {
        this.mocaDiagnosticsEnabled = true;
        this.mocasqlDiagnosticsEnabled = true;
        this.groovyDiagnosticsEnabled = true;

        this.mocasqlFormattingEnabled = true;
        this.groovyFormattingEnabled = true;

        this.groovyStaticTypeCheckingEnabled = true;
    }

}
