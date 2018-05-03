package com.jjkj.administrator.storecontrollersystem.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.jjkj.administrator.storecontrollersystem.R;

/**
 * @author Guo JiaMing
 */
public class MyTextSwitcher extends TextSwitcher {
    private int i;
    private String[] data = {"正常销售", "活动销售", "免费体验"};

    public MyTextSwitcher(Context context) {
        super(context);
    }

    @SuppressLint("InflateParams")
    public MyTextSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        i = 0;
        this.setFactory(() -> LayoutInflater.from(context).inflate(R.layout
                .item_for_text_switcher, null));
        Animation in = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
        this.setInAnimation(in);
        this.setOutAnimation(out);
        this.setOnClickListener(v -> MyTextSwitcher.this.setText(data[++i % data.length]));
        this.setText(data[i]);
    }

    public String getSelectText() {
        TextView textView = (TextView) this.getCurrentView();
        return textView.getText().toString();
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
