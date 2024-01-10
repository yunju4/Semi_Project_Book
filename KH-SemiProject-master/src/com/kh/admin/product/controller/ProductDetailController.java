package com.kh.admin.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.product.model.service.ProductService;
import com.kh.admin.product.model.vo.Attachment;
import com.kh.admin.product.model.vo.BookMaster;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/productDetail.ad")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// DB로부터 조회
		
		// 2) 값 뽑기
		int bookNo = Integer.parseInt(request.getParameter("bno"));
		
		// 3) 필드가 하나뿐이니까 가공은 하지 말고 그냥 Service 단으로 넘기기
		ProductService pService = new ProductService();
		
		// Product 조회
		BookMaster p = pService.selectProductDetail(bookNo);
		
		// 첨부파일 조회
		Attachment at = pService.selectAttachment(bookNo);
		
		// SELECT 조회물 넘겨주기
		request.setAttribute("p", p);
		request.setAttribute("at", at);
		request.setAttribute("bookNo", bookNo);
		// 화면 잘 뜨는지 고고
		request.getRequestDispatcher("views/admin/product/productDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
