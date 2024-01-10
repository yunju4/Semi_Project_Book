package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection conn, Member m) {
		
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
	
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPostNo());
			pstmt.setString(7, m.getAddress());
			pstmt.setString(8, m.getDetailAddress());
			
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		// 결과 리턴
		return result;
	}
	
	public int idCheck(Connection conn, String checkId) {
		
	
		int count = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}
	
	public String findId(Connection conn, String userName, String phone, String email) {
		
				// 변수
				String findedId = "";
				
				PreparedStatement pstmt = null;
				
				ResultSet rset = null;
				
				String sql = prop.getProperty("findId");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, userName);
					pstmt.setString(2, phone);
					pstmt.setString(3, email);
					
					rset = pstmt.executeQuery();
					if(rset.next()) {
						findedId = rset.getString("USER_ID");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				
				return findedId;
		}
	
	public String findPw(Connection conn,String id, String userName,  String email) {
		
				// 변수
				String findedPw = "";
				
				PreparedStatement pstmt = null;
				
				ResultSet rset = null;
				
				String sql = prop.getProperty("findPw");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, id);
					pstmt.setString(2, userName);
					pstmt.setString(3, email);
					
					rset = pstmt.executeQuery();
					if(rset.next()) {
						findedPw = rset.getString("USER_PWD");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				
				return findedPw;
		}
public int deleteMember(Connection conn, String id,String pw) {
		
	
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
	
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			
			
			
			
			result = pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
public Member login(Connection conn, String id,String pw) {
	
	Member m = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("login");

	try {
		
		
		pstmt = conn.prepareStatement(sql);
		
		
		// 빵꾸 매꾸기
		pstmt.setString(1, id);
		pstmt.setString(2,pw);
		
		
		
		
		rset = pstmt.executeQuery();
		if(rset.next()) {
			
			
			
			m = new Member(rset.getInt("USER_NO")
						 , rset.getString("USER_ID")
						 , rset.getString("USER_PWD")
						 , rset.getString("USER_NAME")
						 , rset.getString("PHONE")
						 , rset.getString("EMAIL")
						 , rset.getString("POST_NO")
						 , rset.getString("ADDRESS")
						 , rset.getString("DETAIL_ADDRESS")
						 , rset.getString("STATUS"));
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		// 자원반납
		JDBCTemplate.close(pstmt);
	}
	
	// 결과 리턴
	return m;
}
public Member selectMember(Connection conn, String userId) {
	
	
	Member m = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userId);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			
			m = new Member(rset.getInt("USER_NO"), 
						   rset.getString("USER_ID"), 
						   rset.getString("USER_PWD"), 
						   rset.getString("USER_NAME"), 
						   rset.getString("PHONE"), 
						   rset.getString("EMAIL"), 
						   rset.getString("POST_NO"),
						   rset.getString("ADDRESS"), 
						   rset.getString("DETAIL_ADDRESS"), 
						   rset.getString("STATUS"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}

	return m;
}


   public int updateMember(Connection conn, Member m) {
	      
	      int result = 0;
	      
	      PreparedStatement pstmt = null;
	      
	      
	      String sql = prop.getProperty("updateMember");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, m.getUserName());
	         pstmt.setString(2, m.getPhone());
	         pstmt.setString(3, m.getEmail());
	         pstmt.setString(4, m.getPostNo());
	         pstmt.setString(5, m.getAddress());
	         pstmt.setString(6, m.getDetailAddress());
	         pstmt.setString(7, m.getUserId());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(pstmt);
	      }
	      
	      return result;
	   }

public int updatePwdMember(Connection conn, String userId, String userPwd, String updatePwd) {
	

	int result = 0;
	
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("updatePwdMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, updatePwd);
		pstmt.setString(2, userId);
		pstmt.setString(3, userPwd);
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(pstmt);
	}
	
	return result;
}

public Member checkPwdMember(Connection conn, String userId, String checkPwd) {

	
	Member checkMem = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("checkPwdMember");
	
	try {
	
		pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1, userId);
		pstmt.setString(2, checkPwd);
		
		
		rset = pstmt.executeQuery();
		
		
		if(rset.next()) {
			
			
			checkMem = new Member(rset.getInt("USER_NO")
					 , rset.getString("USER_ID")
					 , rset.getString("USER_PWD")
					 , rset.getString("USER_NAME")
					 , rset.getString("PHONE")
					 , rset.getString("EMAIL")
					 , rset.getString("POST_NO")
					 , rset.getString("ADDRESS")
					 , rset.getString("DETAIL_ADDRESS")
					 , rset.getString("STATUS"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {

		
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	
	return checkMem;
}

		
		
	}


