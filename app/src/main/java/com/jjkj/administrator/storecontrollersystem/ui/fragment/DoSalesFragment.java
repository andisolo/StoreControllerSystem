package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

/**
 * @author Administrator
 */
public class DoSalesFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.general_for_rcv, container, false);
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    public void getData() {

    }
}
