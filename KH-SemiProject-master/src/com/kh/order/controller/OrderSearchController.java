package com.kh.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;

/**
 * Servlet implementation class OrderSearchController
 */
@WebServlet("/search.od")
public class OrderSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userNo = 0;
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginUser") == null) { // 로그인 전

			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);

		} else {
			userNo = ((Member) request.getSession().getAttribute("loginUser")).getUserNo();
		}

		// 입력받은 키워드와 userNO 변수 지정
		String keyword = request.getParameter("keyword");

		ArrayList<Order> list = new OrderService().searchOrderList(keyword, userNo);

		response.setContentType("application/json; charset=UTF-8");
		
		// Gson 사용시 날짜데이터가 미국식으로 변환되어 형식 세팅
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		gson.toJson(list, response.getWriter());
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
