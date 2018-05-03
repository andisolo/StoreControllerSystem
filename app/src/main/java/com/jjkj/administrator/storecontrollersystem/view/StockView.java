package com.jjkj.administrator.storecontrollersystem.view;

import com.jjkj.administrator.storecontrollersystem.bean.StockResult;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

/**
 * @author Guo JiaMing
 */
public interface StockView extends BaseView {

    /**
     * 加载到库存时调用
     *
     * @param result StockResult
     */
    void onLoadStock(StockResult result);

    /**
     * 数据加载失败时调用
     *
     * @param info info
     */
    void onFailed(String info);
}
