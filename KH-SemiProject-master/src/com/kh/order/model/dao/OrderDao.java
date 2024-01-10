package com.kh.order.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.notice.model.dao.NoticeDao;
import com.kh.basket.model.vo.Basket;
import com.kh.common.JDBCTemplate;
import static com.kh.common.JDBCTemplate.*;
import com.kh.order.model.vo.Order;


public class OrderDao {

	private Properties prop = new Properties();
	
	public OrderDao() {
		String fileName = NoticeDao.class.getResource("/sql/order/order-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertOrder(Connection conn, ArrayList<Basket> bList, int userNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertOrder");
		
		
			try {
				
				for(int i = 0; i < bList.size(); i++) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bList.get(i).getBasketSeq());
					pstmt.setInt(2, userNo);
					result = pstmt.executeUpdate();
				}
				
//				for(Basket b : bList) {
//					System.out.println(b.getBasketSeq());
//					pstmt = conn.prepareStatement(sql);
//					pstmt.setInt(1, b.getBasketSeq());
//					pstmt.setInt(2, userNo);
//					result = pstmt.executeUpdate();
//				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
		return result;
	
		
	}

	public int setCount(Connection conn, ArrayList<Basket> bList) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("setCount");
		
		
			try {
				
				for(int i = 0; i < bList.size(); i++) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bList.get(i).getCount());
					pstmt.setInt(2, bList.get(i).getCount());
					pstmt.setInt(3, bList.get(i).getBookNo());
					result = pstmt.executeUpdate();
				}
				
//				for(Basket b : bList) {
//					System.out.println(b.getBasketSeq());
//					pstmt = conn.prepareStatement(sql);
//					pstmt.setInt(1, b.getBasketSeq());
//					pstmt.setInt(2, userNo);
//					result = pstmt.executeUpdate();
//				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
		return result;
		
	}
	
	public ArrayList<Order> selectOrderList(Connection conn, int userNo) {
		// 주문목록 불러오기

		ArrayList<Order> list = new ArrayList<>();

		PreparedStatement pstmt = null;

		ResultSet rset = null;
		
		System.out.println(userNo);

		String sql = prop.getProperty("selectOrderList");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				Order o = new Order();
				o.setUserNo(rset.getInt("USER_NO"));
				o.setBookNo(rset.getInt("BOOK_NO"));
				o.setOrderNo(rset.getInt("ORDER_SEQ"));
				o.setOrderDate(rset.getDate("ORDER_DATE"));
				o.setBookTitle(rset.getString("TITLE"));
				o.setPrice(rset.getInt("PRICE"));
				o.setCount(rset.getInt("COUNT"));
				o.setMultiply(rset.getInt("PRICE") * rset.getInt("COUNT"));
				o.setStatus(rset.getInt("STATUS"));
				o.setConfirmationDate(rset.getDate("CONFIRMATION_DATE"));

				// 현재날짜 생성
				Date now = new Date();

				// getOrderDate 가 아닌 confimation_Date(Order날짜 + 30일 생성) 뽑아올거임 테스트용
				// 주문 후 30일이 지나면 취소/반품이 되지 않게 지정해주는 값을 객체에 생성
				int confimation = now.compareTo(o.getConfirmationDate());

				if (confimation == -1 || confimation == 0) { // 취소/반품 가능

					o.setConfirmation(0);

				} else { // 취소/반품 불가능

					o.setConfirmation(1);

				}

				list.add(o);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Order> searchOrderList(Connection conn, String keyword, int userNo) {
		// 주문목록에 있는 검색기능

		ArrayList<Order> list = new ArrayList<>();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("searchOrderList");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			// 키워드를 LIKE 문으로 SELECT 해올것
			pstmt.setString(2, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {

				Order o = new Order();
				o.setUserNo(rset.getInt("USER_NO"));
				o.setBookNo(rset.getInt("BOOK_NO"));
				o.setOrderNo(rset.getInt("ORDER_SEQ"));
				o.setOrderDate(rset.getDate("ORDER_DATE"));
				o.setBookTitle(rset.getString("TITLE"));
				o.setPrice(rset.getInt("PRICE"));
				o.setCount(rset.getInt("COUNT"));
				o.setMultiply(rset.getInt("PRICE") * rset.getInt("COUNT"));
				o.setStatus(rset.getInt("STATUS"));
				o.setConfirmationDate(rset.getDate("CONFIRMATION_DATE"));

				Date now = new Date();

				int confimation = now.compareTo(o.getConfirmationDate());

				if (confimation == -1 || confimation == 0) {

					o.setConfirmation(0);

				} else {

					o.setConfirmation(1);

				}

				list.add(o);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int cancelOrder(Connection conn, int bookNo, int userNo, int status) {
		// 주문목록에서 취소/반품하기
		int result = 0;

		PreparedStatement pstmt = null;

		// 취소/반품을 한 쿼리문으로 작성
		String sql = prop.getProperty("cancelOrder");

		try {
			pstmt = conn.prepareStatement(sql);

			if (status == 0) { // 주문중인상태이면 취소상태로 업데이트

				pstmt.setInt(1, 2);

			} else { // 배송완료인상태이면 반품상태로 업데이트

				pstmt.setInt(1, 3);
			}

			pstmt.setInt(2, bookNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);
		}

		return result;
	}

	public ArrayList<Order> selectCancelList(Connection conn, int userNo) {
		// 취소/반품목록 불러오기

		ArrayList<Order> list = new ArrayList<>();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectCancelList");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {


				Order o = new Order();
				o.setUserNo(rset.getInt("USER_NO"));
				o.setBookNo(rset.getInt("BOOK_NO"));
				o.setOrderNo(rset.getInt("ORDER_SEQ"));
				o.setCancelDate(rset.getDate("CANCEL_DATE"));
				o.setBookTitle(rset.getString("TITLE"));
				o.setPrice(rset.getInt("PRICE"));
				o.setCount(rset.getInt("COUNT"));
				o.setMultiply(rset.getInt("PRICE") * rset.getInt("COUNT"));
				o.setStatus(rset.getInt("STATUS"));

				list.add(o);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rset);
			close(pstmt);
		}

		return list;

	}

	public int bookAddStock(Connection conn, int bookNo, int count) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("bookAddStock");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, count);
			pstmt.setInt(2, count);
			pstmt.setInt(3, bookNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);
		}

		return result;
	}

	
	public int selectOrderCnt(Connection conn, int userNo, int bookNo) {
		// 주문목록 불러오기

		int result = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOrderCnt");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bookNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result = rset.getInt("CNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

}
