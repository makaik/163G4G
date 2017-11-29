package com.chen.web;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action{
	private String content;
	private String uname;
	
	public String getUname(){
		return uname;
	}
	
	public void setUname(String uname){
		this.uname = uname;
	}
	
	public String execute() throws Exception{
		content = "您好！" + uname;
		return Action.SUCCESS;
	}
}
