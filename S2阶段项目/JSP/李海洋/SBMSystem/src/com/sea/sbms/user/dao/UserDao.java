package com.sea.sbms.user.dao;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.user.bean.User;

public interface UserDao {

	public User doLogin(String userName, String userPassword);
	
	public PageBean allUser(int p);
	
	public int updatePwd(int userId,String userPassword1);
	
	public PageBean findUser(User user,int p);
	
	public int deleteUser(int userId);
	
	public int updateUser(User user,int userId);
	
	public int addUser(User user);
}
