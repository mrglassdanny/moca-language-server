package com.github.mrglassdanny.mocalanguageserver.moca.lang.reimpl;

import com.redprairie.moca.server.parse.MocaLexException;
import com.redprairie.moca.server.parse.MocaTokenType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    This is a re-implementation of the MocaLexer class. The purpose for re-implementing
    is to get a little bit more information from the lexing process.

    We are also re-implementing any sub classes in this file in order to get access to 
    information in data structures.
*/

public class MocaLexerReImpl {
    private final CharSequence _in;
    private final int _length;
    private int _pos;
    private int _line;
    private int _linePos;
    private int _begin;
    private int _startOfToken;
    private MocaLexerReImpl.MocaToken _currentToken;
    private static final Map<String, MocaTokenType> _RESERVED = new HashMap();

    public MocaLexerReImpl(CharSequence in) {
        this._in = in;
        this._length = in.length();
        this._pos = 0;
        this._line = 0;
    }

    public MocaLexerReImpl.Reference markPlace() {
        return new MocaLexerReImpl.Reference(this._currentToken.beginWhitespace);
    }

    public String getTextSinceMark(MocaLexerReImpl.Reference mark) {
        return this._in.subSequence(mark._refPos, this._currentToken.beginToken).toString();
    }

    public MocaLexerReImpl.MocaToken current() {
        return this._currentToken;
    }

    public MocaTokenType tokenType() {
        return this._currentToken.type;
    }

    public int getLine() {
        return this._line;
    }

    public int getLinePos() {
        return this._linePos - (this._pos - this._currentToken.beginToken);
    }

    public MocaLexerReImpl.MocaToken next() throws MocaLexException {
        do {
            this._currentToken = this._nextToken();
        } while (this._currentToken.type == MocaTokenType.COMMENT);

        return this._currentToken;
    }

    public MocaLexerReImpl.MocaToken[] getAllTokens() throws MocaLexException {
        ArrayList tokens = new ArrayList();

        MocaLexerReImpl.MocaToken token;
        do {
            token = this._nextToken();
            tokens.add(token);
        } while (token.getType() != MocaTokenType.EOF);

        return (MocaLexerReImpl.MocaToken[]) tokens.toArray(new MocaLexerReImpl.MocaToken[tokens.size()]);
    }

