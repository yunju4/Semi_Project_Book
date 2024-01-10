package com.kh.admin.product.model.service;

import com.kh.admin.product.model.dao.ProductDao;
import com.kh.admin.product.model.vo.Attachment;
import com.kh.admin.product.model.vo.BookMaster;
import com.kh.admin.product.model.vo.BookTag;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class ProductService {

	public int insertProduct(BookMaster bm, Attachment at, BookTag tc1, BookTag tc2) {
		
		Connection conn = getConnection();
		// SEQ_MNO.NEXTVAL select
		int bookNo = new ProductDao().selectBookNo(conn);
		
		// 첨부파일과 도서번호 동일할 수 있도록 값 넣어주기
		bm.setBookNo(bookNo);
		at.setBookNo(bookNo);
		tc1.setBookNo(bookNo);
		tc2.setBookNo(bookNo);
		
		int result1 = new ProductDao().insertProduct(conn, bm);
		
		int result2 = new ProductDao().insertAttachment(conn, at);
		
		int result3 = new ProductDao().insertTag(conn, tc1);

		int result4 = new ProductDao().insertTag(conn, tc2);
		
		if(result1 * result2 * result3 * result4 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (result1 * result2 * result3 * result4);
	}
	
	public ArrayList<BookMaster> selectProduct() {
		
		Connection conn = getConnection();
		
		ArrayList<BookMaster> list = new ProductDao().selectProduct(conn);
		
		close(conn);
		
		return list;
		
	}
	
	public BookMaster selectProductDetail(int bookNo) {
		
		Connection conn = getConnection();
		
		BookMaster bm = new ProductDao().selectProductDetail(conn, bookNo);
		
		close(conn);
		
		return bm;
		
	}
	
	public Attachment selectAttachment(int bookNo) {
		
		Connection conn = getConnection();
		
		Attachment at = new ProductDao().selectAttachment(conn, bookNo);
		
		close(conn);
		
		return at;
	}
	
	public int updateProduct(BookMaster bm, Attachment at, BookTag tc1, BookTag tc2) {
		
		Connection conn = getConnection();
		
		int result1 = new ProductDao().updateProduct(conn, bm);
		int result2 = 1;
		if(at !=null) {
			result2 = new ProductDao().updateAttachment(conn, at);
		}
		
		int result3 = new ProductDao().updateTag(conn, tc1);

		int result4 = new ProductDao().updateTag(conn, tc2);
		
		if(result1 * result2 * result3 * result4 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (result1 * result2 * result3 * result4);
	} 
	
	public int deleteProduct(int bno) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().deleteProduct(conn, bno);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<BookMaster> selectProduct(String selectType, int bookCnt, String sort) {
		
		Connection conn = getConnection();
		
		ArrayList<BookMaster> bmlist = new ProductDao().selectProduct(conn, selectType, bookCnt, sort);
		
		close(conn);
		
		return bmlist;
	}
	
	public ArrayList<BookMaster> selectSearchProduct(String keyword, String sort) {
		
		Connection conn = getConnection();
		
		ArrayList<BookMaster> list = new ProductDao().selectSearchProduct(conn, keyword, sort);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<BookMaster> selectAllProduct(String category, String sort) {
		
		Connection conn = getConnection();
		
		ArrayList<BookMaster> allList = new ProductDao().selectAllProduct(conn, category, sort);
		
		close(conn);
		
		return allList;
	}
}
