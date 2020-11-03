package com.github.mrglassdanny.mocalanguageserver.services.command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaCommandLookupRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaConnectionRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaLanguageServerActivateRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaLanguageServerOptionsRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaResultsRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaTraceRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.OpenMocaTraceRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.LoadCacheResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaCommandLookupResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaLanguageServerActivateResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaLanguageServerOptionsResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaResultsResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaTraceResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.OpenMocaTraceResponse;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCache;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnection;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.TraceOutliner;

import org.eclipse.lsp4j.ExecuteCommandParams;

public class ExecuteCommandProvider {

    private static final String ERR_NOT_CONNECTED_TO_MOCA_SERVER = "Not connected to MOCA Server";

    public static final String ACTIVATE = "mocalanguageserver.activate";
    public static final String CONNECT = "mocalanguageserver.connect";
    public static final String LOAD_CACHE = "mocalanguageserver.loadCache";
    public static final String EXECUTE = "mocalanguageserver.execute";
    public static final String TRACE = "mocalanguageserver.trace";
    public static final String COMMAND_LOOKUP = "mocalanguageserver.commandLookup";
    public static final String SET_LANGUAGE_SERVER_OPTIONS = "mocalanguageserver.setLanguageServerOptions";
    public static final String OPEN_TRACE = "mocalanguageserver.openTrace";

    public static ArrayList<String> mocaLanguageServerCommands = new ArrayList<>();
    static {
        mocaLanguageServerCommands.add(ACTIVATE);
        mocaLanguageServerCommands.add(CONNECT);
        mocaLanguageServerCommands.add(LOAD_CACHE);
        mocaLanguageServerCommands.add(EXECUTE);
        mocaLanguageServerCommands.add(TRACE);
        mocaLanguageServerCommands.add(COMMAND_LOOKUP);
        mocaLanguageServerCommands.add(SET_LANGUAGE_SERVER_OPTIONS);
        mocaLanguageServerCommands.add(OPEN_TRACE);
    }

    public static CompletableFuture<Object> provideCommandExecution(ExecuteCommandParams params) {
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
                    MocaLanguageServer.mocaLanguageServerOptions = mocaLanguageServerActivateRequest.mocaLanguageServerOptionsRequest.mocaLanguageServerOptions;
                    GroovyCompiler.classpathList = mocaLanguageServerActivateRequest.defaultGroovyClasspathList;

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

                    GroovyCompiler.classpathList = mocaConnectionRequest.groovyClasspathList;

                    MocaConnectionResponse mocaConnectionResponse = new MocaConnectionResponse();
                    try {
                        MocaConnection.getGlobalMocaConnection().connect(mocaConnectionRequest.url,
                                mocaConnectionRequest.userId, mocaConnectionRequest.password,
                                mocaConnectionRequest.approveUnsafeScripts);
                        mocaConnectionResponse.eOk = true;
                        mocaConnectionResponse.exception = null;
                    } catch (Exception e) {
                        mocaConnectionResponse.eOk = false;
                        mocaConnectionResponse.exception = e;
                    }

                    return CompletableFuture.completedFuture(mocaConnectionResponse);
                } catch (Exception exception) {
                    MocaConnectionResponse mocaConnectionResponse = new MocaConnectionResponse(false, exception);
                    return CompletableFuture.completedFuture(mocaConnectionResponse);
                }

            case LOAD_CACHE:

                // No need to do anything special with request; we are not expecting any
                // arguments.

