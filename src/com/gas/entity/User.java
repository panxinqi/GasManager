package com.gas.entity;

import com.gas.utils.CostUtils;

public class User {
	private Integer userId;
	private String userName;
	private String userPwd;
	private String sex;
	private String phone;
	private String address;
	private String role;
	//ø…”√”‡∂Ó
	private double balance;
	private String userMark;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public User(Integer userId) {
		super();
		this.userId = userId;
		this.userMark = CostUtils.MARK_YES;
	}
	public String getUserMark() {
		return userMark;
	}
	public void setUserMark(String userMark) {
		this.userMark = userMark;
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", sex=" + sex
				+ ", phone=" + phone + ", address=" + address + ", role=" + role + ", balance=" + balance
				+ ", userMark=" + userMark + "]";
	}
	
	

}
