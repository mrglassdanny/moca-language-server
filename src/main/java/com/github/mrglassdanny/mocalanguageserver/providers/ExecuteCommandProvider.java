package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.appdata.AppDataManager;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.CancelMocaExecutionRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaCommandLookupRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaConnectionRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaExecutionHistoryRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaMloadRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaResultsRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaTraceRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.CancelMocaExecutionResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaCommandLookupResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaExecutionHistoryResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaMloadResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaResultsResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaTraceResponse;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnectionWrapper;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.GroovyCompiler;

import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.services.LanguageClient;

public class ExecuteCommandProvider {

    public static final String CONNECT = "mocalanguageserver.server.connect";
    public static final String LOAD_REPOSITORY = "mocalanguageserver.server.loadRepository";
    public static final String EXECUTE = "mocalanguageserver.server.execute";
    public static final String TRACE = "mocalanguageserver.server.trace";
    public static final String COMMAND_LOOKUP = "mocalanguageserver.server.commandLookup";
    public static final String EXECUTION_HISTORY = "mocalanguageserver.server.executionHistory";
    public static final String CANCEL_EXECUTION = "mocalanguageserver.server.cancelExecution";
    public static final String MLOAD = "mocalanguageserver.server.mload";

    public static ArrayList<String> mocaLanguageServerCommands = new ArrayList<>();
    static {
        mocaLanguageServerCommands.add(CONNECT);
        mocaLanguageServerCommands.add(LOAD_REPOSITORY);
        mocaLanguageServerCommands.add(EXECUTE);
        mocaLanguageServerCommands.add(TRACE);
        mocaLanguageServerCommands.add(COMMAND_LOOKUP);
        mocaLanguageServerCommands.add(EXECUTION_HISTORY);
        mocaLanguageServerCommands.add(CANCEL_EXECUTION);
        mocaLanguageServerCommands.add(MLOAD);
    }

    public static CompletableFuture<Object> provideCommandExecution(ExecuteCommandParams params,
            LanguageClient languageClient) {
        switch (params.getCommand()) {

            case CONNECT:

                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaConnectionRequest mocaConnectionRequest = new MocaConnectionRequest(args);

                    if (mocaConnectionRequest.useExistingRepository
                            && MocaLanguageServer.currentMocaConnection != null) {
                        MocaLanguageServer.currentMocaConnection = new MocaConnectionWrapper(mocaConnectionRequest.url,
                                mocaConnectionRequest.userId, mocaConnectionRequest.password,
                                MocaLanguageServer.currentMocaConnection.cache);
                    } else {
                        MocaLanguageServer.currentMocaConnection = new MocaConnectionWrapper(mocaConnectionRequest.url,
                                mocaConnectionRequest.userId, mocaConnectionRequest.password);
                    }

                    GroovyCompiler.classpathList = mocaConnectionRequest.classpathList;

                    MocaLanguageServer.globalStoragePath = mocaConnectionRequest.globalStoragePath;
                    MocaConnectionResponse mocaConnectionResponse = MocaLanguageServer.currentMocaConnection.connect();

                    // Here seems like a good time to run appdata maintenance.
                    AppDataManager.runMaintenance();

                    return CompletableFuture.completedFuture(mocaConnectionResponse);
                } catch (Exception exception) {
                    MocaConnectionResponse mocaConnectionResponse = new MocaConnectionResponse(false, exception);
                    return CompletableFuture.completedFuture(mocaConnectionResponse);
                }

            case LOAD_REPOSITORY:
                MocaLanguageServer.currentMocaConnection.loadRepository();
                return CompletableFuture.completedFuture(new Object());
            case EXECUTE:
                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaResultsRequest mocaResultsRequest = new MocaResultsRequest(args);

                    // Adding elapsed time console logging.
                    long start = System.currentTimeMillis();

                    MocaResultsResponse mocaResultsResponse = MocaLanguageServer.currentMocaConnection
                            .executeCommand(mocaResultsRequest.script);

                    // Check to see if our connection timed out. We will know whether or not this is
                    // the case based on the error message in the mocaResultsResponse.
                    if (mocaResultsResponse.exception != null
                            && mocaResultsResponse.exception instanceof MocaException) {
                        MocaException resMocaException = (MocaException) mocaResultsResponse.exception;

                        int curSts = resMocaException.getStatus();
                        if (curSts == 301 || curSts == 203 || curSts == 523) {
                            // If connection timed out, we need to quitely try to reconnect and rerun the
                            // script.
                            MocaConnectionResponse reconnectResponse = MocaLanguageServer.currentMocaConnection
                                    .connect();

                            // If reconnect response has exception, we need to return the message to the
                            // user. Otherwise, rerun the script. We should be able to reuse
                            // mocaResultsResponse initialized above in either case.
                            if (!reconnectResponse.eOk) {
                                mocaResultsResponse.exception = reconnectResponse.exception;
                                mocaResultsResponse.results = null;
                            } else {
                                mocaResultsResponse = MocaLanguageServer.currentMocaConnection
                                        .executeCommand(mocaResultsRequest.script);
                            }
                        }
                    }

                    // End will be a bit skewed if we had to reconnect due to timeout... but oh well
                    // -- it shouldnt happen very often.
                    long end = System.currentTimeMillis();

                    // Elapsed time in terms of seconds.
                    double elapsedTime = ((double) (end - start) / 1000.0000);

                    int rowCount = 0;
                    if (mocaResultsResponse.results != null) {
                        rowCount = mocaResultsResponse.results.getRowCount();
                    }

                    languageClient.logMessage(new MessageParams(MessageType.Info, mocaResultsRequest.fileName
                            + ": Returned " + rowCount + " rows in " + elapsedTime + " seconds"));

                    // Add history entry to appdata.
                    try {
                        int status = 0;
                        String message = "";
                        if (mocaResultsResponse.exception != null) {
                            if (mocaResultsResponse.exception instanceof MocaException) {
                                MocaException mocaException = (MocaException) mocaResultsResponse.exception;
                                status = mocaException.getStatus();
                                message = mocaException.getMessage();
                            } else {
                                status = 0;
                                message = mocaResultsResponse.exception.getMessage();
                            }
                        }
                        AppDataManager.createExecutionHistory(status, message, rowCount, elapsedTime,
                                mocaResultsRequest.script.replace("\"", "\"\""), mocaResultsResponse.results,
                                MocaLanguageServer.currentMocaConnection.url);
                    } catch (Exception ex) {
                        // Log error message for now.
                        languageClient.logMessage(
                                new MessageParams(MessageType.Error, "Could not create history: " + ex.getMessage()));
                    }

                    return CompletableFuture.completedFuture(mocaResultsResponse);
                } catch (Exception exception) {
                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse(null, exception);
                    return CompletableFuture.completedFuture(mocaResultsResponse);
                }

