package com.example.clarence.myapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.adapter.MainAdapter;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.controller.MainController;
import com.example.clarence.myapp.databinding.ActivityMainBinding;
import com.example.clarence.myapp.entity.NavigatData;
import com.example.clarence.myapp.service.FloatingLayerService;

import java.util.List;

import javax.inject.Inject;


public class TestMainActivity extends AppActivity {
    @Inject
    MainController mainController;

    ActivityMainBinding mainBind;
    List<NavigatData> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = DataBindingUtil.setContentView(this, R.layout.activity_main);
        datas = mainController.getData();
        mainBind.listview.setAdapter(new MainAdapter(this, datas));
        mainBind.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String className = datas.get(position).getClassName();
                navigator.navigateTo(TestMainActivity.this, className, new Intent());
            }
        });
    }

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    public void floatView(View view) {
        Intent intent = new Intent(TestMainActivity.this, FloatingLayerService.class);
        startService(intent);//启动FxService
    }

    public void mvpFragment(View view) {
        TestMainFragement mainFragement = new TestMainFragement();
        TestMainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.testFragment, mainFragement, mainFragement.getFragmentTag()).commit();
    }
}
