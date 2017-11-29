package com.chen.web;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action{

	private String content;
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String execute() throws Exception{
		content = "Hello,world!";
		return Action.SUCCESS;
	}
}
