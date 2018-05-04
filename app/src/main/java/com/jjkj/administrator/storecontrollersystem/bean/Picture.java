package com.jjkj.administrator.storecontrollersystem.bean;

/**
 * @author Guo JiaMing
 */
public class Picture {
    private Customer customer;
    private int id;
    private String makeDate;
    private Object picture;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(String makeDate) {
        this.makeDate = makeDate;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }
}
