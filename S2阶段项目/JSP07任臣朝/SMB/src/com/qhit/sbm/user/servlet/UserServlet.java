/**
 * 
 */
package com.qhit.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;
import com.qhit.sbm.user.service.impl.UserServiceImpl;

/**
 * @author admin
 * 2017年11月11日
 */
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	private User user = null;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "userLogin":
			doUserLogin(request, response);
			break;
		case "exit":
			doExit(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//退出，销毁seesion
		request.getSession().invalidate();
		//退出后重定向到登录页面
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		PrintWriter out = response.getWriter();
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	}

	/**
	 * @param request
	 * @param response
	 * 登錄
	 * @throws IOException 
	 */
	private void doUserLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean isLogin = false;
		ServletContext application = request.getServletContext();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		user = userService.doLogin(userName, userPassword);
		if (user != null) {
			//登陸成功
			request.getSession().setAttribute("user", user);
			//添加到在线用户集合中
			List<User> users = (List<User>) application.getAttribute("online");
			//添加当前用户到在线用户集合中:注意：需要先判断该用户是否已经登录
			for (User userOnline : users) {
				if(userOnline.getUserId() == user.getUserId()){
					isLogin = true;
				}
			}
			//遍历查询完，该用户没有在线，然后再把他存在在线用户集合中
			if(!isLogin){
				users.add(user);
				//更新application中在线用户集合
				application.setAttribute("online", users);
			}
			//进入管理页面之前需要先去查询账单分页列表数据
			response.sendRedirect("account?cmd=getPagebean");
		} else {
			//登錄失敗
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}

}
