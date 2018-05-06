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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.CustomerServiceAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.AfterSalesServiceResult;
import com.jjkj.administrator.storecontrollersystem.presenter.CustomerPresenter;
import com.jjkj.administrator.storecontrollersystem.utils.ToastUtils;
import com.jjkj.administrator.storecontrollersystem.view.CustomerView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Guo JiaMing
 */
public class ServiceFragment extends BaseFragment<CustomerView, CustomerPresenter>
		implements CustomerView {

	Unbinder unbinder;
	@BindView(R.id.service_rcv)
	RecyclerView mServiceRcv;
	@BindView(R.id.service_swl)
	SwipeRefreshLayout mServiceSwl;
	private CustomerServiceAdapter mAdapter;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle sedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_service, container, false);
		unbinder = ButterKnife.bind(this, view);
		initView();
		return view;
	}

	private void initView() {
		mServiceRcv.setLayoutManager(new LinearLayoutManager(getContext()));
		mAdapter = new CustomerServiceAdapter(R.layout
				.item_for_customer_service_rcv, new ArrayList<>());
		mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mAdapter.isFirstOnly(false);
		mServiceRcv.setAdapter(mAdapter);
		mServiceSwl.setOnRefreshListener(() -> getPresenter().loadCustomerService());
		getPresenter().loadCustomerService();
	}


	@Override
	public void onCustomerLoad(AfterSalesServiceResult result) {
		if (mServiceSwl.isRefreshing()) {
			mServiceSwl.setRefreshing(false);
		}
		mAdapter.replaceData(result.getCustomer());
	}

	@Override
	public void onCustomerLoadFailed(String info) {
		if (mServiceSwl.isRefreshing()) {
			mServiceSwl.setRefreshing(false);
		}
		ToastUtils.showToast(getContext(), info);
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
