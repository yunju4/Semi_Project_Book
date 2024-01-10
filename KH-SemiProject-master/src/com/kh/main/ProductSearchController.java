package com.kh.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.admin.product.model.service.ProductService;
import com.kh.admin.product.model.vo.BookMaster;

/**
 * Servlet implementation class ProductSearchController
 */
@WebServlet("/productSearch.mi")
public class ProductSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		String keyword = request.getParameter("keyword");
		
		String sort = request.getParameter("sort");
		
		ArrayList<BookMaster> list = null;

		if("keyword".equals(type)) {
			list = new ProductService().selectSearchProduct(keyword, sort);
		}
		else if("best".equals(type)){
			list = new ProductService().selectProduct(type, 12, sort);
		}
		else if("new".equals(type)){
			list = new ProductService().selectProduct(type, 12, sort);
		}
		else {
			String category = request.getParameter("category");
			list = new ProductService().selectAllProduct(category, sort);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
