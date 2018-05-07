package com.gas.system.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gas.entity.User;
import com.gas.system.dao.IUserDAO;
import com.gas.utils.JDBCUtils;


/**
 * 数据访问接口
 * @author xinqi
 *
 */
public class UserDAOImpl implements IUserDAO{
	//获取数据库操作对象QueryRunner
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
