package com.github.mrglassdanny.mocalanguageserver.moca.cache;

import com.github.mrglassdanny.mocalanguageserver.moca.cache.moca.*;
import com.github.mrglassdanny.mocalanguageserver.moca.cache.mocasql.*;

public class Cache {

    
    public MocaCache mocaCache;
    public MocaSqlCache mocaSqlCache;

    public Cache() {
        this.mocaCache = new MocaCache();
        this.mocaSqlCache = new MocaSqlCache();
    }

}
