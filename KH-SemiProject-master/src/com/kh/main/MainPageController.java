package com.kh.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.product.model.service.ProductService;
import com.kh.admin.product.model.vo.BookMaster;

/**
 * Servlet implementation class MainPageController
 */
@WebServlet("/main.mi")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<BookMaster> bmlist = new ProductService().selectProduct("best", 4, "title");
		
		ArrayList<BookMaster> bmNewlist = new ProductService().selectProduct("new", 4, "title");
		
		request.setAttribute("bmlist", bmlist);
		request.setAttribute("bmNewlist", bmNewlist);
		
		request.setAttribute("category", request.getParameter("category"));
		request.getRequestDispatcher("/views/main/mainpage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
