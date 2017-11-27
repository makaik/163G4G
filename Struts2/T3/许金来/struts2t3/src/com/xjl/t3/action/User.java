package com.xjl.t3.action;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.xjl.t3.bean.UserInfo;

public class User implements Action {

	private UserInfo userinfo;
	private Date date;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		date = new Date();
		return Action.SUCCESS;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
