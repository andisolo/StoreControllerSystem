package com.jjkj.administrator.storecontrollersystem.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.jjkj.administrator.storecontrollersystem.dao.DaoSession;
import com.jjkj.administrator.storecontrollersystem.dao.OrderItemDao;
import com.jjkj.administrator.storecontrollersystem.dao.UserDao;
import com.jjkj.administrator.storecontrollersystem.dao.OrderDao;

/**
 * 单笔交易实体类
 *
 * @author Administrator
 */
@Entity
public class Order {
    @Id
    private Long id;
    private int orderNumber;
    private Long userId;
    @ToOne(joinProperty = "userId")
    private User salesman;
    private String customerName;
    @ToMany(referencedJoinProperty = "orderId")
    private List<OrderItem> mItemList;
    private int price;
    private int type;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 949219203)
    private transient OrderDao myDao;
    @Generated(hash = 634388257)
    public Order(Long id, int orderNumber, Long userId, String customerName,
            int price, int type) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.customerName = customerName;
        this.price = price;
        this.type = type;
    }
    @Generated(hash = 1105174599)
    public Order() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getOrderNumber() {
        return this.orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    @Generated(hash = 964321941)
    private transient Long salesman__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1381679384)
    public User getSalesman() {
        Long __key = this.userId;
        if (salesman__resolvedKey == null || !salesman__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User salesmanNew = targetDao.load(__key);
            synchronized (this) {
                salesman = salesmanNew;
                salesman__resolvedKey = __key;
            }
        }
        return salesman;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1008071249)
    public void setSalesman(User salesman) {
        synchronized (this) {
            this.salesman = salesman;
            userId = salesman == null ? null : salesman.getUserId();
            salesman__resolvedKey = userId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 209099162)
    public List<OrderItem> getMItemList() {
        if (mItemList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrderItemDao targetDao = daoSession.getOrderItemDao();
            List<OrderItem> mItemListNew = targetDao._queryOrder_MItemList(id);
            synchronized (this) {
                if (mItemList == null) {
                    mItemList = mItemListNew;
                }
            }
        }
        return mItemList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1602452106)
    public synchronized void resetMItemList() {
        mItemList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 965731666)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderDao() : null;
    }
}
