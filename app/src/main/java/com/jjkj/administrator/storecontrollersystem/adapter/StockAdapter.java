package com.jjkj.administrator.storecontrollersystem.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Guo JiaMing
 */
public class StockAdapter extends BaseQuickAdapter<Stock, BaseViewHolder> {
    public StockAdapter(int layoutResId, @Nullable List<Stock> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Stock item) {
        EditText view = helper.getView(R.id.stock_last_count);
        if (item.getDueQuantity() > item.getLastCount()) {
            helper.setBackgroundColor(R.id.stock_layout, Color.RED);
        } else {
            helper.setBackgroundColor(R.id.stock_layout, Color.parseColor("#FF00DDFF"));
        }
        TextWatcher watcher = (TextWatcher) view.getTag();
        view.removeTextChangedListener(watcher);
        helper.setText(R.id.stock_name, "货物名称:" + item.getName());
        helper.setText(R.id.stock_number, "货物编号:" + item.getNumber());
        TextInputLayout layout = helper.getView(R.id.stock_last_count_hint);
        layout.setHint("最后盘点时库存:");
        helper.setText(R.id.stock_last_count, String.valueOf(item.getLastCount()));
        helper.setText(R.id.stock_last_count_date, "最后盘点日期:" + item.getLastCountDate());
        helper.setText(R.id.stock_due_quantity, "应有库存:" + String.valueOf(item.getDueQuantity()));
        helper.setText(R.id.stock_person, "上次盘点人:" + item.getPerson());
        TextWatcher mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!"".equals(s.toString())) {
                    item.setLastCount(Integer.valueOf(s.toString()));
                } else {
                    item.setLastCount(0);
                }
            }
        };
        view.addTextChangedListener(mTextWatcher);
        view.setTag(mTextWatcher);
    }


    public Map<String, String> getStock(int position) {
        Map<String, String> map = new HashMap<>(5);
        Stock stock = this.getData().get(position);
        map.put("id", String.valueOf(stock.getId()));
        map.put("lastCount", String.valueOf(stock.getLastCount()));
        return map;
    }
}
