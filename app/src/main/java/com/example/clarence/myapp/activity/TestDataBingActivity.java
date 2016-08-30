package com.example.clarence.myapp.activity;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewStub;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.adapter.DataBindingAdapter;
import com.example.clarence.myapp.databinding.TestDataBing;
import com.example.clarence.myapp.databinding.ViewStubBinding;
import com.example.clarence.myapp.entity.PlainUser;
import com.example.clarence.myapp.entity.User;
import com.example.clarence.utillibrary.ToastUtils;

public class TestDataBingActivity extends Activity implements View.OnClickListener {
    private PlainUser plainUser = new PlainUser();
    private ObservableArrayMap<String, Object> mapUser = new ObservableArrayMap<>();
    ObservableArrayList<String> listUser = new ObservableArrayList<>();
    User user;
    TestDataBing binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        initData();
    }

    private void initData() {
        binding.setAttributeName("这是通过属性绑定");
        binding.setListener(this);
        binding.setLarge(true);

        user = new User("user.firstName", "user.lastName", "user.age");
        binding.setUser(user);

        plainUser = new PlainUser();
        plainUser.firstName.set("plainUser.firstName");
        plainUser.lastName.set("plainUser.lastName");
        binding.setPlainUser(plainUser);

        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ViewStubBinding binding = DataBindingUtil.bind(inflated);
                binding.setUser(user);
            }
        });

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new DataBindingAdapter());
    }

    @Override
    public void onClick(View v) {
        ToastUtils.showToast(TestDataBingActivity.this, "i have new name!");
        user.setFirstName("user.firstName2");
        user.setLastName("user.lastName2");
        user.setAge("user.age2");

        plainUser.firstName.set("plainUser.firstName2");
        plainUser.lastName.set("plainUser.lastName2");

        if (!binding.viewStub.isInflated()) {
            binding.viewStub.getViewStub().inflate();
        }

        binding.attribute.setText("通过ID绑定");
    }

    /**
     * 修改属性功能
     *
     * @param view
     * @param oldPadding
     * @param newPadding
     */
    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int oldPadding, int newPadding) {
        if (oldPadding != newPadding) {
            view.setPadding(newPadding, newPadding, newPadding, newPadding);
        }
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }
}
