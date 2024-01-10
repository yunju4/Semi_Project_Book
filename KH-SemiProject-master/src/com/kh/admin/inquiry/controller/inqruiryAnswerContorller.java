package com.kh.admin.inquiry.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.inquiry.model.service.InquiryService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class inqruiryAnswerContorller
 */
@WebServlet("/Answer.in")
public class inqruiryAnswerContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inqruiryAnswerContorller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//2단계
		int userNo = Integer.parseInt(request.getParameter("userNo")); 
		String title = request.getParameter("title"); 
		String message = request.getParameter("message"); 
		String email = request.getParameter("email"); 
		
		
		
		// 4단계
		int result = new InquiryService().insertAn(userNo,title,message);
	
		// 5)단계
		if(result > 0) { 
			
			int result2 = new MemberService().inquirySandEmil(email,title);
			
			if(result2> 0) {
			
			
				
				
				
				response.sendRedirect(request.getContextPath()+"/inquiryFormAdmin.in?currentPage=1");
			}
			else {
				
				
				
				
				response.sendRedirect(request.getContextPath()+"/inquiryFormAdmin.in?currentPage=1");
			}
		}
		else { // 실패 => 에러페이지
			
		
			
			response.sendRedirect(request.getContextPath()+"/inquiryFormAdmin.in?currentPage=1");
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