                // Make sure connection is valid.
                if (!MocaConnection.getGlobalMocaConnection().isValid()) {
                    LoadCacheResponse loadCacheResponse = new LoadCacheResponse(
                            new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER));
                    return CompletableFuture.completedFuture(loadCacheResponse);
                }

                // We want the caller to know when the cache is done loading.
                // The longest function is the moca command loader, so we
                // will just return when it is complete. The rest of functions
                // will be run async.

                // NOTE: we will check status of each cache after initial load. If empty for
                // some reason, we will 1 more time.

                CompletableFuture.runAsync(() -> {
                    MocaCache.getGlobalMocaCache().loadCommandArguments();
                    if (MocaCache.getGlobalMocaCache().commandArguments.isEmpty()) {
                        MocaCache.getGlobalMocaCache().loadCommandArguments();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaCache.getGlobalMocaCache().loadTriggers();
                    if (MocaCache.getGlobalMocaCache().triggers.isEmpty()) {
                        MocaCache.getGlobalMocaCache().loadTriggers();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaCache.getGlobalMocaCache().mocaSqlCache.loadTables();
                    if (MocaCache.getGlobalMocaCache().mocaSqlCache.tables.isEmpty()) {
                        MocaCache.getGlobalMocaCache().mocaSqlCache.loadTables();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaCache.getGlobalMocaCache().mocaSqlCache.loadViews();
                    if (MocaCache.getGlobalMocaCache().mocaSqlCache.views.isEmpty()) {
                        MocaCache.getGlobalMocaCache().mocaSqlCache.loadViews();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaCache.getGlobalMocaCache().mocaSqlCache.loadColumns();
                    if (MocaCache.getGlobalMocaCache().mocaSqlCache.columns.isEmpty()) {
                        MocaCache.getGlobalMocaCache().mocaSqlCache.loadColumns();
                    }
                });

                MocaCache.getGlobalMocaCache().loadCommands();
                if (MocaCache.getGlobalMocaCache().commands.isEmpty()) {
                    MocaCache.getGlobalMocaCache().loadCommands();
                }

                return CompletableFuture.completedFuture(new LoadCacheResponse(null));
            case EXECUTE:

                if (!MocaConnection.getGlobalMocaConnection().isValid()) {
                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse(null,
                            new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER), false);
                    return CompletableFuture.completedFuture(mocaResultsResponse);
                }

                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaResultsRequest mocaResultsRequest = new MocaResultsRequest(args);

                    // If not approved for execution, check unsafe config for connection.
                    if (!mocaResultsRequest.isApprovedForExecution) {
                        // If approval of unsafe scripts for connection is configured, check if script
                        // is unsafe.
                        if (MocaConnection.getGlobalMocaConnection().needToApproveUnsafeScripts()) {

                            MocaCompilationResult mocaCompilationResult = MocaCompiler
                                    .compileScript(mocaResultsRequest.script, mocaResultsRequest.fileName);

                            if (mocaCompilationResult.isUnsafe()) {
                                MocaResultsResponse mocaResultsResponse = new MocaResultsResponse(null, null, true);
                                return CompletableFuture.completedFuture(mocaResultsResponse);
                            }
                        }
                    }

                    // Adding elapsed time console logging.
                    long start = System.currentTimeMillis();

                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse();
                    try {
                        mocaResultsResponse.results = MocaConnection.getGlobalMocaConnection()
                                .executeCommand(mocaResultsRequest.script);
                        mocaResultsResponse.exception = null;
                        mocaResultsResponse.needsApprovalToExecute = false;
                    } catch (Exception e) {
                        mocaResultsResponse.results = null;
                        mocaResultsResponse.exception = e;
                        mocaResultsResponse.needsApprovalToExecute = false;
                    }

                    // Check to see if our connection timed out. We will know whether or not this is
                    // the case based on the error message in the mocaResultsResponse.
                    if (mocaResultsResponse.exception != null
                            && mocaResultsResponse.exception instanceof MocaException) {
                        MocaException resMocaException = (MocaException) mocaResultsResponse.exception;

                        int curSts = resMocaException.getStatus();
                        if (curSts == 301 || curSts == 203 || curSts == 523) {
                            // If connection timed out, we need to quitely try to reconnect and rerun the
                            // script.
                            MocaConnectionResponse reconnectResponse = new MocaConnectionResponse();
                            try {
                                MocaConnection.getGlobalMocaConnection().connect(
                                        MocaConnection.getGlobalMocaConnection().getUrlStr(),
                                        MocaConnection.getGlobalMocaConnection().getUserId(),
                                        MocaConnection.getGlobalMocaConnection().getPassword(),
                                        MocaConnection.getGlobalMocaConnection().needToApproveUnsafeScripts());
                                reconnectResponse.eOk = true;
                                reconnectResponse.exception = null;
                            } catch (Exception e) {
                                reconnectResponse.eOk = false;
                                reconnectResponse.exception = e;
                            }

                            // If reconnect response has exception, we need to return the message to the
                            // user. Otherwise, rerun the script. We should be able to reuse
                            // mocaResultsResponse initialized above in either case.
                            if (!reconnectResponse.eOk) {
                                mocaResultsResponse.results = null;
                                mocaResultsResponse.exception = reconnectResponse.exception;
                            } else {
                                try {
                                    mocaResultsResponse.results = MocaConnection.getGlobalMocaConnection()
                                            .executeCommand(mocaResultsRequest.script);
                                    mocaResultsResponse.exception = null;
                                } catch (Exception e) {
                                    mocaResultsResponse.results = null;
                                    mocaResultsResponse.exception = e;
                                }
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

                    MocaServices.logInfoToLanguageClient(String.format("%s: Returned %d rows in %.2f seconds",
                            mocaResultsRequest.fileName, rowCount, elapsedTime));

                    return CompletableFuture.completedFuture(mocaResultsResponse);
                } catch (Exception exception) {
                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse(null, exception, false);
                    return CompletableFuture.completedFuture(mocaResultsResponse);
                }

            case TRACE:

                if (!MocaConnection.getGlobalMocaConnection().isValid()) {
                    MocaTraceResponse mocaTraceResponse = new MocaTraceResponse(
                            new MocaResultsResponse(null, new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER), false));
                    return CompletableFuture.completedFuture(mocaTraceResponse);
                }

                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaTraceRequest mocaTraceRequest = new MocaTraceRequest(args);

                    if (mocaTraceRequest.fileName.isEmpty()) {
                        mocaTraceRequest.fileName = MocaConnection.getGlobalMocaConnection().getUserId();
                    }

                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse();
                    if (mocaTraceRequest.startTrace) {
                        try {
                            mocaResultsResponse.results = MocaConnection.getGlobalMocaConnection()
                                    .executeCommand(String.format(
                                            "set trace where activate = 1 and filename = '%s.log' and trcmod = '%s'",
                                            mocaTraceRequest.fileName, mocaTraceRequest.mode));
                            mocaResultsResponse.exception = null;
                        } catch (Exception e) {
                            mocaResultsResponse.results = null;
                            mocaResultsResponse.exception = e;
                        }
                    } else {
                        try {
                            mocaResultsResponse.results = MocaConnection.getGlobalMocaConnection()
                                    .executeCommand("set trace where activate = 0");
                            mocaResultsResponse.exception = null;
                        } catch (Exception e) {
                            mocaResultsResponse.results = null;
                            mocaResultsResponse.exception = e;
                        }
                    }

                    return CompletableFuture.completedFuture(new MocaTraceResponse(mocaResultsResponse));
                } catch (Exception exception) {
                    return CompletableFuture
                            .completedFuture(new MocaTraceResponse(new MocaResultsResponse(null, exception, false)));
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
                                MocaCache.getGlobalMocaCache().distinctCommands, null, null, null);
                    } else {
                        mocaCommandLookupResponse = new MocaCommandLookupResponse(null,
                                MocaCache.getGlobalMocaCache().commands
                                        .get(mocaCommandLookupRequest.requestedMocaCommand),
                                MocaCache.getGlobalMocaCache().triggers
                                        .get(mocaCommandLookupRequest.requestedMocaCommand),
                                null);
                    }

                    return CompletableFuture.completedFuture(mocaCommandLookupResponse);
                } catch (Exception exception) {
                    return CompletableFuture
                            .completedFuture(new MocaCommandLookupResponse(null, null, null, exception));
                }

            case SET_LANGUAGE_SERVER_OPTIONS:
                try {
                    List<Object> args = params.getArguments();

                    MocaLanguageServerOptionsRequest mocaLanguageServerOptionsRequest = new MocaLanguageServerOptionsRequest(
                            args);

                    MocaLanguageServer.mocaLanguageServerOptions = mocaLanguageServerOptionsRequest.mocaLanguageServerOptions;

                    return CompletableFuture.completedFuture(new Object());
                } catch (Exception exception) {
                    return CompletableFuture.completedFuture(new MocaLanguageServerOptionsResponse(exception));
                }

            case OPEN_TRACE:
                try {
                    List<Object> args = params.getArguments();

                    OpenMocaTraceRequest openMocaTraceRequest = new OpenMocaTraceRequest(args);

                    // If trace file name is not passed in, then we will send all trace file names.
                    // Otherwise, we will send the contents of the requested trace file.
                    OpenMocaTraceResponse openMocaTraceResponse;
                    if (openMocaTraceRequest.requestedTraceFileName == null) {

                        // Read file names from LESDIR/log/*.log
                        MocaResults res = MocaConnection.getGlobalMocaConnection().executeCommand(
                                "sl_get dir where path = '${LESDIR}/log/' and filter = '*.log' | get file info where pathname = '${LESDIR}/log/' || @file_name");
                        ArrayList<String> traceFileNames = new ArrayList<>(res.getRowCount());
                        for (int i = 0; i < res.getRowCount(); i++) {
                            if (res.getString(i, "type").compareToIgnoreCase("F") == 0) {
                                String pathName = res.getString(i, "pathname");
                                traceFileNames.add(pathName.substring(pathName.lastIndexOf("\\") + 1));
                            }
                        }
                        openMocaTraceResponse = new OpenMocaTraceResponse(traceFileNames, null, null);
                    } else {

                        // Read trace file requested.
                        MocaResults res = MocaConnection.getGlobalMocaConnection()
                                .executeCommand(String.format("read file where filnam = '${LESDIR}/log/%s'",
                                        openMocaTraceRequest.requestedTraceFileName));

                        StringBuilder contents = new StringBuilder(5096);
                        TraceOutliner traceOutliner = new TraceOutliner();

                        for (int i = 0; i < res.getRowCount(); i++) {
                            traceOutliner.readLine(i, res.getString(i, "text"), contents);
                        }

                        openMocaTraceResponse = new OpenMocaTraceResponse(null, contents.toString(), null);
                    }

                    return CompletableFuture.completedFuture(openMocaTraceResponse);
                } catch (Exception exception) {
                    return CompletableFuture.completedFuture(new OpenMocaTraceResponse(null, null, exception));
                }
            default:
                break;

        }

        return CompletableFuture.completedFuture(new Object());
    }

}