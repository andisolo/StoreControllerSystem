package com.jjkj.administrator.storecontrollersystem.presenter;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.LoginView;

/**
 * P层实现
 *
 * @author Administrator
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter() {
        Log.i("LoginPresenter", "new");

    }

    public void getData() {
        Log.i("LoginPresenter", "getData");
        mView.onGetData();
    }
}
