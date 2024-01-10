package com.kh.member.model.vo;

public class Member {
	//필드
	private int userNo;	           
	private String userId;   
	private String userPwd;	
	private String userName; 
	private String phone;            
	private String email;         
	private String postNo;	
	private String address; 
	private String detailAddress; 
	private String status; 
	
	//생성자
	public Member() {
		super();
	}

	public Member( String userId, String userPwd, String userName, String phone, String email, String postNo,
			String address, String detailAddress) {
		super();
	
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.postNo = postNo;
		this.address = address;
		this.detailAddress = detailAddress;
	
	}
	
	public Member(String userId, String userPwd, String address, String email, String phone, String status) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}
	
	public Member( String userName,String phone, String email , String postNo,
			String address, String detailAddress,String userId) {
		super();
	
		this.userId = userId;
		
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.postNo = postNo;
		this.address = address;
		this.detailAddress = detailAddress;
	
	}
	

	public Member(int userNo, String userId, String userPwd, String userName, String phone, String email, String postNo,
			String address, String detailAddress, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.postNo = postNo;
		this.address = address;
		this.detailAddress = detailAddress;
		this.status = status;
	}
	//g and S
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	//tostring

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", phone=" + phone + ", email=" + email + ", postNo=" + postNo + ", address=" + address
				+ ", detailAddress=" + detailAddress + ", status=" + status + "]";
	}
	
}
