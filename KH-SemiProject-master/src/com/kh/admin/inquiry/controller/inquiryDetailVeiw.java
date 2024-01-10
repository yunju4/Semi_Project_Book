package com.kh.admin.inquiry.controller;

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
 * Servlet implementation class inquiryDetailVeiw
 */
@WebServlet("/DetailVeiw.in")
public class inquiryDetailVeiw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inquiryDetailVeiw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String text = request.getParameter("text");
		Inquiry i = new InquiryService().selectInquiryAdmin(userNo,text);
		request.setAttribute("i", i);
	
		request.getRequestDispatcher("views/admin/inquiry/inquiryDetailAdminForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
