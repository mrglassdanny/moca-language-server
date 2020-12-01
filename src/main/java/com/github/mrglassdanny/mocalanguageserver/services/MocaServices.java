package com.github.mrglassdanny.mocalanguageserver.services;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.services.highlight.MocaCompilationServiceSemanticHighlightingManager;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutlineResult;
import com.github.mrglassdanny.mocalanguageserver.services.completion.MocaCompilationServiceCompletionProvider;
import com.github.mrglassdanny.mocalanguageserver.services.definition.MocaCompilationServiceDefinitionProvider;
import com.github.mrglassdanny.mocalanguageserver.services.definition.MocaTraceOutlineServiceDefinitionProvider;
import com.github.mrglassdanny.mocalanguageserver.services.diagnostic.MocaCompilationServiceDiagnosticManager;
import com.github.mrglassdanny.mocalanguageserver.services.format.MocaCompilationServiceDocumentFormattingProvider;
import com.github.mrglassdanny.mocalanguageserver.services.format.MocaCompilationServiceDocumentOnTypeFormattingProvider;
import com.github.mrglassdanny.mocalanguageserver.services.command.ExecuteCommandProvider;
import com.github.mrglassdanny.mocalanguageserver.services.hover.MocaCompilationServiceHoverProvider;
import com.github.mrglassdanny.mocalanguageserver.services.hover.MocaTraceOutlineServiceHoverProvider;
import com.github.mrglassdanny.mocalanguageserver.services.signature.MocaCompilationServiceSignatureHelpProvider;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.StringDifferenceUtils;

import org.codehaus.groovy.ast.ASTNode;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.DefinitionParams;
import org.eclipse.lsp4j.DidChangeConfigurationParams;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.HoverParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureHelpParams;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;

public class MocaServices implements TextDocumentService, WorkspaceService, LanguageClientAware {

    public static LanguageClient languageClient = null;
    private static FileManager fileManager = new FileManager();
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    // We are supporting multiple MOCA 'services'. We will use
    // MocaServiceType enum in order to invoke the correct logic for the requested
    // service.
    // Ex: File ext is .moca.trace -> MocaTraceOutlineService
    // Ex: File ext is .moca OR .msql -> MocaCompilationService
    private enum MocaServiceType {
        MocaCompilation, MocaTraceOutline
    }

    private static MocaServiceType getMocaServiceType(String uriStr) {
        String uriExt = uriStr.substring(uriStr.lastIndexOf("."), uriStr.length());
        if (uriExt.compareToIgnoreCase(".trace") == 0) {
            return MocaServiceType.MocaTraceOutline;
        }

        return MocaServiceType.MocaCompilation;
    }

    // MOCA COMPILATION SERVICE:
    // Will only ever have 1 current moca compilation result. Reason being is that
    // moca scripts/files are independent of eachother, and there is no need to keep
    // track of any compilation results other than the current one for the moca
    // script/file that the user is focused on. The only caveat to this is when
    // dealing with semantic highlighting and diagnostics. However, we account for
    // this simply by not clearing existing highlights/diagnostics when the user
    // sets focus on another file. These existing highlights/diagnostics will not be
    // invalidated since the file will not be changed if the user is not focusing on
    // it. Once the file is focused on and a compile event like change is triggered,
    // we compile the file and everything is how it should be.
    // Since we know that we will always just have 1 of these, and it will either be
    // initialized or null, we will just reference this in all of our services that
    // may need it or it's components.
    public static MocaCompilationResult mocaCompilationResult = null;

    // MOCA TRACE OUTLINE SERVICE:
    // Trace outline results will be treated differently than compilation results --
    // once we perform outlining logic for moca trace, it will not change(unless
    // outlining services are requested again). Therefore, we need to keep track of
    // existing trace outlines since we cannot simply 'recompile' on changed focus.
    private static HashMap<String, MocaTraceOutlineResult> mocaTraceOutlineResultMap = new HashMap<>(); // Key is uri
                                                                                                        // string.
    // To make things easier for callers, we will expose the 'focused' moca trace
    // outline result.
    public static MocaTraceOutlineResult mocaTraceOutlineResult = null;

    @Override
    public void connect(LanguageClient client) {
        MocaServices.languageClient = client;
    }

