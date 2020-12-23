package com.github.mrglassdanny.mocalanguageserver.moca.trace;

public class MocaTraceOutlineOptions {

    public boolean useLogicalIndentStrategy;
    public double minimumExecutionTime;
    public boolean viewRelativeLog;

    public MocaTraceOutlineOptions(boolean useLogicalIndentStrategy, double minimumExecutionTime,
            boolean viewRelativeLog) {
        this.useLogicalIndentStrategy = useLogicalIndentStrategy;
        this.minimumExecutionTime = minimumExecutionTime;
        this.viewRelativeLog = viewRelativeLog;
    }

}
