package com.jjkj.administrator.storecontrollersystem.di.component;

import com.jjkj.administrator.storecontrollersystem.di.module.ActivityModule;
import com.jjkj.administrator.storecontrollersystem.ui.activity.LoginActivity;
import com.jjkj.administrator.storecontrollersystem.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Activity依赖注入
 *
 * @author Administrator
 */
@Singleton
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    /**
     * 注入LoginActivity所需的依赖
     *
     * @param activity Activity
     */
    void inject(LoginActivity activity);

    /**
     * 注入MainActivity所需的依赖
     *
     * @param activity Activity
     */
    void inject(MainActivity activity);
}
