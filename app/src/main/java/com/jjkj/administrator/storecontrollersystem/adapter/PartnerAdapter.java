package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.Person;
import com.jjkj.administrator.storecontrollersystem.utils.Retrofit2Utils;

import java.util.List;

/**
 * @author Administrator
 */
public class PartnerAdapter extends BaseQuickAdapter<Person, BaseViewHolder> {
    public PartnerAdapter(int layoutResId, @Nullable List<Person> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
        ImageView imageView = helper.getView(R.id.partner_picture);
        if (item.getPicture() != 0) {
            Glide.with(imageView).load(Retrofit2Utils.BASE_IMG_URL + item.getPicture()).into
                    (imageView);
        }
        helper.setText(R.id.partner_name, "伙伴姓名:" + item.getName());
        helper.setText(R.id.partner_phone_number, "联系方式:" + item.getPhone());
    }
}
