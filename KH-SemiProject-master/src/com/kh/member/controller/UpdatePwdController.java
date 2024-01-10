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
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String updatePwd = request.getParameter("updatePwd");

	
		
		Member updateMem = new MemberService().updatePwdMember(userId, userPwd, updatePwd);
		
		// 결과값을 통해 성공 실패 여부에 따른 응답화면 지정
		HttpSession session = request.getSession();
		
		if(updateMem == null) {  // 실패
			session.setAttribute("alertMsg", "비밀번호 변경에 실패했습니다.");
		}
		else {  // 성공 => alert, 바뀐 사용자 정보를 loginUser에 덮어 씌우기
			session.setAttribute("alertMsg", "성공적으로 비밀번호가 변경되었습니다.");
			session.setAttribute("loginUser", updateMem);
		}

		response.sendRedirect(request.getContextPath() + "/MyPageForm.me");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
