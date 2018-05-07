package com.gas.entity;

/**
 * 用量记录表
 * @author xinqi
 *
 */
public class UserAmount {
	
	//用户编号
	private Integer userId;
	//用量编号
	private Integer amountId;
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAmountId() {
		return amountId;
	}
	public void setAmountId(Integer amountId) {
		this.amountId = amountId;
	}
	public UserAmount() {
		super();
	}
	public UserAmount(Integer userId) {
		this.userId = userId;
	}
}
