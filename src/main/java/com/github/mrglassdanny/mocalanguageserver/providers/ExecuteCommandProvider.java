package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaCommandLookupRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaConnectionRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaLanguageServerActivateRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaResultsRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.MocaTraceRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.request.TrainFormattersRequest;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.LoadCacheResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaCommandLookupResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaLanguageServerActivateResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaResultsResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.MocaTraceResponse;
import com.github.mrglassdanny.mocalanguageserver.languageclient.response.TrainFormattersResponse;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnectionWrapper;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.format.MocaFormatter;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.sql.format.MocaSqlFormatter;

import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.services.LanguageClient;

public class ExecuteCommandProvider {

    private static final String ERR_NOT_CONNECTED_TO_MOCA_SERVER = "Not connected to MOCA Server";

    public static final String ACTIVATE = "mocalanguageserver.activate";
    public static final String CONNECT = "mocalanguageserver.connect";
    public static final String LOAD_CACHE = "mocalanguageserver.loadCache";
    public static final String EXECUTE = "mocalanguageserver.execute";
    public static final String TRACE = "mocalanguageserver.trace";
    public static final String COMMAND_LOOKUP = "mocalanguageserver.commandLookup";
    public static final String TRAIN_FORMATTERS = "mocalanguageserver.trainFormatters";

    public static ArrayList<String> mocaLanguageServerCommands = new ArrayList<>();
    static {
        mocaLanguageServerCommands.add(ACTIVATE);
        mocaLanguageServerCommands.add(CONNECT);
        mocaLanguageServerCommands.add(LOAD_CACHE);
        mocaLanguageServerCommands.add(EXECUTE);
        mocaLanguageServerCommands.add(TRACE);
        mocaLanguageServerCommands.add(COMMAND_LOOKUP);
        mocaLanguageServerCommands.add(TRAIN_FORMATTERS);
    }

    public static CompletableFuture<Object> provideCommandExecution(ExecuteCommandParams params,
            LanguageClient languageClient) {
        switch (params.getCommand()) {

            case ACTIVATE:

                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }
                    MocaLanguageServerActivateRequest mocaLanguageServerActivateRequest = new MocaLanguageServerActivateRequest(
                            args);
                    MocaLanguageServer.globalStoragePath = mocaLanguageServerActivateRequest.globalStoragePath;

                    // Now that we have a global storage path, lets take this opportunity to do a
                    // couple of things:
                    // Make sure format training defaults exist.
                    MocaFormatter.createDefaults();
                    MocaSqlFormatter.createDefaults();
                    // Train our formatters.
                    MocaFormatter.configureAndTrain(mocaLanguageServerActivateRequest.formatTrainingMocaDirName);
                    MocaSqlFormatter.configureAndTrain(mocaLanguageServerActivateRequest.formatTrainingMocaSqlDirName);

                    return CompletableFuture.completedFuture(new Object());
                } catch (Exception exception) {
                    MocaLanguageServerActivateResponse mocaLanguageServerActivateResponse = new MocaLanguageServerActivateResponse(
                            exception);
                    return CompletableFuture.completedFuture(mocaLanguageServerActivateResponse);
                }
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

                    MocaConnectionResponse mocaConnectionResponse = MocaLanguageServer.currentMocaConnection.connect();

                    return CompletableFuture.completedFuture(mocaConnectionResponse);
                } catch (Exception exception) {
                    MocaConnectionResponse mocaConnectionResponse = new MocaConnectionResponse(false, exception);
                    return CompletableFuture.completedFuture(mocaConnectionResponse);
                }

            case LOAD_CACHE:

                // No need to do anything special with request; we are not expecting any
                // arguments.

                // Make sure connection has url.
                if (MocaLanguageServer.currentMocaConnection.url == null) {
                    LoadCacheResponse loadCacheResponse = new LoadCacheResponse(
                            new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER));
                    return CompletableFuture.completedFuture(loadCacheResponse);
                }

                // We want the caller to know when the cache is done loading.
                // The longest function is the moca command loader, so we
                // will just return when it is complete. The rest of functions
                // will be run async.

                CompletableFuture.runAsync(() -> {
                    MocaLanguageServer.currentMocaConnection.cache.mocaCache.loadCommandArguments();
                });

                CompletableFuture.runAsync(() -> {
                    MocaLanguageServer.currentMocaConnection.cache.mocaCache.loadTriggers();
                });

                CompletableFuture.runAsync(() -> {
                    MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.loadTables();
                });

                CompletableFuture.runAsync(() -> {
                    MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.loadViews();
                });

                CompletableFuture.runAsync(() -> {
                    MocaLanguageServer.currentMocaConnection.cache.mocaSqlCache.loadColumns();
                });

                MocaLanguageServer.currentMocaConnection.cache.mocaCache.loadCommands();

                return CompletableFuture.completedFuture(new LoadCacheResponse(null));
            case EXECUTE:

                if (MocaLanguageServer.currentMocaConnection.url == null) {
                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse(null,
                            new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER));
                    return CompletableFuture.completedFuture(mocaResultsResponse);
                }

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

                    return CompletableFuture.completedFuture(mocaResultsResponse);
                } catch (Exception exception) {
                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse(null, exception);
                    return CompletableFuture.completedFuture(mocaResultsResponse);
                }

            case TRACE:

                if (MocaLanguageServer.currentMocaConnection.url == null) {
                    MocaTraceResponse mocaTraceResponse = new MocaTraceResponse(
                            new MocaResultsResponse(null, new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER)));
                    return CompletableFuture.completedFuture(mocaTraceResponse);
                }

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
                                MocaLanguageServer.currentMocaConnection.cache.mocaCache.distinctCommands, null, null,
                                null);
                    } else {
                        mocaCommandLookupResponse = new MocaCommandLookupResponse(null,
                                MocaLanguageServer.currentMocaConnection.cache.mocaCache.commands
                                        .get(mocaCommandLookupRequest.requestedMocaCommand),
                                MocaLanguageServer.currentMocaConnection.cache.mocaCache.triggers
                                        .get(mocaCommandLookupRequest.requestedMocaCommand),
                                null);
                    }

                    return CompletableFuture.completedFuture(mocaCommandLookupResponse);
                } catch (Exception exception) {
                    return CompletableFuture
                            .completedFuture(new MocaCommandLookupResponse(null, null, null, exception));
                }
            case TRAIN_FORMATTERS:
                try {

                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    TrainFormattersRequest trainFormattersRequest = new TrainFormattersRequest(args);

                    MocaFormatter.configureAndTrain(trainFormattersRequest.mocaDirName);
                    MocaSqlFormatter.configureAndTrain(trainFormattersRequest.mocaSqlDirName);

                    return CompletableFuture.completedFuture(new Object());
                } catch (Exception exception) {
                    TrainFormattersResponse trainFormattersResponse = new TrainFormattersResponse(exception);
                    return CompletableFuture.completedFuture(trainFormattersResponse);
                }
            default:
                break;

        }

        return CompletableFuture.completedFuture(new Object());
    }

}