package com.gas.amount.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gas.amount.dao.IAmountDAO;
import com.gas.entity.Amount;
import com.gas.entity.User;
import com.gas.utils.JDBCUtils;

public class AmountDAOImpl implements IAmountDAO {

	//获取数据库操作对象
	QueryRunner qr = JDBCUtils.getQueryRunner();
	
	@Override
	public boolean addAmount(Amount amount) {
		// TODO Auto-generated method stub
		return false ;
	}

	@Override
	public List<Amount> list(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql, new BeanListHandler<>(Amount.class),arr);
	}

	@Override
	public Amount getAmountById(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql,new BeanHandler<>(Amount.class), arr);
	}

}
