package com.github.mrglassdanny.mocalanguageserver.moca.lang.ast;

import com.redprairie.moca.server.exec.*;
import com.redprairie.moca.server.expression.Expression;

import java.lang.reflect.Field;
import java.util.List;

public class MocaExecutableComponentVisitor {

    public MocaExecutableComponentVisitor() {
    }

    public void visitCommandSequence(CommandSequence sequence) {

        if (sequence == null) {
            return;
        }

        for (CommandStream stream : sequence.getStreams()) {
            this.visitCommandStream(stream);
        }
    }

    public void visitCommandStream(CommandStream stream) {

        if (stream == null)
            return;

        for (CommandGroup group : stream.getGroups()) {
            this.visitCommandGroup(group);
        }
    }

    public void visitCommandGroup(CommandGroup group) {

        if (group == null) {
            return;
        }

        for (CommandStatement stmt : group.getStatements()) {
            this.visitCommandStatement(stmt);
        }
    }

    public void visitCommandStatement(CommandStatement statement) {

        if (statement == null) {
            return;
        }

        try {
            Field mainBlock = CommandStatement.class.getDeclaredField("_mainBlock");
            Field ifTest = CommandStatement.class.getDeclaredField("_ifTest");
            Field ifBlock = CommandStatement.class.getDeclaredField("_ifBlock");
            Field elseBlock = CommandStatement.class.getDeclaredField("_elseBlock");
            Field catchBlocks = CommandStatement.class.getDeclaredField("_catchBlocks");
            Field finallyBlock = CommandStatement.class.getDeclaredField("_finallyBlock");
            Field redirect = CommandStatement.class.getDeclaredField("_redirect");

            mainBlock.setAccessible(true);
            ifTest.setAccessible(true);
            ifBlock.setAccessible(true);
            elseBlock.setAccessible(true);
            catchBlocks.setAccessible(true);
            finallyBlock.setAccessible(true);
            redirect.setAccessible(true);

            try {
                this.visitCommandBlock((CommandBlock) mainBlock.get(statement));
                this.visitExpression((Expression) ifTest.get(statement));
                this.visitCommandStatement((CommandStatement) ifBlock.get(statement));
                this.visitCommandStatement((CommandStatement) elseBlock.get(statement));
                List<CatchBlock> list_catchBlocks = (List<CatchBlock>) catchBlocks.get(statement);
                if (list_catchBlocks != null) {
                    for (CatchBlock catchBlock : list_catchBlocks) {
                        this.visitCatchBlock(catchBlock);
                    }
                }

                this.visitCommandSequence((CommandSequence) finallyBlock.get(statement));

            } catch (IllegalAccessException illegalAccessException) {
                // Uh oh...
            }
        } catch (NoSuchFieldException noSuchFieldException) {
            // Uh oh...
        }
    }

    public void visitCommandBlock(CommandBlock block) {

        if (block == null) {
            return;
        }

        try {
            Field command = CommandBlock.class.getDeclaredField("_command");
            Field subSequence = CommandBlock.class.getDeclaredField("_subSequence");
            Field remoteHost = CommandBlock.class.getDeclaredField("_remoteHost");
            Field remoteType = CommandBlock.class.getDeclaredField("_remoteType");
            Field text = CommandBlock.class.getDeclaredField("_text");

            command.setAccessible(true);
            subSequence.setAccessible(true);
            remoteHost.setAccessible(true);
            remoteType.setAccessible(true);
            text.setAccessible(true);

            try {
                this.visitCommandUnit((CommandUnit) command.get(block));
                this.visitCommandSequence((CommandSequence) subSequence.get(block));
                this.visitExpression((Expression) remoteHost.get(block));

            } catch (IllegalAccessException illegalAccessException) {
                // Uh oh...
            }
        } catch (NoSuchFieldException noSuchFieldException) {
            // Uh oh...
        }

    }

    public void visitCommandUnit(CommandUnit unit) {

        if (unit == null) {
            return;
        }

        try {
            Field sql = CommandUnit.class.getDeclaredField("_sql");
            Field script = CommandUnit.class.getDeclaredField("_script");
            Field override = CommandUnit.class.getDeclaredField("_override");
            Field verbNounClause = CommandUnit.class.getDeclaredField("_verbNounClause");
            Field language = CommandUnit.class.getDeclaredField("_language");
            Field argList = CommandUnit.class.getDeclaredField("_argList");

            sql.setAccessible(true);
            script.setAccessible(true);
            override.setAccessible(true);
            verbNounClause.setAccessible(true);
            language.setAccessible(true);
            argList.setAccessible(true);

            try {

                List<CommandArg> list_argList = (List<CommandArg>) argList.get(unit);
                if (list_argList != null) {
                    for (CommandArg arg : list_argList) {
                        this.visitCommandArg(arg);
                    }
                }

            } catch (IllegalAccessException illegalAccessException) {
                // Uh oh...
            }
        } catch (NoSuchFieldException noSuchFieldException) {
            // Uh oh...
        }
    }

    public void visitCatchBlock(CatchBlock catchBlock) {

        if (catchBlock == null) {
            return;
        }

        this.visitExpression(catchBlock.getTest());
        this.visitCommandSequence(catchBlock.getBlock());
    }

    public void visitExpression(Expression expression) {

        if (expression == null) {
            return;
        }
        // Nothing yet..
    }

    public void visitCommandArg(CommandArg arg) {
        if (arg == null) {
            return;
        }
    }
}
