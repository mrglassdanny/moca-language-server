package com.github.mrglassdanny.mocalanguageserver.services.command.request;

import java.util.List;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServerOptions;
import com.google.gson.JsonObject;

public class MocaLanguageServerOptionsRequest {

        public MocaLanguageServerOptions mocaLanguageServerOptions;

        public MocaLanguageServerOptionsRequest(List<Object> args) throws Exception {
                this((JsonObject) args.get(0));
        }

        public MocaLanguageServerOptionsRequest(JsonObject jsonObj) throws Exception {

                this.mocaLanguageServerOptions = new MocaLanguageServerOptions();
                this.mocaLanguageServerOptions.mocaDiagnosticsEnabled = jsonObj.get("moca-diagnostics-enabled")
                                .getAsBoolean();
                this.mocaLanguageServerOptions.mocaWarningDiagnosticsEnabled = jsonObj
                                .get("moca-warning-diagnostics-enabled").getAsBoolean();
                // Setting in client is sql instead of mocasql.
                this.mocaLanguageServerOptions.mocasqlDiagnosticsEnabled = jsonObj.get("sql-diagnostics-enabled")
                                .getAsBoolean();
                // Setting in client is sql instead of mocasql.
                this.mocaLanguageServerOptions.mocasqlWarningDiagnosticsEnabled = jsonObj
                                .get("sql-warning-diagnostics-enabled").getAsBoolean();
                this.mocaLanguageServerOptions.groovyDiagnosticsEnabled = jsonObj.get("groovy-diagnostics-enabled")
                                .getAsBoolean();
                this.mocaLanguageServerOptions.groovyWarningDiagnosticsEnabled = jsonObj
                                .get("groovy-warning-diagnostics-enabled").getAsBoolean();
                // Setting in client is sql instead of mocasql.
                this.mocaLanguageServerOptions.mocasqlFormattingEnabled = jsonObj.get("sql-formatting-enabled")
                                .getAsBoolean();
                this.mocaLanguageServerOptions.groovyFormattingEnabled = jsonObj.get("groovy-formatting-enabled")
                                .getAsBoolean();
                this.mocaLanguageServerOptions.groovyStaticTypeCheckingEnabled = jsonObj
                                .get("groovy-static-type-checking-enabled").getAsBoolean();

        }

}
