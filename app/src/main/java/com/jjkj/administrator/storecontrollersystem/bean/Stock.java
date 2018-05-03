package com.jjkj.administrator.storecontrollersystem.bean;

/**
 * @author Administrator
 */

public class Stock {
    private Integer id;
    private String name;
    private String number;
    private Integer lastCount;
    private String lastCountDate;
    private Integer dueQuantity;
    private String person;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Integer getLastCount() {
        return lastCount;
    }

    public void setLastCount(Integer lastCount) {
        this.lastCount = lastCount;
    }


    public String getLastCountDate() {
        return lastCountDate;
    }

    public void setLastCountDate(String lastCountDate) {
        this.lastCountDate = lastCountDate;
    }


    public Integer getDueQuantity() {
        return dueQuantity;
    }

    public void setDueQuantity(Integer dueQuantity) {
        this.dueQuantity = dueQuantity;
    }
}
