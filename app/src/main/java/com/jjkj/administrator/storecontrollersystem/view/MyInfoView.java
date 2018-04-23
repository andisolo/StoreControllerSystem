package com.jjkj.administrator.storecontrollersystem.view;

import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

import java.util.List;

/**
 * @author Administrator
 */
public interface MyInfoView extends BaseView {
    /**
     * 获取到String数据时调用
     *
     * @param info 数据
     */

    void onLoadStringData(String info);

    /**
     * 获取到Goods数据时调用
     *
     * @param goods 数据
     */
    void onGetGoods(List<String> goods);
}
