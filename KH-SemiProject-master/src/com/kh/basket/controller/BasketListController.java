package com.kh.basket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.product.model.service.ProductService;
import com.kh.admin.product.model.vo.Attachment;
import com.kh.basket.model.service.BasketService;
import com.kh.basket.model.vo.Basket;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class basketListController
 */
@WebServlet("/list.ba")
public class BasketListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BasketListController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 화면 뛰우기
		// 조회결과가 여러게 일때
		
		HttpSession session = request.getSession();
		int userNo=0;
		if(session.getAttribute("loginUser") == null) { // 로그인 전
		

			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);
		
		}
		else { 
			userNo= ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
			
			ArrayList<Basket> atList = new BasketService().selectBasketImg(userNo);
			
			request.setAttribute("atList", atList);
			
			ArrayList<Basket> list = new BasketService().selectBasket(userNo);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/basket/basketListView.jsp").forward(request, response);
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
