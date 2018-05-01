package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.DoSalesAdapter;
import com.jjkj.administrator.storecontrollersystem.adapter.FilterAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.bean.PersonResult;
import com.jjkj.administrator.storecontrollersystem.bean.SalesEntry;
import com.jjkj.administrator.storecontrollersystem.bean.SalesSlip;
import com.jjkj.administrator.storecontrollersystem.presenter.MyInfoPresenter;
import com.jjkj.administrator.storecontrollersystem.utils.ToastUtils;
import com.jjkj.administrator.storecontrollersystem.view.MyInfoView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 */
public class DoSalesFragment extends BaseFragment<MyInfoView, MyInfoPresenter> implements
		MyInfoView {

	Unbinder unbinder;
	@BindView(R.id.do_sales_main_rcv)
	RecyclerView mDoSalesMainRcv;
	@BindView(R.id.do_sales_goods_name)
	AutoCompleteTextView mDoSalesGoodsName;
	@BindView(R.id.do_sales_goods_number)
	TextInputEditText mDoSalesGoodsNumber;
	@BindView(R.id.do_sales_vip_number)
	TextInputEditText mDoSalesVipNumber;
	@BindView(R.id.do_sales_title_cancel)
	TextView mDoSalesTitleCancel;
	@BindView(R.id.do_sales_title_done)
	TextView mDoSalesTitleDone;
	@BindView(R.id.do_sales_goods_name_hint)
	TextInputLayout mDoSalesGoodsNameHint;
	private DoSalesAdapter mAdapter;
	private FilterAdapter<String> mArrayAdapter;
	private Map<String, Goods> mGoodsMap;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_do_sales, container, false);
		unbinder = ButterKnife.bind(this, view);
		initView();
		return view;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}


	@SuppressLint("InflateParams")
	private void initView() {
		mAdapter = new DoSalesAdapter(R.layout.item_for_general_rcv_do_sales, new ArrayList<>());
		mAdapter.isFirstOnly(false);
		mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mDoSalesMainRcv.setLayoutManager(new LinearLayoutManager(getContext()));
		mDoSalesMainRcv.setAdapter(mAdapter);
		if (getContext() == null) {
			return;
		}
		ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(mAdapter);
		ItemTouchHelper helper = new ItemTouchHelper(callback);
		helper.attachToRecyclerView(mDoSalesMainRcv);
		View empty = getLayoutInflater().inflate(R.layout.empty_view_for_rcv, null);
		mAdapter.setEmptyView(empty);
		View footView = getLayoutInflater().inflate(R.layout.done_and_cancel_view_for_rcv, null);
		footView.findViewById(R.id.done_and_cancel_view_done).setOnClickListener(v ->
				DoSalesFragment.this.getPresenter().saveOrders(mAdapter.getSalesSlip()));
		footView.findViewById(R.id.done_and_cancel_view_cancel).setOnClickListener(v ->
				Objects.requireNonNull(getActivity()).finish());
		mAdapter.addFooterView(footView);
		mAdapter.enableSwipeItem();
		mAdapter.setOnItemSwipeListener(new OnItemSwipeListener() {
			@Override
			public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
				ToastUtils.showToast(getContext(), "向右滑动删除所选项目");
			}

			@Override
			public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {

			}

			@Override
			public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
				mAdapter.remove(viewHolder.getLayoutPosition());
			}

			@Override
			public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder,
			                              float dX, float dY, boolean isCurrentlyActive) {

			}
		});
		mArrayAdapter = new FilterAdapter<>(getContext(), android.R.layout.simple_list_item_1,
				new ArrayList<>());
		mDoSalesGoodsName.setAdapter(mArrayAdapter);
		getPresenter().getGoods(getResources().openRawResource(R.raw.goods_list));
		mDoSalesTitleDone.setOnClickListener(v -> {
			if (mGoodsMap != null) {
				if ("".equals(mDoSalesGoodsName.getText().toString()) || "".equals
						(mDoSalesGoodsNumber.getText().toString())) {
					ToastUtils.showToast(getContext(), "必填项不能为空");
					return;
				}
				SalesEntry salesEntry = new SalesEntry();
				salesEntry.setCommodityName(mDoSalesGoodsName.getText().toString());
				salesEntry.setCommodityQuantity(Integer.valueOf(mDoSalesGoodsNumber.getText()
						.toString()));
				for (Map.Entry<String, Goods> entry : mGoodsMap.entrySet()) {
					if (entry.getValue().getName().equals(mDoSalesGoodsName.getText()
							.toString())) {
						double i = Double.valueOf(entry.getValue().getPrice()) * Double.valueOf
								(mDoSalesGoodsNumber.getText().toString());
						salesEntry.setTotalCommodityPrice(i);
						salesEntry.setCommodityCode(entry.getKey());
						break;
					}
				}
				salesEntry.setSalesType("销售");
				mAdapter.addData(salesEntry);
				SalesSlip salesSlip = new SalesSlip();
				salesSlip.setCustomerName("测试用顾客姓名");
				salesSlip.setCustomerPhone(mDoSalesVipNumber.getText().toString());
				for (SalesEntry entry : mAdapter.getData()) {
					Double price = salesSlip.getPrice();
					if (price == null) {
						price = 0.0;
					}
					salesSlip.setPrice(price + entry.getTotalCommodityPrice());
				}
				salesSlip.setStyle("正常销售");
				salesSlip.setSalesPerson(getPhoneNumber());
				mAdapter.setSalesSlip(salesSlip);
				defView();
				ToastUtils.showToast(getContext(), "成功添加");
			}
		});
		mDoSalesTitleCancel.setOnClickListener(v -> defView());
		mDoSalesGoodsName.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if ("".equals(s.toString())) {
					mDoSalesGoodsNameHint.setHint("商品名称");
					return;
				}
				if (mGoodsMap != null) {
					for (Map.Entry<String, Goods> entry : mGoodsMap.entrySet()) {
						if (entry.getValue().getName().equals(s.toString())) {
							mDoSalesGoodsNameHint.setHint(entry.getKey());
							return;
						}
						if (entry.getKey().equals(s.toString())) {
							mDoSalesGoodsName.setText(entry.getValue().getName());
							mDoSalesGoodsNameHint.setHint(entry.getKey());
							break;
						}
					}
				}
			}
		});
	}

	private void defView() {
		mDoSalesGoodsNumber.setText("");
		mDoSalesGoodsName.setText("");
		mDoSalesGoodsNameHint.setHint("商品名称");
	}

	@Override
	protected void initInject() {
		getComponent().inject(this);
	}


	@Override
	public void showInfo(String info) {
		ToastUtils.showToast(getContext(), info);
		mAdapter.replaceData(new ArrayList<>());
	}

	@Override
	public void onLoadStringData(String info) {

	}

	@Override
	public void onGetGoods(Map<String, Goods> goods) {
		mGoodsMap = goods;
		mArrayAdapter.clear();
		for (Map.Entry<String, Goods> goodsEntry : goods.entrySet()) {
			mArrayAdapter.add(goodsEntry.getValue().getName());
			mArrayAdapter.add(goodsEntry.getValue().getNumber());
		}
		mArrayAdapter.notifyDataSetChanged();
	}

	@Override
	public void onGetPerson(PersonResult personResult) {

	}

	private String getPhoneNumber() {
		TelephonyManager manager = (TelephonyManager) getContext().getSystemService(Context
				.TELEPHONY_SERVICE);
		if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_SMS) !=
				PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
				(getContext(),
						Manifest.permission.READ_PHONE_NUMBERS) != PackageManager
				.PERMISSION_GRANTED &&
				ActivityCompat.checkSelfPermission(getContext(), Manifest.permission
						.READ_PHONE_STATE) !=
						PackageManager.PERMISSION_GRANTED) {
			return "null";
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			return manager != null ? manager.getMeid() : null;
		} else {
			return manager != null ? manager.getDeviceId() : null;
		}
	}
}
