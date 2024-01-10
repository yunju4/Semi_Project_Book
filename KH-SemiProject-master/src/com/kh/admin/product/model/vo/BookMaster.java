package com.kh.admin.product.model.vo;

public class BookMaster {

	private int bookNo;
	private int bookCode;// BOOK_CODE	NUMBER	NOT NULL,
	private String bookTitle;// BOOK_TITLE	VARCHAR2(300)	NULL,
	private String bookHead;// BOOK_HEAD	VARCHAR2(200)	NULL,
	private String bookContent;// BOOK_CONTENT	VARCHAR2(3000)	NULL,
	private String authorInfo; // AUTHOR_INFO	VARCHAR2(3000)	NULL,
	private int price;// PRICE	NUMBER	NULL,
	private String author;// AUTHOR	VARCHAR2 (50)	NULL,
	private String title;// TITLE	VARCHAR2 (300)	NULL,
	private int saleCount;// SALE_COUNT	NUMBER	NULL,
	private String status;// STATUS	VARCHAR2(1)	DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
	private int stock;// STOCK	NUMBER	NOT NULL,
	private String pblctDate;// PBLCT_DATE	VARCHAR2(20)	NOT NULL,
	private String publisher;// PUBLISHER	VARCHAR2(20)	NOT NULL
	private String tag1;
	private String tag2;
	private String changeName;
	private String filePath;
	
	
	public BookMaster() {
		super();
	}
	
	public BookMaster(int price, String title) {
		super();
		this.price = price;
		this.title = title;
	}
	
	public BookMaster( String title,int saleCount, int price) {
		super();
		this.saleCount = saleCount;
		this.title = title;
		this.price = price;
	}

	public BookMaster(int bookNo, int price, String title, String changeName, String filePath) {
		super();
		this.bookNo = bookNo;
		this.price = price;
		this.title = title;
		this.changeName = changeName;
		this.filePath = filePath;
	}

	public BookMaster(int bookNo, int price, String author, String title, int stock, String pblctDate, String publisher) {
		super();
		this.bookNo = bookNo;
		this.price = price;
		this.author = author;
		this.title = title;
		this.stock = stock;
		this.pblctDate = pblctDate;
		this.publisher = publisher;
	}

	public BookMaster(int bookNo, int price, String author, String title, String pblctDate, String publisher,
			String changeName, String filePath) {
		super();
		this.bookNo = bookNo;
		this.price = price;
		this.author = author;
		this.title = title;
		this.pblctDate = pblctDate;
		this.publisher = publisher;
		this.changeName = changeName;
		this.filePath = filePath;
	}

	public BookMaster(int bookCode, String bookTitle, String bookHead, String bookContent, String authorInfo, int price,
			String author, String title, int stock, String pblctDate, String publisher) {
		super();
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookHead = bookHead;
		this.bookContent = bookContent;
		this.authorInfo = authorInfo;
		this.price = price;
		this.author = author;
		this.title = title;
		this.stock = stock;
		this.pblctDate = pblctDate;
		this.publisher = publisher;
	}
	
	
	public BookMaster(int bookNo, int bookCode, String bookTitle, String bookHead, String bookContent,
			String authorInfo, int price, String author, String title, int stock, String pblctDate, String publisher) {
		super();
		this.bookNo = bookNo;
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookHead = bookHead;
		this.bookContent = bookContent;
		this.authorInfo = authorInfo;
		this.price = price;
		this.author = author;
		this.title = title;
		this.stock = stock;
		this.pblctDate = pblctDate;
		this.publisher = publisher;
	}

	public BookMaster(int bookNo, int bookCode, String bookTitle, String bookHead, String bookContent,
			String authorInfo, int price, String author, String title, int stock, String pblctDate, String publisher,
			String tag1, String tag2) {
		super();
		this.bookNo = bookNo;
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookHead = bookHead;
		this.bookContent = bookContent;
		this.authorInfo = authorInfo;
		this.price = price;
		this.author = author;
		this.title = title;
		this.stock = stock;
		this.pblctDate = pblctDate;
		this.publisher = publisher;
		this.tag1 = tag1;
		this.tag2 = tag2;
	}

	public BookMaster(int bookNo, int bookCode, String bookTitle, String bookHead, String bookContent, String authorInfo, int price,
			String author, String title, int saleCount, String status, int stock, String pblctDate, String publisher) {
		super();
		this.bookNo = bookNo;
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookHead = bookHead;
		this.bookContent = bookContent;
		this.authorInfo = authorInfo;
		this.price = price;
		this.author = author;
		this.title = title;
		this.saleCount = saleCount;
		this.status = status;
		this.stock = stock;
		this.pblctDate = pblctDate;
		this.publisher = publisher;
	}

	public int getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	
	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookHead() {
		return bookHead;
	}

	public void setBookHead(String bookHead) {
		this.bookHead = bookHead;
	}

	public String getBookContent() {
		return bookContent;
	}

	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	public String getAuthorInfo() {
		return authorInfo;
	}

	public void setAuthorInfo(String authorInfo) {
		this.authorInfo = authorInfo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPblctDate() {
		return pblctDate;
	}

	public void setPblctDate(String pblctDate) {
		this.pblctDate = pblctDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "BookMaster [bookNo=" + bookNo + ", bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", bookHead="
				+ bookHead + ", bookContent=" + bookContent + ", authorInfo=" + authorInfo + ", price=" + price
				+ ", author=" + author + ", title=" + title + ", saleCount=" + saleCount + ", status=" + status
				+ ", stock=" + stock + ", pblctDate=" + pblctDate + ", publisher=" + publisher + ", tag1=" + tag1
				+ ", tag2=" + tag2 + "]";
	}

}
