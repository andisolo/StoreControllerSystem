package com.jjkj.administrator.storecontrollersystem.ui.fragment;

import com.jjkj.administrator.storecontrollersystem.presenter.MyInfoPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MyInfoView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

/**
 * @author Administrator
 */
public class MySelfFragment extends BaseFragment<MyInfoView, MyInfoPresenter> {
    @Override
    protected void initInject() {
        getComponent().inject(this);
    }
}
