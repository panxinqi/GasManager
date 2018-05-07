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
 
@WebServlet("/system/userView")
public class UserViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//从session中获取用户信息
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userinfo");
		
		//业务逻辑接口  更新用户数据
		IUserService us = new UserServiceImpl();
		user = us.getUser(user);
		request.setAttribute("userinfo", user);
		
		request.getRequestDispatcher("/view/system/userinfo/userinfo_view.jsp").forward(request, response);
		
	}


}
