package com.gas.pay.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gas.entity.UserPayment;
import com.gas.pay.dao.IPaymentHistDAO;
import com.gas.utils.JDBCUtils;

public class PaymentHistDAOImpl implements IPaymentHistDAO {
	
	QueryRunner qr = JDBCUtils.getQueryRunner();
	
	@Override
	public List<UserPayment> list(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql, new BeanListHandler<>(UserPayment.class),arr);
	}

	@Override
	public UserPayment getUserPayment(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql, new BeanHandler<>(UserPayment.class),arr);
	}

}
