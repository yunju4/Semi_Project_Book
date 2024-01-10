package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	      request.setCharacterEncoding("UTF-8");

	      String userId = request.getParameter("userId");
	      String userName = request.getParameter("userName");
	      String phone = request.getParameter("phone");
	      String postNo = request.getParameter("postNo");
	      String address = request.getParameter("address");
	      String detailAddress = request.getParameter("detailAddress");
	      String email = request.getParameter("email");

	      Member m = new Member(userName, phone, email, postNo, address, detailAddress,userId);
			
			Member updateMem = new MemberService().updateMember(m);

			System.out.println(m);
			
			if(updateMem == null) {
				request.setAttribute("errorMsg", "회원 정보 변경에 실패하였습니다 :(");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			else { 
				HttpSession session = request.getSession();
				
				session.setAttribute("loginUser", updateMem);
				session.setAttribute("alertMsg", "회원 정보 변경에 성공하였습니다 :)");

				response.sendRedirect(request.getContextPath() + "/MyPageForm.me");
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
