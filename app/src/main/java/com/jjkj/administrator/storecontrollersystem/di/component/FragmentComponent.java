package com.jjkj.administrator.storecontrollersystem.di.component;


import com.jjkj.administrator.storecontrollersystem.di.module.FragmentModule;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.CustomerFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.DoSalesFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.ExperienceFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.MyInfoFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.MySelfFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.NormalSalesFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.PartnerFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.SalesFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.SalesPromotionFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.ShopFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Fragment依赖注入
 *
 * @author Administrator
 */
@Singleton
@Component(modules = FragmentModule.class)
public interface FragmentComponent {
    /**
     * 注入CustomerFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(CustomerFragment fragment);

    /**
     * 注入DoSalesFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(DoSalesFragment fragment);

    /**
     * 注入ExperienceFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(ExperienceFragment fragment);

    /**
     * 注入MyInfoFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(MyInfoFragment fragment);

    /**
     * 注入NormalSalesFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(NormalSalesFragment fragment);

    /**
     * 注入PartnerFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(PartnerFragment fragment);

    /**
     * 注入SalesFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(SalesFragment fragment);

    /**
     * 注入SalesPromotionFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(SalesPromotionFragment fragment);

    /**
     * 注入ShopFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(ShopFragment fragment);

    /**
     * 注入ShopFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(MySelfFragment fragment);

}
