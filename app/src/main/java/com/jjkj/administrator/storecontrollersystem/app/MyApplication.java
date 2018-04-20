package com.jjkj.administrator.storecontrollersystem.app;

import android.app.Application;
import android.content.Context;

/**
 * @author Administrator
 */
public class MyApplication extends Application {
    private static Context sContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getBaseContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
