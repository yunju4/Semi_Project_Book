package com.kh.comment.model.vo;

public class Cment {
	
	private int cmentSeq;
	private String userNo;
	private int bookNo;
	private String cment;
	private String status;
	
		
	public Cment() {
		super();
	}


	public Cment(int cmentSeq, String userNo, int bookNo, String cment, String status) {
		super();
		this.cmentSeq = cmentSeq;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.cment = cment;
		this.status = status;
	}
	


	public Cment(int cmentSeq, String userNo,  String cment) {
		super();
		this.cmentSeq = cmentSeq;
		this.userNo = userNo;
		this.cment = cment;
	}


	public int getCmentSeq() {
		return cmentSeq;
	}


	public void setCmentSeq(int cmentSeq) {
		this.cmentSeq = cmentSeq;
	}


	public String getUserNo() {
		return userNo;
	}


	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getCment() {
		return cment;
	}


	public void setCment(String cment) {
		this.cment = cment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Cment [cmentSeq=" + cmentSeq + ", userNo=" + userNo + ", bookNo=" + bookNo + ", cment=" + cment
				+ ", status=" + status + "]";
	}
	
	

}
