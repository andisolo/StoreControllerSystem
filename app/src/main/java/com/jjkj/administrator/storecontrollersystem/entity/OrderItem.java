package com.jjkj.administrator.storecontrollersystem.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Administrator
 */
@Entity
public class OrderItem {
    @Id
    private int id;
    private int number;
    private String goods;
    private int price;
    @Generated(hash = 1815799288)
    public OrderItem(int id, int number, String goods, int price) {
        this.id = id;
        this.number = number;
        this.goods = goods;
        this.price = price;
    }
    @Generated(hash = 403153068)
    public OrderItem() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
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
}
