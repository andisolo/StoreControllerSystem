package com.jjkj.administrator.storecontrollersystem.bean;

import java.util.List;

/**
 * @author lenovo
 * Created on 2018-5-1.
 * @description
 */
public class PersonResult {
	private String result;
	private List<Person> person;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
}
