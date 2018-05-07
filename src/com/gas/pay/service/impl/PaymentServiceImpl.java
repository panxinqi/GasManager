package com.gas.pay.service.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gas.entity.Payment;
import com.gas.entity.User;
import com.gas.pay.dao.IPaymentDAO;
import com.gas.pay.dao.impl.PaymentDAOImpl;
import com.gas.pay.service.IPaymentService;
import com.gas.system.service.IUserService;
import com.gas.system.service.impl.UserServiceImpl;
import com.gas.utils.CostUtils;
import com.gas.utils.JDBCUtils;

public class PaymentServiceImpl implements IPaymentService {

	IPaymentDAO dao = new PaymentDAOImpl();

	@Override
	public Payment getPayment(String sql, Object[] arr){
		try {
			return dao.getPayment(sql, arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Payment payment){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean audit(Payment payment) {
		// TODO Auto-generated method stub
		try {
			StringBuffer sql = new StringBuffer("update payment set payMark=? where payId = ?");
			
			List<Object> list = new ArrayList<Object>();
			
			list.add(CostUtils.PAY_MARK_NO);
			list.add(payment.getPayId());
		
			return JDBCUtils.audObject(sql.toString(), list.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Payment getPaymentById(Payment payment){
		// TODO Auto-generated method stub
		try {
			String sql  = "select * from payment where amountId = ?";
			List<Object> list = new ArrayList<Object>();
			list.add(payment.getAmountId());
			
			Payment pay = dao.getPayment(sql, list.toArray());
			
			//�ع�����
			if(pay!=null){
				if(CostUtils.PAY_MARK_AUTO.equals(pay.getPayMark())){
					pay.setPayMark("<btn class='btn btn-default btn-sm'>���ѵ�δ����</btn>");
				}
				if(CostUtils.PAY_MARK_YES.equals(pay.getPayMark())){
					pay.setPayMark("<btn class='btn btn-info btn-sm'>�ѽ���</btn>");
				}
				if(CostUtils.PAY_MARK_NO.equals(pay.getPayMark())){
					pay.setPayMark("<btn class='btn btn-danger btn-sm'>δ����</btn>");
				}
			}
			return pay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Payment> list(Payment payment,User user) {
		try {
			StringBuffer sql  = new StringBuffer("select p.* from payment p,amount a where a.amountId = p.amountId and p.payMark != ?");
			List<Object> list = new ArrayList<Object>();
			list.add(CostUtils.PAY_MARK_AUTO);
			
			if(payment!= null && user!=null && !"".equals(user.getUserName())){
				//�����û�������ѯ
				IUserService us = new UserServiceImpl();
				User user1 = us.getUserByName(user);
				if(user1!=null){
					sql.append(" and a.userId=?");
					list.add(user1.getUserId());
				}
			}
			
			if(payment!=null && payment.getPayMark()!=null && !"".equals(payment.getPayMark())){
				System.out.println("payment"+payment);
				if(payment.getPayMark().equals("0")){
					sql.append(" and p.payMark=?");
					list.add(CostUtils.PAY_MARK_NO);
				}
				if(payment.getPayMark().equals("1")){
					sql.append(" and p.payMark=?");
					list.add(CostUtils.PAY_MARK_YES);
				}
			}
			
			List<Payment> plist = dao.list(sql.toString(), list.toArray());
			
			//�����ع�
			if(plist!=null && plist.size()>0){
				for(Payment each:plist){
					if(CostUtils.PAY_MARK_AUTO.equals(each.getPayMark())){
						each.setPayMark("<btn class='btn btn-default btn-sm'>���ѵ�δ����</btn>");
					}
					if(CostUtils.PAY_MARK_YES.equals(each.getPayMark())){
						each.setPayMark("<btn class='btn btn-info btn-sm'>�ѽ���</btn>");
					}
					if(CostUtils.PAY_MARK_NO.equals(each.getPayMark())){
						each.setPayMark("<btn class='btn btn-danger btn-sm'>δ����</btn>");
					}
				}
			}
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Payment> payList(Payment payment,User user) {
		
		try {
			StringBuffer sql  = new StringBuffer("select p.* from payment p,amount a where a.amountId = p.amountId and p.payMark = ? and a.userId=?");
			List<Object> list = new ArrayList<Object>();
			list.add(CostUtils.PAY_MARK_NO);
			list.add(user.getUserId());
			
			List<Payment> plist = dao.list(sql.toString(), list.toArray());
			
			if(plist!=null && plist.size()>0){
				for(Payment each:plist){
					if(CostUtils.PAY_MARK_AUTO.equals(each.getPayMark())){
						each.setPayMark("<btn class='btn btn-default btn-sm'>���ѵ�δ����</btn>");
					}
					if(CostUtils.PAY_MARK_YES.equals(each.getPayMark())){
						each.setPayMark("<btn class='btn btn-info btn-sm'>�ѽ���</btn>");
					}
					if(CostUtils.PAY_MARK_NO.equals(each.getPayMark())){
						each.setPayMark("<btn class='btn btn-danger btn-sm'>δ����</btn>");
					}
				}
			}
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Payment getPaymentByPayId(Payment payment) {
		try {
			String sql  = "select * from payment where payId = ?";
			List<Object> list = new ArrayList<Object>();
			list.add(payment.getPayId());
			
			Payment pay = dao.getPayment(sql, list.toArray());
			
			//�ع�����
			if(pay!=null){
				if(CostUtils.PAY_MARK_AUTO.equals(pay.getPayMark())){
					pay.setPayMark("<btn class='btn btn-default btn-sm'>���ѵ�δ����</btn>");
				}
				if(CostUtils.PAY_MARK_YES.equals(pay.getPayMark())){
					pay.setPayMark("<btn class='btn btn-info btn-sm'>�ѽ���</btn>");
				}
				if(CostUtils.PAY_MARK_NO.equals(pay.getPayMark())){
					pay.setPayMark("<btn class='btn btn-danger btn-sm'>δ����</btn>");
				}
			}
			return pay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean payMoney(Payment payment) {
		Connection conn = null;
		try {
			//��ȡ���ݿ�����
			conn = JDBCUtils.getConnection();
			//�ر��Զ��ύ����   Ĭ�����Զ��ύ�����  ����Ҫ�رղ����ֶ��ύ����
			conn.setAutoCommit(false);
			
			String sql1 = "update payment set payMark=?,payDate=? where payId=?";
			QueryRunner qr = new QueryRunner();
			qr.update(conn, sql1,CostUtils.PAY_MARK_YES,new Date(),payment.getPayId());
			
			String sql2 = "update user set balance=? where userId=?";
			QueryRunner qr2 = new QueryRunner();
			//����ʱ  ʹ�ò����쳣�׳��쳣��Ϣ �ع�����
			qr2.update(conn,sql2,
					 (payment.getUser().getBalance()-payment.getPayMoney())>0?(payment.getUser().getBalance()-payment.getPayMoney()):"����",
					  payment.getUser().getUserId());
			//int i = 1/0;
			
			String sql3 = "insert into user_payment(userId,payId) values(?,?)";
			QueryRunner qr3 = new QueryRunner();
			qr3.update(conn, sql3,payment.getUser().getUserId(),payment.getPayId());
			
			//�ύ����
			conn.commit();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//ʧ�ܻع�����
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally{
				try {
					//�ر����ݿ�����
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return false;
	}
	
	

}
