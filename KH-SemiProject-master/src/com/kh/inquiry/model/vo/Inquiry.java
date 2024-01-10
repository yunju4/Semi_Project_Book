package com.kh.inquiry.model.vo;

import java.sql.Date;

public class Inquiry {
	//필드
	private int inquirySeq;	           
	private int userNo;   
	private Date inquiryDate;	
	private String inquiryClass; 
	private String inquiryEmail; 
	private String inquiryTitle; 
	private String inquiryContent;            
	private String inquiryStatus;         	
	private String answerStatus; 
	private String answer;	
	//생성자
	public Inquiry() {
		super();
	}
	
	public Inquiry(int inquirySeq, Date inquiryDate, String inquiryClass, String inquiryEmail, String inquiryTitle,
			String inquiryContent, String answerStatus, String answer) {
		super();
		this.inquirySeq = inquirySeq;
		this.inquiryDate = inquiryDate;
		this.inquiryClass = inquiryClass;
		this.inquiryEmail = inquiryEmail;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
		this.answerStatus = answerStatus;
		this.answer = answer;
	}

	public Inquiry( String inquiryTitle, int userNo, String answerStatus, Date inquiryDate) {
		super();
		this.userNo = userNo;
		this.inquiryDate = inquiryDate;
		this.inquiryTitle = inquiryTitle;
		this.answerStatus = answerStatus;
	}
	
	public Inquiry(int inquirySeq, String inquiryTitle, String answerStatus, Date inquiryDate) {
		super();
		this.inquirySeq = inquirySeq;
		this.inquiryDate = inquiryDate;
		this.inquiryTitle = inquiryTitle;
		this.answerStatus = answerStatus;
	}

	public Inquiry(int userNo, String inquiryClass, String inquiryEmail, String inquiryTitle,
			String inquiryContent) {
		super();
		this.userNo = userNo;
		this.inquiryClass = inquiryClass;
		this.inquiryEmail = inquiryEmail;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
	}
	//어드민 상세 조회 야매로함 //여기 여기 여기 여기 부터 여기 부턴 여기 ㅜ턴 여기부터 
	public Inquiry( String inquiryClass, String answerStatus,String inquiryEmail, String inquiryTitle, String inquiryContent,
			String answer,Date inquiryDate,int userNo) {
		super();
		
		this.inquiryClass = inquiryClass;
		this.answerStatus = answerStatus;
		this.inquiryEmail=inquiryEmail;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
		this.answer = answer;
		this.inquiryDate = inquiryDate;
		this.userNo=userNo;
	}
	public int getInquirySeq() {
		return inquirySeq;
	}
	public void setInquirySeq(int inquirySeq) {
		this.inquirySeq = inquirySeq;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Date getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public String getInquiryClass() {
		return inquiryClass;
	}
	public void setInquiryClass(String inquiryClass) {
		this.inquiryClass = inquiryClass;
	}
	public String getInquiryEmail() {
		return inquiryEmail;
	}
	public void setInquiryEmail(String inquiryEmail) {
		this.inquiryEmail = inquiryEmail;
	}
	public String getInquiryTitle() {
		return inquiryTitle;
	}
	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public String getInquiryStatus() {
		return inquiryStatus;
	}
	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}
	public String getAnswerStatus() {
		return answerStatus;
	}
	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "Inquiry [inquirySeq=" + inquirySeq + ", userNo=" + userNo + ", inquiryDate=" + inquiryDate
				+ ", inquiryClass=" + inquiryClass + ", inquiryEmail=" + inquiryEmail + ", inquiryTitle=" + inquiryTitle
				+ ", inquiryContent=" + inquiryContent + ", inquiryStatus=" + inquiryStatus + ", answerStatus="
				+ answerStatus + ", answer=" + answer + "]";
	}
	





	
}
