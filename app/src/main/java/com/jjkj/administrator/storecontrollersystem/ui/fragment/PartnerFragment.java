package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.annotation.SuppressLint;
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
import com.jjkj.administrator.storecontrollersystem.adapter.PartnerAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.PersonResult;
import com.jjkj.administrator.storecontrollersystem.presenter.PartnerPresenter;
import com.jjkj.administrator.storecontrollersystem.utils.ToastUtils;
import com.jjkj.administrator.storecontrollersystem.view.PartnerView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class PartnerFragment extends BaseFragment<PartnerView, PartnerPresenter> implements
		PartnerView {
	@BindView(R.id.partner_rcv)
	RecyclerView mPartnerRcv;
	Unbinder unbinder;
	@BindView(R.id.partner_swl)
	SwipeRefreshLayout mPartnerSwl;
	private PartnerAdapter mAdapter;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_partner, container, false);
		unbinder = ButterKnife.bind(this, view);
		initView();
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		getPresenter().getUsers();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	@SuppressLint("InflateParams")
	private void initView() {
		mPartnerRcv.setLayoutManager(new LinearLayoutManager(getContext()));
		mAdapter = new PartnerAdapter(R.layout.item_for_partner_rcv, new
				ArrayList<>());
		mAdapter.isFirstOnly(false);
		mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mPartnerRcv.setAdapter(mAdapter);
		mPartnerSwl.setOnRefreshListener(() -> getPresenter().getUsers());
	}

	@Override
	protected void initInject() {
		getComponent().inject(this);
	}


	@Override
	public void onLoadUser(PersonResult users) {
		mAdapter.replaceData(users.getPerson());
	}

	@Override
	public void onSucceed(String info) {
		getPresenter().getUsers();
		ToastUtils.showToast(getContext(), info);
		if (mPartnerSwl != null && mPartnerSwl.isRefreshing()) {
			mPartnerSwl.setRefreshing(false);
		}
	}

	@Override
	public void showInfo(String info) {
		ToastUtils.showToast(getContext(), info);
		if (mPartnerSwl != null && mPartnerSwl.isRefreshing()) {
			mPartnerSwl.setRefreshing(false);
		}
	}
}
