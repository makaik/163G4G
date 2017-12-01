package com.perfact.sbm.user.service;

import com.perfact.sbm.user.bean.User;

public interface UserService {
	public User doLogin(String userName,String userPassword);
	public int addUser(User user);
}
