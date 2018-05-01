package com.jjkj.administrator.storecontrollersystem.bean;

import java.io.File;
import java.util.Date;

/**
 * @author Administrator
 */

public class Person {
	private Integer id;
	private String name;
	private String age;
	private String phone;
	private Integer basePay;
	private Integer achievement;
	private Date entryDate;
	private File picture;
	private String meId;

	public String getMeId() {
		return meId;
	}

	public void setMeId(String meId) {
		this.meId = meId;
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


	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getBasePay() {
		return basePay;
	}

	public void setBasePay(Integer basePay) {
		this.basePay = basePay;
	}

	public Integer getAchievement() {
		return achievement;
	}

	public void setAchievement(Integer achievement) {
		this.achievement = achievement;
	}


	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}


	public File getPicture() {
		return picture;
	}

	public void setPicture(File file) {
		this.picture = file;
	}

}
