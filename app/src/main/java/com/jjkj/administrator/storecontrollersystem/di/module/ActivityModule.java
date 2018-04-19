package com.jjkj.administrator.storecontrollersystem.di.module;

import com.jjkj.administrator.storecontrollersystem.presenter.LoginPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 注入Presenter的module
 *
 * @author Administrator
 */
@Module
public class ActivityModule {

    @Singleton
    @Provides
    LoginPresenter getLoginPresenter() {
        return new LoginPresenter();
    }

    @Singleton
    @Provides
    MainPresenter getMainPresenter() {
        return new MainPresenter();
    }
}
