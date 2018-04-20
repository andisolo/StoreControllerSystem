package com.jjkj.administrator.storecontrollersystem.presenter;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.model.UserBiz;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.LoginView;

import javax.inject.Inject;

/**
 * P层实现
 *
 * @author Administrator
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    @Inject
    UserBiz mUserBiz;

    public LoginPresenter() {
        Log.i("LoginPresenter", "new");

    }

    public void getData() {
        Log.i("LoginPresenter", "onLoadData");
        mUserBiz.getData();
        getMvpView().onGetData();
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }
}
