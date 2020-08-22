package com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.embedded.groovy.util.GroovyLanguageUtils;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Positions;
import com.github.mrglassdanny.mocalanguageserver.util.lsp.Ranges;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.AnnotatedNode;
import org.codehaus.groovy.ast.ClassCodeVisitorSupport;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.ConstructorNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.ImportNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.PropertyNode;
import org.codehaus.groovy.ast.expr.ArrayExpression;
import org.codehaus.groovy.ast.expr.AttributeExpression;
import org.codehaus.groovy.ast.expr.BinaryExpression;
import org.codehaus.groovy.ast.expr.BitwiseNegationExpression;
import org.codehaus.groovy.ast.expr.BooleanExpression;
import org.codehaus.groovy.ast.expr.CastExpression;
import org.codehaus.groovy.ast.expr.ClassExpression;
import org.codehaus.groovy.ast.expr.ClosureExpression;
import org.codehaus.groovy.ast.expr.ClosureListExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.ConstructorCallExpression;
import org.codehaus.groovy.ast.expr.ElvisOperatorExpression;
import org.codehaus.groovy.ast.expr.FieldExpression;
import org.codehaus.groovy.ast.expr.GStringExpression;
import org.codehaus.groovy.ast.expr.ListExpression;
import org.codehaus.groovy.ast.expr.MapEntryExpression;
import org.codehaus.groovy.ast.expr.MapExpression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.expr.MethodPointerExpression;
import org.codehaus.groovy.ast.expr.NotExpression;
import org.codehaus.groovy.ast.expr.PostfixExpression;
import org.codehaus.groovy.ast.expr.PrefixExpression;
import org.codehaus.groovy.ast.expr.PropertyExpression;
import org.codehaus.groovy.ast.expr.RangeExpression;
import org.codehaus.groovy.ast.expr.SpreadExpression;
import org.codehaus.groovy.ast.expr.SpreadMapExpression;
import org.codehaus.groovy.ast.expr.StaticMethodCallExpression;
import org.codehaus.groovy.ast.expr.TernaryExpression;
import org.codehaus.groovy.ast.expr.TupleExpression;
import org.codehaus.groovy.ast.expr.UnaryMinusExpression;
import org.codehaus.groovy.ast.expr.UnaryPlusExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.AssertStatement;
import org.codehaus.groovy.ast.stmt.BreakStatement;
import org.codehaus.groovy.ast.stmt.CaseStatement;
import org.codehaus.groovy.ast.stmt.CatchStatement;
import org.codehaus.groovy.ast.stmt.ContinueStatement;
import org.codehaus.groovy.ast.stmt.DoWhileStatement;
import org.codehaus.groovy.ast.stmt.EmptyStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.ForStatement;
import org.codehaus.groovy.ast.stmt.IfStatement;
import org.codehaus.groovy.ast.stmt.ReturnStatement;
import org.codehaus.groovy.ast.stmt.SwitchStatement;
import org.codehaus.groovy.ast.stmt.SynchronizedStatement;
import org.codehaus.groovy.ast.stmt.ThrowStatement;
import org.codehaus.groovy.ast.stmt.TryCatchStatement;
import org.codehaus.groovy.ast.stmt.WhileStatement;
import org.codehaus.groovy.classgen.BytecodeExpression;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.SourceUnit;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class GroovyASTNodeVisitor extends ClassCodeVisitorSupport {
    private class ASTNodeLookupData {
        public ASTNode parent;
    }

    private SourceUnit sourceUnit;

    @Override
    protected SourceUnit getSourceUnit() {
        return sourceUnit;
    }

    public Stack<ASTNode> stack = new Stack<>();
    public Set<ASTNode> allNodes = new HashSet<>();
    public Set<ClassNode> classNodes = new HashSet<>();
    public Map<ASTNode, ASTNodeLookupData> lookup = new HashMap<>();
    public ModuleNode module = null;

    private void pushASTNode(ASTNode node) {
        boolean isSynthetic = false;
        if (node instanceof AnnotatedNode) {
            AnnotatedNode annotatedNode = (AnnotatedNode) node;
            isSynthetic = annotatedNode.isSynthetic();
        }
        if (!isSynthetic) {

            this.allNodes.add(node);

            ASTNodeLookupData data = new ASTNodeLookupData();

            if (this.stack.size() > 0) {
                data.parent = this.stack.lastElement();
            }
            this.lookup.put(node, data);
        }

        this.stack.add(node);
    }

    private void popASTNode() {
        this.stack.pop();
    }

    public List<ClassNode> getClassNodes() {
        return new ArrayList<>(this.classNodes);
    }

    public List<ASTNode> getNodes() {
        return new ArrayList<>(this.allNodes);
    }

    // Also takes current groovy context range index.
    public ASTNode getNodeAtLineAndColumn(int line, int column, Range groovyScriptRange) {
        Position position = new Position(line, column);
        Map<ASTNode, Range> nodeToRange = new HashMap<>();
        if (this.allNodes == null) {
            return null;
        }
        List<ASTNode> foundNodes = this.allNodes.stream().filter(node -> {
            if (node.getLineNumber() == -1) {
                // can't be the offset node if it has no position
                // also, do this first because it's the fastest comparison
                return false;
            }
            ASTNodeLookupData lookupData = lookup.get(node);
            if (lookupData == null) {
                return false;
            }
            Range range = GroovyLanguageUtils.astNodeToRange(node, groovyScriptRange);
            boolean result = Ranges.contains(range, position);
            if (result) {
                // save the range object to avoid creating it again when we
                // sort the nodes
                nodeToRange.put(node, range);
            }
            return result;
        }).sorted((n1, n2) -> {
            int result = Positions.COMPARATOR.reversed().compare(nodeToRange.get(n1).getStart(),
                    nodeToRange.get(n2).getStart());
            if (result != 0) {
                return result;
            }
            result = Positions.COMPARATOR.compare(nodeToRange.get(n1).getEnd(), nodeToRange.get(n2).getEnd());
            if (result != 0) {
                return result;
            }
            // n1 and n2 have the same range
            if (contains(n1, n2)) {
                if (n1 instanceof ClassNode && n2 instanceof ConstructorNode) {
                    return -1;
                }
                return 1;
            } else if (contains(n2, n1)) {
                if (n2 instanceof ClassNode && n1 instanceof ConstructorNode) {
                    return 1;
                }
                return -1;
            }
            return 0;
        }).collect(Collectors.toList());
        if (foundNodes.size() == 0) {
            return null;
        }
        return foundNodes.get(0);
    }

    public ASTNode getParent(ASTNode child) {
        ASTNodeLookupData data = lookup.get(child);
        if (data == null) {
            return null;
        }
        return data.parent;
    }

    public boolean contains(ASTNode ancestor, ASTNode descendant) {
        ASTNode current = getParent(descendant);
        while (current != null) {
            if (current.equals(ancestor)) {
                return true;
            }
            current = getParent(current);
        }
        return false;
    }

    public void visitCompilationUnit(CompilationUnit unit) {

        this.allNodes.clear();
        this.classNodes.clear();
        this.lookup.clear();

        unit.iterator().forEachRemaining(sourceUnit -> {
            this.visitSourceUnit(sourceUnit);
        });
    }

    public void visitSourceUnit(SourceUnit unit) {
        this.sourceUnit = unit;
        if (unit != null && unit.getAST() != null && unit.getAST().getClasses() != null) {
            unit.getAST().getClasses().forEach(classInUnit -> {
                this.visitClass(classInUnit);
            });
        }
        this.sourceUnit = null;
    }

    // GroovyClassVisitor

    public void visitClass(ClassNode node) {
        this.classNodes.add(node);
        this.pushASTNode(node);
        try {
            super.visitClass(node);
        } finally {
            this.popASTNode();
        }
    }

    @Override
    public void visitImports(ModuleNode node) {

        if (node != null) {

            this.module = node;

            for (ImportNode importNode : node.getImports()) {
                this.pushASTNode(importNode);
                this.visitAnnotations(importNode);
                importNode.visit(this);
                this.popASTNode();
            }
            for (ImportNode importStarNode : node.getStarImports()) {
                this.pushASTNode(importStarNode);
                this.visitAnnotations(importStarNode);
                importStarNode.visit(this);
                this.popASTNode();

            }
            for (ImportNode importStaticNode : node.getStaticImports().values()) {
                this.pushASTNode(importStaticNode);
                this.visitAnnotations(importStaticNode);
                importStaticNode.visit(this);
                this.popASTNode();
            }
            for (ImportNode importStaticStarNode : node.getStaticStarImports().values()) {
                this.pushASTNode(importStaticStarNode);
                this.visitAnnotations(importStaticStarNode);
                importStaticStarNode.visit(this);
                this.popASTNode();
            }
        }
    }

    public void visitConstructor(ConstructorNode node) {
        this.pushASTNode(node);
        try {
            super.visitConstructor(node);
            for (Parameter parameter : node.getParameters()) {
                this.visitParameter(parameter);
            }
        } finally {
            this.popASTNode();
        }
    }

    public void visitMethod(MethodNode node) {
        this.pushASTNode(node);
        try {
            super.visitMethod(node);
            for (Parameter parameter : node.getParameters()) {
                this.visitParameter(parameter);
            }
        } finally {
            this.popASTNode();
        }
    }

    protected void visitParameter(Parameter node) {
        this.pushASTNode(node);
        try {
        } finally {
            this.popASTNode();
        }
    }

    public void visitField(FieldNode node) {
        this.pushASTNode(node);
        try {
            super.visitField(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitProperty(PropertyNode node) {
        this.pushASTNode(node);
        try {
            super.visitProperty(node);
        } finally {
            this.popASTNode();
        }
    }

    // GroovyCodeVisitor

    // this has the same range as a class, which isn't ideal
    /*
     * public void visitBlockStatement(BlockStatement node) { pushASTNode(node); try
     * { super.visitBlockStatement(node); } finally { popASTNode(); } }
     */

    public void visitForLoop(ForStatement node) {
        this.pushASTNode(node);
        try {
            super.visitForLoop(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitWhileLoop(WhileStatement node) {
        this.pushASTNode(node);
        try {
            super.visitWhileLoop(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitDoWhileLoop(DoWhileStatement node) {
        this.pushASTNode(node);
        try {
            super.visitDoWhileLoop(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitIfElse(IfStatement node) {
        this.pushASTNode(node);
        try {
            super.visitIfElse(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitExpressionStatement(ExpressionStatement node) {
        this.pushASTNode(node);
        try {
            super.visitExpressionStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitReturnStatement(ReturnStatement node) {
        this.pushASTNode(node);
        try {
            super.visitReturnStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitAssertStatement(AssertStatement node) {
        this.pushASTNode(node);
        try {
            super.visitAssertStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitTryCatchFinally(TryCatchStatement node) {
        this.pushASTNode(node);
        try {
            super.visitTryCatchFinally(node);
        } finally {
            this.popASTNode();
        }
    }

    protected void visitEmptyStatement(EmptyStatement node) {
        this.pushASTNode(node);
        try {
            super.visitEmptyStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitSwitch(SwitchStatement node) {
        this.pushASTNode(node);
        try {
            super.visitSwitch(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitCaseStatement(CaseStatement node) {
        this.pushASTNode(node);
        try {
            super.visitCaseStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitBreakStatement(BreakStatement node) {
        this.pushASTNode(node);
        try {
            super.visitBreakStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitContinueStatement(ContinueStatement node) {
        this.pushASTNode(node);
        try {
            super.visitContinueStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitSynchronizedStatement(SynchronizedStatement node) {
        this.pushASTNode(node);
        try {
            super.visitSynchronizedStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitThrowStatement(ThrowStatement node) {
        this.pushASTNode(node);
        try {
            super.visitThrowStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitMethodCallExpression(MethodCallExpression node) {
        this.pushASTNode(node);
        try {
            super.visitMethodCallExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitStaticMethodCallExpression(StaticMethodCallExpression node) {
        this.pushASTNode(node);
        try {
            super.visitStaticMethodCallExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitConstructorCallExpression(ConstructorCallExpression node) {
        this.pushASTNode(node);
        try {
            super.visitConstructorCallExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitBinaryExpression(BinaryExpression node) {
        this.pushASTNode(node);
        try {
            super.visitBinaryExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitTernaryExpression(TernaryExpression node) {
        this.pushASTNode(node);
        try {
            super.visitTernaryExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitShortTernaryExpression(ElvisOperatorExpression node) {
        this.pushASTNode(node);
        try {
            super.visitShortTernaryExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitPostfixExpression(PostfixExpression node) {
        this.pushASTNode(node);
        try {
            super.visitPostfixExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitPrefixExpression(PrefixExpression node) {
        this.pushASTNode(node);
        try {
            super.visitPrefixExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitBooleanExpression(BooleanExpression node) {
        this.pushASTNode(node);
        try {
            super.visitBooleanExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitNotExpression(NotExpression node) {
        this.pushASTNode(node);
        try {
            super.visitNotExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitClosureExpression(ClosureExpression node) {
        this.pushASTNode(node);
        try {
            super.visitClosureExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitTupleExpression(TupleExpression node) {
        this.pushASTNode(node);
        try {
            super.visitTupleExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitListExpression(ListExpression node) {
        this.pushASTNode(node);
        try {
            super.visitListExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitArrayExpression(ArrayExpression node) {
        this.pushASTNode(node);
        try {
            super.visitArrayExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitMapExpression(MapExpression node) {
        this.pushASTNode(node);
        try {
            super.visitMapExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitMapEntryExpression(MapEntryExpression node) {
        this.pushASTNode(node);
        try {
            super.visitMapEntryExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitRangeExpression(RangeExpression node) {
        this.pushASTNode(node);
        try {
            super.visitRangeExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitSpreadExpression(SpreadExpression node) {
        this.pushASTNode(node);
        try {
            super.visitSpreadExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitSpreadMapExpression(SpreadMapExpression node) {
        this.pushASTNode(node);
        try {
            super.visitSpreadMapExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitMethodPointerExpression(MethodPointerExpression node) {
        this.pushASTNode(node);
        try {
            super.visitMethodPointerExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitUnaryMinusExpression(UnaryMinusExpression node) {
        this.pushASTNode(node);
        try {
            super.visitUnaryMinusExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitUnaryPlusExpression(UnaryPlusExpression node) {
        this.pushASTNode(node);
        try {
            super.visitUnaryPlusExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitBitwiseNegationExpression(BitwiseNegationExpression node) {
        this.pushASTNode(node);
        try {
            super.visitBitwiseNegationExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitCastExpression(CastExpression node) {
        this.pushASTNode(node);
        try {
            super.visitCastExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitConstantExpression(ConstantExpression node) {
        this.pushASTNode(node);
        try {
            super.visitConstantExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitClassExpression(ClassExpression node) {
        this.pushASTNode(node);
        try {
            super.visitClassExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitVariableExpression(VariableExpression node) {
        this.pushASTNode(node);
        try {
            super.visitVariableExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    // this calls visitBinaryExpression()
    /*
     * public void visitDeclarationExpression(DeclarationExpression node) {
     * pushASTNode(node); try { super.visitDeclarationExpression(node); } finally {
     * popASTNode(); } }
     */

    public void visitPropertyExpression(PropertyExpression node) {
        this.pushASTNode(node);
        try {
            super.visitPropertyExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitAttributeExpression(AttributeExpression node) {
        this.pushASTNode(node);
        try {
            super.visitAttributeExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitFieldExpression(FieldExpression node) {
        this.pushASTNode(node);
        try {
            super.visitFieldExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitGStringExpression(GStringExpression node) {
        this.pushASTNode(node);
        try {
            super.visitGStringExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitCatchStatement(CatchStatement node) {
        this.pushASTNode(node);
        try {
            super.visitCatchStatement(node);
        } finally {
            this.popASTNode();
        }
    }

    // this calls visitTupleListExpression()
    /*
     * public void visitArgumentlistExpression(ArgumentListExpression node) {
     * pushASTNode(node); try { super.visitArgumentlistExpression(node); } finally {
     * popASTNode(); } }
     */

    public void visitClosureListExpression(ClosureListExpression node) {
        this.pushASTNode(node);
        try {
            super.visitClosureListExpression(node);
        } finally {
            this.popASTNode();
        }
    }

    public void visitBytecodeExpression(BytecodeExpression node) {
        this.pushASTNode(node);
        try {
            super.visitBytecodeExpression(node);
        } finally {
            this.popASTNode();
        }
    }
}