    public static String getString(MocaLexerReImpl.MocaToken[] elements) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < elements.length; ++i) {
            buf.append(elements[i]);
        }

        return buf.toString();
    }

    public static String getString(Collection<MocaLexerReImpl.MocaToken> elements) {
        StringBuilder buf = new StringBuilder();
        Iterator i$ = elements.iterator();

        while (i$.hasNext()) {
            MocaLexerReImpl.MocaToken e = (MocaLexerReImpl.MocaToken) i$.next();
            buf.append(e);
        }

        return buf.toString();
    }

    private MocaLexerReImpl.MocaToken _nextToken() throws MocaLexException {
        this._begin = this._pos;
        this._skipWhitespace();
        if (!this._hasNext()) {
            return new MocaLexerReImpl.MocaToken(MocaTokenType.EOF, this._begin, this._pos);
        } else {
            this._startOfToken = this._pos;
            char c = this._nextChar();
            if (!Character.isDigit(c) && c != '.') {
                if (!Character.isLetter(c) && c != '_') {
                    switch (c) {
                        case '!':
                            if (this._hasNext() && this._peekChar() == '=') {
                                this._nextChar();
                                return new MocaLexerReImpl.MocaToken(MocaTokenType.NE, this._begin, this._startOfToken);
                            }

                            return new MocaLexerReImpl.MocaToken(MocaTokenType.BANG, this._begin, this._startOfToken);
                        case '"':
                        case '\'':
                        case '[':
                            if (c == '[' && this._hasNext() && this._peekChar() == '[') {
                                return new MocaLexerReImpl.MocaToken(this._readJavaString(c), this._begin,
                                        this._startOfToken);
                            }

                            return new MocaLexerReImpl.MocaToken(this._readSQLString(c), this._begin,
                                    this._startOfToken);
                        case '#':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.POUND, this._begin, this._startOfToken);
                        case '$':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case ']':
                        case '_':
                        case '`':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                        default:
                            throw new MocaLexException(this._line + 1, this._linePos + 1,
                                    "Unrecognized identifier: " + c);
                        case '%':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.PERCENT, this._begin,
                                    this._startOfToken);
                        case '&':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.AMPERSAND, this._begin,
                                    this._startOfToken);
                        case '(':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.OPEN_PAREN, this._begin,
                                    this._startOfToken);
                        case ')':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.CLOSE_PAREN, this._begin,
                                    this._startOfToken);
                        case '*':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.STAR, this._begin, this._startOfToken);
                        case '+':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.PLUS, this._begin, this._startOfToken);
                        case ',':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.COMMA, this._begin, this._startOfToken);
                        case '-':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.MINUS, this._begin, this._startOfToken);
                        case '/':
                            if (this._hasNext() && this._peekChar() == '*') {
                                this._nextChar();

                                do {
                                    do {
                                        c = this._nextChar();
                                    } while (c != '*');
                                } while (this._peekChar() != '/');

                                this._nextChar();
                                return new MocaLexerReImpl.MocaToken(MocaTokenType.COMMENT, this._begin,
                                        this._startOfToken);
                            } else {
                                return new MocaLexerReImpl.MocaToken(MocaTokenType.SLASH, this._begin,
                                        this._startOfToken);
                            }
                        case ':':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.COLON, this._begin, this._startOfToken);
                        case ';':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.SEMICOLON, this._begin,
                                    this._startOfToken);
                        case '<':
                            if (this._hasNext() && this._peekChar() == '=') {
                                this._nextChar();
                                return new MocaLexerReImpl.MocaToken(MocaTokenType.LE, this._begin, this._startOfToken);
                            } else {
                                if (this._hasNext() && this._peekChar() == '>') {
                                    this._nextChar();
                                    return new MocaLexerReImpl.MocaToken(MocaTokenType.NE, this._begin,
                                            this._startOfToken);
                                }

                                return new MocaLexerReImpl.MocaToken(MocaTokenType.LT, this._begin, this._startOfToken);
                            }
                        case '=':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.EQ, this._begin, this._startOfToken);
                        case '>':
                            if (this._hasNext() && this._peekChar() == '=') {
                                this._nextChar();
                                return new MocaLexerReImpl.MocaToken(MocaTokenType.GE, this._begin, this._startOfToken);
                            } else {
                                if (this._hasNext() && this._peekChar() == '>') {
                                    this._nextChar();
                                    return new MocaLexerReImpl.MocaToken(MocaTokenType.REDIR_INTO, this._begin,
                                            this._startOfToken);
                                }

                                return new MocaLexerReImpl.MocaToken(MocaTokenType.GT, this._begin, this._startOfToken);
                            }
                        case '?':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.QUESTION_MARK, this._begin,
                                    this._startOfToken);
                        case '@':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.ATSIGN, this._begin, this._startOfToken);
                        case '\\':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.BACKSLASH, this._begin,
                                    this._startOfToken);
                        case '^':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.CARET, this._begin, this._startOfToken);
                        case '{':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.OPEN_BRACE, this._begin,
                                    this._startOfToken);
                        case '|':
                            if (this._hasNext() && this._peekChar() == '|') {
                                this._nextChar();
                                return new MocaLexerReImpl.MocaToken(MocaTokenType.DOUBLEPIPE, this._begin,
                                        this._startOfToken);
                            }

                            return new MocaLexerReImpl.MocaToken(MocaTokenType.PIPE, this._begin, this._startOfToken);
                        case '}':
                            return new MocaLexerReImpl.MocaToken(MocaTokenType.CLOSE_BRACE, this._begin,
                                    this._startOfToken);
                    }
                } else {
                    return this._readIdentifier();
                }
            } else {
                return this._readNumeric(c);
            }
        }
    }

    private MocaLexerReImpl.MocaToken _readNumeric(char c) throws MocaLexException {
        if (c == '+' || c == '-') {
            this._nextChar();
        }

        while (this._hasNext() && Character.isDigit(this._peekChar())) {
            this._nextChar();
        }

        if (this._hasNext() && this._peekChar() == '.') {
            this._nextChar();
        }

        while (this._hasNext() && Character.isDigit(this._peekChar())) {
            this._nextChar();
        }

        if (this._hasNext() && (this._peekChar() == 'e' || this._peekChar() == 'E')) {
            this._nextChar();
            if (this._peekChar() == '+' || this._peekChar() == '-') {
                this._nextChar();
            }

            while (this._hasNext() && Character.isDigit(this._peekChar())) {
                this._nextChar();
            }
        } else if (this._hasNext() && (Character.isLetter(this._peekChar()) || this._peekChar() == '_')) {
            return this._readIdentifier();
        }

        return new MocaLexerReImpl.MocaToken(MocaTokenType.NUMBER, this._begin, this._startOfToken);
    }

    private boolean _isValidIdentifier(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == '_' || c == '$' || c == '.' || Character.isDigit(c);
    }

    private MocaLexerReImpl.MocaToken _readIdentifier() throws MocaLexException {
        return this._readIdentifierAs((MocaTokenType) null);
    }

    private MocaLexerReImpl.MocaToken _readIdentifierAs(MocaTokenType type) throws MocaLexException {
        while (this._hasNext() && this._isValidIdentifier(this._peekChar())) {
            this._nextChar();
        }

        String word = this._in.subSequence(this._startOfToken, this._pos).toString();
        MocaTokenType wordType;
        if (type != null) {
            wordType = type;
        } else {
            wordType = (MocaTokenType) _RESERVED.get(word.toLowerCase());
            if (wordType == null) {
                wordType = MocaTokenType.VARWORD;
            }
        }

        return new MocaLexerReImpl.MocaToken(wordType, this._begin, this._startOfToken);
    }

    private MocaTokenType _readSQLString(char c) throws MocaLexException {
        if (c != '\'' && c != '"') {
            for (c = this._nextChar(); c != ']'; c = this._nextChar()) {
                if (c != '\'' && c != '"' && c != '[') {
                    if (c == '/' && this._peekChar() == '*') {
                        this._nextChar();

                        do {
                            do {
                                c = this._nextChar();
                            } while (c != '*');
                        } while (this._peekChar() != '/');

                        this._nextChar();
                    }
                } else {
                    this._readSQLString(c);
                }
            }

            return MocaTokenType.BRACKET_STRING;
        } else {
            char lookfor = c;

            do {
                for (c = this._nextChar(); c == lookfor && this._hasNext()
                        && this._peekChar() == lookfor; c = this._nextChar()) {
                    this._nextChar();
                }
            } while (c != lookfor);

            if (lookfor == '\'') {
                return MocaTokenType.SINGLE_STRING;
            } else {
                return MocaTokenType.DOUBLE_STRING;
            }
        }
    }

    private MocaTokenType _readJavaString(char c) throws MocaLexException {
        if (c != '\'' && c != '"') {
            for (c = this._nextChar(); c != ']'; c = this._nextChar()) {
                if (c != '\'' && c != '"' && c != '[') {
                    if (c == '/' && this._peekChar() == '/') {
                        this._nextChar();

                        do {
                            c = this._nextChar();
                        } while (c != '\n');
                    } else if (c == '/' && this._peekChar() == '*') {
                        this._nextChar();

                        do {
                            do {
                                c = this._nextChar();
                            } while (c != '*');
                        } while (this._peekChar() != '/');

                        this._nextChar();
                    }
                } else {
                    this._readJavaString(c);
                }
            }

            return MocaTokenType.BRACKET_STRING;
        } else {
            char lookfor = c;

            do {
                for (c = this._nextChar(); c == '\\'; c = this._nextChar()) {
                    this._nextChar();
                }
            } while (c != lookfor);

            if (lookfor == '\'') {
                return MocaTokenType.SINGLE_STRING;
            } else {
                return MocaTokenType.DOUBLE_STRING;
            }
        }
    }

    private void _skipWhitespace() throws MocaLexException {
        while (this._pos < this._length && Character.isWhitespace(this._peekChar())) {
            this._nextChar();
        }

    }

    private char _nextChar() throws MocaLexException {
        if (this._pos >= this._length) {
            throw new MocaLexException(this._line + 1, this._linePos + 1, "Unexpected end of command text");
        } else {
            ++this._linePos;
            char next = this._in.charAt(this._pos++);
            if (next == '\n') {
                ++this._line;
                this._linePos = 0;
            }

            return next;
        }
    }

    private char _peekChar() {
        return this._in.charAt(this._pos);
    }

    private boolean _hasNext() {
        return this._pos < this._length;
    }

    static {
        _RESERVED.put("if", MocaTokenType.IF);
        _RESERVED.put("else", MocaTokenType.ELSE);
        _RESERVED.put("where", MocaTokenType.WHERE);
        _RESERVED.put("remote", MocaTokenType.REMOTE);
        _RESERVED.put("parallel", MocaTokenType.PARALLEL);
        _RESERVED.put("inparallel", MocaTokenType.INPARALLEL);
        _RESERVED.put("and", MocaTokenType.AND);
        _RESERVED.put("or", MocaTokenType.OR);
        _RESERVED.put("not", MocaTokenType.NOT);
        _RESERVED.put("is", MocaTokenType.IS);
        _RESERVED.put("null", MocaTokenType.NULL_TOKEN);
        _RESERVED.put("like", MocaTokenType.LIKE);
        _RESERVED.put("try", MocaTokenType.TRY);
        _RESERVED.put("catch", MocaTokenType.CATCH);
        _RESERVED.put("finally", MocaTokenType.FINALLY);
    }

    public static class Reference {
        private final int _refPos;

        private Reference(int pos) {
            this._refPos = pos;
        }
    }

    public class MocaToken {
        public final MocaTokenType type;
        public final int beginToken;
        public final int beginWhitespace;
        public final int end;

        public MocaTokenType getType() {
            return this.type;
        }

        public String getValue() {
            return MocaLexerReImpl.this._in.subSequence(this.beginToken, this.end).toString();
        }

        public String toString() {
            return MocaLexerReImpl.this._in.subSequence(this.beginWhitespace, this.end).toString();
        }

        public String getLeadingWhitespace() {
            return MocaLexerReImpl.this._in.subSequence(this.beginWhitespace, this.beginToken).toString();
        }

        private MocaToken(MocaTokenType type, int beginWhitespace, int beginToken) {
            this.type = type;
            this.beginToken = beginToken;
            this.beginWhitespace = beginWhitespace;
            this.end = MocaLexerReImpl.this._pos;
        }
    }
}
