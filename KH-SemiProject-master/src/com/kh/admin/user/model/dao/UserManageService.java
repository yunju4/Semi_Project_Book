package com.kh.admin.user.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.product.model.dao.ProductDao;
import com.kh.admin.product.model.vo.BookMaster;
import com.kh.admin.user.model.service.UserManageDao;
import com.kh.member.model.vo.Member;

public class UserManageService {

	public ArrayList<Member> selectUser() {
		
	Connection conn = getConnection();
		
		ArrayList<Member> list = new UserManageDao().selectUser(conn);
		
		close(conn);
		
		return list;
	}

	public int delMember(String userId) {
		
		Connection conn = getConnection();
		
		int result = new UserManageDao().delMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	public int backMember(String userId) {

		Connection conn = getConnection();
		
		int result = new UserManageDao().backMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
	}

}
