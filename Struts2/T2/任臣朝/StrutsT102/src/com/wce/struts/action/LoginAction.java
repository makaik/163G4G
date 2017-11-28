package com.wce.struts.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String uname;
	private String pswd;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	@Override
	public String execute() throws Exception {
		if(uname == null || uname.equals("") || pswd == null || pswd.equals("") ){
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名或密码不能为空!");
			return Action.INPUT;
		}
		
		if(uname.equals("tom") && pswd.equals("123")){
			ServletActionContext.getRequest().getSession().setAttribute("loginuser", uname);
			return Action.SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名或密码不正确！");
			return Action.INPUT;
		}
	}

}
