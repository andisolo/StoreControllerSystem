package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;

import java.util.List;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class ExperienceAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ExperienceAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_for_normal_sales_name, item);
        helper.setText(R.id.item_for_normal_sales_money, item);
        helper.setText(R.id.item_for_normal_sales_salesman, item);
    }
}
