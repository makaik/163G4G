package com.perfact.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.perfact.sbm.user.bean.User;
import com.perfact.sbm.user.service.UserService;
import com.perfact.sbm.user.service.impl.UserServiceImpl;
import com.perfact.sbm.utils.Constant;
import com.perfact.sbm.utils.IDUtil;
import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
     private UserService userService = new UserServiceImpl(); 
     private User user = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "userLogin":
			doUserLogin(request,response);
			break;
		case "exit":
			doExit(request,response);
			break;
		case "uploadPic":
			douploadPic(request,response);
			break;
		case "addUser":
			doaddUser(request,response);
			break;
		default:
			break;
		}
	}

	private void doaddUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userName = (String) request.getAttribute("userName");
		String userPassword = (String) request.getAttribute("userPassword");
		String userSex = (String) request.getAttribute("userSex");
		String userAge = (String) request.getAttribute("userAge");
		String telephone = (String) request.getAttribute("telephone");
		String address = (String) request.getAttribute("address");
		String type = (String) request.getAttribute("type");
		String pic = (String) request.getAttribute("pic");
		
		User user = new User(
				userName, 
				userPassword,
				userSex,
				Integer.parseInt(userAge),
				telephone, 
				address, 
				pic,
				Integer.parseInt(type));
		
		int row = userService.addUser(user);
		PrintWriter out = response.getWriter();
		if(row > 0) {
			response.sendRedirect("jsp/userInfo.jsp?picPath="+pic);
		}else {
			out.println("<script>alert('添加用户是失败!')</script>");
		}
	}

	private void douploadPic(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		smartUpload.setAllowedFilesList("png,jpg,jpeg,gif");
		smartUpload.setMaxFileSize(1024*1021*5);
		try {
			smartUpload.upload();
			Request sRequest = smartUpload.getRequest();
			File file = smartUpload.getFiles().getFile(0);
			String picName = IDUtil.getUUID();
			String picFilePath = Constant.FILE_USER_PHOTO_PATH;
			java.io.File filePath = new java.io.File(request.getRealPath("/")+picFilePath);
			if(!filePath.exists()) {
				filePath.mkdirs();
			}
			String extName = file.getFileExt();
			String picPath = picFilePath + picName + "." + extName;
			String savePath = request.getRealPath("/") + picPath;
			file.saveAs(savePath);
			
			request.setAttribute("userName", sRequest.getParameter("userName"));
			request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
			request.setAttribute("userSex", sRequest.getParameter("userSex"));
			request.setAttribute("userAge", sRequest.getParameter("userAge"));
			request.setAttribute("telephone", sRequest.getParameter("telephone"));
			request.setAttribute("address", sRequest.getParameter("address"));
			request.setAttribute("pic", sRequest.getParameter("pic"));
			request.setAttribute("type", sRequest.getParameter("type"));
			request.setAttribute("pic", picPath);
			RequestDispatcher registry = request.getRequestDispatcher("../user?cmd=addUser");
			registry.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		PrintWriter out = response.getWriter();
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
		
	}

	private void doUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean isLogin = false;
		ServletContext application = request.getServletContext();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		user = userService.doLogin(userName, userPassword);
		if(user != null){
			request.getSession().setAttribute("user", user);
			List<User> users = (List<User>) application.getAttribute("online");
			for(User userOnline : users){
				if(userOnline.getUserId() == user.getUserId()){
					isLogin = true;
				}
			}
			
			if(!isLogin){
				users.add(user);
				application.setAttribute("online", users);
			}
			response.sendRedirect("account?cmd=getPagebean");
		}else{
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}

}
