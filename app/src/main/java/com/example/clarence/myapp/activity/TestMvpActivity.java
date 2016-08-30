package com.example.clarence.myapp.activity;

import com.example.clarence.corelibrary.delegate.IDelegate;
import com.example.clarence.myapp.app.AppActicityPresenter;
import com.example.clarence.myapp.delegate.MvpDelegate;

public class TestMvpActivity extends AppActicityPresenter {
    MvpDelegate delegate;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
        configSwitch.evenBusSwitch(false);
    }

    @Override
    public IDelegate getViewDelegate() {
        if (delegate == null) {
            delegate = new MvpDelegate();
        }
        return delegate;
    }
    public String getResult(){
        return "mvp success";
    };
}
