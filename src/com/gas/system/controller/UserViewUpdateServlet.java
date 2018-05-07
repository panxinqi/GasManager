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

@WebServlet("/system/userViewUpdate")
public class UserViewUpdateServlet extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�û���Ϣ
		User userinfo = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//ҵ���߼��ӿ�
		IUserService us = new UserServiceImpl();
		
		//ע���޸Ĳ�����Ϣʱ��Ҫ�Ȳ�ѯ������Ϣ   ����û���޸ĵ���Ϣ  ���ûᱻ�޸ĵ���Ϣ
		//��ѯ��Ҫ�޸ĵ��û���Ϣ
		User user = us.getUser(userinfo);
		//����Ҫ�޸ĵ���Ϣ
		user.setUserName(userinfo.getUserName());
		user.setAddress(userinfo.getAddress());
		user.setPhone(userinfo.getPhone());
		user.setUserPwd(userinfo.getUserPwd());
		
		// �����޸ķ���
		boolean mark = us.updateUser(user);
		
		if(mark){
			
			HttpSession session = request.getSession();
			session.setAttribute("userinfo",user);
			
			request.setAttribute("myinfo", "�޸ĸ�����Ϣ�ɹ���");
		}else{
			//�洢��ʾ��Ϣ���ص�����user_add.jsp����
			request.setAttribute("myinfo", "�޸ĸ�����Ϣʧ�ܣ�");
		}
		request.getRequestDispatcher("/view/system/userinfo/userinfo_view.jsp").forward(request, response);

	}

}