            case TRACE:

                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaTraceRequest mocaTraceRequest = new MocaTraceRequest(args);

                    if (mocaTraceRequest.fileName.isEmpty()) {
                        mocaTraceRequest.fileName = MocaLanguageServer.currentMocaConnection.userId;
                    }

                    MocaResultsResponse resResponse = null;
                    if (mocaTraceRequest.startTrace) {
                        resResponse = MocaLanguageServer.currentMocaConnection.executeCommand(
                                "set trace where activate = 1 and filename = '" + mocaTraceRequest.fileName
                                        + ".log' and trcmod = '" + mocaTraceRequest.mode + "'");
                    } else {
                        resResponse = MocaLanguageServer.currentMocaConnection
                                .executeCommand("set trace where activate = 0");
                    }

                    return CompletableFuture.completedFuture(new MocaTraceResponse(resResponse));
                } catch (Exception exception) {
                    return CompletableFuture
                            .completedFuture(new MocaTraceResponse(new MocaResultsResponse(null, exception)));
                }

            case COMMAND_LOOKUP:
                try {
                    List<Object> args = params.getArguments();

                    MocaCommandLookupRequest mocaCommandLookupRequest = new MocaCommandLookupRequest(args);
                    // If command is not passed in, then we will send all distinct commands.
                    // Otherwise, we will send all the data for the requested command.
                    MocaCommandLookupResponse mocaCommandLookupResponse;
                    if (mocaCommandLookupRequest.requestedMocaCommand == null) {
                        mocaCommandLookupResponse = new MocaCommandLookupResponse(
                                MocaLanguageServer.currentMocaConnection.cache.commandRepository.distinctCommands, null,
                                null, null);
                    } else {
                        mocaCommandLookupResponse = new MocaCommandLookupResponse(null,
                                MocaLanguageServer.currentMocaConnection.cache.commandRepository.commands
                                        .get(mocaCommandLookupRequest.requestedMocaCommand),
                                MocaLanguageServer.currentMocaConnection.cache.commandRepository.triggers
                                        .get(mocaCommandLookupRequest.requestedMocaCommand),
                                null);
                    }

                    return CompletableFuture.completedFuture(mocaCommandLookupResponse);
                } catch (Exception exception) {
                    return CompletableFuture
                            .completedFuture(new MocaCommandLookupResponse(null, null, null, exception));
                }

            case EXECUTION_HISTORY:
                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaExecutionHistoryRequest executionHistoryRequest = new MocaExecutionHistoryRequest(args);

                    return CompletableFuture.completedFuture(new MocaExecutionHistoryResponse(
                            new MocaResultsResponse(AppDataManager.getExecutionHistory(), null)));
                } catch (Exception exception) {
                    return CompletableFuture.completedFuture(new MocaExecutionHistoryResponse(null));
                }

            case CANCEL_EXECUTION:
                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new CancelMocaExecutionResponse(false));
                    }

                    CancelMocaExecutionRequest cancelExecutionRequest = new CancelMocaExecutionRequest(args);

                    // TODO - Find thread id and interrupt it.

                    return CompletableFuture.completedFuture(new CancelMocaExecutionResponse(false));
                } catch (Exception exception) {
                    return CompletableFuture.completedFuture(new CancelMocaExecutionResponse(false));
                }

            case MLOAD:

                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaMloadRequest mloadRequest = new MocaMloadRequest(args);

                    // TODO - do stuff.

                    return CompletableFuture.completedFuture(new MocaMloadResponse());
                } catch (Exception exception) {
                    return CompletableFuture.completedFuture(new MocaMloadResponse());
                }
            default:
                break;

        }

        return CompletableFuture.completedFuture(new Object());
    }

}