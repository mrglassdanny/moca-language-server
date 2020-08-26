package com.github.mrglassdanny.mocalanguageserver.moca.cache;

import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.*;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.schema.*;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnectionWrapper;

public class MocaCache {

    public Schema schema;
    public CommandRepository commandRepository;

    public MocaCache() {
        this.schema = new Schema();
        this.commandRepository = new CommandRepository();
    }

    public void loadAsync(MocaConnectionWrapper conn) {
        CompletableFuture.runAsync(() -> {
            this.schema.loadAsync(conn);
        });

        CompletableFuture.runAsync(() -> {
            this.commandRepository.loadAsync(conn);
        });
    }

}
