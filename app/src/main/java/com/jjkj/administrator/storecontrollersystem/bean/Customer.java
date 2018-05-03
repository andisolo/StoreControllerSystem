package com.jjkj.administrator.storecontrollersystem.bean;

/**
 * @author Administrator
 */

public class Customer {
    private Integer id;
    private String name;
    private String age;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String number) {
        this.phone = number;
    }
}
