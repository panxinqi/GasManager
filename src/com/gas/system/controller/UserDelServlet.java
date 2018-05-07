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
 
@WebServlet("/system/userDel")
public class UserDelServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�û���Ϣ
		User userinfo = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//ҵ���߼��ӿ�
		IUserService us = new UserServiceImpl();
		
		//����ID�����û���Ϣ
		User user = us.getUser(userinfo);
		
		// �����޸ķ���
		boolean mark = us.delUser(user);
		
		if(mark){
			request.setAttribute("info", "�û���Ϣɾ���ɹ���");
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}else{
			//�洢��ʾ��Ϣ���ص�����user_add.jsp����
			request.setAttribute("user", userinfo);
			
			//�洢ʧ�ܵ���Ϣ���ص�user_add.jsp�����ж�Ӧ�ı���
			request.setAttribute("info", "�û���Ϣɾ��ʧ�ܣ�");
			
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}
	}

}
