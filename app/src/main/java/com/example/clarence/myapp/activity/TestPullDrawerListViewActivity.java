package com.example.clarence.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.databinding.ActivityPullDrawerListViewBinding;

import java.util.ArrayList;

public class TestPullDrawerListViewActivity extends AppActivity {
    ActivityPullDrawerListViewBinding activityPullDrawerListViewBinding;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPullDrawerListViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_pull_drawer_list_view);

        ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            list1.add("item--" + i);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list1);
        activityPullDrawerListViewBinding.pullDrawerListView.setAdapter(arrayAdapter);
    }
}
