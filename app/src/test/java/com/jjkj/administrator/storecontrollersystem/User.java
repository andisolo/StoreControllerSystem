package com.jjkj.administrator.storecontrollersystem;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author lenovo
 * Created on 2018-4-25.
 * @description
 */

@XStreamAlias("User")
public class User {
	@XStreamAlias("name")
	private String username;

	@XStreamAlias("pass")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
