package com.sea.adduser.action;

import java.util.List;

import com.sea.adduser.bean.User;
import com.sea.adduser.dao.CRUD;
import com.sea.adduser.dao.impl.CRUDImpl;

public class UserAction {
	private CRUD crud = new CRUDImpl() ;
	private User user;
	private List<User> userlist;

	public String addUser() throws Exception{
		if (user!=null) {
			crud.addUser(user);
		}
		return "tolist";
	}
	public String allUser() throws Exception{
		userlist = crud.allUser();
		return "list";
	}
	public String del() throws Exception {
		crud.del(user.getUserId());
		return "tolist";
	}
	public String perUpdate() throws Exception{
		userlist = (List<User>) crud.perUpdate(user.getUserId());
		return "update";
	}
	public String update() throws Exception{
		if (user!=null) {
			crud.del(user.getUserId());
		}
		return "tolist";
	}
	public CRUD getCrud() {
		return crud;
	}
	public void setCrud(CRUD crud) {
		this.crud = crud;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
}