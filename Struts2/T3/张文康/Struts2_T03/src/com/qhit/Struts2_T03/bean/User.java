package com.qhit.Struts2_T03.bean;

import java.util.Date;

public class User {

	private String name;
	private String sex;
	private String national;
	private Date date;
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String sex, String national, Date date) {
		super();
		this.name = name;
		this.sex = sex;
		this.national = national;
		this.date = date;
	}

	
	
	
}
