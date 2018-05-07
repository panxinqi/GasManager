package com.gas.amount.service;

import java.util.List;

import com.gas.entity.Amount;
import com.gas.entity.Payment;

public interface IAmountService {
	
	/**
	 * ¼���û�ȼ��������Ϣ
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
	 * ͨ��ID��ȡAmount
	 * @param amount
	 * @return
	 */
	public Amount getAmountById(Amount amount);
	
	/**�����û��ɷѵ�
	 * @param payment
	 * @return
	 */
	public boolean toPayment(Payment payment);
	
}
