package com.jjkj.administrator.storecontrollersystem.view;

import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

/**
 * @author Guo JiaMing
 */
public interface CustomerView extends BaseView {

	/**
	 * 数据加载成功时调用
	 *
	 * @param result 结果
	 */
	default void onCustomerLoad(CustomerResult result) {
	}

	default void onCustomerFailed(String info) {}
}
