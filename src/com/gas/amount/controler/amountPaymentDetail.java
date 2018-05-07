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

@WebServlet("/amount/amountPaymentDetail")
public class amountPaymentDetail extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//获取amount信息
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
		
		request.getRequestDispatcher("/view/amount/amount_paymentDetail.jsp").forward(request, response);
	}

}
