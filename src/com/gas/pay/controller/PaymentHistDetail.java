package com.gas.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gas.amount.service.IAmountService;
import com.gas.amount.service.impl.AmountServiceImpl;
import com.gas.entity.Amount;
import com.gas.entity.Gas;
import com.gas.entity.Payment;
import com.gas.entity.User;
import com.gas.pay.service.IPaymentService;
import com.gas.pay.service.impl.PaymentServiceImpl;
import com.gas.system.service.IGasService;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.GasServiceImpl;
import com.gas.system.service.impl.UserServiceImpl;
import com.gas.utils.CostUtils;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/pay/paymentHistDetail")
public class PaymentHistDetail extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//��ȡamount��Ϣ
		Payment pay = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		
		//��ȡҵ���
		IUserService us =  new UserServiceImpl();
		IAmountService as = new AmountServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		
		//����payId��ȡpayment��Ϣ  ��ȡ���ѵ���Ϣ
		Payment payment = ps.getPaymentByPayId(pay);
		//����Amount����
		payment.setAmount(as.getAmountById(new Amount(payment.getAmountId())));
		payment.setUser(us.getUser(new User((as.getAmountById(new Amount(payment.getAmountId())).getUserId()))));
		
		request.setAttribute("payment", payment);
		
		request.getRequestDispatcher("/view/pay/payment_histDetail.jsp").forward(request, response);
	}

}
