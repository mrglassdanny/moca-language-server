package com.github.mrglassdanny.mocalanguageserver.moca.trace;

public class MocaTraceOutlineOptions {

    public boolean useLogicalIndentStrategy;
    public double minimumExecutionTime;

    public MocaTraceOutlineOptions(boolean useLogicalIndentStrategy, double minimumExecutionTime) {
        this.useLogicalIndentStrategy = useLogicalIndentStrategy;
        this.minimumExecutionTime = minimumExecutionTime;
    }

}
