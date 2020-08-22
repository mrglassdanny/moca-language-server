package com.github.mrglassdanny.mocalanguageserver.util.lsp;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class Ranges {
    public static boolean contains(Range range, Position position) {
        return Positions.COMPARATOR.compare(position, range.getStart()) >= 0
                && Positions.COMPARATOR.compare(position, range.getEnd()) <= 0;
    }

    public static boolean contains(Range range, Range smallerRange) {
        return Positions.COMPARATOR.compare(range.getStart(), smallerRange.getStart()) <= 0
                && Positions.COMPARATOR.compare(range.getEnd(), smallerRange.getEnd()) >= 0;
    }

    public static boolean intersect(Range r1, Range r2) {
        return contains(r1, r2.getStart()) || contains(r1, r2.getEnd());
    }

    public static String getText(String string, Range range) {

        if (string == null || string.isEmpty()) {
            return "";
        }

        if (range == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Position start = range.getStart();
        Position end = range.getEnd();

        int stringLength = string.length();
        int stoppingPoint = Positions.getOffset(string, end);
        for (int i = Positions.getOffset(string, start); i < stringLength && i < stoppingPoint; i++) {
            builder.append(string.charAt(i));
        }
        return builder.toString();
    }

}