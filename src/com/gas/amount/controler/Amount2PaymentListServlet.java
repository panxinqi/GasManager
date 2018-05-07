package com.gas.amount.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@WebServlet("/amount/amountPaymentList")
public class Amount2PaymentListServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取超表信息
		Amount amount = RequestBeanUtils.requestToSimpleBean(request, Amount.class);
		Payment payment = RequestBeanUtils.requestToSimpleBean(request, Payment.class);
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//业务逻辑接口
		IPaymentService ps = new PaymentServiceImpl();
		IAmountService as = new AmountServiceImpl();
		IUserService is = new UserServiceImpl();
		
		List<Payment> list = ps.list(payment,user);
		
		if(list!=null && list.size()>0){
			for(Payment each:list){
				//获取月份
				if(each.getAmountId()!=null && !"".equals(each.getAmountId())){
					each.setAmount(as.getAmountById(new Amount(each.getAmountId())));
					//获取用户名
					each.setUser(is.getUser(new User(each.getAmount().getUserId())));
				}
			}
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/amount/amount_paymentList.jsp").forward(request, response);
	}
}
