package com.kh.basket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.basket.model.service.BasketService;

/**
 * Servlet implementation class BasketDeleteController
 */
@WebServlet("/delBasket.ba")
public class BasketDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int basketNo = Integer.parseInt(request.getParameter("bano"));
		
		int result = new BasketService().deleteBasket(basketNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "장바구니에서 제외되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.ba");
		} else {
			request.getSession().setAttribute("alertMsg", "장바구니 제회 실패.");
			response.sendRedirect(request.getContextPath() + "/list.ba");
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
