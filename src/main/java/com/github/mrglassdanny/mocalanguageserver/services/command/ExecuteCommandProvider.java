package com.github.mrglassdanny.mocalanguageserver.services.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.MocaLanguageServer;
import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaCSVResultsRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaCommandLookupRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaConnectionRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaLanguageServerActivateRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaLanguageServerOptionsRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaResultsRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.MocaTraceRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.request.OpenMocaTraceOutlineRequest;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.LoadCacheResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaCSVResultsResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaCommandLookupResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaConnectionResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaLanguageServerActivateResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaLanguageServerOptionsResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaResultsResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.MocaTraceResponse;
import com.github.mrglassdanny.mocalanguageserver.services.command.response.OpenMocaTraceOutlineResponse;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaResults;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.exceptions.MocaException;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutliningResult;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutliner;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.exceptions.InvalidMocaTraceFileException;
import com.opencsv.CSVWriter;

import org.eclipse.lsp4j.ExecuteCommandParams;

public class ExecuteCommandProvider {

    private static final String ERR_NOT_CONNECTED_TO_MOCA_SERVER = "Not connected to MOCA Server";

    public static final String ACTIVATE = "mocalanguageserver.activate";
    public static final String CONNECT = "mocalanguageserver.connect";
    public static final String LOAD_CACHE = "mocalanguageserver.loadCache";
    public static final String EXECUTE = "mocalanguageserver.execute";
    public static final String EXECUTE_TO_CSV = "mocalanguageserver.executeToCSV";
    public static final String TRACE = "mocalanguageserver.trace";
    public static final String OPEN_TRACE_OUTLINE = "mocalanguageserver.openTraceOutline";
    public static final String COMMAND_LOOKUP = "mocalanguageserver.commandLookup";
    public static final String SET_LANGUAGE_SERVER_OPTIONS = "mocalanguageserver.setLanguageServerOptions";

