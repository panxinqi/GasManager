package com.gas.entity;

/**
 * ”√¡ø±Ì
 * @author xinqi
 *
 */
public class Amount {
	private Integer amountId;
	private Integer userId;
	private Integer gasId;
	private double price;
	private double amount;
	private String month;
	private String enterUserName;
	
	public Amount(Integer amountId) {
		super();
		this.amountId = amountId;
	}
	public Integer getGasId() {
		return gasId;
	}
	public void setGasId(Integer gasId) {
		this.gasId = gasId;
	}
	public String getEnterUserName() {
		return enterUserName;
	}
	public void setEnterUserName(String enterUserName) {
		this.enterUserName = enterUserName;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Amount() {
		super();
	}
	@Override
	public String toString() {
		return "Amount [amountId=" + amountId + ", userId=" + userId + ", gasId=" + gasId + ", price=" + price
				+ ", amount=" + amount + ", month=" + month + ", enterUserName=" + enterUserName + "]";
	}
	 

}
