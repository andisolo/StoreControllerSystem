package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.DoSalesAdapter;
import com.jjkj.administrator.storecontrollersystem.adapter.FilterAdapter;
import com.jjkj.administrator.storecontrollersystem.presenter.MyInfoPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MyInfoView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 */
public class DoSalesFragment extends BaseFragment<MyInfoView, MyInfoPresenter> implements
        MyInfoView {

    Unbinder unbinder;
    @BindView(R.id.do_sales_main_rcv)
    RecyclerView mDoSalesMainRcv;
    @BindView(R.id.do_sales_goods_name)
    AutoCompleteTextView mDoSalesGoodsName;
    @BindView(R.id.do_sales_goods_number)
    TextInputEditText mDoSalesGoodsNumber;
    @BindView(R.id.do_sales_vip_number)
    TextInputEditText mDoSalesVipNumber;
    @BindView(R.id.do_sales_title_cancel)
    TextView mDoSalesTitleCancel;
    @BindView(R.id.do_sales_title_done)
    TextView mDoSalesTitleDone;
    private DoSalesAdapter mAdapter;
    private FilterAdapter<String> mArrayAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_sales, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @SuppressLint("InflateParams")
    private void initView() {
        mAdapter = new DoSalesAdapter(R.layout.item_for_general_rcv_do_sales, new ArrayList<>());
        mAdapter.isFirstOnly(false);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mDoSalesMainRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mDoSalesMainRcv.setAdapter(mAdapter);
        if (getContext() == null) {
            return;
        }
        mArrayAdapter = new FilterAdapter<>(getContext(), android.R.layout.simple_list_item_1,
                new ArrayList<>());
        mDoSalesGoodsName.setAdapter(mArrayAdapter);
        getPresenter().getGoods(getResources().openRawResource(R.raw.goods_list));
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }


    @Override
    public void showInfo(String info) {
        mAdapter.replaceData(new ArrayList<>());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadStringData(String info) {

    }

    @Override
    public void onGetGoods(List<String> goods) {
        mArrayAdapter.clear();
        for (String good : goods) {
            mArrayAdapter.add(good);
        }
        mArrayAdapter.notifyDataSetChanged();
    }
}
