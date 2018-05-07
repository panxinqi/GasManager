package com.gas.system.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gas.entity.Gas;
import com.gas.system.dao.IGasDAO;
import com.gas.utils.JDBCUtils;

public class GasDAOImpl implements IGasDAO {

	QueryRunner qr = JDBCUtils.getQueryRunner();
	
	@Override
	public List<Gas> list(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql, new BeanListHandler<>(Gas.class),arr);
	}

	@Override
	public Gas getGas(String sql, Object[] arr) throws Exception {
		// TODO Auto-generated method stub
		return qr.query(sql, new BeanHandler<>(Gas.class),arr);
	}

}
