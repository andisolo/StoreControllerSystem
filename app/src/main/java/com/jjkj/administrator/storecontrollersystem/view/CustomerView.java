package com.jjkj.administrator.storecontrollersystem.view;

import com.jjkj.administrator.storecontrollersystem.bean.AfterSalesServiceResult;
import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

/**
 * @author Guo JiaMing
 */
public interface CustomerView extends BaseView {

    /**
     * 数据加载成功时调用
     * 空实现,实现类需要重写
     *
     * @param result 结果
     */
    default void onCustomerLoad(CustomerResult result) {
    }

    /**
     * 数据加载成功时调用
     * 空实现,实现类需要重写
     *
     * @param result 结果
     */
    default void onCustomerLoad(AfterSalesServiceResult result) {
    }

    /**
     * 数据加载失败时调用
     * 空实现,实现类需要重写
     *
     * @param info 结果
     */
    default void onCustomerLoadFailed(String info) {
    }
}
