package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.annotation.SuppressLint;
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
import com.jjkj.administrator.storecontrollersystem.adapter.DoSalesAdapter;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 */
public class DoSalesFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {


    @BindView(R.id.general_rcv)
    RecyclerView mGeneralRcv;
    Unbinder unbinder;
    private DoSalesAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_for_rcv, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @SuppressLint("InflateParams")
    private void initView() {
        mAdapter = new DoSalesAdapter(R.layout.item_for_general_rcv_do_sales, new
                ArrayList<>());
        mAdapter.isFirstOnly(false);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        View headView = getLayoutInflater().inflate(R.layout.done_and_cancel_view_for_rcv, null);
        headView.findViewById(R.id.done_and_cancel_view_done).setOnClickListener(v ->
                getPresenter().addOrders(mAdapter.getData(), "我是顾客的名字"));
        mAdapter.addHeaderView(headView);
        View footView = getLayoutInflater().inflate(R.layout.foot_view_for_rcv_add, null);
        mAdapter.addFooterView(footView);
        footView.setOnClickListener(v -> mAdapter.addData(new OrderItem()));
        mGeneralRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mGeneralRcv.setAdapter(mAdapter);
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }


    @Override
    public void onLoadData(List<Order> orders) {

    }

    @Override
    public void showInfo(String info) {
        mAdapter.replaceData(new ArrayList<>());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
