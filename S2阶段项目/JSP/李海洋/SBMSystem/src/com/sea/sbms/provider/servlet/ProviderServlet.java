package com.sea.sbms.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.provider.bean.Provider;
import com.sea.sbms.provider.service.ProviderService;
import com.sea.sbms.provider.service.impl.ProviderServiceImpl;

public class ProviderServlet extends HttpServlet {
	private ProviderService providerService = new ProviderServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getProvider":
			getProvider(request, response);
			break;
		case "allProvider":
			allProvider(request, response);
			break;
		case "updateProvider":
			updateProvider(request, response);
			break;
		case "deleteProvider":
			deleteProvider(request, response);
			break;
		case "addProvider":
			addProvider(request, response);
			break;
		default:
			break;
		}
	}

	private void addProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String providerName = request.getParameter("providerName");
		String providerDetail = request.getParameter("providerDetail");
		String contact = request.getParameter("contact");
		String telephone = request.getParameter("telephone");
		String facsimile = request.getParameter("facsimile");
		String address = request.getParameter("address");
		
		Provider provider = new Provider(providerName,
				providerDetail, 
				contact, 
				telephone,
				facsimile, 
				address);
		int row = providerService.addProvider(provider);
		PrintWriter out = response.getWriter();
		if(row > 0){
			//提交成功
			response.sendRedirect("provider?cmd=allProvider&&p=1");
		}else{
			//添加失败
			out.print("<script>alert('添加供应商失败!');</script>");
		}
	}

	private void deleteProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String providerId = request.getParameter("providerId");
		
		int row = providerService.deleteProvider(Integer.parseInt(providerId));
		if (row > 0) {
			// 删除成功
			response.sendRedirect("provider?cmd=allProvider&&p=1");
		} else {
			// 删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}

	private void updateProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Provider provider = new Provider();
		String providerId = request.getParameter("providerId");
		String providerName = request.getParameter("providerName");
		String providerDetail = request.getParameter("providerDetail");
		String contact = request.getParameter("contact");
		String telephone = request.getParameter("telephone");
		String facsimile = request.getParameter("facsimile");
		String address = request.getParameter("address");
		
		provider.setProviderName(providerName);
		provider.setProviderDetail(providerDetail);
		provider.setContact(contact);
		provider.setTelephone(telephone);
		provider.setFacsimile(facsimile);
		provider.setAddress(address);
		
		int row = providerService.updateProvider(provider, Integer.parseInt(providerId));
		if (row > 0) {
			// 修改成功
			response.sendRedirect("provider?cmd=allProvider&&p=1");
		} else {
			// 修改失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('修改失败');</script>");
		}
	}

	private void allProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p = 1;//默认显示第一页
		String ps = request.getParameter("p");//获取页面中传递过来的页码
		
		if(ps!=null) p = Integer.parseInt(ps);
		
		PageBean pb = providerService.allProvider(p);
		
		request.getSession().setAttribute("pb", pb);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href='jsp/providerAdmin.jsp'</script>");
	}

	private void getProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Provider> list = providerService.getProvider();

		request.setAttribute("providers", list);
		// 查询完所有的供应商之后再去进入到添加账单的页面
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("jsp/modify.jsp");
		requestDispatcher.forward(request, response);
	}

}
