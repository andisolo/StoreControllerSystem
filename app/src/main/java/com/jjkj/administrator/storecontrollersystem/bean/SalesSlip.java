package com.jjkj.administrator.storecontrollersystem.bean;

import java.io.File;
import java.util.List;

/**
 * @author Administrator
 */

public class SalesSlip {
	private Integer id;
	private Double price;
	private String style;
	private File picture;
	private String customerName;
	private String customerPhone;
	private String salesPerson;
	private List<SalesEntry> entries;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public List<SalesEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<SalesEntry> entries) {
		this.entries = entries;
	}

}
