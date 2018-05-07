package com.gas.entity;

import java.util.Date;

/**
 * 用户交费单
 * @author xinqi
 *
 */
public class Payment {
	//交费单号
	private Integer payId;
	//用量编号
	private Integer amountId;
	//缴费金额
	private double payMoney;
	//缴费日期
	private Date payDate;
	//缴费标识  1表示已经缴费 0表示没有缴费
	private String payMark;
	
	private User user;
	private Amount amount;
	
	
	
	public Payment(Integer payId) {
		super();
		this.payId = payId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public String getPayMark() {
		return payMark;
	}
	public void setPayMark(String payMark) {
		this.payMark = payMark;
	}
	public Integer getPayId() {
		return payId;
	}
	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	public Integer getAmountId() {
		return amountId;
	}
	public void setAmountId(Integer amountId) {
		this.amountId = amountId;
	}
	public double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Payment() {
		super();
	}
	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", amountId=" + amountId + ", payMoney=" + payMoney + ", payDate=" + payDate
				+ ", payMark=" + payMark + ", user=" + user + ", amount=" + amount + "]";
	}
	 
	 
	
	

}
