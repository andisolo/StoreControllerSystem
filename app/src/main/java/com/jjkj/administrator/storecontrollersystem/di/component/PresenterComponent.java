package com.jjkj.administrator.storecontrollersystem.di.component;


import com.jjkj.administrator.storecontrollersystem.di.module.PresenterModule;
import com.jjkj.administrator.storecontrollersystem.presenter.CustomerPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.LoginPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.MainPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.MyInfoPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.NormalSalesPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.PartnerPresenter;
import com.jjkj.administrator.storecontrollersystem.presenter.StockPresenter;

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
     * 注入NormalSalesPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(NormalSalesPresenter presenter);

    /**
     * 注入PartnerPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(PartnerPresenter presenter);

    /**
     * 注入MyInfoPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(MyInfoPresenter presenter);

    /**
     * 注入StockPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(StockPresenter presenter);

    /**
     * 注入CustomerPresenter所需的依赖
     *
     * @param presenter presenter
     */
    void inject(CustomerPresenter presenter);
}
