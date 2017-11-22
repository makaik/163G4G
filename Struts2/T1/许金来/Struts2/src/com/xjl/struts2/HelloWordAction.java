package com.xjl.struts2;

import javax.swing.text.AbstractDocument.Content;

import com.opensymphony.xwork2.Action;

public class HelloWordAction implements Action {
	private String Content;//保存回应结果数据
	
	
	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Content = "Hello,Word!";
		return Action.SUCCESS;
	}

}
