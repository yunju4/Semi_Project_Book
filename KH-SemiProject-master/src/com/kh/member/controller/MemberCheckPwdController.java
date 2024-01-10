package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberCheckPwdController
 */
@WebServlet("/checkPwd.me")
public class MemberCheckPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCheckPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String userId="";
		
		if(session.getAttribute("loginUser") == null) {
			

			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);
		
		}
		else { 
			userId= ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		}
		
		
		request.setCharacterEncoding("UTF-8");
		
		
		String checkPwd = request.getParameter("checkPwd");
	
		
		Member checkMem = new MemberService().checkPwdMember(userId, checkPwd);
		

		
			
		if(checkMem == null) {  
			session.setAttribute("alertMsg", "비밀번호가 틀렸습니다.");
		
			
			response.sendRedirect(request.getContextPath() + "/PwdForm.me");
			
		
		}
		else {  
			session.setAttribute("alertMsg", "재확인에 성공했습니다.");
			response.sendRedirect(request.getContextPath() + "/myPage.me");
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
