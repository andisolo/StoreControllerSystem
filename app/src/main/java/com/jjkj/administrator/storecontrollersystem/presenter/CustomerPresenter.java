package com.jjkj.administrator.storecontrollersystem.presenter;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.bean.Result;
import com.jjkj.administrator.storecontrollersystem.model.SalesBiz;
import com.jjkj.administrator.storecontrollersystem.presenter.base.BasePresenter;
import com.jjkj.administrator.storecontrollersystem.view.CustomerView;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Guo JiaMing
 */
public class CustomerPresenter extends BasePresenter<CustomerView> {
	@Inject
	SalesBiz mSalesBiz;
	@Inject
	CompositeDisposable mDisposable;

	public void commitCustomer(Map<String, String> map) {
		getMvpView().showInfo("开始提交顾客信息");
		mSalesBiz.commitCustomer(map, new Observer<Result>() {
			@Override
			public void onSubscribe(Disposable d) {
				mDisposable.add(d);
			}

			@Override
			public void onNext(Result result) {
				Log.i("CustomerPresenter", result.getResult());
			}

			@Override
			public void onError(Throwable e) {
				getMvpView().showInfo(e.getLocalizedMessage());
			}

			@Override
			public void onComplete() {
				getMvpView().showInfo("提交成功");
			}
		});
	}

	public void loadCustomer() {
		mSalesBiz.loadCustomer(new Observer<CustomerResult>() {
			@Override
			public void onSubscribe(Disposable d) {
				mDisposable.add(d);
			}

			@Override
			public void onNext(CustomerResult result) {
				getMvpView().onCustomerLoad(result);
			}

			@Override
			public void onError(Throwable e) {
				getMvpView().onCustomerFailed(e.getLocalizedMessage());
			}

			@Override
			public void onComplete() {
				getMvpView().showInfo("提交成功");
			}
		});
	}

	@Override
	public void detachView() {
		if (mDisposable != null) {
			mDisposable.clear();
		}
		super.detachView();
	}

	@Override
	protected void initInject() {
		getComponent().inject(this);
	}
}
