package com.xjl.t2.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckRightInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("拦截器开始销毁");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("拦截器开始执行");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器开始");
		String result = arg0.invoke();
		System.out.println("拦截器结束");
		System.out.println("返回代码："+result);
		return result;
	}

}
