package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.ExperienceAdapter;

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
public class ExperienceFragment extends Fragment {
	@BindView(R.id.general_rcv)
	RecyclerView mGeneralRcv;
	Unbinder unbinder;

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
		List<String> data = new ArrayList<>();
		ExperienceAdapter adapter = new ExperienceAdapter(R.layout.item_for_normal_sales, data);
		mGeneralRcv.setLayoutManager(new LinearLayoutManager(getContext()));
		adapter.isFirstOnly(false);
		adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mGeneralRcv.setAdapter(adapter);
		List<String> strings = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			strings.add("测试数据" + i);
		}
		adapter.addData(strings);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}
