package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.entity.User;

import java.util.List;

/**
 * @author Administrator
 */
public class PartnerAdapter extends BaseQuickAdapter<User, BaseViewHolder> {
    public PartnerAdapter(int layoutResId, @Nullable List<User> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
        helper.setText(R.id.partner_name, "伙伴姓名:" + item.getName());
        helper.setText(R.id.partner_phone_number, "联系方式:" + item.getPhoneNum());
    }
}
