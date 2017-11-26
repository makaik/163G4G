package com.qhit.Struts2_T02;

import com.opensymphony.xwork2.Action;

public class loginAction implements Action {

	private String content ;
	private String unam;
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUnam() {
		return unam;
	}

	public void setUnam(String unam) {
		this.unam = unam;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "您好：" + unam;
		return Action.SUCCESS;
	}

}
