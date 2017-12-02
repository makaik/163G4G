package com.jack.struts;

import com.jack.struts.bean.User;
import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
private User user;

	public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(user.getName().equals("jack")&&user.getPassword().equals("123456")){
			//登陆成功
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}

}
