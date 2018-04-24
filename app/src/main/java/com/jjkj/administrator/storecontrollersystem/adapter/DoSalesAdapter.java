package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.Goods;

import java.util.List;

/**
 * @author Administrator
 */
public class DoSalesAdapter extends BaseItemDraggableAdapter<Goods, BaseViewHolder> {
    public DoSalesAdapter(int layoutResId, @Nullable List<Goods> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Goods item) {
        helper.setText(R.id.item_for_general_rcv_do_sales_goods, item.getName());
        helper.setText(R.id.item_for_general_rcv_do_sales_price, item.getNumber());
        helper.setText(R.id.item_for_general_rcv_do_sales_number, item.getPrice());
        EditText view = helper.getView(R.id.item_for_general_rcv_do_sales_goods);
        EditText view1 = helper.getView(R.id.item_for_general_rcv_do_sales_price);
        EditText view2 = helper.getView(R.id.item_for_general_rcv_do_sales_number);
        view.setKeyListener(null);
        view1.setKeyListener(null);
        view2.setKeyListener(null);
    }
}