    @Override
    public void didOpen(DidOpenTextDocumentParams params) {
        MocaServices.fileManager.didOpen(params);
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                // Check if exists in our map.
                if (MocaServices.mocaTraceOutlineResultMap.containsKey(uriStr)) {
                    MocaServices.mocaTraceOutlineResult = MocaServices.mocaTraceOutlineResultMap.get(uriStr);
                } else {
                    // Can assume we are here for 1 of 2 reasons:
                    // 1. Execute command provider loaded trace outline result
                    // 2. vscode was reopened and this file was left open during last vscode close.
                    // This should handle both ^^^ since we want invalidated trace outline
                    // results to be null.
                    MocaServices.mocaTraceOutlineResultMap.put(uriStr, MocaServices.mocaTraceOutlineResult);
                }
                break;
            default:
                String script = MocaServices.fileManager.getContents(uri);
                MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

                // Diagnostics and semantic highlights can be done on seperate threads and can
                // finish independently of this function.
                MocaServices.threadPool.execute(() -> {
                    MocaCompilationServiceDiagnosticManager.streamAll();
                });
                MocaServices.threadPool.execute(() -> {
                    MocaCompilationServiceSemanticHighlightingManager.streamAll();
                });
                break;
        }

    }

    @Override
    public void didChange(DidChangeTextDocumentParams params) {
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                // Nothing to do here.
                break;
            default:
                // We do not want to needlessly compile the entire script everytime a change
                // occurs -- this yields bad performance, especially on larger scripts.
                // Therefore, we will instead attempt to figure out where the change to the file
                // occured and only compile the range that the change is in.

                // Before we process file manager changes, we need to extract the previous
                // contents.
                String prevScript = MocaServices.fileManager.getContents(uri);
                MocaServices.fileManager.didChange(params);

                // Real quick, let's make sure we are dealing with the same uri string as
                // current compilation result. We should be, but let's put this here to be safe!
                if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
                    String script = MocaServices.fileManager.getContents(uri);
                    MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

                    // Diagnostics and semantic highlights can be done on seperate threads and can
                    // finish independently of this function.
                    MocaServices.threadPool.execute(() -> {
                        MocaCompilationServiceDiagnosticManager.streamAll();
                    });
                    MocaServices.threadPool.execute(() -> {
                        MocaCompilationServiceSemanticHighlightingManager.streamAll();
                    });

                    return;
                }

                // Now we need to get the new contents and compare.
                String script = MocaServices.fileManager.getContents(uri);

                // This will return the first indication of a difference. If 0, then there is no
                // change.
                // NOTE: this should work fine since we can assume that there cannot be more
                // than 1 'distinct' differences -- meaning that there cannot be a change at
                // index 5 -> 10 and also one at index 80 -> 90 at the same time.
                int changeIdx = StringDifferenceUtils.indexOfDifference(prevScript, script);
                int changeLen = script.length() - prevScript.length(); // Could be negative number.

                if (changeIdx != 0) {
                    MocaServices.mocaCompilationResult = MocaCompiler.compileScriptChanges(script, uriStr, changeIdx,
                            changeLen, MocaServices.mocaCompilationResult);

                    // Diagnostics and semantic highlights can be done on seperate threads and can
                    // finish independently of this function.
                    MocaServices.threadPool.execute(() -> {
                        MocaCompilationServiceDiagnosticManager.streamAll();
                    });
                    MocaServices.threadPool.execute(() -> {
                        MocaCompilationServiceSemanticHighlightingManager.streamAll();
                    });

                } else {
                    MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

                    // Diagnostics and semantic highlights can be done on seperate threads and can
                    // finish independently of this function.
                    MocaServices.threadPool.execute(() -> {
                        MocaCompilationServiceDiagnosticManager.streamAll();
                    });
                    MocaServices.threadPool.execute(() -> {
                        MocaCompilationServiceSemanticHighlightingManager.streamAll();
                    });
                }
                break;
        }

    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {
        MocaServices.fileManager.didClose(params);
        String uriStr = params.getTextDocument().getUri();

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                // Just need to remove trace outline result from map.
                MocaServices.mocaTraceOutlineResultMap.remove(uriStr);
                break;
            default:
                // Need to clear diagnositics for file we just closed, that way the diagnostics
                // dont linger.
                MocaCompilationServiceDiagnosticManager.clearDiagnostics(uriStr);
                break;
        }

    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                // Nothing to do here.
                break;
            default:
                String script = MocaServices.fileManager.getContents(uri);
                MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

                // Diagnostics and semantic highlights can be done on seperate threads and can
                // finish independently of this function.
                MocaServices.threadPool.execute(() -> {
                    MocaCompilationServiceDiagnosticManager.streamAll();
                });
                MocaServices.threadPool.execute(() -> {
                    MocaCompilationServiceSemanticHighlightingManager.streamAll();
                });
                break;
        }

    }

    @Override
    public void didChangeWatchedFiles(DidChangeWatchedFilesParams params) {
        // Not doing anything..

    }

    @Override
    public void didChangeConfiguration(DidChangeConfigurationParams didChangeConfigurationParams) {
        // Not doing anything..
    }

    @Override
    public CompletableFuture<Hover> hover(HoverParams params) {

        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                // Check if exists in our map.
                if (MocaServices.mocaTraceOutlineResultMap.containsKey(uriStr)) {
                    MocaServices.mocaTraceOutlineResult = MocaServices.mocaTraceOutlineResultMap.get(uriStr);
                } else {
                    // Can assume we are here for 1 of 2 reasons:
                    // 1. Execute command provider loaded trace outline result
                    // 2. vscode was reopened and this file was left open during last vscode close.
                    // This should handle both ^^^ since we want invalidated trace outline
                    // results to be null.
                    MocaServices.mocaTraceOutlineResultMap.put(uriStr, MocaServices.mocaTraceOutlineResult);
                }
                return MocaTraceOutlineServiceHoverProvider.provideHover(params.getPosition());
            default:
                // Need to compile on hover for the following reason:
                // When the user has 2 or more opened MOCA files and they make a change to file
                // A, then switch to file B, the MOCA server thinks user is still looking at
                // file A, since switching files does not trigger an event. This is not an issue
                // for anything other than on hover, since everything else requires the user to
                // make a change to the file. Therefore, we will add a compile here.

                // Before we compile, check if uri string is the same as the current
                // moca compilation result's uri string.
                // If it is, then we do not need to worry about compiling!
                if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
                    String script = MocaServices.fileManager.getContents(uri);
                    MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
                }

                return MocaCompilationServiceHoverProvider.provideHover(params.getPosition());
        }

    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams params) {

        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(params.getTextDocument().getUri());
        TextDocumentIdentifier textDocument = params.getTextDocument();
        Position position = params.getPosition();

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                return CompletableFuture.completedFuture(Either.forLeft(Collections.emptyList()));
            default:
                // Perform preprocessing for each context before we go to provider.
                // Analyze context id for position.
                MocaLanguageContext mocaLanguageContext = MocaLanguageUtils.getMocaLanguageContextFromPosition(position,
                        MocaServices.mocaCompilationResult);
                switch (mocaLanguageContext.id) {
                    case Moca:
                        return MocaCompilationServiceCompletionProvider.provideCompletion(position,
                                mocaLanguageContext);
                    case MocaSql:
                        String originalSourceForMocaSql = null;

                        if (PositionUtils.getCharacterAtPosition(MocaServices.mocaCompilationResult.script,
                                new Position(position.getLine(), position.getCharacter() - 1)) == '.') {

                            originalSourceForMocaSql = MocaServices.fileManager.getContents(uri);
                            VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                                    textDocument.getUri(), 1);
                            TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(
                                    new Range(position, position), 0, "a");
                            DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(
                                    versionedTextDocument, Collections.singletonList(changeEvent));
                            // Like groovy below, if previous character is '.', then there is probably a
                            // syntax error. One of the ways mocasql completion requests are triggered is
                            // via '.'. This hack adds a placeholder value in hopes that the ast will
                            // properly get built during mocasql compilation. We will restore the original
                            // text after we are finished with this!
                            didChange(didChangeParams);
                        }

                        CompletableFuture<Either<List<CompletionItem>, CompletionList>> mocaSqlCompletionItems = null;
                        try {
                            mocaSqlCompletionItems = MocaCompilationServiceCompletionProvider
                                    .provideCompletion(position, mocaLanguageContext);
                        } finally {
                            if (originalSourceForMocaSql != null) {
                                VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                                        textDocument.getUri(), 1);
                                TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(null, 0,
                                        originalSourceForMocaSql);
                                DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(
                                        versionedTextDocument, Collections.singletonList(changeEvent));
                                this.didChange(didChangeParams);
                            }

                        }
                        return mocaSqlCompletionItems;
                    case Groovy:
                        String originalSourceForGroovy = null;
                        GroovyCompilationResult groovyCompilationResult = MocaServices.mocaCompilationResult.groovyCompilationResults
                                .get(mocaLanguageContext.compilationResultIdx);

                        ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(
                                position.getLine(), position.getCharacter(), groovyCompilationResult.range);
                        if (offsetNode == null) {
                            originalSourceForGroovy = MocaServices.fileManager.getContents(uri);
                            VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                                    textDocument.getUri(), 1);
                            TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(
                                    new Range(position, position), 0, "a");
                            DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(
                                    versionedTextDocument, Collections.singletonList(changeEvent));
                            // if the offset node is null, there is probably a syntax error.
                            // a completion request is usually triggered by the . character, and
                            // if there is no property name after the dot, it will cause a syntax
                            // error.
                            // this hack adds a placeholder property name in the hopes that it
                            // will correctly create a PropertyExpression to use for completion.
                            // we'll restore the original text after we're done handling the
                            // completion request.
                            didChange(didChangeParams);
                        }

                        CompletableFuture<Either<List<CompletionItem>, CompletionList>> groovyCompletionItems = null;
                        try {
                            groovyCompletionItems = MocaCompilationServiceCompletionProvider.provideCompletion(position,
                                    mocaLanguageContext);
                        } finally {
                            if (originalSourceForGroovy != null) {
                                VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                                        textDocument.getUri(), 1);
                                TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(null, 0,
                                        originalSourceForGroovy);
                                DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(
                                        versionedTextDocument, Collections.singletonList(changeEvent));
                                this.didChange(didChangeParams);
                            }
                        }
                        return groovyCompletionItems;
                }

                // Shouldnt get here, but just in case we get here.
                return MocaCompilationServiceCompletionProvider.provideCompletion(position, mocaLanguageContext);
        }

    }

    @Override
    public CompletableFuture<SignatureHelp> signatureHelp(SignatureHelpParams params) {

        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(params.getTextDocument().getUri());
        TextDocumentIdentifier textDocument = params.getTextDocument();
        Position position = params.getPosition();

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                return CompletableFuture.completedFuture(new SignatureHelp(Collections.emptyList(), -1, -1));
            default:
                // Perform preprocessing for each context before we go to provider.
                // Analyze context id for position.
                MocaLanguageContext mocaLanguageContext = MocaLanguageUtils.getMocaLanguageContextFromPosition(position,
                        MocaServices.mocaCompilationResult);
                switch (mocaLanguageContext.id) {
                    case Moca:
                        break;
                    case MocaSql:
                        break;
                    case Groovy:
                        String originalSource = null;
                        GroovyCompilationResult groovyCompilationResult = MocaServices.mocaCompilationResult.groovyCompilationResults
                                .get(mocaLanguageContext.compilationResultIdx);

                        ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(
                                params.getPosition().getLine(), params.getPosition().getCharacter(),
                                groovyCompilationResult.range);
                        if (offsetNode == null) {
                            originalSource = MocaServices.fileManager.getContents(uri);
                            VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                                    textDocument.getUri(), 1);
                            int offset = PositionUtils.getOffset(originalSource, position);
                            String lineBeforeOffset = originalSource.substring(offset - position.getCharacter(),
                                    offset);
                            Matcher matcher = Pattern.compile(".*new \\w*$").matcher(lineBeforeOffset);
                            TextDocumentContentChangeEvent changeEvent = null;
                            if (matcher.matches()) {
                                changeEvent = new TextDocumentContentChangeEvent(new Range(position, position), 0,
                                        "a()");
                            } else {
                                changeEvent = new TextDocumentContentChangeEvent(new Range(position, position), 0, "a");
                            }
                            DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(
                                    versionedTextDocument, Collections.singletonList(changeEvent));
                            // if the offset node is null, there is probably a syntax error.
                            // a completion request is usually triggered by the . character, and
                            // if there is no property name after the dot, it will cause a syntax
                            // error.
                            // this hack adds a placeholder property name in the hopes that it
                            // will correctly create a PropertyExpression to use for completion.
                            // we'll restore the original text after we're done handling the
                            // completion request.
                            didChange(didChangeParams);
                        }

                        try {
                            return MocaCompilationServiceSignatureHelpProvider
                                    .provideSignatureHelp(params.getPosition(), mocaLanguageContext);
                        } finally {
                            if (originalSource != null) {
                                VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                                        textDocument.getUri(), 1);
                                TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(null, 0,
                                        originalSource);
                                DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(
                                        versionedTextDocument, Collections.singletonList(changeEvent));
                                didChange(didChangeParams);
                            }
                        }
                }

                // Now provide signature help.
                return MocaCompilationServiceSignatureHelpProvider.provideSignatureHelp(params.getPosition(),
                        mocaLanguageContext);
        }

    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> formatting(DocumentFormattingParams params) {

        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                return CompletableFuture.completedFuture(Collections.emptyList());
            default:
                // Need to compile script before we format.

                // Before we compile, check if uri string is the same as the current
                // moca compilation result's uri string.
                // If it is, then we do not need to worry about compiling!
                if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
                    String script = MocaServices.fileManager.getContents(uri);
                    MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
                }

                return MocaCompilationServiceDocumentFormattingProvider.provideDocumentFormatting(params);
        }
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> rangeFormatting(DocumentRangeFormattingParams params) {

        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                return CompletableFuture.completedFuture(Collections.emptyList());
            default:
                // Need to compile script before we format.

                // Before we compile, check if uri string is the same as the current
                // moca compilation result's uri string.
                // If it is, then we do not need to worry about compiling!
                if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
                    String script = MocaServices.fileManager.getContents(uri);
                    MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
                }

                return MocaCompilationServiceDocumentFormattingProvider.provideDocumentRangeFormatting(params);
        }
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> onTypeFormatting(DocumentOnTypeFormattingParams params) {

        String uriStr = params.getTextDocument().getUri();

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                return CompletableFuture.completedFuture(Collections.emptyList());
            default:
                // No need for a compile call -- we know that compilation is occuring on type
                // elsewhere.
                return MocaCompilationServiceDocumentOnTypeFormattingProvider.provideDocumentOnTypeFormatting(params);
        }
    }

    @Override
    public CompletableFuture<Object> executeCommand(ExecuteCommandParams params) {

        // No need to getMocaServiceType here.

        // Check if we need to run async.
        switch (params.getCommand()) {
            case ExecuteCommandProvider.CONNECT:
            case ExecuteCommandProvider.LOAD_CACHE:
            case ExecuteCommandProvider.EXECUTE:
                return CompletableFuture.supplyAsync(() -> {
                    return ExecuteCommandProvider.provideCommandExecution(params).join();
                });
            default:
                return ExecuteCommandProvider.provideCommandExecution(params);
        }
    }

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(
            DefinitionParams params) {

        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        switch (getMocaServiceType(uriStr)) {
            case MocaTraceOutline:
                // Check if exists in our map.
                if (MocaServices.mocaTraceOutlineResultMap.containsKey(uriStr)) {
                    MocaServices.mocaTraceOutlineResult = MocaServices.mocaTraceOutlineResultMap.get(uriStr);
                } else {
                    // Can assume we are here for 1 of 2 reasons:
                    // 1. Execute command provider loaded trace outline result
                    // 2. vscode was reopened and this file was left open during last vscode close.
                    // This should handle both ^^^ since we want invalidated trace outline
                    // results to be null.
                    MocaServices.mocaTraceOutlineResultMap.put(uriStr, MocaServices.mocaTraceOutlineResult);
                }
                return MocaTraceOutlineServiceDefinitionProvider.provideDefinition(uri, params.getPosition());
            default:
                // Need to compile on definition provide for the same reason as on hover.

                // Before we compile, check if uri string is the same as the current
                // moca compilation result's uri string.
                // If it is, then we do not need to worry about compiling!
                if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
                    String script = MocaServices.fileManager.getContents(uri);
                    MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
                }

                return MocaCompilationServiceDefinitionProvider.provideDefinition(uri, params.getPosition());
        }
    }

    public static void logToLanguageClient(String msg) {
        if (MocaServices.languageClient != null) {
            MocaServices.languageClient.logMessage(new MessageParams(MessageType.Log, msg));
        }
    }

    public static void logErrorToLanguageClient(String msg) {
        if (MocaServices.languageClient != null) {
            MocaServices.languageClient.logMessage(new MessageParams(MessageType.Error, msg));
        }
    }

    public static void logWarningToLanguageClient(String msg) {
        if (MocaServices.languageClient != null) {
            MocaServices.languageClient.logMessage(new MessageParams(MessageType.Warning, msg));
        }
    }

    public static void logInfoToLanguageClient(String msg) {
        if (MocaServices.languageClient != null) {
            MocaServices.languageClient.logMessage(new MessageParams(MessageType.Info, msg));
        }
    }
}