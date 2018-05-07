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
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/pay/paymentPayMoney")
public class PaymentPayMoneyServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�ɷѵ���Ϣ
		Payment	payment1 = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		//��ȡ�û���Ϣ
		//User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//ҵ���߼��ӿ�
		IAmountService as = new AmountServiceImpl();
		IUserService us = new UserServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		//��ȡ�ɷѵ���Ϣ
		Payment payment = ps.getPaymentByPayId(payment1);
		
		//Integer userId = as.getAmountById(new Amount(payment.getAmountId())).getUserId();
		
		payment.setUser(us.getUser(new User(as.getAmountById(new Amount(payment.getAmountId())).getUserId())));
		payment.setAmount(as.getAmountById(new Amount(payment.getAmountId())));
		
		//����ѯ���������session��
		request.setAttribute("payment", payment);
		//����ת��
		request.getRequestDispatcher("/view/pay/payment_payMoney.jsp").forward(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ������Ϣ
		Amount amount = RequestBeanUtils.requestToSimpleBean(request, Amount.class);
		//��ȡ�û���Ϣ
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		//��ȡ��Ȼ����Ϣ
		Gas gas = RequestBeanUtils.requestToSimpleBean(request, Gas.class);
		//��ȡ�ɷѵ���Ϣ
		Payment	payment1 = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		
		//ҵ���߼��ӿ�
		IAmountService as = new AmountServiceImpl();
		IUserService us = new UserServiceImpl();
		IGasService gs = new GasServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		
		Payment payment = ps.getPaymentByPayId(payment1);
		
		payment.setUser(us.getUser(new User(as.getAmountById(new Amount(payment.getAmountId())).getUserId())));
		payment.setAmount(as.getAmountById(new Amount(payment.getAmountId())));
		
		boolean boo = ps.payMoney(payment);
		
		if(boo){
			request.setAttribute("payinfo", "�ɷѳɹ���");
			request.getRequestDispatcher("/pay/paymentList").forward(request, response);
		}else{
			request.setAttribute("payinfo", "���㣡�뼰ʱ��ֵ��");
			request.getRequestDispatcher("/view/pay/payment_payMoney.jsp").forward(request, response);
		}
		
	}
}
