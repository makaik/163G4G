package com.perfact.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfact.sbm.account.service.AccountService;
import com.perfact.sbm.account.service.impl.AccountServiceImpl;
import com.perfact.sbm.common.bean.PageBean;
import com.perfact.sbm.common.service.CommonService;
import com.perfact.sbm.common.service.impl.CommonServiceImpl;
import com.perfact.sbm.goods.bean.Goods;


public class AccountServlet extends HttpServlet {
	private CommonService cService = new CommonServiceImpl();
	private AccountService aService = new AccountServiceImpl();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getPagebean":
			getPagebean(request, response);
			break;
		case "getPagebeanByParam":
			getPagebeanByParam(request, response);
			break;
		case "addAccount":
			addAccount(request, response);
			break;
		case "updateAccount":
			updateAccount(request, response);
			break;
		case "deleteAccount":
			deleteAccount(request, response);
			break;

		default:
			break;
		}
	}
	private void deleteAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		
		int row = aService.deleteAccountById(Integer.parseInt(accountId));
		if(row > 0){
			response.sendRedirect("account?cmd=getPagebean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}
	private void updateAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		String isPayed = request.getParameter("isPayed");
		
		
		int row = aService.updateAccount(Integer.parseInt(accountId), Integer.parseInt(isPayed));
		
		if(row > 0){
			response.sendRedirect("../account?cmd=getPagebean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
	}

	private void addAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		String businessNum = request.getParameter("businessNum");
		
		Goods goods = (Goods) request.getAttribute("goods");
		
		int row = aService.addAccount(
						goods, 
						Integer.parseInt(providerId), 
						Integer.parseInt(isPayed), 
						Integer.parseInt(businessNum));
		
		if(row > 0){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateGoods");
			requestDispatcher.forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
		
		
	}

	private void getPagebeanByParam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<String> wheres = new ArrayList<>();
		List<String> values = new ArrayList<>();

		String productName = request.getParameter("productName");
		String isPayed = request.getParameter("isPayed");

		if(productName != null && productName != ""){
			wheres.add("goodsName");
			values.add(productName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("isPayed");
			values.add(isPayed);
		}

		PageBean pageBean = new PageBean();

		int count = aService.getCount(wheres, values);
		pageBean.setCount(count);
		String p = request.getParameter("p");

		if(p != null && p != ""){
			pageBean.setP(Integer.parseInt(p));
		}else{
			pageBean.setP(1);
		}
		pageBean = aService.getAccount(pageBean, wheres, values);

		request.getSession().setAttribute("pageBean", pageBean);

		PrintWriter out = response.getWriter();
		out.print("<script>location.href='jsp/admin_bill_list.jsp'</script>");

	}

	private void getPagebean(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageBean pageBean = new PageBean();
		int count = cService.getCount("tb_account", null, null);
		pageBean.setCount(count);
		String p = request.getParameter("p");

		if(p != null && p != ""){
			pageBean.setP(Integer.parseInt(p));
		}else{
			pageBean.setP(1);
		}
		pageBean = aService.getAccount(pageBean);

		request.getSession().setAttribute("pageBean", pageBean);

		if(p != null && p != ""){
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
		}else{
			response.sendRedirect("jsp/admin_index.jsp");
		}
	}

}
