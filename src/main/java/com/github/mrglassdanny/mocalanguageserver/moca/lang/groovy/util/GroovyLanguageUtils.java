package com.github.mrglassdanny.mocalanguageserver.moca.lang.groovy.util;

import java.net.URI;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.PropertyNode;
import org.codehaus.groovy.ast.Variable;
import org.codehaus.groovy.syntax.SyntaxException;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SymbolKind;

public class GroovyLanguageUtils {

    public static final String GROOVY_DEFAULT_IMPORTS = "import java.lang.*; import java.util.*; import java.io.*; import java.net.*; import groovy.lang.*; import groovy.util.*; import java.math.BigInteger; import java.math.BigDecimal; ";

    public static final String MOCA_DEFAULT_IMPORTS = "import com.redprairie.moca.*; import com.redprairie.moca.util.*; import com.redprairie.moca.exceptions.*;";
    public static final String MOCA_DEFAULT_DECLARATIONS = "MocaContext moca; ";
    public static final String MOCA_GROOVY_SCRIPT_PREFIX = MOCA_DEFAULT_IMPORTS + MOCA_DEFAULT_DECLARATIONS;

    public static boolean importIsContainedInDefaultGroovyImports(String fullClassName) {

        String packageName = fullClassName.substring(0, fullClassName.lastIndexOf("."));
        if (GroovyLanguageUtils.MOCA_DEFAULT_IMPORTS.contains(packageName)
                || GroovyLanguageUtils.GROOVY_DEFAULT_IMPORTS.contains(packageName)) {
            return true;
        } else {
            return false;
        }
    }

    // Since we could have multiple groovy ranges in script, we need to pass in the
    // range of the groovy script we are referring to.
    public static Position createMocaPosition(int groovyLine, int groovyColumn, Range groovyScriptRange) {
        int lspLine = groovyLine;
        if (lspLine > 0) {
            lspLine--;
        }
        int lspColumn = groovyColumn;
        if (lspColumn > 0) {
            lspColumn--;
        }

        // If the line is 0, we need to keep the char offset in mind.
        if (lspLine == 0) {
            return new Position(lspLine + groovyScriptRange.getStart().getLine(),
                    lspColumn + groovyScriptRange.getStart().getCharacter() + 2); // +2 for '[['.
        } else {
            return new Position(lspLine + groovyScriptRange.getStart().getLine(), lspColumn);
        }
    }

    public static Range syntaxExceptionToRange(SyntaxException exception, Range groovyScriptRange) {
        return new Range(createMocaPosition(exception.getStartLine(), exception.getStartColumn(), groovyScriptRange),
                createMocaPosition(exception.getEndLine(), exception.getEndColumn(), groovyScriptRange));
    }

    // Also takes current groovy context range index.
    public static Range astNodeToRange(ASTNode node, Range groovyScriptRange) {
        return new Range(createMocaPosition(node.getLineNumber(), node.getColumnNumber(), groovyScriptRange),
                createMocaPosition(node.getLastLineNumber(), node.getLastColumnNumber(), groovyScriptRange));
    }

    public static CompletionItemKind astNodeToCompletionItemKind(ASTNode node) {
        if (node instanceof ClassNode) {
            ClassNode classNode = (ClassNode) node;
            if (classNode.isInterface()) {
                return CompletionItemKind.Interface;
            } else if (classNode.isEnum()) {
                return CompletionItemKind.Enum;
            }
            return CompletionItemKind.Class;
        } else if (node instanceof MethodNode) {
            return CompletionItemKind.Method;
        } else if (node instanceof Variable) {
            if (node instanceof FieldNode || node instanceof PropertyNode) {
                return CompletionItemKind.Field;
            }
            return CompletionItemKind.Variable;
        }

        return CompletionItemKind.Property;
    }

    public static SymbolKind astNodeToSymbolKind(ASTNode node) {
        if (node instanceof ClassNode) {
            ClassNode classNode = (ClassNode) node;
            if (classNode.isInterface()) {
                return SymbolKind.Interface;
            } else if (classNode.isEnum()) {
                return SymbolKind.Enum;
            }
            return SymbolKind.Class;
        } else if (node instanceof MethodNode) {
            return SymbolKind.Method;
        } else if (node instanceof Variable) {
            if (node instanceof FieldNode || node instanceof PropertyNode) {
                return SymbolKind.Field;
            }
            return SymbolKind.Variable;
        }
        return SymbolKind.Property;
    }

    public static Location astNodeToLocation(ASTNode node, Range groovyScriptRange, URI uri) {
        return new Location(uri.toString(), astNodeToRange(node, groovyScriptRange));
    }

}