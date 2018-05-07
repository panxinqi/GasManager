package com.gas.system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gas.entity.User;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.UserServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/userList")
public class UserListServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户信息
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//业务逻辑接口
		IUserService us = new UserServiceImpl();
		
		//查询用户信息
		List<User> list = us.list(user);
		
		//返回信息到页面
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/system/userinfo/userinfo_list.jsp").forward(request, response);
		
		
	}
}
