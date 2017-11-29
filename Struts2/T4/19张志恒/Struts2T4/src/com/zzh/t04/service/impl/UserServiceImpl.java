package com.zzh.t04.service.impl;

import com.zzh.t04.bean.User;
import com.zzh.t04.dao.impl.UserDaoImpl;
import com.zzh.t04.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().add(user);
	}

}
