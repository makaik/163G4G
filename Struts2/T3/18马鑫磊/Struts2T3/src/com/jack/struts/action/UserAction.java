package com.jack.struts.action;

import java.util.Date;

import com.jack.struts.action.bean.User;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
private User user;
private Date birthday;

	public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

	public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date=new Date();
		birthday=date;
		return SUCCESS;
	}

}
