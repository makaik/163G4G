/**
 * 
 */
package com.qhit.sbm.common.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.qhit.sbm.user.bean.User;

/**
 * @author admin
 * 2017年11月14日
 */
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("应用程序销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("应用程序初始化");
		List<User> users = new ArrayList<>();
		arg0.getServletContext().setAttribute("online", users);
	}

}
