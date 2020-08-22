package com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.util;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.ast.GroovyASTNodeVisitor;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.ConstructorNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.Variable;

public class GroovyNodeToStringUtils {
    private static final String JAVA_OBJECT = "java.lang.Object";

    public static String classToString(ClassNode classNode, GroovyASTNodeVisitor ast) {
        StringBuilder builder = new StringBuilder();
        if (!classNode.isSyntheticPublic()) {
            builder.append("public ");
        }
        if (classNode.isAbstract()) {
            builder.append("abstract ");
        }
        if (classNode.isInterface()) {
            builder.append("interface ");
        } else if (classNode.isEnum()) {
            builder.append("enum ");
        } else {
            builder.append("class ");
        }
        builder.append(classNode.getName());

        ClassNode superClass = classNode.getSuperClass();
        if (superClass != null && !superClass.getName().equals(JAVA_OBJECT)) {
            builder.append(" extends ");
            builder.append(superClass.getNameWithoutPackage());
        }
        return builder.toString();
    }

    public static String constructorToString(ConstructorNode constructorNode, GroovyASTNodeVisitor ast) {
        StringBuilder builder = new StringBuilder();
        builder.append(constructorNode.getDeclaringClass().getName());
        builder.append("(");
        builder.append(parametersToString(constructorNode.getParameters(), ast));
        builder.append(")");
        return builder.toString();
    }

    public static String methodToString(MethodNode methodNode, GroovyASTNodeVisitor ast) {
        if (methodNode instanceof ConstructorNode) {
            return constructorToString((ConstructorNode) methodNode, ast);
        }
        StringBuilder builder = new StringBuilder();
        if (methodNode.isPublic()) {
            if (!methodNode.isSyntheticPublic()) {
                builder.append("public ");
            }
        } else if (methodNode.isProtected()) {
            builder.append("protected ");
        } else if (methodNode.isPrivate()) {
            builder.append("private ");
        }

        if (methodNode.isStatic()) {
            builder.append("static ");
        }

        if (methodNode.isFinal()) {
            builder.append("final ");
        }
        ClassNode returnType = methodNode.getReturnType();
        builder.append(returnType.getNameWithoutPackage());
        builder.append(" ");
        builder.append(methodNode.getName());
        builder.append("(");
        builder.append(parametersToString(methodNode.getParameters(), ast));
        builder.append(")");
        return builder.toString();
    }

    public static String parametersToString(Parameter[] params, GroovyASTNodeVisitor ast) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            Parameter paramNode = params[i];
            builder.append(variableToString(paramNode, ast));
        }
        return builder.toString();
    }

    public static String variableToString(Variable variable, GroovyASTNodeVisitor ast) {
        StringBuilder builder = new StringBuilder();
        if (variable instanceof FieldNode) {
            FieldNode fieldNode = (FieldNode) variable;
            if (fieldNode.isPublic()) {
                builder.append("public ");
            }
            if (fieldNode.isProtected()) {
                builder.append("protected ");
            }
            if (fieldNode.isPrivate()) {
                builder.append("private ");
            }

            if (fieldNode.isFinal()) {
                builder.append("final ");
            }

            if (fieldNode.isStatic()) {
                builder.append("static ");
            }
        }
        ClassNode varType = null;
        if (variable instanceof ASTNode) {
            varType = GroovyASTUtils.getTypeOfNode((ASTNode) variable, ast);
        } else {
            varType = variable.getType();
        }
        builder.append(varType.getNameWithoutPackage());
        builder.append(" ");
        builder.append(variable.getName());
        return builder.toString();
    }
}