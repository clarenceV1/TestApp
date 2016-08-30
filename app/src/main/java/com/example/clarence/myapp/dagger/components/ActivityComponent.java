package com.example.clarence.myapp.dagger.components;

import com.example.clarence.myapp.activity.TestHttpActivity;
import com.example.clarence.myapp.activity.TestMainActivity;
import com.example.clarence.myapp.activity.TestSqliteActivity;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.app.AppActicityPresenter;
import com.example.clarence.myapp.dagger.module.ActivityModule;

import dagger.Component;

@ScopeActivity
@Component(
        dependencies = {AppComponent.class},
        modules = {ActivityModule.class
        }
)
public interface ActivityComponent {
    void inject(AppActicityPresenter activity);

    void inject(AppActivity activity);

    void inject(TestMainActivity activity);

    void inject(TestSqliteActivity activity);

    void inject(TestHttpActivity activity);


}
