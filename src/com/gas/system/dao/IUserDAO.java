package com.gas.system.dao;

import java.util.List;

import com.gas.entity.User;


public interface IUserDAO {
	
	/**
	 * ������ѯ  ������Ϣ
	 * @param sql  ��ѯ��sql
	 * @param arr  ��ѯ������,��SQL����еģ����Ӧ
	 * @return     ���ض�����¼
	 * @throws Exception
	 */
	public List<User> list(String sql,Object[] arr) throws Exception; 
	
	
	/**
	 * ͨ��ID��ѯ�û���Ϣ
	 * @param sql sql���
	 * @param arr ����
	 * @return  UserInfo
	 * @throws Exception
	 */
	public User selectById(String sql,Object[] arr) throws Exception;
	
	
	/**
	 * ����������ѯ�����û���Ϣ
	 * @param sql  sql���
	 * @param arr  arr ����
	 * @return  UserInfo
	 */
	public User getUser(String sql,Object[] arr) throws Exception;
	
	
}
