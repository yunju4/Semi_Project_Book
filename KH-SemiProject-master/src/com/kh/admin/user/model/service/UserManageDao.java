package com.kh.admin.user.model.service;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

import com.kh.admin.product.model.dao.ProductDao;
import com.kh.admin.product.model.vo.BookMaster;
import com.kh.member.model.vo.Member;

public class UserManageDao {
	
private Properties prop = new Properties();
	
	public UserManageDao() {
		String fileName = ProductDao.class.getResource("/sql/user/user-mapper.xml").getPath();
			
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Member> selectUser(Connection conn) {
		
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getString("USER_ID"),
										rset.getString("USER_PWD"),
										rset.getString("ADDRESS"),
										rset.getString("EMAIL"),
										rset.getString("PHONE"),
										rset.getString("STATUS")
										));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int delMember(Connection conn, String userId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("delMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int backMember(Connection conn, String userId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("backMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	}


