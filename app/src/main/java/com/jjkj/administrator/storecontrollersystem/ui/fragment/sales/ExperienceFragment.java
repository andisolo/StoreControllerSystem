package com.jjkj.administrator.storecontrollersystem.ui.fragment.sales;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.ExperienceAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.SlipResult;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class ExperienceFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {
    @BindView(R.id.general_rcv)
    RecyclerView mGeneralRcv;
    Unbinder unbinder;
    @BindView(R.id.general_swl)
    SwipeRefreshLayout mGeneralSwl;
    private ExperienceAdapter mAdapter;
    private Map<String, String> mMap;

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
        getPresenter().getOrders(mMap);
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
        mMap = new HashMap<>(1);
        mMap.put("style", "免费体验");
        mAdapter = new ExperienceAdapter(R.layout.item_for_normal_sales, new ArrayList<>());
        mGeneralRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.isFirstOnly(false);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mGeneralRcv.setAdapter(mAdapter);
        mGeneralSwl.setOnRefreshListener(() -> getPresenter().getOrders(mMap));
    }


    @Override
    public void onLoadData(SlipResult orders) {
        if (mGeneralSwl != null && mGeneralSwl.isRefreshing()) {
            mGeneralSwl.setRefreshing(false);
        }
        mAdapter.replaceData(orders.getSalesSlip());
    }

    @Override
    public void onFailed() {
        if (mGeneralSwl != null && mGeneralSwl.isRefreshing()) {
            mGeneralSwl.setRefreshing(false);
        }
    }
}
