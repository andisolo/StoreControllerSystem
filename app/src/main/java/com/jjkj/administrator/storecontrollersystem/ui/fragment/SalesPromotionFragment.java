package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.SalesProMotionAdapter;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class SalesPromotionFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {
    @BindView(R.id.general_rcv)
    RecyclerView mGeneralRcv;
    Unbinder unbinder;
    private SalesProMotionAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_for_rcv, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().getOrders();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    private void initView() {
        mAdapter = new SalesProMotionAdapter(R.layout.item_for_normal_sales,
                new ArrayList<>());
        mGeneralRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.isFirstOnly(false);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mGeneralRcv.setAdapter(mAdapter);
    }

    @Override
    public void onLoadData(List<Order> orders) {
        mAdapter.replaceData(orders);
    }
}
