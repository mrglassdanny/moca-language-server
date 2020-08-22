package com.github.mrglassdanny.mocalanguageserver.moca.lang;

import java.util.List;

import com.redprairie.moca.server.exec.CommandArg;

// 'Struct' classes for public access.
public class CommandUnitStruct {
    public String sql;
    public String script;
    public boolean override;
    public String verbNounClause;
    public String language;
    public List<CommandArg> argList;

    public CommandUnitStruct(String sql, String script, boolean override, String verbNounClause, String language,
            List<CommandArg> argList) {
        this.sql = sql;
        this.script = script;
        this.override = override;
        this.verbNounClause = verbNounClause;
        this.language = language;
        this.argList = argList;
    }

}