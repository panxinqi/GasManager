package com.gas.pay.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gas.entity.Payment;
import com.gas.entity.UserPayment;
import com.gas.utils.JDBCUtils;

public interface IPaymentHistDAO {
	
	/**
	 * 
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public List<UserPayment> list(String sql, Object[] arr) throws Exception ;

	/**
	 * 
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public UserPayment getUserPayment(String sql, Object[] arr) throws Exception ;
}
