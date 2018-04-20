package com.jjkj.administrator.storecontrollersystem.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
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
