package com.multiplex.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertable")
public class User {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer userId;
private String userName;
private String phoneNumber;
private String emailId;
private String password;
public User() {
	super();
}
public User(Integer userId, String userName, String phoneNumber, String emailId, String password) {
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
@Override
public int hashCode() {
	return Objects.hash(emailId, password, phoneNumber, userId, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(emailId, other.emailId) && Objects.equals(password, other.password)
			&& Objects.equals(phoneNumber, other.phoneNumber) && userId == other.userId
			&& Objects.equals(userName, other.userName);
}


}
