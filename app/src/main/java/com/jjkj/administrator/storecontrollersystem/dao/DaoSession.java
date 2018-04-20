package com.jjkj.administrator.storecontrollersystem.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.jjkj.administrator.storecontrollersystem.entity.User;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;

import com.jjkj.administrator.storecontrollersystem.dao.UserDao;
import com.jjkj.administrator.storecontrollersystem.dao.OrderDao;
import com.jjkj.administrator.storecontrollersystem.dao.OrderItemDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig orderDaoConfig;
    private final DaoConfig orderItemDaoConfig;

    private final UserDao userDao;
    private final OrderDao orderDao;
    private final OrderItemDao orderItemDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        orderDaoConfig = daoConfigMap.get(OrderDao.class).clone();
        orderDaoConfig.initIdentityScope(type);

        orderItemDaoConfig = daoConfigMap.get(OrderItemDao.class).clone();
        orderItemDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        orderDao = new OrderDao(orderDaoConfig, this);
        orderItemDao = new OrderItemDao(orderItemDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Order.class, orderDao);
        registerDao(OrderItem.class, orderItemDao);
    }
    
    public void clear() {
        userDaoConfig.clearIdentityScope();
        orderDaoConfig.clearIdentityScope();
        orderItemDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public OrderItemDao getOrderItemDao() {
        return orderItemDao;
    }

}
