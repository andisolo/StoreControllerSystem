package com.jjkj.administrator.storecontrollersystem.model;

import android.util.Log;

import javax.inject.Inject;

/**
 * M层
 *
 * @author Administrator
 */
public class UserBiz {
    @Inject
    public UserBiz() {
    }

    public void getData() {
        Log.i("UserBiz", "getData");
    }
}
