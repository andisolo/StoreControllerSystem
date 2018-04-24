package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.presenter.MyInfoPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MyInfoView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 */
public class ShopFragment extends BaseFragment<MyInfoView, MyInfoPresenter> implements MyInfoView {


    @BindView(R.id.shop_fragment_info)
    TextView mShopFragmentInfo;
    Unbinder unbinder;
    @BindView(R.id.shop_fragment_edt)
    TextInputEditText mShopFragmentEdt;
    @BindView(R.id.shop_fragment_sch)
    TextView mShopFragmentSch;
    @BindView(R.id.shop_fragment_btn)
    TextView mShopFragmentBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mShopFragmentSch.setOnClickListener(v -> {
            if (!"".equals(mShopFragmentEdt.getText().toString())) {
                getPresenter().getPosBalaceDate(mShopFragmentEdt.getText().toString());
            }
        });
        mShopFragmentBtn.setOnClickListener(v -> {
            if (!"".equals(mShopFragmentEdt.getText().toString())) {
                getPresenter().writePosBalanceDate(mShopFragmentEdt.getText().toString());
            }
        });
    }

    @Override
    public void onResume() {
        getPresenter().getPosBalaceDate("JMD2263");
        super.onResume();
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadStringData(String info) {
        mShopFragmentInfo.setText(info);
    }

    @Override
    public void onGetGoods(Map<String, Goods> goods) {

    }
}
