package com.perfact.sbm.provider.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfact.sbm.provider.bean.Provider;
import com.perfact.sbm.provider.service.ProviderService;
import com.perfact.sbm.provider.service.impl.ProviderServiceImpl;

/**
 * Servlet implementation class ProviderServlet
 */
@WebServlet("/ProviderServlet")
public class ProviderServlet extends HttpServlet {
	private ProviderService providerService = new ProviderServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProviderServlet() {
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
		case "getProvider":
			getProvider(request, response);
			break;

		default:
			break;
		}
	}

	private void getProvider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Provider> list = providerService.getProvider();
		
		request.setAttribute("providers", list);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
		requestDispatcher.forward(request, response);
	}

}
