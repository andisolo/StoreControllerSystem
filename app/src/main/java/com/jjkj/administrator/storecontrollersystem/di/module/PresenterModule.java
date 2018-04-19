package com.jjkj.administrator.storecontrollersystem.di.module;

import com.jjkj.administrator.storecontrollersystem.model.UserBiz;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
}
