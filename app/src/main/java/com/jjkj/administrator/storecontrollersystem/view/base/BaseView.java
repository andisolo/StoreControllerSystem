package com.jjkj.administrator.storecontrollersystem.view.base;

import android.app.Activity;
import android.content.Context;

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
	default Context getContext() {
		if (ACTIVITY_LIST.size() <= 0) {
			return null;
		}
		return ACTIVITY_LIST.get(ACTIVITY_LIST.size() - 1);
	}
}
