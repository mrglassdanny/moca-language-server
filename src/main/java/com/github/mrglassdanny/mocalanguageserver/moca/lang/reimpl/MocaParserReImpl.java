package com.github.mrglassdanny.mocalanguageserver.moca.lang.reimpl;

import com.github.mrglassdanny.mocalanguageserver.moca.lang.CommandUnitStruct;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.reimpl.MocaLexerReImpl.MocaToken;
import com.github.mrglassdanny.mocalanguageserver.moca.lang.reimpl.MocaLexerReImpl.Reference;
import com.redprairie.moca.MocaOperator;
import com.redprairie.moca.MocaType;
import com.redprairie.moca.server.exec.CatchBlock;
import com.redprairie.moca.server.exec.CommandArg;
import com.redprairie.moca.server.exec.CommandBlock;
import com.redprairie.moca.server.exec.CommandGroup;
import com.redprairie.moca.server.exec.CommandSequence;
import com.redprairie.moca.server.exec.CommandStatement;
import com.redprairie.moca.server.exec.CommandStream;
import com.redprairie.moca.server.exec.CommandUnit;
import com.redprairie.moca.server.exec.CommandBlock.RemoteType;
import com.redprairie.moca.server.expression.ErrorCodeExpression;
import com.redprairie.moca.server.expression.ErrorMessageExpression;
import com.redprairie.moca.server.expression.Expression;
import com.redprairie.moca.server.expression.FunctionExpression;
import com.redprairie.moca.server.expression.LiteralExpression;
import com.redprairie.moca.server.expression.ReferenceExpression;
import com.redprairie.moca.server.expression.ScriptExpression;
import com.redprairie.moca.server.expression.operators.AndExpression;
import com.redprairie.moca.server.expression.operators.ConcatExpression;
import com.redprairie.moca.server.expression.operators.IsNullExpression;
import com.redprairie.moca.server.expression.operators.NotExpression;
import com.redprairie.moca.server.expression.operators.NotNullExpression;
import com.redprairie.moca.server.expression.operators.OrExpression;
import com.redprairie.moca.server.expression.operators.arith.DivisionExpression;
import com.redprairie.moca.server.expression.operators.arith.MinusExpression;
import com.redprairie.moca.server.expression.operators.arith.ModExpression;
import com.redprairie.moca.server.expression.operators.arith.MultiplyExpression;
import com.redprairie.moca.server.expression.operators.arith.PlusExpression;
import com.redprairie.moca.server.expression.operators.compare.EqualsExpression;
import com.redprairie.moca.server.expression.operators.compare.GreaterThanExpression;
import com.redprairie.moca.server.expression.operators.compare.GreaterThanOrEqualsExpression;
import com.redprairie.moca.server.expression.operators.compare.LessThanExpression;
import com.redprairie.moca.server.expression.operators.compare.LessThanOrEqualsExpression;
import com.redprairie.moca.server.expression.operators.compare.LikeExpression;
import com.redprairie.moca.server.expression.operators.compare.NotEqualsExpression;
import com.redprairie.moca.server.expression.operators.compare.NotLikeExpression;
import com.redprairie.moca.server.parse.MocaParseException;
import com.redprairie.moca.server.parse.MocaTokenType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    This is a re-implementation of the MocaParser class. The purpose for re-implementing
    is to get a little bit more information from the parsing process.
*/
public class MocaParserReImpl {
    private MocaLexerReImpl _scan;
    // For linking a token to a command unit.
    public HashMap<CommandUnitStruct, ArrayList<MocaToken>> commandUnitStructs;
    // For linking a token to a redirect.
    public HashMap<MocaToken, String> redirects;

    public MocaParserReImpl(CharSequence command) {
        this._scan = new MocaLexerReImpl(command);
        this.commandUnitStructs = new HashMap<>();
        this.redirects = new HashMap<>();
    }

    public CommandSequence parse() throws MocaParseException {

        this.commandUnitStructs.clear();

        this._scan.next();
        CommandSequence seq = this.buildSequence();
        if (this._scan.tokenType() != MocaTokenType.EOF) {
            throw new MocaParseException(this._scan.getLine() + 1, this._scan.getLinePos() + 1,
                    "Unexpected token: " + this._scan.current());
        } else {
            return seq;
        }
    }

