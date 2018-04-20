package com.jjkj.administrator.storecontrollersystem.di.module;

import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.PartnerPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Administrator
 */
@Module
public class FragmentModule {
    @Singleton
    @Provides
    NormalSalesPresenter getNormalSalesPresenter() {
        return new NormalSalesPresenter();
    }

    @Singleton
    @Provides
    PartnerPresenter getPartnerPresenter() {
        return new PartnerPresenter();
    }
}
