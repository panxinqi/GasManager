package com.gas.system.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gas.entity.User;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.UserServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�û���Ϣ
		User User = RequestBeanUtils.requestToSimpleBean(request,User.class);

		IUserService us = new UserServiceImpl();
		
		User user = us.getUser(User);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/view/system/userinfo/userinfo_update.jsp").forward(request, response);
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�û���Ϣ
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		//System.out.println("user = "+user);
		//ҵ���߼��ӿ�
		IUserService us = new UserServiceImpl();
		
		// �����޸ķ���
		boolean boo = us.updateUser(user);
		
		if(boo){
			request.setAttribute("info", "�û���Ϣ�޸ĳɹ���");
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}else{
			//�洢��ʾ��Ϣ���ص�����user_add.jsp����
			request.setAttribute("user", user);
			
			//�洢ʧ�ܵ���Ϣ���ص�user_add.jsp�����ж�Ӧ�ı���
			request.setAttribute("info", "�û���Ϣ�޸�ʧ�ܣ�");
			
			request.getRequestDispatcher("/view/system/userinfo/userinfo_update.jsp").forward(request, response);
			
		}
	}

}
