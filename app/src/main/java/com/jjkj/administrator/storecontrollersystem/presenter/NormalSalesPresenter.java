package com.jjkj.administrator.storecontrollersystem.presenter;

import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;

/**
 * @author Administrator
 */
public class NormalSalesPresenter extends BasePresenter<MainView> {
    @Override
    protected void initInject() {
        getComponent().inject(this);
    }
}
