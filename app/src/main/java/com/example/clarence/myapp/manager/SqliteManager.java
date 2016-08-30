package com.example.clarence.myapp.manager;

import com.example.clarence.datastorelibrary.db.DbException;
import com.example.clarence.myapp.entity.Child;
import com.example.clarence.utillibrary.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/4/5.
 */
public class SqliteManager extends AppManager {
    @Inject
    public SqliteManager() {
    }

    public List<Child> getChildList() {
        List<Child> children = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Child child = new Child();
            child.setEmail("qwe@11.com");
            child.setName("aaaa");
            child.setText("qqq");
            child.setWillIgnore("ttt");
            children.add(child);
        }
        return children;
    }

    public void testQuery() {
        try {
            Child child = dbManager.selector(Child.class).where("id", "in", new int[]{1, 3, 6}).findFirst();
            LogUtils.e("==>", child.toString());
            long count = dbManager.selector(Child.class).where("id", "in", new int[]{1, 3, 6}).count();
            LogUtils.e("==>", "数量：" + count);
            List<Child> childList = dbManager.selector(Child.class).where("id", "in", new int[]{1, 3, 6}).findAll();
            LogUtils.e("==>", "查找1，3，6:" + childList.toString());
            childList = dbManager.selector(Child.class).where("id", "between", new String[]{"1", "5"}).findAll();
            LogUtils.e("==>", "查找1-5:" + childList.toString());
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void testInsert() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Child> children = getChildList();
                    //逐个插入的时间
                    long start = System.currentTimeMillis();
                    for (Child child : children) {
                        dbManager.save(child);
                    }
                    long end = System.currentTimeMillis();
                    LogUtils.e("===>", "逐个插入时间：" + (end - start));

                    //批量插入时间
                    start = System.currentTimeMillis();
                    dbManager.save(children);
                    end = System.currentTimeMillis();
                    LogUtils.e("===>", "批量插入时间" + (end - start));

                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public String testBingdId() {
        String result = "error";
        Child child = new Child();
        child.setEmail("qwe@1123.com");
        child.setName("bbbbb");
        child.setText("qqq222");
        child.setWillIgnore("ttt333");
        child.setParentId(1);
        try {
            dbManager.save(child);
            Child query = dbManager.selector(Child.class).where("email", "=", child.getEmail()).findFirst();
            result = query.toString();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return result;
    }
}
