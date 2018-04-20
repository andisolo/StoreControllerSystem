package com.jjkj.administrator.storecontrollersystem.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Administrator
 */
@Entity
public class OrderItem {
    @Id()
    private Long orderItemID;
    private int number;
    private String goods;
    private int price;
    private Long orderId;
    @Generated(hash = 16912071)
    public OrderItem(Long orderItemID, int number, String goods, int price,
            Long orderId) {
        this.orderItemID = orderItemID;
        this.number = number;
        this.goods = goods;
        this.price = price;
        this.orderId = orderId;
    }
    @Generated(hash = 403153068)
    public OrderItem() {
    }
    public Long getOrderItemID() {
        return this.orderItemID;
    }
    public void setOrderItemID(Long orderItemID) {
        this.orderItemID = orderItemID;
    }
    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getGoods() {
        return this.goods;
    }
    public void setGoods(String goods) {
        this.goods = goods;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Long getOrderId() {
        return this.orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
