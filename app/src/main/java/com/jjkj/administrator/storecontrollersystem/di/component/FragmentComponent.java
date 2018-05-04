package com.jjkj.administrator.storecontrollersystem.di.component;


import com.jjkj.administrator.storecontrollersystem.di.module.FragmentModule;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.customer.CustomerAddFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.customer.CustomerFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.customer.CustomerListFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.customer.ServiceFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.myself.DoSalesFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.myself.MyInfoFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.myself.MySelfFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.myself.ShopFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.myself.StockFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.partner.PartnerFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.sales.ExperienceFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.sales.NormalSalesFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.sales.SalesFragment;
import com.jjkj.administrator.storecontrollersystem.ui.fragment.sales.SalesPromotionFragment;

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

    /**
     * 注入StockFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(StockFragment fragment);

    /**
     * 注入CustomerAddFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(CustomerAddFragment fragment);

    /**
     * 注入CustomerListFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(CustomerListFragment fragment);

    /**
     * 注入ServiceFragment所需的依赖
     *
     * @param fragment fragment
     */
    void inject(ServiceFragment fragment);

}
