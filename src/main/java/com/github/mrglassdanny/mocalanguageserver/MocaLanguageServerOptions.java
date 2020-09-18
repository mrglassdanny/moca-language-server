package com.github.mrglassdanny.mocalanguageserver;

public class MocaLanguageServerOptions {

    public boolean mocaDiagnosticsEnabled;
    public boolean mocaWarningDiagnosticsEnabled;
    public boolean mocasqlDiagnosticsEnabled;
    public boolean mocasqlWarningDiagnosticsEnabled;
    public boolean groovyDiagnosticsEnabled;
    public boolean groovyWarningDiagnosticsEnabled;

    public boolean mocasqlFormattingEnabled;
    public boolean groovyFormattingEnabled;

    public boolean groovyStaticTypeCheckingEnabled;

    public MocaLanguageServerOptions() {
        this.mocaDiagnosticsEnabled = true;
        this.mocaWarningDiagnosticsEnabled = true;
        this.mocasqlDiagnosticsEnabled = true;
        this.mocaWarningDiagnosticsEnabled = true;
        this.groovyDiagnosticsEnabled = true;
        this.groovyWarningDiagnosticsEnabled = true;

        this.mocasqlFormattingEnabled = true;
        this.groovyFormattingEnabled = true;

        this.groovyStaticTypeCheckingEnabled = true;
    }

}
