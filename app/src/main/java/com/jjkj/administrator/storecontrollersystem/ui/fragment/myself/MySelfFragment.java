package com.jjkj.administrator.storecontrollersystem.ui.fragment.myself;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.bean.Person;
import com.jjkj.administrator.storecontrollersystem.bean.PersonResult;
import com.jjkj.administrator.storecontrollersystem.presenter.MyInfoPresenter;
import com.jjkj.administrator.storecontrollersystem.utils.Retrofit2Utils;
import com.jjkj.administrator.storecontrollersystem.view.MyInfoView;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 */
public class MySelfFragment extends BaseFragment<MyInfoView, MyInfoPresenter> implements
        MyInfoView {
    @BindView(R.id.myself_name)
    TextInputEditText mMyselfName;
    @BindView(R.id.myself_age)
    TextInputEditText mMyselfAge;
    @BindView(R.id.myself_phone)
    TextInputEditText mMyselfPhone;
    Unbinder unbinder;
    @BindView(R.id.myself_commit_btn)
    TextView mMyselfCommitBtn;
    @BindView(R.id.myself_name_hint)
    TextInputLayout mMyselfNameHint;
    @BindView(R.id.myself_age_hint)
    TextInputLayout mMyselfAgeHint;
    @BindView(R.id.myself_phone_hint)
    TextInputLayout mMyselfPhoneHint;
    @BindView(R.id.myself_picture)
    ImageView mMyselfPicture;
    @BindView(R.id.myself_basePay)
    TextView mMyselfBasePay;
    @BindView(R.id.myself_achievement)
    TextView mMyselfAchievement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mMyselfNameHint.setHint("我的名字");
        mMyselfAgeHint.setHint("我的年龄");
        mMyselfPhoneHint.setHint("我的电话");
        Map<String, String> map = new HashMap<>(2);
        map.put("meId", getPhoneNumber());
        getPresenter().loadMyInfo(map);
        mMyselfCommitBtn.setOnClickListener(v -> {
            map.put("name", mMyselfName.getText().toString());
            map.put("age", mMyselfAge.getText().toString());
            map.put("phone", mMyselfPhone.getText().toString());
            map.put("meId", getPhoneNumber());
            getPresenter().updateOrSaveMyself(map);
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

    @Override
    public void onLoadStringData(String info) {

    }

    @Override
    public void onGetGoods(Map<String, Goods> goods) {

    }

    @Override
    public void onGetPerson(PersonResult personResult) {
        if (personResult.getPerson().size() <= 0) {
            return;
        }
        Person myself = personResult.getPerson().get(0);
        mMyselfName.setText(myself.getName());
        mMyselfAge.setText(myself.getAge());
        mMyselfPhone.setText(myself.getPhone());
        mMyselfBasePay.setText(String.format("基本工资:%s", myself.getBasePay()));
        mMyselfAchievement.setText(String.format("本月业绩:%s", myself.getAchievement()));
        if (myself.getPicture() != 0) {
            String url = Retrofit2Utils.BASE_IMG_URL + myself.getPicture();
            Glide.with(this).load(url).into(mMyselfPicture);
        }
    }
}
