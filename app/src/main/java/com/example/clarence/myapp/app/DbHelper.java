package com.example.clarence.myapp.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import com.example.clarence.datastorelibrary.db.DaoConfig;
import com.example.clarence.datastorelibrary.db.DbManager;
import com.example.clarence.datastorelibrary.db.DbManagerImpl;

import java.io.File;

/**
 * Created by clarence on 16/4/16.
 */
public class DbHelper {
    Context context;

    public DbHelper(Context context) {
        this.context = context;
    }

    public DaoConfig getDaoConfig() {
        DaoConfig daoConfig = new DaoConfig(context)
                .setDbName("test.db")
                // 不设置dbDir时, 默认存储在app的私有目录.
               // .setDbDir(new File("/sdcard")) // "sdcard"的写法并非最佳实践, 这里为了简单, 先这样写了.
                .setDbVersion(2)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
                    @Override
                    public void onDbOpened(DbManager db) {
                        // 开启WAL, 对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        // TODO: ...
                        // db.addColumn(...);
                        // db.dropTable(...);
                        // ...
                        // or
                        // db.dropDb();
                    }
                });
        return daoConfig;
    }
}
