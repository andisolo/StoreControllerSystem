package com.jjkj.administrator.storecontrollersystem.view.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.jjkj.administrator.storecontrollersystem.di.component.DaggerFragmentComponent;
import com.jjkj.administrator.storecontrollersystem.di.component.FragmentComponent;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment
        implements BaseView {
    @Inject
    protected P mPresenter;



    @Override
    public void onAttach(Context context) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        super.onAttach(context);
    }

    /**
     * 注入当前Fragment所需的依赖
     */
    protected abstract void initInject();

    protected FragmentComponent getComponent() {
        return DaggerFragmentComponent.builder().build();
    }

    protected P getPresenter() {
        return mPresenter;
    }
}
