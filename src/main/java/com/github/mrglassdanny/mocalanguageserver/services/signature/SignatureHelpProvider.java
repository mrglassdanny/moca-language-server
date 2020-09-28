package com.github.mrglassdanny.mocalanguageserver.services.signature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.services.MocaServices;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaCache;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.MocaFunction;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.MocaLanguageContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr.MocaParser.Function_exprContext;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.GroovyCompilationResult;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyASTUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util.GroovyNodeToStringUtils;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.util.MocaLanguageUtils;

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

public class SignatureHelpProvider {

    public static CompletableFuture<SignatureHelp> provideSignatureHelp(Position position,
            MocaLanguageContext mocaLanguageContext) {

        switch (mocaLanguageContext.id) {
            case Moca:
                // Looking for moca functions.

                org.antlr.v4.runtime.Token curMocaToken = MocaLanguageUtils.getMocaTokenAtPosition(position,
                        MocaServices.mocaCompilationResult);

                if (curMocaToken != null) {

                    // Now let's see if token exists in our moca functions list.
                    // One way we can check is by seeing if current moca token is between start and
                    // stop tokens of function expression.
                    for (Function_exprContext mocaFuncExpr : MocaServices.mocaCompilationResult.mocaParseTreeListener.functions) {
                        org.antlr.v4.runtime.Token startFuncToken = mocaFuncExpr.getStart();
                        org.antlr.v4.runtime.Token stopFuncToken = mocaFuncExpr.getStop();

                        if (startFuncToken.getStartIndex() <= curMocaToken.getStartIndex()
                                && stopFuncToken.getStopIndex() >= curMocaToken.getStopIndex()) {
                            // Looks like we have our function expression.
                            MocaFunction mocaFunction = MocaCache.getGlobalMocaCache().functions
                                    .get(mocaFuncExpr.WORD().getText());
                            if (mocaFunction != null) {
                                // One thing to note -- we do not have to worry about overloads with moca
                                // functions.
                                List<SignatureInformation> sigInfos = new ArrayList<>();
                                List<ParameterInformation> parameters = new ArrayList<>();
                                StringBuilder mocaFunctionSigInfoLabelBuf = new StringBuilder();
                                mocaFunctionSigInfoLabelBuf.append(mocaFunction.name);
                                mocaFunctionSigInfoLabelBuf.append('(');

                                for (String argName : mocaFunction.argumentNames) {
                                    ParameterInformation paramInfo = new ParameterInformation();
                                    paramInfo.setLabel(
                                            argName.compareTo(MocaFunction.VARIABLE_LENGTH_ARGUMENT) == 0 ? "..."
                                                    : argName);
                                    parameters.add(paramInfo);
                                    mocaFunctionSigInfoLabelBuf.append(
                                            argName.compareTo(MocaFunction.VARIABLE_LENGTH_ARGUMENT) == 0 ? "..."
                                                    : argName);
                                    mocaFunctionSigInfoLabelBuf.append(',');
                                }

                                // Remove last comma so that the signature looks nice!
                                if (mocaFunctionSigInfoLabelBuf
                                        .charAt(mocaFunctionSigInfoLabelBuf.length() - 1) == ',') {
                                    mocaFunctionSigInfoLabelBuf.deleteCharAt(mocaFunctionSigInfoLabelBuf.length() - 1);
                                }

                                mocaFunctionSigInfoLabelBuf.append(')');

                                SignatureInformation sigInfo = new SignatureInformation();
                                sigInfo.setLabel(mocaFunctionSigInfoLabelBuf.toString());
                                sigInfo.setParameters(parameters);
                                sigInfos.add(sigInfo);

                                // Get active parameter index.
                                // We know that comma tokens in the function expr will delmit args. So all we
                                // have to do is figure out how many comma tokens are to the left of our current
                                // token.
                                // Let's just assume the comma tokens are in 'ascending' order.
                                int currentCommaTokenIdx = 0;
                                for (org.antlr.v4.runtime.tree.TerminalNode commaNode : mocaFuncExpr.COMMA()) {
                                    org.antlr.v4.runtime.Token commaNodeToken = commaNode.getSymbol();
                                    if (commaNodeToken.getStopIndex() <= curMocaToken.getStartIndex()) {
                                        currentCommaTokenIdx++;
                                    } else {
                                        break;
                                    }
                                }

                                return CompletableFuture
                                        .completedFuture(new SignatureHelp(sigInfos, 0, currentCommaTokenIdx));
                            }
                        }
                    }
                }
            case MocaSql:
                // Looking for moca functions -- moca functions are valid in mocasql context.
                break;
            case Groovy:
                GroovyCompilationResult groovyCompilationResult = MocaServices.mocaCompilationResult.groovyCompilationResults
                        .get(mocaLanguageContext.rangeIdx);

                Range groovyScriptRange = MocaServices.mocaCompilationResult.groovyRanges
                        .get(mocaLanguageContext.rangeIdx);

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