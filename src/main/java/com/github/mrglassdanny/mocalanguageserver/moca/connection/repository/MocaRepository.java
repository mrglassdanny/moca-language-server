package com.github.mrglassdanny.mocalanguageserver.moca.connection.repository;

import java.util.concurrent.CompletableFuture;

import com.github.mrglassdanny.mocalanguageserver.moca.connection.MocaConnectionWrapper;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.repository.database.*;
import com.github.mrglassdanny.mocalanguageserver.moca.connection.repository.moca.*;

public class MocaRepository {

    public DatabaseSchema databaseSchema;
    public CommandRepository commandRepository;

    public MocaRepository() {
        this.databaseSchema = new DatabaseSchema();
        this.commandRepository = new CommandRepository();
    }

    public void loadAsync(MocaConnectionWrapper conn) {
        CompletableFuture.runAsync(() -> {
            this.databaseSchema.loadAsync(conn);
        });

        CompletableFuture.runAsync(() -> {
            this.commandRepository.loadAsync(conn);
        });
    }

}
