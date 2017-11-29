package com.chen.pm.user.dao;

import com.chen.pm.user.bean.User;

public interface UserDao {
	public int addUser(User user);
	public User doLogin(String userName,String userPassword);

}
