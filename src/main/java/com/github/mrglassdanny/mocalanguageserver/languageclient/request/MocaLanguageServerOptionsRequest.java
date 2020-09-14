package com.github.mrglassdanny.mocalanguageserver.languageclient.request;

import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServerOptions;
import com.google.gson.JsonObject;

public class MocaLanguageServerOptionsRequest {

    public MocaLanguageServerOptions mocaLanguageServerOptions;

    public MocaLanguageServerOptionsRequest(List<Object> args) throws Exception {

        JsonObject jsonObj = (JsonObject) args.get(0);
        this.mocaLanguageServerOptions = new MocaLanguageServerOptions();
        this.mocaLanguageServerOptions.mocaErrorDiagnosticsEnabled = jsonObj.get("moca-error-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.mocaWarningDiagnosticsEnabled = jsonObj.get("moca-warning-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.mocasqlErrorDiagnosticsEnabled = jsonObj.get("mocasql-error-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.mocasqlWarningDiagnosticsEnabled = jsonObj
                .get("mocasql-warning-diagnostics-enabled").getAsBoolean();
        this.mocaLanguageServerOptions.groovyErrorDiagnosticsEnabled = jsonObj.get("groovy-error-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.groovyWarningDiagnosticsEnabled = jsonObj
                .get("groovy-warning-diagnostics-enabled").getAsBoolean();
        this.mocaLanguageServerOptions.mocasqlFormattingEnabled = jsonObj.get("mocasql-formatting-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.groovyFormattingEnabled = jsonObj.get("groovy-formatting-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.groovyStaticTypeCheckingEnabled = jsonObj
                .get("groovy-static-type-checking-enabled").getAsBoolean();

    }

    public MocaLanguageServerOptionsRequest(JsonObject jsonObj) throws Exception {

        this.mocaLanguageServerOptions = new MocaLanguageServerOptions();
        this.mocaLanguageServerOptions.mocaErrorDiagnosticsEnabled = jsonObj.get("moca-error-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.mocaWarningDiagnosticsEnabled = jsonObj.get("moca-warning-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.mocasqlErrorDiagnosticsEnabled = jsonObj.get("mocasql-error-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.mocasqlWarningDiagnosticsEnabled = jsonObj
                .get("mocasql-warning-diagnostics-enabled").getAsBoolean();
        this.mocaLanguageServerOptions.groovyErrorDiagnosticsEnabled = jsonObj.get("groovy-error-diagnostics-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.groovyWarningDiagnosticsEnabled = jsonObj
                .get("groovy-warning-diagnostics-enabled").getAsBoolean();
        this.mocaLanguageServerOptions.mocasqlFormattingEnabled = jsonObj.get("mocasql-formatting-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.groovyFormattingEnabled = jsonObj.get("groovy-formatting-enabled")
                .getAsBoolean();
        this.mocaLanguageServerOptions.groovyStaticTypeCheckingEnabled = jsonObj
                .get("groovy-static-type-checking-enabled").getAsBoolean();

    }

}
