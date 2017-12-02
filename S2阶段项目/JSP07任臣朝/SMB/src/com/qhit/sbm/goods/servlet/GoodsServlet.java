/**
 * 
 */
package com.qhit.sbm.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.service.GoodsService;
import com.qhit.sbm.goods.service.impl.GoodsServiceImpl;

/**
 * @author admin
 * 2017年11月15日
 */
public class GoodsServlet extends HttpServlet {
	private GoodsService goodsService = new GoodsServiceImpl();

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
		case "getGoodsInfoByName":
			getGoodsInfoByName(request, response);
			break;
		case "updateGoods":
			updateGoods(request, response);
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
	private void updateGoods(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String businessNum = request.getParameter("businessNum");
		Goods goods = (Goods) request.getAttribute("goods");
		
		int goodsNum = goods.getGoodsNum() + Integer.parseInt(businessNum);
		int row = goodsService.updateGoods(goodsNum, goods.getGoodsId());
		
		if(row > 0){
			//更新成功
			response.sendRedirect("account?cmd=getPagebean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新商品库存失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 根据商品名称去查询商品
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getGoodsInfoByName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String goodsName = request.getParameter("goodsName");
		
		Goods goods = goodsService.getGoodsInfoByName(goodsName);
		
		request.setAttribute("goods", goods);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("account?cmd=addAccount");
		requestDispatcher.forward(request, response);
		
	}

}
