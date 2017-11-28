package com.wce.struts.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckInterceptor extends AbstractInterceptor  {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Object value = arg0.getInvocationContext().getSession().get("loginuser");
		
		if(value == null){
			return Action.LOGIN;
		}else{
			System.out.println("登录信息："+value);
			return arg0.invoke();
		}
	}

}
