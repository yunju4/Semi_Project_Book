package com.kh.admin.product.model.vo;

public class Attachment {

	private int key;//	KEY	NUMBER		PRIMARY KEY,
	private int bookNo;//	BOOK_NO	NUMBER		REFERENCES BOOK_MASTER(BOOK_NO),
	private String originName;//	ORIGIN_NAME	VARCHAR2(255)		NOT NULL,
	private String changeName;//	CHANGE_NAME	VARCHAR2(255)		NOT NULL,
	private String filePath;//	FILE_PATH	VARCHAR2(1000)		NOT NULL,
	private String status;//	STATUS	VARCHAR2(1)	DEFAULT 'Y'	NULL
	
	public Attachment() {
		super();
	}
	
	

	public Attachment(int key, String originName, String changeName, String filePath) {
		super();
		this.key = key;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}



	public Attachment(int key, int bookNo, String originName, String changeName, String filePath, String status) {
		super();
		this.key = key;
		this.bookNo = bookNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.status = status;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [key=" + key + ", bookNo=" + bookNo + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", status=" + status + "]";
	}

}
