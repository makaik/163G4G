package com.perfact.t02.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String pwd;
	private String name;
	private String HHH;
	

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HHH = "嘿！ " + name+ " ，老子一反手就是一发意大利炮打你脸上！";
		return Action.SUCCESS;
	}
	
	
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getHHH() {
		return HHH;
	}


	public void setHHH(String hHH) {
		HHH = hHH;
	}


}
