package com.syw.struts;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String content;
	private String uname;
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content="hello!  "+uname;
		return Action.SUCCESS;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}
}
