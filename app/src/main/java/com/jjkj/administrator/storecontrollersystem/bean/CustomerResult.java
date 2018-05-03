package com.jjkj.administrator.storecontrollersystem.bean;

import java.util.List;

public class CustomerResult {

    private String result;
    private List<Customer> customer;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
