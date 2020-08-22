package com.github.mrglassdanny.mocalanguageserver.moca.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.github.mrglassdanny.mocalanguageserver.moca.MocaResults;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.LoginFailException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MocaConnection {

    private String urlStr;
    private String environmentVariablesXmlStr;

    public MocaConnection(String urlStr) {
        this.urlStr = urlStr;
        this.environmentVariablesXmlStr = "";
    }

    public void login(String userId, String password) throws IOException, LoginFailException {
        MocaResults res = this
                .executeCommand(String.format("login user where usr_id = '%s' and usr_pswd = '%s'", userId, password));

        if (res == null) {
            throw new LoginFailException();
        }

        String localeId = res.getString(0, "locale_id");
        String usrId = res.getString(0, "usr_id");
        String sessionKey = res.getString(0, "session_key");

        this.environmentVariablesXmlStr = String.format(
                "<var name=\"LOCALE_ID\" value=\"%s\"/><var name=\"USR_ID\" value=\"%s\"/><var name=\"SESSION_KEY\" value=\"%s\"/>",
                localeId, usrId, sessionKey);
    }

    // TODO - use headers to determine status of request, ie login failed, etc.
    public MocaResults executeCommand(String command) throws IOException, JsonSyntaxException {

        // Setup connection object(s).
        URL url = new URL(this.urlStr);
        // We have to create a new instance of HttpURLConnection every time we send a
        // request to the MOCA server.
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("POST");
        httpConnection.setRequestProperty("Content-Type", "application/moca-xml");
        httpConnection.setRequestProperty("Accept", "application/json");
        httpConnection.setRequestProperty("Response-Encoder", "Json");
        httpConnection.setDoOutput(true);

        // Build moca request.
        String mocaRequest = MocaConnection.generateMocaRequestXmlString(true, this.environmentVariablesXmlStr,
                command);

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

        if (responseJsonStr == null) {
            return null;
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

    private static String generateMocaRequestXmlString(boolean autoCommit, String environmentVariables, String query) {

        // Auto commit:
        String autoCommitXmlElem = String.format("autocommit=\"%s\"", (autoCommit ? "true" : "false"));

        // Environment variables:
        String environmentVariablesXmlElem = String.format("<environment>%s</environment>", environmentVariables);

        // Query:
        // Make sure the query string is escaped.
        String escapedQuery = MocaConnection.escapeXml(query);
        String queryXmlElem = String.format("<query>%s</query>", escapedQuery);

        return String.format("<moca-request %s>%s%s</moca-request>", autoCommitXmlElem, environmentVariablesXmlElem,
                queryXmlElem);

    }
}