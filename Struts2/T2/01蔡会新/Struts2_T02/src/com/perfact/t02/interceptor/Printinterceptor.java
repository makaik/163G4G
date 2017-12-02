package com.perfact.t02.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Printinterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("自定义拦截器被破坏");

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("自定义拦截器初始化");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("自定义拦截器的执行start");
		String result = arg0.invoke();
		System.out.println("自定义拦截器的响应结果:"+result);
		System.out.println("自定义拦截器执行end");
		return result;
	}

}
