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
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("id"); 
		String userPwd = request.getParameter("pw"); 
	
		int result = new MemberService().deleteMember(userId,userPwd);
		
	
		if(result > 0) { 
			request.getSession().invalidate();
			request.getSession().setAttribute("alertMsg", "회원탈퇴 완료... 그 동안 감사했습니다.");
			response.sendRedirect(request.getContextPath());
			
			
		}
		else { 
			
			request.getSession().setAttribute("alertMsg", "회원탈퇴에 실패햇습니다..다시 시도해주세요");
			
			response.sendRedirect(request.getContextPath()+ "/deleteForm.me");
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
