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
		//获取用户信息
		User User = RequestBeanUtils.requestToSimpleBean(request,User.class);

		IUserService us = new UserServiceImpl();
		
		User user = us.getUser(User);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/view/system/userinfo/userinfo_update.jsp").forward(request, response);
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取用户信息
		User user = RequestBeanUtils.requestToSimpleBean(request, User.class);
		//System.out.println("user = "+user);
		//业务逻辑接口
		IUserService us = new UserServiceImpl();
		
		// 调用修改方法
		boolean boo = us.updateUser(user);
		
		if(boo){
			request.setAttribute("info", "用户信息修改成功！");
			request.getRequestDispatcher("/system/userList").forward(request, response);
			
		}else{
			//存储提示信息返回到界面user_add.jsp界面
			request.setAttribute("user", user);
			
			//存储失败的信息返回到user_add.jsp界面中对应的表单中
			request.setAttribute("info", "用户信息修改失败！");
			
			request.getRequestDispatcher("/view/system/userinfo/userinfo_update.jsp").forward(request, response);
			
		}
	}

}
