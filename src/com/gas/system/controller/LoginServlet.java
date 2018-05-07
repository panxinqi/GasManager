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

		//��ȡ�˺�������Ϣ
		User user = RequestBeanUtils.requestToSimpleBean(request,User.class);
		//System.out.println(user);
		
		//ҵ���߼��ӿ�
		IUserService us = new UserServiceImpl();
		User userinfo = us.isLogin(user);
		//System.out.println(userinfo);
		
		if(userinfo!=null){
			
			//�ѵ�¼�û�����Ϣ����session��
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userinfo);
			
			if("��ͨ�û�".equals(userinfo.getRole())){
				request.setAttribute("mlist", normal());
			}
			if("�������Ա".equals(userinfo.getRole())){
				request.setAttribute("mlist", manager());
			}
			if("��������Ա".equals(userinfo.getRole())){
				request.setAttribute("mlist", getData());
			}
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("logininfo", "�˺Ż����������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * ���в˵� ģ�����ݿ������
	 * @return
	 */
	public List<Menu> getData(){
		
		List<Menu> list = new ArrayList<Menu>();
		
		//��Ŀ¼
		list.add(new Menu(1,"ϵͳ����","",0));
		list.add(new Menu(2,"���ù���","",0));
		list.add(new Menu(3,"�������","",0));
		
		//ϵͳ����
		list.add(new Menu(4,"�û�����","system/userList",1));
		//list.add(new Menu(5,"���ù���","",1));
		list.add(new Menu(6,"������Ϣ","system/userView",1));
		
		//���ù���
		list.add(new Menu( 7,"�ɷѲ�ѯ","pay/paymentList",2));
		list.add(new Menu( 8,"��ʷ�˵�","pay/paymentHist",2));
		
		//�������
		list.add(new Menu(9,"¼�����","amount/amountAdd",3));
		list.add(new Menu(10,"�����ѯ","amount/amountList",3));
		list.add(new Menu(11,"���ѵ���ѯ","amount/amountPaymentList",3));
		
		return list;
	}
	
	/**
	 * ��ȡÿ��ͬ�û�Ȩ�޲˵��ķ���
	 * @return
	 */
	public List<Menu> getList(int[] arr){
		
		List<Menu> list = getData();
		List<Menu> newList = new ArrayList<>();
		
		for(int i = 0;i<list.size();i++){
			for(int j=0;j<arr.length;j++){
				//ʹ��IDƥ��
				if(list.get(i).getmId().equals(arr[j])){
					newList.add(list.get(i));
				}
			}
		}
		return newList;
	}
	
	/**
	 * ��ͨ�û���Ȩ��
	 * @return
	 */
	public List<Menu>  normal(){
		int[] arr = {1,5,6,2,7,8};
		return getList(arr);
	}
	
	/**
	 * �������Ա��Ȩ��
	 * @return
	 */
	public List<Menu> manager(){
		int[] arr = {1,5,6,2,7,8,3,9,10,11};
		return getList(arr);
	}

}
