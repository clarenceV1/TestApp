package com.example.clarence.myapp.activity;


import com.example.clarence.myapp.data.UserInfoDO;

/**
 * Created by clarence on 16/8/30.
 */
public class ContactsItem {
    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public final int type;
    public int sectionPosition;
    public int listPosition;
    public UserInfoDO userInfoDO;

    public ContactsItem(int type, UserInfoDO userInfoDO) {
        this.type = type;
        this.userInfoDO = userInfoDO;
    }

    public ContactsItem(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return userInfoDO.toString();
    }
}
