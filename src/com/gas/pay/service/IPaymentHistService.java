package com.gas.pay.service;

import java.util.List;

import com.gas.entity.UserPayment;

public interface IPaymentHistService {
	
	/**
	 * 获取用户历史账单
	 * @param userPayment
	 * @return
	 */
	public List<UserPayment> list(UserPayment userPayment);
	
	
	/**
	 * 根据用户ID获取UserPayment
	 * @param userPayment
	 * @return
	 */
	public List<UserPayment> GetListByUserId(UserPayment userPayment);
	
}
