package com.gas.entity;

/**
 * ������¼��
 * @author xinqi
 *
 */
public class UserAmount {
	
	//�û����
	private Integer userId;
	//�������
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
