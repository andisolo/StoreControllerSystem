package com.jjkj.administrator.storecontrollersystem.presenter;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;

/**
 * @author Administrator
 */
public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter() {
        Log.i("MainPresenter", "new");
    }

    public void getData() {
        Log.i("MainPresenter", "onLoadData");
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }
}
