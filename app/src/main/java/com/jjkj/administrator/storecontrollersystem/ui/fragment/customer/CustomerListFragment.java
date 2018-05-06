package com.jjkj.administrator.storecontrollersystem.ui.fragment.customer;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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

import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.adapter.CustomerAdapter;
import com.jjkj.administrator.storecontrollersystem.bean.Customer;
import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.presenter.CustomerPresenter;
import com.jjkj.administrator.storecontrollersystem.utils.ToastUtils;
import com.jjkj.administrator.storecontrollersystem.view.CustomerView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

/**
 * @author Guo JiaMing
 */
public class CustomerListFragment extends BaseFragment<CustomerView, CustomerPresenter>
		implements CustomerView, EasyPermissions.PermissionCallbacks {
	@BindView(R.id.general_rcv)
	RecyclerView mGeneralRcv;
	@BindView(R.id.general_swl)
	SwipeRefreshLayout mGeneralSwl;
	Unbinder unbinder;
	private CustomerAdapter mAdapter;
	private Map<String, Object> map;
	private static final int TAKE_PHOTO_REQUEST = 200;
	private File mFile;


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
		mAdapter.setOnItemClickListener((adapter, view, position) -> {
			Customer customer = mAdapter.getData().get(position);
			map.put("customer", customer);
			View contView = getLayoutInflater().inflate(R.layout
					.img_item_for_customer_alert_dialog, null);
			EditText inflate = contView.findViewById(R.id.item_for_dialog_input);
			AlertDialog.Builder builder = new AlertDialog.Builder(getMyContext());
			builder.setTitle("项目输入")
					.setMessage("输入项目的内容")
					.setNegativeButton("取消",
							(dialog, which) -> dialog.cancel())
					.setPositiveButton("确认", (dialog, which) -> makePicture()).setView
					(contView).show();
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
		});
		mGeneralRcv.setLayoutManager(new LinearLayoutManager(getContext()));
		mGeneralRcv.setAdapter(mAdapter);
		mGeneralSwl.setOnRefreshListener(() -> getPresenter().loadCustomer());
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


	private void makePicture() {
		if (EasyPermissions.hasPermissions(getMyContext(),
				Manifest.permission.WRITE_EXTERNAL_STORAGE,
				Manifest.permission.READ_EXTERNAL_STORAGE,
				Manifest.permission.CAMERA)) {
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			String path = Environment.getExternalStorageDirectory().getPath();
			if (!path.endsWith("/")) {
				path = path + "/";
			}
			mFile = new File(path + "pic.jpg");
			Uri imageUri = Uri.fromFile(mFile);
			//指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent, TAKE_PHOTO_REQUEST);

		} else {
			PermissionRequest.Builder builder = new PermissionRequest.Builder(
					this, 0,
					Manifest.permission.WRITE_EXTERNAL_STORAGE,
					Manifest.permission.READ_EXTERNAL_STORAGE,
					Manifest.permission.CAMERA);
			EasyPermissions.requestPermissions(builder.build());
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			case TAKE_PHOTO_REQUEST:
				uploadPhoto();
				break;
			default:
		}
	}

	private void uploadPhoto() {
		map.put("file", mFile.getPath());
		getPresenter().upLoadPicture(map);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
	                                       @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
	}

	@Override
	public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
		switch (requestCode) {
			case 0:
				ToastUtils.showToast(getMyContext(), "授权成功");
				break;
			default:
		}
	}

	@Override
	public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
		switch (requestCode) {
			case 0:
				ToastUtils.showToast(getMyContext(), "授权失败");
				break;
			default:
		}
	}
}
