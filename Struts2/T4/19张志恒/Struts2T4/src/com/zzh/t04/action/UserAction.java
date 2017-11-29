package com.zzh.t04.action;

import com.opensymphony.xwork2.Action;
import com.zzh.t04.bean.User;
import com.zzh.t04.service.UserService;
import com.zzh.t04.service.impl.UserServiceImpl;

public class UserAction implements Action {
	private User user;
	UserService uService = new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		int row = uService.add(user);
		if(row > 0){
			return "success";
		}else{
			return "error";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
