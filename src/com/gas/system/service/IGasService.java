package com.gas.system.service;

import java.util.List;

import com.gas.entity.Gas;

public interface IGasService {
	
	/**
	 * 获取所有燃气信息
	 * @param gas
	 * @return
	 */
	public List<Gas> list(Gas gas);

	
	/**
	 * 根据id获取燃气信息
	 * @param gas1
	 * @return
	 */
	public Gas getGasById(Gas gas1);
}
