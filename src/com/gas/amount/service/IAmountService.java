package com.gas.amount.service;

import java.util.List;

import com.gas.entity.Amount;
import com.gas.entity.Payment;

public interface IAmountService {
	
	/**
	 * 录入用户燃气用量信息
	 * @return
	 */
	public boolean add(Amount amount);
	
	/**
	 * 
	 * @param amount
	 * @return
	 *  */
	
	public List<Amount> list(Amount amount);
	
	/**
	 * 通过ID获取Amount
	 * @param amount
	 * @return
	 */
	public Amount getAmountById(Amount amount);
	
	/**生成用户缴费单
	 * @param payment
	 * @return
	 */
	public boolean toPayment(Payment payment);
	
}
