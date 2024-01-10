package com.kh.admin.sellCount.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.notice.model.dao.NoticeDao;
import com.kh.common.JDBCTemplate;
import com.kh.admin.product.model.vo.BookMaster;

public class SaleCountDao {

	private Properties prop = new Properties();
	
	
	
	public SaleCountDao() {
		String fileName = NoticeDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public int saleCount(Connection conn) {
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("saleCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count = count + rset.getInt("SALE_COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
		
	}



	public ArrayList<BookMaster> getCount(Connection conn) {

		ArrayList<BookMaster> bml = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("getCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BookMaster bm = new BookMaster();
				bm = new BookMaster(rset.getString("TITLE"), rset.getInt("SALE_COUNT"), rset.getInt("SUMPRICE"));
				
				bml.add(bm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return bml;
		
	}

}
