package com.perfact.sbm.user.service.impl;

import com.perfact.sbm.user.bean.User;
import com.perfact.sbm.user.dao.impl.UserDaoImpl;
import com.perfact.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {

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
