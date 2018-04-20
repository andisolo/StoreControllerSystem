package com.jjkj.administrator.storecontrollersystem.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jjkj.administrator.storecontrollersystem.dao.DaoMaster;
import com.jjkj.administrator.storecontrollersystem.dao.DaoSession;

/**
 * @author Administrator
 */
public class DbManager {
    public static final boolean ENCRYPTED = true;
    private static final String DB_NAME = "user.db";
    private Context mContext;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static DbManager mDbManager;


    private DbManager(Context context) {
        this.mContext = context;
        // 初始化数据库信息
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }

    public static DbManager getInstance(Context context) {
        if (null == mDbManager) {
            synchronized (DbManager.class) {
                if (null == mDbManager) {
                    mDbManager = new DbManager(context);
                }
            }
        }
        return mDbManager;
    }

    /**
     * 获取可读数据库
     *
     * @param context context
     * @return SQLiteDatabase
     */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @param context context
     * @return SQLiteDatabase
     */
    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }

        return mDevOpenHelper.getWritableDatabase();
    }

    /**
     * 获取DaoMaster
     *
     * @param context context
     * @return DaoMaster
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DbManager.class) {
                if (null == mDaoMaster) {
                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
                }
            }
        }
        return mDaoMaster;
    }

    /**
     * 获取DaoSession
     *
     * @param context context
     * @return DaoSession
     */
    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DbManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }
}
