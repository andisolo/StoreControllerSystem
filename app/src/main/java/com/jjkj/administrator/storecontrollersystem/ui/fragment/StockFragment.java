package com.jjkj.administrator.storecontrollersystem.ui.fragment;

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
import com.jjkj.administrator.storecontrollersystem.adapter.StockAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.StockResult;
import com.jjkj.administrator.storecontrollersystem.presenter.StockPresenter;
import com.jjkj.administrator.storecontrollersystem.utils.ToastUtils;
import com.jjkj.administrator.storecontrollersystem.view.StockView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Guo JiaMing
 */
public class StockFragment extends BaseFragment<StockView, StockPresenter> implements StockView {
    @BindView(R.id.stock_rcv)
    RecyclerView mStockRcv;
    Unbinder unbinder;
    @BindView(R.id.stock_swl)
    SwipeRefreshLayout mStockSwl;
    private StockAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().loadStock();
    }

    private void initView() {
        mStockRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new StockAdapter(R.layout.item_for_stock_rcv, new ArrayList<>());
        mAdapter.isFirstOnly(false);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mStockRcv.setAdapter(mAdapter);
        mStockSwl.setOnRefreshListener(() -> getPresenter().loadStock());
        mAdapter.setOnItemLongClickListener((adapter, view, position) -> {
            Map<String, String> map = mAdapter.getStock(position);
            map.put("person", getPhoneNumber());
            getPresenter().updateStock(map);
            return true;
        });
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadStock(StockResult result) {
        mAdapter.replaceData(result.getStock());
    }

    @Override
    public void onFailed(String info) {
        if (mStockSwl != null && mStockSwl.isRefreshing()) {
            mStockSwl.setRefreshing(false);
        }
        ToastUtils.showToast(getContext(), info);
    }
}
