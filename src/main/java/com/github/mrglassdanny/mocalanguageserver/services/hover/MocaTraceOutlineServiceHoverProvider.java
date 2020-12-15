package com.github.mrglassdanny.mocalanguageserver.services.hover;

import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceOutliningResult;
import com.github.mrglassdanny.mocalanguageserver.moca.trace.MocaTraceStackFrame;

import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.MarkupKind;
import org.eclipse.lsp4j.Position;

public class MocaTraceOutlineServiceHoverProvider {

    public static CompletableFuture<Hover> provideHover(String uriStr, Position position) {

        Hover hover = new Hover();

        // Placeholder contents until we set due to analysis.
        hover.setContents(new MarkupContent(MarkupKind.PLAINTEXT, "No data found"));

        MocaTraceOutliningResult mocaTraceOutliningResult = MocaServices.mocaTraceOutliningResultMap.get(uriStr);

        // Make sure we have a working trace outline result.
        if (mocaTraceOutliningResult == null) {
            return CompletableFuture.completedFuture(hover);
        }

        // +1 since lsp position lines start at 0!
        MocaTraceStackFrame frame = mocaTraceOutliningResult.actualLinesMap.get(position.getLine() + 1);
        if (frame == null) {
            return CompletableFuture.completedFuture(hover);
        }

        hover.setContents(new MarkupContent(MarkupKind.MARKDOWN, frame.getMarkdownStr()));

        return CompletableFuture.completedFuture(hover);
    }

}
