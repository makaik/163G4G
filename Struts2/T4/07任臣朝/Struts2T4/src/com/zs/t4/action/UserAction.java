package com.zs.t4.action;

import com.zs.t4.bean.User;
import com.zs.t4.service.UserService;
import com.zs.t4.service.impl.UserServiceImpl;

public class UserAction {
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String add() throws Exception{
		
		UserService uService = new UserServiceImpl();
		int row = uService.add(user);
		if(row > 0){
			return "success";
		}else{
			return "error";
		}
	}
}
