package com.gas.system.service;

import java.util.List;

import com.gas.entity.User;


/**
 * ҵ���߼��ӿ�
 * @author xinqi
 *
 */
public interface IUserService {
	
	/**
	 * �ж��Ƿ��¼�ɹ��ķ���
	 * @return  User
	 */
	public User isLogin(User user);	
	
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param user
	 * @return
	 */
	public List<User> list(User user);
	
	/**
	 * ����û���Ϣ
	 * @param   user  User
	 * @return  true�ɹ�   falseʧ��
	 */
	public boolean add(User user);
	
	
	/**
	 * ���ݣɣĻ�ȡ�û���Ϣ
	 * @param user
	 * @return  User
	 */
	public User getUser(User user);
	
	/**
	 * �����û�����ȡ�û���Ϣ
	 * @param user
	 * @return
	 */
	public User getUserByName(User user);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	/**
	 * ɾ���û���Ϣ  ����ָ���Ǽ�ɾ��  ��̨���ݿⲢû��ɾ��ֻ��ǰ̨���治��ʾ��Ϣ����  �ѱ�ʶ�ĳ�o
	 * @param user
	 * @return
	 */
	public boolean delUser(User user);
	
	
	
}
