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
		
		//获取用户信息
		User User = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//业务逻辑接口
		IUserService us = new UserServiceImpl();
		
		boolean mark = us.add(User);
		
		if(mark){
			
			//request.setAttribute("addUser", User);
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}else{
			//存储提示信息返回到界面user_add.jsp界面
			request.setAttribute("user", User);
			
			//存储失败的信息返回到user_add.jsp界面中对应的表单中
			request.setAttribute("info", "用户信息添加失败！");
			
			request.getRequestDispatcher("/view/system/User/UserInfo_add.jsp").forward(request, response);
			
		}	
	}
}
