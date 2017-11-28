package com.jer.holle;

import com.opensymphony.xwork2.Action;

public class HelloStruts implements Action {
	
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Content = "Hello,world!" ;
		return Action.SUCCESS;
	}

}
