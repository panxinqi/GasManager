package com.gas.pay.test;

import com.gas.entity.Payment;
import com.gas.pay.service.IPaymentService;
import com.gas.pay.service.impl.PaymentServiceImpl;

public class paymentUpdateTets {
	public static void main(String[] args) {
		
		IPaymentService pay = new PaymentServiceImpl();
		
		Payment payment = new Payment();
		
		payment.setPayId(1);
		
		try {
			
			//≤‚ ‘≥…π¶
			boolean boo = pay.audit(payment);
			System.out.println(boo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
