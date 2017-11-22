package com.sea.test.interceptor;



import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrintInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("开始拦截start");
		String result = arg0.invoke();
		System.out.println("拦截结束end");
		System.out.println("返回代码："+result);
		return result;
	}

}
