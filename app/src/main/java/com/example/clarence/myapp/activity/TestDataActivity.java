package com.example.clarence.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.clarence.datastorelibrary.StoreFactory;
import com.example.clarence.myapp.R;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.databinding.DataLayoutBind;
import com.example.clarence.utillibrary.DeviceUtils;

/**
 * Created by clarence on 16/6/19.
 */
public class TestDataActivity extends AppActivity {
    DataLayoutBind dataLayoutBind;

    @Override
    public void initVariables() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataLayoutBind = DataBindingUtil.setContentView(this, R.layout.activity_data);
        StoreFactory.getStoreSharePreference().setStringValue("key", "sharePreference success");
        String value = StoreFactory.getStoreSharePreference().getStringValue("key", "sharePreference fail");
        dataLayoutBind.testData.setText(value);
        dataLayoutBind.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceUtils.hideKeyboard(TestDataActivity.this);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.DONUT) {
            overridePendingTransition(R.anim.shrink_left_bottom_in, R.anim.shrink_left_bottom_in);
        }
    }
}
