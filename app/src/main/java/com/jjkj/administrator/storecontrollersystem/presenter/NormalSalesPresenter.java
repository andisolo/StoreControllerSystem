package com.jjkj.administrator.storecontrollersystem.presenter;

import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;
import com.jjkj.administrator.storecontrollersystem.model.SalesBiz;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;

import java.util.List;

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

    public void getOrders() {
        mSalesBiz.getOrders(new Observer<List<Order>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<Order> orders) {
                getMvpView().onLoadData(orders);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showInfo(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                getMvpView().showInfo("成功加载");
            }
        });
    }

    public void addOrders(List<OrderItem> orderItems, String name) {
        mSalesBiz.addOrders(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(String orders) {
                getMvpView().showInfo(orders);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showInfo(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        }, orderItems, name);
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
