package com.sea.adduser.dao;

import java.util.List;

import com.sea.adduser.bean.User;

public interface CRUD {
	//添加
	 public void addUser(User user);
	 //遍历查询
	 public List<User> allUser();
	 //删除
	 public void del(int userId);
	 //预修改
	 public User perUpdate(int userId);
	 //修改
	 public void update(User user);
}
