package com.jjkj.administrator.storecontrollersystem.presenter.base;

import com.jjkj.administrator.storecontrollersystem.di.component.DaggerPresenterComponent;
import com.jjkj.administrator.storecontrollersystem.di.component.PresenterComponent;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

/**
 * P 层接口基类
 *
 * @author Administrator
 */
public abstract class BasePresenter<V extends BaseView> {
    private V mView;


    public void attachView(V mView) {
        initInject();
        this.mView = mView;
    }

    /**
     * 初始化对象注入
     */
    protected abstract void initInject();

    public void detachView() {
        mView = null;
    }

    protected PresenterComponent getComponent() {
        return DaggerPresenterComponent.builder().build();
    }

    protected V getMvpView() {
        return mView;
    }
}
