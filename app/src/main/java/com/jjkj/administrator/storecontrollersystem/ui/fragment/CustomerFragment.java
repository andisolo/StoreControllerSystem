package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.List;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class CustomerFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer, container, false);
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }


    @Override
    public void onLoadData(List<Order> orders) {

    }
}
