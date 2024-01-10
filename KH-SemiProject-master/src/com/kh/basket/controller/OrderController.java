package com.kh.basket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.basket.model.service.BasketService;
import com.kh.basket.model.service.CardService;
import com.kh.basket.model.vo.Basket;
import com.kh.basket.model.vo.Card;
import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/order.ba")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		/*
		String order = request.getParameter("order");
		String receipt = request.getParameter("receipt");
		String postNo = request.getParameter("postNo");
		String address = request.getParameter("detailAddress");
		String phone = request.getParameter("phone");
		*/
		HttpSession session = request.getSession();
		int userNo=0;
		if(session.getAttribute("loginUser") == null) { // 로그인 전
		

			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);
		
		} else { 
			userNo= ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
			
			String cardName = request.getParameter("cardName");
			String cardNum = request.getParameter("cardNum");
			String cardPwd = request.getParameter("cardPwd");
			System.out.println(userNo);
			System.out.println(cardName);
			System.out.println(cardNum);
			System.out.println(cardPwd);
			
			Card c = new CardService().checkCard(userNo);
			
//			if(c.getCardCom() == cardName && c.getcNum() == cardNum && c.getCardPwd() == cardPwd) {
//				ArrayList<Basket> bList = new BasketService().selectBasket(userNo);
//				System.out.println(bList.toString());
//				
//				int result1 = new OrderService().insertOrder(bList, userNo);
//				
//				int result0 = new OrderService().setCount(bList);
//				
//				int result2 = 0;
//				for(int i = 0; i < bList.size(); i++) {
//					int basketNo = bList.get(i).getBasketSeq();
//					result2 = new BasketService().deleteBasket(basketNo);
//				}
//				
//				if((result1 * result2 * result0) > 0) {
//					request.getSession().setAttribute("alertMsg", "결제가 완료되었습니다. 메인페이지로 돌아갑니다.");
//					response.sendRedirect(request.getContextPath() + "/main.mi");
//				} else {
//					request.getSession().setAttribute("alertMsg", "★ 결제 실패 ★");
//					response.sendRedirect(request.getContextPath() + "/main.mi");
//				}
//			} else {
//				request.getSession().setAttribute("alertMsg", "카드정보가 알맞지 않습니다.");
//				response.sendRedirect(request.getContextPath() + "/basket.pb");
//			}
			
			if(c.getCardCom().equals(cardName)) {
				if(c.getcNum().equals(cardNum)) {
					if(c.getCardPwd().equals(cardPwd)) {
						ArrayList<Basket> bList = new BasketService().selectBasket(userNo);
						System.out.println(bList.toString());
						
						int result1 = new OrderService().insertOrder(bList, userNo);
						
						int result0 = new OrderService().setCount(bList);
						
						int result2 = 0;
						for(int i = 0; i < bList.size(); i++) {
							int basketNo = bList.get(i).getBasketSeq();
							result2 = new BasketService().deleteBasket(basketNo);
						}
						
						if((result1 * result2 * result0) > 0) {
							request.getSession().setAttribute("alertMsg", "결제가 완료되었습니다. 메인페이지로 돌아갑니다.");
							response.sendRedirect(request.getContextPath() + "/main.mi");
						} else {
							request.getSession().setAttribute("alertMsg", "★ 결제 실패 ★");
							response.sendRedirect(request.getContextPath() + "/main.mi");
						}
					} else {
						request.getSession().setAttribute("alertMsg", "카드비밀번호가 알맞지 않습니다.");
						response.sendRedirect(request.getContextPath() + "/basket.pb");
					}
				} else {
					request.getSession().setAttribute("alertMsg", "카드번호가 알맞지 않습니다.");
					response.sendRedirect(request.getContextPath() + "/basket.pb");
				}
			} else {
				request.getSession().setAttribute("alertMsg", "카드사가 알맞지 않습니다.");
				response.sendRedirect(request.getContextPath() + "/basket.pb");
			}
			
			
			
			
			
			
			
			
			
		}

		
		
		
		
		
		
		
		
//		if(c.getCardCom() == cardName) {
//			if(c.getcNum() == cardNum) {
//				if(c.getCardPwd() == cardPwd) {
//					if((result1 * result2 * result0) > 0) {
//						request.getSession().setAttribute("alertMsg", "결제가 완료되었습니다. 메인페이지로 돌아갑니다.");
//						response.sendRedirect(request.getContextPath() + "/main.mi");
//					} else {
//						request.getSession().setAttribute("alertMsg", "★ 결제 실패 ★");
//						response.sendRedirect(request.getContextPath() + "/main.mi");
//					}
//				}
//			}
//		}

		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
