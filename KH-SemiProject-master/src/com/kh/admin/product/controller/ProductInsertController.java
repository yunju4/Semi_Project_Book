package com.kh.admin.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.admin.product.model.service.ProductService;
import com.kh.admin.product.model.vo.BookMaster;
import com.kh.admin.product.model.vo.BookTag;
import com.oreilly.servlet.MultipartRequest;
import com.kh.admin.product.model.vo.Attachment;

/**
 * Servlet implementation class ProductEnrollFormController
 */
@WebServlet("/productInsert.ad")
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST
		// 1) 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024 * 1024 * 10; // 10mbyte 첨부파일 크기 지정
			
			// 전달된 파일을 저장할 서버의 폴더 경로 알아내기 => 세션객체에서 제공하는 getRealPath 메소드를 통해 알아내기
			// 다만, 매개변수로 WebContent 폴더로부터 product_upfiles 폴더까지의 경로를 제시
			String savePath = request.getSession().getServletContext().getRealPath("/resources/product_upfiles/");
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 2) multiRequest 객체로부터 요청 시 전달값 뽑기
			
			// BookMaster에 넣을 값 뽑기 
			int bookCode = Integer.parseInt(multiRequest.getParameter("bookCode"));
			String bookTitle = multiRequest.getParameter("bookTitle");
			String bookHead = multiRequest.getParameter("bookHead");
			String bookContent = multiRequest.getParameter("bookContent");
			String authorInfo = multiRequest.getParameter("authorInfo");
			int price = Integer.parseInt(multiRequest.getParameter("price"));
			String author = multiRequest.getParameter("author");
			String title = multiRequest.getParameter("title");
			int stock = Integer.parseInt(multiRequest.getParameter("stock"));
			String pblctDate = multiRequest.getParameter("pblctDate");
			String publisher = multiRequest.getParameter("publisher");
			
			// BookTag에 넣을 값 뽑기
			String tagContent1 = multiRequest.getParameter("tagContent1");
			String tagContent2 = multiRequest.getParameter("tagContent2");
			
			// 3) BookMaster VO 객체로 가공
			BookMaster bm = new BookMaster(bookCode, bookTitle, bookHead, bookContent, authorInfo,
					price, author, title, stock, pblctDate, publisher);
			
			// 4) BookTag VO 객체로 가공
			BookTag tc1 = new BookTag(1, tagContent1);
			BookTag tc2 = new BookTag(2, tagContent2);
			
			// 두번째 INSERT => 첨부파일 INSERT
			Attachment at = null;
			// 사실은 원본파일명을 리턴
			// multiRequest.getOriginalFileName("키값")
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				// 첨부파일  VO 객체로 가공
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile")); // 원본명
				
				// 실제 서버에 업로드된 파일의 이름을 리턴해주는 메소드
				// multiRequest.getFilesystemName("키값");
				at.setChangeName(multiRequest.getFilesystemName("upfile")); // 수정파일명
				
				// 파일 경로
				at.setFilePath("resources/product_upfiles/");
			}
			int result = new ProductService().insertProduct(bm, at, tc1, tc2);
		
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/productList.ad");
			}
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
