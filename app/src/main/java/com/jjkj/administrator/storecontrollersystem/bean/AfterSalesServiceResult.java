package com.jjkj.administrator.storecontrollersystem.bean;

import java.util.List;

/**
 * @author Guo JiaMing
 */
public class AfterSalesServiceResult {


    private String result;
    private List<AfterSalesService> customer;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<AfterSalesService> getCustomer() {
        return customer;
    }

    public void setCustomer(List<AfterSalesService> customer) {
        this.customer = customer;
    }
}
