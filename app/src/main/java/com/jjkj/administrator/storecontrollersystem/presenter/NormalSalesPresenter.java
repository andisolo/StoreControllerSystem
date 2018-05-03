package com.jjkj.administrator.storecontrollersystem.presenter;

import com.jjkj.administrator.storecontrollersystem.bean.SlipResult;
import com.jjkj.administrator.storecontrollersystem.model.SalesBiz;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Administrator
 */
public class NormalSalesPresenter extends BasePresenter<MainView> {
    @Inject
    SalesBiz mSalesBiz;
    @Inject
    CompositeDisposable compositeDisposable;

    public void getOrders(Map<String, String> map) {
        mSalesBiz.getOrders(map, new Observer<SlipResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(SlipResult orders) {
                getMvpView().onLoadData(orders);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showInfo(e.getLocalizedMessage());
                getMvpView().onFailed();
            }

            @Override
            public void onComplete() {
                getMvpView().showInfo("成功加载");
            }
        });
    }


    @Override
    public void detachView() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        super.detachView();
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }
}
