package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	// 1. DB와 접속된 Connection 객체를 생성해서 반환시켜주는 메소드
	public static Connection getConnection() {

		// 동적 코딩방식을 적용하기 위해 Properties 객체를 갱성
		Properties prop = new Properties();
		
		// Connection 객체를 담을 그릇 생성
		Connection conn = null;
		
		// 읽어들이고자 하는 파일의 물리적인 경로
		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
		
		// 연결 시키기
		try {
			//prop으로부터 load 메소드를 이용해서 각 키에 해당되는 밸류를 가져옴
			prop.load(new FileInputStream/*통로연결*/(fileName));
			
			// prop으로부터 gerProperty 메소드를 이용해서 각 키에 해당되는 밸류를 뽑아서 배치
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url")
											 , prop.getProperty("username")
											 , prop.getProperty("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Connection 객체 반환
		return conn;
	}
	
	// 전달받은 객체를 반납시켜주는 메소드(각 객체별로)
	// Connection 객체를 전달받아서 반납시켜주는 메소드
	public static void close(Connection conn) {
		try {
			if(conn != null && !(conn.isClosed())) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Statement 객체를 전달받아서 반납시켜주는 메소드
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !(stmt.isClosed())) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet 객체를 전달받아서 반납시켜주는 메소드
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !(rset.isClosed())) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 전달받은 Connection 객체를 가지고 COMMIT 시켜주는 메소드
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	// 전달받은 Connection 객체를 가지고 ROLLBACK 시켜주는 메소드
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
