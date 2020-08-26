package com.github.mrglassdanny.mocalanguageserver.moca.cache.schema;

public class TableColumn {
    public String table_name;
    public String column_name;
    public String lngdsc;
    public String comtyp;
    public int length;
    public boolean null_flg;
    public boolean pk_flg;
    public boolean ident_flg;
    public String column_comment;
    public String documentationStr;

    public TableColumn(String table_name, String column_name, String lngdsc, String comtyp, int length,
            boolean null_flg, boolean pk_flg, boolean ident_flg, String column_comment) {
        this.table_name = table_name.toLowerCase(); // We want all database entities lower case.
        this.column_name = column_name.toLowerCase(); // We want all database entities lower case.
        this.lngdsc = lngdsc;
        this.comtyp = comtyp;
        this.length = length;
        this.null_flg = null_flg;
        this.pk_flg = pk_flg;
        this.ident_flg = ident_flg;
        this.column_comment = column_comment;

        this.setDocumentationString();
    }

    private void setDocumentationString() {
        this.documentationStr = "";
        String dataTypeDescription;
        switch (this.comtyp) {
            case "S":
                dataTypeDescription = "String(" + this.length + ")";
                break;
            case "D":
                dataTypeDescription = "Date";
                break;
            case "F":
                dataTypeDescription = "Numeric";
                break;
            case "I":
                if (this.column_name.contains("flg")) {
                    dataTypeDescription = "Boolean";
                } else {
                    dataTypeDescription = "Integer";
                }
                break;
            default:
                dataTypeDescription = this.comtyp;
                break;
        }

        this.documentationStr += dataTypeDescription;
        this.documentationStr += "\t\t";

        if (this.pk_flg) {
            this.documentationStr += "PK\t";
        }
        if (!this.null_flg) {
            this.documentationStr += "Not Null\t";
        }
        if (this.ident_flg) {
            this.documentationStr += "Identity";
        }

        this.documentationStr += "\n";
        this.documentationStr += this.column_comment;
    }
}