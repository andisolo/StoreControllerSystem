package com.jjkj.administrator.storecontrollersystem.di.module;

import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    @Singleton
    @Provides
    NormalSalesPresenter getLoginPresenter() {
        return new NormalSalesPresenter();
    }
}
