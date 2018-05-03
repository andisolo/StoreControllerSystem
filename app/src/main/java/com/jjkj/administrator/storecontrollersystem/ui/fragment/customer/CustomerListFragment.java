package com.jjkj.administrator.storecontrollersystem.ui.fragment.customer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.CustomerAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.presenter.CustomerPresenter;
import com.jjkj.administrator.storecontrollersystem.view.CustomerView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Guo JiaMing
 */
public class CustomerListFragment extends BaseFragment<CustomerView, CustomerPresenter>
        implements CustomerView {
    @BindView(R.id.general_rcv)
    RecyclerView mGeneralRcv;
    @BindView(R.id.general_swl)
    SwipeRefreshLayout mGeneralSwl;
    Unbinder unbinder;
    private CustomerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_for_rcv, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mAdapter = new CustomerAdapter(R.layout.item_for_customer_rcv, new
                ArrayList<>());
        mGeneralRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mGeneralRcv.setAdapter(mAdapter);
        mGeneralSwl.setOnRefreshListener(() -> getPresenter().loadCustomer());
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().loadCustomer();
    }

    @Override
    public void onCustomerLoad(CustomerResult result) {
        mAdapter.replaceData(result.getCustomer());
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
}
