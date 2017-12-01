package com.djh.t4.bean;


public class User {
	private String uname;
	private String pswd;
	private String edu;
	private String sex;

	
	public User(String uname, String pswd, String edu, String sex) {
		super();
		this.uname = uname;
		this.pswd = pswd;
		this.edu = edu;
		this.sex = sex;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
