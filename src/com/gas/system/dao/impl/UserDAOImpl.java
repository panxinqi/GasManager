package com.gas.system.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gas.entity.User;
import com.gas.system.dao.IUserDAO;
import com.gas.utils.JDBCUtils;


/**
 * ���ݷ��ʽӿ�
 * @author xinqi
 *
 */
public class UserDAOImpl implements IUserDAO{
	//��ȡ���ݿ��������QueryRunner
	QueryRunner qr = JDBCUtils.getQueryRunner();
	
	@Override
	public List<User> list(String sql, Object[] arr) throws Exception {
		return qr.query(sql, new BeanListHandler<>(User.class),arr);
	}

	@Override
	public User selectById(String sql, Object[] arr) throws Exception {
		 
		return qr.query(sql,new BeanHandler<>(User.class), arr);
	}

	@Override
	public User getUser(String sql, Object[] arr) throws Exception{
		return qr.query(sql, new BeanHandler<>(User.class),arr);
	}

}
