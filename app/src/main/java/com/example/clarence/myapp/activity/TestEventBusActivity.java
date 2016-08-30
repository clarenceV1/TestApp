package com.example.clarence.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.databinding.EventbusBind;
import com.example.clarence.myapp.event.TestEvenBus;

import de.greenrobot.event.EventBus;

/**
 * Created by clarence on 16/6/19.
 */
public class TestEventBusActivity extends AppActivity {
    EventbusBind eventbusBind;
    int i = 0;

    @Override
    public void initVariables() {
        configSwitch.evenBusSwitch(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventbusBind = DataBindingUtil.setContentView(this, R.layout.activity_eventbus);
    }

    public void myClick(View view) {
        EventBus.getDefault().post(new TestEvenBus("value" + (i++)));
    }

    /**
     * 接受EvenBus用
     */
    public void onEventMainThread(TestEvenBus event) {
        if (event.result != null) {
            eventbusBind.setValue(event.result);
        }
    }
}
