package com.kh.order.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;

/**
 * Servlet implementation class OrderMe
 */
@WebServlet("/order.me")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public OrderListController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession();
		
		int userNo=0;
		
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			

			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);
		
		}
		else { 
			userNo= ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		
		ArrayList<Order> list = new OrderService().selectOrderList(userNo);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/order/orderview.jsp").forward(request, response);
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
