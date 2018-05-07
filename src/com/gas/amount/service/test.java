package com.gas.amount.service;

import com.gas.amount.service.impl.AmountServiceImpl;
import com.gas.entity.Amount;

public class test {
	public static void main(String[] args) {
		
		AmountServiceImpl am = new AmountServiceImpl();
		
		Amount amount = new Amount();
		
		amount.setAmount(11);
		amount.setEnterUserName("≤‚ ‘1");
		amount.setPrice(11);
		amount.setUserId(1);
		amount.setMonth("2012-12");
		
		am.add(amount);
		
		
	}
}
