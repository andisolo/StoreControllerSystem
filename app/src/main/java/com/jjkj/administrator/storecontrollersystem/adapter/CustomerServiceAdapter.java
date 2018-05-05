package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.AfterSalesService;
import com.jjkj.administrator.storecontrollersystem.utils.Retrofit2Utils;

import java.util.List;

/**
 * @author Guo JiaMing
 */
public class CustomerServiceAdapter extends BaseQuickAdapter<AfterSalesService, BaseViewHolder> {

    public CustomerServiceAdapter(int layoutResId, @Nullable List<AfterSalesService> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AfterSalesService item) {
        ImageView view = helper.getView(R.id.item_for_customer_service_rcv_img);
        String url = Retrofit2Utils.BASE_IMG_URL + item.getPicture();
        Glide.with(view).asBitmap().apply(RequestOptions.overrideOf(300, 300)).load(url).into(view);
        helper.setText(R.id.item_for_customer_service_rcv_date, "售后服务时间:" + item.getDate());
        helper.setText(R.id.item_for_customer_service_rcv_name, "项目名称:" + item.getName());
        helper.setText(R.id.item_for_customer_service_rcv_phone, "顾客名称:" + item.getCustomer()
                .getName());
    }
}
