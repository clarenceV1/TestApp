package com.example.clarence.myapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.clarence.libwidget.pinnedsection.PinnedSectionListView;
import com.example.clarence.myapp.R;
import com.example.clarence.myapp.data.UserInfoDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContactsFragment extends Fragment {
    PinnedSectionListView listView;
    ContactsFragmentAdapter adapter;

    List<ContactsItem> data = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentData();
        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (PinnedSectionListView) view.findViewById(R.id.listView);
        adapter = new ContactsFragmentAdapter(getContext(), data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactsItem item = adapter.getItem(position);
                if (item != null) {
                    if (item.type == ContactsItem.SECTION) {
                        Toast.makeText(getContext(), "section " + position + ": " + item.userInfoDO.getName(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Item " + position + ": " + item.userInfoDO.getName(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "erro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getIntentData() {
        Bundle bundle = getArguments();
    }

    private void loadData() {
        final int sectionsNumber = 'Z' - 'A' + 1;
        int sectionPosition = 0, listPosition = 0;
        UserInfoDO userInfoDO;
        for (char i = 0; i < sectionsNumber; i++) {
            userInfoDO = new UserInfoDO();
            userInfoDO.setName(String.valueOf((char) ('A' + i)));
            userInfoDO.setTelephone(i + "");
            ContactsItem section = new ContactsItem(ContactsItem.SECTION, userInfoDO);
            section.sectionPosition = sectionPosition;
            section.listPosition = listPosition++;
            data.add(section);

            final int itemsNumber = (int) Math.abs((Math.cos(2f * Math.PI / 3f * sectionsNumber / (i + 1f)) * 25f));
            for (int j = 0; j < itemsNumber; j++) {
                userInfoDO = new UserInfoDO();
                userInfoDO.setName(section.userInfoDO.getName().toUpperCase(Locale.ENGLISH) + " - " + j);
                userInfoDO.setTelephone(i + "");
                ContactsItem item = new ContactsItem(ContactsItem.ITEM, userInfoDO);
                item.sectionPosition = sectionPosition;
                item.listPosition = listPosition++;
                data.add(item);
            }
            sectionPosition++;
        }
    }

}