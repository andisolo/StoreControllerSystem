package com.jjkj.administrator.storecontrollersystem.bean;

/**
 * @author Administrator
 */

public class SalesEntry {
	private Integer id;
	private String salesType;
	private String commodityCode;
	private String commodityName;
	private Integer commodityQuantity;
	private Double totalCommodityPrice;
	private SalesSlip salesSlip;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}


	public Integer getCommodityQuantity() {
		return commodityQuantity;
	}

	public void setCommodityQuantity(Integer commodityQuantity) {
		this.commodityQuantity = commodityQuantity;
	}


	public Double getTotalCommodityPrice() {
		return totalCommodityPrice;
	}

	public void setTotalCommodityPrice(Double totalCommodityPrice) {
		this.totalCommodityPrice = totalCommodityPrice;
	}


	public SalesSlip getSalesSlip() {
		return salesSlip;
	}

	public void setSalesSlip(SalesSlip salesSlip) {
		this.salesSlip = salesSlip;
	}
}
