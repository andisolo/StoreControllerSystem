package com.jjkj.administrator.storecontrollersystem.presenter;

import com.jjkj.administrator.storecontrollersystem.entity.User;
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

    public void addUser(User user) {
        mSalesBiz.addUsers(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(String info) {
                getMvpView().showInfo(info);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showInfo(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                getMvpView().onSucceed("刷新数据");
            }
        }, user);
    }

    public void deleteUser(User user) {
        mSalesBiz.deleteUsers(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(String info) {
                getMvpView().showInfo(info);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showInfo(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                getMvpView().onSucceed("刷新数据");
            }
        }, user);
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
