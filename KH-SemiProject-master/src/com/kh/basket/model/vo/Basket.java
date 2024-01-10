package com.kh.basket.model.vo;

public class Basket {

	private int basketSeq;
	private int bookNo;
	private int userNo;
	private int count;
	private String status;
	
	private String bookTitle;
	private int price;
	private int sumPrice;
	
	// 썸내일 파일명
	private String titleImg;
	
	public Basket() {
		super();
	}
	
	

	public Basket(int basketSeq) {
		super();
		this.basketSeq = basketSeq;
	}



	public Basket(int basketSeq, int bookNo, int userNo, int count, String status) {
		super();
		this.basketSeq = basketSeq;
		this.bookNo = bookNo;
		this.userNo = userNo;
		this.count = count;
		this.status = status;
	}

	

	public Basket(int basketSeq, int count, String bookTitle, int price, int sumPrice) {
		super();
		this.basketSeq = basketSeq;
		this.count = count;
		this.bookTitle = bookTitle;
		this.price = price;
		this.sumPrice = sumPrice;
	}

	public Basket(int basketSeq, int bookNo, int userNo, int count, String bookTitle, int price,
			int sumPrice) {
		super();
		this.basketSeq = basketSeq;
		this.bookNo = bookNo;
		this.userNo = userNo;
		this.count = count;
		this.bookTitle = bookTitle;
		this.price = price;
		this.sumPrice = sumPrice;
	}
	
	public Basket(int basketSeq, int bookNo, int userNo, int count, String bookTitle, int price,
			int sumPrice, String titleImg) {
		super();
		this.basketSeq = basketSeq;
		this.bookNo = bookNo;
		this.userNo = userNo;
		this.count = count;
		this.bookTitle = bookTitle;
		this.price = price;
		this.sumPrice = sumPrice;
		this.titleImg = titleImg;
	}



	public int getBasketSeq() {
		return basketSeq;
	}

	public void setBasketSeq(int basketSeq) {
		this.basketSeq = basketSeq;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	
	
	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}



	@Override
	public String toString() {
		return "Basket [basketSeq=" + basketSeq + ", bookNo=" + bookNo + ", userNo=" + userNo + ", count=" + count
				+ ", status=" + status + ", bookTitle=" + bookTitle + ", price=" + price + ", sumPrice=" + sumPrice
				+ "]";
	}

	

	
	
}
