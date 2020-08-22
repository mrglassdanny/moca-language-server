package com.github.mrglassdanny.mocalanguageserver.moca;

public class MocaResults {

    // metadata index info:
    // 0 - name
    // 1 - type
    // 2 - length
    public Object[][] metadata;
    public Object[][] values;

    // Row index starts at 0!
    public String getString(int rowIdx, String columnName) {
        if (this.values.length < rowIdx) {
            return null;
        }

        int foundColumnIdx = -1;
        for (int columnIdx = 0; columnIdx < this.metadata.length; columnIdx++) {
            if (this.metadata[columnIdx][0].toString().compareToIgnoreCase(columnName) == 0) {
                foundColumnIdx = columnIdx;
                break;
            }
        }

        if (foundColumnIdx == -1) {
            return null;
        }

        return this.values[rowIdx][foundColumnIdx].toString();
    }

    public int getInt(int rowIdx, String columnName) {
        if (this.values.length < rowIdx) {
            return -1;
        }

        int foundColumnIdx = -1;
        for (int columnIdx = 0; columnIdx < this.metadata.length; columnIdx++) {
            if (this.metadata[columnIdx][0].toString().compareToIgnoreCase(columnName) == 0) {
                foundColumnIdx = columnIdx;
                break;
            }
        }

        if (foundColumnIdx == -1) {
            return -1;
        }

        return (int) this.values[rowIdx][foundColumnIdx];
    }

    public boolean getBoolean(int rowIdx, String columnName) {
        if (this.values.length < rowIdx) {
            return false;
        }

        int foundColumnIdx = -1;
        for (int columnIdx = 0; columnIdx < this.metadata.length; columnIdx++) {
            if (this.metadata[columnIdx][0].toString().compareToIgnoreCase(columnName) == 0) {
                foundColumnIdx = columnIdx;
                break;
            }
        }

        if (foundColumnIdx == -1) {
            return false;
        }

        return (boolean) this.values[rowIdx][foundColumnIdx];
    }

}
