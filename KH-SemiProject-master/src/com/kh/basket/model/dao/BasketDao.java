package com.kh.basket.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.notice.model.dao.NoticeDao;
import com.kh.admin.product.model.vo.Attachment;
import com.kh.basket.model.vo.Basket;
import com.kh.common.JDBCTemplate;

public class BasketDao {

	private Properties prop = new Properties();
	
	public BasketDao() {
		
		String fileName = NoticeDao.class.getResource("/sql/basket/basket-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Basket> selectBasket(Connection conn, int userNo) {
		
		ArrayList<Basket> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBasket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Basket b = new Basket(rset.getInt("BASKET_SEQ"),
									  rset.getInt("BOOK_NO"),
									  rset.getInt("USER_NO"),
						   			  rset.getInt("COUNT"),
						   			  rset.getString("BTITLE"),
						   			  rset.getInt("BPRICE"),
						   			  rset.getInt("SUMPRICE"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}

	public int insertBook(Connection conn, int bookNo, int userNo, int count) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, count);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public int deleteBasket(Connection conn, int basketNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBasket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, basketNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public ArrayList<Basket> selectBasketImg(Connection conn, int userNo) {
		
		ArrayList<Basket> atList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBasketImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Basket b = new Basket();
				
				b.setBasketSeq(rset.getInt("BASKET_SEQ"));
				b.setBookNo(rset.getInt("BOOK_NO"));
				b.setUserNo(rset.getInt("USER_NO"));
				b.setBookTitle(rset.getString("BTITLE"));
				b.setPrice(rset.getInt("BPRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setSumPrice(rset.getInt("SUMPRICE"));
				b.setTitleImg(rset.getString("TITLEIMG"));
				
				atList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return atList;
		
	}





	
	
}
