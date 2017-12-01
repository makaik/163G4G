package com.djh.t4.service.impl;

import com.djh.t4.bean.User;
import com.djh.t4.dao.impl.UserDaoImpl;
import com.djh.t4.service.UserService;

public class UserServiceImpl implements UserService {

	public int add(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().add(user);
}
}