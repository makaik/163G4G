package com.lzk.t4.service.impl;

import com.lzk.t4.bean.User;
import com.lzk.t4.dao.impl.UserDaoImpl;
import com.lzk.t4.service.UserService;



public class UserServiceImpl implements UserService {

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().add(user);
	}

}
