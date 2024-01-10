package com.kh.admin.sellCount.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.sellCount.model.dao.SaleCountDao;
import com.kh.common.JDBCTemplate;
import com.kh.admin.product.model.vo.BookMaster;

public class SaleCountService {

	public int saleCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new SaleCountDao().saleCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count;
		
	}

	public ArrayList<BookMaster> getCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<BookMaster> bml = new SaleCountDao().getCount(conn);
		
		JDBCTemplate.close(conn);
		
		return bml;
	}

}
