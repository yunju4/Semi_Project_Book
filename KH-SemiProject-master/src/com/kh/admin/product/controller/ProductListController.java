package com.kh.admin.product.controller;

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
 * Servlet implementation class ProductListController
 */
@WebServlet("/productList.ad")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 화면을 띄우기 전에 테이블로부터 조회해와야 한다.
		ArrayList<BookMaster> list = new ProductService().selectProduct();
		
		// request 에 담기
		request.setAttribute("list", list);
		
		// 보여줄 화면 지정
		// => 포워딩
		request.getRequestDispatcher("views/admin/product/productListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
