package com.jack.struts.action;

import com.jack.struts.bean.User;
import com.jack.struts.service.UserService;
import com.jack.struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class userAction implements Action{
private User user;


public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public UserService getUserService() {
	return userService;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}

UserService userService =new UserServiceImpl();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int row =userService.addUser(user);
		if(row>0){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
	}

}
