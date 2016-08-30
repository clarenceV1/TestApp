package com.example.clarence.myapp.dagger.module;

import android.app.Application;
import android.content.Context;

import com.example.clarence.corelibrary.ConfigManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by clarence on 16/4/4.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    ConfigManager providesConfigManager() {
        return new ConfigManager(application);
    }
}
