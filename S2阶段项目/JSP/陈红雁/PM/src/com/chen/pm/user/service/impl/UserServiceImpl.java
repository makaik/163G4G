package com.chen.pm.user.service.impl;

import com.chen.pm.user.service.UserService;
import com.chen.pm.user.bean.User;
import com.chen.pm.user.dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService{
	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

}
