package com.qhit.Struts2_T03.Actions;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.qhit.Struts2_T03.bean.User;

public class loginAction implements Action {

	private User user ;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//user.setDate(new Date());
		//System.out.println(new Date());
		user.setDate(new Date());
		return Action.SUCCESS;
	}

}
