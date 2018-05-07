package com.gas.pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gas.amount.service.IAmountService;
import com.gas.amount.service.impl.AmountServiceImpl;
import com.gas.entity.Amount;
import com.gas.entity.Payment;
import com.gas.entity.User;
import com.gas.entity.UserAmount;
import com.gas.entity.UserPayment;
import com.gas.pay.service.IPaymentHistService;
import com.gas.pay.service.IPaymentService;
import com.gas.pay.service.impl.PaymentHistServiceImpl;
import com.gas.pay.service.impl.PaymentServiceImpl;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.UserServiceImpl;

@WebServlet("/pay/paymentHist")
public class PaymentHistServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取当前登录用户信息
		HttpSession session = request.getSession();
		User userSession = (User)session.getAttribute("userinfo");
		
		//业务逻辑接口
		IUserService is = new UserServiceImpl();
		IAmountService as = new AmountServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		IPaymentHistService phs = new PaymentHistServiceImpl();
		
		//根据userid构建userPayment对象
		UserPayment upayment = new UserPayment(userSession.getUserId());
		
		//获取用户缴费记录单信息
		List<UserPayment> phlist = phs.list(upayment);
		
		if(phlist!=null && phlist.size()>0){
			for(UserPayment each:phlist){
				each.setUser(is.getUser(new User(each.getUserId())));
				//System.out.println("User="+is.getUser(new User(each.getUserId())));
				each.setPayment(ps.getPaymentByPayId(new Payment(each.getPayId())));
				each.setAmount(as.getAmountById(new Amount(each.getPayment().getAmountId())));
				//System.out.println("amount="+as.getAmountById(new Amount(each.getPayment().getAmountId())));
			}
		}
		
		request.setAttribute("list", phlist);
		
		request.getRequestDispatcher("/view/pay/payment_history.jsp").forward(request, response);
	}
}
