package com.gas.amount.service.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gas.amount.dao.IAmountDAO;
import com.gas.amount.dao.impl.AmountDAOImpl;
import com.gas.amount.service.IAmountService;
import com.gas.entity.Amount;
import com.gas.entity.Payment;
import com.gas.utils.CostUtils;
import com.gas.utils.JDBCUtils;

public class AmountServiceImpl implements IAmountService {
	
	IAmountDAO dao = new AmountDAOImpl();
	
	@Override
	public boolean add(Amount amount) {
		Connection conn = null;
		try {
			//获取数据库连接
			conn = JDBCUtils.getConnection();
			//关闭自动提交事务   默认是自动提交事务的  所以要关闭采用手动提交事务
			conn.setAutoCommit(false);
			
			String sql1 = "insert into amount(userId,gasId,amount,month,enterUserName) values(?,?,?,?,?)";
			QueryRunner qr = new QueryRunner();
			qr.update(conn, sql1,amount.getUserId(),1,amount.getAmount(),amount.getMonth(),amount.getEnterUserName());
			
			//获取amount自增长的主键值  amountId
			BigInteger amountId = (BigInteger)qr.query(conn,"select last_insert_id()",new ScalarHandler<>(1));
			
			
			String sql2 = "insert into user_amount(userId,amountId) values(?,?)";
			QueryRunner qr2 = new QueryRunner();
			qr2.update(conn,sql2,amount.getUserId(),amountId);
			
			
			//获取用量表中的price和amount计算缴费表中的payMoney的数值
			Double price = (Double)qr.query(
					conn,
					"SELECT gasPrice from gas where gasId=1",
					new ScalarHandler<>(1));
			Double count = (Double)qr.query(
					conn,
					"SELECT amount from amount where amountId="+amountId,
					new ScalarHandler<>(1));
			String sql3 = "insert into payment(amountId,payMoney,payDate,payMark) values(?,?,?,?)";
			QueryRunner qr3 = new QueryRunner();
			qr3.update(conn, sql3,amountId,price*count,null,CostUtils.PAY_MARK_AUTO);
			
			//提交事务
			conn.commit();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//失败回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally{
				try {
					//关闭数据库连接
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public List<Amount> list(Amount amount) {
		try {
			//只查询没有生成交费单的 就是payMark=-1的
			String sql = "select amount.* from amount,payment where amount.amountId = payment.amountId and payment.payMark=?";
			List<Object> list = new ArrayList<Object>();
			list.add(CostUtils.PAY_MARK_AUTO);
			return dao.list(sql.toString(), list.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Amount getAmountById(Amount amount) {
		// TODO Auto-generated method stub
		try {
			String sql ="select * from amount where amountId = ?";
			List<Object> list = new ArrayList<Object>();
			list.add(amount.getAmountId());
			
			return dao.getAmountById(sql, list.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean toPayment(Payment payment) {

		try {
			StringBuffer sql = new StringBuffer("update payment set payMark=? where payId=?");
			List<Object> list = new ArrayList<Object>();
			
			list.add(CostUtils.PAY_MARK_NO);
			list.add(payment.getPayId());
		
			return JDBCUtils.audObject(sql.toString(), list.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
