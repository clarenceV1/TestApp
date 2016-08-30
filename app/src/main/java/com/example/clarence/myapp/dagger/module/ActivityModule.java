package com.example.clarence.myapp.dagger.module;

import android.app.Activity;

import com.example.clarence.corelibrary.ConfigSwitch;
import com.example.clarence.datastorelibrary.StoreFactory;
import com.example.clarence.datastorelibrary.db.DbManager;
import com.example.clarence.myapp.app.DbHelper;
import com.example.clarence.myapp.dagger.components.ScopeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by clarence on 16/4/4.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ScopeActivity
    Activity providesActivity() {
        return this.activity;
    }

    @Provides
    @ScopeActivity
    ConfigSwitch providesConfigSwitch() {
        return new ConfigSwitch(activity);
    }


    @Provides
    @ScopeActivity
    DbManager providesAppManager() {
        return StoreFactory.getDbManager(new DbHelper(activity).getDaoConfig());
    }
}

