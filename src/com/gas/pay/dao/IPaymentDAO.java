package com.gas.pay.dao;

import java.util.List;

import com.gas.entity.Payment;
import com.gas.entity.User;

public interface IPaymentDAO {
	
	/**
	 * 条件查询  多条信息
	 * @param sql  查询的sql
	 * @param arr  查询的条件,与SQL语句中的？相对应
	 * @return     返回多条记录
	 * @throws Exception
	 */
	public List<Payment> list(String sql,Object[] arr) throws Exception; 
	
	
	/**
	 * 根据条件查询单个信息
	 * @param sql  sql语句
	 * @param arr  arr 条件
	 * @return  UserInfo
	 */
	public Payment getPayment(String sql,Object[] arr) throws Exception;
	
	
}
