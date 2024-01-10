package com.kh.admin.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

import com.kh.admin.product.model.vo.Attachment;
import com.kh.admin.product.model.vo.BookMaster;
import com.kh.admin.product.model.vo.BookTag;

public class ProductDao {
	
	private Properties prop = new Properties();
	
	public ProductDao() {
		String fileName = ProductDao.class.getResource("/sql/product/product-mapper.xml").getPath();
			
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectBookNo(Connection conn) {
		
		// SELECT => ResultSet => 조회 후 반환형을 int
		
		// 필요한 변수 셋팅
		int bookNo = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBookNo");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bookNo = rset.getInt("BOOK_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		return bookNo;
		
	}
	
	public int insertProduct(Connection conn, BookMaster bm) {
		
		// 필요한 변수 셋팅
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bm.getBookNo());
			pstmt.setInt(2, bm.getBookCode());
			pstmt.setString(3, bm.getBookTitle());
			pstmt.setString(4, bm.getBookHead());
			pstmt.setString(5, bm.getBookContent());
			pstmt.setString(6, bm.getAuthorInfo());
			pstmt.setInt(7, bm.getPrice());
			pstmt.setString(8, bm.getAuthor());
			pstmt.setString(9, bm.getTitle());
			pstmt.setInt(10, bm.getStock());
			pstmt.setString(11, bm.getPblctDate());
			pstmt.setString(12, bm.getPublisher());
			
			// SQL 실행
			// INSERT => pstmt.executeUpdate();
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, at.getBookNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			// SQL 실행
			// INSERT => pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertTag(Connection conn,BookTag tc) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertTag");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tc.getTagNo());
			pstmt.setString(2, tc.getTagContent());
			pstmt.setInt(3, tc.getBookNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<BookMaster> selectProduct(Connection conn) {
		
		ArrayList<BookMaster> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new BookMaster(rset.getInt("BOOK_NO"),
										rset.getInt("PRICE"),
										rset.getString("AUTHOR"),
										rset.getString("TITLE"),
										rset.getInt("STOCK"),
										rset.getString("PBLCT_DATE"),
										rset.getString("PUBLISHER")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public BookMaster selectProductDetail(Connection conn, int bookNo) {
		
		BookMaster bm = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			
			rset = pstmt.executeQuery();
			
			// 조회한 한 행이므로
			if(rset.next()) {
				bm = new BookMaster(rset.getInt("BOOK_NO"),
									rset.getInt("BOOK_CODE"),
									rset.getString("BOOK_TITLE"),
									rset.getString("BOOK_HEAD"),
									rset.getString("BOOK_CONTENT"),
									rset.getString("AUTHOR_INFO"),
									rset.getInt("PRICE"),
									rset.getString("AUTHOR"),
									rset.getString("TITLE"),
									rset.getInt("STOCK"),
									rset.getString("PBLCT_DATE"),
									rset.getString("PUBLISHER"),
									rset.getString("TAG1"),
									rset.getString("TAG2")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bm;
	}
	
	public Attachment selectAttachment(Connection conn, int bookNo) {
		
		Attachment at = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			
			rset = pstmt.executeQuery();
			
			// 조회되는 놈이 한 행이므로
			if(rset.next()) {
				
				at = new Attachment(rset.getInt("KEY"),
									rset.getString("ORIGIN_NAME"),
									rset.getString("CHANGE_NAME"),
									rset.getString("FILE_PATH"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return at;
		
	}
	
	public int updateProduct(Connection conn, BookMaster bm) {
		
		// 필요한 변수 셋팅
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bm.getBookCode());
			pstmt.setString(2, bm.getBookTitle());
			pstmt.setString(3, bm.getBookHead());
			pstmt.setString(4, bm.getBookContent());
			pstmt.setString(5, bm.getAuthorInfo());
			pstmt.setInt(6, bm.getPrice());
			pstmt.setString(7, bm.getAuthor());
			pstmt.setString(8, bm.getTitle());
			pstmt.setInt(9, bm.getStock());
			pstmt.setString(10, bm.getPblctDate());
			pstmt.setString(11, bm.getPublisher());
			pstmt.setInt(12, bm.getBookNo());
			
			// SQL 실행
			// INSERT => pstmt.executeUpdate();
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getBookNo());
			
			// SQL 실행
			// INSERT => pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateTag(Connection conn,BookTag tc) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateTag");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, tc.getTagContent());
			pstmt.setInt(2, tc.getBookNo());
			pstmt.setInt(3, tc.getTagNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteProduct(Connection conn, int bno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<BookMaster> selectProduct(Connection conn, String selectType, int bookCnt, String sort) {
		
		ArrayList<BookMaster> bmlist = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = "";
		if("best".equals(selectType)) {
			sql = prop.getProperty("selectBestProduct");
		}
		else {
			sql = prop.getProperty("selectNewProduct");
		}
		
		if("title".equals(sort)) {
			sql += " ORDER BY TITLE ASC";
		} else if("dPub".equals(sort)) {
			sql += " ORDER BY PBLCT_DATE ASC";
		} else if("lowPrice".equals(sort)) {
			sql += " ORDER BY PRICE ASC";
		} else if("highPrice".equals(sort)) {
			sql += " ORDER BY PRICE DESC";
		} else {
			sql += " ORDER BY PBLCT_DATE ASC";
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookCnt);
			
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bmlist.add(new BookMaster(rset.getInt("BOOK_NO"),
										  rset.getInt("PRICE"),
										  rset.getString("AUTHOR"),
										  rset.getString("TITLE"),
										  rset.getString("PBLCT_DATE"),
										  rset.getString("PUBLISHER"),
										  rset.getString("CHANGE_NAME"),
										  rset.getString("FILE_PATH")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bmlist;
	}
	
	public ArrayList<BookMaster> selectSearchProduct(Connection conn, String keyword, String sort) {
		
		ArrayList<BookMaster> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSearchProduct");
		
		if("title".equals(sort)) {
			sql += " ORDER BY TITLE ASC";
		} else if("dPub".equals(sort)) {
			sql += " ORDER BY PBLCT_DATE ASC";
		} else if("lowPrice".equals(sort)) {
			sql += " ORDER BY PRICE ASC";
		} else if("highPrice".equals(sort)) {
			sql += " ORDER BY PRICE DESC";
		} else {
			sql += " ORDER BY PBLCT_DATE ASC";
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			pstmt.setString(4, keyword);
			pstmt.setString(5, keyword);
			
			

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new BookMaster(rset.getInt("BOOK_NO"),
										rset.getInt("PRICE"),
										rset.getString("AUTHOR"),
										rset.getString("TITLE"),
										rset.getString("PBLCT_DATE"),
										rset.getString("PUBLISHER"),
										rset.getString("CHANGE_NAME"),
										rset.getString("FILE_PATH")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<BookMaster> selectAllProduct(Connection conn, String category, String sort) {
		
		ArrayList<BookMaster> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllProduct");
		if("title".equals(sort)) {
			sql += " ORDER BY TITLE ASC";
		} else if("dPub".equals(sort)) {
			sql += " ORDER BY PBLCT_DATE ASC";
		} else if("lowPrice".equals(sort)) {
			sql += " ORDER BY PRICE ASC";
		} else if("highPrice".equals(sort)) {
			sql += " ORDER BY PRICE DESC";
		} else {
			sql += " ORDER BY PBLCT_DATE ASC";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(category));
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new BookMaster(rset.getInt("BOOK_NO"),
										rset.getInt("PRICE"),
										rset.getString("AUTHOR"),
										rset.getString("TITLE"),
										rset.getString("PBLCT_DATE"),
										rset.getString("PUBLISHER"),
										rset.getString("CHANGE_NAME"),
										rset.getString("FILE_PATH")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		return list;	
	}
}
