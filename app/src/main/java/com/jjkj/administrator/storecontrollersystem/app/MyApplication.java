package com.jjkj.administrator.storecontrollersystem.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * @author Administrator
 */
public class MyApplication extends MultiDexApplication {
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
