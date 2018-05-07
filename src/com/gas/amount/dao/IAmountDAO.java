package com.gas.amount.dao;

import java.util.List;

import com.gas.entity.Amount;

/**
 * 用户天然气用量接口
 * @author xinqi
 *
 */
public interface IAmountDAO {
	
	/**
	 * 录入用户天然气用量
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
	 * 根据id获取amount
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public Amount getAmountById(String sql,Object[] arr) throws Exception; 
	
}
