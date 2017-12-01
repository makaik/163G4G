package com.perfact.sbm.user.dao;

import com.perfact.sbm.user.bean.User;

public interface UserDao {
	public User doLogin(String userName,String userPassword);
	public int addUser(User user);
}
