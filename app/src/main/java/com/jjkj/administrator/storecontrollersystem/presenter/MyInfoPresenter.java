package com.jjkj.administrator.storecontrollersystem.presenter;

import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.bean.PersonResult;
import com.jjkj.administrator.storecontrollersystem.bean.Result;
import com.jjkj.administrator.storecontrollersystem.bean.SalesSlip;
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
		mSalesBiz.getGoods(new Observer<Map<String, Goods>>() {
			@Override
			public void onSubscribe(Disposable d) {
				mDisposable.add(d);
			}

			@Override
			public void onNext(Map<String, Goods> o) {
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

	public void saveOrders(SalesSlip slip) {
		mSalesBiz.saveOrders(slip, new Observer<Result>() {
			@Override
			public void onSubscribe(Disposable d) {
				mDisposable.add(d);
			}

			@Override
			public void onNext(Result result) {
				getMvpView().showInfo(result.getResult());
			}

			@Override
			public void onError(Throwable e) {
				getMvpView().showInfo(e.getLocalizedMessage());
			}

			@Override
			public void onComplete() {
				getMvpView().showInfo("成功保存");
			}
		});
	}

	public void loadMyInfo(Map<String, String> map) {
		mSalesBiz.loadMyInfo(map, new Observer<PersonResult>() {
			@Override
			public void onSubscribe(Disposable d) {
				mDisposable.add(d);
			}

			@Override
			public void onNext(PersonResult personResult) {
				getMvpView().onGetPerson(personResult);
			}

			@Override
			public void onError(Throwable e) {
				getMvpView().showInfo(e.getLocalizedMessage());
			}

			@Override
			public void onComplete() {
				getMvpView().showInfo("加载成功");
			}
		});
	}

	public void updateOrSaveMyself(Map<String, String> map) {
		mSalesBiz.updateOrSaveMyself(map, new Observer<Result>() {
			@Override
			public void onSubscribe(Disposable d) {
				mDisposable.add(d);
			}

			@Override
			public void onNext(Result personResult) {
				getMvpView().showInfo(personResult.getResult());
			}

			@Override
			public void onError(Throwable e) {
				getMvpView().showInfo(e.getLocalizedMessage());
			}

			@Override
			public void onComplete() {
				getMvpView().showInfo("注册成功");
			}
		});
	}


	@Override
	protected void initInject() {
		getComponent().inject(this);
	}
}
