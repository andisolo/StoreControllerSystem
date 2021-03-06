package com.jjkj.administrator.storecontrollersystem.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER_ITEM".
*/
public class OrderItemDao extends AbstractDao<OrderItem, Long> {

    public static final String TABLENAME = "ORDER_ITEM";

    /**
     * Properties of entity OrderItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property OrderItemID = new Property(0, Long.class, "orderItemID", true, "_id");
        public final static Property Number = new Property(1, int.class, "number", false, "NUMBER");
        public final static Property Goods = new Property(2, String.class, "goods", false, "GOODS");
        public final static Property Price = new Property(3, int.class, "price", false, "PRICE");
        public final static Property OrderId = new Property(4, Long.class, "orderId", false, "ORDER_ID");
    }

    private Query<OrderItem> order_MItemListQuery;

    public OrderItemDao(DaoConfig config) {
        super(config);
    }
    
    public OrderItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER_ITEM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: orderItemID
                "\"NUMBER\" INTEGER NOT NULL ," + // 1: number
                "\"GOODS\" TEXT," + // 2: goods
                "\"PRICE\" INTEGER NOT NULL ," + // 3: price
                "\"ORDER_ID\" INTEGER);"); // 4: orderId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER_ITEM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderItem entity) {
        stmt.clearBindings();
 
        Long orderItemID = entity.getOrderItemID();
        if (orderItemID != null) {
            stmt.bindLong(1, orderItemID);
        }
        stmt.bindLong(2, entity.getNumber());
 
        String goods = entity.getGoods();
        if (goods != null) {
            stmt.bindString(3, goods);
        }
        stmt.bindLong(4, entity.getPrice());
 
        Long orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindLong(5, orderId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderItem entity) {
        stmt.clearBindings();
 
        Long orderItemID = entity.getOrderItemID();
        if (orderItemID != null) {
            stmt.bindLong(1, orderItemID);
        }
        stmt.bindLong(2, entity.getNumber());
 
        String goods = entity.getGoods();
        if (goods != null) {
            stmt.bindString(3, goods);
        }
        stmt.bindLong(4, entity.getPrice());
 
        Long orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindLong(5, orderId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public OrderItem readEntity(Cursor cursor, int offset) {
        OrderItem entity = new OrderItem( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // orderItemID
            cursor.getInt(offset + 1), // number
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // goods
            cursor.getInt(offset + 3), // price
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // orderId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OrderItem entity, int offset) {
        entity.setOrderItemID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNumber(cursor.getInt(offset + 1));
        entity.setGoods(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPrice(cursor.getInt(offset + 3));
        entity.setOrderId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(OrderItem entity, long rowId) {
        entity.setOrderItemID(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(OrderItem entity) {
        if(entity != null) {
            return entity.getOrderItemID();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(OrderItem entity) {
        return entity.getOrderItemID() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "mItemList" to-many relationship of Order. */
    public List<OrderItem> _queryOrder_MItemList(Long orderId) {
        synchronized (this) {
            if (order_MItemListQuery == null) {
                QueryBuilder<OrderItem> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.OrderId.eq(null));
                order_MItemListQuery = queryBuilder.build();
            }
        }
        Query<OrderItem> query = order_MItemListQuery.forCurrentThread();
        query.setParameter(0, orderId);
        return query.list();
    }

}
