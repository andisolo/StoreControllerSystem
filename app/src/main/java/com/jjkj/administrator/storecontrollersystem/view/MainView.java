package com.jjkj.administrator.storecontrollersystem.view;

import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

import java.util.List;

/**
 * @author Administrator
 */
public interface MainView extends BaseView {

    /**
     * 加载数据
     *
     * @param orders 加载到的订单数据
     */
    void onLoadData(List<Order> orders);
}
