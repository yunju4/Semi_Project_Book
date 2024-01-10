package com.kh.admin.product.model.vo;

public class BookTag {
	
	private int tagNo;
	private String tagContent;
	private int bookNo;
	
	public BookTag() {
		super();
	}
	
	

	public BookTag(int tagNo, String tagContent) {
		super();
		this.tagNo = tagNo;
		this.tagContent = tagContent;
	}



	public BookTag(int tagNo, String tagContent, int bookNo) {
		super();
		this.tagNo = tagNo;
		this.tagContent = tagContent;
		this.bookNo = bookNo;
	}

	public int getTagNo() {
		return tagNo;
	}

	public void setTagNo(int tagNo) {
		this.tagNo = tagNo;
	}

	public String getTagContent() {
		return tagContent;
	}

	public void setTagContent(String tagContent) {
		this.tagContent = tagContent;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "BookTag [tagNo=" + tagNo + ", tagContent=" + tagContent + ", bookNo=" + bookNo + "]";
	}

}
