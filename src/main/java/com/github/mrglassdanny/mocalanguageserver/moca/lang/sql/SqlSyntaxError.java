package com.github.mrglassdanny.mocalanguageserver.moca.lang.sql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.lsp4j.Position;

import net.sf.jsqlparser.JSQLParserException;

public class SqlSyntaxError {
    private Throwable cause;
    private String simplifiedErrMsg;
    private int line;
    private int column;

    public SqlSyntaxError(JSQLParserException e) {
        this.cause = e.getCause();

        String str = this.cause.getMessage();

        if (str == null) {
            this.simplifiedErrMsg = "";
            this.line = 0;
            this.column = 0;
            return;
        }

        int cutoffIndex = str.length() - 1; // Simplify error message.

        Pattern linePattern = Pattern.compile("(line \\d+)");
        Pattern columnPattern = Pattern.compile("(column \\d+)");
        Pattern numberPattern = Pattern.compile("\\d+");

        Matcher lineMatcher = linePattern.matcher(str);
        Matcher columnMatcher = columnPattern.matcher(str);

        int lineNum = 0, columnNum = 0;
        while (lineMatcher.find()) {
            String lineStr = lineMatcher.group();
            Matcher lineNumMatcher = numberPattern.matcher(lineStr);
            while (lineNumMatcher.find()) {
                String lineNumStr = lineNumMatcher.group();
                lineNum = Integer.parseInt(lineNumStr);
                break;
            }

            break;
        }

        while (columnMatcher.find()) {
            String columnStr = columnMatcher.group();
            Matcher columnNumMatcher = numberPattern.matcher(columnStr);
            while (columnNumMatcher.find()) {
                String columnNumStr = columnNumMatcher.group();
                columnNum = Integer.parseInt(columnNumStr);
                break;
            }

            cutoffIndex = str.indexOf(columnStr) + columnStr.length();

            break;
        }

        this.line = lineNum;
        this.column = columnNum;

        this.simplifiedErrMsg = str.substring(0, cutoffIndex);
    }

    public Position getSyntaxErrorPosition() {
        return new Position(this.line, this.column);
    }

    public String getSyntaxErrorText() {

        return this.simplifiedErrMsg;
    }
}