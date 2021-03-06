package com.jjkj.administrator.storecontrollersystem.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jjkj.administrator.storecontrollersystem.di.component.ActivityComponent;
import com.jjkj.administrator.storecontrollersystem.di.component.DaggerActivityComponent;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * Activity基类
 *
 * @author Administrator
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends
        AppCompatActivity implements BaseView {
    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        addActivity(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        delActivity(this);
        super.onDestroy();
    }

    /**
     * 注入当前Activity所需的依赖
     */
    protected abstract void initInject();

    protected ActivityComponent getComponent() {
        return DaggerActivityComponent.builder().build();
    }

    protected P getPresenter() {
        return mPresenter;
    }
}
