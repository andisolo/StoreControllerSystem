package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;

import java.util.List;

/**
 * @author Administrator
 */
public class DoSalesAdapter extends BaseQuickAdapter<OrderItem, BaseViewHolder> {

    public DoSalesAdapter(int layoutResId, @Nullable List<OrderItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderItem item) {
        helper.setText(R.id.item_for_general_rcv_do_sales_price, item.getPrice() + "");
        helper.setText(R.id.item_for_general_rcv_do_sales_number, item.getNumber() + "");
        helper.setText(R.id.item_for_general_rcv_do_sales_goods, item.getGoods());
        EditText price = helper.getView(R.id.item_for_general_rcv_do_sales_price);
        EditText number = helper.getView(R.id.item_for_general_rcv_do_sales_number);
        EditText goods = helper.getView(R.id.item_for_general_rcv_do_sales_goods);
        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ("".equals(s.toString())) {
                    DoSalesAdapter.this.getData().get(helper.getLayoutPosition() - 1).setNumber(0);
                } else {
                    DoSalesAdapter.this.getData().get(helper.getLayoutPosition() - 1)
                            .setPrice(Integer.valueOf(s.toString()));
                }
            }
        });
        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ("".equals(s.toString())) {
                    DoSalesAdapter.this.getData().get(helper.getLayoutPosition() - 1).setNumber(0);
                } else {
                    DoSalesAdapter.this.getData().get(helper.getLayoutPosition() - 1)
                            .setNumber(Integer.valueOf(s.toString()));
                }
            }
        });
        goods.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                DoSalesAdapter.this.getData().get(helper.getLayoutPosition() - 1).setGoods(s
                        .toString
                        ());
            }
        });


    }


}
