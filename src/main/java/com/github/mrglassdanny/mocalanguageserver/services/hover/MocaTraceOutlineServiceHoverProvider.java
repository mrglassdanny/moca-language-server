package com.github.mrglassdanny.mocalanguageserver.services.hover;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.PositionUtils;

import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.MarkupKind;
import org.eclipse.lsp4j.Position;

public class MocaTraceOutlineServiceHoverProvider {

    public static CompletableFuture<Hover> provideHover(Position position) {

        Hover hover = new Hover();
        // Placeholder contents until we set due to analysis.
        hover.setContents(new MarkupContent(MarkupKind.PLAINTEXT, "TEST: " + position.getLine()));

        // hover.setContents(new MarkupContent(MarkupKind.MARKDOWN,
        // mocaFunction.getMarkdownStr()));

        return CompletableFuture.completedFuture(hover);
    }

}
