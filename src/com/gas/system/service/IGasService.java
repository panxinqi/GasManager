package com.gas.system.service;

import java.util.List;

import com.gas.entity.Gas;

public interface IGasService {
	
	/**
	 * ��ȡ����ȼ����Ϣ
	 * @param gas
	 * @return
	 */
	public List<Gas> list(Gas gas);

	
	/**
	 * ����id��ȡȼ����Ϣ
	 * @param gas1
	 * @return
	 */
	public Gas getGasById(Gas gas1);
}
