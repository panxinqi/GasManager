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
		//获取用户信息
		User userinfo = RequestBeanUtils.requestToSimpleBean(request, User.class);
		
		//业务逻辑接口
		IUserService us = new UserServiceImpl();
		
		//注意修改部分信息时：要先查询出来信息   保存没有修改的信息  设置会被修改的信息
		//查询出要修改的用户信息
		User user = us.getUser(userinfo);
		//设置要修改的信息
		user.setUserName(userinfo.getUserName());
		user.setAddress(userinfo.getAddress());
		user.setPhone(userinfo.getPhone());
		user.setUserPwd(userinfo.getUserPwd());
		
		// 调用修改方法
		boolean mark = us.updateUser(user);
		
		if(mark){
			
			HttpSession session = request.getSession();
			session.setAttribute("userinfo",user);
			
			request.setAttribute("myinfo", "修改个人信息成功！");
		}else{
			//存储提示信息返回到界面user_add.jsp界面
			request.setAttribute("myinfo", "修改个人信息失败！");
		}
		request.getRequestDispatcher("/view/system/userinfo/userinfo_view.jsp").forward(request, response);

	}

}
