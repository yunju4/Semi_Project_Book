

package com.kh.order.model.service;

import com.kh.basket.model.vo.Basket;
import com.kh.common.JDBCTemplate;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;

import com.kh.order.model.dao.OrderDao;
import com.kh.order.model.vo.Order;

public class OrderService {

	public ArrayList<Order> selectOrderList(int userNo) {

		Connection conn = getConnection();

		ArrayList<Order> list = new OrderDao().selectOrderList(conn,userNo);

		close(conn);

		return list;
	}

	public ArrayList<Order> searchOrderList(String keyword, int userNo) {

		Connection conn = getConnection();

		ArrayList<Order> list = new OrderDao().searchOrderList(conn, keyword, userNo);

		close(conn);

		return list;
	}

	public int cancelOrder(int orderNo, int userNo, int status) {

		Connection conn = getConnection();

		int result = new OrderDao().cancelOrder(conn, orderNo, userNo, status);

		if (result > 0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);
		}

		return result;
	}

	public ArrayList<Order> selectCancelList(int userNo) {

		Connection conn = getConnection();

		ArrayList<Order> list = new OrderDao().selectCancelList(conn, userNo);

		close(conn);

		return list;
	}

	public int bookAddStock(int bookNo, int count) {
		// 주문목록에서 취소/반품시 수량 조정 메소드
		Connection conn = getConnection();

		int result = new OrderDao().bookAddStock(conn, bookNo, count);

		if (result > 0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);
		}

		return result;
	}
	public int insertOrder(ArrayList<Basket> bList, int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new OrderDao().insertOrder(conn, bList, userNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
		
	}

	public int setCount(ArrayList<Basket> bList) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new OrderDao().setCount(conn, bList);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	public int selectOrderCnt(int userNo,int bookNo) {

		Connection conn = getConnection();

		int result = new OrderDao().selectOrderCnt(conn,userNo,bookNo);

		if (result > 0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);
		}

		return result;
	}
	
	
}
