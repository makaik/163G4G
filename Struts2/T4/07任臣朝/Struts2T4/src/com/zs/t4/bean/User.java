package com.zs.t4.bean;

import java.util.Date;

public class User {
	private String name;
	private String pwd;
	private String date;
	private int sex;
	private String[] like;
	private String[] nativeplace;
	private String 	memo;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String name, String pwd, String date, int sex, String[] like,
			String[] nativeplace, String memo) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.date = date;
		this.sex = sex;
		this.like = like;
		this.nativeplace = nativeplace;
		this.memo = memo;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String[] getLike() {
		return like;
	}
	public void setLike(String[] like) {
		this.like = like;
	}
	public String[] getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String[] nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
