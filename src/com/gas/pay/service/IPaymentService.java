package com.gas.pay.service;

import java.util.List;

import com.gas.entity.Payment;
import com.gas.entity.User;

public interface IPaymentService {
	
	
	/**
	 * 条件查询  多条信息
	 * @param sql  查询的sql
	 * @param arr  查询的条件,与SQL语句中的？相对应
	 * @return     返回多条记录
	 * @throws Exception
	 */
	public List<Payment> list(Payment payment,User user) ; 
	
	
	/**
	 * 根据条件查询单个信息
	 * @param sql  sql语句
	 * @param arr  arr 条件
	 * @return  UserInfo
	 */
	public Payment getPayment(String sql,Object[] arr) ;
	
	
	/**
	 * 添加缴费单
	 * @param payment
	 * @return
	 * @throws Exception
	 */
	public boolean add(Payment payment);
	
	/**
	 * 生成缴费单  payMark == 0
	 * @param payment
	 * @return
	 * @throws Exception
	 */
	public boolean audit(Payment payment);
	
	/**
	 * 根据paymentID获取信息
	 * @param payment
	 * @return
	 * @throws Exception
	 */
	public Payment getPaymentById(Payment payment);
	
	/**
	 * 用户交费单查询
	 * @param payment
	 * @param user
	 * @return
	 */
	public List<Payment> payList(Payment payment,User user);

	/**
	 * 根据payId获取payment信息
	 * @param payment
	 * @return
	 */
	public Payment getPaymentByPayId(Payment payment1);


	/**
	 * 缴费方法
	 * @param payment
	 * @return
	 */
	public boolean payMoney(Payment	payment);
}
