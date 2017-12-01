package com.jer.t4.action;

import com.jer.t4.bean.User;
import com.jer.t4.service.UserService;
import com.jer.t4.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	UserService uService = new UserServiceImpl();
	
	public String add() throws Exception {
		int row = uService.add(user);
		if (row>0) {
			return "success";
		}else{
			return "error";			
		}
		
	}
}
