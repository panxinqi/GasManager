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
		
		//��ʼ������������  
		
		//��ȡ��Ȼ��������Ϣ
		IGasService cs = new GasServiceImpl();
		List<Gas> list = cs.list(null);
		
		request.setAttribute("gasList", list);
		
		request.getRequestDispatcher("/view/amount/amount_add.jsp").forward(request, response);
	}

 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ������Ϣ
		Amount amount = RequestBeanUtils.requestToSimpleBean(request, Amount.class);
		//��ȡ�û���Ϣ
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		//��ȡ��Ȼ����Ϣ
		Gas gas = RequestBeanUtils.requestToSimpleBean(request, Gas.class);
		
		//ҵ���߼��ӿ�
		IAmountService am = new AmountServiceImpl();
		IUserService us = new UserServiceImpl();
		IGasService gs = new GasServiceImpl();
		
		
		User findedUser = us.getUserByName(user);
		
		boolean boo = false;
		
		if(findedUser!=null){
			//�����û����
			amount.setUserId(findedUser.getUserId());
			amount.setGasId(1);
			boo = am.add(amount);
		}
		
		if(boo){
			//request.setAttribute("addUser", User);
			request.getRequestDispatcher("/amount/amountList").forward(request, response);
		}else{
			
			//�洢ʧ�ܵ���Ϣ���ص�user_add.jsp�����ж�Ӧ�ı���
			request.setAttribute("amountInfo", "�û���Ϣ���ʧ�ܣ�");
			request.getRequestDispatcher("/view/amount/amount_add.jsp").forward(request, response);
		}	
	}
}
