package com.github.mrglassdanny.mocalanguageserver.moca.connection;

import java.io.IOException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.UnsupportedConnectionTypeException;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MocaConnection {

    // Using singleton pattern to manage single global moca connection instance.
    private static MocaConnection globalMocaConnection;

    public static MocaConnection getGlobalMocaConnection() {
        if (globalMocaConnection == null) {
            MocaConnection.globalMocaConnection = new MocaConnection();
            return MocaConnection.globalMocaConnection;
        } else {
            return MocaConnection.globalMocaConnection;
        }
    }

    private String urlStr;
    private String userId;
    private String password;
    private String sessionId;
    private String environmentVariablesXmlStr;

    private MocaConnection() {
        this.urlStr = null;
        this.userId = null;
        this.password = null;
        this.sessionId = null;
        this.environmentVariablesXmlStr = null;
    }

    private void login() throws IOException, MocaException, Exception {
        MocaResults res = this.executeCommand(
                String.format("login user where usr_id = '%s' and usr_pswd = '%s'", this.userId, this.password));

        String localeId = res.getString(0, "locale_id");
        String usrId = res.getString(0, "usr_id");
        String sessionKey = res.getString(0, "session_key");

        this.environmentVariablesXmlStr = String.format(
                "<var name=\"LOCALE_ID\" value=\"%s\"/><var name=\"USR_ID\" value=\"%s\"/><var name=\"SESSION_KEY\" value=\"%s\"/>",
                localeId, usrId, sessionKey);
    }

    public void connect(String urlStr, String userId, String password) throws Exception {

        this.urlStr = urlStr;
        this.userId = userId;
        this.password = password;
        this.sessionId = "";
        this.environmentVariablesXmlStr = "";

        // Test to see if url is correct type -- we will only support http and https.
        String lowerCaseUrlStr = this.urlStr.toLowerCase();
        if (!lowerCaseUrlStr.startsWith("http") && !lowerCaseUrlStr.startsWith("https")) {
            throw new UnsupportedConnectionTypeException(
                    "MOCA Language Server only supports 'http' and 'https' connections!");
        }

        this.login();

    }

    public MocaResults executeCommand(String command) throws IOException, MocaException, Exception {

        // Validate instance.
        if (!this.isValid()) {
            return null;
        }

        // Setup connection object(s).
        // Add session id to url string if it is not null.
        URL url = null;
        if (this.sessionId != null) {
            url = new URL(String.format("%s?msession=%s", this.urlStr, this.sessionId));

        } else {
            url = new URL(this.urlStr);
        }

        // Build moca request.
        String mocaRequest = MocaConnection.generateMocaRequestXmlString(true, this.sessionId,
                this.environmentVariablesXmlStr, command);

        // We will keep connect timeout at default 10 secs and read timeout/write
        // timeout at 3 mins.
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).build();
        MediaType mediaType = MediaType.parse("application/moca-xml");
        RequestBody body = RequestBody.create(mediaType, mocaRequest);
        Request request = new Request.Builder().url(url).post(body).addHeader("Content-Type", "application/moca-xml")
                .addHeader("Accept", "application/json").addHeader("Response-Encoder", "Json").build();
        Response response = client.newCall(request).execute();

        // Process headers -- these will tell the story if something went wrong.
        // We also need to extract session id if it is there.
        String sessionId = null;
        int commandStatusHeader = 0;
        String messageHeader = null;

        try {
            sessionId = response.header("Session-Id");
            // Change session id if it is different than before.
            if (sessionId != null && !sessionId.equals(this.sessionId)) {
                this.sessionId = sessionId;
            }

            commandStatusHeader = Integer.parseInt(response.header("Command-Status"));
            messageHeader = response.header("Message");

        } catch (Exception headerAnalysisException) {
            // Do not care about doing anything here -- just want to make sure we do not
            // crash.
        }

        if (commandStatusHeader != 0) {
            throw new MocaException(messageHeader != null ? messageHeader : "Unknown Error Occured",
                    commandStatusHeader);
        }

        return new Gson().fromJson(response.body().string(), MocaResults.class);
    }

    public final String getUrlStr() {
        return this.urlStr;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getPassword() {
        return this.password;
    }

    public boolean isValid() {
        return this.urlStr != null && this.userId != null && this.password != null
                && this.environmentVariablesXmlStr != null;
    }

    // Utilies.
    private static String escapeXml(String str) {

        StringBuilder buf = new StringBuilder();
        char[] arr = str.toCharArray();

        for (char c : arr) {
            switch (c) {
                case '"':
                    buf.append("&quot;");
                    break;
                case '\'':
                    buf.append("&apos;");
                    break;
                case '&':
                    buf.append("&amp;");
                    break;
                case '<':
                    buf.append("&lt;");
                    break;
                case '>':
                    buf.append("&gt;");
                    break;
                default:
                    buf.append(c);
                    break;
            }
        }

        return buf.toString();

    }

    private static String generateMocaRequestXmlString(boolean autoCommit, String sessionId,
            String environmentVariables, String query) {

        // Auto commit:
        String autoCommitXmlElem = String.format("autocommit=\"%s\"", (autoCommit ? "true" : "false"));

        // Session id:
        String sessionIdXmlElem = String.format("<session id=\"%s\"/>", sessionId);

        // Environment variables:
        String environmentVariablesXmlElem = String.format("<environment>%s</environment>", environmentVariables);

        // Query:
        // Make sure the query string is escaped.
        String escapedQuery = MocaConnection.escapeXml(query);
        String queryXmlElem = String.format("<query>%s</query>", escapedQuery);

        return String.format("<moca-request %s>%s%s%s</moca-request>", autoCommitXmlElem, sessionIdXmlElem,
                environmentVariablesXmlElem, queryXmlElem);

    }
}