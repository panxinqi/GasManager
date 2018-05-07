package com.gas.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gas.entity.Gas;
import com.gas.system.dao.IGasDAO;
import com.gas.system.dao.impl.GasDAOImpl;
import com.gas.system.service.IGasService;

public class GasServiceImpl implements IGasService {
	
	IGasDAO dao = new GasDAOImpl();
	
	@Override
	public List<Gas> list(Gas gas) {
		// TODO Auto-generated method stub
		try{
			StringBuffer sql = new StringBuffer("select * from gas");
			
			List<Object> list = new ArrayList<>();
			
			return dao.list(sql.toString(), list.toArray());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Gas getGasById(Gas gas1){
		try {
			String sql = "select * from gas where gasId=?";
			
			List<Object> list = new ArrayList<Object>();
			list.add(gas1.getGasId());
			
			
			return dao.getGas(sql, list.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


}
