package com.jjkj.administrator.storecontrollersystem.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Administrator
 * @date 2018/3/21
 */

public class ToastUtils {
    private ToastUtils() {
    }

    private static Toast mToast;

    public static void showToast(Context context, String info) {
        if (mToast != null) {
            mToast.cancel();
            mToast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
            mToast.show();
        } else {
            mToast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
            mToast.show();
        }
    }
}
