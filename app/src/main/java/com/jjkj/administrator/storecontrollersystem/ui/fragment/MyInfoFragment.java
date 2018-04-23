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
import com.jjkj.administrator.storecontrollersystem.adapter.MainViewPagerAdapter;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
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
public class MyInfoFragment extends BaseFragment<MainView, NormalSalesPresenter> implements
        MainView {
    @BindView(R.id.my_info_tbV)
    TabLayout mMyInfoTbV;
    @BindView(R.id.my_info_vp)
    ViewPager mMyInfoVp;
    Unbinder unbinder;
    public static final String[] TABS = {"销售登记", "日结管理", "我的信息"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_info, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    private void initView() {
        for (String tab : TABS) {
            mMyInfoTbV.addTab(mMyInfoTbV.newTab().setText(tab));
        }
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DoSalesFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MySelfFragment());
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getChildFragmentManager(),
                fragments);
        mMyInfoVp.setAdapter(adapter);
        mMyInfoTbV.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (mMyInfoVp));
        mMyInfoVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mMyInfoTbV));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadData(List<Order> orders) {

    }
}
