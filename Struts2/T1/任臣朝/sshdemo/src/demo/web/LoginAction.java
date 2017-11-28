package demo.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{
	private String uname;
	private String pwd;
	
	public String execute() throws Exception{
		if(uname==null || uname .equals("")||pwd==null||pwd.equals("")){
			ServeletActionContext.getRequest().setAttribute("errorMsg","用户名或密码不能为空");
			return Action.INPUT;
		}
		
		if(uname.equals("zhangsan")&&pwd.equals("123456")){
			ServletActionContext.getRequest().getSession().setAttribute("loginuser", uname);
			return Action.SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名或密码不对");
			return Action.INPUT;
		}
	}

}
