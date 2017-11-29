package com.lzk.t03.bean;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private UserInfo userinfo;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	
}
