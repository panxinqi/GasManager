package com.gas.system.dao;

import java.util.List;

import com.gas.entity.Gas;

public interface IGasDAO {
	
	/**
	 * 获取所有天然气类别
	 * @return
	 */
	public List<Gas> list(String sql,Object[] arr) throws Exception;
	
	/**
	 * 获取单个信息
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public Gas getGas(String sql,Object[] arr) throws Exception;
	
	
}
