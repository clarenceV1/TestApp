package com.example.clarence.myapp.controller;

import com.example.clarence.myapp.manager.SqliteManager;

import javax.inject.Inject;

/**
 * Created by clarence on 16/4/4.
 */
public class SqliteController extends AppController {
    @Inject
    SqliteManager sqliteManager;

    @Inject
    public SqliteController() {

    }

    public String testSql() {
        return sqliteManager.testBingdId();
    }

}
