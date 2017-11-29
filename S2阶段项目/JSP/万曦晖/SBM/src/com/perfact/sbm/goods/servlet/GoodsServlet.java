package com.perfact.sbm.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfact.sbm.goods.bean.Goods;
import com.perfact.sbm.goods.service.GoodsService;
import com.perfact.sbm.goods.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private GoodsService goodsService = new GoodsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
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
		case "getGoodsInfoByName":
			getGoodsInfoByName(request,response);
			break;
		case "updateGoods":
			updateGoods(request,response);
			break;

		default:
			break;
		}
	}

	private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String businessNum = request.getParameter("businessNum");
		Goods goods = (Goods) request.getAttribute("goods");
		
		int goodsNum = goods.getGoodsNum() + Integer.parseInt(businessNum);
		int row = goodsService.updateGoods(goodsNum, goods.getGoodsId());
		if(row >0 ){
			response.sendRedirect("account?cmd=getPagebean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新商品库存失败');</script>");

		}
	}

	private void getGoodsInfoByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsName = request.getParameter("goodsName");
		
		Goods goods = goodsService.getGoodsInfoByName(goodsName);
		
		request.setAttribute("goods", goods);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("account?cmd=addAccount");
		requestDispatcher.forward(request, response);

	}

}
