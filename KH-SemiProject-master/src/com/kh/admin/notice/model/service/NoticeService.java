package com.kh.admin.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.notice.model.dao.NoticeDao;
import com.kh.admin.notice.model.vo.Notice;
import com.kh.common.JDBCTemplate;

public class NoticeService {

	public ArrayList<Notice> selectNotice() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNotice(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

	public int insertNotice(Notice n) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int increaseCount(int noticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public Notice selectNoticeDetail(int noticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Notice n = new NoticeDao().selectNoticeDetail(conn, noticeNo);
		
		JDBCTemplate.close(conn);
		
		return n;
	}



}
