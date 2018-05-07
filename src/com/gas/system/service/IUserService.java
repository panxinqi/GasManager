package com.gas.system.service;

import java.util.List;

import com.gas.entity.User;


/**
 * 业务逻辑接口
 * @author xinqi
 *
 */
public interface IUserService {
	
	/**
	 * 判断是否登录成功的方法
	 * @return  User
	 */
	public User isLogin(User user);	
	
	
	/**
	 * 查询用户信息
	 * @param user
	 * @return
	 */
	public List<User> list(User user);
	
	/**
	 * 添加用户信息
	 * @param   user  User
	 * @return  true成功   false失败
	 */
	public boolean add(User user);
	
	
	/**
	 * 根据ＩＤ获取用户信息
	 * @param user
	 * @return  User
	 */
	public User getUser(User user);
	
	/**
	 * 根据用户名获取用户信息
	 * @param user
	 * @return
	 */
	public User getUserByName(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	/**
	 * 删除用户信息  这里指的是假删除  后台数据库并没有删除只是前台界面不显示信息而已  把标识改成o
	 * @param user
	 * @return
	 */
	public boolean delUser(User user);
	
	
	
}
