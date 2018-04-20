package com.jjkj.administrator.storecontrollersystem.di.module;

import com.jjkj.administrator.storecontrollersystem.model.SalesBiz;
import com.jjkj.administrator.storecontrollersystem.model.UserBiz;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Administrator
 */
@Module
public class PresenterModule {
    @Singleton
    @Provides
    UserBiz getUserBiz() {
        return new UserBiz();
    }

    @Singleton
    @Provides
    SalesBiz getSalesBiz() {
        return new SalesBiz();
    }

    @Singleton
    @Provides
    CompositeDisposable getCompositeDisposable() {
        return new CompositeDisposable();
    }
}
