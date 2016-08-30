package com.example.clarence.myapp.manager;

import com.example.clarence.corelibrary.BaseManager;
import com.example.clarence.datastorelibrary.db.DbManager;

import javax.inject.Inject;

/**
 * Created by clarence on 16/4/4.
 */
public class AppManager extends BaseManager {
    @Inject
    DbManager dbManager;

    @Inject
    public AppManager() {

    }
}
