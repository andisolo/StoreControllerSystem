package com.jjkj.administrator.storecontrollersystem.ui.fragment.customer;

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
public class CustomerFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {
    @BindView(R.id.custom_tbV)
    TabLayout mCustomTbV;
    @BindView(R.id.custom_vp)
    ViewPager mCustomVp;
    Unbinder unbinder;
    private static final String[] TABS = {"售后明细", "顾客明细", "新增顾客"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        for (String tab : TABS) {
            mCustomTbV.addTab(mCustomTbV.newTab().setText(tab));
        }
        mCustomTbV.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (mCustomVp));
        mCustomVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mCustomTbV));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ServiceFragment());
        fragments.add(new CustomerListFragment());
        fragments.add(new CustomerAddFragment());
        SalesViewPagerAdapter adapter = new SalesViewPagerAdapter(getChildFragmentManager(),
                fragments);
        mCustomVp.setAdapter(adapter);
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }


    @Override
    public void onLoadData(SlipResult orders) {

    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
