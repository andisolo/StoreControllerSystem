package com.jjkj.administrator.storecontrollersystem.di.module;

import com.jjkj.administrator.storecontrollersystem.presenter.CustomerPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.MyInfoPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.PartnerPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.StockPresenter;

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

    @Singleton
    @Provides
    MyInfoPresenter getMyInfoPresenter() {
        return new MyInfoPresenter();
    }

    @Singleton
    @Provides
    StockPresenter getStockPresenter() {
        return new StockPresenter();
    }

    @Singleton
    @Provides
    CustomerPresenter getCustomerPresenter() {
        return new CustomerPresenter();
    }
}
