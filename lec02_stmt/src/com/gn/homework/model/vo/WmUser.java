package com.gn.homework.model.vo;

import java.time.LocalDateTime;

public class WmUser {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private LocalDateTime regDate;
	
	public WmUser() {}
	public WmUser(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
	public WmUser(String userId,String userPw,String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
	public WmUser(int userNo, String userId, String userPw, String userName, LocalDateTime regDate) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.regDate = regDate;
	}
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
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "사용자 [번호=" + userNo + ", 아이디=" + userId + ", 비밀번호=" + userPw + ", 이름=" + userName
				+ ", 가입일=" + regDate + "]";
	}
	
	
	
	
}
