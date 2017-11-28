package com.wce.nxte.login;

import com.wce.nxte.action.Action;
import com.wce.nxte.user.UserInfo;

public class LoginAction implements Action {
	private UserInfo userinfo;

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}
