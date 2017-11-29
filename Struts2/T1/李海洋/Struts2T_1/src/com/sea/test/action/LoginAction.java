package com.sea.test.action;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;


public class LoginAction implements Action {
	private String uname;
	private String pwd;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//HttpServletRequest request = ServletActionContext.getRequest();
		
		//String uname = request.getParameter("uname");
		//String pwd = request.getParameter("pwd");
		if (uname != null && !"".equals(uname) && pwd != null && !"".equals(pwd)) {
			if (uname.equals("Sea")&&pwd.equals("123456")) {
				ServletActionContext.getRequest().getSession().setAttribute("uname", uname);
				//request.setAttribute("uname", uname);
				return Action.SUCCESS;
			}else {
				return Action.ERROR;
			}
		}
		return Action.NONE;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
