package com.gas.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gas.entity.User;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.UserServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class UsrInfoServiceServlet
 */
@WebServlet("/system/userAdd")
public class UserAddServlet extends HttpServlet {
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ�û���Ϣ
		User User = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//ҵ���߼��ӿ�
		IUserService us = new UserServiceImpl();
		
		boolean mark = us.add(User);
		
		if(mark){
			
			//request.setAttribute("addUser", User);
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}else{
			//�洢��ʾ��Ϣ���ص�����user_add.jsp����
			request.setAttribute("user", User);
			
			//�洢ʧ�ܵ���Ϣ���ص�user_add.jsp�����ж�Ӧ�ı���
			request.setAttribute("info", "�û���Ϣ���ʧ�ܣ�");
			
			request.getRequestDispatcher("/view/system/User/UserInfo_add.jsp").forward(request, response);
			
		}	
	}
}
