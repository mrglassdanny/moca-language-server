package com.github.mrglassdanny.mocalanguageserver.moca.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.google.gson.Gson;

public class MocaConnection {

    private String urlStr;
    private String sessionId;
    private String environmentVariablesXmlStr;

    public MocaConnection(String urlStr) {
        this.urlStr = urlStr;
        this.sessionId = "";
        this.environmentVariablesXmlStr = "";
    }

    public void login(String userId, String password) throws IOException, MocaException, Exception {
        MocaResults res = this
                .executeCommand(String.format("login user where usr_id = '%s' and usr_pswd = '%s'", userId, password));

        String localeId = res.getString(0, "locale_id");
        String usrId = res.getString(0, "usr_id");
        String sessionKey = res.getString(0, "session_key");

        this.environmentVariablesXmlStr = String.format(
                "<var name=\"LOCALE_ID\" value=\"%s\"/><var name=\"USR_ID\" value=\"%s\"/><var name=\"SESSION_KEY\" value=\"%s\"/>",
                localeId, usrId, sessionKey);
    }

    public MocaResults executeCommand(String command) throws IOException, MocaException, Exception {

        // Setup connection object(s).
        // Add session id to url string if it is not null.
        URL url = null;
        if (this.sessionId != null) {
            url = new URL(String.format("%s?msession=%s", this.urlStr, this.sessionId));

        } else {
            url = new URL(this.urlStr);
        }

        // We have to create a new instance of HttpURLConnection every time we send a
        // request to the MOCA server.
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("POST");
        httpConnection.setRequestProperty("Content-Type", "application/moca-xml");
        httpConnection.setRequestProperty("Accept", "application/json");
        httpConnection.setRequestProperty("Response-Encoder", "Json");
        httpConnection.setDoOutput(true);

        // Build moca request.
        String mocaRequest = MocaConnection.generateMocaRequestXmlString(true, this.sessionId,
                this.environmentVariablesXmlStr, command);

        // Send request.
        try (OutputStream outputStream = httpConnection.getOutputStream()) {
            byte[] input = mocaRequest.getBytes();
            outputStream.write(input, 0, input.length);
        }

        // Read response.
        String responseJsonStr = null;
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpConnection.getInputStream()))) {
            StringBuilder responseBuf = new StringBuilder();
            String responseLine = null;
            while ((responseLine = bufferedReader.readLine()) != null) {
                responseBuf.append(responseLine.trim());
            }

            responseJsonStr = responseBuf.toString();
        }

        // If response is null, I guess just go ahead and return null.
        if (responseJsonStr == null) {
            return null;
        }

        // Process headers -- these will tell the story if something went wrong.
        // We also need to extract session id if it is there.
        String sessionId = null;
        int commandStatusHeader = 0;
        String messageHeader = null;

        try {
            sessionId = httpConnection.getHeaderField("Session-Id");
            // Change session id if it is different than before.
            if (sessionId != null && !sessionId.equals(this.sessionId)) {
                this.sessionId = sessionId;
            }

            commandStatusHeader = Integer.parseInt(httpConnection.getHeaderField("Command-Status"));
            messageHeader = httpConnection.getHeaderField("Message");
        } catch (Exception headerAnalysisException) {
            // Do not care about doing anything here -- just want to make sure we do not
            // crash.
        }

        if (commandStatusHeader != 0) {
            throw new MocaException(messageHeader != null ? messageHeader : "Unknown Error Occured",
                    commandStatusHeader);
        }

        return new Gson().fromJson(responseJsonStr, MocaResults.class);
    }

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