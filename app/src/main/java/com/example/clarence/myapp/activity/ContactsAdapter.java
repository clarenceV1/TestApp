package com.example.clarence.myapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clarence on 16/7/14.
 */
public class ContactsAdapter extends FragmentStatePagerAdapter {
    final List<String> tabTitle = new ArrayList<>();
    Context context;

    public ContactsAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        for (int i = 1; i <= 13; i++) {
            tabTitle.add(i + "");
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
//        try {
//            bundle.putInt("days", days.get(position));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return Fragment.instantiate(context, ContactsFragment.class.getName(), bundle);
    }

    @Override
    public int getCount() {
        return tabTitle.size();
    }
}
