package com.jack.struts.service.impl;

import com.jack.struts.bean.User;
import com.jack.struts.dao.impl.UserDaoImpl;
import com.jack.struts.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

}
