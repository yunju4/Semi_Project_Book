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
 * Servlet implementation class MemberFindId
 */
@WebServlet("/login.me")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 아이디 비밀번호 규격

		request.setCharacterEncoding("UTF-8");

		// 값 가져오기
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pw");

		HttpSession session = request.getSession();

		// 관리자 페이지 메인

		Member m = new MemberService().login(userId, userPwd);
		// 로그인 시도
		// 실패시
		
		
		if (m == null) {

			session.setAttribute("alertMsg", "아이디 혹은 비밀번호를 확인해주세요.");
			response.sendRedirect(request.getContextPath() + "/loginForm.me");

		}

		// 성공
		else if (userId.equals("admin") && userPwd.equals("1234")) {
			// request.getRequestDispatcher("/views/admin/adminMain.jsp").forward(request,
			// response);
			response.sendRedirect(request.getContextPath() + "/admain.ad");
		} else {
			session.setAttribute("loginUser", m);
			session.setAttribute("alertMsg", "성공적으로 로그인이 되었습니다.");
			response.sendRedirect(request.getContextPath());
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