    private CommandSequence buildSequence() throws MocaParseException {
        CommandSequence sequence = new CommandSequence();
        CommandStream stream = this.buildStream();
        sequence.addStream(stream);

        while (this._scan.tokenType() == MocaTokenType.SEMICOLON) {
            this._scan.next();
            if (this._scan.tokenType() == MocaTokenType.CLOSE_BRACE || this._scan.tokenType() == MocaTokenType.EOF) {
                break;
            }

            stream = this.buildStream();
            sequence.addStream(stream);
        }

        return sequence;
    }

    private CommandStream buildStream() throws MocaParseException {
        CommandStream stream = new CommandStream();
        CommandGroup group = this.buildGroup();
        stream.addGroup(group);

        while (this._scan.tokenType() == MocaTokenType.PIPE) {
            this._scan.next();
            group = this.buildGroup();
            stream.addGroup(group);
        }

        return stream;
    }

    private CommandGroup buildGroup() throws MocaParseException {
        CommandGroup group = new CommandGroup();
        CommandStatement stmt = this.buildStatement();
        group.addStatement(stmt);

        while (this._scan.tokenType() == MocaTokenType.AMPERSAND) {
            this._scan.next();
            stmt = this.buildStatement();
            group.addStatement(stmt);
        }

        return group;
    }

    private CommandStatement buildStatement() throws MocaParseException {
        CommandStatement stmt = new CommandStatement();
        if (this._scan.tokenType() == MocaTokenType.IF) {
            this._scan.next();
            if (this._scan.tokenType() != MocaTokenType.OPEN_PAREN) {
                throw this.parseException("(");
            }

            this._scan.next();
            stmt.setIfTest(this.buildFullExpression());
            if (this._scan.tokenType() != MocaTokenType.CLOSE_PAREN) {
                throw this.parseException(")");
            }

            this._scan.next();
            stmt.setIfBlock(this.buildStatement());
            if (this._scan.tokenType() == MocaTokenType.ELSE) {
                this._scan.next();
                stmt.setElseBlock(this.buildStatement());
            }
        } else if (this._scan.tokenType() == MocaTokenType.TRY) {
            this._scan.next();
            if (this._scan.tokenType() != MocaTokenType.OPEN_BRACE) {
                throw this.parseException("{");
            }

            stmt.setMainBlock(this.buildBlock());
            stmt.setCatchBlocks(this.buildCatchBlocks());
            if (this._scan.tokenType() == MocaTokenType.FINALLY) {
                this._scan.next();
                stmt.setFinallyBlock(this.buildSubSequence());
            }
        } else {
            stmt.setMainBlock(this.buildBlock());
            stmt.setCatchBlocks(this.buildMultiCatchBlock());
        }

        if (this._scan.tokenType() == MocaTokenType.REDIR_INTO) {
            this._scan.next();
            if (this._scan.tokenType() != MocaTokenType.VARWORD) {
                throw this.parseException("<WORD>");
            }

            String curVal = this._scan.current().getValue();
            stmt.setRedirect(curVal);
            // Add redirect to map!
            MocaToken curMocaToken = this._scan.current();
            this.redirects.put(curMocaToken, curVal);

            this._scan.next();
        }

        return stmt;
    }

    private List<CatchBlock> buildCatchBlocks() throws MocaParseException {
        if (this._scan.tokenType() != MocaTokenType.CATCH) {
            return null;
        } else {
            ArrayList blocks = new ArrayList();

            while (this._scan.tokenType() == MocaTokenType.CATCH) {
                CatchBlock block = new CatchBlock();
                this._scan.next();
                if (this._scan.tokenType() != MocaTokenType.OPEN_PAREN) {
                    throw this.parseException("(");
                }

                this._scan.next();
                block.setTest(this.buildExpressionTerm());
                if (this._scan.tokenType() != MocaTokenType.CLOSE_PAREN) {
                    throw this.parseException(")");
                }

                this._scan.next();
                if (this._scan.tokenType() != MocaTokenType.OPEN_BRACE) {
                    throw this.parseException("{");
                }

                this._scan.next();
                if (this._scan.tokenType() != MocaTokenType.CLOSE_BRACE) {
                    block.setBlock(this.buildSequence());
                }

                if (this._scan.tokenType() != MocaTokenType.CLOSE_BRACE) {
                    throw this.parseException("}");
                }

                this._scan.next();
                blocks.add(block);
            }

            return blocks;
        }
    }

