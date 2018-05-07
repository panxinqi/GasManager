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
		//获取缴费单信息
		Payment	payment1 = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		//获取用户信息
		//User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//业务逻辑接口
		IAmountService as = new AmountServiceImpl();
		IUserService us = new UserServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		//获取缴费单信息
		Payment payment = ps.getPaymentByPayId(payment1);
		
		//Integer userId = as.getAmountById(new Amount(payment.getAmountId())).getUserId();
		
		payment.setUser(us.getUser(new User(as.getAmountById(new Amount(payment.getAmountId())).getUserId())));
		payment.setAmount(as.getAmountById(new Amount(payment.getAmountId())));
		
		//将查询结果保存在session中
		request.setAttribute("payment", payment);
		//请求转发
		request.getRequestDispatcher("/view/pay/payment_payMoney.jsp").forward(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取超表信息
		Amount amount = RequestBeanUtils.requestToSimpleBean(request, Amount.class);
		//获取用户信息
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		//获取天然气信息
		Gas gas = RequestBeanUtils.requestToSimpleBean(request, Gas.class);
		//获取缴费单信息
		Payment	payment1 = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		
		//业务逻辑接口
		IAmountService as = new AmountServiceImpl();
		IUserService us = new UserServiceImpl();
		IGasService gs = new GasServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		
		Payment payment = ps.getPaymentByPayId(payment1);
		
		payment.setUser(us.getUser(new User(as.getAmountById(new Amount(payment.getAmountId())).getUserId())));
		payment.setAmount(as.getAmountById(new Amount(payment.getAmountId())));
		
		boolean boo = ps.payMoney(payment);
		
		if(boo){
			request.setAttribute("payinfo", "缴费成功！");
			request.getRequestDispatcher("/pay/paymentList").forward(request, response);
		}else{
			request.setAttribute("payinfo", "余额不足！请及时充值！");
			request.getRequestDispatcher("/view/pay/payment_payMoney.jsp").forward(request, response);
		}
		
	}
}
