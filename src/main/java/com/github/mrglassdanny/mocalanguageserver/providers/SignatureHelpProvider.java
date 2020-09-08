package com.github.mrglassdanny.mocalanguageserver.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaCompiler;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyNodeToStringUtils;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.MethodCall;
import org.eclipse.lsp4j.ParameterInformation;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureInformation;
import org.eclipse.lsp4j.TextDocumentIdentifier;

public class SignatureHelpProvider {

    public static CompletableFuture<SignatureHelp> provideSignatureHelp(TextDocumentIdentifier textDocument,
            Position position, MocaCompiler mocaCompiler) {

        // Analyze context id for position.
        MocaLanguageContext ctx = mocaCompiler.getMocaLanguageContextFromPosition(position);

        switch (ctx.id) {
            case Moca:
                // TODO - maybe for moca commands and their required args?
                break;
            case MocaSql:
                // Only thing we could do here would be functions...
                break;
            case Groovy:
                GroovyCompilationResult groovyCompilationResult = mocaCompiler.currentCompilationResult.groovyCompilationResults
                        .get(ctx.rangeIdx);

                Range groovyScriptRange = mocaCompiler.groovyRanges.get(ctx.rangeIdx);

                if (groovyCompilationResult.astVisitor == null) {
                    // this shouldn't happen, but let's avoid an exception if something
                    // goes terribly wrong.
                    return CompletableFuture.completedFuture(new SignatureHelp(Collections.emptyList(), -1, -1));

                }

                ASTNode offsetNode = groovyCompilationResult.astVisitor.getNodeAtLineAndColumn(position.getLine(),
                        position.getCharacter(), groovyScriptRange);
                if (offsetNode == null) {
                    return CompletableFuture.completedFuture(new SignatureHelp(Collections.emptyList(), -1, -1));
                }
                int activeParamIndex = -1;
                MethodCall methodCall = null;
                ASTNode parentNode = groovyCompilationResult.astVisitor.getParent(offsetNode);

                if (offsetNode instanceof ArgumentListExpression) {
                    methodCall = (MethodCall) parentNode;

                    ArgumentListExpression argsList = (ArgumentListExpression) offsetNode;
                    List<Expression> expressions = argsList.getExpressions();
                    activeParamIndex = getActiveParameter(position, expressions, groovyScriptRange);
                }

                if (methodCall == null) {
                    return CompletableFuture.completedFuture(new SignatureHelp(Collections.emptyList(), -1, -1));
                }

                List<MethodNode> methods = GroovyASTUtils.getMethodOverloadsFromCallExpression(methodCall,
                        groovyCompilationResult.astVisitor);
                if (methods.isEmpty()) {
                    return CompletableFuture.completedFuture(new SignatureHelp(Collections.emptyList(), -1, -1));
                }

                List<SignatureInformation> sigInfos = new ArrayList<>();
                for (MethodNode method : methods) {
                    List<ParameterInformation> parameters = new ArrayList<>();
                    Parameter[] methodParams = method.getParameters();
                    for (int i = 0; i < methodParams.length; i++) {
                        Parameter methodParam = methodParams[i];

                        ParameterInformation paramInfo = new ParameterInformation();
                        paramInfo.setLabel(GroovyNodeToStringUtils.variableToString(methodParam,
                                groovyCompilationResult.astVisitor));
                        parameters.add(paramInfo);
                    }
                    SignatureInformation sigInfo = new SignatureInformation();
                    sigInfo.setLabel(
                            GroovyNodeToStringUtils.methodToString(method, groovyCompilationResult.astVisitor));
                    sigInfo.setParameters(parameters);
                    sigInfos.add(sigInfo);
                }

                MethodNode bestMethod = GroovyASTUtils.getMethodFromCallExpression(methodCall,
                        groovyCompilationResult.astVisitor, activeParamIndex);
                int activeSignature = methods.indexOf(bestMethod);

                return CompletableFuture
                        .completedFuture(new SignatureHelp(sigInfos, activeSignature, activeParamIndex));
        }

        return CompletableFuture.completedFuture(new SignatureHelp(Collections.emptyList(), -1, -1));
    }

    // MOCA.

    // SQL.

    // GROOVY.
    private static int getActiveParameter(Position position, List<Expression> expressions, Range groovyScriptRange) {
        for (int i = 0; i < expressions.size(); i++) {
            Expression expr = expressions.get(i);
            Range exprRange = GroovyLanguageUtils.astNodeToRange(expr, groovyScriptRange);
            if (position.getLine() < exprRange.getEnd().getLine()) {
                return i;
            }
            if (position.getLine() == exprRange.getEnd().getLine()
                    && position.getCharacter() <= exprRange.getEnd().getCharacter()) {
                return i;
            }
        }
        return expressions.size();
    }

}