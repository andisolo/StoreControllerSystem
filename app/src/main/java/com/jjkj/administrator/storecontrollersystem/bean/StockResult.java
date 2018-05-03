package com.jjkj.administrator.storecontrollersystem.bean;

import java.util.List;

/**
 * @author Guo JiaMing
 */
public class StockResult {

    private String result;
    private List<Stock> stock;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }
}
