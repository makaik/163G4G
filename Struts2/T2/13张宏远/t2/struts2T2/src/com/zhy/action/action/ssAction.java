package com.zhy.action.action;

import com.opensymphony.xwork2.Action;


public class ssAction implements Action {
			private String Content;
			private String uname;
			@Override
			public String execute() throws Exception {
				// TODO Auto-generated method stub
				Content = "hello"+uname;
				return Action.SUCCESS;
			}
			public String getContent() {
				return Content;
			}
			public void setContent(String content) {
				Content = content;
			}
			public String getUname() {
				return uname;
			}
			public void setUname(String uname) {
				this.uname = uname;
			}


			
}
