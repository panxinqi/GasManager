package com.gas.system.dao;

import java.util.List;

import com.gas.entity.Gas;

public interface IGasDAO {
	
	/**
	 * ��ȡ������Ȼ�����
	 * @return
	 */
	public List<Gas> list(String sql,Object[] arr) throws Exception;
	
	/**
	 * ��ȡ������Ϣ
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public Gas getGas(String sql,Object[] arr) throws Exception;
	
	
}
