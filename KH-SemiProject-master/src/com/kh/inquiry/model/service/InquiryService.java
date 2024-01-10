package com.kh.inquiry.model.service;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.inquiry.model.dao.InquiryDao;
import com.kh.inquiry.model.vo.Inquiry;



public class InquiryService {

	public int insertInquiry(Inquiry i) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new InquiryDao().insertInquiry(conn, i);
		
	
		if(result > 0) { 
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	public int selectListCount(int userNo) {
		
		Connection conn =   JDBCTemplate.getConnection();
		
		int listCount = new InquiryDao().selectListCount(conn,userNo);
		
		
		JDBCTemplate.commit(conn);
		
		return listCount;
	}
	
	public ArrayList<Inquiry> selectList(PageInfo pi,int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Inquiry> list = new InquiryDao().selectList(conn, pi,userNo);
		
		JDBCTemplate.commit(conn);
		
		return list;
	}
	
	public Inquiry selectInquiry(int inNo,int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		Inquiry i= new InquiryDao().selectInquiry(conn, inNo,userNo);
		
		JDBCTemplate.commit(conn);
		
		return i;
	}
	public int selectListCountAdmin() {
		
		Connection conn = JDBCTemplate.getConnection();
		int result= new InquiryDao().selectListCountAdmin(conn);
		
		JDBCTemplate.commit(conn);
		
		return result;
	}
	
public ArrayList<Inquiry> selectListAdmin(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Inquiry> list = new InquiryDao().selectListAdmin(conn, pi);
		
		JDBCTemplate.commit(conn);
		
		return list;
	}

public Inquiry selectInquiryAdmin(int useNo,String text) {
	
	Connection conn = JDBCTemplate.getConnection();
	Inquiry i= new InquiryDao().selectInquiryAdmin(conn, useNo,text);
	
	JDBCTemplate.commit(conn);
	
	return i;
}

public int insertAn(int userNo,String title,String message ) {
	
	Connection conn = JDBCTemplate.getConnection();
	
	int result = new InquiryDao().insertAn(conn, userNo,title,message);
	

	if(result > 0) { 
		JDBCTemplate.commit(conn);
	}
	else {
		JDBCTemplate.rollback(conn);
	}
	
	JDBCTemplate.close(conn);
	
	return result;
}
	
}
