package com.gas.system.test;

import java.util.List;

import com.gas.entity.Gas;
import com.gas.system.service.IGasService;
import com.gas.system.service.impl.GasServiceImpl;

public class gastest {
	public static void main(String[] args) {
		IGasService se = new GasServiceImpl();
		List<Gas> list = se.list(new Gas());
		System.out.println(list);
	}
}
