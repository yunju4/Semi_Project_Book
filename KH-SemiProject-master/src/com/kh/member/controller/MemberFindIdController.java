package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberFindId
 */
@WebServlet("/findId.me")
public class MemberFindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//
		String userName = request.getParameter("name"); 
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email");
		
		
		
		int result = new MemberService().findId(userName, phone, email);
		
		switch(result) {
		
		case 1: 
			request.getSession().setAttribute("alertMsg", "올바른 이름 ,전화번호 또는 회원가입시 입력한 메일 입력해주세요.");
			response.sendRedirect(request.getContextPath());
			break;
		case 2: 
			request.getSession().setAttribute("alertMsg", "메일전송 실패 잠시후 다시시도해주세요");
			response.sendRedirect(request.getContextPath());
			break;
		default: 
			request.getSession().setAttribute("alertMsg", "아이디 찾기 성공 . 메일함을 확인해 주세요 ");
			response.sendRedirect(request.getContextPath());
			
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
