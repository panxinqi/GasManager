package com.gas.amount.controler;

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

@WebServlet("/amount/amountToPayment")
public class Amount2PaymentServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//��ȡamount��Ϣ
		Amount amount = RequestBeanUtils.requestToSimpleBean(request, Amount.class);
		Payment pay = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		
		IUserService us =  new UserServiceImpl();
		IAmountService as = new AmountServiceImpl();
		IGasService gs = new GasServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		
		Amount am  = as.getAmountById(amount);
		
		User user = new User();
		if(am!=null && am.getUserId()!=null){
			User user1 = new User();
			user1.setUserId(am.getUserId());
			user1.setUserMark(CostUtils.MARK_YES);
			user = us.getUser(user1);
			//System.out.println(user);
		}
		
		Gas gas = new Gas();
		if(am!=null && am.getGasId()!=null){
			Gas gas1 = new Gas();
			gas1.setGasId(am.getGasId());
			gas = gs.getGasById(gas1);
		}
		
		Payment payment = ps.getPaymentById(pay);
		
		request.setAttribute("amount", am);
		request.setAttribute("user", user);
		request.setAttribute("gs", gas);
		request.setAttribute("payment", payment);
		
		boolean boo = false;
			try {
				boo = ps.audit(pay);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		request.getRequestDispatcher("/view/amount/amount_payment.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ������Ϣ
		Amount amount = RequestBeanUtils.requestToSimpleBean(request, Amount.class);
		//��ȡ�û���Ϣ
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		//��ȡ��Ȼ����Ϣ
		Gas gas = RequestBeanUtils.requestToSimpleBean(request, Gas.class);
		//��ȡ�ɷѵ���Ϣ
		Payment	payment = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		
		//ҵ���߼��ӿ�
		IAmountService as = new AmountServiceImpl();
		IUserService us = new UserServiceImpl();
		IGasService gs = new GasServiceImpl();
		IPaymentService ps = new PaymentServiceImpl();
		
		boolean flag = as.toPayment(payment);
		
		if(flag){
			//request.setAttribute("addUser", User);
			request.getRequestDispatcher("/amount/amountPaymentList").forward(request, response);
		}else{
			request.setAttribute("topaymentInfo", "���ɽɷѵ�ʧ�ܣ�");
			request.getRequestDispatcher("/view/amount/amount_list.jsp").forward(request, response);
		}	
	}
}
