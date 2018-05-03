package com.jjkj.administrator.storecontrollersystem.ui.fragment.customer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.presenter.CustomerPresenter;
import com.jjkj.administrator.storecontrollersystem.utils.ToastUtils;
import com.jjkj.administrator.storecontrollersystem.view.CustomerView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Guo JiaMing
 */
public class CustomerAddFragment extends BaseFragment<CustomerView, CustomerPresenter> implements
        CustomerView {
    @BindView(R.id.customer_add_name)
    TextInputEditText mCustomerAddName;
    @BindView(R.id.customer_add_age)
    TextInputEditText mCustomerAddAge;
    @BindView(R.id.customer_add_phone)
    TextInputEditText mCustomerAddPhone;
    @BindView(R.id.customer_add_commit)
    TextView mCustomerAddCommit;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_add, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mCustomerAddCommit.setOnClickListener(v -> {
            Map<String, String> map = new HashMap<>(5);
            if ("".equals(mCustomerAddPhone.getText().toString())) {
                ToastUtils.showToast(getContext(), "手机号码不能为空");
                return;
            }
            map.put("name", mCustomerAddName.getText().toString());
            map.put("age", mCustomerAddAge.getText().toString());
            map.put("phone", mCustomerAddPhone.getText().toString());
            getPresenter().commitCustomer(map);
        });
    }

    @Override
    protected void initInject() {
        getComponent().inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
