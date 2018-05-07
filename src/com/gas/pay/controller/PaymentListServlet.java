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
import com.gas.pay.service.IPaymentService;
import com.gas.pay.service.impl.PaymentServiceImpl;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.UserServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/pay/paymentList")
public class PaymentListServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ�û���Ϣ
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//ҵ���߼��ӿ�
		IUserService is = new UserServiceImpl();
		IAmountService as = new AmountServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		
		
		//��ȡ��ǰ��¼�û���Ϣ
		HttpSession session = request.getSession();
		User userSession = (User)session.getAttribute("userinfo");
		
		List<Payment> list = ps.payList(null, userSession);
		
		if(list!=null && list.size()>0){
			for(Payment each:list){
				//��ȡ�·�
				if(each.getAmountId()!=null && !"".equals(each.getAmountId())){
					each.setAmount(as.getAmountById(new Amount(each.getAmountId())));
					//��ȡ�û���
					each.setUser(is.getUser(new User(each.getAmount().getUserId())));
				}
			}
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/pay/payment_list.jsp").forward(request, response);
		
		
	}
}
