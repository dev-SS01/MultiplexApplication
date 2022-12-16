package com.multiplex.dto;

public class UserDTO {
private Integer userId;
private String userName;
private String phoneNumber;
private String emailId;
private String password;
public UserDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public UserDTO(Integer userId, String userName, String phoneNumber, String emailId, String password) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.phoneNumber = phoneNumber;
	this.emailId = emailId;
	this.password = password;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
			+ ", password=" + password + "]";
}
}