    public static ArrayList<String> mocaLanguageServerCommands = new ArrayList<>();
    static {
        mocaLanguageServerCommands.add(ACTIVATE);
        mocaLanguageServerCommands.add(CONNECT);
        mocaLanguageServerCommands.add(LOAD_CACHE);
        mocaLanguageServerCommands.add(EXECUTE);
        mocaLanguageServerCommands.add(EXECUTE_TO_CSV);
        mocaLanguageServerCommands.add(TRACE);
        mocaLanguageServerCommands.add(OPEN_TRACE_OUTLINE);
        mocaLanguageServerCommands.add(COMMAND_LOOKUP);
        mocaLanguageServerCommands.add(SET_LANGUAGE_SERVER_OPTIONS);
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
                        MocaServices.mocaConnection.connect(mocaConnectionRequest.url, mocaConnectionRequest.userId,
                                mocaConnectionRequest.password, mocaConnectionRequest.approveUnsafeScripts);
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
                if (!MocaServices.mocaConnection.isValid()) {
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
                    MocaServices.mocaCache.loadCommandArguments();
                    if (MocaServices.mocaCache.commandArguments.isEmpty()) {
                        MocaServices.mocaCache.loadCommandArguments();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaServices.mocaCache.loadTriggers();
                    if (MocaServices.mocaCache.triggers.isEmpty()) {
                        MocaServices.mocaCache.loadTriggers();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaServices.mocaCache.mocaSqlCache.loadTables();
                    if (MocaServices.mocaCache.mocaSqlCache.tables.isEmpty()) {
                        MocaServices.mocaCache.mocaSqlCache.loadTables();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaServices.mocaCache.mocaSqlCache.loadViews();
                    if (MocaServices.mocaCache.mocaSqlCache.views.isEmpty()) {
                        MocaServices.mocaCache.mocaSqlCache.loadViews();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaServices.mocaCache.mocaSqlCache.loadIndexes();
                    if (MocaServices.mocaCache.mocaSqlCache.indexes.isEmpty()) {
                        MocaServices.mocaCache.mocaSqlCache.loadIndexes();
                    }
                });

                CompletableFuture.runAsync(() -> {
                    MocaServices.mocaCache.mocaSqlCache.loadColumns();
                    if (MocaServices.mocaCache.mocaSqlCache.columns.isEmpty()) {
                        MocaServices.mocaCache.mocaSqlCache.loadColumns();
                    }
                });

                MocaServices.mocaCache.loadCommands();
                if (MocaServices.mocaCache.commands.isEmpty()) {
                    MocaServices.mocaCache.loadCommands();
                }

                return CompletableFuture.completedFuture(new LoadCacheResponse(null));
            case EXECUTE:

                if (!MocaServices.mocaConnection.isValid()) {
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

                    // If not approved for execution, check unsafe config/super user for connection.
                    if (!mocaResultsRequest.isApprovedForExecution) {
                        // If approval of unsafe scripts for connection is configured, check if script
                        // is unsafe.
                        if (MocaServices.mocaConnection.needToApproveUnsafeScripts()
                                || !MocaServices.mocaConnection.isSuperUser()) {

                            MocaCompilationResult mocaCompilationResult = MocaCompiler
                                    .compileScript(mocaResultsRequest.script);

                            if (mocaCompilationResult.isUnsafe()) {
                                MocaResultsResponse mocaResultsResponse = new MocaResultsResponse(null, null, true,
                                        MocaServices.mocaConnection.isSuperUser());
                                return CompletableFuture.completedFuture(mocaResultsResponse);
                            }
                        }
                    }

                    // Adding elapsed time console logging.
                    long start = System.currentTimeMillis();

                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse();
                    try {
                        mocaResultsResponse.results = MocaServices.mocaConnection
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
                                MocaServices.mocaConnection.connect(MocaServices.mocaConnection.getUrlStr(),
                                        MocaServices.mocaConnection.getUserId(),
                                        MocaServices.mocaConnection.getPassword(),
                                        MocaServices.mocaConnection.needToApproveUnsafeScripts());
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
                                    mocaResultsResponse.results = MocaServices.mocaConnection
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
            case EXECUTE_TO_CSV:

                if (!MocaServices.mocaConnection.isValid()) {
                    MocaCSVResultsResponse mocaCSVResultsResponse = new MocaCSVResultsResponse(
                            new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER), false);
                    return CompletableFuture.completedFuture(mocaCSVResultsResponse);
                }

                try {
                    List<Object> args = params.getArguments();
                    if (args == null) {
                        return CompletableFuture.completedFuture(new Object());
                    }

                    MocaCSVResultsRequest mocaCSVResultsRequest = new MocaCSVResultsRequest(args);

                    // If not approved for execution, check unsafe config for connection.
                    if (!mocaCSVResultsRequest.isApprovedForExecution) {
                        // If approval of unsafe scripts for connection is configured, check if script
                        // is unsafe.
                        if (MocaServices.mocaConnection.needToApproveUnsafeScripts()) {

                            MocaCompilationResult mocaCompilationResult = MocaCompiler
                                    .compileScript(mocaCSVResultsRequest.script);

                            if (mocaCompilationResult.isUnsafe()) {
                                MocaCSVResultsResponse mocaCSVResultsResponse = new MocaCSVResultsResponse(null, true);
                                return CompletableFuture.completedFuture(mocaCSVResultsResponse);
                            }
                        }
                    }

                    // Adding elapsed time console logging.
                    long start = System.currentTimeMillis();

                    MocaCSVResultsResponse mocaCSVResultsResponse = new MocaCSVResultsResponse();
                    MocaResults mocaResults = null;
                    try {
                        mocaResults = MocaServices.mocaConnection.executeCommand(mocaCSVResultsRequest.script);
                        mocaCSVResultsResponse.exception = null;
                        mocaCSVResultsResponse.needsApprovalToExecute = false;
                    } catch (Exception e) {
                        mocaCSVResultsResponse.exception = e;
                        mocaCSVResultsResponse.needsApprovalToExecute = false;
                    }

                    // Check to see if our connection timed out. We will know whether or not this is
                    // the case based on the error message in the mocaResultsResponse.
                    if (mocaCSVResultsResponse.exception != null
                            && mocaCSVResultsResponse.exception instanceof MocaException) {
                        MocaException resMocaException = (MocaException) mocaCSVResultsResponse.exception;

                        int curSts = resMocaException.getStatus();
                        if (curSts == 301 || curSts == 203 || curSts == 523) {
                            // If connection timed out, we need to quitely try to reconnect and rerun the
                            // script.
                            MocaConnectionResponse reconnectResponse = new MocaConnectionResponse();
                            try {
                                MocaServices.mocaConnection.connect(MocaServices.mocaConnection.getUrlStr(),
                                        MocaServices.mocaConnection.getUserId(),
                                        MocaServices.mocaConnection.getPassword(),
                                        MocaServices.mocaConnection.needToApproveUnsafeScripts());
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
                                mocaCSVResultsResponse.exception = reconnectResponse.exception;
                            } else {
                                try {
                                    mocaResults = MocaServices.mocaConnection
                                            .executeCommand(mocaCSVResultsRequest.script);
                                    mocaCSVResultsResponse.exception = null;
                                } catch (Exception e) {
                                    mocaCSVResultsResponse.exception = e;
                                }
                            }
                        }
                    }

                    // Only load csv if no exception.
                    if (mocaCSVResultsResponse.exception == null) {
                        CSVWriter writer = new CSVWriter(
                                new FileWriter(new File(mocaCSVResultsRequest.fullFileName + ".csv")));
                        writer.writeAll(mocaResults.toStringTable());
                        writer.close();
                    }

                    // End will be a bit skewed if we had to reconnect due to timeout... but oh well
                    // -- it shouldnt happen very often.
                    long end = System.currentTimeMillis();

                    // Elapsed time in terms of seconds.
                    double elapsedTime = ((double) (end - start) / 1000.0000);

                    int rowCount = 0;
                    if (mocaResults != null) {
                        rowCount = mocaResults.getRowCount();
                    }

                    MocaServices.logInfoToLanguageClient(String.format("%s: Returned %d rows in %.2f seconds",
                            mocaCSVResultsRequest.fileName, rowCount, elapsedTime));

                    return CompletableFuture.completedFuture(mocaCSVResultsResponse);
                } catch (Exception exception) {
                    MocaCSVResultsResponse mocaCSVResultsResponse = new MocaCSVResultsResponse(exception, false);
                    return CompletableFuture.completedFuture(mocaCSVResultsResponse);
                }

            case TRACE:

                if (!MocaServices.mocaConnection.isValid()) {
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

                    // Should be sending file name from client, but set as user ID just in case we
                    // do not.
                    if (mocaTraceRequest.fileName.isEmpty()) {
                        mocaTraceRequest.fileName = MocaServices.mocaConnection.getUserId();
                    }

                    MocaResultsResponse mocaResultsResponse = new MocaResultsResponse();
                    if (mocaTraceRequest.startTrace) {
                        try {
                            mocaResultsResponse.results = MocaServices.mocaConnection.executeCommand(String.format(
                                    "set trace where activate = 1 and filename = '%s.log' and trcmod = '%s'",
                                    mocaTraceRequest.fileName, mocaTraceRequest.mode));
                            mocaResultsResponse.exception = null;
                        } catch (Exception e) {
                            mocaResultsResponse.results = null;
                            mocaResultsResponse.exception = e;
                        }
                    } else {
                        try {
                            mocaResultsResponse.results = MocaServices.mocaConnection
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

            case OPEN_TRACE_OUTLINE:
                try {
                    List<Object> args = params.getArguments();

                    OpenMocaTraceOutlineRequest openMocaTraceOutlineRequest = new OpenMocaTraceOutlineRequest(args);

                    OpenMocaTraceOutlineResponse openMocaTraceOutlineResponse;

                    // If no requested trace file name, we can assume client wants list of remote
                    // trace files.

                    if (openMocaTraceOutlineRequest.requestedTraceFileName == null) {

                        // Before returning remote trace file names, make sure we have valid MOCA
                        // connection.
                        if (!MocaServices.mocaConnection.isValid()) {
                            return CompletableFuture.completedFuture(new OpenMocaTraceOutlineResponse(null, null,
                                    new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER)));
                        }

                        // Read file names from LESDIR/log/*.log
                        // A little over-complicated because we want to sort by modified date.
                        MocaResults res = MocaServices.mocaConnection.executeCommand(
                                "{ sl_get dir where path = '${LESDIR}/log/' and filter = '*.log' | get file info where pathname = '${LESDIR}/log/' || @file_name | publish data where file_name = @file_name and file_typ = @file_typ and modified = @modified } >> res | sort result set where result_set = @res and sort_list = 'modified desc'");

                        ArrayList<String> traceFileNames = new ArrayList<>(res.getRowCount());
                        // Should have dirs and files in result set -- let's make sure to only add files
                        // to the list.
                        for (int i = 0; i < res.getRowCount(); i++) {
                            if (res.getString(i, "file_typ").compareToIgnoreCase("FILE") == 0) {
                                String fileName = res.getString(i, "file_name");
                                traceFileNames.add(fileName);
                            }
                        }

                        openMocaTraceOutlineResponse = new OpenMocaTraceOutlineResponse(traceFileNames, null, null);
                    } else {

                        // Read remote or read local file.

                        if (openMocaTraceOutlineRequest.isRemote) {

                            // Before reading requested remote trace file, make sure we have valid MOCA
                            // connection.
                            if (!MocaServices.mocaConnection.isValid()) {
                                return CompletableFuture.completedFuture(new OpenMocaTraceOutlineResponse(null, null,
                                        new Exception(ERR_NOT_CONNECTED_TO_MOCA_SERVER)));
                            }

                            // Read trace file requested.
                            MocaResults res = MocaServices.mocaConnection
                                    .executeCommand(String.format("read file where filnam = '${LESDIR}/log/%s'",
                                            openMocaTraceOutlineRequest.requestedTraceFileName));

                            MocaTraceOutliningResult mocaTraceOutliningResult = MocaTraceOutliner.outlineTrace(
                                    openMocaTraceOutlineRequest.requestedTraceFileName,
                                    openMocaTraceOutlineRequest.options, res);

                            // Make sure string is not null.
                            String mocaTraceOutliningResultStr = mocaTraceOutliningResult.toString();
                            if (mocaTraceOutliningResultStr == null || mocaTraceOutliningResultStr.isEmpty()) {
                                throw new InvalidMocaTraceFileException("Trace Outline is empty");
                            }

                            // We have uriStr(map key); add to moca services map here.
                            MocaServices.mocaTraceOutliningResultMap.put(
                                    openMocaTraceOutlineRequest.createdTraceOutlineUriStr, mocaTraceOutliningResult);

                            openMocaTraceOutlineResponse = new OpenMocaTraceOutlineResponse(null,
                                    mocaTraceOutliningResultStr, null);
                        } else {

                            // Will have full URI from client.
                            File file = new File(URI.create(openMocaTraceOutlineRequest.requestedTraceFileName));

                            // Read file.
                            BufferedReader reader = new BufferedReader(new FileReader(file));

                            // Wrapping in try-catch-finally here since we need to cleanup io resources.
                            try {

                                // Make sure we shorten file name.
                                MocaTraceOutliningResult mocaTraceOutliningResult = MocaTraceOutliner.outlineTrace(
                                        openMocaTraceOutlineRequest.requestedTraceFileName.substring(
                                                openMocaTraceOutlineRequest.requestedTraceFileName.lastIndexOf("/")),
                                        openMocaTraceOutlineRequest.options, reader);

                                // Make sure string is not null.
                                String mocaTraceOutliningResultStr = mocaTraceOutliningResult.toString();
                                if (mocaTraceOutliningResultStr == null || mocaTraceOutliningResultStr.isEmpty()) {
                                    throw new InvalidMocaTraceFileException("Trace Outline is empty");
                                }

                                // We have uriStr(map key); add to moca services map here.
                                MocaServices.mocaTraceOutliningResultMap.put(
                                        openMocaTraceOutlineRequest.createdTraceOutlineUriStr,
                                        mocaTraceOutliningResult);

                                openMocaTraceOutlineResponse = new OpenMocaTraceOutlineResponse(null,
                                        mocaTraceOutliningResultStr, null);
                            } catch (Exception innerException) {
                                openMocaTraceOutlineResponse = new OpenMocaTraceOutlineResponse(null, null,
                                        innerException);
                            } finally {
                                reader.close();
                            }
                        }
                    }
                    return CompletableFuture.completedFuture(openMocaTraceOutlineResponse);
                } catch (Exception exception) {
                    return CompletableFuture.completedFuture(new OpenMocaTraceOutlineResponse(null, null, exception));
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
                                MocaServices.mocaCache.distinctCommands, null, null, null);
                    } else {
                        mocaCommandLookupResponse = new MocaCommandLookupResponse(null,
                                MocaServices.mocaCache.commands.get(mocaCommandLookupRequest.requestedMocaCommand),
                                MocaServices.mocaCache.triggers.get(mocaCommandLookupRequest.requestedMocaCommand),
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
            default:
                break;

        }

        return CompletableFuture.completedFuture(new Object());
    }

}