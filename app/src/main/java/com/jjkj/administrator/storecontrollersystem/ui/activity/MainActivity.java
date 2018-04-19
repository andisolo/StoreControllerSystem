package com.jjkj.administrator.storecontrollersystem.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.presenter.MainPresenter;
import com.jjkj.administrator.storecontrollersystem.view.MainView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {
    @BindView(R.id.main_text)
    TextView mMainText;

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainText.setText("第二个activity");
        getPresenter().getData();
    }

    @Override
    public void getData() {
        Log.i("MainActivity", "getData");
    }
}
