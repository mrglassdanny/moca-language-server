package com.github.mrglassdanny.mocalanguageserver.util.lsp;

import java.util.Comparator;
import java.util.regex.Pattern;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class Positions {

    public static final Comparator<Position> COMPARATOR = (Position p1, Position p2) -> {
        if (p1.getLine() != p2.getLine()) {
            return p1.getLine() - p2.getLine();
        }
        return p1.getCharacter() - p2.getCharacter();
    };

    public static boolean isValid(Position position) {
        return (position.getLine() >= 0 && position.getCharacter() >= 0);
    }

    public static boolean isOffsetValid(String string, int offset) {
        return offset >= 0 && offset <= string.length();
    }

    public static int getOffset(String string, Position position) {

        if (!isValid(position)) {
            return -1;
        }

        int line = position.getLine();
        int character = position.getCharacter();
        int currentIndex = 0;
        int stringLength = string.length();
        if (line > 0) {
            int readLines = 0;
            while (currentIndex < stringLength) {
                char currentChar = string.charAt(currentIndex);
                if (currentChar == -1) {
                    return -1;
                }

                currentIndex++;

                if (currentChar == '\n') {

                    readLines++;

                    if (readLines == line) {
                        break;
                    }

                }
            }
        }
        return currentIndex + character;
    }

    public static Position getPosition(String string, int offset) {

        if (!isOffsetValid(string, offset)) {
            return null;
        }

        int lineNum = 0;
        int curCharIndex = 0;

        for (int i = 0; i < offset; i++) {
            char curChar = string.charAt(i);
            if (curChar == '\n') {
                lineNum++;
                curCharIndex = 0;
            } else {
                curCharIndex++;
            }
        }

        return new Position(lineNum, curCharIndex);
    }

    public static char getCharacterAtPosition(String string, Position position) {

        if (!isValid(position)) {
            return '0';
        }

        int offset = getOffset(string, position);
        if (offset > string.length() - 1) {
            return '0';
        } else {
            return string.charAt(offset);
        }
    }

    public static Range getWordRangeAtPosition(String string, Position position) {

        if (!isValid(position)) {
            return null;
        }

        int curCharNum = Positions.getOffset(string, position);
        int left = curCharNum - 1, right = curCharNum;

        while (left >= 0 && Pattern.matches("([a-zA-Z_])", Character.toString(string.charAt(left)))) {
            left--;
        }
        while (right < string.length() && Pattern.matches("([a-zA-Z_])", Character.toString(string.charAt(right)))) {
            right++;
        }

        int lineNum = position.getLine();
        return new Range(new Position(lineNum, left), new Position(lineNum, right));
    }

    public static String getWordAtPosition(String string, Position position) {

        if (!isValid(position)) {
            return null;
        }

        int curCharNum = Positions.getOffset(string, position);
        int left = curCharNum - 1, right = curCharNum;
        String word = "";

        String charStr;
        while (left >= 0 && Pattern.matches("([a-zA-Z_])", charStr = Character.toString(string.charAt(left)))) {
            word = charStr + word;
            left--;
        }
        while (right < string.length()
                && Pattern.matches("([a-zA-Z_])", charStr = Character.toString(string.charAt(right)))) {
            word += charStr;
            right++;
        }

        return word;
    }

    public static Range getWordRangeAtPosition(String string, Position position, String regex) {
        return null;
    }

    public static Range getWordAtPosition(String string, Position position, String regex) {
        return null;
    }

}