package com.jjkj.administrator.storecontrollersystem.di.component;


import com.jjkj.administrator.storecontrollersystem.di.module.PresenterModule;
import com.jjkj.administrator.storecontrollersystem.presenter.LoginPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.MainPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Presenter依赖注入
 *
 * @author Administrator
 */
@Singleton
@Component(modules = PresenterModule.class)
public interface PresenterComponent {
    /**
     * 注入LoginPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(LoginPresenter presenter);

    /**
     * 注入MainPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(MainPresenter presenter);

    /**
     * 注入MainPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(NormalSalesPresenter presenter);
}
