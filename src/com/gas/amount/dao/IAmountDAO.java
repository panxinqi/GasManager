package com.gas.amount.dao;

import java.util.List;

import com.gas.entity.Amount;

/**
 * �û���Ȼ�������ӿ�
 * @author xinqi
 *
 */
public interface IAmountDAO {
	
	/**
	 * ¼���û���Ȼ������
	 * @return
	 */
	public boolean addAmount(Amount amount);
	
	/**
	 * 
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public List<Amount> list(String sql,Object[] arr) throws Exception; 
	
	/**
	 * ����id��ȡamount
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public Amount getAmountById(String sql,Object[] arr) throws Exception; 
	
}
