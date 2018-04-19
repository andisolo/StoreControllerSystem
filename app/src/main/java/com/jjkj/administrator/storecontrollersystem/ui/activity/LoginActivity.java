package com.jjkj.administrator.storecontrollersystem.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.presenter.LoginPresenter;
import com.jjkj.administrator.storecontrollersystem.view.LoginView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseActivity;

/**
 * @author Administrator
 */
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements
        LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getData();
    }

    @Override
    public void onGetData() {
        Log.i("LoginActivity", "onGetData");
    }
}
