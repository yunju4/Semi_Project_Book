package com.kh.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.comment.model.service.CommentService;
import com.kh.comment.model.vo.Cment;
import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;


/**
 * Servlet implementation class InsertCommentController
 */
@WebServlet("/insertcomment.co")
public class InsertCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// request 로부터 값뽑기
		String cment = request.getParameter("cment");
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		Integer userNo = null;
		int result = 0;
		// 로그인한 회원 정보
		if(request.getSession().getAttribute("loginUser") != null) {
			userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		}
		if(userNo != null) {
			//구매여부 조회
			int orderCnt = new OrderService().selectOrderCnt(userNo,bookNo);
			//if 구매했다
			if(orderCnt > 0) {
				// VO 가공 => Reply
				Cment c = new Cment();
				c.setCment(cment);
				c.setBookNo(bookNo);
				//세션정보에서 가져온다.
				c.setUserNo(String.valueOf(userNo));
				// Service 단 호출
				result = new CommentService().insertComment(c);
			}
			else {
				result = -1;
			}
		}
			
		// Gson, Json => 넘겨야할 값이 여러개일때 묶을때
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(result, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
