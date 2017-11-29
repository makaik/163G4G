package com.lzk.t03.bean;

import java.util.Date;

public class UserInfo {
	private String name;
	private String password;
	private Date date;
	
	
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String name, String password, Date date) {
		super();
		this.name = name;
		this.password = password;
		this.date = date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		date.getTime();
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
