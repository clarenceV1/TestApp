package com.example.clarence.myapp.app;

import android.content.Context;

import com.example.clarence.corelibrary.CApplication;
import com.example.clarence.corelibrary.ConfigManager;
import com.example.clarence.imageloaderlibrary.ImageLoaderFactory;
import com.example.clarence.myapp.dagger.components.AppComponent;
import com.example.clarence.myapp.dagger.components.DaggerAppComponent;
import com.example.clarence.myapp.dagger.module.AppModule;

import javax.inject.Inject;

/**
 * Created by clarence on 16/4/4.
 */
public class AppAplication extends CApplication {
    public static Context context;
    private AppComponent applicationComponent;
    @Inject
    ConfigHelper configHelper;
    @Inject
    ConfigManager configManager;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initializeInjector();
    }

    public static Context getContext() {
        return context;
    }

    private void initializeInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void init() {
        context = this;
    }

}
