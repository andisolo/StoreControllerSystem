package com.jjkj.administrator.storecontrollersystem.view.base;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import com.jjkj.administrator.storecontrollersystem.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * V层接口的基类
 *
 * @author Administrator
 */
public interface BaseView {
    List<Activity> ACTIVITY_LIST = new ArrayList<>();

    /**
     * 创建时把Activity保存到集合中
     *
     * @param activity 添加的Activity
     */
    default void addActivity(Activity activity) {

        ACTIVITY_LIST.add(activity);
    }

    /**
     * 销毁时移除Activity
     *
     * @param activity 添加的Activity
     */
    default void delActivity(Activity activity) {

        ACTIVITY_LIST.remove(activity);
    }

    /**
     * 关闭程序时移除所有Activity
     */
    default void delAllActivity() {

        for (Activity activity : ACTIVITY_LIST) {
            activity.finish();
        }
        ACTIVITY_LIST.clear();
    }

    /**
     * 显示信息
     *
     * @param info 信息
     */
    default void showInfo(String info) {
        if (ACTIVITY_LIST.size() > 0) {
            ToastUtils.showToast(ACTIVITY_LIST.get(ACTIVITY_LIST.size() - 1), info);
        }
    }

    /**
     * 获取栈顶的activity
     *
     * @return activity
     */
    default Context getMyContext() {
        if (ACTIVITY_LIST.size() <= 0) {
            return null;
        }
        return ACTIVITY_LIST.get(ACTIVITY_LIST.size() - 1);
    }

    /**
     * 获取栈顶的activity
     *
     * @return 手机的Meid
     */
    default String getPhoneNumber() {
        TelephonyManager manager = (TelephonyManager) getMyContext().getSystemService(Context
                .TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(getMyContext(), Manifest.permission.READ_SMS) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (getMyContext(),
                        Manifest.permission.READ_PHONE_NUMBERS) != PackageManager
                .PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getMyContext(), Manifest.permission
                        .READ_PHONE_STATE) !=
                        PackageManager.PERMISSION_GRANTED) {
            return "null";
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return manager != null ? manager.getMeid() : null;
        } else {
            return manager != null ? manager.getDeviceId() : null;
        }
    }
}
