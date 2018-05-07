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
import com.gas.entity.Gas;
import com.gas.entity.User;
import com.gas.system.service.IGasService;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.GasServiceImpl;
import com.gas.system.service.impl.UserServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/amount/amountAdd")
public class AmountAddServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//初始化报销单界面  
		
		//获取天然气类型信息
		IGasService cs = new GasServiceImpl();
		List<Gas> list = cs.list(null);
		
		request.setAttribute("gasList", list);
		
		request.getRequestDispatcher("/view/amount/amount_add.jsp").forward(request, response);
	}

 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取超表信息
		Amount amount = RequestBeanUtils.requestToSimpleBean(request, Amount.class);
		//获取用户信息
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		//获取天然气信息
		Gas gas = RequestBeanUtils.requestToSimpleBean(request, Gas.class);
		
		//业务逻辑接口
		IAmountService am = new AmountServiceImpl();
		IUserService us = new UserServiceImpl();
		IGasService gs = new GasServiceImpl();
		
		
		User findedUser = us.getUserByName(user);
		
		boolean boo = false;
		
		if(findedUser!=null){
			//设置用户编号
			amount.setUserId(findedUser.getUserId());
			amount.setGasId(1);
			boo = am.add(amount);
		}
		
		if(boo){
			//request.setAttribute("addUser", User);
			request.getRequestDispatcher("/amount/amountList").forward(request, response);
		}else{
			
			//存储失败的信息返回到user_add.jsp界面中对应的表单中
			request.setAttribute("amountInfo", "用户信息添加失败！");
			request.getRequestDispatcher("/view/amount/amount_add.jsp").forward(request, response);
		}	
	}
}
