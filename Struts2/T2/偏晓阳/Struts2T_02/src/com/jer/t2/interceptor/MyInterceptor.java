package com.jer.t2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
				System.out.println("我开始拦截……");
				String result = invocation.invoke();
				System.out.println("返回代码：" + result);
				return result;
	}
}
