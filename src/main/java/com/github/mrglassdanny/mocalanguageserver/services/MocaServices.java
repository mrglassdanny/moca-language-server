package com.github.mrglassdanny.mocalanguageserver.services;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.services.highlight.SemanticHighlightingManager;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.services.completion.CompletionProvider;
import com.github.mrglassdanny.mocalanguageserver.services.definition.DefinitionProvider;
import com.github.mrglassdanny.mocalanguageserver.services.diagnostic.DiagnosticManager;
import com.github.mrglassdanny.mocalanguageserver.services.format.DocumentFormattingProvider;
import com.github.mrglassdanny.mocalanguageserver.services.format.DocumentOnTypeFormattingProvider;
import com.github.mrglassdanny.mocalanguageserver.services.command.ExecuteCommandProvider;
import com.github.mrglassdanny.mocalanguageserver.services.hover.HoverProvider;
import com.github.mrglassdanny.mocalanguageserver.services.signature.SignatureHelpProvider;
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

    public static LanguageClient languageClient = null;
    private static FileManager fileManager = new FileManager();

    // Diagnostics and semantic highlighting can be processed on different threads.
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    @Override
    public void connect(LanguageClient client) {
        MocaServices.languageClient = client;
    }

    @Override
    public void didOpen(DidOpenTextDocumentParams params) {
        MocaServices.fileManager.didOpen(params);
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        String script = MocaServices.fileManager.getContents(uri);
        MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

        // We do not need to sync things up -- we can just execute.
        MocaServices.threadPool.execute(() -> {
            DiagnosticManager.streamAll();
        });

        MocaServices.threadPool.execute(() -> {
            SemanticHighlightingManager.streamAll();
        });

    }

    @Override
    public void didChange(DidChangeTextDocumentParams params) {
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        // First make sure we are dealing with the same uri string as current
        // compilation result. We should be, but let's put this here to be safe!
        if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
            String script = MocaServices.fileManager.getContents(uri);
            MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

            DiagnosticManager.streamAll();
            SemanticHighlightingManager.streamAll();

            return;
        }

        // We do not want to needlessly compile the entire script everytime a change
        // occurs -- this yields bad performance, especially on larger scripts.
        // Therefore, we will instead attempt to figure out where the change to the file
        // occured and only compile the range that the change is in.

        // Before we process file manager changes, we need to extract the previous
        // contents.
        String prevScript = MocaServices.fileManager.getContents(uri);
        MocaServices.fileManager.didChange(params);

        // Now we need to get the new contents and compare.
        String script = MocaServices.fileManager.getContents(uri);

        // This will return the first indication of a difference. If 0, then there is no
        // change.
        // NOTE: this should work fine since we can assume that there cannot be more
        // than 1 'distinct' differences -- meaning that there cannot be a change at
        // index 5 -> 10 and also one at index 80 -> 90.
        int changeIdx = StringDifferenceUtils.indexOfDifference(prevScript, script);
        int changeLen = script.length() - prevScript.length(); // Could be negative number.

        if (changeIdx != 0) {
            MocaServices.mocaCompilationResult = MocaCompiler.compileScriptChanges(script, uriStr, changeIdx, changeLen,
                    MocaServices.mocaCompilationResult);

            // We do not need to sync things up -- we can just execute.
            MocaServices.threadPool.execute(() -> {
                DiagnosticManager.streamAll();
            });

            MocaServices.threadPool.execute(() -> {
                SemanticHighlightingManager.streamAll();
            });

        } else {
            MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

            // We do not need to sync things up -- we can just execute.
            MocaServices.threadPool.execute(() -> {
                DiagnosticManager.streamAll();
            });

            MocaServices.threadPool.execute(() -> {
                SemanticHighlightingManager.streamAll();
            });
        }
    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {
        MocaServices.fileManager.didClose(params);
        String uriStr = params.getTextDocument().getUri();

        // Need to clear diagnositics for file we just closed, that way the diagnostics
        // dont linger.
        DiagnosticManager.clearDiagnostics(uriStr);

    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        String script = MocaServices.fileManager.getContents(uri);
        MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);

        // We do not need to sync things up -- we can just execute.
        MocaServices.threadPool.execute(() -> {
            DiagnosticManager.streamAll();
        });

        MocaServices.threadPool.execute(() -> {
            SemanticHighlightingManager.streamAll();
        });
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

        // Need to compile on hover for the following reason:
        // When the user has 2 or more opened MOCA files and they make a change to file
        // A, then switch to file B, the MOCA server thinks user is still looking at
        // file A, since switching files does not trigger an event. This is not an issue
        // for anything other than on hover, since everything else requires the user to
        // make a change to the file. Therefore, we will add a compile here.
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        // Before we compile, check if uri string is the same as the current
        // moca compilation result's uri string.
        // If it is, then we do not need to worry about compiling!
        if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
            String script = MocaServices.fileManager.getContents(uri);
            MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
        }

        return HoverProvider.provideHover(params.getPosition());
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams params) {

        URI uri = URI.create(params.getTextDocument().getUri());
        TextDocumentIdentifier textDocument = params.getTextDocument();
        Position position = params.getPosition();

        // Perform preprocessing for each context before we go to provider.
        // Analyze context id for position.
        MocaLanguageContext mocaLanguageContext = MocaLanguageUtils.getMocaLanguageContextFromPosition(position,
                MocaServices.mocaCompilationResult);
        switch (mocaLanguageContext.id) {
            case Moca:
                return CompletionProvider.provideCompletion(position, mocaLanguageContext);
            case MocaSql:
                String originalSourceForMocaSql = null;

                if (PositionUtils.getCharacterAtPosition(MocaServices.mocaCompilationResult.script,
                        new Position(position.getLine(), position.getCharacter() - 1)) == '.') {

                    originalSourceForMocaSql = MocaServices.fileManager.getContents(uri);
                    VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                            textDocument.getUri(), 1);
                    TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(
                            new Range(position, position), 0, "a");
                    DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(versionedTextDocument,
                            Collections.singletonList(changeEvent));
                    // Like groovy below, if previous character is '.', then there is probably a
                    // syntax error. One of the ways mocasql completion requests are triggered is
                    // via '.'. This hack adds a placeholder value in hopes that the ast will
                    // properly get built during mocasql compilation. We will restore the original
                    // text after we are finished with this!
                    didChange(didChangeParams);
                }

                CompletableFuture<Either<List<CompletionItem>, CompletionList>> mocaSqlCompletionItems = null;
                try {
                    mocaSqlCompletionItems = CompletionProvider.provideCompletion(position, mocaLanguageContext);
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
                        .get(mocaLanguageContext.rangeIdx);

                Range groovyScriptRange = MocaServices.mocaCompilationResult.groovyRanges
                        .get(mocaLanguageContext.rangeIdx);

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                        position.getCharacter(), groovyScriptRange);
                if (offsetNode == null) {
                    originalSourceForGroovy = MocaServices.fileManager.getContents(uri);
                    VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                            textDocument.getUri(), 1);
                    TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(
                            new Range(position, position), 0, "a");
                    DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(versionedTextDocument,
                            Collections.singletonList(changeEvent));
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
                    groovyCompletionItems = CompletionProvider.provideCompletion(position, mocaLanguageContext);
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
        return CompletionProvider.provideCompletion(position, mocaLanguageContext);
    }

    @Override
    public CompletableFuture<SignatureHelp> signatureHelp(SignatureHelpParams params) {
        URI uri = URI.create(params.getTextDocument().getUri());
        TextDocumentIdentifier textDocument = params.getTextDocument();
        Position position = params.getPosition();

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
                        .get(mocaLanguageContext.rangeIdx);

                Range groovyScriptRange = MocaServices.mocaCompilationResult.groovyRanges
                        .get(mocaLanguageContext.rangeIdx);

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(
                        params.getPosition().getLine(), params.getPosition().getCharacter(), groovyScriptRange);
                if (offsetNode == null) {
                    originalSource = MocaServices.fileManager.getContents(uri);
                    VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                            textDocument.getUri(), 1);
                    int offset = PositionUtils.getOffset(originalSource, position);
                    String lineBeforeOffset = originalSource.substring(offset - position.getCharacter(), offset);
                    Matcher matcher = Pattern.compile(".*new \\w*$").matcher(lineBeforeOffset);
                    TextDocumentContentChangeEvent changeEvent = null;
                    if (matcher.matches()) {
                        changeEvent = new TextDocumentContentChangeEvent(new Range(position, position), 0, "a()");
                    } else {
                        changeEvent = new TextDocumentContentChangeEvent(new Range(position, position), 0, "a");
                    }
                    DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(versionedTextDocument,
                            Collections.singletonList(changeEvent));
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
                    return SignatureHelpProvider.provideSignatureHelp(params.getPosition(), mocaLanguageContext);
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
        return SignatureHelpProvider.provideSignatureHelp(params.getPosition(), mocaLanguageContext);
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> formatting(DocumentFormattingParams params) {

        // Need to compile script before we format.
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        // Before we compile, check if uri string is the same as the current
        // moca compilation result's uri string.
        // If it is, then we do not need to worry about compiling!
        if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
            String script = MocaServices.fileManager.getContents(uri);
            MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
        }

        return DocumentFormattingProvider.provideDocumentFormatting(params);
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> rangeFormatting(DocumentRangeFormattingParams params) {

        // Need to compile script before we format.
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        // Before we compile, check if uri string is the same as the current
        // moca compilation result's uri string.
        // If it is, then we do not need to worry about compiling!
        if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
            String script = MocaServices.fileManager.getContents(uri);
            MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
        }

        return DocumentFormattingProvider.provideDocumentRangeFormatting(params);
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> onTypeFormatting(DocumentOnTypeFormattingParams params) {

        // No need for a compile call -- we know that compilation is occuring on type
        // elsewhere.
        return DocumentOnTypeFormattingProvider.provideDocumentOnTypeFormatting(params);
    }

    @Override
    public CompletableFuture<Object> executeCommand(ExecuteCommandParams params) {

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

        // Need to compile on definition provide for the same reason as on hover ^.
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        // Before we compile, check if uri string is the same as the current
        // moca compilation result's uri string.
        // If it is, then we do not need to worry about compiling!
        if (uriStr.compareToIgnoreCase(MocaServices.mocaCompilationResult.uriStr) != 0) {
            String script = MocaServices.fileManager.getContents(uri);
            MocaServices.mocaCompilationResult = MocaCompiler.compileScript(script, uriStr);
        }

        return DefinitionProvider.provideDefinition(uri, params.getPosition());
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