    private List<CatchBlock> buildMultiCatchBlock() throws MocaParseException {
        if (this._scan.tokenType() != MocaTokenType.CATCH) {
            return null;
        } else {
            List<CatchBlock> blocks = new ArrayList();
            this._scan.next();
            if (this._scan.tokenType() != MocaTokenType.OPEN_PAREN) {
                throw this.parseException("(");
            } else {
                this._scan.next();

                while (true) {
                    CatchBlock block = new CatchBlock();
                    block.setTest(this.buildExpressionTerm());
                    blocks.add(block);
                    if (this._scan.tokenType() != MocaTokenType.COMMA) {
                        if (this._scan.tokenType() != MocaTokenType.CLOSE_PAREN) {
                            throw this.parseException(")");
                        } else {
                            this._scan.next();
                            return blocks;
                        }
                    }

                    this._scan.next();
                }
            }
        }
    }

    private CommandSequence buildSubSequence() throws MocaParseException {
        if (this._scan.tokenType() != MocaTokenType.OPEN_BRACE) {
            throw this.parseException("{");
        } else {
            this._scan.next();
            CommandSequence seq = this.buildSequence();
            if (this._scan.tokenType() != MocaTokenType.CLOSE_BRACE) {
                throw this.parseException("}");
            } else {
                this._scan.next();
                return seq;
            }
        }
    }

    private CommandBlock buildBlock() throws MocaParseException {
        CommandBlock block = new CommandBlock();
        RemoteType remoteFlavor = null;
        Reference remoteStart = null;
        if (this._scan.tokenType() == MocaTokenType.REMOTE || this._scan.tokenType() == MocaTokenType.PARALLEL
                || this._scan.tokenType() == MocaTokenType.INPARALLEL) {
            MocaTokenType flavorToken = this._scan.tokenType();
            if (flavorToken == MocaTokenType.REMOTE) {
                remoteFlavor = RemoteType.REMOTE;
            } else if (flavorToken == MocaTokenType.PARALLEL) {
                remoteFlavor = RemoteType.PARALLEL;
            } else {
                remoteFlavor = RemoteType.INPARALLEL;
            }

            this._scan.next();
            if (this._scan.tokenType() != MocaTokenType.OPEN_PAREN) {
                throw this.parseException("(");
            }

            this._scan.next();
            block.setRemoteType(remoteFlavor);
            block.setRemoteHost(this.buildExpressionTerm());
            if (this._scan.tokenType() != MocaTokenType.CLOSE_PAREN) {
                throw this.parseException(")");
            }

            this._scan.next();
            remoteStart = this._scan.markPlace();
        }

        if (this._scan.tokenType() == MocaTokenType.OPEN_BRACE) {
            this._scan.next();
            block.setSubSequence(this.buildSequence());
            if (this._scan.tokenType() != MocaTokenType.CLOSE_BRACE) {
                throw this.parseException("}");
            }

            this._scan.next();
        } else {
            block.setCommand(this.buildCommand());
        }

        if (remoteStart != null) {
            block.setRemoteText(this._scan.getTextSinceMark(remoteStart));
        }

        return block;
    }

