package com.kh.order.model.vo;

import java.sql.Date;

public class Order {

	private int userNo; // 유저넘버
	private int orderNo; // 오더넘버
	private int bookNo;
	private Date orderDate; // 주문날짜
	private Date cancelDate; // 주문취소날짜
	private String bookTitle; // 책제목
	private int price; // 가격
	private int count; // 수량
	private int multiply; // 가격 * 수량
	private int status; // 주문상태
	private int confirmation; // 확정날짜 = 주문날짜 + 30일 => 지나면 반품불가능
	private Date confirmationDate;

	public Order() {
		super();
	}

	public Order(int userNo, int orderNo, int bookNo, Date orderDate, Date cancelDate, String bookTitle, int price, int count, int multiply,
			int status, int confirmation, Date confirmationDate) {
		super();
		this.userNo = userNo;
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.orderDate = orderDate;
		this.cancelDate = cancelDate;
		this.bookTitle = bookTitle;
		this.price = price;
		this.count = count;
		this.multiply = multiply;
		this.status = status;
		this.confirmation = confirmation;
		this.confirmationDate = confirmationDate;
	}
	
	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getMultiply() {
		return multiply;
	}

	public void setMultiply(int multiply) {
		this.multiply = multiply;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStatus() {
		return status;
	}

	public int getConfirmation() {
		return confirmation;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setConfirmation(int confirmation) {
		this.confirmation = confirmation;
	}


	@Override
	public String toString() {
		return "Order [userNo=" + userNo + ", orderNo=" + orderNo + ", orderDate=" + orderDate + ", bookTitle="
				+ bookTitle + ", price=" + price + ", count=" + count + ", multiply=" + multiply + ", status=" + status
				+ ", confirmation=" + confirmation + "]";
	}

}
