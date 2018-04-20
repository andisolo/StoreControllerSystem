package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.entity.Order;

import java.util.List;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class SalesProMotionAdapter extends BaseQuickAdapter<Order, BaseViewHolder> {
    public SalesProMotionAdapter(int layoutResId, @Nullable List<Order> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Order item) {
        helper.setText(R.id.item_for_normal_sales_name, "伙伴姓名:" + item.getSalesman().getName());
        helper.setText(R.id.item_for_normal_sales_money, "订单价格:" + item.getPrice());
        helper.setText(R.id.item_for_normal_sales_salesman, "顾客姓名:" + item.getCustomerName());
    }
}
