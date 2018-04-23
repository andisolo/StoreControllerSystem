package com.jjkj.administrator.storecontrollersystem.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.MainViewPagerAdapter;
import com.jjkj.administrator.storecontrollersystem.api.StoreServiceApi;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.presenter.MainPresenter;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.CustomerFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.MyInfoFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.PartnerFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.SalesFragment;
import com.jjkj.administrator.storecontrollersystem.utils.Retrofit2Utils;
import com.jjkj.administrator.storecontrollersystem.utils.RxHelper;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView,
        RxHelper {
    private static final String REGEX = ">([\\s\\S]*)</";
    StoreServiceApi serviceApi = Retrofit2Utils.getServiceApi(StoreServiceApi.class);
    private static final String[] TABS = {"销售信息", "售后信息", "我的伙伴", "我的信息"};
    @BindView(R.id.main_vP)
    ViewPager mMainVP;
    @BindView(R.id.main_tabV)
    TabLayout mMainTabV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    private void initView() {
        for (String tab : TABS) {
            TabLayout.Tab tab1 = mMainTabV.newTab();
            tab1.setText(tab);
            mMainTabV.addTab(tab1);
        }
        mMainTabV.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mMainVP));
        mMainVP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mMainTabV));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SalesFragment());
        fragments.add(new CustomerFragment());
        fragments.add(new PartnerFragment());
        fragments.add(new MyInfoFragment());
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(),
                fragments);
        mMainVP.setAdapter(adapter);
    }

    @Override
    public void onLoadData(List<Order> orders) {

    }
}
