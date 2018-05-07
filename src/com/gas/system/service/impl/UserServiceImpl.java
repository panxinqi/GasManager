package com.gas.system.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gas.entity.User;
import com.gas.system.dao.IUserDAO;
import com.gas.system.dao.impl.UserDAOImpl;
import com.gas.system.service.IUserService;
import com.gas.utils.CostUtils;
import com.gas.utils.JDBCUtils;

public class UserServiceImpl implements IUserService{
	
	IUserDAO dao = new UserDAOImpl();

	@Override
	public User isLogin(User user) {
		// TODO Auto-generated method stub
		try{
			
			StringBuffer sql = new StringBuffer("select * from user where userName=? and userPwd=?");
			
			List<Object> list = new ArrayList<>();
			
			//查询有效的数据  相当于 1=1永久成立  
			list.add(user.getUserName());
			list.add(user.getUserPwd());
			
			return dao.getUser(sql.toString(), list.toArray());
			
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public List<User> list(User user) {
		try{
			StringBuffer sql = new StringBuffer("select * from user where userMark=?");
			List<Object> list = new ArrayList<>();
			//查询有效的数据  相当于 1=1永久成立  
			list.add(CostUtils.MARK_YES);
			//条件查询
			if(user!=null){
				if(user.getUserName()!= null && !"".equals(user.getUserName())){
					sql.append(" and userName like?");
					list.add("%"+user.getUserName()+"%");
				}
				if(user.getAddress()!=null && !"".equals(user.getAddress())){
					sql.append(" and address=?");
					list.add(user.getAddress());
				}
			}
			sql.append(" order by userId asc");
				return dao.list(sql.toString(), list.toArray());
		}catch(Exception e){
			e.printStackTrace();
		}
			return null;
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		try{
			String sql = "insert into user(userName,userPwd,sex,phone,address,role,userMark)"
					+ "values(?,?,?,?,?,?,?)";
			List<Object>  list = new ArrayList<>();
			
			list.add(user.getUserName());
			list.add(user.getUserPwd());
			list.add(user.getSex());
			list.add(user.getPhone());
			list.add(user.getAddress());
			list.add(user.getRole());
			list.add(CostUtils.MARK_YES);
			
			return JDBCUtils.audObject(sql, list.toArray());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(User user) {
		
		StringBuffer sql = new StringBuffer("select * from user where userMark=? and userId=?");
		List<Object> list = new ArrayList<Object>();
		
		list.add(CostUtils.MARK_YES);
		list.add(user.getUserId());
		try {
			return dao.getUser(sql.toString(), list.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("update user set userName=?,userPwd=?,sex=?,address=?,phone=?,role=?,balance=?,userMark=? where userId=? ");
		
		List<Object> list = new ArrayList<Object>();
		list.add(user.getUserName());
		list.add(user.getUserPwd());
		list.add(user.getSex());
		list.add(user.getAddress());
		list.add(user.getPhone());
		list.add(user.getRole());
		list.add(user.getBalance());
		list.add(CostUtils.MARK_YES);
		list.add(user.getUserId());
		
		try {
			return JDBCUtils.audObject(sql.toString(), list.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delUser(User user) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("update user set userName=?,userPwd=?,sex=?,address=?,phone=?,role=?,balance=?,userMark=? where userId=? ");
		
		List<Object> list = new ArrayList<Object>();
		list.add(user.getUserName());
		list.add(user.getUserPwd());
		list.add(user.getSex());
		list.add(user.getAddress());
		list.add(user.getPhone());
		list.add(user.getRole());
		list.add(user.getBalance());
		list.add(CostUtils.MARK_NO);
		list.add(user.getUserId());
		
		try {
			return JDBCUtils.audObject(sql.toString(), list.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserByName(User user) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("select * from user where userMark=? and userName=?");
		List<Object> list = new ArrayList<Object>();
		
		list.add(CostUtils.MARK_YES);
		list.add(user.getUserName());
		
		try {
			return dao.getUser(sql.toString(), list.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
