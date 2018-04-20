package com.jjkj.administrator.storecontrollersystem.view;

import com.jjkj.administrator.storecontrollersystem.entity.User;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

import java.util.List;

/**
 * @author Administrator
 */
public interface PartnerView extends BaseView {
    /**
     * 获取所有的售货员
     *
     * @param users 售货员明细
     */
    void onLoadUser(List<User> users);

    /**
     * 加载成功时调用
     *
     * @param info 信息
     */
    void onSucceed(String info);
}
