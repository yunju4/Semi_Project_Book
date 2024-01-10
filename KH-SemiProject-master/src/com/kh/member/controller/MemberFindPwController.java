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
@WebServlet("/findPw.me")
public class MemberFindPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//
		String userId = request.getParameter("id"); 
		String userName = request.getParameter("name"); 
		String email = request.getParameter("email");
		
		
		
		int result = new MemberService().findPw(userId,userName,  email);
		
		switch(result) {
		
		case 1: //찾는비번 없을경우
			request.getSession().setAttribute("alertMsg", "올바른 아이디 ,이름 또는 회원가입시 입력한 메일 입력해주세요.");
			response.sendRedirect(request.getContextPath());
			break;
		case 2: //찾았지만 메일전송 실패
			request.getSession().setAttribute("alertMsg", "메일전송에 실패했습니다. 잠시후 시도해주세요");
			response.sendRedirect(request.getContextPath());
			break;
		default: //전송완료
			request.getSession().setAttribute("alertMsg", "비밀번호 찾기 성공 . 메일함을 확인해 주세요 ");
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
