package com.jjkj.administrator.storecontrollersystem.ui.fragment.customer;

import android.Manifest;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.CustomerAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.Customer;
import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.presenter.CustomerPresenter;
import com.jjkj.administrator.storecontrollersystem.view.CustomerView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * @author Guo JiaMing
 */
@RuntimePermissions
public class CustomerListFragment extends BaseFragment<CustomerView, CustomerPresenter>
        implements CustomerView {
    @BindView(R.id.general_rcv)
    RecyclerView mGeneralRcv;
    @BindView(R.id.general_swl)
    SwipeRefreshLayout mGeneralSwl;
    Unbinder unbinder;
    private CustomerAdapter mAdapter;
    private Map<String, Object> map;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_for_rcv, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        map = new HashMap<>(5);
        mAdapter = new CustomerAdapter(R.layout.item_for_customer_rcv, new
                ArrayList<>());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Customer customer = mAdapter.getData().get(position);
                map.put("customer", customer);
                EditText inflate = (EditText) getLayoutInflater().inflate(R.layout
                        .img_item_for_customer_alert_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(getMyContext());
                builder.setTitle("请输入执行的销售项目名称").setNegativeButton("取消",
                        (dialog, which) -> dialog.cancel())
                        .setPositiveButton("确认", (dialog, which) -> makePicture()).setView
                        (inflate).show();
                inflate.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        map.put("name", s.toString());
                    }
                });
            }
        });
        mGeneralRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mGeneralRcv.setAdapter(mAdapter);
        mGeneralSwl.setOnRefreshListener(() -> getPresenter().loadCustomer());
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().loadCustomer();
    }

    @Override
    public void onCustomerLoad(CustomerResult result) {
        if (mGeneralSwl.isRefreshing()) {
            mGeneralSwl.setRefreshing(false);
        }
        mAdapter.replaceData(result.getCustomer());
    }

    @Override
    public void onCustomerLoadFailed(String info) {
        if (mGeneralSwl.isRefreshing()) {
            mGeneralSwl.setRefreshing(false);
        }
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

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void getPermission() {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        CustomerListFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode,
                grantResults);
    }

    private void makePicture() {
    }
}
