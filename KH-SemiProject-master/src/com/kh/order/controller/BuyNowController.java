package com.kh.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.basket.model.service.BasketService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BuyNowController
 */
@WebServlet("/buyNow.or")
public class BuyNowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyNowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		int userNo = 0;
		
		if (session.getAttribute("loginUser") == null) { // 로그인 전

			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);

		} else {
			userNo = ((Member) request.getSession().getAttribute("loginUser")).getUserNo();
			
			int bookNo = Integer.parseInt(request.getParameter("bno"));
			int count = Integer.parseInt(request.getParameter("count"));
			
			int result = new BasketService().insertBook(bookNo, userNo, count);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "결제페이지로 이동합니다.");
				response.sendRedirect(request.getContextPath() + "/basket.pb");
			} else {
				request.getSession().setAttribute("alertMsg", "결제페이지 이동 실패");
				response.sendRedirect(request.getContextPath() + "/productUserDetail.mi?bno=" + bookNo);
			}
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
