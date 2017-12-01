package com.perfact.t01.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String content;
	private String uname;
	
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "嘿!你的益达。" + uname;
		return Action.SUCCESS;
	}

}
