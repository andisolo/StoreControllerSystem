package com.jjkj.administrator.storecontrollersystem.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 单笔交易实体类
 *
 * @author Administrator
 */
@Entity
public class Order {
    @Id
    private long id;
    private long orderNumber;
    private String salesman;
    private String customerName;
    private int price;
    @Generated(hash = 1998382151)
    public Order(long id, long orderNumber, String salesman, String customerName,
            int price) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.salesman = salesman;
        this.customerName = customerName;
        this.price = price;
    }
    @Generated(hash = 1105174599)
    public Order() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getOrderNumber() {
        return this.orderNumber;
    }
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getSalesman() {
        return this.salesman;
    }
    public void setSalesman(String salesman) {
        this.salesman = salesman;
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
}
