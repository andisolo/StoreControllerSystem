package com.jjkj.administrator.storecontrollersystem.bean;

import java.util.List;

/**
 * @author lenovo
 * Created on 2018-5-1.
 * @description
 */
public class SlipResult {
	private String result;
	private List<SalesSlip> salesSlip;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<SalesSlip> getSalesSlip() {
		return salesSlip;
	}

	public void setSalesSlip(List<SalesSlip> salesSlip) {
		this.salesSlip = salesSlip;
	}
}
