package com.syw.t3.bean;

public class User {
	private String uname;
	private String upwd;
	private String age;
	private String add;
	
	
	public User(String uname, String upwd, String age, String add, String date) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.add = add;
	}

	public User(String uname, String upwd, String age, String add) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.add = add;
		
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public User() {
		// TODO Auto-generated constructor stub
		
	}

}
