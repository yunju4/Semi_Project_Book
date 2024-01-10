package com.kh.admin.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.user.model.dao.UserManageService;

/**
 * Servlet implementation class DeleteMemberController
 */
@WebServlet("/delMember.ad")
public class DeleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		int result = new UserManageService().delMember(userId);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "회원 제재 완료");
			response.sendRedirect(request.getContextPath() + "/userList.ad");
		} else {
			request.getSession().setAttribute("alertMsg", "회원 제재에 실패햐였습니다. 다시 확인해 주세요.");
			response.sendRedirect(request.getContextPath() + "/userList.ad");
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