    private CommandUnit buildCommand() throws MocaParseException {
        CommandUnit cmd = new CommandUnit();
        ArrayList<MocaToken> commandUnitLexerTokens = new ArrayList<>();
        String verb;
        if (this._scan.tokenType() == MocaTokenType.COLON) {
            commandUnitLexerTokens.add(this._scan.next());
            if (this._scan.tokenType() != MocaTokenType.VARWORD) {
                throw this.parseException("<WORD>");
            }

            verb = this._scan.current().getValue();
            cmd.setLanguage(verb);
            commandUnitLexerTokens.add(this._scan.next());
        }

        if (this._scan.tokenType() == MocaTokenType.BRACKET_STRING) {
            verb = this._scan.current().getValue();
            commandUnitLexerTokens.add(this._scan.next());
            if (verb.length() >= 4 && verb.charAt(1) == '[' && verb.charAt(verb.length() - 2) == ']') {
                cmd.setScript(verb.substring(2, verb.length() - 2));
            } else {
                cmd.setSql(verb.substring(1, verb.length() - 1));
            }
        } else {
            if (this._scan.tokenType() == MocaTokenType.CARET) {
                commandUnitLexerTokens.add(this._scan.next());
                cmd.setOverride(true);
            }

            if (this._scan.tokenType() != MocaTokenType.VARWORD) {
                throw this.parseException("<WORD>");
            }

            commandUnitLexerTokens.add(this._scan.current());
            verb = this._scan.current().getValue();
            StringBuilder verbNounClause = new StringBuilder(verb);
            commandUnitLexerTokens.add(this._scan.next());

            while (this.isValidNoun(this._scan.tokenType())) {
                verbNounClause.append(' ');
                verbNounClause.append(this._scan.current().getValue());
                commandUnitLexerTokens.add(this._scan.next());
            }

            cmd.setVerbNounClause(verbNounClause.toString().toLowerCase());
        }

        if (this._scan.tokenType() == MocaTokenType.WHERE) {
            commandUnitLexerTokens.add(this._scan.next());
            cmd.setArgList(this.buildArgList(commandUnitLexerTokens));
        }

        // Convert CommandUnit to CommandUnitStruct.
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

                List<CommandArg> list_argList = (List<CommandArg>) argList.get(cmd);

                this.commandUnitStructs.put(new CommandUnitStruct((String) sql.get(cmd), (String) script.get(cmd),
                        (boolean) override.get(cmd), (String) verbNounClause.get(cmd), (String) language.get(cmd),
                        list_argList), commandUnitLexerTokens);

            } catch (IllegalAccessException illegalAccessException) {
                // Uh oh...
            }
        } catch (NoSuchFieldException noSuchFieldException) {
            // Uh oh...
        }
        return cmd;
    }

    private boolean isValidNoun(MocaTokenType type) {
        switch (type) {
            case VARWORD:
            case REMOTE:
            case PARALLEL:
            case INPARALLEL:
            case AND:
            case OR:
            case NOT:
            case IS:
            case LIKE:
            case NULL_TOKEN:
                return true;
            default:
                return false;
        }
    }

    private boolean isValidVariableRef(MocaTokenType type) {
        switch (type) {
            case VARWORD:
            case REMOTE:
            case PARALLEL:
            case INPARALLEL:
            case LIKE:
            case WHERE:
                return true;
            case AND:
            case OR:
            case NOT:
            case IS:
            case NULL_TOKEN:
            default:
                return false;
        }
    }

    private List<CommandArg> buildArgList(ArrayList<MocaToken> commandUnitTokens) throws MocaParseException {
        ArrayList argList = new ArrayList();

        while (true) {
            CommandArg arg = new CommandArg();
            if (this._scan.tokenType() == MocaTokenType.BRACKET_STRING) {
                String strToken = this._scan.current().getValue();
                commandUnitTokens.add(this._scan.next());
                arg.setName("where");
                arg.setOperator(MocaOperator.RAWCLAUSE);
                arg.setValue(new LiteralExpression(MocaType.STRING, strToken.substring(1, strToken.length() - 1)));
            } else {
                String name;
                if (this._scan.tokenType() == MocaTokenType.ATSIGN) {
                    commandUnitTokens.add(this._scan.next());
                    if (this._scan.tokenType() == MocaTokenType.STAR) {
                        commandUnitTokens.add(this._scan.next());
                        arg.setName("_ALL_ARGS_");
                        arg.setOperator(MocaOperator.REFALL);
                    } else {
                        if (this._scan.tokenType() != MocaTokenType.PLUS
                                && this._scan.tokenType() != MocaTokenType.PERCENT) {
                            throw this.parseException("*, % or +");
                        }

                        boolean isLike = this._scan.tokenType() == MocaTokenType.PERCENT;
                        commandUnitTokens.add(this._scan.next());
                        name = this.getVarName("NAME");
                        commandUnitTokens.add(this._scan.next());
                        if (this._scan.tokenType() == MocaTokenType.CARET) {
                            commandUnitTokens.add(this._scan.next());
                            arg.setName(this.getVarName("NAME"));
                            arg.setTargetName(name);
                            commandUnitTokens.add(this._scan.next());
                        } else {
                            arg.setName(name);
                        }

                        arg.setOperator(isLike ? MocaOperator.REFLIKE : MocaOperator.REFONE);
                    }
                } else {
                    arg.setName(this.getVarName("WORD, wildcard variable reference (@+, @*), or [raw where clause]"));
                    commandUnitTokens.add(this._scan.next());
                    MocaTokenType oper = this._scan.tokenType();
                    if (oper == MocaTokenType.BRACKET_STRING) {
                        name = this._scan.current().getValue();
                        commandUnitTokens.add(this._scan.next());
                        arg.setOperator(MocaOperator.NAMEDCLAUSE);
                        arg.setValue(new LiteralExpression(MocaType.STRING, name.substring(1, name.length() - 1)));
                    } else if (oper == MocaTokenType.IS) {
                        commandUnitTokens.add(this._scan.next());
                        if (this._scan.tokenType() == MocaTokenType.NOT) {
                            commandUnitTokens.add(this._scan.next());
                            arg.setOperator(MocaOperator.NOTNULL);
                        } else {
                            arg.setOperator(MocaOperator.ISNULL);
                        }

                        if (this._scan.tokenType() != MocaTokenType.NULL_TOKEN) {
                            throw this.parseException("NULL");
                        }

                        commandUnitTokens.add(this._scan.next());
                    } else {
                        if (oper == MocaTokenType.EQ) {
                            arg.setOperator(MocaOperator.EQ);
                        } else if (oper == MocaTokenType.NE) {
                            arg.setOperator(MocaOperator.NE);
                        } else if (oper == MocaTokenType.GT) {
                            arg.setOperator(MocaOperator.GT);
                        } else if (oper == MocaTokenType.GE) {
                            arg.setOperator(MocaOperator.GE);
                        } else if (oper == MocaTokenType.LT) {
                            arg.setOperator(MocaOperator.LT);
                        } else if (oper == MocaTokenType.LE) {
                            arg.setOperator(MocaOperator.LE);
                        } else if (oper == MocaTokenType.LIKE) {
                            arg.setOperator(MocaOperator.LIKE);
                        } else {
                            if (oper != MocaTokenType.NOT) {
                                throw this.parseException("(=, !=, >, <, >=, <=, IS, or LIKE)");
                            }

                            commandUnitTokens.add(this._scan.next());
                            if (this._scan.tokenType() != MocaTokenType.LIKE) {
                                throw this.parseException("LIKE");
                            }

                            arg.setOperator(MocaOperator.NOTLIKE);
                        }

                        commandUnitTokens.add(this._scan.next());
                        arg.setValue(this.buildExpressionTerm());
                    }
                }
            }

            argList.add(arg);
            if (this._scan.tokenType() != MocaTokenType.AND) {
                return argList;
            }

            commandUnitTokens.add(this._scan.next());
        }
    }

    private Expression buildExpressionTerm() throws MocaParseException {
        Object expr = this.buildExpressionFactor();

        while (true) {
            while (true) {
                MocaTokenType operatorToken = this._scan.tokenType();
                if (operatorToken == MocaTokenType.PLUS) {
                    this._scan.next();
                    expr = new PlusExpression((Expression) expr, this.buildExpressionFactor());
                } else if (operatorToken == MocaTokenType.MINUS) {
                    this._scan.next();
                    expr = new MinusExpression((Expression) expr, this.buildExpressionFactor());
                } else {
                    if (operatorToken != MocaTokenType.DOUBLEPIPE) {
                        return (Expression) expr;
                    }

                    this._scan.next();
                    expr = new ConcatExpression((Expression) expr, this.buildExpressionFactor());
                }
            }
        }
    }

    private Expression buildLogicalExpression() throws MocaParseException {
        Expression expr = this.buildExpressionTerm();
        MocaTokenType oper = this._scan.tokenType();
        if (oper == MocaTokenType.IS) {
            this._scan.next();
            if (this._scan.tokenType() == MocaTokenType.NOT) {
                this._scan.next();
                expr = new NotNullExpression((Expression) expr);
            } else {
                expr = new IsNullExpression((Expression) expr);
            }

            if (this._scan.tokenType() != MocaTokenType.NULL_TOKEN) {
                throw this.parseException("NULL");
            }

            this._scan.next();
        } else if (oper == MocaTokenType.EQ) {
            this._scan.next();
            expr = new EqualsExpression((Expression) expr, this.buildExpressionTerm());
        } else if (oper == MocaTokenType.NE) {
            this._scan.next();
            expr = new NotEqualsExpression((Expression) expr, this.buildExpressionTerm());
        } else if (oper == MocaTokenType.GT) {
            this._scan.next();
            expr = new GreaterThanExpression((Expression) expr, this.buildExpressionTerm());
        } else if (oper == MocaTokenType.GE) {
            this._scan.next();
            expr = new GreaterThanOrEqualsExpression((Expression) expr, this.buildExpressionTerm());
        } else if (oper == MocaTokenType.LT) {
            this._scan.next();
            expr = new LessThanExpression((Expression) expr, this.buildExpressionTerm());
        } else if (oper == MocaTokenType.LE) {
            this._scan.next();
            expr = new LessThanOrEqualsExpression((Expression) expr, this.buildExpressionTerm());
        } else if (oper == MocaTokenType.LIKE) {
            this._scan.next();
            expr = new LikeExpression((Expression) expr, this.buildExpressionTerm());
        } else if (oper == MocaTokenType.NOT) {
            this._scan.next();
            if (this._scan.tokenType() != MocaTokenType.LIKE) {
                throw this.parseException("LIKE");
            }

            this._scan.next();
            expr = new NotLikeExpression((Expression) expr, this.buildExpressionTerm());
        }

        return (Expression) expr;
    }

    private Expression buildAndExpression() throws MocaParseException {
        Object expr;
        Expression right;
        for (expr = this.buildLogicalExpression(); this._scan
                .tokenType() == MocaTokenType.AND; expr = new AndExpression((Expression) expr, right)) {
            this._scan.next();
            right = this.buildLogicalExpression();
        }

        return (Expression) expr;
    }

    private Expression buildFullExpression() throws MocaParseException {
        Object expr;
        Expression right;
        for (expr = this.buildAndExpression(); this._scan
                .tokenType() == MocaTokenType.OR; expr = new OrExpression((Expression) expr, right)) {
            this._scan.next();
            right = this.buildAndExpression();
        }

        return (Expression) expr;
    }

    private Expression buildExpressionFactor() throws MocaParseException {
        Object expr = this.buildExpressionValue();

        while (true) {
            while (true) {
                MocaTokenType operatorToken = this._scan.tokenType();
                if (operatorToken == MocaTokenType.STAR) {
                    this._scan.next();
                    expr = new MultiplyExpression((Expression) expr, this.buildExpressionValue());
                } else if (operatorToken == MocaTokenType.SLASH) {
                    this._scan.next();
                    expr = new DivisionExpression((Expression) expr, this.buildExpressionValue());
                } else {
                    if (operatorToken != MocaTokenType.PERCENT) {
                        return (Expression) expr;
                    }

                    this._scan.next();
                    expr = new ModExpression((Expression) expr, this.buildExpressionValue());
                }
            }
        }
    }

    private Expression buildExpressionValue() throws MocaParseException {
        boolean isNegative = false;
        switch (this._scan.tokenType()) {
            case VARWORD:
                return this.buildFunctionExpression();
            case REMOTE:
            case PARALLEL:
            case INPARALLEL:
            case AND:
            case OR:
            case NOT:
            case IS:
            case LIKE:
            case WHERE:
            default:
                throw this.parseException("expression");
            case NULL_TOKEN:
                this._scan.next();
                return new LiteralExpression(MocaType.STRING, (Object) null);
            case BANG:
                this._scan.next();
                return new NotExpression(this.buildExpressionValue());
            case OPEN_PAREN:
                this._scan.next();
                Expression subExpression = this.buildFullExpression();
                if (this._scan.tokenType() != MocaTokenType.CLOSE_PAREN) {
                    throw this.parseException(")");
                }

                this._scan.next();
                return subExpression;
            case MINUS:
                isNegative = true;
            case PLUS:
                this._scan.next();
                if (this._scan.tokenType() != MocaTokenType.NUMBER) {
                    throw this.parseException("<NUMBER>");
                }
            case NUMBER:
                String numericValue = this._scan.current().getValue();
                if (isNegative) {
                    numericValue = "-" + numericValue;
                }

                LiteralExpression numericExpression;
                try {
                    if (numericValue.indexOf(46) == -1 && numericValue.indexOf(101) == -1
                            && numericValue.indexOf(69) == -1) {
                        long tmpValue = Long.parseLong(numericValue);
                        if (tmpValue <= 2147483647L && tmpValue >= -2147483648L) {
                            numericExpression = new LiteralExpression(MocaType.INTEGER, (int) tmpValue);
                        } else {
                            numericExpression = new LiteralExpression(MocaType.DOUBLE, (double) tmpValue);
                        }
                    } else {
                        numericExpression = new LiteralExpression(MocaType.DOUBLE, new Double(numericValue));
                    }
                } catch (NumberFormatException var13) {
                    throw this.parseException("NUMERIC");
                }

                this._scan.next();
                return numericExpression;
            case BRACKET_STRING:
                String bracketValue = this._scan.current().getValue();
                this._scan.next();
                String rawValue;
                if (bracketValue.length() >= 4 && bracketValue.charAt(1) == '['
                        && bracketValue.charAt(bracketValue.length() - 2) == ']') {
                    rawValue = bracketValue.substring(2, bracketValue.length() - 2);
                    return new ScriptExpression(rawValue);
                }

                rawValue = bracketValue.substring(1, bracketValue.length() - 1);
                return new LiteralExpression(MocaType.STRING, rawValue);
            case SINGLE_STRING:
            case DOUBLE_STRING:
                String unquoted = this._scan.current().getValue();
                this._scan.next();
                return new LiteralExpression(MocaType.STRING, this.dequote(unquoted));
            case ATSIGN:
                this._scan.next();
                if (this._scan.tokenType() == MocaTokenType.BANG) {
                    this._scan.next();
                    return new ErrorMessageExpression();
                } else if (this._scan.tokenType() == MocaTokenType.QUESTION_MARK) {
                    this._scan.next();
                    return new ErrorCodeExpression();
                } else {
                    boolean isEnvironment = false;
                    boolean useAllForms = false;
                    if (this._scan.tokenType() == MocaTokenType.ATSIGN) {
                        this._scan.next();
                        isEnvironment = true;
                    } else if (this._scan.tokenType() == MocaTokenType.MINUS) {
                        this._scan.next();
                        useAllForms = true;
                    }

                    String name = this.getVarName("NAME");
                    this._scan.next();
                    boolean markUsed = true;
                    boolean checkOnly = false;
                    if (this._scan.tokenType() == MocaTokenType.POUND) {
                        this._scan.next();
                        if (this._scan.tokenType() != MocaTokenType.VARWORD) {
                            throw this.parseException("keep or onstack");
                        }

                        if (this._scan.current().getValue().equalsIgnoreCase("keep")) {
                            markUsed = false;
                        } else {
                            if (!this._scan.current().getValue().equalsIgnoreCase("onstack")) {
                                throw this.parseException("keep or onstack");
                            }

                            checkOnly = true;
                        }

                        this._scan.next();
                    }

                    return new ReferenceExpression(name, isEnvironment, useAllForms, markUsed, checkOnly);
                }
        }
    }

    private Expression buildFunctionExpression() throws MocaParseException {
        String functionName = this._scan.current().getValue();
        List<Expression> functionArgs = new ArrayList();
        this._scan.next();
        if (this._scan.tokenType() == MocaTokenType.OPEN_PAREN) {
            this._scan.next();

            while (this._scan.tokenType() != MocaTokenType.CLOSE_PAREN) {
                functionArgs.add(this.buildFullExpression());
                if (this._scan.tokenType() == MocaTokenType.COMMA) {
                    this._scan.next();
                } else if (this._scan.tokenType() != MocaTokenType.CLOSE_PAREN) {
                    throw this.parseException(")");
                }
            }

            this._scan.next();
        }

        return new FunctionExpression(functionName, functionArgs);
    }

    private String dequote(String orig) {
        char quotechar = orig.charAt(0);
        int startpos = 1;
        int endpos = orig.length() - 1;
        StringBuilder buf = new StringBuilder(orig.length());

        do {
            int quotepos = orig.indexOf(quotechar, startpos);
            if (quotepos > startpos) {
                buf.append(orig, startpos, quotepos);
            }

            if (quotepos < endpos) {
                buf.append(quotechar);
                startpos = quotepos + 2;
            } else {
                startpos = quotepos;
            }
        } while (startpos < endpos);

        return buf.toString();
    }

    private String getVarName(String expect) throws MocaParseException {
        if (this.isValidVariableRef(this._scan.tokenType())) {
            return this._scan.current().getValue();
        } else {
            throw this.parseException(expect);
        }
    }

    private MocaParseException parseException(String expected) {
        return new MocaParseException(this._scan.getLine() + 1, this._scan.getLinePos() + 1,
                "Expected: " + expected + ", got " + this._scan.current());
    }
}