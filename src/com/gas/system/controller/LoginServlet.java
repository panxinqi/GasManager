package com.gas.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gas.entity.Menu;
import com.gas.entity.User;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.UserServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

 
@WebServlet("/system/login")
public class LoginServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取账号密码信息
		User user = RequestBeanUtils.requestToSimpleBean(request,User.class);
		//System.out.println(user);
		
		//业务逻辑接口
		IUserService us = new UserServiceImpl();
		User userinfo = us.isLogin(user);
		//System.out.println(userinfo);
		
		if(userinfo!=null){
			
			//把登录用户的信息放入session中
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userinfo);
			
			if("普通用户".equals(userinfo.getRole())){
				request.setAttribute("mlist", normal());
			}
			if("抄表管理员".equals(userinfo.getRole())){
				request.setAttribute("mlist", manager());
			}
			if("超级管理员".equals(userinfo.getRole())){
				request.setAttribute("mlist", getData());
			}
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("logininfo", "账号或者密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * 所有菜单 模拟数据库的数据
	 * @return
	 */
	public List<Menu> getData(){
		
		List<Menu> list = new ArrayList<Menu>();
		
		//根目录
		list.add(new Menu(1,"系统管理","",0));
		list.add(new Menu(2,"费用管理","",0));
		list.add(new Menu(3,"抄表管理","",0));
		
		//系统管理
		list.add(new Menu(4,"用户管理","system/userList",1));
		//list.add(new Menu(5,"费用管理","",1));
		list.add(new Menu(6,"个人信息","system/userView",1));
		
		//费用管理
		list.add(new Menu( 7,"缴费查询","pay/paymentList",2));
		list.add(new Menu( 8,"历史账单","pay/paymentHist",2));
		
		//抄表管理
		list.add(new Menu(9,"录入计量","amount/amountAdd",3));
		list.add(new Menu(10,"抄表查询","amount/amountList",3));
		list.add(new Menu(11,"交费单查询","amount/amountPaymentList",3));
		
		return list;
	}
	
	/**
	 * 获取每不同用户权限菜单的方法
	 * @return
	 */
	public List<Menu> getList(int[] arr){
		
		List<Menu> list = getData();
		List<Menu> newList = new ArrayList<>();
		
		for(int i = 0;i<list.size();i++){
			for(int j=0;j<arr.length;j++){
				//使用ID匹配
				if(list.get(i).getmId().equals(arr[j])){
					newList.add(list.get(i));
				}
			}
		}
		return newList;
	}
	
	/**
	 * 普通用户的权限
	 * @return
	 */
	public List<Menu>  normal(){
		int[] arr = {1,5,6,2,7,8};
		return getList(arr);
	}
	
	/**
	 * 抄表管理员的权限
	 * @return
	 */
	public List<Menu> manager(){
		int[] arr = {1,5,6,2,7,8,3,9,10,11};
		return getList(arr);
	}

}
