package com.olegsagenadatrytwo.w5_d3_timberzxingurbanairship;

/**
 * Created by omcna on 8/30/2017.
 */

import android.content.Context;

public class SingletonSavesContext {
    private Context context;
    private static SingletonSavesContext instance;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static SingletonSavesContext getInstance() {
        if (instance == null) {
            instance = new SingletonSavesContext();
        }
        return instance;
    }
}