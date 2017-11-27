package com.syw.t3.action;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.syw.t3.bean.User;

public class UserAction implements Action {
	private User user;
	private Date date;
	public UserAction() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		date = new Date();
		return Action.SUCCESS;
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
