package com.gas.pay.service;

import java.util.List;

import com.gas.entity.Payment;
import com.gas.entity.User;

public interface IPaymentService {
	
	
	/**
	 * ������ѯ  ������Ϣ
	 * @param sql  ��ѯ��sql
	 * @param arr  ��ѯ������,��SQL����еģ����Ӧ
	 * @return     ���ض�����¼
	 * @throws Exception
	 */
	public List<Payment> list(Payment payment,User user) ; 
	
	
	/**
	 * ����������ѯ������Ϣ
	 * @param sql  sql���
	 * @param arr  arr ����
	 * @return  UserInfo
	 */
	public Payment getPayment(String sql,Object[] arr) ;
	
	
	/**
	 * ��ӽɷѵ�
	 * @param payment
	 * @return
	 * @throws Exception
	 */
	public boolean add(Payment payment);
	
	/**
	 * ���ɽɷѵ�  payMark == 0
	 * @param payment
	 * @return
	 * @throws Exception
	 */
	public boolean audit(Payment payment);
	
	/**
	 * ����paymentID��ȡ��Ϣ
	 * @param payment
	 * @return
	 * @throws Exception
	 */
	public Payment getPaymentById(Payment payment);
	
	/**
	 * �û����ѵ���ѯ
	 * @param payment
	 * @param user
	 * @return
	 */
	public List<Payment> payList(Payment payment,User user);

	/**
	 * ����payId��ȡpayment��Ϣ
	 * @param payment
	 * @return
	 */
	public Payment getPaymentByPayId(Payment payment1);


	/**
	 * �ɷѷ���
	 * @param payment
	 * @return
	 */
	public boolean payMoney(Payment	payment);
}
