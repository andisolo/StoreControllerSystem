package com.jjkj.administrator.storecontrollersystem.presenter;

import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.model.NetWorkBiz;
import com.jjkj.administrator.storecontrollersystem.model.SalesBiz;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.MyInfoView;

import java.io.InputStream;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Administrator
 */
public class MyInfoPresenter extends BasePresenter<MyInfoView> {
    @Inject
    NetWorkBiz mNetWorkBiz;
    @Inject
    SalesBiz mSalesBiz;
    @Inject
    CompositeDisposable mDisposable;

    public void getPosBalaceDate(String storeNumber) {
        mNetWorkBiz.getPosBalaceDate(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(String s) {
                getMvpView().onLoadStringData(s);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().onLoadStringData(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        }, storeNumber);
    }

    public void writePosBalanceDate(String storeNumber) {
        mNetWorkBiz.writePosBalanceDate(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(String s) {
                getMvpView().onLoadStringData(s);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().onLoadStringData(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        }, storeNumber);
    }

    public void getGoods(InputStream in) {
        mSalesBiz.getGoods(new Observer<Map<String,Goods>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(Map<String,Goods> o) {
                getMvpView().onGetGoods(o);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().onLoadStringData(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        }, in);
    }


    @Override
    protected void initInject() {
        getComponent().inject(this);
    }
}
