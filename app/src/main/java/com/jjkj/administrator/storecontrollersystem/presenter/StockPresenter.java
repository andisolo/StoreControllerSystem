package com.jjkj.administrator.storecontrollersystem.presenter;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.bean.Result;
import com.jjkj.administrator.storecontrollersystem.bean.StockResult;
import com.jjkj.administrator.storecontrollersystem.model.SalesBiz;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.StockView;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Guo JiaMing
 */
public class StockPresenter extends BasePresenter<StockView> {
    @Inject
    SalesBiz mSalesBiz;
    @Inject
    CompositeDisposable mDisposable;

    public void loadStock() {
        mSalesBiz.loadStock(new Observer<StockResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("StockPresenter", "onSubscribe");
                mDisposable.add(d);
            }

            @Override
            public void onNext(StockResult result) {
                Log.i("StockPresenter", "onNext");
                getMvpView().onLoadStock(result);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().onFailed(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                getMvpView().onFailed("成功加载");
            }
        });
    }

    public void updateStock(Map<String, String> map) {
        getMvpView().showInfo("开始上传库存信息...");
        mSalesBiz.updateStock(map, new Observer<Result>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(Result result) {
                Log.i("StockPresenter", "onNext");
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().onFailed(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                getMvpView().showInfo("成功保存");
            }
        });
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) {
            mDisposable.clear();
        }
    }
}
