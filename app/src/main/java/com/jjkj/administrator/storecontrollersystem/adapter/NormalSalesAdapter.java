package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.SalesSlip;

import java.util.List;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class NormalSalesAdapter extends BaseQuickAdapter<SalesSlip, BaseViewHolder> {
	public NormalSalesAdapter(int layoutResId, @Nullable List<SalesSlip> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, SalesSlip item) {
		helper.setText(R.id.item_for_normal_sales_name, "伙伴姓名:" + item.getSalesPerson());
		helper.setText(R.id.item_for_normal_sales_money, "订单价格:" + item.getPrice());
		helper.setText(R.id.item_for_normal_sales_salesman, "顾客姓名:" + item.getCustomerName());
	}
}
