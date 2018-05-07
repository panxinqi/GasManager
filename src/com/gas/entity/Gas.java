package com.gas.entity;

public class Gas {
	
	private Integer gasId;
	private String gasName;
	private double gasPrice;
	private String gasDesc;
	public Integer getGasId() {
		return gasId;
	}
	public void setGasId(Integer gasId) {
		this.gasId = gasId;
	}
	public String getGasName() {
		return gasName;
	}
	public void setGasName(String gasName) {
		this.gasName = gasName;
	}
	public double getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(double gasPrice) {
		this.gasPrice = gasPrice;
	}
	public String getGasDesc() {
		return gasDesc;
	}
	public void setGasDesc(String gasDesc) {
		this.gasDesc = gasDesc;
	}
	public Gas() {
		super();
	}
	@Override
	public String toString() {
		return "Gas [gasId=" + gasId + ", gasName=" + gasName + ", gasPrice=" + gasPrice + ", gasDesc=" + gasDesc + "]";
	}
	
	
	
}
