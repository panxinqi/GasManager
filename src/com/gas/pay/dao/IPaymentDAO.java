package com.gas.pay.dao;

import java.util.List;

import com.gas.entity.Payment;
import com.gas.entity.User;

public interface IPaymentDAO {
	
	/**
	 * ������ѯ  ������Ϣ
	 * @param sql  ��ѯ��sql
	 * @param arr  ��ѯ������,��SQL����еģ����Ӧ
	 * @return     ���ض�����¼
	 * @throws Exception
	 */
	public List<Payment> list(String sql,Object[] arr) throws Exception; 
	
	
	/**
	 * ����������ѯ������Ϣ
	 * @param sql  sql���
	 * @param arr  arr ����
	 * @return  UserInfo
	 */
	public Payment getPayment(String sql,Object[] arr) throws Exception;
	
	
}
