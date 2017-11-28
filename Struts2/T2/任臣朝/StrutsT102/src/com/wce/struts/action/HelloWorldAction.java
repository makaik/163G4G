package com.wce.struts.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String content;
	private String uname;
	
	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(uname.length() <= 3){
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名必须大于等于3位");
			return Action.LOGIN;
		}else{
			return Action.SUCCESS;
		}

	}

}
