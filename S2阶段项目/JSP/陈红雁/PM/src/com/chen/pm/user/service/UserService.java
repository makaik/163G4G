package com.chen.pm.user.service;

import com.chen.pm.user.bean.User;

public interface UserService {
	public int addUser(User user);
	public User doLogin(String userName,String userPassword);

}
