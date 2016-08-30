package com.example.clarence.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.controller.SqliteController;
import com.example.clarence.myapp.databinding.ActivitySqliteBinding;

import javax.inject.Inject;

/**
 * Created by clarence on 16/6/19.
 */
public class TestSqliteActivity extends AppActivity {
    ActivitySqliteBinding activitySqliteBinding;
    @Inject
    SqliteController sqliteController;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySqliteBinding = DataBindingUtil.setContentView(this, R.layout.activity_sqlite);
        activitySqliteBinding.testSql.setText(sqliteController == null ? "null" : sqliteController.testSql());
    }
}
