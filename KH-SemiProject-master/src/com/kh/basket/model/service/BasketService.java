package com.kh.basket.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.product.model.vo.Attachment;
import com.kh.basket.model.dao.BasketDao;
import com.kh.basket.model.vo.Basket;
import com.kh.common.JDBCTemplate;

public class BasketService {

	public ArrayList<Basket> selectBasket(int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Basket> list = new BasketDao().selectBasket(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

	public int insertBook(int bookNo, int userNo, int count) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BasketDao().insertBook(conn, bookNo, userNo, count);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public int deleteBasket(int basketNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BasketDao().deleteBasket(conn, basketNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public ArrayList<Basket> selectBasketImg(int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Basket> atList = new BasketDao().selectBasketImg(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return atList;
		
	}


	
}
