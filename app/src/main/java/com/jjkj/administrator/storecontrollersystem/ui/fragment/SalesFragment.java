package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.SalesViewPagerAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.SlipResult;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class SalesFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {
    public static final String[] TABS = {"正常销售", "活动销售", "体验明细"};
    @BindView(R.id.sale_tbV)
    TabLayout mSaleTbV;
    @BindView(R.id.sale_vp)
    ViewPager mSaleVp;
    Unbinder unbinder;
    private List<Fragment> mFragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    private void initView() {
        for (String tab : TABS) {
            mSaleTbV.addTab(mSaleTbV.newTab().setText(tab));
        }
        mSaleTbV.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mSaleVp));
        mSaleVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mSaleTbV));
        mFragments = new ArrayList<>();
        mFragments.add(new NormalSalesFragment());
        mFragments.add(new SalesPromotionFragment());
        mFragments.add(new ExperienceFragment());
        SalesViewPagerAdapter adapter = new SalesViewPagerAdapter(getChildFragmentManager(), mFragments);
        mSaleVp.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadData(SlipResult orders) {

    }
}
