package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.Customer;

import java.util.List;

/**
 * @author Guo JiaMing
 */
public class CustomerAdapter extends BaseQuickAdapter<Customer, BaseViewHolder> {
    public CustomerAdapter(int layoutResId, @Nullable List<Customer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Customer item) {
        helper.setText(R.id.item_for_customer_name, "顾客姓名:" + item.getName());
        helper.setText(R.id.item_for_customer_age, "顾客年龄:" + item.getAge());
        helper.setText(R.id.item_for_customer_phone, "顾客电话:" + item.getPhone());
    }
}
