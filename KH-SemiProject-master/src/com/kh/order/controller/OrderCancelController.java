package com.kh.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;

/**
 * Servlet implementation class OrderCancleController
 */
@WebServlet("/cancel.me")
public class OrderCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderCancelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int userNo = 0;

		// 입력받은 값들 변수지정
		int orderNo = Integer.parseInt(request.getParameter("ono"));
		int status = Integer.parseInt(request.getParameter("status"));
		int count = Integer.parseInt(request.getParameter("count"));
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		// System.out.println(orderNo);

		if (session.getAttribute("loginUser") == null) { // 로그인 전

			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);

		} else {
			userNo = ((Member) request.getSession().getAttribute("loginUser")).getUserNo();
		}
		int result1 = new OrderService().cancelOrder(orderNo, userNo, status);
		
		int result2 = new OrderService().bookAddStock(bookNo, count);

		if (result1 * result2 > 0) {

			// request.getRequestDispatcher("views/order/orderview.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/order.me");
			// request.getRequestDispatcher("views/order/orderview.jsp").forward(request, response);

		} else {
			// 		request.getSession().setAttribute("alertMsg", "똑바로하세요..다시 시도해주세요");
			response.sendRedirect(request.getContextPath()+"/order.me");
	
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
