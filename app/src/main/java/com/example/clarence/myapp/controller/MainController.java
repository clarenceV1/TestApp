package com.example.clarence.myapp.controller;

import com.example.clarence.myapp.activity.TestAnimationActivity;
import com.example.clarence.myapp.activity.TestDataActivity;
import com.example.clarence.myapp.activity.TestDataBingActivity;
import com.example.clarence.myapp.activity.TestEventBusActivity;
import com.example.clarence.myapp.activity.TestFrescoImageLoaderActivity;
import com.example.clarence.myapp.activity.TestHttpActivity;
import com.example.clarence.myapp.activity.TestMvpActivity;
import com.example.clarence.myapp.activity.TestPullDrawerListViewActivity;
import com.example.clarence.myapp.activity.TestSqliteActivity;
import com.example.clarence.myapp.entity.NavigatData;
import com.example.clarence.myapp.manager.MainManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/4/4.
 */
public class MainController extends AppController {
    @Inject
    MainManager mainManager;

    @Inject
    public MainController() {

    }

    public List<NavigatData> getData() {
        List<NavigatData> data = new ArrayList<>();
        data.add(new NavigatData("evenBus测试", TestEventBusActivity.class.getName()));
        data.add(new NavigatData("数据库测试", TestSqliteActivity.class.getName()));
        data.add(new NavigatData("数据存取测试", TestDataActivity.class.getName()));
        data.add(new NavigatData("databinding", TestDataBingActivity.class.getName()));
        data.add(new NavigatData("Http测试", TestHttpActivity.class.getName()));
        data.add(new NavigatData("MVP测试", TestMvpActivity.class.getName()));
        data.add(new NavigatData("PullDrawerListViewActivity测试", TestPullDrawerListViewActivity.class.getName()));
        data.add(new NavigatData("fresco图片加载测试", TestFrescoImageLoaderActivity.class.getName()));
        data.add(new NavigatData("动画测试", TestAnimationActivity.class.getName()));
        return data;
    }
}
