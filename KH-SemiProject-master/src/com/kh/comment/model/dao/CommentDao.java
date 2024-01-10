package com.kh.comment.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.kh.comment.model.vo.Cment;


public class CommentDao {
private Properties prop = new Properties();
	
	public CommentDao() {
		
		String fileName = CommentDao.class.getResource("/sql/comment/comment-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertComment(Connection conn, Cment c) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		System.out.println(c.toString());
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(c.getUserNo()));
			pstmt.setInt(2, c.getBookNo());
			pstmt.setString(3, c.getCment());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public ArrayList<Cment> selectComment(Connection conn, int bookNo) {
		
		// SELECT => ResultSet => ArrayList, while
		// 변수
		ArrayList<Cment> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Cment(rset.getInt("CMENT_SEQ")
								 , rset.getString("USER_ID")
								 , rset.getString("CMENT")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
}
	