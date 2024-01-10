package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1단계
		request.setCharacterEncoding("UTF-8");
		//2단계
		String userId = request.getParameter("id"); 
		String userPwd = request.getParameter("pw"); 
		String userName = request.getParameter("name"); 
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email");
		String postNo = request.getParameter("postnum");
		String address =request.getParameter("add");
		String detailAddress =request.getParameter("detailadd");
		//3단계
		Member m = new Member(userId, userPwd, userName, phone, email, postNo, address,detailAddress);
		
		// 4단계
		int result = new MemberService().insertMember(m);
		
		// 5)단계
		if(result > 0) { 
			
			request.getSession().setAttribute("alertMsg", "회원가입에 성공했습니다. 로그인 페이지로 이동합니다.");
			
			response.sendRedirect(request.getContextPath()+"/loginForm.me");
			
		}
		else { // 실패 => 에러페이지
			
		request.getSession().setAttribute("alertMsg", "회원가입에 실패햇습니다.. 잠시후 다시 시도해 주세요");
			
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
