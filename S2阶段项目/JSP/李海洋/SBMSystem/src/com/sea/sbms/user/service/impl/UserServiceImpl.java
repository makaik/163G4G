package com.sea.sbms.user.service.impl;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.user.bean.User;
import com.sea.sbms.user.dao.impl.UserDaoImpl;
import com.sea.sbms.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(String userName, String userPassword) {
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

	@Override
	public int updatePwd(int userId, String userPassword1) {
		return new UserDaoImpl().updatePwd(userId, userPassword1);
	}

	@Override
	public PageBean allUser(int p) {
		return new UserDaoImpl().allUser(p);
	}

	@Override
	public PageBean findUser(User user, int p) {
		return new UserDaoImpl().findUser(user, p);
	}

	@Override
	public int deleteUser(int userId) {
		return new UserDaoImpl().deleteUser(userId);
	}

	@Override
	public int updateUser(User user, int userId) {
		return new UserDaoImpl().updateUser(user, userId);
	}

	@Override
	public int addUser(User user) {
		return new UserDaoImpl().addUser(user);
	}
}
