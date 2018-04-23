package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;

import java.util.List;

/**
 * @author Administrator
 */
public class DoSalesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DoSalesAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_for_general_rcv_do_sales_goods, item);
        helper.setText(R.id.item_for_general_rcv_do_sales_price, item);
        helper.setText(R.id.item_for_general_rcv_do_sales_number, item);
        EditText view = helper.getView(R.id.item_for_general_rcv_do_sales_goods);
        view.setKeyListener(null);
    }
}
