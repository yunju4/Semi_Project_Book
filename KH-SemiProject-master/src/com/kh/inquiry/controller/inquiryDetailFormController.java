package com.kh.inquiry.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.inquiry.model.service.InquiryService;
import com.kh.inquiry.model.vo.Inquiry;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class inquiryDetailFormController
 */
@WebServlet("/detail.in")
public class inquiryDetailFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inquiryDetailFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int inNo = Integer.parseInt(request.getParameter("inNo"));
		int userNo= ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		Inquiry i = new InquiryService().selectInquiry(inNo,userNo);
		request.setAttribute("i", i);
		request.getRequestDispatcher("views/inquiry/inquiryDetailForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
