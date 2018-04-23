package com.jjkj.administrator.storecontrollersystem.presenter;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.entity.User;
import com.jjkj.administrator.storecontrollersystem.model.NetWorkBiz;
import com.jjkj.administrator.storecontrollersystem.model.SalesBiz;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.PartnerView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Administrator
 */
public class PartnerPresenter extends BasePresenter<PartnerView> {
    @Inject
    SalesBiz mSalesBiz;
    @Inject
    NetWorkBiz mNetWorkBiz;
    @Inject
    CompositeDisposable compositeDisposable;

    public void getUsers() {
        mSalesBiz.getUsers(new Observer<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<User> users) {
                getMvpView().onLoadUser(users);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showInfo(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                getMvpView().showInfo("加载完成");
            }
        });
    }

    public void getSelesMan() {
        mNetWorkBiz.getSalesManList(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(String s) {
                Log.i("PartnerPresenter", s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("PartnerPresenter", e.getLocalizedMessage());

            }

            @Override
            public void onComplete() {
                Log.i("PartnerPresenter", "onComplete");

            }
        });
    }


    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    public void detachView() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        super.detachView();
    }
}
