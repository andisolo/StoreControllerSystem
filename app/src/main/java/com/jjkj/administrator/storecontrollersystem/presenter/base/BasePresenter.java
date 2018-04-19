package com.jjkj.administrator.storecontrollersystem.presenter.base;

import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

/**
 * P 层接口基类
 *
 * @author Administrator
 */
public class BasePresenter<V extends BaseView> {
    protected V mView;


    public void attachView(V mView) {
        this.mView = mView;
    }

    public void detachView() {
        mView = null;
    }
}
