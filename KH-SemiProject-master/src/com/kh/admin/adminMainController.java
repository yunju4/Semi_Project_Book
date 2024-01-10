package com.kh.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.sellCount.model.service.SaleCountService;
import com.kh.admin.product.model.vo.BookMaster;

/**
 * Servlet implementation class adminMain
 */
@WebServlet("/admain.ad")
public class adminMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int count = new SaleCountService().saleCount();
		
		//request.setAttribute("saleCount", count);
		
		ArrayList<BookMaster> bml = new SaleCountService().getCount();
		
		
		request.setAttribute("bml", bml);
		
		request.getRequestDispatcher("views/admin/adminMain.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
