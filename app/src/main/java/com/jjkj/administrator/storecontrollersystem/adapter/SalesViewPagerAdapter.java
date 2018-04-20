package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author lenovo
 * Created on 2018/4/19.
 * @description
 */
public class SalesViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;

    public SalesViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
