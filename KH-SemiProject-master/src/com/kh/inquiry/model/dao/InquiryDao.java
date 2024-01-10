package com.kh.inquiry.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.inquiry.model.vo.Inquiry;



public class InquiryDao {
	private Properties prop = new Properties();
	
	public InquiryDao() {
		
		String fileName = InquiryDao.class.getResource("/sql/inquiry/inquiry-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertInquiry(Connection conn, Inquiry i) {
		
	
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertInquiry");
	
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setInt(1, i.getUserNo());
			pstmt.setString(2, i.getInquiryClass());
			pstmt.setString(3, i.getInquiryEmail());
			pstmt.setString(4, i.getInquiryTitle());
			pstmt.setString(5, i.getInquiryContent());
			
			
		
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	public int selectListCount(Connection conn,int userNo) {
		
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1,userNo);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
		
	}

	public ArrayList<Inquiry> selectList(Connection conn,PageInfo pi, int userNo) {
		
		
		ArrayList<Inquiry> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
		
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Inquiry(rset.getInt("LISTNUM"),
									  rset.getString("INQUIRY_TITLE"), 
									  rset.getString("ANSWER_STATUS"), 
									  rset.getDate("INQUIRY_DATE")));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public Inquiry selectInquiry(Connection conn, int inNo, int userNo) {
		
		
		Inquiry i = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectInquiry");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, inNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				i = new Inquiry(rset.getInt("INQUIRY_SEQ"),
								rset.getDate("INQUIRY_DATE"),
							    rset.getString("INQUIRY_CLASS"), 
							    rset.getString("INQUIRY_EMAIL"), 
					
							    rset.getString("INQUIRY_TITLE"), 
							    rset.getString("INQUIRY_CONTENT"), 
							    rset.getString("ANSWER_STATUS"), 
							    rset.getString("ANSWER"));
							   
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return i;
	}
	
public int selectListCountAdmin(Connection conn) {
		
		
	int listCount = 0;
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectListCountAdmin");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		

		
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			listCount = rset.getInt("COUNT");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	return listCount;
	
}

public ArrayList<Inquiry> selectListAdmin(Connection conn,PageInfo pi) {
	
	
	ArrayList<Inquiry> list = new ArrayList<>();
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectListAdmin");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
	
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
	
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			
			list.add(new Inquiry(rset.getString("INQUIRY_TITLE"),
								  rset.getInt("USER_NO"), 
								  rset.getString("ANSWER_STATUS"), 
								  rset.getDate("INQUIRY_DATE")));
		
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	return list;
}

public Inquiry selectInquiryAdmin(Connection conn, int useNo,String text) {
	
	
	Inquiry i = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectInquiryAdmin");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, text);
		pstmt.setInt(2, useNo);
		
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			i = new Inquiry(rset.getString("USER_NAME"),
					rset.getString("ANSWER_STATUS"), 
					rset.getString("INQUIRY_EMAIL"),
					rset.getString("INQUIRY_TITLE"), 
			        rset.getString("INQUIRY_CONTENT"), 
				    rset.getString("ANSWER"),
				    rset.getDate("INQUIRY_DATE"),
				    rset.getInt("USER_NO"));
	
			
		}
	
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	return i;
}
public int insertAn(Connection conn, int userNo,String title,String message ) {
	
	
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("insertAn");

	try {
		
		
		pstmt = conn.prepareStatement(sql);
		
		
		
		pstmt.setString(1, message);
		pstmt.setInt(2, userNo);
		pstmt.setString(3, title);
	
		
		
	
		result = pstmt.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
	
		JDBCTemplate.close(pstmt);
	}
	
	
	
	return result;
}
}
