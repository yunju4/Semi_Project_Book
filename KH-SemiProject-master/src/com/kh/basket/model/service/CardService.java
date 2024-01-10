package com.kh.basket.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.basket.model.dao.BasketDao;
import com.kh.basket.model.dao.CardDao;
import com.kh.basket.model.vo.Basket;
import com.kh.basket.model.vo.Card;
import com.kh.common.JDBCTemplate;

public class CardService {

	public Card checkCard(int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Card c = new CardDao().checkCard(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return c;
		
	}

}
