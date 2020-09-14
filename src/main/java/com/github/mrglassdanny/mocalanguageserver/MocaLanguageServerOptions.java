package com.github.mrglassdanny.mocalanguageserver;

public class MocaLanguageServerOptions {

    public boolean mocaErrorDiagnosticsEnabled;
    public boolean mocaWarningDiagnosticsEnabled;

    public boolean mocasqlErrorDiagnosticsEnabled;
    public boolean mocasqlWarningDiagnosticsEnabled;

    public boolean groovyErrorDiagnosticsEnabled;
    public boolean groovyWarningDiagnosticsEnabled;

    public boolean mocasqlFormattingEnabled;
    public boolean groovyFormattingEnabled;

    public boolean groovyStaticTypeCheckingEnabled;

    public MocaLanguageServerOptions() {
        this.mocaErrorDiagnosticsEnabled = true;
        this.mocaWarningDiagnosticsEnabled = true;

        this.mocasqlErrorDiagnosticsEnabled = true;
        this.mocasqlWarningDiagnosticsEnabled = true;

        this.groovyErrorDiagnosticsEnabled = true;
        this.groovyWarningDiagnosticsEnabled = true;

        this.mocasqlFormattingEnabled = true;
        this.groovyFormattingEnabled = true;

        this.groovyStaticTypeCheckingEnabled = true;
    }

}
