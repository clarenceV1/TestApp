package com.example.clarence.myapp.app;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.clarence.corelibrary.BaseActivity;
import com.example.clarence.corelibrary.ConfigSwitch;
import com.example.clarence.myapp.dagger.components.ActivityComponent;
import com.example.clarence.myapp.dagger.components.AppComponent;
import com.example.clarence.myapp.dagger.components.DaggerActivityComponent;
import com.example.clarence.myapp.dagger.module.ActivityModule;

import javax.inject.Inject;

/**
 * 提供必要的组件
 * Created by clarence on 16/4/4.
 */
public abstract class AppActivity extends BaseActivity {
    @Inject
    public ConfigSwitch configSwitch;
    @Inject
    public Navigator navigator;

    public ActivityComponent activityComponent;

    public abstract void initVariables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConfig();
        initVariables();
    }

    public void initConfig() {
        initDagger();
    }

    private void initDagger() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActicityModule())
                .build();
        activityComponent.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return ((AppAplication) getApplication()).getApplicationComponent();
    }

    public ActivityModule getActicityModule() {
        return new ActivityModule(this);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }


    @Override
    protected void onDestroy() {
        configSwitch.evenBusSwitch(false);
        super.onDestroy();
    }
}
