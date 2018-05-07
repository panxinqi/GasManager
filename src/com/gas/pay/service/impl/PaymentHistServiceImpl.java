package com.gas.pay.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gas.entity.UserPayment;
import com.gas.pay.dao.IPaymentHistDAO;
import com.gas.pay.dao.impl.PaymentHistDAOImpl;
import com.gas.pay.service.IPaymentHistService;

public class PaymentHistServiceImpl implements IPaymentHistService {

	IPaymentHistDAO dao = new PaymentHistDAOImpl();
	
	@Override
	public List<UserPayment> list(UserPayment userPayment) {
		try {
			StringBuffer sql = new StringBuffer("select * from user_payment where userId = ?");
			
			List<Object> list = new ArrayList<Object>();
			list.add(userPayment.getUserId());
		
			return dao.list(sql.toString(), list.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserPayment> GetListByUserId(UserPayment userPayment) {
		try {
			StringBuffer sql = new StringBuffer("select a.* from user_payment a,user b,payment c where a.userId = b.userId and a.payId = c.payId and userId = ? and paymark=?");
			
			List<Object> list = new ArrayList<Object>();
			list.add(userPayment.getUserId());
			
			return dao.list(sql.toString(), list.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
