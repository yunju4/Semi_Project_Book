package com.kh.inquiry.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kh.member.model.vo.Member;
import com.kh.common.model.vo.PageInfo;
import com.kh.inquiry.model.service.InquiryService;
import com.kh.inquiry.model.vo.Inquiry;

/**
 * Servlet implementation class MemberFindIdFormController
 */
@WebServlet("/inquiryForm.in")
public class InquiryFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
				int userNo = 0;
				
				int listCount; 
				int currentPage; 
				int pageLimit;
				int boardLimit; 
				
				int maxPage; 
				int startPage; 
				int endPage; 
				
				HttpSession session = request.getSession();
				
				if(session.getAttribute("loginUser") == null) { // 로그인 전
				
	
					request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);
				
				}
				else { 
					userNo= ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
				}

				listCount = new InquiryService().selectListCount(userNo);
				
				
				
		
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
				
			
				pageLimit = 5;
				
			
				boardLimit = 5;
				
				
				
				maxPage = (int)Math.ceil((double)listCount / boardLimit);
				
				
				startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
				
			
				endPage = startPage + pageLimit - 1;
				
				
				if(endPage > maxPage) {
					endPage = maxPage;
				}
				
			
				PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, 
										   maxPage, startPage, endPage);
				
				
				ArrayList<Inquiry> list = new InquiryService().selectList(pi,userNo);
				
				
				request.setAttribute("list", list); 
				request.setAttribute("pi", pi); 
				
				
				
				request.getRequestDispatcher("views/inquiry/inquiryForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
