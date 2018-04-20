package com.jjkj.administrator.storecontrollersystem.db;

import com.jjkj.administrator.storecontrollersystem.app.MyApplication;
import com.jjkj.administrator.storecontrollersystem.dao.OrderDao;
import com.jjkj.administrator.storecontrollersystem.dao.OrderItemDao;
import com.jjkj.administrator.storecontrollersystem.dao.UserDao;

/**
 * Dao获取工具类
 *
 * @author Administrator
 */
@SuppressWarnings("unused")
public interface DaoHelper {
    /**
     * 获取 UserDao
     *
     * @return UserDao
     */
    default UserDao getUserDao() {
        return DbManager.getDaoSession(MyApplication.getContext()).getUserDao();
    }

    /**
     * 获取 OrderDao
     *
     * @return OrderDao
     */
    default OrderDao getOrderDao() {
        return DbManager.getDaoSession(MyApplication.getContext()).getOrderDao();
    }

    /**
     * 获取 OrderItemDao
     *
     * @return OrderItemDao
     */
    default OrderItemDao getOrderItemDao() {
        return DbManager.getDaoSession(MyApplication.getContext()).getOrderItemDao();
    }
}
