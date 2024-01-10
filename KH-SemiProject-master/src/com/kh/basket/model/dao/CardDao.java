package com.kh.basket.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.admin.notice.model.dao.NoticeDao;
import com.kh.basket.model.vo.Card;
import com.kh.common.JDBCTemplate;

public class CardDao {
	
	private Properties prop = new Properties();
	
	public CardDao() {
		
		String fileName = NoticeDao.class.getResource("/sql/order/order-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Card checkCard(Connection conn, int userNo) {
		
		Card c = new Card();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkCard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset);
			
			if(rset.next()) {
				c.setCardCom(rset.getString("CARD_COM"));
				c.setCardPwd(rset.getString("CARD_PWD"));
				c.setcNum(rset.getString("CNUM"));
			}
			System.out.println(c.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return c;
		
	}

}
