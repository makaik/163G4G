package com.zzh.t04.bean;

public class User {
	private String name;
	private String password;
	private String birthday;
	private String sex;
	private String love;
	private String active;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String password, String birthday, String sex,
			String love, String active) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.love = love;
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
