package com.gas.pay.service;

import java.util.List;

import com.gas.entity.UserPayment;

public interface IPaymentHistService {
	
	/**
	 * ��ȡ�û���ʷ�˵�
	 * @param userPayment
	 * @return
	 */
	public List<UserPayment> list(UserPayment userPayment);
	
	
	/**
	 * �����û�ID��ȡUserPayment
	 * @param userPayment
	 * @return
	 */
	public List<UserPayment> GetListByUserId(UserPayment userPayment);
	
}
