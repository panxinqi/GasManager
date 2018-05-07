package com.gas.entity;

/**
 * �û��ɷ���ʷ��¼��
 * @author xinqi
 *
 */
public class UserPayment {
	private Integer userPayId;
	//�û����
	private Integer userId;
	//�ɷѱ��
	private Integer payId;
	
	//�û���Ϣ
	private User user;
	//�ɷѵ���Ϣ
	private Payment payment;	
	//�û�������Ϣ
	private UserAmount userAmount;
	
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	private Amount amount;
	
	
	public UserAmount getUserAmount() {
		return userAmount;
	}
	public void setUserAmount(UserAmount userAmount) {
		this.userAmount = userAmount;
	}
	public UserPayment(Integer userId) {
		super();
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Integer getUserPayId() {
		return userPayId;
	}
	public void setUserPayId(Integer userPayId) {
		this.userPayId = userPayId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPayId() {
		return payId;
	}
	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	public UserPayment() {
		super();
	}
	@Override
	public String toString() {
		return "UserPayment [userPayId=" + userPayId + ", userId=" + userId + ", payId=" + payId + ", user=" + user
				+ ", payment=" + payment + ", userAmount=" + userAmount + ", amount=" + amount + "]";
	}
	 
}
