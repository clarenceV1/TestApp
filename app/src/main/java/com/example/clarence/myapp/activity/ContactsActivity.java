package com.example.clarence.myapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clarence.libwidget.SlidingTabLayout;
import com.example.clarence.myapp.R;

/**
 * Created by clarence on 16/8/30.
 */
public class ContactsActivity extends Fragment {
    SlidingTabLayout tabLayout;
    ViewPager viewPager;
    ContactsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tabLayout = (SlidingTabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapter = new ContactsAdapter(getActivity().getSupportFragmentManager(), getActivity());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }
}
