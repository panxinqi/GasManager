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
		//获取用户信息
		User userinfo = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//业务逻辑接口
		IUserService us = new UserServiceImpl();
		
		//根据ID查找用户信息
		User user = us.getUser(userinfo);
		
		// 调用修改方法
		boolean mark = us.delUser(user);
		
		if(mark){
			request.setAttribute("info", "用户信息删除成功！");
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}else{
			//存储提示信息返回到界面user_add.jsp界面
			request.setAttribute("user", userinfo);
			
			//存储失败的信息返回到user_add.jsp界面中对应的表单中
			request.setAttribute("info", "用户信息删除失败！");
			
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}
	}

}
