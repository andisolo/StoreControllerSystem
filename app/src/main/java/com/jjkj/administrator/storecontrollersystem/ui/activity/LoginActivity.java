package com.jjkj.administrator.storecontrollersystem.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.presenter.LoginPresenter;
import com.jjkj.administrator.storecontrollersystem.view.LoginView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator
 */
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements
		LoginView {

	@BindView(R.id.login_register_btn)
	TextView mLoginRegisterBtn;
	@BindView(R.id.login_login_btn)
	TextView mLoginLoginBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ButterKnife.bind(this);
	}

	@Override
	protected void initInject() {
		getComponent().inject(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		getPresenter().getData();
	}

	@Override
	public void onGetData() {
		Log.i("LoginActivity", "onGetData");
	}

	@OnClick({R.id.login_register_btn, R.id.login_login_btn})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.login_register_btn:
				break;
			case R.id.login_login_btn:
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
				break;
			default:
		}
	}
}
