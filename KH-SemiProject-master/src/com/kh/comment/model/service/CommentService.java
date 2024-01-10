package com.kh.comment.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.comment.model.dao.CommentDao;
import com.kh.comment.model.vo.Cment;

public class CommentService {
	
		public int insertComment(Cment c){
			Connection conn = getConnection();
		
			int result = new CommentDao().insertComment(conn, c);
			
			if(result > 0) { // 성공
				commit(conn);
			}
			else { // 실패
				rollback(conn);
			}
			
			close(conn);
			
			return result;
	}
		public ArrayList<Cment> selectComment(int bookNo) {
			
			Connection conn = getConnection();
			
			ArrayList<Cment> list = new CommentDao().selectComment(conn, bookNo);
			
			close(conn);
			
			return list;
		}
}
