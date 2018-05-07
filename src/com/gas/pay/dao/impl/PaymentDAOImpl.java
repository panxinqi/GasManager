package com.gas.pay.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gas.entity.Payment;
import com.gas.entity.User;
import com.gas.pay.dao.IPaymentDAO;
import com.gas.utils.JDBCUtils;

public class PaymentDAOImpl implements IPaymentDAO {

	QueryRunner qr = JDBCUtils.getQueryRunner();
	
	@Override
	public List<Payment> list(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql, new BeanListHandler<>(Payment.class),arr);
	}

	@Override
	public Payment getPayment(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql, new BeanHandler<>(Payment.class),arr);
	}
	
}
