package com.kh.inquiry.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.inquiry.model.service.InquiryService;
import com.kh.inquiry.model.vo.Inquiry;

/**
 * Servlet implementation class MemberFindIdFormController
 */
@WebServlet("/insert.in")
public class InquiryInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		
		int inquiryNo = Integer.parseInt(request.getParameter("userNo"));
		String inquiryClass = request.getParameter("select_Q");
		String inquiryEmail= request.getParameter("in_email");
		String inquiryTitle = request.getParameter("title");
		String inquiryContent = request.getParameter("content");
		
		Inquiry i = new Inquiry(inquiryNo,inquiryClass, inquiryEmail, inquiryTitle, inquiryContent);
		
		
		int result = new InquiryService().insertInquiry(i);
		
		
		if(result > 0) { 
			
			request.getSession().setAttribute("alertMsg", "문의 등록 성공 ");
			
			response.sendRedirect(request.getContextPath()+"/inquiryForm.in?currentPage=1");
			
		}
		else { 
			
		request.getSession().setAttribute("alertMsg", "문의 등록 실패.. 잠시후 다시 시도해 주세요");
			
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
