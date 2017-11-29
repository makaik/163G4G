package com.sea.sbms.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.user.bean.User;
import com.sea.sbms.user.service.UserService;
import com.sea.sbms.user.service.impl.UserServiceImpl;
import com.sea.sbms.utils.Constant;
import com.sea.sbms.utils.IDUtil;

public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	private User user = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

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
		case "updatePwd":
			doUpdataPwd(request, response);
			break;
		case "allUser":
			allUser(request, response);
			break;
		case "findUser":
			findUser(request, response);
			break;
		case "updataUser":
			updataUser(request, response);
			break;
		case "deleteUser":
			deleteUser(request, response);
			break;
		case "addUser":
			addUser(request, response);
			break;
		case "uploadPic":
			uploadPic(request, response);
			break;
		default:
			break;
		}
	}

	private void uploadPic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		smartUpload.setAllowedFilesList("png,jpg,jpeg,gif");//允许上传的文件类型
		smartUpload.setMaxFileSize(1024*1024*5);//允许上传的最大文件
		try {
			//上传文件
			smartUpload.upload();
			//samrtuoload组件提供的请求对象，表单的参数都在这个request对象中存取的，而不在jsp内置对象request中了
			Request sRequest = smartUpload.getRequest();
			//获取要上传文件的对象
			File file = smartUpload.getFiles().getFile(0);
			//保存文件,确保文件无中文，唯一性
			//12306:100w/1000=1000:
			//uuid的文件名
			//图片名称
			String picName = IDUtil.getUUID();
			String picFilePath = Constant.FILE_USER_PHOTO_PATH;
			java.io.File filePath = new java.io.File(request.getRealPath("/")+picFilePath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			//文件的后缀名
			String extName = file.getFileExt();
			//图片的文件相对路径(存在数据库的路径)
			String picPath = picFilePath + picName + "." +extName;
			//保存路径
			String savePath = request.getRealPath("/") + picPath;
			//另存为（可以修改名字）
			file.saveAs(savePath);
			//如果保存成功了将继续往下执行，然后添加用户数据，因为需要使用原请求的用户参数，所以必须使用请求转发
			request.setAttribute("userName", sRequest.getParameter("userName"));
			request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
			request.setAttribute("userSex", sRequest.getParameter("userSex"));
			request.setAttribute("userAge", sRequest.getParameter("userAge"));
			request.setAttribute("telephone", sRequest.getParameter("telephone"));
			request.setAttribute("address", sRequest.getParameter("address"));
			request.setAttribute("type", sRequest.getParameter("type"));
			request.setAttribute("pic", picPath);//第2步得到的图片保存的相对路径，需要存在数据库中
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user?cmd=addUser");
			requestDispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userSex = request.getParameter("userSex");
		String userAge = request.getParameter("userAge");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		
		String pic = request.getParameter("pic");
		
		user = new User(
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
		if(row > 0){
			//添加成功:重新查询添加后的用户列表，然后进入到用户列表分页页面
//			out.print("<script>alert('添加用户成功!');</script>");
			response.sendRedirect("user?cmd=allUser&&p=1");
		}else{
			//添加失败
			out.print("<script>alert('添加用户失败!');</script>");
		}
	}

	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		
		int row = userService.deleteUser(Integer.parseInt(userId));
		if (row > 0) {
			// 删除成功
			response.sendRedirect("user?cmd=allUser&&p=1");
		} else {
			// 删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}

	private void updataUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		user = new User();
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		String userAge = request.getParameter("userAge");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		
		user.setUserName(userName);
		user.setUserSex(userSex);
		user.setUserAge(Integer.parseInt(userAge));
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setType(Integer.parseInt(type));
		
		int row = userService.updateUser(user, Integer.parseInt(userId));
		
		if (row > 0) {
			// 修改成功
			response.sendRedirect("user?cmd=allUser&&p=1");
		} else {
			// 修改失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('修改失败');</script>");
		}
	}

	private void findUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int p = 1;//默认显示第一页
		String ps = request.getParameter("p");//获取页面中传递过来的页码
		
		if(ps!=null) p = Integer.parseInt(ps);
		
		String userName = request.getParameter("userName");
		user.setUserName(userName);
		
		PageBean pb = userService.findUser(user, p);
		
		
		request.getSession().setAttribute("pb", pb);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href='jsp/userAdmin.jsp'</script>");
	}

	private void allUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int p = 1;//默认显示第一页
		String ps = request.getParameter("p");//获取页面中传递过来的页码
		
		if(ps!=null) p = Integer.parseInt(ps);
		
		PageBean pb = userService.allUser(p);
		
		request.getSession().setAttribute("pb", pb);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href='jsp/userAdmin.jsp'</script>");
	}

	private void doUpdataPwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String userPassword1 = request.getParameter("userPassword1");

		User user = (User) request.getSession().getAttribute("user");
		
		int row = userService.updatePwd(user.getUserId(), userPassword1);
			if (row > 0) {
				// 修改成功
				response.sendRedirect("user?cmd=exit");
			}else {
				PrintWriter out = response.getWriter();
				out.print("<script>alert('请重新输入密码');</script>");
			}
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 退出，销毁seesion
		request.getSession().invalidate();
		// 退出后重定向到登录页面
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		PrintWriter out = response.getWriter();
		out.print("<script>window.top.location.href='" + basePath
				+ "'</script>");
	}

	private void doUserLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean isLogin = false;
		ServletContext application = request.getServletContext();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		user = userService.doLogin(userName, userPassword);
		if (user != null) {
			// 登陸成功
			request.getSession().setAttribute("user", user);
			// 添加到在线用户集合中
			List<User> users = (List<User>) application.getAttribute("online");
			// 添加当前用户到在线用户集合中:注意：需要先判断该用户是否已经登录
			for (User userOnline : users) {
				if (userOnline.getUserId() == user.getUserId()) {
					isLogin = true;
				}
			}
			// 遍历查询完，该用户没有在线，然后再把他存在在线用户集合中
			if (!isLogin) {
				users.add(user);
				// 更新application中在线用户集合
				application.setAttribute("online", users);
			}
			// 进入管理页面之前需要先去查询账单分页列表数据
			response.sendRedirect("account?cmd=getPagebean");
		} else {
			// 登錄失敗
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}

}
