package com.jjkj.administrator.storecontrollersystem.view;

import com.jjkj.administrator.storecontrollersystem.bean.SlipResult;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

/**
 * @author Administrator
 */
public interface MainView extends BaseView {

    /**
     * 加载数据
     *
     * @param orders 加载到的订单数据
     */
    void onLoadData(SlipResult orders);

    /**
     * 加载数据
     */
    void onFailed();
}
