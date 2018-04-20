package com.jjkj.administrator.storecontrollersystem.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户信息实体类
 *
 * @author Administrator
 */
@Entity
public class User {
    @Id
    private Long userId;
    private String name;
    private int age;
    private String phoneNum;
    private int performance;
    private int salary;
    private Date entryDate;
    private int level;
    @Generated(hash = 716730717)
    public User(Long userId, String name, int age, String phoneNum, int performance,
            int salary, Date entryDate, int level) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
        this.performance = performance;
        this.salary = salary;
        this.entryDate = entryDate;
        this.level = level;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhoneNum() {
        return this.phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public int getPerformance() {
        return this.performance;
    }
    public void setPerformance(int performance) {
        this.performance = performance;
    }
    public int getSalary() {
        return this.salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Date getEntryDate() {
        return this.entryDate;
    }
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
