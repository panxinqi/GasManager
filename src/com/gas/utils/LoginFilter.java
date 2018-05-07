package com.gas.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gas.entity.User;


/**
 * ��ֹ�Ƿ������Ĺ�����
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
 
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//��ȡHttpServletRequest
		HttpServletRequest request  = (HttpServletRequest)req;
		//���󲿷�·��
		String uri = request.getRequestURI();
		 //System.out.println(uri);
		//��ȡ��ǰ��¼�û�
		HttpSession session = request.getSession();
		User userinfo = (User)session.getAttribute("userinfo");
		
		
		if(uri.contains("/login")){
			chain.doFilter(request, response);
		}else if(uri.contains("/resources")){
			chain.doFilter(request, response);
		}else if(userinfo!=null){
			chain.doFilter(request, response);
		}else{
			//��ת��¼ҳ��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}		
	}
	
	public LoginFilter() {
        // TODO Auto-generated constructor stub
    }
	 
	public void destroy() {
		// TODO Auto-generated method stub
	}
	 
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
