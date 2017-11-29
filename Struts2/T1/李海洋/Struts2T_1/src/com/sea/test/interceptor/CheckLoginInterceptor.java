package com.sea.test.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		Object value = arg0.getInvocationContext().getParameters().get("uname");
		if (value == null) {
			System.out.println("该用户不存在！");
			return Action.LOGIN;
		}else {
			System.out.println("登录信息："+value);
			return arg0.invoke();
		}
	}

}
