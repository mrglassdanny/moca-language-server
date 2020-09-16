package com.github.mrglassdanny.mocalanguageserver;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.mrglassdanny.mocalanguageserver.managers.DiagnosticManager;
import com.github.mrglassdanny.mocalanguageserver.managers.SemanticHighlightingManager;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.providers.CompletionProvider;
import com.github.mrglassdanny.mocalanguageserver.providers.DefinitionProvider;
import com.github.mrglassdanny.mocalanguageserver.providers.DocumentFormattingProvider;
import com.github.mrglassdanny.mocalanguageserver.providers.DocumentOnTypeFormattingProvider;
import com.github.mrglassdanny.mocalanguageserver.providers.ExecuteCommandProvider;
import com.github.mrglassdanny.mocalanguageserver.providers.HoverProvider;
import com.github.mrglassdanny.mocalanguageserver.providers.SignatureHelpProvider;
import com.github.mrglassdanny.mocalanguageserver.util.file.FileManager;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;

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

    private LanguageClient languageClient;
    private FileManager fileManager;
    private MocaCompiler mocaCompiler;

    public MocaServices() {
        this.fileManager = new FileManager();
        this.mocaCompiler = new MocaCompiler();
    }

    @Override
    public void connect(LanguageClient client) {
        this.languageClient = client;
    }

    @Override
    public void didOpen(DidOpenTextDocumentParams params) {
        this.fileManager.didOpen(params);
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        String script = this.fileManager.getContents(uri);
        this.mocaCompiler.compileScript(script);

        DiagnosticManager.streamAll(this.languageClient, uriStr, script, this.mocaCompiler);

        SemanticHighlightingManager.streamAll(this.languageClient, uriStr, script, this.mocaCompiler);
    }

    @Override
    public void didChange(DidChangeTextDocumentParams params) {
        this.fileManager.didChange(params);
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        String script = this.fileManager.getContents(uri);
        this.mocaCompiler.compileScript(script);

        DiagnosticManager.streamAll(this.languageClient, uriStr, script, this.mocaCompiler);

        SemanticHighlightingManager.streamAll(this.languageClient, uriStr, script, this.mocaCompiler);
    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {
        this.fileManager.didClose(params);
        String uriStr = params.getTextDocument().getUri();

        // Need to clear diagnositics for file we just closed, that way the diagnostics
        // dont linger.
        DiagnosticManager.clearDiagnostics(this.languageClient, uriStr);

    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);

        String script = this.fileManager.getContents(uri);
        this.mocaCompiler.compileScript(script);

        DiagnosticManager.streamAll(this.languageClient, uriStr, script, this.mocaCompiler);

        SemanticHighlightingManager.streamAll(this.languageClient, uriStr, script, this.mocaCompiler);
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
        String script = this.fileManager.getContents(uri);
        this.mocaCompiler.compileScript(script);

        return HoverProvider.provideHover(params.getTextDocument(), params.getPosition(),
                this.fileManager.getContents(uri), this.mocaCompiler);
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams params) {

        URI uri = URI.create(params.getTextDocument().getUri());
        TextDocumentIdentifier textDocument = params.getTextDocument();
        Position position = params.getPosition();

        // Perform preprocessing for each context before we go to provider.
        // Analyze context id for position.
        MocaLanguageContext mocaLanguageContext = this.mocaCompiler.getMocaLanguageContextFromPosition(position);
        switch (mocaLanguageContext.id) {
            case Moca:
                return CompletionProvider.provideCompletion(params.getTextDocument(), params.getPosition(),
                        this.fileManager.getContents(URI.create(params.getTextDocument().getUri())),
                        params.getContext(), this.mocaCompiler, mocaLanguageContext);
            case MocaSql:
                return CompletionProvider.provideCompletion(params.getTextDocument(), params.getPosition(),
                        this.fileManager.getContents(URI.create(params.getTextDocument().getUri())),
                        params.getContext(), this.mocaCompiler, mocaLanguageContext);
            case Groovy:
                String originalSource = null;
                GroovyCompilationResult groovyCompilationResult = this.mocaCompiler.currentCompilationResult.groovyCompilationResults
                        .get(mocaLanguageContext.rangeIdx);

                Range groovyScriptRange = this.mocaCompiler.groovyRanges.get(mocaLanguageContext.rangeIdx);

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(
                        params.getPosition().getLine(), params.getPosition().getCharacter(), groovyScriptRange);
                if (offsetNode == null) {
                    originalSource = this.fileManager.getContents(uri);
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

                CompletableFuture<Either<List<CompletionItem>, CompletionList>> completionItems = null;
                try {
                    completionItems = CompletionProvider.provideCompletion(params.getTextDocument(),
                            params.getPosition(),
                            this.fileManager.getContents(URI.create(params.getTextDocument().getUri())),
                            params.getContext(), this.mocaCompiler, mocaLanguageContext);
                } finally {
                    if (originalSource != null) {
                        VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                                textDocument.getUri(), 1);
                        TextDocumentContentChangeEvent changeEvent = new TextDocumentContentChangeEvent(null, 0,
                                originalSource);
                        DidChangeTextDocumentParams didChangeParams = new DidChangeTextDocumentParams(
                                versionedTextDocument, Collections.singletonList(changeEvent));
                        this.didChange(didChangeParams);
                    }
                }
                return completionItems;
        }

        // Shouldnt get here, but just in case we get here.
        return CompletionProvider.provideCompletion(params.getTextDocument(), params.getPosition(),
                this.fileManager.getContents(URI.create(params.getTextDocument().getUri())), params.getContext(),
                this.mocaCompiler, mocaLanguageContext);
    }

    @Override
    public CompletableFuture<SignatureHelp> signatureHelp(SignatureHelpParams params) {
        URI uri = URI.create(params.getTextDocument().getUri());
        TextDocumentIdentifier textDocument = params.getTextDocument();
        String textDocumentContents = this.fileManager.getContents(uri);
        Position position = params.getPosition();

        // Perform preprocessing for each context before we go to provider.
        // Analyze context id for position.
        MocaLanguageContext mocaLanguageContext = this.mocaCompiler.getMocaLanguageContextFromPosition(position);
        switch (mocaLanguageContext.id) {
            case Moca:
                break;
            case MocaSql:
                break;
            case Groovy:
                String originalSource = null;
                GroovyCompilationResult groovyCompilationResult = this.mocaCompiler.currentCompilationResult.groovyCompilationResults
                        .get(mocaLanguageContext.rangeIdx);

                Range groovyScriptRange = this.mocaCompiler.groovyRanges.get(mocaLanguageContext.rangeIdx);

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(
                        params.getPosition().getLine(), params.getPosition().getCharacter(), groovyScriptRange);
                if (offsetNode == null) {
                    originalSource = this.fileManager.getContents(uri);
                    VersionedTextDocumentIdentifier versionedTextDocument = new VersionedTextDocumentIdentifier(
                            textDocument.getUri(), 1);
                    int offset = Positions.getOffset(originalSource, position);
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
                    return SignatureHelpProvider.provideSignatureHelp(params.getTextDocument(), textDocumentContents,
                            params.getPosition(), this.mocaCompiler, mocaLanguageContext);
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
        return SignatureHelpProvider.provideSignatureHelp(params.getTextDocument(), textDocumentContents,
                params.getPosition(), this.mocaCompiler, mocaLanguageContext);
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> formatting(DocumentFormattingParams params) {

        // Need to compile script before we format.
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);
        String script = this.fileManager.getContents(uri);
        this.mocaCompiler.compileScript(script);

        return DocumentFormattingProvider.provideDocumentFormatting(params, script, this.mocaCompiler);
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> rangeFormatting(DocumentRangeFormattingParams params) {

        // Need to compile script before we format.
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);
        String script = this.fileManager.getContents(uri);
        this.mocaCompiler.compileScript(script);

        return DocumentFormattingProvider.provideDocumentRangeFormatting(params, script, this.mocaCompiler);
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> onTypeFormatting(DocumentOnTypeFormattingParams params) {

        // No need to compile prior to calling formatting on type func. We know that
        // will each change to file, we are compiling.
        return DocumentOnTypeFormattingProvider.provideDocumentOnTypeFormatting(params,
                this.fileManager.getContents(URI.create(params.getTextDocument().getUri())), this.mocaCompiler);
    }

    @Override
    public CompletableFuture<Object> executeCommand(ExecuteCommandParams params) {

        // Check if we need to run async.
        switch (params.getCommand()) {
            case ExecuteCommandProvider.CONNECT:
            case ExecuteCommandProvider.LOAD_CACHE:
            case ExecuteCommandProvider.EXECUTE:
                return CompletableFuture.supplyAsync(() -> {
                    return ExecuteCommandProvider.provideCommandExecution(params, this.languageClient).join();
                });
            default:
                return ExecuteCommandProvider.provideCommandExecution(params, this.languageClient);
        }
    }

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(
            DefinitionParams params) {

        // Need to compile on definition provide for the same reason as on hover ^.
        String uriStr = params.getTextDocument().getUri();
        URI uri = URI.create(uriStr);
        String script = this.fileManager.getContents(uri);
        this.mocaCompiler.compileScript(script);

        return DefinitionProvider.provideDefinition(params.getTextDocument(), params.getPosition(),
                this.fileManager.getContents(uri), this.mocaCompiler);
    }
}