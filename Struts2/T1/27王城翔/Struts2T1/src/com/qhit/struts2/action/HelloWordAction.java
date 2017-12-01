package com.qhit.struts2.action;

import com.opensymphony.xwork2.Action;

public class HelloWordAction implements Action {
	
	private String content;
	private String uname;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "hello,"+uname;
		return Action.SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
